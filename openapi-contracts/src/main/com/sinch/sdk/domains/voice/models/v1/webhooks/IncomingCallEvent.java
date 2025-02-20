/*
 * Voice API | Sinch
 *
 * OpenAPI document version: 1.0.1
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.voice.models.v1.webhooks;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.voice.models.v1.Domain;
import com.sinch.sdk.domains.voice.models.v1.Price;
import com.sinch.sdk.domains.voice.models.v1.destination.Destination;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.CallHeader;
import java.time.Instant;
import java.util.List;

/** The request body of an Incoming Call Event. */
@JsonDeserialize(builder = IncomingCallEventImpl.Builder.class)
public interface IncomingCallEvent extends VoiceWebhookEvent, VoiceWebhookCallEvent {

  /**
   * The timestamp in UTC format.
   *
   * @return timestamp
   */
  Instant getTimestamp();

  /**
   * A string that can be used to pass custom information related to the call.
   *
   * @return custom
   */
  String getCustom();

  /**
   * The unique application key. You can find it in the Sinch <a
   * href="https://dashboard.sinch.com/voice/apps">dashboard</a>.
   *
   * @return applicationKey
   */
  String getApplicationKey();

  /**
   * The path of the API resource.
   *
   * @return callResourceUrl
   */
  String getCallResourceUrl();

  /**
   * Get userRate
   *
   * @return userRate
   */
  Price getUserRate();

  /**
   * The number that will be displayed to the recipient of the call. To set your own CLI, you may
   * use your verified number or your Dashboard virtual number and add it to the <code>connectPSTN
   * </code> SVAML response to the Incoming Call Event request. It must be in <a
   * href="https://community.sinch.com/t5/Glossary/E-164/ta-p/7537">E.164</a> format.
   *
   * @return cli
   */
  String getCli();

  /**
   * Get to
   *
   * @return to
   */
  Destination getTo();

  /**
   * Get domain
   *
   * @return domain
   */
  Domain getDomain();

  /**
   * Get originationType
   *
   * @return originationType
   */
  Domain getOriginationType();

  /**
   * The duration of the call in seconds.
   *
   * @return duration
   */
  Integer getDuration();

  /**
   * The redirected dialled number identification service.
   *
   * @return rdnis
   */
  String getRdnis();

  /**
   * If the call is initiated by a Sinch SDK client, call headers are the headers specified by the
   * <em>caller</em> client. Read more about call headers <a
   * href="https://developers.sinch.com/docs/voice/api-reference/call-headers">here</a>.
   *
   * @return callHeaders
   */
  List<CallHeader> getCallHeaders();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new IncomingCallEventImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder extends VoiceWebhookEvent.Builder<Builder>, VoiceWebhookCallEvent.Builder {

    /**
     * see getter
     *
     * @param timestamp see getter
     * @return Current builder
     * @see #getTimestamp
     */
    Builder setTimestamp(Instant timestamp);

    /**
     * see getter
     *
     * @param custom see getter
     * @return Current builder
     * @see #getCustom
     */
    Builder setCustom(String custom);

    /**
     * see getter
     *
     * @param applicationKey see getter
     * @return Current builder
     * @see #getApplicationKey
     */
    Builder setApplicationKey(String applicationKey);

    /**
     * see getter
     *
     * @param callResourceUrl see getter
     * @return Current builder
     * @see #getCallResourceUrl
     */
    Builder setCallResourceUrl(String callResourceUrl);

    /**
     * see getter
     *
     * @param userRate see getter
     * @return Current builder
     * @see #getUserRate
     */
    Builder setUserRate(Price userRate);

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
     * @param to see getter
     * @return Current builder
     * @see #getTo
     */
    Builder setTo(Destination to);

    /**
     * see getter
     *
     * @param domain see getter
     * @return Current builder
     * @see #getDomain
     */
    Builder setDomain(Domain domain);

    /**
     * see getter
     *
     * @param originationType see getter
     * @return Current builder
     * @see #getOriginationType
     */
    Builder setOriginationType(Domain originationType);

    /**
     * see getter
     *
     * @param duration see getter
     * @return Current builder
     * @see #getDuration
     */
    Builder setDuration(Integer duration);

    /**
     * see getter
     *
     * @param rdnis see getter
     * @return Current builder
     * @see #getRdnis
     */
    Builder setRdnis(String rdnis);

    /**
     * see getter
     *
     * @param callHeaders see getter
     * @return Current builder
     * @see #getCallHeaders
     */
    Builder setCallHeaders(List<CallHeader> callHeaders);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    IncomingCallEvent build();
  }
}
