package com.sinch.sdk.domains.voice.models.v2.svaml.amd;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlCommand;
import java.util.List;

/**
 * SVAML commands to execute based on the answering machine detection result. These events define
 * different call flows depending on whether a human, machine, beep, or unknown entity answers the
 * call.
 */
@JsonDeserialize(builder = AmdEventsImpl.Builder.class)
public interface AmdEvents {

  /**
   * SVAML commands to be executed when a human is detected
   *
   * @return onHuman
   */
  List<SvamlCommand> getOnHuman();

  /**
   * SVAML commands to be executed when a machine is detected
   *
   * @return onMachine
   */
  List<SvamlCommand> getOnMachine();

  /**
   * SVAML commands to be executed when a beep is detected
   *
   * @return onBeep
   */
  List<SvamlCommand> getOnBeep();

  /**
   * SVAML commands to be executed when an unknown event is detected
   *
   * @return onUnknown
   */
  List<SvamlCommand> getOnUnknown();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new AmdEventsImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param onHuman see getter
     * @return Current builder
     * @see #getOnHuman
     */
    Builder setOnHuman(List<SvamlCommand> onHuman);

    /**
     * see getter
     *
     * @param onMachine see getter
     * @return Current builder
     * @see #getOnMachine
     */
    Builder setOnMachine(List<SvamlCommand> onMachine);

    /**
     * see getter
     *
     * @param onBeep see getter
     * @return Current builder
     * @see #getOnBeep
     */
    Builder setOnBeep(List<SvamlCommand> onBeep);

    /**
     * see getter
     *
     * @param onUnknown see getter
     * @return Current builder
     * @see #getOnUnknown
     */
    Builder setOnUnknown(List<SvamlCommand> onUnknown);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    AmdEvents build();
  }
}
