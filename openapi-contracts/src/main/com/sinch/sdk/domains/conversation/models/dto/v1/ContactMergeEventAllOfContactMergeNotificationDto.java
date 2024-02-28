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

package com.sinch.sdk.domains.conversation.models.dto.v1;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

/** ContactMergeEventAllOfContactMergeNotificationDto */
@JsonPropertyOrder({
  ContactMergeEventAllOfContactMergeNotificationDto.JSON_PROPERTY_PRESERVED_CONTACT,
  ContactMergeEventAllOfContactMergeNotificationDto.JSON_PROPERTY_DELETED_CONTACT
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ContactMergeEventAllOfContactMergeNotificationDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_PRESERVED_CONTACT = "preserved_contact";
  private ContactDto preservedContact;
  private boolean preservedContactDefined = false;

  public static final String JSON_PROPERTY_DELETED_CONTACT = "deleted_contact";
  private ContactDto deletedContact;
  private boolean deletedContactDefined = false;

  public ContactMergeEventAllOfContactMergeNotificationDto() {}

  public ContactMergeEventAllOfContactMergeNotificationDto preservedContact(
      ContactDto preservedContact) {
    this.preservedContact = preservedContact;
    this.preservedContactDefined = true;
    return this;
  }

  /**
   * Get preservedContact
   *
   * @return preservedContact
   */
  @JsonProperty(JSON_PROPERTY_PRESERVED_CONTACT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public ContactDto getPreservedContact() {
    return preservedContact;
  }

  @JsonIgnore
  public boolean getPreservedContactDefined() {
    return preservedContactDefined;
  }

  @JsonProperty(JSON_PROPERTY_PRESERVED_CONTACT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPreservedContact(ContactDto preservedContact) {
    this.preservedContact = preservedContact;
    this.preservedContactDefined = true;
  }

  public ContactMergeEventAllOfContactMergeNotificationDto deletedContact(
      ContactDto deletedContact) {
    this.deletedContact = deletedContact;
    this.deletedContactDefined = true;
    return this;
  }

  /**
   * Get deletedContact
   *
   * @return deletedContact
   */
  @JsonProperty(JSON_PROPERTY_DELETED_CONTACT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public ContactDto getDeletedContact() {
    return deletedContact;
  }

  @JsonIgnore
  public boolean getDeletedContactDefined() {
    return deletedContactDefined;
  }

  @JsonProperty(JSON_PROPERTY_DELETED_CONTACT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDeletedContact(ContactDto deletedContact) {
    this.deletedContact = deletedContact;
    this.deletedContactDefined = true;
  }

  /**
   * Return true if this ContactMergeEvent_allOf_contact_merge_notification object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContactMergeEventAllOfContactMergeNotificationDto
        contactMergeEventAllOfContactMergeNotification =
            (ContactMergeEventAllOfContactMergeNotificationDto) o;
    return Objects.equals(
            this.preservedContact, contactMergeEventAllOfContactMergeNotification.preservedContact)
        && Objects.equals(
            this.deletedContact, contactMergeEventAllOfContactMergeNotification.deletedContact);
  }

  @Override
  public int hashCode() {
    return Objects.hash(preservedContact, deletedContact);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContactMergeEventAllOfContactMergeNotificationDto {\n");
    sb.append("    preservedContact: ").append(toIndentedString(preservedContact)).append("\n");
    sb.append("    deletedContact: ").append(toIndentedString(deletedContact)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}