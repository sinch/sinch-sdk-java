package com.sinch.sdk.domains.voice.models.v2.services;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * No call behavior is configured for the service. Incoming calls will not be handled and outbound
 * calls can still be initiated via the API.
 */
@JsonDeserialize(builder = NoneCallBehaviorImpl.Builder.class)
public interface NoneCallBehavior extends CallBehavior {

  /** Default none call behavior, to be used instead of building an empty one */
  NoneCallBehavior NONE_CALL_BEHAVIOR = NoneCallBehavior.builder().build();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new NoneCallBehaviorImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    NoneCallBehavior build();
  }
}
