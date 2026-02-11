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
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.domains.conversation.api.v1.TranscodingService;
import com.sinch.sdk.domains.conversation.models.v1.transcoding.request.TranscodeMessageRequestDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.transcoding.response.TranscodeMessageResponse;
import com.sinch.sdk.domains.conversation.models.v1.transcoding.response.TranscodeMessageResponseDtoTest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
public class TranscodingServiceTest extends ConversationBaseTest {
  @Mock ServerConfiguration serverConfiguration;
  @Mock HttpClient httpClient;
  @Mock Map<String, AuthManager> authManagers;
  TranscodingService service;
  String uriPartID = "foovalue";

  static final Collection<String> AUTH_NAMES = Arrays.asList("Basic", "oAuth2");

  @GivenTextResource("/domains/conversation/v1/transcoding/request/TranscodeMessageRequestDto.json")
  String jsonTranscodeMessageRequestDto;

  @GivenTextResource(
      "domains/conversation/v1/transcoding/response/TranscodeMessageResponseDto.json")
  String jsonTranscodeMessageResponseDto;

  @BeforeEach
  public void initMocks() {
    service =
        new TranscodingServiceImpl(
            httpClient, serverConfiguration, authManagers, HttpMapper.getInstance(), uriPartID);
  }

  @Test
  void transcode() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            String.format("/v1/projects/%s/messages:transcode", uriPartID),
            HttpMethod.POST,
            Collections.emptyList(),
            jsonTranscodeMessageRequestDto,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(
            200, null, Collections.emptyMap(), jsonTranscodeMessageResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    TranscodeMessageResponse response =
        service.transcodeMessage(TranscodeMessageRequestDtoTest.transcodeMessageRequestDto);

    TestHelpers.recursiveEquals(
        response, TranscodeMessageResponseDtoTest.expectedTranscodeMessageResponseDto);
  }
}
