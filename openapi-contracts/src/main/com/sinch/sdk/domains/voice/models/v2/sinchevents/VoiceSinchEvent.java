package com.sinch.sdk.domains.voice.models.v2.sinchevents;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.voice.models.v2.Call;

/** The event payload delivered by the Voice Platform to the Sinch Events endpoint. */
@JsonDeserialize(builder = VoiceSinchEventImpl.Builder.class)
public interface VoiceSinchEvent {

  /**
   * Identifies the type of call event that triggered this Sinch Event notification.
   *
   * <p>Call-related events always start with <code>call.</code> followed by the type of event that
   * triggered them. Events triggered by the <code>customEvent</code> SVAML command are dynamic and
   * follow the pattern <code>call.customEvent.&lt;customEventName&gt;</code>.
   *
   * <p>Field is required
   *
   * @return event
   */
  SinchEventType getEvent();

  /**
   * The current state of the call at the time the event was triggered.
   *
   * <p>Field is required
   *
   * @return call
   */
  Call getCall();

  /**
   * Information about the menu interaction that triggered the Sinch Event. Present for <code>
   * call.menu</code> events, and for <code>call.customEvent.&lt;customEventName&gt;</code> events
   * triggered within a menu context.
   *
   * @return menu
   */
  MenuInput getMenu();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new VoiceSinchEventImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param event see getter
     * @return Current builder
     * @see #getEvent
     */
    Builder setEvent(SinchEventType event);

    /**
     * see getter
     *
     * @param call see getter
     * @return Current builder
     * @see #getCall
     */
    Builder setCall(Call call);

    /**
     * see getter
     *
     * @param menu see getter
     * @return Current builder
     * @see #getMenu
     */
    Builder setMenu(MenuInput menu);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    VoiceSinchEvent build();
  }
}
