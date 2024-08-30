package com.sinch.sample.conversation.transcoding;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.conversation.api.v1.TranscodingService;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.messages.AppMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.location.Coordinates;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.location.LocationMessage;
import com.sinch.sdk.domains.conversation.models.v1.transcoding.request.TranscodeMessageRequest;
import com.sinch.sdk.domains.conversation.models.v1.transcoding.response.TranscodeMessageResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;

public class Transcode extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(Transcode.class.getName());

  public Transcode() throws IOException {}

  public static void main(String[] args) {
    try {
      new Transcode().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    TranscodingService service = client.conversation().v1().transcoding();

    AppMessage<?> appMessage =
        AppMessage.<LocationMessage>builder()
            .setBody(
                LocationMessage.builder()
                    .setCoordinates(
                        Coordinates.builder()
                            .setLatitude(47.627980)
                            .setLongitude(-2.822915)
                            .build())
                    .setTitle("Coordinates title")
                    .build())
            .build();

    TranscodeMessageRequest request =
        TranscodeMessageRequest.builder()
            .setAppId(conversationAppId)
            .setAppMessage(appMessage)
            .setChannels(Arrays.asList(ConversationChannel.WHATSAPP))
            .build();

    LOGGER.info("Transcode message request: " + request);

    TranscodeMessageResponse response = service.transcodeMessage(request);
    LOGGER.info("Transcode message response: " + response);
  }
}
