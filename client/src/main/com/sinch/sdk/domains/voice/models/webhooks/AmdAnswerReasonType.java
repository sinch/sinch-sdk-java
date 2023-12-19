package com.sinch.sdk.domains.voice.models.webhooks;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** The reason that the system used to determine who answered the call. */
public class AmdAnswerReasonType extends EnumDynamic<String, AmdAnswerReasonType> {

  /** If the greeting is too long, this could be indicative of an answering machine. */
  public static final AmdAnswerReasonType LONG_GREETING = new AmdAnswerReasonType("longgreeting");

  /**
   * If there is an initial silence after the call is answered before the greeting starts, this
   * could be indicative of an answering machine.
   */
  public static final AmdAnswerReasonType INITIAL_SILENCE =
      new AmdAnswerReasonType("initialsilence");

  private static final EnumSupportDynamic<String, AmdAnswerReasonType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          AmdAnswerReasonType.class,
          AmdAnswerReasonType::new,
          Arrays.asList(LONG_GREETING, INITIAL_SILENCE));

  private AmdAnswerReasonType(String value) {
    super(value);
  }

  public static Stream<AmdAnswerReasonType> values() {
    return ENUM_SUPPORT.values();
  }

  public static AmdAnswerReasonType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(AmdAnswerReasonType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
