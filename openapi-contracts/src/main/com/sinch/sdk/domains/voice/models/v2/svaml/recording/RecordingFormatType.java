package com.sinch.sdk.domains.voice.models.v2.svaml.recording;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Audio format for this recording. */
public class RecordingFormatType extends EnumDynamic<String, RecordingFormatType> {
  /** MPEG Audio Layer III compressed audio format. */
  public static final RecordingFormatType MP3 = new RecordingFormatType("MP3");

  /** Waveform Audio File Format, uncompressed audio. */
  public static final RecordingFormatType WAV = new RecordingFormatType("WAV");

  private static final EnumSupportDynamic<String, RecordingFormatType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          RecordingFormatType.class, RecordingFormatType::new, Arrays.asList(MP3, WAV));

  private RecordingFormatType(String value) {
    super(value);
  }

  public static Stream<RecordingFormatType> values() {
    return ENUM_SUPPORT.values();
  }

  public static RecordingFormatType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(RecordingFormatType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
