package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({ContactInfoMessageImpl.JSON_PROPERTY_CONTACT_INFO_MESSAGE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ContactInfoMessageImpl implements ContactInfoMessage {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CONTACT_INFO_MESSAGE = "contact_info_message";

  private OptionalValue<ContactInfoMessageContactInfoMessage> contactInfoMessage;

  public ContactInfoMessageImpl() {}

  protected ContactInfoMessageImpl(
      OptionalValue<ContactInfoMessageContactInfoMessage> contactInfoMessage) {
    this.contactInfoMessage = contactInfoMessage;
  }

  @JsonIgnore
  public ContactInfoMessageContactInfoMessage getContactInfoMessage() {
    return contactInfoMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CONTACT_INFO_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ContactInfoMessageContactInfoMessage> contactInfoMessage() {
    return contactInfoMessage;
  }

  /** Return true if this ContactInfoMessage object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContactInfoMessageImpl contactInfoMessage = (ContactInfoMessageImpl) o;
    return Objects.equals(this.contactInfoMessage, contactInfoMessage.contactInfoMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contactInfoMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContactInfoMessageImpl {\n");
    sb.append("    contactInfoMessage: ").append(toIndentedString(contactInfoMessage)).append("\n");
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
  static class Builder implements ContactInfoMessage.Builder {
    OptionalValue<ContactInfoMessageContactInfoMessage> contactInfoMessage = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CONTACT_INFO_MESSAGE)
    public Builder setContactInfoMessage(ContactInfoMessageContactInfoMessage contactInfoMessage) {
      this.contactInfoMessage = OptionalValue.of(contactInfoMessage);
      return this;
    }

    public ContactInfoMessage build() {
      return new ContactInfoMessageImpl(contactInfoMessage);
    }
  }
}
