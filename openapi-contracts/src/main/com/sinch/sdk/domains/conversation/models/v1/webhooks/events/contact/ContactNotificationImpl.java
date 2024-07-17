package com.sinch.sdk.domains.conversation.models.v1.webhooks.events.contact;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.contact.Contact;
import java.util.Objects;

@JsonPropertyOrder({ContactNotificationImpl.JSON_PROPERTY_CONTACT})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ContactNotificationImpl implements ContactNotification {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CONTACT = "contact";

  private OptionalValue<Contact> contact;

  public ContactNotificationImpl() {}

  protected ContactNotificationImpl(OptionalValue<Contact> contact) {
    this.contact = contact;
  }

  @JsonIgnore
  public Contact getContact() {
    return contact.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CONTACT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Contact> contact() {
    return contact;
  }

  /** Return true if this ContactNotification object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContactNotificationImpl contactNotification = (ContactNotificationImpl) o;
    return Objects.equals(this.contact, contactNotification.contact);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contact);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContactNotificationImpl {\n");
    sb.append("    contact: ").append(toIndentedString(contact)).append("\n");
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
  static class Builder implements ContactNotification.Builder {
    OptionalValue<Contact> contact = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CONTACT)
    public Builder setContact(Contact contact) {
      this.contact = OptionalValue.of(contact);
      return this;
    }

    public ContactNotification build() {
      return new ContactNotificationImpl(contact);
    }
  }
}
