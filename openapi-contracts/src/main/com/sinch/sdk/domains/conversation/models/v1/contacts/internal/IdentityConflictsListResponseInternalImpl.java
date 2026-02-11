package com.sinch.sdk.domains.conversation.models.v1.contacts.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.contacts.response.IdentityConflicts;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  IdentityConflictsListResponseInternalImpl.JSON_PROPERTY_CONFLICTS,
  IdentityConflictsListResponseInternalImpl.JSON_PROPERTY_NEXT_PAGE_TOKEN
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class IdentityConflictsListResponseInternalImpl
    implements IdentityConflictsListResponseInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CONFLICTS = "conflicts";

  private OptionalValue<List<IdentityConflicts>> conflicts;

  public static final String JSON_PROPERTY_NEXT_PAGE_TOKEN = "next_page_token";

  private OptionalValue<String> nextPageToken;

  public IdentityConflictsListResponseInternalImpl() {}

  protected IdentityConflictsListResponseInternalImpl(
      OptionalValue<List<IdentityConflicts>> conflicts, OptionalValue<String> nextPageToken) {
    this.conflicts = conflicts;
    this.nextPageToken = nextPageToken;
  }

  @JsonIgnore
  public List<IdentityConflicts> getConflicts() {
    return conflicts.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CONFLICTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<IdentityConflicts>> conflicts() {
    return conflicts;
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

  /** Return true if this Contact_ListIdentityConflicts_200_response object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IdentityConflictsListResponseInternalImpl contactListIdentityConflicts200Response =
        (IdentityConflictsListResponseInternalImpl) o;
    return Objects.equals(this.conflicts, contactListIdentityConflicts200Response.conflicts)
        && Objects.equals(
            this.nextPageToken, contactListIdentityConflicts200Response.nextPageToken);
  }

  @Override
  public int hashCode() {
    return Objects.hash(conflicts, nextPageToken);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IdentityConflictsListResponseInternalImpl {\n");
    sb.append("    conflicts: ").append(toIndentedString(conflicts)).append("\n");
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
  static class Builder implements IdentityConflictsListResponseInternal.Builder {
    OptionalValue<List<IdentityConflicts>> conflicts = OptionalValue.empty();
    OptionalValue<String> nextPageToken = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CONFLICTS)
    public Builder setConflicts(List<IdentityConflicts> conflicts) {
      this.conflicts = OptionalValue.of(conflicts);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_NEXT_PAGE_TOKEN)
    public Builder setNextPageToken(String nextPageToken) {
      this.nextPageToken = OptionalValue.of(nextPageToken);
      return this;
    }

    public IdentityConflictsListResponseInternal build() {
      return new IdentityConflictsListResponseInternalImpl(conflicts, nextPageToken);
    }
  }
}
