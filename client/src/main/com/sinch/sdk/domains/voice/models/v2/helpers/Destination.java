package com.sinch.sdk.domains.voice.models.v2.helpers;

import com.fasterxml.jackson.annotation.JsonValue;
import com.sinch.sdk.domains.voice.models.v2.destination.CallDestination;
import com.sinch.sdk.domains.voice.models.v2.destination.CallOrigin;
import com.sinch.sdk.domains.voice.models.v2.destination.Phone;
import com.sinch.sdk.domains.voice.models.v2.destination.Sip;
import com.sinch.sdk.domains.voice.models.v2.destination.SipFrom;
import com.sinch.sdk.domains.voice.models.v2.destination.Stream;
import com.sinch.sdk.domains.voice.models.v2.destination.VoiceRelay;
import java.util.Objects;

/**
 * Factory helpers for the <code>to</code> and <code>from</code> values of a Voice V2 call
 *
 * <p><code>to</code> takes a {@link CallDestination} and <code>from</code> a {@link CallOrigin}.
 * {@link #of(String)} returns a {@link BaseDestination}, accepted by both.
 *
 * <p>Each factory only sets the required fields. Use the model builders ({@link Sip#builder()},
 * {@link SipFrom#builder()}, {@link Stream#builder()}, {@link VoiceRelay#builder()}) to set the
 * optional ones.
 *
 * @since 2.4
 */
public final class Destination {

  static final String PHONE_PREFIX = "phone:";
  static final String STREAM_PREFIX = "stream:";
  static final String SIP_PREFIX = "sip:";
  static final String SIPS_PREFIX = "sips:";

  private Destination() {}

  /**
   * Create a call endpoint from a string, detecting its type from the prefix
   *
   * <ul>
   *   <li><code>sip:</code> and <code>sips:</code>: SIP endpoint, the URI is kept as given
   *   <li><code>stream:</code>: stream endpoint (only valid as <code>to</code>), prefix removed
   *   <li><code>phone:</code>: phone number, the prefix is removed
   *   <li>Anything else: phone number, the value is kept as given (e.g. a batch placeholder such as
   *       <code>@toNumber</code>)
   * </ul>
   *
   * <p>The result is accepted as both <code>to</code> and <code>from</code>. It only carries the
   * fields found in the string: use the dedicated factories, or the model builders, to set optional
   * fields. A voice relay destination is not built here: it requires a TTS voice and an STT
   * language, see {@link #voiceRelay(String, String, String)}.
   *
   * @param value Endpoint, optionally prefixed with its type
   * @return The phone, SIP or stream endpoint
   * @since 2.4
   */
  public static BaseDestination of(String value) {
    Objects.requireNonNull(value, "value must not be null");
    if (isSip(value)) {
      return new Endpoint(sip(value));
    }
    if (value.startsWith(STREAM_PREFIX)) {
      return new Endpoint(stream(value.substring(STREAM_PREFIX.length())));
    }
    return new Endpoint(phone(withoutPhonePrefix(value)));
  }

  /**
   * Create a phone number on the PSTN, valid as both call destination and call origin
   *
   * @param number Phone number in E.164 format
   * @return The phone destination
   * @since 2.4
   */
  public static Phone phone(String number) {
    Objects.requireNonNull(number, "number must not be null");
    return Phone.builder().setNumber(number).build();
  }

  /**
   * Create a SIP call destination. Only valid as call destination: use {@link #sipFrom(String)} for
   * a call origin
   *
   * @param endpoint SIP URI of the destination endpoint (<code>sip:</code> or <code>sips:</code>
   *     scheme)
   * @return The SIP destination
   * @since 2.4
   */
  public static Sip sip(String endpoint) {
    Objects.requireNonNull(endpoint, "endpoint must not be null");
    return Sip.builder().setEndpoint(endpoint).build();
  }

  /**
   * Create a SIP call origin. Only valid as call origin: use {@link #sip(String)} for a call
   * destination
   *
   * @param endpoint SIP URI of the originating endpoint (<code>sip:</code> or <code>sips:</code>
   *     scheme)
   * @return The SIP origin
   * @since 2.4
   */
  public static SipFrom sipFrom(String endpoint) {
    Objects.requireNonNull(endpoint, "endpoint must not be null");
    return SipFrom.builder().setEndpoint(endpoint).build();
  }

  /**
   * Create a WebSocket stream call destination
   *
   * @param endpoint WebSocket URL (<code>ws://</code> or <code>wss://</code>) accepting the
   *     connection
   * @return The stream destination
   * @since 2.4
   */
  public static Stream stream(String endpoint) {
    Objects.requireNonNull(endpoint, "endpoint must not be null");
    return Stream.builder().setEndpoint(endpoint).build();
  }

  /**
   * Create a Voice Relay call destination
   *
   * @param endpoint URL of the server accepting the WebSocket request
   * @param ttsVoice Default voice for speech synthesis
   * @param sttLanguage BCP-47 language tag used to transcribe the inbound audio
   * @return The Voice Relay destination
   * @since 2.4
   */
  public static VoiceRelay voiceRelay(String endpoint, String ttsVoice, String sttLanguage) {
    Objects.requireNonNull(endpoint, "endpoint must not be null");
    Objects.requireNonNull(ttsVoice, "ttsVoice must not be null");
    Objects.requireNonNull(sttLanguage, "sttLanguage must not be null");
    return VoiceRelay.builder()
        .setEndpoint(endpoint)
        .setTtsVoice(ttsVoice)
        .setSttLanguage(sttLanguage)
        .build();
  }

  private static boolean isSip(String value) {
    return value.startsWith(SIP_PREFIX) || value.startsWith(SIPS_PREFIX);
  }

  private static String withoutPhonePrefix(String value) {
    return value.startsWith(PHONE_PREFIX) ? value.substring(PHONE_PREFIX.length()) : value;
  }

  /**
   * {@link BaseDestination} around a generated destination model. Serialized as the wrapped model,
   * so the JSON is the one of the {@link Phone}, {@link Sip} or {@link Stream} it holds.
   */
  static final class Endpoint implements BaseDestination {

    private final Object destination;

    Endpoint(Object destination) {
      this.destination = destination;
    }

    @JsonValue
    Object getDestination() {
      return destination;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      return destination.equals(((Endpoint) o).destination);
    }

    @Override
    public int hashCode() {
      return destination.hashCode();
    }

    @Override
    public String toString() {
      return destination.toString();
    }
  }
}
