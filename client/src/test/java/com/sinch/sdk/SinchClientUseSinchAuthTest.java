package com.sinch.sdk;

import static org.junit.jupiter.api.Assertions.*;

import com.sinch.sdk.domains.numberlookup.models.v2.request.NumberLookupRequest;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.NumberLookupContext;
import com.sinch.sdk.models.TransportSettings;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SinchClientUseSinchAuthTest extends BaseTest {

  private MockWebServer server;
  private final AtomicInteger authRequests = new AtomicInteger();
  private volatile String lastLookupAuthorization = "unset";

  @BeforeEach
  void setUp() throws IOException {
    server = new MockWebServer();
    authRequests.set(0);
    server.setDispatcher(
        new Dispatcher() {
          @Override
          public MockResponse dispatch(RecordedRequest request) {
            String path = null != request.getPath() ? request.getPath() : "";
            if (path.startsWith("/auth")) {
              authRequests.incrementAndGet();
              return new MockResponse()
                  .setResponseCode(200)
                  .addHeader("Content-Type", "application/json")
                  .setBody(
                      "{\"access_token\":\"t\",\"expires_in\":3600,\"token_type\":\"Bearer\"}");
            }
            lastLookupAuthorization = request.getHeader("Authorization");
            return new MockResponse()
                .setResponseCode(200)
                .addHeader("Content-Type", "application/json")
                .setBody("{}");
          }
        });
    server.start();
  }

  @AfterEach
  void tearDown() throws IOException {
    server.shutdown();
  }

  private Configuration.Builder base() {
    return Configuration.builder()
        .setProjectId("project")
        .setOAuthUrl(server.url("/auth").toString())
        .setNumberLookupContext(
            NumberLookupContext.builder()
                .setNumberLookupUrl(server.url("/lookup").toString())
                .build());
  }

  private void lookup(SinchClient client) {
    client.lookup().v2().lookup(NumberLookupRequest.builder().setNumber("+46700000000").build());
  }

  @Test
  void disabledSkipsTheTokenFetchAndSendsNoAuthorization() {
    SinchClient client =
        new SinchClient(
            base()
                .setTransportSettings(TransportSettings.builder().setUseSinchAuth(false).build())
                .build());

    lookup(client);

    assertEquals(0, authRequests.get(), "no token must be fetched when Sinch auth is disabled");
    assertNull(lastLookupAuthorization, "no Authorization header must be sent");
    client.close();
  }

  @Test
  void disabledDoesNotRequireKeyIdNorKeySecret() {
    SinchClient client =
        new SinchClient(
            base()
                .setTransportSettings(TransportSettings.builder().setUseSinchAuth(false).build())
                .build());

    assertDoesNotThrow(() -> lookup(client));
    client.close();
  }

  @Test
  void enabledStillFetchesATokenAndAuthorizes() {
    SinchClient client = new SinchClient(base().setKeyId("key").setKeySecret("secret").build());

    lookup(client);

    assertEquals(1, authRequests.get(), "the token exchange must still happen by default");
    assertNotNull(lastLookupAuthorization);
    assertTrue(lastLookupAuthorization.startsWith("Bearer "));
    client.close();
  }

  @Test
  void enabledStillRequiresCredentials() {
    SinchClient client = new SinchClient(base().build());

    assertThrows(RuntimeException.class, () -> lookup(client));
    client.close();
  }
}
