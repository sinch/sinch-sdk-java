/*
 * Verification | Sinch
 *
 * OpenAPI document version: 2.0.1
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.verification.models.v1.start.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import com.sinch.sdk.domains.verification.models.v1.Identity;
import java.util.Arrays;
import java.util.stream.Stream;

/** VerificationStartRequestSms */
@JsonDeserialize(builder = VerificationStartRequestSmsImpl.Builder.class)
public interface VerificationStartRequestSms
    extends com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequest {

  /**
   * Get identity
   *
   * @return identity
   */
  Identity getIdentity();

  /**
   * Used to pass your own reference in the request for tracking purposes.
   *
   * @return reference
   */
  String getReference();

  /**
   * Can be used to pass custom data in the request.
   *
   * @return custom
   */
  String getCustom();

  /**
   * The expiration time for a verification process is represented in the format <code>HH:MM:SS
   * </code>.
   *
   * @return expiry
   */
  String getExpiry();

  /** Accepted values for the type of code to be generated are Numeric, Alpha, and Alphanumeric. */
  public class CodeTypeEnum extends EnumDynamic<String, CodeTypeEnum> {
    public static final CodeTypeEnum NUMERIC = new CodeTypeEnum("Numeric");
    public static final CodeTypeEnum ALPHA = new CodeTypeEnum("Alpha");
    public static final CodeTypeEnum ALPHANUMERIC = new CodeTypeEnum("Alphanumeric");

    private static final EnumSupportDynamic<String, CodeTypeEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(
            CodeTypeEnum.class, CodeTypeEnum::new, Arrays.asList(NUMERIC, ALPHA, ALPHANUMERIC));

    private CodeTypeEnum(String value) {
      super(value);
    }

    public static Stream<CodeTypeEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static CodeTypeEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(CodeTypeEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  /**
   * Accepted values for the type of code to be generated are Numeric, Alpha, and Alphanumeric.
   *
   * @return codeType
   */
  CodeTypeEnum getCodeType();

  /**
   * The SMS template must include a placeholder <code>{{CODE}}</code> where the verification code
   * will be inserted, and it can otherwise be customized as desired.
   *
   * @return template
   */
  String getTemplate();

  /**
   * In SMS Verification, value of <a
   * href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Accept-Language">Accept-Language</a>
   * header is used to determine the language of an SMS message.
   *
   * @return acceptLanguage
   */
  String getAcceptLanguage();

  /**
   * Return the additional "smsOptions" with the specified name.
   *
   * @param key the name of the property
   * @return the additional property with the specified name
   */
  Object getExtraOption(String key);

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new VerificationStartRequestSmsImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder
      extends com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequest
          .Builder {

    /**
     * see getter
     *
     * @param identity see getter
     * @return Current builder
     * @see #getIdentity
     */
    Builder setIdentity(Identity identity);

    /**
     * see getter
     *
     * @param reference see getter
     * @return Current builder
     * @see #getReference
     */
    Builder setReference(String reference);

    /**
     * see getter
     *
     * @param custom see getter
     * @return Current builder
     * @see #getCustom
     */
    Builder setCustom(String custom);

    /**
     * see getter
     *
     * @param expiry see getter
     * @return Current builder
     * @see #getExpiry
     */
    Builder setExpiry(String expiry);

    /**
     * see getter
     *
     * @param codeType see getter
     * @return Current builder
     * @see #getCodeType
     */
    Builder setCodeType(CodeTypeEnum codeType);

    /**
     * see getter
     *
     * @param template see getter
     * @return Current builder
     * @see #getTemplate
     */
    Builder setTemplate(String template);

    /**
     * see getter
     *
     * @param acceptLanguage see getter
     * @return Current builder
     * @see #getAcceptLanguage
     */
    Builder setAcceptLanguage(String acceptLanguage);

    /**
     * see getter
     *
     * @return Current builder
     * @see #getExtraOption
     */
    Builder putExtraOption(String key, Object value);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    VerificationStartRequestSms build();
  }
}
