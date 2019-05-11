package us.vchain.jvcn;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static java.io.File.createTempFile;
import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class JVCNIntegrationTest {
    private static final String ASSETS_CONTRACT =
        "0xf1d4b9fe8290bb5718db5d46c313e7b266570c21";

    private static final String BACKEND =
        "https://api.staging.codenotary.io/foundation";

    private static final String NETWORK =
        "https://main.staging.vchain.us";

    private static final String HASH =
        "181210f8f9c779c26da1d9b2075bde0127302ee0e3fca38c9a83f5b1dd8e5d3b";

    private static final String SIGNER =
        "0xC498EEEbDcBd4047b7393573dB21099cE42638be";

    private JVCN jvcn;

    private File tmpFile;

    @Before
    public void createTestFile() throws IOException {
        tmpFile = createTempFile("jvcn", "tmp");
        try (final FileOutputStream fileOutputStream = new FileOutputStream(tmpFile)) {
            fileOutputStream.write("123\n".getBytes(UTF_8));
        }
    }

    @After
    public void removeTestFile() {
        if (tmpFile != null && tmpFile.exists()) {
            assertTrue(tmpFile.delete());
        }
    }

    @Before
    public void setUpJVCN() {
        jvcn = new JVCN.Builder()
            .systemConfiguration(new SystemConfiguration() {
                @Override
                public String getContractAddress() {
                    return ASSETS_CONTRACT;
                }

                @Override
                public String getNetwork() {
                    return NETWORK;
                }

                @Override
                public String getBackend() {
                    return BACKEND;
                }
            })
            .build();
    }

    @Test
    public void verify() {
        final Optional<Asset> asset = jvcn.verify(HASH);
        assertTrue(asset.isPresent());
    }

    @Test
    public void verifyFile() {
        final Optional<Asset> asset = jvcn.verifyFile(tmpFile);
        assertTrue(asset.isPresent());
    }

    @Test
    public void listAllAssetsMatchingHash() {
        final List<Asset> assets = jvcn.listAllAssetsMatchingHash(HASH);
        assertFalse(assets.isEmpty());
    }

    @Test
    public void listAllAssetsMatchingFile() {
        final List<Asset> assets = jvcn.listAllAssetsMatchingFile(tmpFile);
        assertFalse(assets.isEmpty());
    }

    @Test
    public void listAllAssetsMatchingHashAndSigner() {
        final List<Asset> assets = jvcn.listAllAssetsMatchingHashAndSigner(HASH, SIGNER);
        assertFalse(assets.isEmpty());
    }

    @Test
    public void listAllAssetsMatchingFileAndSigner() {
        final List<Asset> assets = jvcn.listAllAssetsMatchingFileAndSigner(tmpFile, SIGNER);
        assertFalse(assets.isEmpty());
    }
}
