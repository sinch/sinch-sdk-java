package com.sinch.sdk.domains.conversation.models.v1.webhooks;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.ClientCredentials.TokenRequestTypeEnum;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class ClientCredentialsDtoTest extends ConversationBaseTest {

  public static ClientCredentials expectedDto =
      ClientCredentials.builder()
          .setClientId("a client id")
          .setClientSecret("a client secret")
          .setEndpoint("https://fake.url")
          .setScope("a scope")
          .setResponseType("a response type")
          .setTokenRequestType(TokenRequestTypeEnum.BASIC)
          .build();

  @GivenJsonResource("domains/conversation/v1/webhooks/ClientCredentialsDto.json")
  ClientCredentials dto;

  @GivenTextResource("/domains/conversation/v1/webhooks/ClientCredentialsDto.json")
  String json;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedDto);

    JSONAssert.assertEquals(json, serializedString, true);
  }

  @Test
  void deserialize() {
    TestHelpers.recursiveEquals(dto, expectedDto);
  }
}
