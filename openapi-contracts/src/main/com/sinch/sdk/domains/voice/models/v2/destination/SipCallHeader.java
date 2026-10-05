package com.sinch.sdk.domains.voice.models.v2.destination;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/** Custom SIP headers to be sent in the call setup. */
@JsonDeserialize(builder = SipCallHeaderImpl.Builder.class)
public interface SipCallHeader {

  /**
   * Name of the SIP header.
   *
   * <p>Field is required
   *
   * @return key
   */
  String getKey();

  /**
   * Value of the SIP header.
   *
   * @return value
   */
  String getValue();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new SipCallHeaderImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param key see getter
     * @return Current builder
     * @see #getKey
     */
    Builder setKey(String key);

    /**
     * see getter
     *
     * @param value see getter
     * @return Current builder
     * @see #getValue
     */
    Builder setValue(String value);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    SipCallHeader build();
  }
}
