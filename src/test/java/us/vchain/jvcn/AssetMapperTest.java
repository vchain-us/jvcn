package us.vchain.jvcn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.web3j.tuples.generated.Tuple4;

import java.math.BigInteger;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class AssetMapperTest {
    @InjectMocks
    private AssetMapper assetMapper;

    @Test
    public void from() {
        final Asset expectedAsset = new Asset();
        expectedAsset.setHash("hash");
        expectedAsset.setOwner("0xDEadBeeF");
        expectedAsset.setLevel(1L);
        expectedAsset.setStatus(10L);
        expectedAsset.setTimestamp(LocalDateTime.parse("1970-01-01T00:00"));
        final Tuple4<String, BigInteger, BigInteger, BigInteger> tuple =
            new Tuple4<>("0xDEADBEEF", BigInteger.ONE, BigInteger.TEN, BigInteger.ZERO);
        final Asset asset = assetMapper.from("hash", tuple);
        assertEquals(expectedAsset, asset);
    }
}
