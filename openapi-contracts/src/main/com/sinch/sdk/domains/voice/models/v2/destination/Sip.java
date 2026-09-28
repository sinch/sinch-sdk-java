package com.sinch.sdk.domains.voice.models.v2.destination;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = SipImpl.Builder.class)
public interface Sip extends CallDestination {

  /**
   * Get sip
   *
   * <p>Field is required
   *
   * @return sip
   */
  SipDetails getSip();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new SipImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param sip see getter
     * @return Current builder
     * @see #getSip
     */
    Builder setSip(SipDetails sip);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    Sip build();
  }
}
