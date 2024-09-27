package com.sinch.sdk.domains.conversation.models.v1;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Gets or Sets ReasonSubCode */
public class ReasonSubCode extends EnumDynamic<String, ReasonSubCode> {

  /**
   * UNSPECIFIED_SUB_CODE is used if no other sub code can be used to describe the encountered
   * error.
   */
  public static final ReasonSubCode UNSPECIFIED_SUB_CODE =
      new ReasonSubCode("UNSPECIFIED_SUB_CODE");

  /**
   * The message attachment was rejected by the channel due to a policy. Some channels have specific
   * policies that must be met to receive an attachment.
   */
  public static final ReasonSubCode ATTACHMENT_REJECTED = new ReasonSubCode("ATTACHMENT_REJECTED");

  /** The specified media urls media type could not be determined. */
  public static final ReasonSubCode MEDIA_TYPE_UNDETERMINED =
      new ReasonSubCode("MEDIA_TYPE_UNDETERMINED");

  /**
   * The used credentials for the underlying channel is inactivated and not allowed to send or
   * receive messages.
   */
  public static final ReasonSubCode INACTIVE_SENDER = new ReasonSubCode("INACTIVE_SENDER");

  private static final EnumSupportDynamic<String, ReasonSubCode> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          ReasonSubCode.class,
          ReasonSubCode::new,
          Arrays.asList(
              UNSPECIFIED_SUB_CODE, ATTACHMENT_REJECTED, MEDIA_TYPE_UNDETERMINED, INACTIVE_SENDER));

  private ReasonSubCode(String value) {
    super(value);
  }

  public static Stream<ReasonSubCode> values() {
    return ENUM_SUPPORT.values();
  }

  public static ReasonSubCode from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(ReasonSubCode e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
