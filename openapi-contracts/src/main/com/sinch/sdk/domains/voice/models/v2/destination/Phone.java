package com.sinch.sdk.domains.voice.models.v2.destination;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/** Routes the call to a phone number on the Public Switched Telephone Network (PSTN). */
@JsonDeserialize(builder = PhoneImpl.Builder.class)
public interface Phone extends CallOrigin, CallDestination {

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
    return new PhoneImpl.Builder();
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
    Phone build();
  }
}
