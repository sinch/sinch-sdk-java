package com.sinch.sdk.domains.conversation.models.v1.contacts.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({GetChannelProfileResponseImpl.JSON_PROPERTY_PROFILE_NAME})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class GetChannelProfileResponseImpl implements GetChannelProfileResponse {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_PROFILE_NAME = "profile_name";

  private OptionalValue<String> profileName;

  public GetChannelProfileResponseImpl() {}

  protected GetChannelProfileResponseImpl(OptionalValue<String> profileName) {
    this.profileName = profileName;
  }

  @JsonIgnore
  public String getProfileName() {
    return profileName.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PROFILE_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> profileName() {
    return profileName;
  }

  /** Return true if this GetChannelProfileResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetChannelProfileResponseImpl getChannelProfileResponse = (GetChannelProfileResponseImpl) o;
    return Objects.equals(this.profileName, getChannelProfileResponse.profileName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(profileName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetChannelProfileResponseImpl {\n");
    sb.append("    profileName: ").append(toIndentedString(profileName)).append("\n");
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
  static class Builder implements GetChannelProfileResponse.Builder {
    OptionalValue<String> profileName = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_PROFILE_NAME)
    public Builder setProfileName(String profileName) {
      this.profileName = OptionalValue.of(profileName);
      return this;
    }

    public GetChannelProfileResponse build() {
      return new GetChannelProfileResponseImpl(profileName);
    }
  }
}
