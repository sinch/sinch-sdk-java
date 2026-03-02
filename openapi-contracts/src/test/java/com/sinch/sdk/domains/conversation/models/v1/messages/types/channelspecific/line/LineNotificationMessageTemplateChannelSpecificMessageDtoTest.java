package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.line;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.line.buttons.LineNotificationMessageTemplateButton;
import java.util.Arrays;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class LineNotificationMessageTemplateChannelSpecificMessageDtoTest
    extends ConversationBaseTest {

  @GivenTextResource(
      "/domains/conversation/v1/messages/types/channelspecific/line/LineNotificationMessageTemplateChannelSpecificMessageDto.json")
  static String jsonLineNotificationMessageTemplateChannelSpecificMessageDto;

  public static LineNotificationMessageTemplateChannelSpecificMessage
      lineNotificationMessageTemplateChannelSpecificMessageDto =
          LineNotificationMessageTemplateChannelSpecificMessage.builder()
              .setTemplateKey("order_item_completion_ja")
              .setBody(
                  LineNotificationMessageTemplateBody.builder()
                      .setEmphasizedItem(
                          LineNotificationMessageTemplateEmphasizedItem.builder()
                              .setItemKey("name_013_ja")
                              .setContent("013 ja content value")
                              .build())
                      .setItems(
                          Arrays.asList(
                              LineNotificationMessageTemplateItem.builder()
                                  .setItemKey("name_014_ja")
                                  .setContent("014 ja content value")
                                  .build()))
                      .setButtons(
                          Arrays.asList(
                              LineNotificationMessageTemplateButton.builder()
                                  .setButtonKey("check_delivery_status_ja")
                                  .setUrl("https://example.com")
                                  .build()))
                      .build())
              .build();

  @Test
  void deserializeKakaoTalkCommerceChannelSpecificMessage() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(
            jsonLineNotificationMessageTemplateChannelSpecificMessageDto,
            LineNotificationMessageTemplateChannelSpecificMessage.class);

    TestHelpers.recursiveEquals(
        deserialized, lineNotificationMessageTemplateChannelSpecificMessageDto);
  }

  @Test
  void serializeKakaoTalkCommerceChannelSpecificMessage()
      throws JsonProcessingException, JSONException {
    String serializedString =
        objectMapper.writeValueAsString(lineNotificationMessageTemplateChannelSpecificMessageDto);

    JSONAssert.assertEquals(
        jsonLineNotificationMessageTemplateChannelSpecificMessageDto, serializedString, true);
  }
}
