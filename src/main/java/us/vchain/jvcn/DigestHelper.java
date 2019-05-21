package us.vchain.jvcn;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static java.lang.String.format;
import static java.nio.charset.StandardCharsets.UTF_8;
import static java.security.MessageDigest.getInstance;
import static java.time.ZoneOffset.UTC;

class DigestHelper {
    private static final String ALGORITHM = "SHA-256";

    @SuppressWarnings("StatementWithEmptyBody")
    static String sha256Hash(final File file) throws Exception {
        final MessageDigest messageDigest = getInstance(ALGORITHM);
        try (final FileInputStream fileInputStream = new FileInputStream(file);
             final DigestInputStream digestInputStream = new DigestInputStream(
                 fileInputStream, messageDigest)) {
            while (digestInputStream.read() != -1) {
                // consume file
            }
            return format("%064x", new BigInteger(1, messageDigest.digest()));
        }
    }

    static String metaHash(final Asset asset) {
        try {
            final String format = format(
                "%s-%d-%d-%d",
                asset.getSigner(),
                asset.getLevel().getValue(),
                asset.getStatus().getValue(),
                asset.getTimestamp().toEpochSecond(UTC));
            final MessageDigest messageDigest = MessageDigest.getInstance(ALGORITHM);
            messageDigest.update(format.getBytes(UTF_8));
            final byte[] digest = messageDigest.digest();
            return format("%064x", new BigInteger(1, digest));
        } catch (final NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
