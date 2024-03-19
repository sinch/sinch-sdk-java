package com.sinch.sdk.domains.conversation.models.v1.messages.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({ContactMessageImpl.JSON_PROPERTY_CONTACT_MESSAGE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ContactMessageImpl implements ContactMessage {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CONTACT_MESSAGE = "contact_message";

  private OptionalValue<ContactMessage> contactMessage;

  public ContactMessageImpl() {}

  protected ContactMessageImpl(OptionalValue<ContactMessage> contactMessage) {
    this.contactMessage = contactMessage;
  }

  @JsonIgnore
  public ContactMessage getContactMessage() {
    return contactMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CONTACT_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ContactMessage> contactMessage() {
    return contactMessage;
  }

  /** Return true if this contact_message object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContactMessageImpl contactMessage = (ContactMessageImpl) o;
    return Objects.equals(this.contactMessage, contactMessage.contactMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contactMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContactMessageImpl {\n");
    sb.append("    contactMessage: ").append(toIndentedString(contactMessage)).append("\n");
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
  static class Builder implements ContactMessage.Builder {
    OptionalValue<ContactMessage> contactMessage = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CONTACT_MESSAGE)
    public Builder setContactMessage(ContactMessage contactMessage) {
      this.contactMessage = OptionalValue.of(contactMessage);
      return this;
    }

    public ContactMessage build() {
      return new ContactMessageImpl(contactMessage);
    }
  }
}
