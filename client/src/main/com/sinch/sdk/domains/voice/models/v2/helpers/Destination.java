package com.sinch.sdk.domains.voice.models.v2.helpers;

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
   * Create a call destination from a string, detecting its type from the prefix
   *
   * <ul>
   *   <li><code>sip:</code> and <code>sips:</code>: {@link Sip} destination, the endpoint is kept
   *       as given
   *   <li><code>stream:</code>: {@link Stream} destination, the prefix is removed
   *   <li><code>phone:</code>: {@link Phone} destination, the prefix is removed
   *   <li>Anything else: {@link Phone} destination, the value is kept as given (e.g. a batch
   *       placeholder such as <code>@toNumber</code>)
   * </ul>
   *
   * <p>A voice relay destination is not built here: it requires a TTS voice and an STT language,
   * see {@link #voiceRelay(String, String, String)}.
   *
   * @param destination Destination, optionally prefixed with its type
   * @return The phone, SIP or stream destination
   * @see #originOf(String)
   * @since 2.4
   */
  public static CallDestination of(String destination) {
    Objects.requireNonNull(destination, "destination must not be null");
    if (isSip(destination)) {
      return sip(destination);
    }
    if (destination.startsWith(STREAM_PREFIX)) {
      return stream(destination.substring(STREAM_PREFIX.length()));
    }
    return phone(withoutPhonePrefix(destination));
  }

  /**
   * Create a call origin from a string, detecting its type from the prefix
   *
   * <ul>
   *   <li><code>sip:</code> and <code>sips:</code>: {@link SipFrom} origin, the endpoint is kept as
   *       given
   *   <li><code>phone:</code>: {@link Phone} origin, the prefix is removed
   *   <li>Anything else: {@link Phone} origin, the value is kept as given
   * </ul>
   *
   * @param origin Origin, optionally prefixed with its type
   * @return The phone or SIP origin
   * @throws IllegalArgumentException if <code>origin</code> is a <code>stream:</code> endpoint: a
   *     stream can only be a call destination
   * @see #of(String)
   * @since 2.4
   */
  public static CallOrigin originOf(String origin) {
    Objects.requireNonNull(origin, "origin must not be null");
    if (isSip(origin)) {
      return sipFrom(origin);
    }
    if (origin.startsWith(STREAM_PREFIX)) {
      throw new IllegalArgumentException(
          "A stream endpoint can only be a call destination, not an origin: " + origin);
    }
    return phone(withoutPhonePrefix(origin));
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
}
