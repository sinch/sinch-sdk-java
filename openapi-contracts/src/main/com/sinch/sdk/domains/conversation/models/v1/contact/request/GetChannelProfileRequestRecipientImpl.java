package com.sinch.sdk.domains.conversation.models.v1.contact.request;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.request.IdentifiedBy;
import java.util.Objects;

@JsonPropertyOrder({
  GetChannelProfileRequestRecipientImpl.JSON_PROPERTY_CONTACT_ID,
  GetChannelProfileRequestRecipientImpl.JSON_PROPERTY_IDENTIFIED_BY
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class GetChannelProfileRequestRecipientImpl implements GetChannelProfileRequestRecipient {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CONTACT_ID = "contact_id";

  private OptionalValue<String> contactId;

  public static final String JSON_PROPERTY_IDENTIFIED_BY = "identified_by";

  private OptionalValue<IdentifiedBy> identifiedBy;

  public GetChannelProfileRequestRecipientImpl() {}

  protected GetChannelProfileRequestRecipientImpl(
      OptionalValue<String> contactId, OptionalValue<IdentifiedBy> identifiedBy) {
    this.contactId = contactId;
    this.identifiedBy = identifiedBy;
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

  @JsonIgnore
  public IdentifiedBy getIdentifiedBy() {
    return identifiedBy.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_IDENTIFIED_BY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<IdentifiedBy> identifiedBy() {
    return identifiedBy;
  }

  /** Return true if this GetChannelProfileRequestRecipient object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetChannelProfileRequestRecipientImpl getChannelProfileRequestRecipient =
        (GetChannelProfileRequestRecipientImpl) o;
    return Objects.equals(this.contactId, getChannelProfileRequestRecipient.contactId)
        && Objects.equals(this.identifiedBy, getChannelProfileRequestRecipient.identifiedBy);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contactId, identifiedBy);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetChannelProfileRequestRecipientImpl {\n");
    sb.append("    contactId: ").append(toIndentedString(contactId)).append("\n");
    sb.append("    identifiedBy: ").append(toIndentedString(identifiedBy)).append("\n");
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
  static class Builder implements GetChannelProfileRequestRecipient.Builder {
    OptionalValue<String> contactId = OptionalValue.empty();
    OptionalValue<IdentifiedBy> identifiedBy = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CONTACT_ID)
    public Builder setContactId(String contactId) {
      this.contactId = OptionalValue.of(contactId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_IDENTIFIED_BY)
    public Builder setIdentifiedBy(IdentifiedBy identifiedBy) {
      this.identifiedBy = OptionalValue.of(identifiedBy);
      return this;
    }

    public GetChannelProfileRequestRecipient build() {
      return new GetChannelProfileRequestRecipientImpl(contactId, identifiedBy);
    }
  }
}
