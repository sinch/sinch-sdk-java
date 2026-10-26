package com.sinch.sdk.domains.voice.models.v2.helpers;

import com.sinch.sdk.domains.voice.models.v2.svaml.customevents.CustomEventCommand;
import java.util.Objects;

/**
 * Helpers to build the custom event SVAML command
 *
 * @since 2.4
 */
public final class CustomEvents {

  private CustomEvents() {}

  /**
   * Send a mid-call event to the application backend, which answers with the commands that control
   * the rest of the call
   *
   * <p>The sequence waits for the backend answer before running the next command.
   *
   * <p>The backend receives a <code>call.webhook.&lt;name&gt;</code> event. Once parsed by the SDK,
   * its type is <code>call.customEvent.&lt;name&gt;</code>.
   *
   * @param name Name of the custom event, sent as <code>webhookName</code>
   * @param url URL the event is sent to
   * @return The <code>customEvent</code> command
   * @since 2.4
   */
  public static CustomEventCommand trigger(String name, String url) {
    Objects.requireNonNull(name, "name must not be null");
    Objects.requireNonNull(url, "url must not be null");
    return CustomEventCommand.builder().setCustomEventName(name).setUrl(url).build();
  }

  /**
   * Send a mid-call event to the application backend, with a fallback URL
   *
   * @param name Name of the custom event, sent as <code>webhookName</code>
   * @param url URL the event is sent to
   * @param fallbackUrl URL a failed request is sent to
   * @return The <code>customEvent</code> command
   * @see #trigger(String, String)
   * @since 2.4
   */
  public static CustomEventCommand trigger(String name, String url, String fallbackUrl) {
    Objects.requireNonNull(name, "name must not be null");
    Objects.requireNonNull(url, "url must not be null");
    Objects.requireNonNull(fallbackUrl, "fallbackUrl must not be null");
    return CustomEventCommand.builder()
        .setCustomEventName(name)
        .setUrl(url)
        .setFallbackUrl(fallbackUrl)
        .build();
  }
}
