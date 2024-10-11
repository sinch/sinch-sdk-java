/*
 * Voice API | Sinch
 *
 * OpenAPI document version: 1.0.1
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.voice.models.v1.svaml.action;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import com.sinch.sdk.domains.voice.models.v1.Destination;
import com.sinch.sdk.domains.voice.models.v1.MusicOnHold;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Determines how to route a call to a SIP server. Available to use in a response to an <a
 * href="https://developers.sinch.com/docs/voice/api-reference/voice/tag/Callbacks/#tag/Callbacks/operation/ice">Incoming
 * Call Event</a> callback.
 */
@JsonDeserialize(builder = SvamlActionConnectSipImpl.Builder.class)
public interface SvamlActionConnectSip
    extends com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlAction {

  /** The name property. Must have the value <code>connectSip</code>. */
  public class NameEnum extends EnumDynamic<String, NameEnum> {
    public static final NameEnum CONNECT_SIP = new NameEnum("connectSip");

    private static final EnumSupportDynamic<String, NameEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(NameEnum.class, NameEnum::new, Arrays.asList(CONNECT_SIP));

    private NameEnum(String value) {
      super(value);
    }

    public static Stream<NameEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static NameEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(NameEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  /**
   * Get destination
   *
   * @return destination
   */
  Destination getDestination();

  /**
   * The max duration of the call in seconds (max 14400 seconds). If the call is still connected at
   * that time, it will be automatically disconnected.
   *
   * @return maxDuration
   */
  Integer getMaxDuration();

  /**
   * Used to override the CLI (or caller ID) of the client. The phone number of the person who
   * initiated the call is shown as the CLI. To set your own CLI, you may use your verified number
   * or your Dashboard virtual number.
   *
   * @return cli
   */
  String getCli();

  /** An optional parameter to specify the SIP transport protocol. If unspecified, UDP is used. */
  public class TransportEnum extends EnumDynamic<String, TransportEnum> {
    public static final TransportEnum UDP = new TransportEnum("UDP");
    public static final TransportEnum TCP = new TransportEnum("TCP");
    public static final TransportEnum TLS = new TransportEnum("TLS");

    private static final EnumSupportDynamic<String, TransportEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(
            TransportEnum.class, TransportEnum::new, Arrays.asList(UDP, TCP, TLS));

    private TransportEnum(String value) {
      super(value);
    }

    public static Stream<TransportEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static TransportEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(TransportEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  /**
   * An optional parameter to specify the SIP transport protocol. If unspecified, UDP is used.
   *
   * @return transport
   */
  TransportEnum getTransport();

  /**
   * If enabled, suppresses <a
   * href="https://developers.sinch.com/docs/voice/api-reference/voice/tag/Callbacks/#tag/Callbacks/operation/ace">ACE</a>
   * and <a
   * href="https://developers.sinch.com/docs/voice/api-reference/voice/tag/Callbacks/#tag/Callbacks/operation/dice">DICE</a>
   * callbacks for the call.
   *
   * @return suppressCallbacks
   */
  Boolean getSuppressCallbacks();

  /**
   * <a
   * href="https://developers.sinch.com/docs/voice/api-reference/sip-trunking/#receiving-calls-from-sinch-platform-to-your-sip-infrastructure">Private
   * SIP headers</a> to send with the call.
   *
   * @return callHeaders
   */
  List<CallHeader> getCallHeaders();

  /**
   * Means &quot;music on hold&quot;. If this optional parameter is included, plays music to the
   * connected participant if the SIP call is placed on hold. If <code>moh</code> isn't specified
   * and the SIP call is placed on hold, the user will only hear silence while during the holding
   * period .
   *
   * @return MusicOnHold
   */
  MusicOnHold getMusicOnHold();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new SvamlActionConnectSipImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param destination see getter
     * @return Current builder
     * @see #getDestination
     */
    Builder setDestination(Destination destination);

    /**
     * see getter
     *
     * @param maxDuration see getter
     * @return Current builder
     * @see #getMaxDuration
     */
    Builder setMaxDuration(Integer maxDuration);

    /**
     * see getter
     *
     * @param cli see getter
     * @return Current builder
     * @see #getCli
     */
    Builder setCli(String cli);

    /**
     * see getter
     *
     * @param transport see getter
     * @return Current builder
     * @see #getTransport
     */
    Builder setTransport(TransportEnum transport);

    /**
     * see getter
     *
     * @param suppressCallbacks see getter
     * @return Current builder
     * @see #getSuppressCallbacks
     */
    Builder setSuppressCallbacks(Boolean suppressCallbacks);

    /**
     * see getter
     *
     * @param callHeaders see getter
     * @return Current builder
     * @see #getCallHeaders
     */
    Builder setCallHeaders(List<CallHeader> callHeaders);

    /**
     * see getter
     *
     * @param MusicOnHold see getter
     * @return Current builder
     * @see #getMusicOnHold
     */
    Builder setMusicOnHold(MusicOnHold MusicOnHold);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    SvamlActionConnectSip build();
  }
}
