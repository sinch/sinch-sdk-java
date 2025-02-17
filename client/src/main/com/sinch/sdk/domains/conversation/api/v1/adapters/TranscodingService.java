package com.sinch.sdk.domains.conversation.api.v1.adapters;

import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.domains.conversation.api.v1.internal.TranscodingApi;
import com.sinch.sdk.domains.conversation.models.v1.transcoding.request.TranscodeMessageRequest;
import com.sinch.sdk.domains.conversation.models.v1.transcoding.response.TranscodeMessageResponse;
import com.sinch.sdk.models.ConversationContext;
import java.util.Map;

public class TranscodingService
    implements com.sinch.sdk.domains.conversation.api.v1.TranscodingService {

  private final String uriUUID;
  private final TranscodingApi api;

  public TranscodingService(
      String uriUUID,
      ConversationContext context,
      HttpClient httpClient,
      Map<String, AuthManager> authManagers) {
    this.uriUUID = uriUUID;
    this.api =
        new TranscodingApi(httpClient, context.getServer(), authManagers, HttpMapper.getInstance());
  }

  protected TranscodingApi getApi() {
    return this.api;
  }

  public TranscodeMessageResponse transcodeMessage(TranscodeMessageRequest request) {
    return getApi().transcodingTranscodeMessage(uriUUID, request);
  }
}
