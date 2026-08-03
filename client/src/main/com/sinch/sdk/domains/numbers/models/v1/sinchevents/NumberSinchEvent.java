/*
 * Numbers | Sinch
 *
 * NOTE: This class is NOT generated: it is maintained by hand.
 */

package com.sinch.sdk.domains.numbers.models.v1.sinchevents;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.time.Instant;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Base class for Numbers Sinch Events.
 *
 * @see ActiveNumberSinchEvent
 * @see NumberOrderSinchEvent
 */
@JsonDeserialize(builder = NumberSinchEventImpl.Builder.class)
public interface NumberSinchEvent extends CallbackPayloadBase {

  /**
   * The unique identifier of the resource, depending on the resource type. For example, a phone
   * number, a hosting order ID, or a brand ID.
   *
   * @return resourceId
   * @deprecated Use {@link ActiveNumberSinchEvent#getResourceId()} or {@link
   *     NumberOrderSinchEvent#getResourceId()}
   */
  @Deprecated
  String getResourceId();

  /** The type of the event. */
  public class EventTypeEnum extends EnumDynamic<String, EventTypeEnum> {
    /** An event that occurs when a number is linked to a Service Plan ID. */
    public static final EventTypeEnum PROVISIONING_TO_SMS_PLATFORM =
        new EventTypeEnum("PROVISIONING_TO_SMS_PLATFORM");

    /** An event that occurs when a number is unlinked from a Service Plan ID. */
    public static final EventTypeEnum DEPROVISIONING_FROM_SMS_PLATFORM =
        new EventTypeEnum("DEPROVISIONING_FROM_SMS_PLATFORM");

    /** An event that occurs when a number is linked to a Campaign. */
    public static final EventTypeEnum PROVISIONING_TO_CAMPAIGN =
        new EventTypeEnum("PROVISIONING_TO_CAMPAIGN");

    /** An event that occurs when a number is unlinked from a Campaign. */
    public static final EventTypeEnum DEPROVISIONING_FROM_CAMPAIGN =
        new EventTypeEnum("DEPROVISIONING_FROM_CAMPAIGN");

    /** An event that occurs when a number is enabled for Voice operations. */
    public static final EventTypeEnum PROVISIONING_TO_VOICE_PLATFORM =
        new EventTypeEnum("PROVISIONING_TO_VOICE_PLATFORM");

    /** An event that occurs when a number is disabled for Voice operations. */
    public static final EventTypeEnum DEPROVISIONING_FROM_VOICE_PLATFORM =
        new EventTypeEnum("DEPROVISIONING_FROM_VOICE_PLATFORM");

    /** An event that occurs when a Number Order transitions to a new state. */
    public static final EventTypeEnum NUMBER_ORDER_PROCESSING =
        new EventTypeEnum("NUMBER_ORDER_PROCESSING");

    /** Deprecated. Replaced by <code>DEPROVISIONING_FROM_VOICE_PLATFORM</code>. */
    public static final EventTypeEnum DEPROVISIONING_TO_VOICE_PLATFORM =
        new EventTypeEnum("DEPROVISIONING_TO_VOICE_PLATFORM");

    private static final EnumSupportDynamic<String, EventTypeEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(
            EventTypeEnum.class,
            EventTypeEnum::new,
            Arrays.asList(
                PROVISIONING_TO_SMS_PLATFORM,
                DEPROVISIONING_FROM_SMS_PLATFORM,
                PROVISIONING_TO_CAMPAIGN,
                DEPROVISIONING_FROM_CAMPAIGN,
                PROVISIONING_TO_VOICE_PLATFORM,
                DEPROVISIONING_FROM_VOICE_PLATFORM,
                NUMBER_ORDER_PROCESSING,
                DEPROVISIONING_TO_VOICE_PLATFORM));

    private EventTypeEnum(String value) {
      super(value);
    }

