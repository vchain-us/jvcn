package us.vchain.jvcn;

import org.web3j.protocol.Web3j;
import org.web3j.tuples.generated.Tuple4;
import org.web3j.tx.ReadonlyTransactionManager;
import org.web3j.tx.gas.StaticGasProvider;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static java.math.BigInteger.valueOf;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static us.vchain.jvcn.DigestHelper.metaHash;

class AssetsRelayFacade {
    private final AssetsRelay assetsRelay;

    private final AssetMapper assetMapper;

    private final AssetsClient assetsClient;

    AssetsRelayFacade(final Web3j web3j,
                      final Configuration configuration,
                      final SystemConfiguration systemConfiguration) {
        final ReadonlyTransactionManager transactionManager =
            new ReadonlyTransactionManager(web3j, configuration.getPublicKey());
        final StaticGasProvider contractGasProvider =
            new StaticGasProvider(
                systemConfiguration.getGasPrice(),
                systemConfiguration.getGasLimit());
        assetMapper = new AssetMapper();
        assetsClient = new AssetsClient(systemConfiguration);
        assetsRelay = AssetsRelay.load(
            systemConfiguration.getContractAddress(),
            web3j,
            transactionManager,
            contractGasProvider);
    }

    Optional<Asset> verify(final String hash) throws Exception {
        final Tuple4<String, BigInteger, BigInteger, BigInteger> tuple =
            assetsRelay.verify(hash).send();
        final Asset asset = assetMapper.from(hash, tuple);
        if (!asset.isPresent()) {
            return Optional.empty();
        }
        final String metaHash = metaHash(asset);
        assetsClient.fetchMetadata(hash, metaHash)
            .ifPresent(metadata -> assetMapper.enrich(asset, metadata));
        return Optional.of(asset);
    }

    List<Asset> listAllAssetsMatchingHash(final String hash) throws Exception {
        final List<Asset> assets = new ArrayList<>();
        final BigInteger count = assetsRelay.getAssetCountForHash(hash).send();
        for (long i = 0; i < count.longValue(); i++) {
            final Tuple4<String, BigInteger, BigInteger, BigInteger> tuple =
                assetsRelay.verifyByIndex(hash, valueOf(i)).send();
            final Asset asset = assetMapper.from(hash, tuple);
            if (!asset.isPresent()) {
                continue;
            }
            final String metaHash = metaHash(asset);
            assetsClient.fetchMetadata(hash, metaHash)
                .ifPresent(metadata -> assetMapper.enrich(asset, metadata));
            assets.add(asset);
        }
        return assets;
    }

    List<Asset> listAllAssetsMatchingHashAndSigner(final String hash,
                                                   final Set<String> signers) throws Exception {
        final Set<String> sanitisedSigners = signers.stream()
            .map(String::toLowerCase)
            .collect(toSet());
        return listAllAssetsMatchingHash(hash).stream()
            .filter(asset -> sanitisedSigners.contains(asset.getSigner().toLowerCase()))
            .collect(toList());
    }
}
