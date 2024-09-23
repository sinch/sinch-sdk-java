/*
 * Conversation API | Sinch
 *
 * OpenAPI document version: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.v1.messages.types.contactinfo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/** Name information of the contact. */
@JsonDeserialize(builder = NameInfoImpl.Builder.class)
public interface NameInfo {

  /**
   * Full name of the contact
   *
   * @return fullName
   */
  String getFullName();

  /**
   * First name.
   *
   * @return firstName
   */
  String getFirstName();

  /**
   * Last name.
   *
   * @return lastName
   */
  String getLastName();

  /**
   * Middle name.
   *
   * @return middleName
   */
  String getMiddleName();

  /**
   * Prefix before the name. e.g. Mr, Mrs, Dr etc.
   *
   * @return prefix
   */
  String getPrefix();

  /**
   * Suffix after the name.
   *
   * @return suffix
   */
  String getSuffix();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new NameInfoImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param fullName see getter
     * @return Current builder
     * @see #getFullName
     */
    Builder setFullName(String fullName);

    /**
     * see getter
     *
     * @param firstName see getter
     * @return Current builder
     * @see #getFirstName
     */
    Builder setFirstName(String firstName);

    /**
     * see getter
     *
     * @param lastName see getter
     * @return Current builder
     * @see #getLastName
     */
    Builder setLastName(String lastName);

    /**
     * see getter
     *
     * @param middleName see getter
     * @return Current builder
     * @see #getMiddleName
     */
    Builder setMiddleName(String middleName);

    /**
     * see getter
     *
     * @param prefix see getter
     * @return Current builder
     * @see #getPrefix
     */
    Builder setPrefix(String prefix);

    /**
     * see getter
     *
     * @param suffix see getter
     * @return Current builder
     * @see #getSuffix
     */
    Builder setSuffix(String suffix);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    NameInfo build();
  }
}