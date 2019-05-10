package us.vchain.jvcn;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.io.InputStream;

class AssetsClient {
    private final SystemConfiguration systemConfiguration;

    private final OkHttpClient httpClient;

    private final ObjectMapper objectMapper;

    public AssetsClient(final SystemConfiguration systemConfiguration) {
        this.systemConfiguration = systemConfiguration;
        httpClient = new OkHttpClient.Builder().build();
        objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
    }

    public Metadata fetchMetadata(final String hash,
                                  final String metaHash) throws IOException {
        final Request request = new Request.Builder()
            .url(systemConfiguration.getArtifactUrl(hash, metaHash))
            .build();
        final Response response = httpClient.newCall(request).execute();
        final InputStream inputStream = response.body() == null
            ? null : response.body().byteStream();
        return objectMapper.readValue(inputStream, Metadata.class);
    }
}
