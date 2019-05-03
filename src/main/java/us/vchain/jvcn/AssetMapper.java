package us.vchain.jvcn;

import org.web3j.tuples.generated.Tuple4;

import java.math.BigInteger;
import java.time.Instant;

import static java.time.Instant.ofEpochSecond;
import static java.time.LocalDateTime.ofInstant;
import static java.time.ZoneOffset.UTC;

class AssetMapper {
    Asset from(final String hash,
               final Tuple4<String, BigInteger, BigInteger, BigInteger> tuple) {
        final Asset asset = new Asset();
        asset.setHash(hash);
        asset.setOwner(tuple.getValue1());
        asset.setLevel(tuple.getValue2().longValue());
        asset.setStatus(tuple.getValue3().longValue());
        final Instant instant = ofEpochSecond(tuple.getValue4().longValue());
        asset.setTimestamp(ofInstant(instant, UTC));
        return asset;
    }
}
