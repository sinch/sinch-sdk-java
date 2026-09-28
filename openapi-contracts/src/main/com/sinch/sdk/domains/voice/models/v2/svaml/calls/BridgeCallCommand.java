package com.sinch.sdk.domains.voice.models.v2.svaml.calls;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlCommand;

/**
 * Adds the current call to a bridge, enabling bidirectional audio communication with other calls in
 * the same session. This is a non-blocking command — execution continues to the next command in the
 * sequence immediately after the call joins the bridge.
 *
 * <p>Bridges are created automatically when referenced by name. If a bridge with the specified name
 * already exists, the call joins that bridge; otherwise, a new bridge is created.
 */
@JsonDeserialize(builder = BridgeCallCommandImpl.Builder.class)
public interface BridgeCallCommand extends SvamlCommand {

  /**
   * Name of the bridge to join. If no bridge with this name exists in the session, a new one is
   * created automatically.
   *
   * <p>Field is required
   *
   * @return bridgeName
   */
  String getBridgeName();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new BridgeCallCommandImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param bridgeName see getter
     * @return Current builder
     * @see #getBridgeName
     */
    Builder setBridgeName(String bridgeName);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    BridgeCallCommand build();
  }
}
