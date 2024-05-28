package com.sinch.sdk.domains.verification.models.v1.start.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({StartVerificationResponseSeamlessContentImpl.JSON_PROPERTY_TARGET_URI})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class StartVerificationResponseSeamlessContentImpl
    implements StartVerificationResponseSeamlessContent {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TARGET_URI = "targetUri";

  private OptionalValue<String> targetUri;

  public StartVerificationResponseSeamlessContentImpl() {}

  protected StartVerificationResponseSeamlessContentImpl(OptionalValue<String> targetUri) {
    this.targetUri = targetUri;
  }

  @JsonIgnore
  public String getTargetUri() {
    return targetUri.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TARGET_URI)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> targetUri() {
    return targetUri;
  }

  /** Return true if this DataInitiateVerificationResponse_seamless object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StartVerificationResponseSeamlessContentImpl dataInitiateVerificationResponseSeamless =
        (StartVerificationResponseSeamlessContentImpl) o;
    return Objects.equals(this.targetUri, dataInitiateVerificationResponseSeamless.targetUri);
  }

  @Override
  public int hashCode() {
    return Objects.hash(targetUri);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StartVerificationResponseSeamlessContentImpl {\n");
    sb.append("    targetUri: ").append(toIndentedString(targetUri)).append("\n");
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
  static class Builder implements StartVerificationResponseSeamlessContent.Builder {
    OptionalValue<String> targetUri = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_TARGET_URI)
    public Builder setTargetUri(String targetUri) {
      this.targetUri = OptionalValue.of(targetUri);
      return this;
    }

    public StartVerificationResponseSeamlessContent build() {
      return new StartVerificationResponseSeamlessContentImpl(targetUri);
    }
  }
}
