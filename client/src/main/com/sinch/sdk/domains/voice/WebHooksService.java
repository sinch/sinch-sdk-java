package com.sinch.sdk.domains.voice;

import com.sinch.sdk.core.exceptions.ApiMappingException;
import com.sinch.sdk.domains.voice.models.svaml.SVAMLControl;
import com.sinch.sdk.domains.voice.models.webhooks.WebhooksEvent;
import java.util.Map;

public interface WebHooksService {

  boolean validateAuthenticatedRequest(
      String method, String path, Map<String, String> headers, String jsonPayload);

  WebhooksEvent unserializeWebhooksEvent(String jsonPayload) throws ApiMappingException;

  String serializeWebhooksResponse(SVAMLControl response) throws ApiMappingException;
}
