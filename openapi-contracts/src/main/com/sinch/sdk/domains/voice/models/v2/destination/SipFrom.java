package com.sinch.sdk.domains.voice.models.v2.destination;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = SipFromImpl.Builder.class)
public interface SipFrom extends CallOrigin {

  /**
   * Get sip
   *
   * <p>Field is required
   *
   * @return sip
   */
  SipFromDetails getSip();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new SipFromImpl.Builder();
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
    Builder setSip(SipFromDetails sip);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    SipFrom build();
  }
}
