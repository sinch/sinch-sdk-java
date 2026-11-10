/**
 * Sinch Java Snippet
 *
 * <p>This snippet is available at https://github.com/sinch/sinch-sdk-java
 *
 * <p>See https://github.com/sinch/sinch-sdk-java/blob/main/examples/snippets/README.md for details
 */
package http;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.core.exceptions.ApiHttpException;
import com.sinch.sdk.core.http.transport.HttpHeaders;
import com.sinch.sdk.core.http.transport.HttpResponse;
import com.sinch.sdk.http.HttpCallParameters;
import com.sinch.sdk.http.HttpRequestOptions;
import com.sinch.sdk.http.SinchHttpClient;
import com.sinch.sdk.models.Configuration;
import java.util.Map;
import java.util.logging.Logger;
import utils.Settings;

public class Post {

  private static final Logger LOGGER = Logger.getLogger(Post.class.getName());

  public static void main(String[] args) {

    String projectId = Settings.getProjectId().orElse("MY_PROJECT_ID");
    String keyId = Settings.getKeyId().orElse("MY_KEY_ID");
    String keySecret = Settings.getKeySecret().orElse("MY_KEY_SECRET");

    // The phone number you want to lookup in E.164 format
    String phoneNumber = "PHONE_NUMBER";

    Configuration configuration =
        Configuration.builder().setKeyId(keyId).setKeySecret(keySecret).build();

    SinchClient client = new SinchClient(configuration);

    SinchHttpClient http = client.http();

    // The body is sent as is: serialize it and set the matching content-type header
    String body = "{\"number\":\"" + phoneNumber + "\"}";

    try {
      HttpResponse response =
          http.post(
              "https://lookup.api.sinch.com/v2/projects/" + projectId + "/lookups",
              body,
              HttpCallParameters.builder()
                  .setHeaders(
                      new HttpHeaders()
                          .set("content-type", "application/json")
                          .set("accept", "application/json"))
                  // request level options override the client settings for this call only
                  .setOptions(HttpRequestOptions.builder().setTimeoutSeconds(10).build())
                  .build());

      Map<String, Object> content = response.getContent().asMap();

      LOGGER.info("Response status: " + response.getStatus());
      LOGGER.info("Line: " + content.get("line"));
    } catch (ApiHttpException e) {
      // status >= 400: the response remains readable
      LOGGER.severe("Error " + e.getCode() + ": " + e.getResponse().getContent().asString());
    }
  }
}
