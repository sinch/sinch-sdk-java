/*
 *
 */

package com.sinch.sdk.domains.voice.models.v1.svaml.action;

/**
 * @deprecated use {@link
 *     com.sinch.sdk.domains.voice.models.v1.svaml.action.AnsweringMachineDetectionQuery} instead.
 */
@Deprecated
public interface ConnectPstnAnsweringMachineDetection extends AnsweringMachineDetectionQuery {

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new ConnectPstnAnsweringMachineDetectionImpl.Builder();
  }

  /**
   * Dedicated Builder
   *
   * @deprecated use {@link
   *     com.sinch.sdk.domains.voice.models.v1.svaml.action.AnsweringMachineDetectionQuery} instead.
   */
  @Deprecated
  interface Builder extends AnsweringMachineDetectionQuery.Builder {

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    ConnectPstnAnsweringMachineDetection build();
  }
}
