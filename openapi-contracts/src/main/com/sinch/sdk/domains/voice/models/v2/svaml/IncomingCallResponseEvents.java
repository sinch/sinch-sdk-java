package com.sinch.sdk.domains.voice.models.v2.svaml;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;

/** Commands to execute on specific events for this call. */
@JsonDeserialize(builder = IncomingCallResponseEventsImpl.Builder.class)
public interface IncomingCallResponseEvents {

  /**
   * SVAML commands to be executed when the call is hung up.
   *
   * @return onHangup
   */
  List<SvamlCommand> getOnHangup();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new IncomingCallResponseEventsImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param onHangup see getter
     * @return Current builder
     * @see #getOnHangup
     */
    Builder setOnHangup(List<SvamlCommand> onHangup);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    IncomingCallResponseEvents build();
  }
}
