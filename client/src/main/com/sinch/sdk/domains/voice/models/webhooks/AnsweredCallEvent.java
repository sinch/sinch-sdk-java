package com.sinch.sdk.domains.voice.models.webhooks;

import java.time.Instant;

/**
 * This callback is made when the call is picked up by the callee (person receiving the call).
 *
 * <p>It's a POST request to the specified calling callback URL. Look here for allowed {@link
 * com.sinch.sdk.domains.voice.models.svaml.Action instructions} and {@link
 * com.sinch.sdk.domains.voice.models.svaml.Instruction actions}.
 *
 * <p>If there is no response to the callback within the timeout period, the call is connected.
 *
 * <p>If you have Answering Machine Detection (<a
 * href="https://developers.sinch.com/docs/voice/api-reference/amd_v2">AMD</a>) enabled, the amd
 * object will also be present on ACE callbacks.
 *
 * <p>Note: ACE Callbacks are not issued for InApp Calls (destination: username), only PSTN and SIP
 * calls.
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/voice/api-reference/voice/tag/Callbacks/#tag/Callbacks/operation/ace">ACE</a>
 */
public class AnsweredCallEvent extends CallEvent {

  private final AmdAnswer amd;

  private AnsweredCallEvent(
      String callId, Instant timestamp, Integer version, String custom, AmdAnswer amd) {
    super(callId, timestamp, version, custom);
    this.amd = amd;
  }

  /**
   * If Answering Machine Detection is enabled, this object contains information about whether the
   * call was answered by a machine.
   *
   * @return AMD Answer value
   */
  public AmdAnswer getAmd() {
    return amd;
  }

  @Override
  public String toString() {
    return "AnsweredCallEvent{" + "amd=" + amd + "} " + super.toString();
  }

  public static Builder<?> builder() {
    return new Builder<>();
  }

  public static class Builder<B extends Builder<B>> extends CallEvent.Builder<Builder<B>> {

    AmdAnswer amd;

    public Builder<B> setAmd(AmdAnswer amd) {
      this.amd = amd;
      return this;
    }

    public AnsweredCallEvent build() {
      return new AnsweredCallEvent(callId, timestamp, version, custom, amd);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }
  }
}
