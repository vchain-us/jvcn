package us.vchain.jvcn;

import java.math.BigInteger;

import static java.math.BigInteger.ZERO;
import static java.math.BigInteger.valueOf;

public class SystemConfiguration {
    public String getContractAddress() {
        return "0x495021fe1a48a5b0c85ef1abd68c42cdfc7cda08";
    }

    public String getNetwork() {
        return "https://main.vchain.us";
    }

    public String getBackend() {
        return "https://api.codenotary.io/foundation";
    }

    public String getArtifactUrl(final String hash, final String metaHash) {
        return getBackend() + "/v1/artifact/" + hash + "/" + metaHash;
    }

    public BigInteger getGasPrice() {
        return ZERO;
    }

    public BigInteger getGasLimit() {
        return valueOf(25484100L);
    }
}
