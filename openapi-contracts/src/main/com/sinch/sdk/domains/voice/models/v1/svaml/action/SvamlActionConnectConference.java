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
import com.sinch.sdk.domains.voice.models.v1.MusicOnHold;
import com.sinch.sdk.domains.voice.models.v1.conferences.ConferenceDtmfOptions;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Connects an incoming call to a conference. Available to use in a response to an <a
 * href="https://developers.sinch.com/docs/voice/api-reference/voice/tag/Callbacks/#tag/Callbacks/operation/ice">Incoming
 * Call Event</a> callback.
 */
@JsonDeserialize(builder = SvamlActionConnectConferenceImpl.Builder.class)
public interface SvamlActionConnectConference
    extends com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlAction {

  /** The name property. Must have the value <code>connectConf</code>. */
  public class NameEnum extends EnumDynamic<String, NameEnum> {
    public static final NameEnum CONNECT_CONF = new NameEnum("connectConf");

    private static final EnumSupportDynamic<String, NameEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(NameEnum.class, NameEnum::new, Arrays.asList(CONNECT_CONF));

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
   * The unique identifier of the conference. Shouldn't exceed 64 characters.
   *
   * @return conferenceId
   */
  String getConferenceId();

  /**
   * Get conferenceDtmfOptions
   *
   * @return conferenceDtmfOptions
   */
  ConferenceDtmfOptions getConferenceDtmfOptions();

  /**
   * Means &quot;music on hold&quot;. If this optional parameter is included, plays music to the
   * first participant in a conference while they're alone and waiting for other participants to
   * join. If <code>moh</code> isn't specified, the user will only hear silence while alone in the
   * conference.
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
    return new SvamlActionConnectConferenceImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param conferenceId see getter
     * @return Current builder
     * @see #getConferenceId
     */
    Builder setConferenceId(String conferenceId);

    /**
     * see getter
     *
     * @param conferenceDtmfOptions see getter
     * @return Current builder
     * @see #getConferenceDtmfOptions
     */
    Builder setConferenceDtmfOptions(ConferenceDtmfOptions conferenceDtmfOptions);

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
    SvamlActionConnectConference build();
  }
}
