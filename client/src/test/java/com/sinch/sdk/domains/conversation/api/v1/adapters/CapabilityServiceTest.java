package com.sinch.sdk.domains.conversation.api.v1.adapters;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.domains.conversation.api.v1.internal.CapabilityApi;
import com.sinch.sdk.domains.conversation.models.v1.capability.request.QueryCapabilityRequestDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.capability.response.QueryCapabilityResponse;
import com.sinch.sdk.domains.conversation.models.v1.capability.response.QueryCapabilityResponseDtoTest;
import com.sinch.sdk.models.ConversationContext;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
public class CapabilityServiceTest extends ConversationBaseTest {

  @Mock ConversationContext context;
  @Mock CapabilityApi api;
  @Mock HttpClient httpClient;
  @Mock Map<String, AuthManager> authManagers;

  CapabilityService service;
  String uriPartID = "foovalue";

  @BeforeEach
  public void initMocks() {
    service = spy(new CapabilityService(uriPartID, context, httpClient, authManagers));
    doReturn(api).when(service).getApi();
  }

  @Test
  void lookup() throws ApiException {

    when(api.capabilityQueryCapability(
            eq(uriPartID), eq(QueryCapabilityRequestDtoTest.queryCapabilityRequestDto)))
        .thenReturn(QueryCapabilityResponseDtoTest.expectedQueryCapabilityResponseDto);

    QueryCapabilityResponse response =
        service.lookup(QueryCapabilityRequestDtoTest.queryCapabilityRequestDto);

    TestHelpers.recursiveEquals(
        response, QueryCapabilityResponseDtoTest.expectedQueryCapabilityResponseDto);
  }
}
