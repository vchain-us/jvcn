package us.vchain.jvcn;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

@JsonIgnoreProperties(ignoreUnknown = true)
class Metadata {
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

    String getName() {
        return name;
    }

    void setName(final String name) {
        this.name = name;
    }

    Long getSize() {
        return size;
    }

    void setSize(final Long size) {
        this.size = size;
    }

    String getUrl() {
        return url;
    }

    void setUrl(final String url) {
        this.url = url;
    }

    String getPublisher() {
        return publisher;
    }

    void setPublisher(final String publisher) {
        this.publisher = publisher;
    }

    Long getVerificationCount() {
        return verificationCount;
    }

    void setVerificationCount(final Long verificationCount) {
        this.verificationCount = verificationCount;
    }

    Long getPublisherCount() {
        return publisherCount;
    }

    void setPublisherCount(final Long publisherCount) {
        this.publisherCount = publisherCount;
    }

    String getPublisherCompany() {
        return publisherCompany;
    }

    void setPublisherCompany(final String publisherCompany) {
        this.publisherCompany = publisherCompany;
    }

    String getPublisherWebsiteUrl() {
        return publisherWebsiteUrl;
    }

    void setPublisherWebsiteUrl(final String publisherWebsiteUrl) {
        this.publisherWebsiteUrl = publisherWebsiteUrl;
    }

    String getKind() {
        return kind;
    }

    void setKind(final String kind) {
        this.kind = kind;
    }

    String getContentType() {
        return contentType;
    }

    void setContentType(final String contentType) {
        this.contentType = contentType;
    }

    Map<String, Object> getMetadata() {
        return metadata;
    }

    void setMetadata(final Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    LocalDateTime getCreatedAt() {
        return createdAt;
    }

    void setCreatedAt(final LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Metadata)) {
            return false;
        }
        final Metadata metadata1 = (Metadata) o;
        return Objects.equals(name, metadata1.name) &&
            Objects.equals(size, metadata1.size) &&
            Objects.equals(url, metadata1.url) &&
            Objects.equals(publisher, metadata1.publisher) &&
            Objects.equals(verificationCount, metadata1.verificationCount) &&
            Objects.equals(publisherCount, metadata1.publisherCount) &&
            Objects.equals(publisherCompany, metadata1.publisherCompany) &&
            Objects.equals(publisherWebsiteUrl, metadata1.publisherWebsiteUrl) &&
            Objects.equals(kind, metadata1.kind) &&
            Objects.equals(contentType, metadata1.contentType) &&
            Objects.equals(metadata, metadata1.metadata) &&
            Objects.equals(createdAt, metadata1.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size, url, publisher, verificationCount,
            publisherCount, publisherCompany, publisherWebsiteUrl, kind,
            contentType, metadata, createdAt);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Metadata.class.getSimpleName() + "[", "]")
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
}
