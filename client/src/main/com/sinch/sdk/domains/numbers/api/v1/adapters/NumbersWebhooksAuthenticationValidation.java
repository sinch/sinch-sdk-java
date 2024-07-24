package com.sinch.sdk.domains.numbers.api.v1.adapters;

import com.sinch.sdk.core.exceptions.ApiAuthException;
import com.sinch.sdk.core.utils.MapUtils;
import com.sinch.sdk.core.utils.StringUtil;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Objects;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class NumbersWebhooksAuthenticationValidation {

  public static final String SIGNATURE_HEADER = "X-Sinch-Signature";
  static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";

  public boolean validateAuthenticationHeader(
      String secret, Map<String, String> headers, String jsonPayload) {

    // convert header keys to use case-insensitive map keys
    String signatureHeader = MapUtils.getCaseInsensitiveMap(headers).get(SIGNATURE_HEADER);

    // missing authorization header(s)
    if (StringUtil.isEmpty(secret) || StringUtil.isEmpty(signatureHeader)) {
      return false;
    }

    String signedData = encode(secret, jsonPayload);

    return Objects.equals(signatureHeader, signedData);
  }

  private String encode(String secret, String stringToSign) {
    try {
      SecretKeySpec secretKeySpec =
          new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), HMAC_SHA1_ALGORITHM);
      Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
      mac.init(secretKeySpec);
      byte[] hmacSha256 = mac.doFinal(stringToSign.getBytes(StandardCharsets.UTF_8));
      return NumbersWebhooksAuthenticationValidation.bytesToHex(hmacSha256);
    } catch (NoSuchAlgorithmException | InvalidKeyException e) {
      throw new ApiAuthException(e);
    }
  }

  private static String bytesToHex(byte[] hash) {
    StringBuilder hexString = new StringBuilder(2 * hash.length);
    for (byte h : hash) {
      String hex = Integer.toHexString(0xff & h);
      if (hex.length() == 1) hexString.append('0');
      hexString.append(hex);
    }
    return hexString.toString();
  }
}
