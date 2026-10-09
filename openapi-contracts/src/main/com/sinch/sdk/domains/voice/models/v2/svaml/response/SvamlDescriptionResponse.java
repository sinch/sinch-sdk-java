package com.sinch.sdk.domains.voice.models.v2.svaml.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/** Response containing a human-readable description of the SVAML call flow. */
@JsonDeserialize(builder = SvamlDescriptionResponseImpl.Builder.class)
public interface SvamlDescriptionResponse {

  /**
   * Human-readable description of the call flow.
   *
   * @return description
   */
  String getDescription();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new SvamlDescriptionResponseImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param description see getter
     * @return Current builder
     * @see #getDescription
     */
    Builder setDescription(String description);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    SvamlDescriptionResponse build();
  }
}
