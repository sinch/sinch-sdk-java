package com.sinch.sdk.domains.voice.models.v2.svaml.recording;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** The type of recording to perform. */
public class RecordingType extends EnumDynamic<String, RecordingType> {
  /** Record inbound and outbound voice streams. */
  public static final RecordingType COMBINED = new RecordingType("COMBINED");

  /** Record inbound voice stream only. */
  public static final RecordingType INBOUND = new RecordingType("INBOUND");

  /** Record outbound voice stream only. */
  public static final RecordingType OUTBOUND = new RecordingType("OUTBOUND");

  private static final EnumSupportDynamic<String, RecordingType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          RecordingType.class, RecordingType::new, Arrays.asList(COMBINED, INBOUND, OUTBOUND));

  private RecordingType(String value) {
    super(value);
  }

  public static Stream<RecordingType> values() {
    return ENUM_SUPPORT.values();
  }

  public static RecordingType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(RecordingType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
