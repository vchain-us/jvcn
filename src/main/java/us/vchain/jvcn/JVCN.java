package us.vchain.jvcn;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static us.vchain.jvcn.DigestHelper.sha256Hash;

public class JVCN {
    private final AssetsRelayFacade assetsRelayFacade;

    private JVCN(final Configuration configuration,
                 final SystemConfiguration systemConfiguration,
                 final Web3j web3j) {
        assetsRelayFacade = new AssetsRelayFacade(
            web3j, configuration, systemConfiguration);
    }

    public Optional<Asset> verify(final String hash) {
        try {
            return assetsRelayFacade.verify(hash);
        } catch (final Exception e) {
            throw new JVCNException(e);
        }
    }

    public Optional<Asset> verify(final String hash,
                                  final Set<String> signers) {
        final List<Asset> assets = listAllAssetsMatchingHashAndSigner(hash, signers);
        return assets.isEmpty()
            ? Optional.empty()
            : Optional.of(assets.get(assets.size() - 1));
    }

    public Optional<Asset> verify(final File file) {
        try {
            final String hash = sha256Hash(file);
            return verify(hash);
        } catch (final Exception e) {
            throw new JVCNException(e);
        }
    }

    public Optional<Asset> verify(final File file,
                                  final Set<String> signers) {
        try {
            final String hash = sha256Hash(file);
            final List<Asset> assets = listAllAssetsMatchingHashAndSigner(hash, signers);
            return assets.isEmpty()
                ? Optional.empty()
                : Optional.of(assets.get(assets.size() - 1));
        } catch (final Exception e) {
            throw new JVCNException(e);
        }
    }

    public List<Asset> listAllAssetsMatchingHash(final String hash) {
        try {
            return assetsRelayFacade.listAllAssetsMatchingHash(hash);
        } catch (final Exception e) {
            throw new JVCNException(e);
        }
    }

    public List<Asset> listAllAssetsMatchingFile(final File file) {
        try {
            final String hash = sha256Hash(file);
            return assetsRelayFacade.listAllAssetsMatchingHash(hash);
        } catch (final Exception e) {
            throw new JVCNException(e);
        }
    }

    public List<Asset> listAllAssetsMatchingHashAndSigner(final String hash,
                                                          final Set<String> signers) {
        try {
            return assetsRelayFacade.listAllAssetsMatchingHashAndSigner(hash, signers);
        } catch (final Exception e) {
            throw new JVCNException(e);
        }
    }

    public List<Asset> listAllAssetsMatchingFileAndSigner(final File file,
                                                          final Set<String> signers) {
        try {
            final String hash = sha256Hash(file);
            return assetsRelayFacade.listAllAssetsMatchingHashAndSigner(hash, signers);
        } catch (final Exception e) {
            throw new JVCNException(e);
        }
    }

    public static class Builder {
        private Configuration configuration;

        private SystemConfiguration systemConfiguration;

        private Web3j web3j;

        public Builder() {
            configuration = new Configuration();
            systemConfiguration = new SystemConfiguration();
            web3j = Web3j.build(new HttpService(systemConfiguration.getNetwork()));
        }

        public Builder configuration(final Configuration configuration) {
            this.configuration = configuration;
            return this;
        }

        public Builder systemConfiguration(final SystemConfiguration systemConfiguration) {
            this.systemConfiguration = systemConfiguration;
            return this;
        }

        public Builder web3j(final Web3j web3j) {
            this.web3j = web3j;
            return this;
        }

        public JVCN build() {
            return new JVCN(configuration, systemConfiguration, web3j);
        }
    }
}
