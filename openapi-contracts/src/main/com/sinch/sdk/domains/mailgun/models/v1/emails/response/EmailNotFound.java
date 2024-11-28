/*
 * Mailgun API
 *
 * OpenAPI document version: 0.0.0
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.mailgun.models.v1.emails.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/** EmailNotFound */
@JsonDeserialize(builder = EmailNotFoundImpl.Builder.class)
public interface EmailNotFound {

  /**
   * Get message
   *
   * @return message
   */
  String getMessage();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new EmailNotFoundImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param message see getter
     * @return Current builder
     * @see #getMessage
     */
    Builder setMessage(String message);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    EmailNotFound build();
  }
}