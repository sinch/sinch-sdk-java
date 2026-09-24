package com.sinch.sdk.domains.voice.models.v2.destination;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;

@JsonDeserialize(builder = StreamDetailsImpl.Builder.class)
public interface StreamDetails {

  /**
   * WebSocket endpoint that will accept the incoming connection for real-time audio streaming. Must
   * be a valid WebSocket URL using either <code>ws://</code> or <code>wss://</code> (recommended).
   * The URL must be reachable from the public internet and capable of handling the negotiated
   * stream protocol.
   *
   * <p>Field is required
   *
   * @return endpoint
   */
  String getEndpoint();

  /**
   * Get streamOptions
   *
   * @return streamOptions
   */
  StreamOptions getStreamOptions();

  /**
   * Custom headers to be sent in the call setup.
   *
   * @return callHeaders
   */
  List<CallHeader> getCallHeaders();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new StreamDetailsImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param endpoint see getter
     * @return Current builder
     * @see #getEndpoint
     */
    Builder setEndpoint(String endpoint);

    /**
     * see getter
     *
     * @param streamOptions see getter
     * @return Current builder
     * @see #getStreamOptions
     */
    Builder setStreamOptions(StreamOptions streamOptions);

    /**
     * see getter
     *
     * @param callHeaders see getter
     * @return Current builder
     * @see #getCallHeaders
     */
    Builder setCallHeaders(List<CallHeader> callHeaders);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    StreamDetails build();
  }
}
