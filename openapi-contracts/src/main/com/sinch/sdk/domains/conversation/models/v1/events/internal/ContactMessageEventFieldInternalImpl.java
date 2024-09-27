package com.sinch.sdk.domains.conversation.models.v1.events.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.events.ContactMessageEvent;
import java.util.Objects;

@JsonPropertyOrder({ContactMessageEventFieldInternalImpl.JSON_PROPERTY_CONTACT_MESSAGE_EVENT})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ContactMessageEventFieldInternalImpl implements ContactMessageEventFieldInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CONTACT_MESSAGE_EVENT = "contact_message_event";

  private OptionalValue<ContactMessageEvent> contactMessageEvent;

  public ContactMessageEventFieldInternalImpl() {}

  protected ContactMessageEventFieldInternalImpl(
      OptionalValue<ContactMessageEvent> contactMessageEvent) {
    this.contactMessageEvent = contactMessageEvent;
  }

  @JsonIgnore
  public ContactMessageEvent getContactMessageEvent() {
    return contactMessageEvent.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CONTACT_MESSAGE_EVENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ContactMessageEvent> contactMessageEvent() {
    return contactMessageEvent;
  }

  /** Return true if this ContactMessageEventField object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContactMessageEventFieldInternalImpl contactMessageEventField =
        (ContactMessageEventFieldInternalImpl) o;
    return Objects.equals(this.contactMessageEvent, contactMessageEventField.contactMessageEvent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contactMessageEvent);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContactMessageEventFieldInternalImpl {\n");
    sb.append("    contactMessageEvent: ")
        .append(toIndentedString(contactMessageEvent))
        .append("\n");
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
  static class Builder implements ContactMessageEventFieldInternal.Builder {
    OptionalValue<ContactMessageEvent> contactMessageEvent = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_CONTACT_MESSAGE_EVENT, required = true)
    public Builder setContactMessageEvent(ContactMessageEvent contactMessageEvent) {
      this.contactMessageEvent = OptionalValue.of(contactMessageEvent);
      return this;
    }

    public ContactMessageEventFieldInternal build() {
      return new ContactMessageEventFieldInternalImpl(contactMessageEvent);
    }
  }
}
