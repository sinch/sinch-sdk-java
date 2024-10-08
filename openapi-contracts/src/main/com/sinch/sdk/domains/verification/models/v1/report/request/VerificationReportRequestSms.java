/*
 * Verification | Sinch
 *
 * OpenAPI document version: 2.0.1
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.verification.models.v1.report.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** SMS Verification Report Request */
@JsonDeserialize(builder = VerificationReportRequestSmsImpl.Builder.class)
public interface VerificationReportRequestSms
    extends com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequest {

  /** The type of verification. */
  public class MethodEnum extends EnumDynamic<String, MethodEnum> {
    public static final MethodEnum SMS = new MethodEnum("sms");

    private static final EnumSupportDynamic<String, MethodEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(MethodEnum.class, MethodEnum::new, Arrays.asList(SMS));

    private MethodEnum(String value) {
      super(value);
    }

    public static Stream<MethodEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static MethodEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(MethodEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  /**
   * The code which was received by the user submitting the SMS verification.
   *
   * @return code
   */
  String getCode();

  /**
   * The sender ID of the SMS.
   *
   * @return cli
   */
  String getCli();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new VerificationReportRequestSmsImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param code see getter
     * @return Current builder
     * @see #getCode
     */
    Builder setCode(String code);

    /**
     * see getter
     *
     * @param cli see getter
     * @return Current builder
     * @see #getCli
     */
    Builder setCli(String cli);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    VerificationReportRequestSms build();
  }
}
