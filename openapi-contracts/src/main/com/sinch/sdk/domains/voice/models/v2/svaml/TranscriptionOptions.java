package com.sinch.sdk.domains.voice.models.v2.svaml;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/** Configuration for automatic speech-to-text transcription of the recording. */
@JsonDeserialize(builder = TranscriptionOptionsImpl.Builder.class)
public interface TranscriptionOptions {

  /**
   * If true, the recording will be transcribed to text.
   *
   * <p>Field is required
   *
   * @return isEnabled
   */
  Boolean getIsEnabled();

  /**
   * Language code in BCP-47 format.
   *
   * @return locale
   */
  String getLocale();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new TranscriptionOptionsImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param isEnabled see getter
     * @return Current builder
     * @see #getIsEnabled
     */
    Builder setIsEnabled(Boolean isEnabled);

    /**
     * see getter
     *
     * @param locale see getter
     * @return Current builder
     * @see #getLocale
     */
    Builder setLocale(String locale);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    TranscriptionOptions build();
  }
}
