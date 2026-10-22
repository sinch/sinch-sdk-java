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
import java.util.function.Consumer;

/**
 * Factory helpers for the <code>to</code> and <code>from</code> values of a Voice V2 call
 *
 * <p><code>to</code> takes a {@link CallDestination} and <code>from</code> a {@link CallOrigin}.
 * {@link #of(String)} returns a {@link BaseDestination}, accepted by both.
 *
 * <p>Each factory takes the required fields. Its lambda overload sets the optional ones on the
 * model builder, e.g. <code>sip(endpoint, sip -&gt; sip.setTransport(...))</code>.
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
   * fields found in the string: use the dedicated factories to set optional fields.
   *
   * <p>A voice relay destination is not built here, as it requires a TTS voice and an STT language:
   * use the <code>voiceRelay</code> factories.
   *
   * <p>The result is meant to build requests. It wraps the generated model and serializes as it,
   * but it is neither an instance of {@link Phone}, {@link Sip} or {@link Stream}, nor equal to the
   * model returned by the dedicated factories. Use them when the typed model is needed.
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
    return sip(endpoint, sip -> {});
  }

  /**
   * Create a SIP call destination with optional fields, e.g. the transport or the call headers
   *
   * @param endpoint SIP URI of the destination endpoint (<code>sip:</code> or <code>sips:</code>
   *     scheme)
   * @param sip Lambda setting the optional fields on the model builder, which already holds the
   *     endpoint
   * @return The SIP destination
   * @since 2.4
   */
  public static Sip sip(String endpoint, Consumer<Sip.Builder> sip) {
    Objects.requireNonNull(endpoint, "endpoint must not be null");
    Sip.Builder builder = Sip.builder().setEndpoint(endpoint);
    Objects.requireNonNull(sip, "sip must not be null").accept(builder);
    return builder.build();
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
    return sipFrom(endpoint, sipFrom -> {});
  }

  /**
   * Create a SIP call origin with optional fields, e.g. the display name
   *
   * @param endpoint SIP URI of the originating endpoint (<code>sip:</code> or <code>sips:</code>
   *     scheme)
   * @param sipFrom Lambda setting the optional fields on the model builder, which already holds the
   *     endpoint
   * @return The SIP origin
   * @since 2.4
   */
  public static SipFrom sipFrom(String endpoint, Consumer<SipFrom.Builder> sipFrom) {
    Objects.requireNonNull(endpoint, "endpoint must not be null");
    SipFrom.Builder builder = SipFrom.builder().setEndpoint(endpoint);
    Objects.requireNonNull(sipFrom, "sipFrom must not be null").accept(builder);
    return builder.build();
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
    return stream(endpoint, stream -> {});
  }

  /**
   * Create a WebSocket stream call destination with optional fields, e.g. the stream options or the
   * call headers
   *
   * @param endpoint WebSocket URL (<code>ws://</code> or <code>wss://</code>) accepting the
   *     connection
   * @param stream Lambda setting the optional fields on the model builder, which already holds the
   *     endpoint
   * @return The stream destination
   * @since 2.4
   */
  public static Stream stream(String endpoint, Consumer<Stream.Builder> stream) {
    Objects.requireNonNull(endpoint, "endpoint must not be null");
    Stream.Builder builder = Stream.builder().setEndpoint(endpoint);
    Objects.requireNonNull(stream, "stream must not be null").accept(builder);
    return builder.build();
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
    return voiceRelay(endpoint, ttsVoice, sttLanguage, voiceRelay -> {});
  }

  /**
   * Create a Voice Relay call destination with optional fields, e.g. the interruptions or the call
   * headers
   *
   * @param endpoint URL of the server accepting the WebSocket request
   * @param ttsVoice Default voice for speech synthesis
   * @param sttLanguage BCP-47 language tag used to transcribe the inbound audio
   * @param voiceRelay Lambda setting the optional fields on the model builder, which already holds
   *     the required ones
   * @return The Voice Relay destination
   * @since 2.4
   */
  public static VoiceRelay voiceRelay(
      String endpoint,
      String ttsVoice,
      String sttLanguage,
      Consumer<VoiceRelay.Builder> voiceRelay) {
    Objects.requireNonNull(endpoint, "endpoint must not be null");
    Objects.requireNonNull(ttsVoice, "ttsVoice must not be null");
    Objects.requireNonNull(sttLanguage, "sttLanguage must not be null");
    VoiceRelay.Builder builder =
        VoiceRelay.builder()
            .setEndpoint(endpoint)
            .setTtsVoice(ttsVoice)
            .setSttLanguage(sttLanguage);
    Objects.requireNonNull(voiceRelay, "voiceRelay must not be null").accept(builder);
    return builder.build();
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
