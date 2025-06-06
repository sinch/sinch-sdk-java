/*
 * Voice API | Sinch
 *
 * OpenAPI document version: 1.0.1
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.voice.models.v1.conferences;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/** ConferenceParticipant */
@JsonDeserialize(builder = ConferenceParticipantImpl.Builder.class)
public interface ConferenceParticipant {

  /**
   * The phone number of the PSTN participant that was connected in the conference, or whatever was
   * passed as CLI for data originated/terminated calls.
   *
   * @return cli
   */
  String getCli();

  /**
   * The callId of the call leg that the participant joined the conference.
   *
   * @return id
   */
  String getId();

  /**
   * The number of seconds that the participant has been connected to the conference.
   *
   * @return duration
   */
  Integer getDuration();

  /**
   * Get muted
   *
   * @return muted
   */
  Boolean getMuted();

  /**
   * Get OnHold
   *
   * @return OnHold
   */
  Boolean getOnHold();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new ConferenceParticipantImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

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
     * @param id see getter
     * @return Current builder
     * @see #getId
     */
    Builder setId(String id);

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
     * @param muted see getter
     * @return Current builder
     * @see #getMuted
     */
    Builder setMuted(Boolean muted);

    /**
     * see getter
     *
     * @param OnHold see getter
     * @return Current builder
     * @see #getOnHold
     */
    Builder setOnHold(Boolean OnHold);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    ConferenceParticipant build();
  }
}
