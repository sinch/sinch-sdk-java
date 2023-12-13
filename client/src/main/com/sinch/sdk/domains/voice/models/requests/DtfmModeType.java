package com.sinch.sdk.domains.voice.models.requests;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Determines what DTMF mode the participant will use in the call. */
public class DtfmModeType extends EnumDynamic<String, DtfmModeType> {

  /**
   * Nothing is done with the participant's DTMF signals. This is the default mode. Any DTMF signals
   * that the participant sends can still be heard by all participants, but no action will be
   * performed.
   */
  public static final DtfmModeType IGNORE = new DtfmModeType("ignore");

  /** The participant's DTMF signals are forwarded to all other participants in the conference */
  public static final DtfmModeType FORWARD = new DtfmModeType("forward");

  /**
   * The participant's DTMF signals are detected by the conference and sent to your backend server
   * using a Prompt Input Event (PIE) callback.
   *
   * @see <a
   *     href="https://developers.sinch.com/docs/voice/api-reference/voice/tag/Callbacks/#tag/Callbacks/operation/pie">Prompt
   *     Input Event (PIE)</a>
   */
  public static final DtfmModeType DETECT = new DtfmModeType("detect");

  /** */
  private static final EnumSupportDynamic<String, DtfmModeType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          DtfmModeType.class, DtfmModeType::new, Arrays.asList(IGNORE, FORWARD, DETECT));

  private DtfmModeType(String value) {
    super(value);
  }

  public static Stream<DtfmModeType> values() {
    return ENUM_SUPPORT.values();
  }

  public static DtfmModeType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(DtfmModeType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
