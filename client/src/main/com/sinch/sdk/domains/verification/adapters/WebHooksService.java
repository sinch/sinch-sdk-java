package com.sinch.sdk.domains.verification.adapters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.exceptions.ApiMappingException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.verification.models.webhooks.VerificationEvent;
import com.sinch.sdk.domains.verification.models.webhooks.VerificationResponse;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Supplier;

public class WebHooksService implements com.sinch.sdk.domains.verification.WebHooksService {

  private final Supplier<Map<String, AuthManager>> authManagerSupplier;

  public WebHooksService(Supplier<Map<String, AuthManager>> authManagerSupplier) {
    this.authManagerSupplier = authManagerSupplier;
  }

  public boolean checkAuthentication(
      String method, String path, Map<String, String> headers, String jsonPayload) {

    // convert header keys to use case-insensitive map keys
    Map<String, String> ciHeaders = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    ciHeaders.putAll(headers);

    String authorizationHeader = ciHeaders.get("Authorization");

    // no authorization required
    if (null == authorizationHeader) {
      return true;
    }

    String[] split = authorizationHeader.split(" ");
    String authorizationKeyword = split.length > 0 ? split[0] : "";
    String authorizationHash = split.length > 1 ? split[1] : "";

    String computedHash = computeHash(ciHeaders, authorizationKeyword, method, path, jsonPayload);

    return computedHash.equals(authorizationHash);
  }

  private String computeHash(Map<String, String> ciHeaders, String authorizationKeyword,
      String method, String path, String jsonPayload) {
    // getting content type header
    String contentTypeHeader = ciHeaders.getOrDefault("content-type", "");

    // getting x-timestamp header
    String xTimeStampHeader = ciHeaders.get("x-timestamp");

    // getting manager related to Authorization header value
    AuthManager authManager = authManagerSupplier.get().get(authorizationKeyword);

    // compute locally according to inputs
    Collection<Pair<String, String>> computedHeaders =
        authManager.getAuthorizationHeaders(
            xTimeStampHeader, method, contentTypeHeader, path, jsonPayload);

    // get locally computed hash by auth manager
    String computedAuthorization =
        computedHeaders.stream()
            .filter(f -> f.getLeft().equals("Authorization"))
            .findFirst()
            .map(Pair::getRight)
            .orElse("");
    String[] newSplit = computedAuthorization.split(" ");
    return newSplit.length > 1 ? newSplit[1] : "";
  }

  @Override
  public VerificationEvent unserializeVerificationEvent(String jsonPayload)
      throws ApiMappingException {
    try {
      return Mapper.getInstance().readValue(jsonPayload, VerificationEvent.class);
    } catch (JsonProcessingException e) {
      throw new ApiMappingException(jsonPayload, e);
    }
  }

  @Override
  public String serializeVerificationResponse(VerificationResponse response)
      throws ApiMappingException {
    try {
      return Mapper.getInstance().writeValueAsString(response);
    } catch (JsonProcessingException e) {
      throw new ApiMappingException(response.toString(), e);
    }
  }
}
