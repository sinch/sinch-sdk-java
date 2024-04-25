package com.sinch.sdk.domains.conversation.models.v1.templates;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.domains.conversation.adapters.ConversationBaseTest;
import java.util.HashMap;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class TemplateReferenceDtoTest extends ConversationBaseTest {

  public static TemplateReference templateReferenceDto = createTemplateReference();

  private static TemplateReference createTemplateReference() {
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

  @GivenTextResource("/domains/conversation/v1/templates/TemplateReferenceDto.json")
  String jsonTemplateReferenceDto;

  @Test
  void serializeMessageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(templateReferenceDto);

    JSONAssert.assertEquals(jsonTemplateReferenceDto, serializedString, true);
  }

  @Test
  void deserializeMessageDto() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(jsonTemplateReferenceDto, TemplateReference.class);

    Assertions.assertThat(deserialized).usingRecursiveComparison().isEqualTo(templateReferenceDto);
  }
}
