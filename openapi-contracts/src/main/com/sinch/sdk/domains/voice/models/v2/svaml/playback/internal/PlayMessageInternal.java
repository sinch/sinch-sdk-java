package com.sinch.sdk.domains.voice.models.v2.svaml.playback.internal;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = PlayMessageInternalImpl.Builder.class)
public interface PlayMessageInternal {

  /**
   * URL of the media to send
   *
   * <p>Field is required
   *
   * @return url
   */
  String getUrl();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new PlayMessageInternalImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param url see getter
     * @return Current builder
     * @see #getUrl
     */
    Builder setUrl(String url);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    PlayMessageInternal build();
  }
}
