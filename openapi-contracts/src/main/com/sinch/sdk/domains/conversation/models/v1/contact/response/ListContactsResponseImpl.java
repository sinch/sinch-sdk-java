package com.sinch.sdk.domains.conversation.models.v1.contact.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.contact.Contact;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  ListContactsResponseImpl.JSON_PROPERTY_CONTACTS,
  ListContactsResponseImpl.JSON_PROPERTY_NEXT_PAGE_TOKEN
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ListContactsResponseImpl implements ListContactsResponse {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CONTACTS = "contacts";

  private OptionalValue<List<Contact>> contacts;

  public static final String JSON_PROPERTY_NEXT_PAGE_TOKEN = "next_page_token";

  private OptionalValue<String> nextPageToken;

  public ListContactsResponseImpl() {}

  protected ListContactsResponseImpl(
      OptionalValue<List<Contact>> contacts, OptionalValue<String> nextPageToken) {
    this.contacts = contacts;
    this.nextPageToken = nextPageToken;
  }

  @JsonIgnore
  public List<Contact> getContacts() {
    return contacts.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CONTACTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<Contact>> contacts() {
    return contacts;
  }

  @JsonIgnore
  public String getNextPageToken() {
    return nextPageToken.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NEXT_PAGE_TOKEN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> nextPageToken() {
    return nextPageToken;
  }

  /** Return true if this ListContactsResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListContactsResponseImpl listContactsResponse = (ListContactsResponseImpl) o;
    return Objects.equals(this.contacts, listContactsResponse.contacts)
        && Objects.equals(this.nextPageToken, listContactsResponse.nextPageToken);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contacts, nextPageToken);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListContactsResponseImpl {\n");
    sb.append("    contacts: ").append(toIndentedString(contacts)).append("\n");
    sb.append("    nextPageToken: ").append(toIndentedString(nextPageToken)).append("\n");
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
  static class Builder implements ListContactsResponse.Builder {
    OptionalValue<List<Contact>> contacts = OptionalValue.empty();
    OptionalValue<String> nextPageToken = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CONTACTS)
    public Builder setContacts(List<Contact> contacts) {
      this.contacts = OptionalValue.of(contacts);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_NEXT_PAGE_TOKEN)
    public Builder setNextPageToken(String nextPageToken) {
      this.nextPageToken = OptionalValue.of(nextPageToken);
      return this;
    }

    public ListContactsResponse build() {
      return new ListContactsResponseImpl(contacts, nextPageToken);
    }
  }
}
