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

package com.sinch.sdk.domains.verification.models.v1.webhooks;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import com.sinch.sdk.domains.verification.models.v1.VerificationStatus;
import com.sinch.sdk.domains.verification.models.v1.VerificationStatusReason;
import com.sinch.sdk.domains.verification.models.v1.internal.IdentityInternal;
import java.util.Arrays;
import java.util.stream.Stream;

/** declaration */
@JsonDeserialize(builder = VerificationResultEventImpl.Builder.class)
public interface VerificationResultEvent {

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

  /** The verification method. */
  public class MethodEnum extends EnumDynamic<String, MethodEnum> {
    public static final MethodEnum SMS = new MethodEnum("sms");
    public static final MethodEnum FLASH_CALL = new MethodEnum("flashcall");
    public static final MethodEnum PHONE_CALL = new MethodEnum("callout");
    public static final MethodEnum DATA = new MethodEnum("seamless");

    private static final EnumSupportDynamic<String, MethodEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(
            MethodEnum.class, MethodEnum::new, Arrays.asList(SMS, FLASH_CALL, PHONE_CALL, DATA));

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
   * The verification method.
   *
   * @return method
   */
  MethodEnum getMethod();

  /**
   * Get identity
   *
   * @return identity
   */
  IdentityInternal getIdentity();

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

  /** Free text that the client is sending, used to show if the call/SMS was intercepted or not. */
  public class SourceEnum extends EnumDynamic<String, SourceEnum> {
    public static final SourceEnum INTERCEPTED = new SourceEnum("intercepted");
    public static final SourceEnum MANUAL = new SourceEnum("manual");

    private static final EnumSupportDynamic<String, SourceEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(
            SourceEnum.class, SourceEnum::new, Arrays.asList(INTERCEPTED, MANUAL));

    private SourceEnum(String value) {
      super(value);
    }

    public static Stream<SourceEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static SourceEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(SourceEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  /**
   * Free text that the client is sending, used to show if the call/SMS was intercepted or not.
   *
   * @return source
   */
  SourceEnum getSource();

  /**
   * A custom string that can be provided during a verification request.
   *
   * @return custom
   */
  String getCustom();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new VerificationResultEventImpl.Builder();
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
     * @param event see getter
     * @return Current builder
     * @see #getEvent
     */
    Builder setEvent(EventEnum event);

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
     * @param identity see getter
     * @return Current builder
     * @see #getIdentity
     */
    Builder setIdentity(IdentityInternal identity);

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
     * @param source see getter
     * @return Current builder
     * @see #getSource
     */
    Builder setSource(SourceEnum source);

    /**
     * see getter
     *
     * @param custom see getter
     * @return Current builder
     * @see #getCustom
     */
    Builder setCustom(String custom);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    VerificationResultEvent build();
  }
}
