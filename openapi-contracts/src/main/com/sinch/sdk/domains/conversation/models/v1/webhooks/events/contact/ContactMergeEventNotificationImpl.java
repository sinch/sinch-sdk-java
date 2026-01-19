package com.sinch.sdk.domains.conversation.models.v1.webhooks.events.contact;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.contacts.Contact;
import java.util.Objects;

@JsonPropertyOrder({
  ContactMergeEventNotificationImpl.JSON_PROPERTY_PRESERVED_CONTACT,
  ContactMergeEventNotificationImpl.JSON_PROPERTY_DELETED_CONTACT
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ContactMergeEventNotificationImpl implements ContactMergeEventNotification {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_PRESERVED_CONTACT = "preserved_contact";

  private OptionalValue<Contact> preservedContact;

  public static final String JSON_PROPERTY_DELETED_CONTACT = "deleted_contact";

  private OptionalValue<Contact> deletedContact;

  public ContactMergeEventNotificationImpl() {}

  protected ContactMergeEventNotificationImpl(
      OptionalValue<Contact> preservedContact, OptionalValue<Contact> deletedContact) {
    this.preservedContact = preservedContact;
    this.deletedContact = deletedContact;
  }

  @JsonIgnore
  public Contact getPreservedContact() {
    return preservedContact.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PRESERVED_CONTACT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Contact> preservedContact() {
    return preservedContact;
  }

  @JsonIgnore
  public Contact getDeletedContact() {
    return deletedContact.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DELETED_CONTACT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Contact> deletedContact() {
    return deletedContact;
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
    ContactMergeEventNotificationImpl contactMergeEventAllOfContactMergeNotification =
        (ContactMergeEventNotificationImpl) o;
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
    sb.append("class ContactMergeEventNotificationImpl {\n");
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

  @JsonPOJOBuilder(withPrefix = "set")
  static class Builder implements ContactMergeEventNotification.Builder {
    OptionalValue<Contact> preservedContact = OptionalValue.empty();
    OptionalValue<Contact> deletedContact = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_PRESERVED_CONTACT)
    public Builder setPreservedContact(Contact preservedContact) {
      this.preservedContact = OptionalValue.of(preservedContact);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DELETED_CONTACT)
    public Builder setDeletedContact(Contact deletedContact) {
      this.deletedContact = OptionalValue.of(deletedContact);
      return this;
    }

    public ContactMergeEventNotification build() {
      return new ContactMergeEventNotificationImpl(preservedContact, deletedContact);
    }
  }
}
