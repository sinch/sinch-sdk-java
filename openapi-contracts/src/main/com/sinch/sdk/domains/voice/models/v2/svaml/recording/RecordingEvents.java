package com.sinch.sdk.domains.voice.models.v2.svaml.recording;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlCommand;
import java.util.List;

/** SVAML commands to execute based on recording lifecycle outcomes. */
@JsonDeserialize(builder = RecordingEventsImpl.Builder.class)
public interface RecordingEvents {

  /**
   * Commands to execute when the recording is successfully stopped. Note that this does not mean
   * that the file is delivered to the configured destination yet.
   *
   * @return onFinish
   */
  List<SvamlCommand> getOnFinish();

  /**
   * Commands to execute if the recording fails to start. If omitted, failures are silently ignored
   * and the call flow continues.
   *
   * @return onFailure
   */
  List<SvamlCommand> getOnFailure();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new RecordingEventsImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param onFinish see getter
     * @return Current builder
     * @see #getOnFinish
     */
    Builder setOnFinish(List<SvamlCommand> onFinish);

    /**
     * see getter
     *
     * @param onFailure see getter
     * @return Current builder
     * @see #getOnFailure
     */
    Builder setOnFailure(List<SvamlCommand> onFailure);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    RecordingEvents build();
  }
}
