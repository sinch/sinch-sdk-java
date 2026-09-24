package com.sinch.sdk.domains.voice.models.v2.destination;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = SipFromDetailsImpl.Builder.class)
public interface SipFromDetails {

  /**
   * SIP URI of the originating endpoint. Both <code>sip:</code> (unencrypted) and <code>sips:
   * </code> (TLS-encrypted) schemes are supported.
   *
   * <p>Field is required
   *
   * @return endpoint
   */
  String getEndpoint();

  /**
   * Display name presented to the called party as the caller identity. Transmitted as the display
   * name part of the SIP <code>From</code> header (for example, <code>
   * Alice &lt;sip:alice&#64;example.com&gt;</code>).
   *
   * @return displayName
   */
  String getDisplayName();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new SipFromDetailsImpl.Builder();
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
     * @param displayName see getter
     * @return Current builder
     * @see #getDisplayName
     */
    Builder setDisplayName(String displayName);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    SipFromDetails build();
  }
}
