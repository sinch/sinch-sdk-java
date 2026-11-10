/**
 * Sinch Java Snippet
 *
 * <p>This snippet is available at https://github.com/sinch/sinch-sdk-java
 *
 * <p>See https://github.com/sinch/sinch-sdk-java/blob/main/examples/snippets/README.md for details
 */
package http;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.core.http.transport.HttpHeaders;
import com.sinch.sdk.core.http.transport.HttpResponse;
import com.sinch.sdk.http.HttpCallParameters;
import com.sinch.sdk.http.SinchHttpClient;
import com.sinch.sdk.models.Configuration;
import java.util.Map;
import java.util.logging.Logger;
import utils.Settings;

public class Get {

  private static final Logger LOGGER = Logger.getLogger(Get.class.getName());

  public static void main(String[] args) {

    String projectId = Settings.getProjectId().orElse("MY_PROJECT_ID");
    String keyId = Settings.getKeyId().orElse("MY_KEY_ID");
    String keySecret = Settings.getKeySecret().orElse("MY_KEY_SECRET");

    // projectId is not required by the HTTP client: it is part of the URL
    Configuration configuration =
        Configuration.builder().setKeyId(keyId).setKeySecret(keySecret).build();

    SinchClient client = new SinchClient(configuration);

    SinchHttpClient http = client.http();

    // The URL and the query parameters are sent as is: they have to be already encoded
    HttpResponse response =
        http.get(
            "https://numbers.api.sinch.com/v1/projects/" + projectId + "/activeNumbers",
            HttpCallParameters.builder()
                .setQueryParameters("?regionCode=US&type=LOCAL&pageSize=5")
                .setHeaders(new HttpHeaders().set("accept", "application/json"))
                .build());

    Map<String, Object> content = response.getContent().asMap();

    LOGGER.info("Response status: " + response.getStatus());
    LOGGER.info("Active numbers: " + content.get("activeNumbers"));
  }
}