    public static Stream<EventTypeEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static EventTypeEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(EventTypeEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  /**
   * The type of the event.
   *
   * @return eventType
   * @deprecated Use {@link ActiveNumberSinchEvent#getEventType()} or {@link
   *     NumberOrderSinchEvent#getEventType()}
   */
  @Deprecated
  EventTypeEnum getEventType();

  /** The status of the event or the state transition it represents. */
  public class StatusEnum extends EnumDynamic<String, StatusEnum> {
    /** The event has succeeded. */
    public static final StatusEnum SUCCEEDED = new StatusEnum("SUCCEEDED");

    /** The event has failed. */
    public static final StatusEnum FAILED = new StatusEnum("FAILED");

    /** The Number Order transitioned to the IN_REVIEW state. */
    public static final StatusEnum IN_REVIEW = new StatusEnum("IN_REVIEW");

    /** The Number Order transitioned to the BLOCKED state. */
    public static final StatusEnum BLOCKED = new StatusEnum("BLOCKED");

    /** The Number Order transitioned to the COMPLETED state. */
    public static final StatusEnum COMPLETED = new StatusEnum("COMPLETED");

    /** The Number Order transitioned to the REJECTED state. */
    public static final StatusEnum REJECTED = new StatusEnum("REJECTED");

    /** The Number Order transitioned to the EXPIRED state. */
    public static final StatusEnum EXPIRED = new StatusEnum("EXPIRED");

    private static final EnumSupportDynamic<String, StatusEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(
            StatusEnum.class,
            StatusEnum::new,
            Arrays.asList(SUCCEEDED, FAILED, IN_REVIEW, BLOCKED, COMPLETED, REJECTED, EXPIRED));

    private StatusEnum(String value) {
      super(value);
    }

    public static Stream<StatusEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static StatusEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(StatusEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  /**
   * The status of the event or the state transition it represents.
   *
   * @return status
   * @deprecated Use {@link ActiveNumberSinchEvent#getStatus()} or {@link
   *     NumberOrderSinchEvent#getStatus()}
   */
  @Deprecated
  StatusEnum getStatus();

  /**
   * If the status is FAILED, a failure code will be provided. For numbers provisioning to SMS
   * platform, there won't be any extra <code>failureCode</code>, as the result is binary. For
   * campaign provisioning-related failures, refer to the list for the possible values.
   */
  public class FailureCodeEnum extends EnumDynamic<String, FailureCodeEnum> {
    /** The specified campaign is not available. */
    public static final FailureCodeEnum CAMPAIGN_NOT_AVAILABLE =
        new FailureCodeEnum("CAMPAIGN_NOT_AVAILABLE");

    /** Exceeded the limit for 10DLC. */
    public static final FailureCodeEnum EXCEEDED_10_DLC_LIMIT =
        new FailureCodeEnum("EXCEEDED_10DLC_LIMIT");

    /** Provisioning the number failed. */
    public static final FailureCodeEnum NUMBER_PROVISIONING_FAILED =
        new FailureCodeEnum("NUMBER_PROVISIONING_FAILED");

    /** The third party service is unavailable. */
    public static final FailureCodeEnum PARTNER_SERVICE_UNAVAILABLE =
        new FailureCodeEnum("PARTNER_SERVICE_UNAVAILABLE");

    /** The campaign is not yet accepted. */
    public static final FailureCodeEnum CAMPAIGN_PENDING_ACCEPTANCE =
        new FailureCodeEnum("CAMPAIGN_PENDING_ACCEPTANCE");

    /** Error with MNO. */
    public static final FailureCodeEnum MNO_SHARING_ERROR =
        new FailureCodeEnum("MNO_SHARING_ERROR");

    /** The campaign failed to provision. */
    public static final FailureCodeEnum CAMPAIGN_PROVISIONING_FAILED =
        new FailureCodeEnum("CAMPAIGN_PROVISIONING_FAILED");

    /** The campaign expired. */
    public static final FailureCodeEnum CAMPAIGN_EXPIRED = new FailureCodeEnum("CAMPAIGN_EXPIRED");

    /** The campaign MNO was rejected. */
    public static final FailureCodeEnum CAMPAIGN_MNO_REJECTED =
        new FailureCodeEnum("CAMPAIGN_MNO_REJECTED");

    /** The campaign MNO was suspended. */
    public static final FailureCodeEnum CAMPAIGN_MNO_SUSPENDED =
        new FailureCodeEnum("CAMPAIGN_MNO_SUSPENDED");

    /** The campaign MNO is under review. */
    public static final FailureCodeEnum CAMPAIGN_MNO_REVIEW =
        new FailureCodeEnum("CAMPAIGN_MNO_REVIEW");

    /** Not enough credit in the account. */
    public static final FailureCodeEnum INSUFFICIENT_BALANCE =
        new FailureCodeEnum("INSUFFICIENT_BALANCE");

    /** Provisioning not allowed for mock campaigns. */
    public static final FailureCodeEnum MOCK_CAMPAIGN_NOT_ALLOWED =
        new FailureCodeEnum("MOCK_CAMPAIGN_NOT_ALLOWED");

    /** Toll free numbers not allowed. */
    public static final FailureCodeEnum TFN_NOT_ALLOWED = new FailureCodeEnum("TFN_NOT_ALLOWED");

    /** Invalid NNID. */
    public static final FailureCodeEnum INVALID_NNID = new FailureCodeEnum("INVALID_NNID");

    private static final EnumSupportDynamic<String, FailureCodeEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(
            FailureCodeEnum.class,
            FailureCodeEnum::new,
            Arrays.asList(
                CAMPAIGN_NOT_AVAILABLE,
                EXCEEDED_10_DLC_LIMIT,
                NUMBER_PROVISIONING_FAILED,
                PARTNER_SERVICE_UNAVAILABLE,
                CAMPAIGN_PENDING_ACCEPTANCE,
                MNO_SHARING_ERROR,
                CAMPAIGN_PROVISIONING_FAILED,
                CAMPAIGN_EXPIRED,
                CAMPAIGN_MNO_REJECTED,
                CAMPAIGN_MNO_SUSPENDED,
                CAMPAIGN_MNO_REVIEW,
                INSUFFICIENT_BALANCE,
                MOCK_CAMPAIGN_NOT_ALLOWED,
                TFN_NOT_ALLOWED,
                INVALID_NNID));

    private FailureCodeEnum(String value) {
      super(value);
    }

    public static Stream<FailureCodeEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static FailureCodeEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(FailureCodeEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  /**
   * If the status is FAILED, a failure code will be provided. For numbers provisioning to SMS
   * platform, there won't be any extra <code>failureCode</code>, as the result is binary. For
   * campaign provisioning-related failures, refer to the list for the possible values.
   *
   * @return failureCode
   * @deprecated Use {@link ActiveNumberSinchEvent#getFailureCode()}: the field is defined for
   *     <code>ACTIVE_NUMBER</code> events only
   */
  @Deprecated
  default FailureCodeEnum getFailureCode() {
    return null;
  }

  /**
   * If the status is FAILED, certain processes (eg. number to campaign provisioning) will have an
   * internalFailureCode in the payload. The details of these codes can be found in our dedicated <a
   * href="https://developers.sinch.com/docs/numbers/api-reference/error-codes/provisioning-errors">Provisioning
   * errors</a> documentation.
   *
   * @return internalFailureCode
   * @deprecated Use {@link ActiveNumberSinchEvent#getInternalFailureCode()}: the field is defined
   *     for <code>ACTIVE_NUMBER</code> events only
   */
  @Deprecated
  default String getInternalFailureCode() {
    return null;
  }

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new NumberSinchEventImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param eventId see getter
     * @return Current builder
     * @see #getEventId
     */
    Builder setEventId(String eventId);

    /**
     * see getter
     *
     * @param timestamp see getter
     * @return Current builder
     * @see #getTimestamp
     */
    Builder setTimestamp(Instant timestamp);

    /**
     * see getter
     *
     * @param projectId see getter
     * @return Current builder
     * @see #getProjectId
     */
    Builder setProjectId(String projectId);

    /**
     * see getter
     *
     * @param resourceId see getter
     * @return Current builder
     * @see #getResourceId
     */
    Builder setResourceId(String resourceId);

    /**
     * see getter
     *
     * @param resourceType see getter
     * @return Current builder
     * @see #getResourceType
     */
    Builder setResourceType(ResourceType resourceType);

    /**
     * see getter
     *
     * @param eventType see getter
     * @return Current builder
     * @see #getEventType
     */
    Builder setEventType(EventTypeEnum eventType);

    /**
     * see getter
     *
     * @param status see getter
     * @return Current builder
     * @see #getStatus
     */
    Builder setStatus(StatusEnum status);

    /**
     * see getter
     *
     * @param failureCode see getter
     * @return Current builder
     * @see #getFailureCode
     */
    Builder setFailureCode(FailureCodeEnum failureCode);

    /**
     * see getter
     *
     * @param internalFailureCode see getter
     * @return Current builder
     * @see #getInternalFailureCode
     */
    Builder setInternalFailureCode(String internalFailureCode);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    NumberSinchEvent build();
  }
}
