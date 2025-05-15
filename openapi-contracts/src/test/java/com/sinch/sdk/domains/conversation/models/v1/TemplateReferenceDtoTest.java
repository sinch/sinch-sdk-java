package com.sinch.sdk.domains.conversation.models.v1;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class TemplateReferenceDtoTest extends ConversationBaseTest {

  public static TemplateReference templateReferenceWithVersionDto = createTemplateReference(true);
  public static TemplateReference templateReferenceWithoutVersionDto =
      createTemplateReference(false);

  private static TemplateReference createTemplateReference(boolean withVersion) {
    Map<String, String> map = new HashMap<>();
    map.put(
        "name",
        "Value for the name parameter used in the version 1 and language \"en-US\" of the"
            + " template");

    TemplateReference.Builder builder =
        TemplateReference.builder()
            .setTemplateId("another template ID")
            .setLanguageCode("another language")
            .setParameters(map);

    if (withVersion) {
      builder.setVersion("another version");
    }
    return builder.build();
  }

  @GivenTextResource("/domains/conversation/v1/TemplateReferenceFieldWithVersionDto.json")
  String jsonTemplateReferenceWithVersionDto;

  @GivenTextResource("/domains/conversation/v1/TemplateReferenceFieldWithoutVersionDto.json")
  String jsonTemplateReferenceWithoutVersionDto;

  @Test
  void serializeTemplateReferenceDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(templateReferenceWithVersionDto);

    JSONAssert.assertEquals(jsonTemplateReferenceWithVersionDto, serializedString, true);
  }

  @Test
  void deserializeTemplateReferenceDto() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(jsonTemplateReferenceWithVersionDto, TemplateReference.class);

    TestHelpers.recursiveEquals(deserialized, templateReferenceWithVersionDto);
  }

  @Test
  void serializeTemplateReferenceWithoutVersionDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(templateReferenceWithoutVersionDto);

    JSONAssert.assertEquals(jsonTemplateReferenceWithoutVersionDto, serializedString, true);
  }

  @Test
  void deserializeTemplateReferenceWithoutVersionDto() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(jsonTemplateReferenceWithoutVersionDto, TemplateReference.class);

    TestHelpers.recursiveEquals(deserialized, templateReferenceWithoutVersionDto);
  }
}
