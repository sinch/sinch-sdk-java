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
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class VerificationApplicationAuthManager implements AuthManager {

  private static final String AUTH_KEYWORD = "Application";
  private static final String XTIMESTAMP_HEADER = "x-timestamp";
  private final String key;
  private final byte[] secret;

  public VerificationApplicationAuthManager(String key, String base64Secret) {
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
        new Pair<>(XTIMESTAMP_HEADER, timestamp.toString()));
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
}
