/*
 * Verification | Sinch
 * Verify users with SMS, flash calls (missed calls), a regular call, or data verification.
 *
 * The version of the OpenAPI document: 2.0.1
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.verification.models.v1.report.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** declaration */
@JsonDeserialize(builder = VerificationReportRequestParametersCalloutImpl.Builder.class)
public interface VerificationReportRequestParametersCallout {

  /** The type of verification. */
  public class MethodEnum extends EnumDynamic<String, MethodEnum> {
    public static final MethodEnum CALLOUT = new MethodEnum("callout");

    private static final EnumSupportDynamic<String, MethodEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(MethodEnum.class, MethodEnum::new, Arrays.asList(CALLOUT));

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
   * The type of verification.
   *
   * @return method
   */
  MethodEnum getMethod();

  /**
   * Get callout
   *
   * @return callout
   */
  VerificationReportRequestParametersCalloutOptions getCallout();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new VerificationReportRequestParametersCalloutImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param method see getter
     * @return Current builder
     * @see #getMethod
     */
    Builder setMethod(MethodEnum method);

    /**
     * see getter
     *
     * @param callout see getter
     * @return Current builder
     * @see #getCallout
     */
    Builder setCallout(VerificationReportRequestParametersCalloutOptions callout);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    VerificationReportRequestParametersCallout build();
  }
}
