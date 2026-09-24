package com.sinch.sdk.domains.voice.models.v2.svaml;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;

/** SVAML commands to execute based on message playback outcomes. */
@JsonDeserialize(builder = MessageEventsImpl.Builder.class)
public interface MessageEvents {

  /**
   * Commands to execute when all messages in the sequence have finished playing.
   *
   * @return onFinish
   */
  List<SvamlCommand> getOnFinish();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new MessageEventsImpl.Builder();
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
     * Create instance
     *
     * @return The instance build with current builder values
     */
    MessageEvents build();
  }
}
