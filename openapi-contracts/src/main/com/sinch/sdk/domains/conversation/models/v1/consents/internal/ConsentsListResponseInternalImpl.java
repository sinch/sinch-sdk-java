package com.sinch.sdk.domains.conversation.models.v1.consents.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.consents.Identity;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  ConsentsListResponseInternalImpl.JSON_PROPERTY_IDENTITIES,
  ConsentsListResponseInternalImpl.JSON_PROPERTY_NEXT_PAGE_TOKEN
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ConsentsListResponseInternalImpl implements ConsentsListResponseInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_IDENTITIES = "identities";

  private OptionalValue<List<Identity>> identities;

  public static final String JSON_PROPERTY_NEXT_PAGE_TOKEN = "next_page_token";

  private OptionalValue<String> nextPageToken;

  public ConsentsListResponseInternalImpl() {}

  protected ConsentsListResponseInternalImpl(
      OptionalValue<List<Identity>> identities, OptionalValue<String> nextPageToken) {
    this.identities = identities;
    this.nextPageToken = nextPageToken;
  }

  @JsonIgnore
  public List<Identity> getIdentities() {
    return identities.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_IDENTITIES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<Identity>> identities() {
    return identities;
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

  /** Return true if this GetIdentitiesFromConsentResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConsentsListResponseInternalImpl getIdentitiesFromConsentResponse =
        (ConsentsListResponseInternalImpl) o;
    return Objects.equals(this.identities, getIdentitiesFromConsentResponse.identities)
        && Objects.equals(this.nextPageToken, getIdentitiesFromConsentResponse.nextPageToken);
  }

  @Override
  public int hashCode() {
    return Objects.hash(identities, nextPageToken);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConsentsListResponseInternalImpl {\n");
    sb.append("    identities: ").append(toIndentedString(identities)).append("\n");
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
  static class Builder implements ConsentsListResponseInternal.Builder {
    OptionalValue<List<Identity>> identities = OptionalValue.empty();
    OptionalValue<String> nextPageToken = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_IDENTITIES)
    public Builder setIdentities(List<Identity> identities) {
      this.identities = OptionalValue.of(identities);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_NEXT_PAGE_TOKEN)
    public Builder setNextPageToken(String nextPageToken) {
      this.nextPageToken = OptionalValue.of(nextPageToken);
      return this;
    }

    public ConsentsListResponseInternal build() {
      return new ConsentsListResponseInternalImpl(identities, nextPageToken);
    }
  }
}
