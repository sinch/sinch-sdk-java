package com.sinch.sdk.domains.voice.models.v2.helpers;

import com.sinch.sdk.domains.voice.models.v2.services.EventDestinationCallBehavior;
import com.sinch.sdk.domains.voice.models.v2.services.EventDestinationConfiguration;
import com.sinch.sdk.domains.voice.models.v2.services.NoneCallBehavior;
import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlCommand;
import java.util.Collection;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * Helpers to build the call behavior of a Voice V2 service, used to create or update it
 *
 * @since 2.4
 */
public final class CallBehaviorHelper {

  private CallBehaviorHelper() {}

  /**
   * No call behavior: incoming calls are not handled. Outbound calls can still be started with the
   * API
   *
   * @return The <code>NONE</code> call behavior
   * @since 2.4
   */
  public static NoneCallBehavior none() {
    return NoneCallBehavior.NONE_CALL_BEHAVIOR;
  }

  /**
   * Calls are handled by sending Sinch Events to the backend, which answers with the commands that
   * control the call
   *
   * @param url URL the events are sent to
   * @return The event destination call behavior, sent as <code>WEBHOOK</code>
   * @since 2.4
   */
  public static EventDestinationCallBehavior eventDestination(String url) {
    Objects.requireNonNull(url, "url must not be null");
    return EventDestinationCallBehavior.builder()
        .setEventDestination(EventDestinationConfiguration.builder().setUrl(url).build())
        .build();
  }

  /**
   * Calls are handled by sending Sinch Events to the backend, with a fallback URL
   *
   * @param url URL the events are sent to
   * @param fallbackUrl URL a failed request is sent to
   * @return The event destination call behavior, sent as <code>WEBHOOK</code>
   * @see #eventDestination(String)
   * @since 2.4
   */
  public static EventDestinationCallBehavior eventDestination(String url, String fallbackUrl) {
    Objects.requireNonNull(url, "url must not be null");
    Objects.requireNonNull(fallbackUrl, "fallbackUrl must not be null");
    return EventDestinationCallBehavior.builder()
        .setEventDestination(
            EventDestinationConfiguration.builder().setUrl(url).setFallbackUrl(fallbackUrl).build())
        .build();
  }

  /**
   * Calls are handled by the same commands, with no backend involved
   *
   * <p>Named <code>staticBehavior</code>: <code>static</code> is a reserved word in Java.
   *
   * @param commands Commands run for every call of the service
   * @return The creator of the <code>STATIC</code> call behavior
   * @since 2.4
   */
  public static StaticCallBehaviorCreator staticBehavior(SvamlCommand... commands) {
    return new StaticCallBehaviorCreator(Commands.append(null, commands));
  }

  /**
   * Calls are handled by the same commands, with no backend involved
   *
   * @param commands Commands run for every call of the service
   * @return The creator of the <code>STATIC</code> call behavior
   * @see #staticBehavior(SvamlCommand...)
   * @since 2.4
   */
  public static StaticCallBehaviorCreator staticBehavior(
      Collection<? extends SvamlCommand> commands) {
    return new StaticCallBehaviorCreator(Commands.append(null, commands));
  }

  /**
   * Calls are handled by the same commands, with no backend involved
   *
   * @param sequence Lambda adding the commands run for every call of the service
   * @return The creator of the <code>STATIC</code> call behavior
   * @see #staticBehavior(SvamlCommand...)
   * @since 2.4
   */
  public static StaticCallBehaviorCreator staticBehavior(
      Consumer<CommandsSequenceCreator> sequence) {
    return new StaticCallBehaviorCreator(Commands.append(null, sequence));
  }
}
