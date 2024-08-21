package com.sinch.sdk.domains.conversation.api.v1.adapters;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.domains.conversation.api.v1.internal.TranscodingApi;
import com.sinch.sdk.domains.conversation.models.v1.transcoding.request.TranscodeMessageRequestDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.transcoding.response.TranscodeMessageResponse;
import com.sinch.sdk.domains.conversation.models.v1.transcoding.response.TranscodeMessageResponseDtoTest;
import com.sinch.sdk.models.ConversationContext;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
public class TranscodingServiceTest extends ConversationBaseTest {

  @Mock ConversationContext context;
  @Mock TranscodingApi api;
  @Mock HttpClient httpClient;
  @Mock Map<String, AuthManager> authManagers;

  TranscodingService service;
  String uriPartID = "foovalue";

  @BeforeEach
  public void initMocks() {
    service = spy(new TranscodingService(uriPartID, context, httpClient, authManagers));
    doReturn(api).when(service).getApi();
  }

  @Test
  void trancode() throws ApiException {

    when(api.transcodingTranscodeMessage(
            eq(uriPartID), eq(TranscodeMessageRequestDtoTest.transcodeMessageRequestDto)))
        .thenReturn(TranscodeMessageResponseDtoTest.expectedTranscodeMessageResponseDto);

    TranscodeMessageResponse response =
        service.transcodeMessage(TranscodeMessageRequestDtoTest.transcodeMessageRequestDto);

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(TranscodeMessageResponseDtoTest.expectedTranscodeMessageResponseDto);
  }
}
