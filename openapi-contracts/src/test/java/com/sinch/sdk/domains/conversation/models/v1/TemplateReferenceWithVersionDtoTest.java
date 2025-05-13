package com.sinch.sdk.domains.conversation.models.v1;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.internal.TemplateReferenceInternal;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class TemplateReferenceWithVersionDtoTest extends ConversationBaseTest {

  public static TemplateReferenceInternal templateReferenceWithVersionDto =
      createTemplateReference(true);
  public static TemplateReferenceInternal templateReferenceWithoutVersionDto =
      createTemplateReference(false);

  private static TemplateReferenceInternal createTemplateReference(boolean withVersion) {
    Map<String, String> map = new HashMap<>();
    map.put(
        "name",
        "Value for the name parameter used in the version 1 and language \"en-US\" of the"
            + " template");

    TemplateReferenceInternal.Builder builder =
        TemplateReferenceInternal.builder()
            .setTemplateId("another template ID")
            .setLanguageCode("another language")
            .setParameters(map);

    if (withVersion) {
      builder.setVersion("another version");
    }
    return builder.build();
  }

  @GivenTextResource("/domains/conversation/v1/TemplateReferenceWithVersionDto.json")
  String jsonTemplateReferenceFieldWithVersionDto;

  @GivenTextResource("/domains/conversation/v1/TemplateReferenceWithoutVersionDto.json")
  String jsonTemplateReferenceFieldWithoutVersionDto;

  @Test
  void serializeReferenceDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(templateReferenceWithVersionDto);

    JSONAssert.assertEquals(jsonTemplateReferenceFieldWithVersionDto, serializedString, true);
  }

  @Test
  void deserializeReferenceDto() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(
            jsonTemplateReferenceFieldWithVersionDto, TemplateReferenceInternal.class);

    TestHelpers.recursiveEquals(deserialized, templateReferenceWithVersionDto);
  }

  @Test
  void deserializeReferenceWithoutVersionDto() throws JsonProcessingException {

    Object deserialized =
        objectMapper.readValue(
            jsonTemplateReferenceFieldWithoutVersionDto, TemplateReferenceInternal.class);

    TestHelpers.recursiveEquals(deserialized, templateReferenceWithoutVersionDto);
  }

  @Test
  void serializeReferenceWithoutVersionDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(templateReferenceWithoutVersionDto);

    JSONAssert.assertEquals(jsonTemplateReferenceFieldWithoutVersionDto, serializedString, true);
  }
}
