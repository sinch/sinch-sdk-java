package com.sinch.sdk.domains.voice.models.v2.svaml.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlInput;

/** Request payload for describing a SVAML document before using it in a call. */
@JsonDeserialize(builder = DescribeSvamlRequestImpl.Builder.class)
public interface DescribeSvamlRequest {

  /**
   * The SVAML payload to describe.
   *
   * <p>Field is required
   *
   * @return svaml
   */
  SvamlInput getSvaml();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new DescribeSvamlRequestImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param svaml see getter
     * @return Current builder
     * @see #getSvaml
     */
    Builder setSvaml(SvamlInput svaml);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    DescribeSvamlRequest build();
  }
}
