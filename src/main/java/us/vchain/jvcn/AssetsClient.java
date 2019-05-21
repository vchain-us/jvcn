package us.vchain.jvcn;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.ofNullable;

class AssetsClient {
    private static final Logger log = LoggerFactory.getLogger(AssetsClient.class);

    private final SystemConfiguration systemConfiguration;

    private final OkHttpClient httpClient;

    private final ObjectMapper objectMapper;

    AssetsClient(final SystemConfiguration systemConfiguration) {
        this.systemConfiguration = systemConfiguration;
        httpClient = new OkHttpClient.Builder().build();
        objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
    }

    Optional<Metadata> fetchMetadata(final String hash,
                                     final String metaHash) {
        try {
            final Request request = new Request.Builder()
                .url(systemConfiguration.getArtifactUrl(hash, metaHash))
                .build();
            final Response response = httpClient.newCall(request).execute();
            final InputStream inputStream = response.body() == null
                ? null : response.body().byteStream();
            return ofNullable(objectMapper.readValue(inputStream, Metadata.class));
        } catch (final Exception e) {
            log.warn("Unable to fetch metadata for {}/{}: {}",
                hash, metaHash, e.getMessage(), e);
            return empty();
        }
    }
}
