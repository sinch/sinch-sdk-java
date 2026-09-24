package com.sinch.sdk.domains.voice.models.v2.calls.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlCommand;
import java.util.List;

/** Request to start a single outbound call. */
@JsonDeserialize(builder = StartCallRequestImpl.Builder.class)
public interface StartCallRequest {

  /**
   * An ordered list of SVAML v2 (Sinch Voice Application Markup Language) commands that describe a
   * call flow. Commands are executed sequentially in the order they are defined.
   *
   * <p>Blocking vs. non-blocking: Some commands block execution until they complete (<code>pause
   * </code>, <code>webhook</code>, <code>menu</code>, <code>gotoMenu</code>), while others return
   * immediately and run in parallel (<code>dial</code>, <code>messages</code>, <code>amd</code>,
   * <code>answer</code>, <code>hangup</code>, <code>startRecording</code>, <code>stopRecording
   * </code>, <code>bridgeCall</code>, <code>stopMessages</code>). Each command's description
   * specifies its behavior.
   *
   * <p>Nesting scope: Commands that appear inside event handlers (e.g., <code>dial.events.onAnswer
   * </code>, <code>messages.events.onFinish</code>) form independent sequences and execute in their
   * own context — they are not continuations of the parent sequence.
   *
   * <p>Field is required
   *
   * @return commands
   */
  List<SvamlCommand> getCommands();

  /**
   * The ID of the service to use for the call. If omitted, the project's default service is used.
   *
   * <p>Sent as the <code>serviceId</code> query parameter.
   *
   * @return serviceId
   */
  String getServiceId();

  /**
   * Client-generated idempotency key to safely retry requests. The server uses this key to
   * recognize retries of the same request. If a request with the same key is received within 10
   * minutes, the server returns the cached response from the original request. Using a random UUID
   * (v4) is strongly recommended.
   *
   * <p>Sent as the <code>Idempotency-Key</code> header. If not set, the SDK generates a random UUID
   * for each call. Whether set or generated, the same key is sent on every automatic retry of that
   * call.
   *
   * @return idempotencyKey
   */
  String getIdempotencyKey();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new StartCallRequestImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param commands see getter
     * @return Current builder
     * @see #getCommands
     */
    Builder setCommands(List<SvamlCommand> commands);

    /**
     * see getter
     *
     * @param serviceId see getter
     * @return Current builder
     * @see #getServiceId
     */
    Builder setServiceId(String serviceId);

    /**
     * see getter
     *
     * @param idempotencyKey see getter
     * @return Current builder
     * @see #getIdempotencyKey
     */
    Builder setIdempotencyKey(String idempotencyKey);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    StartCallRequest build();
  }
}
