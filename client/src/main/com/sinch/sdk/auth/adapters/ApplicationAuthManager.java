package com.sinch.sdk.auth.adapters;

import com.sinch.sdk.core.exceptions.ApiAuthException;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.core.utils.StringUtil;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class ApplicationAuthManager implements AuthManager {

  private static final Logger LOGGER = Logger.getLogger(ApplicationAuthManager.class.getName());

  private static final String AUTH_KEYWORD = "Application";
  private static final String XTIMESTAMP_HEADER = "x-timestamp";
  private final String key;
  private final byte[] secret;

  public ApplicationAuthManager(String key, String base64Secret) {
    this.key = key;
    this.secret = Base64.getDecoder().decode(base64Secret);
  }

  // FIXME: Verification OAS file claim it support "Basic" but miss the "Application" definition
  public String getSchema() {
    return "Basic";
  }

  @Override
  public void resetToken() {
    // no op
  }

  @Override
  public Collection<Pair<String, String>> getAuthorizationHeaders(
      String timestamp, String method, String httpContentType, String path, String body) {

    String decodePath;
    try {
      decodePath = new URI(path).getPath();
    } catch (URISyntaxException e) {
      throw new ApiException(e);
    }
    // see
    // https://developers.sinch.com/docs/verification/api-reference/authentication/signed-request/
    String bodyMD5Hash = getBodyMD5Hash(body);
    String stringToSign = getSignature(method, bodyMD5Hash, httpContentType, timestamp, decodePath);
    String encoded = encode(stringToSign);
    String key = this.key == null ? "" : this.key;

    return Arrays.asList(
        new Pair<>("Authorization", AUTH_KEYWORD + " " + key + ":" + encoded),
        new Pair<>(XTIMESTAMP_HEADER, timestamp));
  }

  private String getBodyMD5Hash(String body) {
    if (StringUtil.isEmpty(body)) {
      return "";
    }
    try {
      MessageDigest md = MessageDigest.getInstance("MD5");
      byte[] digest = md.digest(body.getBytes(StandardCharsets.UTF_8));
      byte[] encodedMd5ToBase64VerificationBody = Base64.getEncoder().encode(digest);
      return new String(encodedMd5ToBase64VerificationBody, StandardCharsets.UTF_8);
    } catch (NoSuchAlgorithmException e) {
      throw new ApiAuthException(e);
    }
  }

  private String getSignature(
      String method, String bodyMD5Hash, String httpContentType, String timestamp, String path) {
    return String.join(
        "\n",
        method,
        bodyMD5Hash,
        null != httpContentType ? httpContentType : "",
        XTIMESTAMP_HEADER + ":" + timestamp,
        path);
  }

  private String encode(String stringToSign) {
    try {
      SecretKeySpec secretKeySpec = new SecretKeySpec(secret, "HmacSHA256");
      Mac mac = Mac.getInstance("HmacSHA256");
      mac.init(secretKeySpec);
      byte[] hmacSha256 = mac.doFinal(stringToSign.getBytes(StandardCharsets.UTF_8));
      return new String(Base64.getEncoder().encode(hmacSha256), StandardCharsets.UTF_8);
    } catch (NoSuchAlgorithmException | InvalidKeyException e) {
      throw new ApiAuthException(e);
    }
  }

  public boolean validateAuthenticatedRequest(
      String method, String path, Map<String, String> headers, String jsonPayload) {

    // convert header keys to use case-insensitive map keys
    Map<String, String> caseInsensitiveHeaders = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    caseInsensitiveHeaders.putAll(headers);

    String authorizationHeader = caseInsensitiveHeaders.get("Authorization");

    // missing authorization header
    if (null == authorizationHeader) {
      return false;
    }

    Pair<String, String> header = extractAuthorizationHeader(authorizationHeader);

    String authorizationKeyword = header.getLeft();
    if (!isValidAuthManagerKeyword(authorizationKeyword)) {
      LOGGER.severe(
          String.format("Invalid auth manager called with '%s' keyword", authorizationKeyword));
      return false;
    }

    String authorizationValue = header.getRight();
    Pair<String, String> parts = extractAuthorizationValues(authorizationValue);

    // is key is matching with current one?
    if (!parts.getLeft().equals(key)) {
      return false;
    }

    String computedValue = computeValue(caseInsensitiveHeaders, method, path, jsonPayload);

    return computedValue.equals(authorizationValue);
  }

  private Pair<String, String> extractAuthorizationHeader(String authorizationHeader) {
    String[] split = authorizationHeader.split(" ");
    String authorizationKeyword = split.length > 0 ? split[0] : "";
    String authorizationHash = split.length > 1 ? split[1] : "";
    return new Pair<>(authorizationKeyword, authorizationHash);
  }

  private boolean isValidAuthManagerKeyword(String authorizationKeyword) {
    return authorizationKeyword.compareToIgnoreCase(AUTH_KEYWORD) == 0;
  }

  private Pair<String, String> extractAuthorizationValues(String authorizationValue) {
    String[] split = authorizationValue.split(":");
    String authorizationKey = split.length > 0 ? split[0] : "";
    String authorizationHash = split.length > 1 ? split[1] : "";
    return new Pair<>(authorizationKey, authorizationHash);
  }

  private String computeValue(
      Map<String, String> caseInsensitiveHeaders, String method, String path, String jsonPayload) {
    // getting content type header
    String contentTypeHeader = caseInsensitiveHeaders.getOrDefault("content-type", "");

    // getting x-timestamp header
    String xTimeStampHeader = caseInsensitiveHeaders.get("x-timestamp");

    // compute locally according to inputs
    Collection<Pair<String, String>> computedHeaders =
        getAuthorizationHeaders(xTimeStampHeader, method, contentTypeHeader, path, jsonPayload);

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
}
