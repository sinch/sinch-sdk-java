package com.sinch.sdk.domains.conversation.models.v1.eventdestinations;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Gets or Sets WebhookTargetType */
public class EventDestinationTargetType extends EnumDynamic<String, EventDestinationTargetType> {

  /** Events won't be sent. */
  public static final EventDestinationTargetType DISMISS =
      new EventDestinationTargetType("DISMISS");

  /** Events will be sent to an HTTP target. */
  public static final EventDestinationTargetType HTTP = new EventDestinationTargetType("HTTP");

  private static final EnumSupportDynamic<String, EventDestinationTargetType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          EventDestinationTargetType.class,
          EventDestinationTargetType::new,
          Arrays.asList(DISMISS, HTTP));

  private EventDestinationTargetType(String value) {
    super(value);
  }

  public static Stream<EventDestinationTargetType> values() {
    return ENUM_SUPPORT.values();
  }

  public static EventDestinationTargetType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(EventDestinationTargetType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
