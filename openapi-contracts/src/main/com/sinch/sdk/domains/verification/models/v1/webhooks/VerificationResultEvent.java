/*
 * Verification | Sinch
 *
 * OpenAPI document version: 2.0.1
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.verification.models.v1.webhooks;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import com.sinch.sdk.domains.verification.models.v1.Identity;
import com.sinch.sdk.domains.verification.models.v1.VerificationMethod;
import com.sinch.sdk.domains.verification.models.v1.VerificationStatus;
import com.sinch.sdk.domains.verification.models.v1.VerificationStatusReason;
import com.sinch.sdk.domains.verification.models.v1.status.StatusSource;
import java.util.Arrays;
import java.util.stream.Stream;

/** VerificationResultEvent */
@JsonDeserialize(builder = VerificationResultEventImpl.Builder.class)
public interface VerificationResultEvent
    extends com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationEvent {

  /**
   * The ID of the verification request.
   *
   * @return id
   */
  String getId();

  /** The type of the event. */
  public class EventEnum extends EnumDynamic<String, EventEnum> {
    public static final EventEnum VERIFICATION_RESULT_EVENT =
        new EventEnum("VerificationResultEvent");

    private static final EnumSupportDynamic<String, EventEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(
            EventEnum.class, EventEnum::new, Arrays.asList(VERIFICATION_RESULT_EVENT));

    private EventEnum(String value) {
      super(value);
    }

    public static Stream<EventEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static EventEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(EventEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  /**
   * The type of the event.
   *
   * @return event
   */
  EventEnum getEvent();

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
   * Get method
   *
   * @return method
   */
  VerificationMethod getMethod();

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
   * Get source
   *
   * @return source
   */
  StatusSource getSource();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new VerificationResultEventImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder
      extends com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationEvent.Builder {

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
     * @param event see getter
     * @return Current builder
     * @see #getEvent
     */
    Builder setEvent(EventEnum event);

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
     * @param method see getter
     * @return Current builder
     * @see #getMethod
     */
    Builder setMethod(VerificationMethod method);

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
     * @param source see getter
     * @return Current builder
     * @see #getSource
     */
    Builder setSource(StatusSource source);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    VerificationResultEvent build();
  }
}
