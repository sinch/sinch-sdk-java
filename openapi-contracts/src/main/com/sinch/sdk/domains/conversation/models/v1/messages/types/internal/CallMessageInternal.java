/*
 * Conversation API | Sinch
 *
 * OpenAPI document version: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.v1.messages.types.internal;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/** Call Message */
@JsonDeserialize(builder = CallMessageInternalImpl.Builder.class)
public interface CallMessageInternal {

  /**
   * Phone number in E.164 with leading +.
   *
   * @return phoneNumber
   */
  String getPhoneNumber();

  /**
   * Title shown close to the phone number. The title is clickable in some cases.
   *
   * @return title
   */
  String getTitle();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new CallMessageInternalImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param phoneNumber see getter
     * @return Current builder
     * @see #getPhoneNumber
     */
    Builder setPhoneNumber(String phoneNumber);

    /**
     * see getter
     *
     * @param title see getter
     * @return Current builder
     * @see #getTitle
     */
    Builder setTitle(String title);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    CallMessageInternal build();
  }
}
