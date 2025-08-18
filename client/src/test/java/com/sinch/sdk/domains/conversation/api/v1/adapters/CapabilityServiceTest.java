package com.sinch.sdk.domains.conversation.api.v1.adapters;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpContentType;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.http.HttpMethod;
import com.sinch.sdk.core.http.HttpRequest;
import com.sinch.sdk.core.http.HttpRequestTest.HttpRequestMatcher;
import com.sinch.sdk.core.http.HttpResponse;
import com.sinch.sdk.core.http.URLPathUtils;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.domains.conversation.api.v1.CapabilityService;
import com.sinch.sdk.domains.conversation.models.v1.capability.request.QueryCapabilityRequestDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.capability.response.QueryCapabilityResponse;
import com.sinch.sdk.domains.conversation.models.v1.capability.response.QueryCapabilityResponseDtoTest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
public class CapabilityServiceTest extends ConversationBaseTest {

  @Mock HttpClient httpClient;
  @Mock ServerConfiguration serverConfiguration;
  @Mock Map<String, AuthManager> authManagers;

  static final String uriUUID = "foo";
  static final Collection<String> AUTH_NAMES = Arrays.asList("Basic", "oAuth2");

  CapabilityService service;

  @GivenTextResource("/domains/conversation/v1/capability/request/QueryCapabilityRequestDto.json")
  static String jsonQueryCapabilityRequestDto;

  @GivenTextResource("domains/conversation/v1/capability/response/QueryCapabilityResponseDto.json")
  String jsonQueryCapabilityResponseDto;

  @BeforeEach
  public void initMocks() {
    service =
        new CapabilityServiceImpl(
            httpClient, serverConfiguration, authManagers, HttpMapper.getInstance(), uriUUID);
  }

  @Test
  void lookup() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            String.format(
                "/v1/projects/%s/capability:query", URLPathUtils.encodePathSegment(uriUUID)),
            HttpMethod.POST,
            Collections.emptyList(),
            jsonQueryCapabilityRequestDto,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(
            200, null, Collections.emptyMap(), jsonQueryCapabilityResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    QueryCapabilityResponse response =
        service.lookup(QueryCapabilityRequestDtoTest.queryCapabilityRequestDto);

    TestHelpers.recursiveEquals(
        response, QueryCapabilityResponseDtoTest.expectedQueryCapabilityResponseDto);
  }
}
