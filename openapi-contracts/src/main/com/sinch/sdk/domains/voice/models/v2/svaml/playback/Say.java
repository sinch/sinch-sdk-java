package com.sinch.sdk.domains.voice.models.v2.svaml.playback;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

@JsonDeserialize(builder = SayImpl.Builder.class)
public interface Say {

  /** Gets or Sets format */
  public class FormatEnum extends EnumDynamic<String, FormatEnum> {
    public static final FormatEnum TEXT = new FormatEnum("TEXT");

    public static final FormatEnum SSML = new FormatEnum("SSML");

    private static final EnumSupportDynamic<String, FormatEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(FormatEnum.class, FormatEnum::new, Arrays.asList(TEXT, SSML));

    private FormatEnum(String value) {
      super(value);
    }

    public static Stream<FormatEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static FormatEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(FormatEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  /**
   * The text to be synthesized into speech.
   *
   * <p>If <code>format</code> is <code>TEXT</code> (default), provide plain text. If <code>format
   * </code> is <code>SSML</code>, provide a valid SSML document (for example, <code>
   * &lt;speak&gt;...&lt;/speak&gt;</code>).
   *
   * <p>Field is required
   *
   * @return text
   */
  String getText();

  /**
   * Format of the message
   *
   * @return format
   */
  FormatEnum getFormat();

  /**
   * The name of the voice to use for text-to-speech synthesis.
   *
   * <p>Supported voices include: Emma, Brian, and others. For a complete list of available voices
   * and their characteristics, see the Text-to-Speech Voices documentation.
   *
   * <p>Field is required
   *
   * @return voiceName
   */
  String getVoiceName();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new SayImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param text see getter
     * @return Current builder
     * @see #getText
     */
    Builder setText(String text);

    /**
     * see getter
     *
     * @param format see getter
     * @return Current builder
     * @see #getFormat
     */
    Builder setFormat(FormatEnum format);

    /**
     * see getter
     *
     * @param voiceName see getter
     * @return Current builder
     * @see #getVoiceName
     */
    Builder setVoiceName(String voiceName);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    Say build();
  }
}
