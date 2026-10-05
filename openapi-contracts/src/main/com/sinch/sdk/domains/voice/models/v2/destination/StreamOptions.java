package com.sinch.sdk.domains.voice.models.v2.destination;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;

@JsonDeserialize(builder = StreamOptionsImpl.Builder.class)
public interface StreamOptions {

  /** Gets or Sets codec */
  public class CodecEnum extends EnumDynamic<String, CodecEnum> {
    public static final CodecEnum PCM = new CodecEnum("PCM");

    private static final EnumSupportDynamic<String, CodecEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(CodecEnum.class, CodecEnum::new, Arrays.asList(PCM));

    private CodecEnum(String value) {
      super(value);
    }

    public static java.util.stream.Stream<CodecEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static CodecEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(CodecEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  /** Gets or Sets sampleRate */
  public class SampleRateEnum extends EnumDynamic<Integer, SampleRateEnum> {
    public static final SampleRateEnum HZ_8000 = new SampleRateEnum(8000);

    public static final SampleRateEnum HZ_16000 = new SampleRateEnum(16000);

    public static final SampleRateEnum HZ_24000 = new SampleRateEnum(24000);

    public static final SampleRateEnum HZ_44100 = new SampleRateEnum(44100);

    public static final SampleRateEnum HZ_48000 = new SampleRateEnum(48000);

    public static final SampleRateEnum HZ_96000 = new SampleRateEnum(96000);

    private static final EnumSupportDynamic<Integer, SampleRateEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(
            SampleRateEnum.class,
            SampleRateEnum::new,
            Arrays.asList(HZ_8000, HZ_16000, HZ_24000, HZ_44100, HZ_48000, HZ_96000));

    private SampleRateEnum(Integer value) {
      super(value);
    }

    public static java.util.stream.Stream<SampleRateEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static SampleRateEnum from(Integer value) {
      return ENUM_SUPPORT.from(value);
    }

    public static Integer valueOf(SampleRateEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  /**
   * Defines the version of the stream protocol.
   *
   * @return version
   */
  Integer getVersion();

  /**
   * Defines the audio codec/format used for the stream audio payload.
   *
   * <p>Currently, only <code>PCM</code> is supported (uncompressed raw audio). Use <code>sampleRate
   * </code> to configure the sampling rate for the stream.
   *
   * @return codec
   */
  CodecEnum getCodec();

  /**
   * Defines the audio sampling rate (Hz) used for the stream.
   *
   * <p>For calls that traverse the PSTN, audio is typically sampled at 8 kHz, so using a higher
   * value will not improve perceived quality. Higher sample rates can be useful for non-PSTN
   * scenarios (for example, SIP/streaming paths), but will increase bandwidth usage and processing
   * load.
   *
   * @return sampleRate
   */
  SampleRateEnum getSampleRate();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new StreamOptionsImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param version see getter
     * @return Current builder
     * @see #getVersion
     */
    Builder setVersion(Integer version);

    /**
     * see getter
     *
     * @param codec see getter
     * @return Current builder
     * @see #getCodec
     */
    Builder setCodec(CodecEnum codec);

    /**
     * see getter
     *
     * @param sampleRate see getter
     * @return Current builder
     * @see #getSampleRate
     */
    Builder setSampleRate(SampleRateEnum sampleRate);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    StreamOptions build();
  }
}
