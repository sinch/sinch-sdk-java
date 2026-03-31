package com.sinch.sdk.e2e.domains.conversation;

import com.sinch.sdk.domains.conversation.api.v1.TranscodingService;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.messages.AppMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.location.Coordinates;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.location.LocationMessage;
import com.sinch.sdk.domains.conversation.models.v1.transcoding.request.TranscodeMessageRequest;
import com.sinch.sdk.domains.conversation.models.v1.transcoding.response.TranscodeMessageResponse;
import com.sinch.sdk.e2e.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public class TranscodingSteps {

  TranscodingService service;
  TranscodeMessageResponse transcodeMessageResponse;
  int channelsCount;

  @Given("^the Conversation service \"Transcoding\" is available$")
  public void serviceAvailable() {
    service = Config.getSinchClient().conversation().v1().transcoding();
  }

  @When("^I send a request to transcode a location message$")
  public void transcodeMessage() {

    LocationMessage message =
        LocationMessage.builder()
            .setTitle("Phare d'Eckmühl")
            .setLabel("Pointe de Penmarch")
            .setCoordinates(
                Coordinates.builder().setLatitude(47.7981899).setLongitude(-4.3727685).build())
            .build();

    List<ConversationChannel> channels =
        Arrays.asList(
            ConversationChannel.APPLEBC,
            ConversationChannel.INSTAGRAM,
            ConversationChannel.KAKAOTALK,
            ConversationChannel.KAKAOTALKCHAT,
            ConversationChannel.LINE,
            ConversationChannel.MESSENGER,
            ConversationChannel.RCS,
            ConversationChannel.SMS,
            ConversationChannel.TELEGRAM,
            ConversationChannel.from("VIBER"),
            ConversationChannel.WECHAT,
            ConversationChannel.WHATSAPP);

    TranscodeMessageRequest request =
        TranscodeMessageRequest.builder()
            .setAppId(AppsSteps.APP_ID)
            .setChannels(channels)
            .setAppMessage(AppMessage.builder().setBody(message).build())
            .build();

    transcodeMessageResponse = service.transcodeMessage(request);
    channelsCount = channels.size();
  }

  @Then("the location message is transcoded for all the channels")
  public void transcodeMessageResult() {

    Map<ConversationChannel, String> transcodedMap =
        transcodeMessageResponse.getTranscodedMessage();
    Assertions.assertEquals(transcodedMap.size(), channelsCount);
    Assertions.assertTrue(transcodedMap.containsKey(ConversationChannel.APPLEBC));
    Assertions.assertTrue(transcodedMap.containsKey(ConversationChannel.INSTAGRAM));
    Assertions.assertTrue(transcodedMap.containsKey(ConversationChannel.KAKAOTALK));
    Assertions.assertTrue(transcodedMap.containsKey(ConversationChannel.KAKAOTALKCHAT));
    Assertions.assertTrue(transcodedMap.containsKey(ConversationChannel.LINE));
    Assertions.assertTrue(transcodedMap.containsKey(ConversationChannel.MESSENGER));
    Assertions.assertTrue(transcodedMap.containsKey(ConversationChannel.RCS));
    Assertions.assertTrue(transcodedMap.containsKey(ConversationChannel.SMS));
    Assertions.assertTrue(transcodedMap.containsKey(ConversationChannel.TELEGRAM));
    Assertions.assertTrue(transcodedMap.containsKey(ConversationChannel.from("VIBER")));
    Assertions.assertTrue(transcodedMap.containsKey(ConversationChannel.WECHAT));
    Assertions.assertTrue(transcodedMap.containsKey(ConversationChannel.WHATSAPP));

    String expectedWHATSAPPTranscodedMessageResponse =
        "{\"to\":\"{{to}}\",\"type\":\"location\",\"recipient_type\":\"individual\",\"location\":{\"longitude\":\"-4.3727684\",\"latitude\":\"47.79819\",\"name\":\"Phare"
            + " d'Eckmühl\",\"address\":\"Pointe de"
            + " Penmarch\"},\"messaging_product\":\"whatsapp\",\"biz_opaque_callback_data\":null}";

    Assertions.assertEquals(
        transcodedMap.get(ConversationChannel.WHATSAPP), expectedWHATSAPPTranscodedMessageResponse);
  }
}
