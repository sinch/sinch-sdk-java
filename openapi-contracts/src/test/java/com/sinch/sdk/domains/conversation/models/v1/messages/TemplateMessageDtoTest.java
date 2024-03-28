package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class TemplateMessageDtoTest extends BaseTest {

  private static final Map<ConversationChannel, TemplateReference> channelTemplate =
      createChannelTemplate();
  private static final TemplateReference omniTemplate = createOmniTemplate();
  public static TemplateMessage templateMessageDto =
      TemplateMessage.builder()
          .setChannelTemplate(channelTemplate)
          .setOmniTemplate(omniTemplate)
          .build();

  @GivenTextResource("/domains/conversation/v1/messages/TemplateMessageDto.json")
  String jsonTemplateMessageDto;

  private static Map<ConversationChannel, TemplateReference> createChannelTemplate() {
    Map<ConversationChannel, TemplateReference> map = new HashMap<>();
    map.put(
        ConversationChannel.KAKAOTALK,
        TemplateReference.builder()
            .setTemplateId("my template ID value")
            .setVersion("a version")
            .setLanguageCode("en-US")
            .build());
    return Collections.unmodifiableMap(map);
  }

  private static TemplateReference createOmniTemplate() {
    Map<String, String> map = new HashMap<>();
    map.put(
        "name",
        "Value for the name parameter used in the version 1 and language \"en-US\" of the"
            + " template");
    return TemplateReference.builder()
        .setTemplateId("another template ID")
        .setVersion("another version")
        .setLanguageCode("another language")
        .setParameters(map)
        .build();
  }

  @Test
  void serializeMessageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(templateMessageDto);

    JSONAssert.assertEquals(jsonTemplateMessageDto, serializedString, true);
  }
}
