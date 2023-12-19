package com.sinch.sdk.domains.numbers.models.webhooks;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * The type of the event
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/numbers/api-reference/numbers/tag/Callbacks/#tag/Callbacks/operation/ImportedNumberService_EventsCallback!path=eventType&t=request">https://developers.sinch.com/docs/numbers/api-reference/numbers/tag/Callbacks/#tag/Callbacks/operation/ImportedNumberService_EventsCallback!path=eventType&amp;t=request</a>
 * @since 1.0
 */
public final class EventType extends EnumDynamic<String, EventType> {

  /** An event that occurs when a number is linked to a Service Plan ID. */
  public static final EventType PROVISIONING_TO_SMS_PLATFORM =
      new EventType("PROVISIONING_TO_SMS_PLATFORM");

  /** An event that occurs when a number is unlinked from a Service Plan ID */
  public static final EventType DEPROVISIONING_FROM_SMS_PLATFORM =
      new EventType("DEPROVISIONING_FROM_SMS_PLATFORM");

  /** An event that occurs when a number is linked to a Campaign */
  public static final EventType PROVISIONING_TO_CAMPAIGN =
      new EventType("PROVISIONING_TO_CAMPAIGN");

  /** An event that occurs when a number is unlinked from a Campaign */
  public static final EventType DEPROVISIONING_FROM_CAMPAIGN =
      new EventType("DEPROVISIONING_FROM_CAMPAIGN");

  /** An event that occurs when a number is enabled for Voice operations. */
  public static final EventType PROVISIONING_TO_VOICE_PLATFORM =
      new EventType("PROVISIONING_TO_VOICE_PLATFORM");

  /** An event that occurs when a number is disabled for Voice operations */
  public static final EventType DEPROVISIONING_TO_VOICE_PLATFORM =
      new EventType("DEPROVISIONING_TO_VOICE_PLATFORM");

  private static final EnumSupportDynamic<String, EventType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          EventType.class,
          EventType::new,
          Arrays.asList(
              PROVISIONING_TO_SMS_PLATFORM,
              DEPROVISIONING_FROM_SMS_PLATFORM,
              PROVISIONING_TO_CAMPAIGN,
              DEPROVISIONING_FROM_CAMPAIGN,
              PROVISIONING_TO_VOICE_PLATFORM,
              DEPROVISIONING_TO_VOICE_PLATFORM));

  EventType(String value) {
    super(value);
  }

  public static Stream<EventType> values() {
    return ENUM_SUPPORT.values();
  }

  public static EventType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(EventType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
