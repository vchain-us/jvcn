package us.vchain.jvcn;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

import static java.lang.String.format;
import static java.nio.charset.StandardCharsets.UTF_8;
import static java.time.ZoneOffset.UTC;

public class Asset {
    private static final String ALGORITHM = "SHA-256";

    private static final String UNIT = "0x0000000000000000000000000000000000000000";

    // BC

    private String hash;

    private String signer;

    private Long level;

    private Long status;

    private LocalDateTime timestamp;

    // Meta

    private String name;

    private Long size;

    private String url;

    private String publisher;

    private Long verificationCount;

    private Long publisherCount;

    private String publisherCompany;

    private String publisherWebsiteUrl;

    private String kind;

    private String contentType;

    private Map<String, Object> metadata;

    private LocalDateTime createdAt;

    public Boolean isPresent() {
        return !UNIT.equals(signer);
    }

    public String getMetaHash() {
        try {
            final String format = format(
                "%s-%d-%d-%d",
                signer,
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

    public String getSigner() {
        return signer;
    }

    public void setSigner(final String signer) {
        this.signer = signer;
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

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(final Long size) {
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(final String publisher) {
        this.publisher = publisher;
    }

    public Long getVerificationCount() {
        return verificationCount;
    }

    public void setVerificationCount(final Long verificationCount) {
        this.verificationCount = verificationCount;
    }

    public Long getPublisherCount() {
        return publisherCount;
    }

    public void setPublisherCount(final Long publisherCount) {
        this.publisherCount = publisherCount;
    }

    public String getPublisherCompany() {
        return publisherCompany;
    }

    public void setPublisherCompany(final String publisherCompany) {
        this.publisherCompany = publisherCompany;
    }

    public String getPublisherWebsiteUrl() {
        return publisherWebsiteUrl;
    }

    public void setPublisherWebsiteUrl(final String publisherWebsiteUrl) {
        this.publisherWebsiteUrl = publisherWebsiteUrl;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(final String kind) {
        this.kind = kind;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(final String contentType) {
        this.contentType = contentType;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(final Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(final LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Asset.class.getSimpleName() + "[", "]")
            .add("hash='" + hash + "'")
            .add("signer='" + signer + "'")
            .add("level=" + level)
            .add("status=" + status)
            .add("timestamp=" + timestamp)
            .add("name='" + name + "'")
            .add("size=" + size)
            .add("url='" + url + "'")
            .add("publisher='" + publisher + "'")
            .add("verificationCount=" + verificationCount)
            .add("publisherCount=" + publisherCount)
            .add("publisherCompany='" + publisherCompany + "'")
            .add("publisherWebsiteUrl='" + publisherWebsiteUrl + "'")
            .add("kind='" + kind + "'")
            .add("contentType='" + contentType + "'")
            .add("metadata=" + metadata)
            .add("createdAt=" + createdAt)
            .toString();
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
            Objects.equals(signer, asset.signer) &&
            Objects.equals(level, asset.level) &&
            Objects.equals(status, asset.status) &&
            Objects.equals(timestamp, asset.timestamp) &&
            Objects.equals(name, asset.name) &&
            Objects.equals(size, asset.size) &&
            Objects.equals(url, asset.url) &&
            Objects.equals(publisher, asset.publisher) &&
            Objects.equals(verificationCount, asset.verificationCount) &&
            Objects.equals(publisherCount, asset.publisherCount) &&
            Objects.equals(publisherCompany, asset.publisherCompany) &&
            Objects.equals(publisherWebsiteUrl, asset.publisherWebsiteUrl) &&
            Objects.equals(kind, asset.kind) &&
            Objects.equals(contentType, asset.contentType) &&
            Objects.equals(metadata, asset.metadata) &&
            Objects.equals(createdAt, asset.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hash, signer, level, status, timestamp, name, size,
            url, publisher, verificationCount, publisherCount, publisherCompany,
            publisherWebsiteUrl, kind, contentType, metadata, createdAt);
    }
}
