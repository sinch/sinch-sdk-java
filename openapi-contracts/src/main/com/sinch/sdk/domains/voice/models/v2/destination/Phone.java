package com.sinch.sdk.domains.voice.models.v2.destination;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/** Routes the call to a phone number on the Public Switched Telephone Network (PSTN). */
@JsonDeserialize(builder = PhoneImpl.Builder.class)
public interface Phone extends CallOrigin, CallDestination {

  /**
   * Get phone
   *
   * <p>Field is required
   *
   * @return phone
   */
  PhoneDetails getPhone();

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
     * @param phone see getter
     * @return Current builder
     * @see #getPhone
     */
    Builder setPhone(PhoneDetails phone);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    Phone build();
  }
}
