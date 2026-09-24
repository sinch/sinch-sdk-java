package com.sinch.sdk.domains.voice.models.v2.destination;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = PhoneDetailsImpl.Builder.class)
public interface PhoneDetails {

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
    return new PhoneDetailsImpl.Builder();
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
    PhoneDetails build();
  }
}
