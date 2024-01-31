package com.sinch.sdk.domains.voice.models.webhooks;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** The status of a call */
public class AmdAnswerStatusType extends EnumDynamic<String, AmdAnswerStatusType> {

  /** An answering machine was detected as answering the call. */
  public static final AmdAnswerStatusType MACHINE = new AmdAnswerStatusType("machine");

  /** A human was detected as answering the call. */
  public static final AmdAnswerStatusType HUMAN = new AmdAnswerStatusType("human");

  /** The system was unable to determine who answered the call. */
  public static final AmdAnswerStatusType NOTSURE = new AmdAnswerStatusType("notsure");

  /** The call was hung up. */
  public static final AmdAnswerStatusType HANGUP = new AmdAnswerStatusType("hangup");

  private static final EnumSupportDynamic<String, AmdAnswerStatusType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          AmdAnswerStatusType.class,
          AmdAnswerStatusType::new,
          Arrays.asList(MACHINE, HUMAN, NOTSURE, HANGUP));

  private AmdAnswerStatusType(String value) {
    super(value);
  }

  public static Stream<AmdAnswerStatusType> values() {
    return ENUM_SUPPORT.values();
  }

  public static AmdAnswerStatusType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(AmdAnswerStatusType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
