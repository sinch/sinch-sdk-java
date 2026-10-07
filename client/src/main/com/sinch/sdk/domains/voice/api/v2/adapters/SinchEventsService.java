package com.sinch.sdk.domains.voice.api.v2.adapters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.sinch.sdk.auth.adapters.ApplicationAuthManager;
import com.sinch.sdk.core.exceptions.ApiMappingException;
import com.sinch.sdk.core.utils.MapUtils;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.voice.models.v2.sinchevents.VoiceSinchEvent;
import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlInput;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Locale;
import java.util.Map;

public class SinchEventsService implements com.sinch.sdk.domains.voice.api.v2.SinchEventsService {

  private static final String AUTH_KEYWORD = "service";
  private static final String XTIMESTAMP_HEADER = "x-timestamp";

  // The API sends custom events as "call.webhook.<name>": the SDK names them after the
  // customEvent SVAML command, like the Python SDK does
  private static final String WIRE_CUSTOM_EVENT_PREFIX = "call.webhook.";
  private static final String CUSTOM_EVENT_PREFIX = "call.customEvent.";

  public boolean validateAuthenticationHeader(
      String serviceId,
      String serviceSecret,
      String method,
      String path,
      Map<String, String> headers,
      String jsonPayload) {

    StringUtil.requireNonEmpty(serviceId, "'serviceId' must be defined");
    StringUtil.requireNonEmpty(serviceSecret, "'serviceSecret' must be defined");

    // throws IllegalArgumentException on an invalid Base64 secret
    ApplicationAuthManager signer = new ApplicationAuthManager(serviceId, serviceSecret);

    if (null == headers) {
      return false;
    }

    // convert header keys to use case-insensitive map keys
    Map<String, String> caseInsensitiveHeaders = MapUtils.getCaseInsensitiveMap(headers);

    String authorizationHeader = caseInsensitiveHeaders.get("Authorization");
    if (StringUtil.isEmpty(authorizationHeader)) {
      return false;
    }

    String[] split = authorizationHeader.split(" ", 2);
    if (split.length != 2 || !AUTH_KEYWORD.equalsIgnoreCase(split[0])) {
      return false;
    }

    // signature is Base64 and contains no colon: split on the last one
    String authorizationValue = split[1];
    int separator = authorizationValue.lastIndexOf(':');
    if (separator < 0) {
      return false;
    }
    if (!serviceId.equals(authorizationValue.substring(0, separator))) {
      return false;
    }
    String receivedSignature = authorizationValue.substring(separator + 1);

    String timestamp = caseInsensitiveHeaders.get(XTIMESTAMP_HEADER);
    if (StringUtil.isEmpty(timestamp)) {
      return false;
    }
    String contentType = caseInsensitiveHeaders.getOrDefault("content-type", "");

    // Voice V2 "service" scheme shares the signing algorithm of the "Application" scheme
    String computedSignature =
        signer
            .getAuthorizationHeaders(
                timestamp,
                null == method ? null : method.toUpperCase(Locale.ROOT),
                contentType,
                path,
                jsonPayload)
            .stream()
            .filter(f -> f.getLeft().equals("Authorization"))
            .findFirst()
            .map(Pair::getRight)
            .map(value -> value.substring(value.lastIndexOf(':') + 1))
            .orElse("");

    return MessageDigest.isEqual(
        computedSignature.getBytes(StandardCharsets.UTF_8),
        receivedSignature.getBytes(StandardCharsets.UTF_8));
  }

  @Override
  public VoiceSinchEvent parseEvent(String jsonPayload) throws ApiMappingException {
    try {
      JsonNode node = Mapper.getInstance().readTree(jsonPayload);
      JsonNode event = null != node ? node.get("event") : null;
      if (node instanceof ObjectNode
          && null != event
          && event.isTextual()
          && event.asText().startsWith(WIRE_CUSTOM_EVENT_PREFIX)) {
        ((ObjectNode) node)
            .put(
                "event",
                CUSTOM_EVENT_PREFIX + event.asText().substring(WIRE_CUSTOM_EVENT_PREFIX.length()));
      }
      return Mapper.getInstance().treeToValue(node, VoiceSinchEvent.class);
    } catch (JsonProcessingException | IllegalArgumentException e) {
      throw new ApiMappingException(jsonPayload, e);
    }
  }

  @Override
  public String serializeResponse(SvamlInput response) throws ApiMappingException {
    try {
      return Mapper.getInstance().writeValueAsString(response);
    } catch (JsonProcessingException e) {
      throw new ApiMappingException(String.valueOf(response), e);
    }
  }
}
