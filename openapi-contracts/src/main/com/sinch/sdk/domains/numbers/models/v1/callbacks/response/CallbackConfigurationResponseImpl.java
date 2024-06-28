package com.sinch.sdk.domains.numbers.models.v1.callbacks.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  CallbackConfigurationResponseImpl.JSON_PROPERTY_PROJECT_ID,
  CallbackConfigurationResponseImpl.JSON_PROPERTY_HMAC_SECRET
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class CallbackConfigurationResponseImpl implements CallbackConfigurationResponse {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_PROJECT_ID = "projectId";

  private OptionalValue<String> projectId;

  public static final String JSON_PROPERTY_HMAC_SECRET = "hmacSecret";

  private OptionalValue<String> hmacSecret;

  public CallbackConfigurationResponseImpl() {}

  protected CallbackConfigurationResponseImpl(
      OptionalValue<String> projectId, OptionalValue<String> hmacSecret) {
    this.projectId = projectId;
    this.hmacSecret = hmacSecret;
  }

  @JsonIgnore
  public String getProjectId() {
    return projectId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PROJECT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> projectId() {
    return projectId;
  }

  @JsonIgnore
  public String getHmacSecret() {
    return hmacSecret.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_HMAC_SECRET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> hmacSecret() {
    return hmacSecret;
  }

  /** Return true if this CallbackConfiguration object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CallbackConfigurationResponseImpl callbackConfiguration = (CallbackConfigurationResponseImpl) o;
    return Objects.equals(this.projectId, callbackConfiguration.projectId)
        && Objects.equals(this.hmacSecret, callbackConfiguration.hmacSecret);
  }

  @Override
  public int hashCode() {
    return Objects.hash(projectId, hmacSecret);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CallbackConfigurationResponseImpl {\n");
    sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
    sb.append("    hmacSecret: ").append(toIndentedString(hmacSecret)).append("\n");
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
  static class Builder implements CallbackConfigurationResponse.Builder {
    OptionalValue<String> projectId = OptionalValue.empty();
    OptionalValue<String> hmacSecret = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_PROJECT_ID)
    public Builder setProjectId(String projectId) {
      this.projectId = OptionalValue.of(projectId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_HMAC_SECRET)
    public Builder setHmacSecret(String hmacSecret) {
      this.hmacSecret = OptionalValue.of(hmacSecret);
      return this;
    }

    public CallbackConfigurationResponse build() {
      return new CallbackConfigurationResponseImpl(projectId, hmacSecret);
    }
  }
}
