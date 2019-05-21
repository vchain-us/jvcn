package us.vchain.jvcn;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static java.io.File.createTempFile;
import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static us.vchain.jvcn.DigestHelper.sha256Hash;

@RunWith(MockitoJUnitRunner.class)
public class DigestHelperTest {
    private static final String HASH =
        "181210f8f9c779c26da1d9b2075bde0127302ee0e3fca38c9a83f5b1dd8e5d3b";

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

    @Test
    public void hashFile() throws Exception {
        final String hash = sha256Hash(tmpFile);
        assertEquals(HASH, hash);
    }
}
