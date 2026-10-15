package com.sinch.sdk.domains.voice.models.v2.svaml.calls;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlCommand;

/**
 * Answers an inbound call leg. This is a non-blocking command — execution continues to the next
 * command in the sequence immediately after the answer is initiated.
 */
@JsonDeserialize(builder = AnswerCommandImpl.Builder.class)
public interface AnswerCommand extends SvamlCommand {

  /** Default answer command, to be used instead of building an empty one */
  AnswerCommand ANSWER_COMMAND = AnswerCommand.builder().build();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new AnswerCommandImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    AnswerCommand build();
  }
}
