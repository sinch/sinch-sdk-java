import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Logger;

public class SmokeTest {

  private static final Logger LOGGER = Logger.getLogger(SmokeTest.class.getName());

  // A simulated call.incoming event, with every field Sinch sends
  private static final String CALL_INCOMING_EVENT =
      """
      {
        "event": "call.incoming",
        "call": {
          "callId": "test",
          "projectId": "test",
          "serviceId": "test",
          "sessionId": "test",
          "direction": "INBOUND",
          "originationType": "PHONE",
          "callType": "PHONE",
          "from": {"type": "PHONE", "phone": {"number": "+15551112222"}},
          "to": {"type": "PHONE", "phone": {"number": "+14045001000"}},
          "callResult": "INITIATED",
          "startTime": "2025-06-01T10:00:00Z",
          "callRate": {"currencyCode": "USD", "amount": "0.0000"},
          "callResourceUrl": "https://voice.api.sinch.com"
        }
      }
      """;

  public static void main(String[] args) throws Exception {

    String port = Settings.get("PORT", "3000");

    HttpRequest request =
        HttpRequest.newBuilder(URI.create("http://localhost:" + port + "/voice/events"))
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(CALL_INCOMING_EVENT))
            .build();

    HttpResponse<String> response =
        HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

    LOGGER.info(response.statusCode() + " " + response.body());
  }
}
