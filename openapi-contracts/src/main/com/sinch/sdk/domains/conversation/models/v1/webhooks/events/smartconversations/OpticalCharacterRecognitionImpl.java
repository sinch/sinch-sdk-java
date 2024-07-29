package com.sinch.sdk.domains.conversation.models.v1.webhooks.events.smartconversations;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({OpticalCharacterRecognitionImpl.JSON_PROPERTY_RESULT})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class OpticalCharacterRecognitionImpl implements OpticalCharacterRecognition {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_RESULT = "result";

  private OptionalValue<List<OpticalCharacterRecognitionData>> result;

  public OpticalCharacterRecognitionImpl() {}

  protected OpticalCharacterRecognitionImpl(
      OptionalValue<List<OpticalCharacterRecognitionData>> result) {
    this.result = result;
  }

  @JsonIgnore
  public List<OpticalCharacterRecognitionData> getResult() {
    return result.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_RESULT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<OpticalCharacterRecognitionData>> result() {
    return result;
  }

  /** Return true if this OpticalCharacterRecognition object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OpticalCharacterRecognitionImpl opticalCharacterRecognition =
        (OpticalCharacterRecognitionImpl) o;
    return Objects.equals(this.result, opticalCharacterRecognition.result);
  }

  @Override
  public int hashCode() {
    return Objects.hash(result);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OpticalCharacterRecognitionImpl {\n");
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
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
  static class Builder implements OpticalCharacterRecognition.Builder {
    OptionalValue<List<OpticalCharacterRecognitionData>> result = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_RESULT)
    public Builder setResult(List<OpticalCharacterRecognitionData> result) {
      this.result = OptionalValue.of(result);
      return this;
    }

    public OpticalCharacterRecognition build() {
      return new OpticalCharacterRecognitionImpl(result);
    }
  }
}
