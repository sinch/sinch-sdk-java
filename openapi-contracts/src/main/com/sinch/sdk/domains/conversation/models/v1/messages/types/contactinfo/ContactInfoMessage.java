/*
 * Conversation API | Sinch
 * Send and receive messages globally over SMS, RCS, WhatsApp, Viber Business, Facebook messenger and other popular channels using the Sinch Conversation API.  The Conversation API endpoint uses built-in transcoding to give you the power of conversation across all supported channels and, if required, full control over channel specific features.
 *
 * The version of the OpenAPI document: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.v1.messages.types.contactinfo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.LocalDate;
import java.util.List;

/** Message containing contact information. */
@JsonDeserialize(builder = ContactInfoMessageImpl.Builder.class)
public interface ContactInfoMessage
    extends com.sinch.sdk.domains.conversation.models.v1.messages.OmniMessageOverride,
        com.sinch.sdk.domains.conversation.models.v1.messages.AppMessageBody {

  /**
   * Get name
   *
   * @return name
   */
  NameInfo getName();

  /**
   * Phone numbers of the contact
   *
   * @return phoneNumbers
   */
  List<PhoneNumberInfo> getPhoneNumbers();

  /**
   * Physical addresses of the contact
   *
   * @return addresses
   */
  List<AddressInfo> getAddresses();

  /**
   * Email addresses of the contact
   *
   * @return emailAddresses
   */
  List<EmailInfo> getEmailAddresses();

  /**
   * Get organization
   *
   * @return organization
   */
  OrganizationInfo getOrganization();

  /**
   * URLs/websites associated with the contact
   *
   * @return urls
   */
  List<UrlInfo> getUrls();

  /**
   * Date of birth in YYYY-MM-DD format.
   *
   * @return birthday
   */
  LocalDate getBirthday();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new ContactInfoMessageImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param name see getter
     * @return Current builder
     * @see #getName
     */
    Builder setName(NameInfo name);

    /**
     * see getter
     *
     * @param phoneNumbers see getter
     * @return Current builder
     * @see #getPhoneNumbers
     */
    Builder setPhoneNumbers(List<PhoneNumberInfo> phoneNumbers);

    /**
     * see getter
     *
     * @param addresses see getter
     * @return Current builder
     * @see #getAddresses
     */
    Builder setAddresses(List<AddressInfo> addresses);

    /**
     * see getter
     *
     * @param emailAddresses see getter
     * @return Current builder
     * @see #getEmailAddresses
     */
    Builder setEmailAddresses(List<EmailInfo> emailAddresses);

    /**
     * see getter
     *
     * @param organization see getter
     * @return Current builder
     * @see #getOrganization
     */
    Builder setOrganization(OrganizationInfo organization);

    /**
     * see getter
     *
     * @param urls see getter
     * @return Current builder
     * @see #getUrls
     */
    Builder setUrls(List<UrlInfo> urls);

    /**
     * see getter
     *
     * @param birthday see getter
     * @return Current builder
     * @see #getBirthday
     */
    Builder setBirthday(LocalDate birthday);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    ContactInfoMessage build();
  }
}
