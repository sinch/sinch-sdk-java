/*
 * Voice API | Sinch
 *
 * OpenAPI document version: 1.0.1
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.voice.models.v1.destination;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.voice.models.v1.calls.response.CallInformationFrom;
import com.sinch.sdk.domains.voice.models.v1.calls.response.CallInformationTo;

/** The type of device and number or endpoint to call. */
@JsonDeserialize(builder = DestinationPstnImpl.Builder.class)
public interface DestinationPstn
    extends Destination,
        DestinationConference,
        DestinationCustom,
        DestinationTextToSpeech,
        CallInformationFrom,
        CallInformationTo {

  /** Static builder helper */
  static DestinationPstn from(String endPoint) {
    return DestinationPstn.builder().setEndpoint(endPoint).build();
  }

  /**
   * If the type is <code>number</code> the value of the endpoint is a phone number.
   *
   * @return endpoint
   */
  String getEndpoint();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new DestinationPstnImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param endpoint see getter
     * @return Current builder
     * @see #getEndpoint
     */
    Builder setEndpoint(String endpoint);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    DestinationPstn build();
  }
}
