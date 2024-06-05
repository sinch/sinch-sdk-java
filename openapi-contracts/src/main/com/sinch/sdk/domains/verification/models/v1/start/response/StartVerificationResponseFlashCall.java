/*
 * Verification | Sinch
 * Verify users with SMS, flash calls (missed calls), a regular call, or data verification.
 *
 * The version of the OpenAPI document: 2.0.1
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.verification.models.v1.start.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;

/** declaration */
@JsonDeserialize(builder = StartVerificationResponseFlashCallImpl.Builder.class)
public interface StartVerificationResponseFlashCall
    extends com.sinch.sdk.domains.verification.models.v1.response.StartVerificationResponse {

  /**
   * Verification identifier used to query for status.
   *
   * @return id
   */
  String getId();

  /**
   * The value of the method used for the Verification. For flash call Verifications, this will
   * always be &#x60;flashcall&#x60;.
   *
   * @return method
   */
  String getMethod();

  /**
   * Get flashCall
   *
   * @return flashCall
   */
  StartVerificationResponseFlashCallContent getFlashCall();

  /**
   * Get links
   *
   * @return links
   */
  List<Link> getLinks();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new StartVerificationResponseFlashCallImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

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
     * @param method see getter
     * @return Current builder
     * @see #getMethod
     */
    Builder setMethod(String method);

    /**
     * see getter
     *
     * @param flashCall see getter
     * @return Current builder
     * @see #getFlashCall
     */
    Builder setFlashCall(StartVerificationResponseFlashCallContent flashCall);

    /**
     * see getter
     *
     * @param links see getter
     * @return Current builder
     * @see #getLinks
     */
    Builder setLinks(List<Link> links);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    StartVerificationResponseFlashCall build();
  }
}
