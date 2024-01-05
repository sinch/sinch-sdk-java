package com.sinch.sdk.domains.voice.models.requests;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Action to apply on conference participant" */
public class ConferenceManageParticipantCommandType
    extends EnumDynamic<String, ConferenceManageParticipantCommandType> {

  /** Mutes participant */
  public static final ConferenceManageParticipantCommandType MUTE =
      new ConferenceManageParticipantCommandType("mute");

  /** Unmutes participant */
  public static final ConferenceManageParticipantCommandType UNMUTE =
      new ConferenceManageParticipantCommandType("unmute");

  /** Puts participant on hold */
  public static final ConferenceManageParticipantCommandType ONHOLD =
      new ConferenceManageParticipantCommandType("onhold");

  /** Returns participant to conference */
  public static final ConferenceManageParticipantCommandType RESUME =
      new ConferenceManageParticipantCommandType("resume");

  /** */
  private static final EnumSupportDynamic<String, ConferenceManageParticipantCommandType>
      ENUM_SUPPORT =
          new EnumSupportDynamic<>(
              ConferenceManageParticipantCommandType.class,
              ConferenceManageParticipantCommandType::new,
              Arrays.asList(MUTE, UNMUTE, ONHOLD, RESUME));

  private ConferenceManageParticipantCommandType(String value) {
    super(value);
  }

  public static Stream<ConferenceManageParticipantCommandType> values() {
    return ENUM_SUPPORT.values();
  }

  public static ConferenceManageParticipantCommandType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(ConferenceManageParticipantCommandType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
