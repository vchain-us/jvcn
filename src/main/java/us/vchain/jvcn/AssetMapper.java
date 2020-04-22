package us.vchain.jvcn;

import org.web3j.tuples.generated.Tuple4;

import java.math.BigInteger;
import java.time.Instant;

import static java.time.Instant.ofEpochSecond;
import static java.time.LocalDateTime.ofInstant;
import static java.time.ZoneOffset.UTC;
import static org.web3j.crypto.Keys.toChecksumAddress;

class AssetMapper {
    Asset from(final String hash,
               final Tuple4<String, BigInteger, BigInteger, BigInteger> tuple) {
        final Asset asset = new Asset();
        asset.setHash(hash);
        asset.setSigner(toChecksumAddress(tuple.component1()));
        asset.setLevel(Level.from(tuple.component2().intValue()));
        asset.setStatus(Status.from(tuple.component3().intValue()));
        final Instant instant = ofEpochSecond(tuple.component4().longValue());
        asset.setTimestamp(ofInstant(instant, UTC));
        return asset;
    }

    void enrich(final Asset asset,
                final Metadata metadata) {
        asset.setName(metadata.getName());
        asset.setSize(metadata.getSize());
        asset.setUrl(metadata.getUrl());
        asset.setPublisher(metadata.getPublisher());
        asset.setVerificationCount(metadata.getVerificationCount());
        asset.setPublisherCount(metadata.getPublisherCount());
        asset.setPublisherCompany(metadata.getPublisherCompany());
        asset.setPublisherWebsiteUrl(metadata.getPublisherWebsiteUrl());
        asset.setKind(metadata.getKind());
        asset.setContentType(metadata.getContentType());
        asset.setMetadata(metadata.getMetadata());
        asset.setCreatedAt(metadata.getCreatedAt());
    }
}
