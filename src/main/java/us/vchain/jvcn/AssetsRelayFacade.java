package us.vchain.jvcn;

import org.web3j.protocol.Web3j;
import org.web3j.tuples.generated.Tuple4;
import org.web3j.tx.ReadonlyTransactionManager;
import org.web3j.tx.gas.StaticGasProvider;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static java.math.BigInteger.valueOf;

public class AssetsRelayFacade {
    private final AssetsRelay assetsRelay;

    private final AssetMapper assetMapper;

    public AssetsRelayFacade(final Web3j web3j,
                             final Configuration configuration,
                             final SystemConfiguration systemConfiguration) {
        final ReadonlyTransactionManager transactionManager =
            new ReadonlyTransactionManager(web3j, configuration.getPublicKey());
        final StaticGasProvider contractGasProvider =
            new StaticGasProvider(
                systemConfiguration.getGasPrice(),
                systemConfiguration.getGasLimit());
        assetMapper = new AssetMapper();
        assetsRelay = AssetsRelay.load(
            systemConfiguration.getContractAddress(),
            web3j,
            transactionManager,
            contractGasProvider);
    }

    public Asset verify(final String hash) throws Exception {
        final Tuple4<String, BigInteger, BigInteger, BigInteger> tuple =
            assetsRelay.verify(hash).send();
        return assetMapper.from(hash, tuple);
    }

    public List<Asset> listAllAssetsMatchingHash(final String hash) throws Exception {
        final List<Asset> assets = new ArrayList<>();
        final BigInteger count = assetsRelay.getAssetCountForHash(hash).send();
        for (long i = 0; i < count.longValue(); i++) {
            final Tuple4<String, BigInteger, BigInteger, BigInteger> tuple =
                assetsRelay.verifyByIndex(hash, valueOf(i)).send();
            final Asset asset = assetMapper.from(hash, tuple);
            assets.add(asset);
        }
        return assets;
    }
}
