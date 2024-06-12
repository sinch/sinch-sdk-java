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

package com.sinch.sdk.domains.verification.models.v1.status.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import com.sinch.sdk.domains.verification.models.v1.VerificationStatus;
import com.sinch.sdk.domains.verification.models.v1.VerificationStatusReason;
import com.sinch.sdk.domains.verification.models.v1.internal.IdentityInternal;
import com.sinch.sdk.domains.verification.models.v1.status.StatusCallResult;
import com.sinch.sdk.domains.verification.models.v1.status.StatusPrice;
import java.util.Arrays;
import java.util.stream.Stream;

/** declaration */
@JsonDeserialize(builder = PhoneCallVerificationStatusResponseImpl.Builder.class)
public interface PhoneCallVerificationStatusResponse {

  /**
   * The unique ID of the verification request.
   *
   * @return id
   */
  String getId();

  /**
   * Get status
   *
   * @return status
   */
  VerificationStatus getStatus();

  /**
   * Get reason
   *
   * @return reason
   */
  VerificationStatusReason getReason();

  /**
   * The reference ID that was optionally passed together with the verification request.
   *
   * @return reference
   */
  String getReference();

  /**
   * Get identity
   *
   * @return identity
   */
  IdentityInternal getIdentity();

  /**
   * The ID of the country to which the verification was sent.
   *
   * @return countryId
   */
  String getCountryId();

  /**
   * The timestamp in UTC format. &lt;/br&gt; **Note:** The formatting does not respect
   * &#x60;ISO-8601&#x60; and the returned value has the format &#x60;YYYY-MM-DDThh:mm:ss.SSS&#x60;.
   * If you need to parse this value into a specific date object in your programming language,
   * please append &#x60;Z&#x60; (Zulu time &#x3D; UTC) at the end of the date value to match the
   * &#x60;ISO-8601&#x60; format: &#x60;YYYY-MM-DDThh:mm:ss.SSSZ&#x60;.
   *
   * @return verificationTimestamp
   */
  String getVerificationTimestamp();

  /** The method of the verification request. This will always be &#x60;callout&#x60;. */
  public class MethodEnum extends EnumDynamic<String, MethodEnum> {
    public static final MethodEnum PHONE_CALL = new MethodEnum("callout");

    private static final EnumSupportDynamic<String, MethodEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(MethodEnum.class, MethodEnum::new, Arrays.asList(PHONE_CALL));

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
   * The method of the verification request. This will always be &#x60;callout&#x60;.
   *
   * @return method
   */
  MethodEnum getMethod();

  /**
   * Shows whether the call is complete or not.
   *
   * @return callComplete
   */
  Boolean getCallComplete();

  /**
   * Get callResult
   *
   * @return callResult
   */
  StatusCallResult getCallResult();

  /**
   * Get price
   *
   * @return price
   */
  StatusPrice getPrice();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new PhoneCallVerificationStatusResponseImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param id see getter
     * @return Current builder
     * @see #getId
     */
    Builder setId(String id);

    /**
     * see getter
     *
     * @param status see getter
     * @return Current builder
     * @see #getStatus
     */
    Builder setStatus(VerificationStatus status);

    /**
     * see getter
     *
     * @param reason see getter
     * @return Current builder
     * @see #getReason
     */
    Builder setReason(VerificationStatusReason reason);

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
     * @param identity see getter
     * @return Current builder
     * @see #getIdentity
     */
    Builder setIdentity(IdentityInternal identity);

    /**
     * see getter
     *
     * @param countryId see getter
     * @return Current builder
     * @see #getCountryId
     */
    Builder setCountryId(String countryId);

    /**
     * see getter
     *
     * @param verificationTimestamp see getter
     * @return Current builder
     * @see #getVerificationTimestamp
     */
    Builder setVerificationTimestamp(String verificationTimestamp);

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
     * @param callComplete see getter
     * @return Current builder
     * @see #getCallComplete
     */
    Builder setCallComplete(Boolean callComplete);

    /**
     * see getter
     *
     * @param callResult see getter
     * @return Current builder
     * @see #getCallResult
     */
    Builder setCallResult(StatusCallResult callResult);

    /**
     * see getter
     *
     * @param price see getter
     * @return Current builder
     * @see #getPrice
     */
    Builder setPrice(StatusPrice price);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    PhoneCallVerificationStatusResponse build();
  }
}
