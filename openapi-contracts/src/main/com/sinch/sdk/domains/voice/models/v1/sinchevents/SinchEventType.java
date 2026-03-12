package com.sinch.sdk.domains.voice.models.v1.sinchevents;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Gets or Sets webhooksEventRequestType */
public class SinchEventType extends EnumDynamic<String, SinchEventType> {

  /**
   * An Incoming Call Event is a type of event sent to your server when a phone number assigned to
   * your Voice application receives an incoming call.
   */
  public static final SinchEventType ICE = new SinchEventType("ice");

  /**
   * An Answered Call Event is a type of event sent to your server when an outgoing call made by
   * your Voice application is answered.
   */
  public static final SinchEventType ACE = new SinchEventType("ace");

  /**
   * A Disconnected Call Event is a type of event sent to your server when a call is disconnected.
   */
  public static final SinchEventType DICE = new SinchEventType("dice");

  /**
   * A Prompt Input Event is a type of event sent to your server when a prompt input is submitted.
   */
  public static final SinchEventType PIE = new SinchEventType("pie");

  /**
   * A Notification Event is a type of event sent to your server when a particular action occurs,
   * such as a recording starting or finishing.
   */
  public static final SinchEventType NOTIFY = new SinchEventType("notify");

  private static final EnumSupportDynamic<String, SinchEventType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          SinchEventType.class, SinchEventType::new, Arrays.asList(ICE, ACE, DICE, PIE, NOTIFY));

  private SinchEventType(String value) {
    super(value);
  }

  public static Stream<SinchEventType> values() {
    return ENUM_SUPPORT.values();
  }

  public static SinchEventType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(SinchEventType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
