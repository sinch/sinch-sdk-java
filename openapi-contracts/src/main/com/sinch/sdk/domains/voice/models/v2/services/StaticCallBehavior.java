package com.sinch.sdk.domains.voice.models.v2.services;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlInput;

/**
 * Calls are handled using a predefined static SVAML script. The commands are executed for every
 * call on this service, without any backend involvement.
 */
@JsonDeserialize(builder = StaticCallBehaviorImpl.Builder.class)
public interface StaticCallBehavior extends CallBehavior {

  /**
   * Predefined SVAML commands executed for every call on this service.
   *
   * <p>Field is required
   *
   * @return static
   */
  SvamlInput getStatic();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new StaticCallBehaviorImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param _static see getter
     * @return Current builder
     * @see #getStatic
     */
    Builder setStatic(SvamlInput _static);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    StaticCallBehavior build();
  }
}
