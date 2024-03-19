package com.sinch.sdk.domains.conversation.models.v1.messages.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  ReasonImpl.JSON_PROPERTY_CODE,
  ReasonImpl.JSON_PROPERTY_DESCRIPTION,
  ReasonImpl.JSON_PROPERTY_SUB_CODE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ReasonImpl implements Reason {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CODE = "code";

  private OptionalValue<String> code;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";

  private OptionalValue<String> description;

  public static final String JSON_PROPERTY_SUB_CODE = "sub_code";

  private OptionalValue<String> subCode;

  public ReasonImpl() {}

  protected ReasonImpl(
      OptionalValue<String> code,
      OptionalValue<String> description,
      OptionalValue<String> subCode) {
    this.code = code;
    this.description = description;
    this.subCode = subCode;
  }

  @JsonIgnore
  public String getCode() {
    return code.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> code() {
    return code;
  }

  @JsonIgnore
  public String getDescription() {
    return description.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> description() {
    return description;
  }

  @JsonIgnore
  public String getSubCode() {
    return subCode.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SUB_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> subCode() {
    return subCode;
  }

  /** Return true if this Reason object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReasonImpl reason = (ReasonImpl) o;
    return Objects.equals(this.code, reason.code)
        && Objects.equals(this.description, reason.description)
        && Objects.equals(this.subCode, reason.subCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, description, subCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReasonImpl {\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    subCode: ").append(toIndentedString(subCode)).append("\n");
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
  static class Builder implements Reason.Builder {
    OptionalValue<String> code = OptionalValue.empty();
    OptionalValue<String> description = OptionalValue.empty();
    OptionalValue<String> subCode = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CODE)
    public Builder setCode(String code) {
      this.code = OptionalValue.of(code);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    public Builder setDescription(String description) {
      this.description = OptionalValue.of(description);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SUB_CODE)
    public Builder setSubCode(String subCode) {
      this.subCode = OptionalValue.of(subCode);
      return this;
    }

    public Reason build() {
      return new ReasonImpl(code, description, subCode);
    }
  }
}
