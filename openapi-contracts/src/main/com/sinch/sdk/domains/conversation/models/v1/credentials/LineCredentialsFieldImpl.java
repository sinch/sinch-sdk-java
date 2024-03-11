package com.sinch.sdk.domains.conversation.models.v1.credentials;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({LineCredentialsFieldImpl.JSON_PROPERTY_LINE_CREDENTIALS})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class LineCredentialsFieldImpl implements LineCredentialsField {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_LINE_CREDENTIALS = "line_credentials";

  private OptionalValue<LineCredentials> lineCredentials;

  public LineCredentialsFieldImpl() {}

  protected LineCredentialsFieldImpl(OptionalValue<LineCredentials> lineCredentials) {
    this.lineCredentials = lineCredentials;
  }

  @JsonIgnore
  public LineCredentials getLineCredentials() {
    return lineCredentials.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_LINE_CREDENTIALS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<LineCredentials> lineCredentials() {
    return lineCredentials;
  }

  /** Return true if this LineCredentialsField object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LineCredentialsFieldImpl lineCredentialsField = (LineCredentialsFieldImpl) o;
    return Objects.equals(this.lineCredentials, lineCredentialsField.lineCredentials);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lineCredentials);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LineCredentialsFieldImpl {\n");
    sb.append("    lineCredentials: ").append(toIndentedString(lineCredentials)).append("\n");
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
  static class Builder implements LineCredentialsField.Builder {
    OptionalValue<LineCredentials> lineCredentials = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_LINE_CREDENTIALS)
    public Builder setLineCredentials(LineCredentials lineCredentials) {
      this.lineCredentials = OptionalValue.of(lineCredentials);
      return this;
    }

    public LineCredentialsField build() {
      return new LineCredentialsFieldImpl(lineCredentials);
    }
  }
}
