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

/** Data Response */
@JsonDeserialize(builder = VerificationStartResponseDataImpl.Builder.class)
public interface VerificationStartResponseData
    extends com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponse {

  /**
   * Verification identifier used to query for status.
   *
   * @return id
   */
  String getId();

  /**
   * Get links
   *
   * @return links
   */
  List<Link> getLinks();

  /**
   * The target URI.
   *
   * @return targetUri
   */
  String getTargetUri();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new VerificationStartResponseDataImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder
      extends com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponse
          .Builder {

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
     * @param links see getter
     * @return Current builder
     * @see #getLinks
     */
    Builder setLinks(List<Link> links);

    /**
     * see getter
     *
     * @param targetUri see getter
     * @return Current builder
     * @see #getTargetUri
     */
    Builder setTargetUri(String targetUri);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    VerificationStartResponseData build();
  }
}
