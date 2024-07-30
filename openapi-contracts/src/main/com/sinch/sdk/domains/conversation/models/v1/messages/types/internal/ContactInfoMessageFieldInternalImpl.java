package com.sinch.sdk.domains.conversation.models.v1.messages.types.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.contactinfo.ContactInfoMessage;
import java.util.Objects;

@JsonPropertyOrder({ContactInfoMessageFieldInternalImpl.JSON_PROPERTY_CONTACT_INFO_MESSAGE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ContactInfoMessageFieldInternalImpl implements ContactInfoMessageFieldInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CONTACT_INFO_MESSAGE = "contact_info_message";

  private OptionalValue<ContactInfoMessage> contactInfoMessage;

  public ContactInfoMessageFieldInternalImpl() {}

  protected ContactInfoMessageFieldInternalImpl(
      OptionalValue<ContactInfoMessage> contactInfoMessage) {
    this.contactInfoMessage = contactInfoMessage;
  }

  @JsonIgnore
  public ContactInfoMessage getContactInfoMessage() {
    return contactInfoMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CONTACT_INFO_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ContactInfoMessage> contactInfoMessage() {
    return contactInfoMessage;
  }

  /** Return true if this ContactInfoMessageField object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContactInfoMessageFieldInternalImpl contactInfoMessageField =
        (ContactInfoMessageFieldInternalImpl) o;
    return Objects.equals(this.contactInfoMessage, contactInfoMessageField.contactInfoMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contactInfoMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContactInfoMessageFieldInternalImpl {\n");
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
  static class Builder implements ContactInfoMessageFieldInternal.Builder {
    OptionalValue<ContactInfoMessage> contactInfoMessage = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CONTACT_INFO_MESSAGE)
    public Builder setContactInfoMessage(ContactInfoMessage contactInfoMessage) {
      this.contactInfoMessage = OptionalValue.of(contactInfoMessage);
      return this;
    }

    public ContactInfoMessageFieldInternal build() {
      return new ContactInfoMessageFieldInternalImpl(contactInfoMessage);
    }
  }
}
