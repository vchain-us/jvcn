package us.vchain.jvcn;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

import static java.lang.String.format;
import static java.nio.charset.StandardCharsets.UTF_8;
import static java.time.ZoneOffset.UTC;

public class Asset {
    private static final String ALGORITHM = "SHA-256";

    private static final String UNIT = "0x0000000000000000000000000000000000000000";

    private String hash;

    private String owner;

    private Long level;

    private Long status;

    private LocalDateTime timestamp;

    public Boolean isPresent() {
        return !UNIT.equals(owner);
    }

    public String getMetaHash() {
        try {
            final String format = format(
                "%s-%d-%d-%d",
                owner,
                level,
                status,
                timestamp.toEpochSecond(UTC));
            final MessageDigest messageDigest = MessageDigest.getInstance(ALGORITHM);
            messageDigest.update(format.getBytes(UTF_8));
            final byte[] digest = messageDigest.digest();
            return format("%064x", new BigInteger(1, digest));
        } catch (final NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public String getHash() {
        return hash;
    }

    public void setHash(final String hash) {
        this.hash = hash;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(final String owner) {
        this.owner = owner;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(final Long level) {
        this.level = level;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(final Long status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(final LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Asset)) {
            return false;
        }
        final Asset asset = (Asset) o;
        return Objects.equals(hash, asset.hash) &&
            Objects.equals(owner, asset.owner) &&
            Objects.equals(level, asset.level) &&
            Objects.equals(status, asset.status) &&
            Objects.equals(timestamp, asset.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hash, owner, level, status, timestamp);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Asset.class.getSimpleName() + "[", "]")
            .add("present='" + isPresent() + "'")
            .add("hash='" + hash + "'")
            .add("owner='" + owner + "'")
            .add("level=" + level)
            .add("status=" + status)
            .add("timestamp=" + timestamp)
            .toString();
    }
}
