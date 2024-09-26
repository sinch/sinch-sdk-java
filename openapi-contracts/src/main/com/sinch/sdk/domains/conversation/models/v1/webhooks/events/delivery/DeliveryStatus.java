package com.sinch.sdk.domains.conversation.models.v1.webhooks.events.delivery;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Shows the status of the message or event delivery */
public class DeliveryStatus extends EnumDynamic<String, DeliveryStatus> {

  /** The message has been queued on the corresponding Conversation API channel. */
  public static final DeliveryStatus QUEUED_ON_CHANNEL = new DeliveryStatus("QUEUED_ON_CHANNEL");

  /** The message has been delivered. */
  public static final DeliveryStatus DELIVERED = new DeliveryStatus("DELIVERED");

  /** The message has been read. */
  public static final DeliveryStatus READ = new DeliveryStatus("READ");

  /** Message delivery failed. */
  public static final DeliveryStatus FAILED = new DeliveryStatus("FAILED");

  /** The Conversation API app is switch to a different channel to deliver the message. */
  public static final DeliveryStatus SWITCHING_CHANNEL = new DeliveryStatus("SWITCHING_CHANNEL");

  private static final EnumSupportDynamic<String, DeliveryStatus> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          DeliveryStatus.class,
          DeliveryStatus::new,
          Arrays.asList(QUEUED_ON_CHANNEL, DELIVERED, READ, FAILED, SWITCHING_CHANNEL));

  private DeliveryStatus(String value) {
    super(value);
  }

  public static Stream<DeliveryStatus> values() {
    return ENUM_SUPPORT.values();
  }

  public static DeliveryStatus from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(DeliveryStatus e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
