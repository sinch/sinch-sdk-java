package com.sinch.sdk.domains.conversation.models.v1;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({ContactIdImpl.JSON_PROPERTY_CONTACT_ID})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ContactIdImpl
    implements ContactId, com.sinch.sdk.domains.conversation.models.v1.Recipient {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CONTACT_ID = "contact_id";

  private OptionalValue<String> contactId;

  public ContactIdImpl() {}

  protected ContactIdImpl(OptionalValue<String> contactId) {
    this.contactId = contactId;
  }

  @JsonIgnore
  public String getContactId() {
    return contactId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CONTACT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> contactId() {
    return contactId;
  }

  /** Return true if this ContactIDField object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContactIdImpl contactIDField = (ContactIdImpl) o;
    return Objects.equals(this.contactId, contactIDField.contactId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contactId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContactIdImpl {\n");
    sb.append("    contactId: ").append(toIndentedString(contactId)).append("\n");
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
  static class Builder implements ContactId.Builder {
    OptionalValue<String> contactId = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CONTACT_ID)
    public Builder setContactId(String contactId) {
      this.contactId = OptionalValue.of(contactId);
      return this;
    }

    public ContactId build() {
      return new ContactIdImpl(contactId);
    }
  }
}
