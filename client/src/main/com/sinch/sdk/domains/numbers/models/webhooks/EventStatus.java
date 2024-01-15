package com.sinch.sdk.domains.numbers.models.webhooks;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

public final class EventStatus extends EnumDynamic<String, EventStatus> {

  /**
   * The status of the event
   *
   * @see <a
   *     href="https://developers.sinch.com/docs/numbers/api-reference/numbers/tag/Callbacks/#tag/Callbacks/operation/ImportedNumberService_EventsCallback!path=status&t=request/">https://developers.sinch.com/docs/numbers/api-reference/numbers/tag/Callbacks/#tag/Callbacks/operation/ImportedNumberService_EventsCallback!path=status&amp;t=request/</a>
   * @since 1.0
   */
  public static final EventStatus SUCCEEDED = new EventStatus("SUCCEEDED");

  public static final EventStatus FAILED = new EventStatus("FAILED");

  private static final EnumSupportDynamic<String, EventStatus> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          EventStatus.class, EventStatus::new, Arrays.asList(SUCCEEDED, FAILED));

  EventStatus(String value) {
    super(value);
  }

  public static Stream<EventStatus> values() {
    return ENUM_SUPPORT.values();
  }

  public static EventStatus from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(EventStatus e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
