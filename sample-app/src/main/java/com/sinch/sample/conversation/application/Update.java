package com.sinch.sample.conversation.application;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.conversation.api.v1.AppService;
import com.sinch.sdk.domains.conversation.models.v1.app.CallbackSettings;
import com.sinch.sdk.domains.conversation.models.v1.app.request.AppUpdateRequest;
import com.sinch.sdk.domains.conversation.models.v1.credentials.ConversationChannelCredentialsBuilderFactory;
import com.sinch.sdk.domains.conversation.models.v1.credentials.StaticBearerCredentials;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;

public class Update extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(Update.class.getName());

  public Update() throws IOException {}

  public static void main(String[] args) {
    try {
      new Update().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    AppService service = client.conversation().v1().app();

    LOGGER.info(String.format("Updating application '%s'", conversationAppId));

    var smsChannel =
        ConversationChannelCredentialsBuilderFactory.sms(
                StaticBearerCredentials.builder()
                    .setClaimedIdentity(smsServicePlanId)
                    .setToken(smsApiToken)
                    .build())
            .build();

    var parameters =
        AppUpdateRequest.builder()
            .setDisplayName("Updated from Java SDK")
            .setChannelCredentials(Arrays.asList(smsChannel))
            .setCallbackSettings(
                CallbackSettings.builder().setSecretForOverriddenCallbackUrls("foo secret").build())
            .build();

    var result = service.update(conversationAppId, parameters);

    LOGGER.info("Response: " + result);
  }
}
