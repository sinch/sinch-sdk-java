package com.sinch.sdk.domains.verification.api.v1;

import com.sinch.sdk.core.exceptions.ApiMappingException;
import com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationEvent;
import com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationRequestEventResponse;
import java.util.Map;

public interface WebHooksService {

  boolean validateAuthenticationHeader(
      String method, String path, Map<String, String> headers, String jsonPayload);

  VerificationEvent parseEvent(String jsonPayload) throws ApiMappingException;

  String serializeResponse(VerificationRequestEventResponse response) throws ApiMappingException;
}
