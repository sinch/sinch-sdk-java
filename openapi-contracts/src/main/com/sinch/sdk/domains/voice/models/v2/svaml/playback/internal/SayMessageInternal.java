package com.sinch.sdk.domains.voice.models.v2.svaml.playback.internal;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.voice.models.v2.svaml.playback.SayMessage.FormatEnum;

@JsonDeserialize(builder = SayMessageInternalImpl.Builder.class)
public interface SayMessageInternal {

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
    return new SayMessageInternalImpl.Builder();
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
    SayMessageInternal build();
  }
}
