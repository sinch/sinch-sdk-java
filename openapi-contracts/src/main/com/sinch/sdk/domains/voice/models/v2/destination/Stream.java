package com.sinch.sdk.domains.voice.models.v2.destination;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/** Routes the call to a WebSocket stream endpoint for real-time audio processing. */
@JsonDeserialize(builder = StreamImpl.Builder.class)
public interface Stream extends CallDestination {

  /**
   * Get stream
   *
   * <p>Field is required
   *
   * @return stream
   */
  StreamDetails getStream();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new StreamImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param stream see getter
     * @return Current builder
     * @see #getStream
     */
    Builder setStream(StreamDetails stream);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    Stream build();
  }
}
