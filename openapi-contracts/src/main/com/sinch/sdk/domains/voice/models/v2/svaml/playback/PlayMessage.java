package com.sinch.sdk.domains.voice.models.v2.svaml.playback;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * An audio file playback message item. The platform fetches and plays the audio file at the
 * provided URL on the call.
 */
@JsonDeserialize(builder = PlayMessageImpl.Builder.class)
public interface PlayMessage extends Message {

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
    return new PlayMessageImpl.Builder();
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
    PlayMessage build();
  }
}
