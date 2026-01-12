package com.sinch.sdk.domains.numbers.models.v1.numberorder.request;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Map;
import java.util.Objects;

@JsonPropertyOrder({UpdateNumberOrderRegistrationRequestImpl.JSON_PROPERTY_DATA})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class UpdateNumberOrderRegistrationRequestImpl
    implements UpdateNumberOrderRegistrationRequest {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_DATA = "data";

  private OptionalValue<Map<String, Object>> data;

  public UpdateNumberOrderRegistrationRequestImpl() {}

  protected UpdateNumberOrderRegistrationRequestImpl(OptionalValue<Map<String, Object>> data) {
    this.data = data;
  }

  @JsonIgnore
  public Map<String, Object> getData() {
    return data.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DATA)
  @JsonInclude(content = JsonInclude.Include.ALWAYS, value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Map<String, Object>> data() {
    return data;
  }

  /** Return true if this UpdateNumberOrderRegistrationRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateNumberOrderRegistrationRequestImpl updateNumberOrderRegistrationRequest =
        (UpdateNumberOrderRegistrationRequestImpl) o;
    return Objects.equals(this.data, updateNumberOrderRegistrationRequest.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateNumberOrderRegistrationRequestImpl {\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
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
  static class Builder implements UpdateNumberOrderRegistrationRequest.Builder {
    OptionalValue<Map<String, Object>> data = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_DATA)
    public Builder setData(Map<String, Object> data) {
      this.data = OptionalValue.of(data);
      return this;
    }

    public UpdateNumberOrderRegistrationRequest build() {
      return new UpdateNumberOrderRegistrationRequestImpl(data);
    }
  }
}
