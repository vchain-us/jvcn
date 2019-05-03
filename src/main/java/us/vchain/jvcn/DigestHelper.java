package us.vchain.jvcn;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.DigestInputStream;
import java.security.MessageDigest;

import static java.lang.String.format;
import static java.security.MessageDigest.getInstance;

class DigestHelper {
    private static final String ALGORITHM = "SHA-256";

    String sha256Hash(final File file) throws Exception {
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
}
