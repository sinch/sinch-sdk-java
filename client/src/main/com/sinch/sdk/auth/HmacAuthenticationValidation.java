package com.sinch.sdk.auth;

import com.sinch.sdk.core.exceptions.ApiAuthException;
import com.sinch.sdk.core.utils.MapUtils;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HmacAuthenticationValidation {

  private static final Logger LOGGER =
      Logger.getLogger(HmacAuthenticationValidation.class.getName());

  public static final String TIMESTAMP_HEADER = "x-sinch-webhook-signature-timestamp";
  public static final String NONCE_HEADER = "x-sinch-webhook-signature-nonce";
  public static final String ALGORITHM_HEADER = "x-sinch-webhook-signature-algorithm";
  public static final String SIGNATURE_HEADER = "x-sinch-webhook-signature";

  public boolean validateAuthenticationHeader(
      String secret, Map<String, String> _headers, String jsonPayload) {

    Map<String, String> headers = MapUtils.getCaseInsensitiveMap(_headers);
    String timestampHeader = headers.get(TIMESTAMP_HEADER);
    String nonceHeader = headers.get(NONCE_HEADER);
    String algorithmHeader = headers.get(ALGORITHM_HEADER);
    String signatureHeader = headers.get(SIGNATURE_HEADER);

    // missing authorization header(s)
    if (null == secret
        || null == timestampHeader
        || null == nonceHeader
        || null == algorithmHeader
        || null == signatureHeader) {
      return false;
    }

    String toBeSignedData = String.format("%s.%s.%s", jsonPayload, nonceHeader, timestampHeader);

    String signedData = encode(secret, algorithmHeader, toBeSignedData);

    return Objects.equals(signatureHeader, signedData);
  }

  private String encode(String secret, String algorithm, String stringToSign) {
    try {
      SecretKeySpec secretKeySpec =
          new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), algorithm);
      Mac mac = Mac.getInstance(algorithm);
      mac.init(secretKeySpec);
      byte[] hmacSha256 = mac.doFinal(stringToSign.getBytes(StandardCharsets.UTF_8));
      return new String(Base64.getEncoder().encode(hmacSha256), StandardCharsets.UTF_8);
    } catch (NoSuchAlgorithmException | InvalidKeyException e) {
      throw new ApiAuthException(e);
    }
  }
}
