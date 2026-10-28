package com.sinch.sdk.domains.voice.models.v2.helpers;

/**
 * Helpers to build the Answering Machine Detection SVAML command
 *
 * @since 2.4
 */
public final class Amd {

  private Amd() {}

  /**
   * Detect what answered the call: a human, a machine, a beep, or an unknown result
   *
   * <p>Detection runs in parallel with the next commands. Set the commands to run for each result
   * on the returned creator.
   *
   * @return The creator of the <code>amd</code> command
   * @since 2.4
   */
  public static AmdCreator activate() {
    return new AmdCreator();
  }
}
