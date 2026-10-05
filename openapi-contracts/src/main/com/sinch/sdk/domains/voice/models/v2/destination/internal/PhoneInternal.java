package com.sinch.sdk.domains.voice.models.v2.destination.internal;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = PhoneInternalImpl.Builder.class)
public interface PhoneInternal {

  /**
   * E.164 Phone number
   *
   * <p>Field is required
   *
   * @return number
   */
  String getNumber();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new PhoneInternalImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param number see getter
     * @return Current builder
     * @see #getNumber
     */
    Builder setNumber(String number);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    PhoneInternal build();
  }
}
