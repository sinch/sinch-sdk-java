package com.sinch.sdk;

import static org.junit.jupiter.api.Assertions.*;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.numberlookup.models.v2.request.NumberLookupRequest;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.NumberLookupContext;
import com.sinch.sdk.models.SMSRegion;
import com.sinch.sdk.models.SmsContext;
import com.sinch.sdk.models.TransportSettings;
import com.sinch.sdk.models.VerificationContext;
import com.sinch.sdk.models.VoiceContext;
import java.io.IOException;
import java.util.Optional;
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
  private final AtomicInteger apiRequests = new AtomicInteger();
  private volatile Optional<String> lastLookupAuthorization = Optional.empty();

  @BeforeEach
  void setUp() throws IOException {
    server = new MockWebServer();
    authRequests.set(0);
    apiRequests.set(0);
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
            apiRequests.incrementAndGet();
            lastLookupAuthorization = Optional.ofNullable(request.getHeader("Authorization"));
            // the verification status is deserialized from its method
            String body =
                path.startsWith("/verification")
                    ? "{\"id\":\"id\",\"method\":\"sms\",\"status\":\"PENDING\"}"
                    : "{}";
            return new MockResponse()
                .setResponseCode(200)
                .addHeader("Content-Type", "application/json")
                .setBody(body);
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
    assertFalse(lastLookupAuthorization.isPresent(), "no Authorization header must be sent");
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
    SinchClient client =
        new SinchClient(
            base()
                .setKeyId("key")
                .setKeySecret("secret")
                .setTransportSettings(TransportSettings.builder().setUseSinchAuth(true).build())
                .build());

    lookup(client);

    assertEquals(1, authRequests.get(), "the token exchange must still happen by default");
    assertTrue(lastLookupAuthorization.isPresent());
    assertTrue(lastLookupAuthorization.get().startsWith("Bearer "));
    client.close();
  }

  @Test
  void enabledStillRequiresCredentials() {
    SinchClient client =
        new SinchClient(
            base()
                .setTransportSettings(TransportSettings.builder().setUseSinchAuth(true).build())
                .build());

    assertThrows(RuntimeException.class, () -> lookup(client));
    client.close();
  }

  @Test
  void disabledSmsServicePlanSendsNoTokenAndDoesNotRequireIt() {
    SinchClient client = new SinchClient(sms().setTransportSettings(disabled()).build());

    sendIgnoringTheResponse(() -> client.sms().v1().groups().get("groupId"));

    assertNoAuthorizationSent();
    client.close();
  }

  @Test
  void enabledSmsServicePlanSendsTheToken() {
    SinchClient client = new SinchClient(sms().setSmsApiToken("api-token").build());

    sendIgnoringTheResponse(() -> client.sms().v1().groups().get("groupId"));

    assertEquals(1, apiRequests.get());
    assertEquals(Optional.of("Bearer api-token"), lastLookupAuthorization);
    client.close();
  }

  @Test
  void disabledVoiceV1SendsNoSignatureAndDoesNotRequireTheApplicationCredentials() {
    SinchClient client = new SinchClient(voiceV1().setTransportSettings(disabled()).build());

    sendIgnoringTheResponse(() -> client.voice().v1().calls().get("callId"));

    assertNoAuthorizationSent();
    client.close();
  }

  @Test
  void enabledVoiceV1SignsTheRequest() {
    SinchClient client =
        new SinchClient(
            voiceV1().setApplicationKey("app-key").setApplicationSecret("c2VjcmV0").build());

    sendIgnoringTheResponse(() -> client.voice().v1().calls().get("callId"));

    assertEquals(1, apiRequests.get());
    assertTrue(lastLookupAuthorization.orElse("").startsWith("Application app-key:"));
    client.close();
  }

  @Test
  void disabledVerificationSendsNoSignatureAndDoesNotRequireTheApplicationCredentials() {
    SinchClient client =
        new SinchClient(
            base()
                .setVerificationContext(
                    VerificationContext.builder()
                        .setVerificationUrl(server.url("/verification").toString())
                        .build())
                .setTransportSettings(disabled())
                .build());

    sendIgnoringTheResponse(() -> client.verification().v1().verificationStatus().getById("id"));

    assertNoAuthorizationSent();
    client.close();
  }

  @Test
  void disabledVoiceV2SendsNoTokenAndDoesNotRequireTheKeys() {
    SinchClient client =
        new SinchClient(
            base()
                .setVoiceV2Url(server.url("/voice-v2").toString())
                .setTransportSettings(disabled())
                .build());

    sendIgnoringTheResponse(() -> client.voice().v2().calls().get("callId"));

    assertEquals(0, authRequests.get());
    assertNoAuthorizationSent();
    client.close();
  }

  private Configuration.Builder sms() {
    return base()
        .setSmsServicePlanId("plan")
        .setSmsContext(
            SmsContext.builder()
                .setSmsUrl(server.url("/sms").toString())
                .setSmsRegion(SMSRegion.US)
                .build());
  }

  private Configuration.Builder voiceV1() {
    return base()
        .setVoiceContext(
            VoiceContext.builder()
                .setVoiceUrl(server.url("/voice").toString())
                .setVoiceApplicationMngmtUrl(server.url("/voice-mngmt").toString())
                .build());
  }

  private static TransportSettings disabled() {
    return TransportSettings.builder().setUseSinchAuth(false).build();
  }

  // the mock answers "{}" to every call: only the request sent matters, not its parsing
  private static void sendIgnoringTheResponse(Runnable call) {
    try {
      call.run();
    } catch (ApiException ignored) {
      // response not matching the model
    }
  }

  private void assertNoAuthorizationSent() {
    assertEquals(1, apiRequests.get(), "the request must be sent");
    assertFalse(lastLookupAuthorization.isPresent(), "no Authorization header must be sent");
  }
}
