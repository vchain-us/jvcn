package us.vchain.jvcn;

import java.util.Objects;
import java.util.StringJoiner;

public class Configuration {
    private String publicKey = "0x0000000000000000000000000000000000000000";

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(final String publicKey) {
        this.publicKey = publicKey;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Configuration.class.getSimpleName() + "[", "]")
            .add("publicKey='" + publicKey + "'")
            .toString();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Configuration)) {
            return false;
        }
        final Configuration that = (Configuration) o;
        return Objects.equals(publicKey, that.publicKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(publicKey);
    }
}
