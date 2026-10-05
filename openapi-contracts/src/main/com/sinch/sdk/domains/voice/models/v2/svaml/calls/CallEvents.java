package com.sinch.sdk.domains.voice.models.v2.svaml.calls;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlCommand;
import java.util.List;

/** Webhook to handle call events, used when callBehaviors are set to WEBHOOK */
@JsonDeserialize(builder = CallEventsImpl.Builder.class)
public interface CallEvents {

  /**
   * SVAML commands to be executed when the call is answered
   *
   * @return onAnswer
   */
  List<SvamlCommand> getOnAnswer();

  /**
   * SVAML commands to be executed when the call is busy
   *
   * @return onBusy
   */
  List<SvamlCommand> getOnBusy();

  /**
   * SVAML commands to be executed when the call is rejected
   *
   * @return onReject
   */
  List<SvamlCommand> getOnReject();

  /**
   * SVAML commands to be executed when the call is timed out
   *
   * @return onTimeout
   */
  List<SvamlCommand> getOnTimeout();

  /**
   * SVAML commands to be executed when the call is hung up
   *
   * @return onHangup
   */
  List<SvamlCommand> getOnHangup();

  /**
   * SVAML commands to be executed when the call fails
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
    return new CallEventsImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param onAnswer see getter
     * @return Current builder
     * @see #getOnAnswer
     */
    Builder setOnAnswer(List<SvamlCommand> onAnswer);

    /**
     * see getter
     *
     * @param onBusy see getter
     * @return Current builder
     * @see #getOnBusy
     */
    Builder setOnBusy(List<SvamlCommand> onBusy);

    /**
     * see getter
     *
     * @param onReject see getter
     * @return Current builder
     * @see #getOnReject
     */
    Builder setOnReject(List<SvamlCommand> onReject);

    /**
     * see getter
     *
     * @param onTimeout see getter
     * @return Current builder
     * @see #getOnTimeout
     */
    Builder setOnTimeout(List<SvamlCommand> onTimeout);

    /**
     * see getter
     *
     * @param onHangup see getter
     * @return Current builder
     * @see #getOnHangup
     */
    Builder setOnHangup(List<SvamlCommand> onHangup);

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
    CallEvents build();
  }
}
