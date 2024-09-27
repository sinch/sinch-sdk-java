package com.sinch.sdk.domains.conversation.models.v1.events.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.events.ContactEvent;
import java.util.Objects;

@JsonPropertyOrder({ContactEventFieldInternalImpl.JSON_PROPERTY_CONTACT_EVENT})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ContactEventFieldInternalImpl implements ContactEventFieldInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CONTACT_EVENT = "contact_event";

  private OptionalValue<ContactEvent> contactEvent;

  public ContactEventFieldInternalImpl() {}

  protected ContactEventFieldInternalImpl(OptionalValue<ContactEvent> contactEvent) {
    this.contactEvent = contactEvent;
  }

  @JsonIgnore
  public ContactEvent getContactEvent() {
    return contactEvent.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CONTACT_EVENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ContactEvent> contactEvent() {
    return contactEvent;
  }

  /** Return true if this ContactEventField object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContactEventFieldInternalImpl contactEventField = (ContactEventFieldInternalImpl) o;
    return Objects.equals(this.contactEvent, contactEventField.contactEvent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contactEvent);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContactEventFieldInternalImpl {\n");
    sb.append("    contactEvent: ").append(toIndentedString(contactEvent)).append("\n");
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
  static class Builder implements ContactEventFieldInternal.Builder {
    OptionalValue<ContactEvent> contactEvent = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_CONTACT_EVENT, required = true)
    public Builder setContactEvent(ContactEvent contactEvent) {
      this.contactEvent = OptionalValue.of(contactEvent);
      return this;
    }

    public ContactEventFieldInternal build() {
      return new ContactEventFieldInternalImpl(contactEvent);
    }
  }
}
