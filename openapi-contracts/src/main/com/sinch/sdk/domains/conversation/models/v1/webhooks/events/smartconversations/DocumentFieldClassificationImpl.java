package com.sinch.sdk.domains.conversation.models.v1.webhooks.events.smartconversations;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonPropertyOrder({DocumentFieldClassificationImpl.JSON_PROPERTY_RESULT})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class DocumentFieldClassificationImpl implements DocumentFieldClassification {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_RESULT = "result";

  private OptionalValue<List<Map<String, DocumentFieldClassificationData>>> result;

  public DocumentFieldClassificationImpl() {}

  protected DocumentFieldClassificationImpl(
      OptionalValue<List<Map<String, DocumentFieldClassificationData>>> result) {
    this.result = result;
  }

  @JsonIgnore
  public List<Map<String, DocumentFieldClassificationData>> getResult() {
    return result.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_RESULT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<Map<String, DocumentFieldClassificationData>>> result() {
    return result;
  }

  /** Return true if this DocumentFieldClassification object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DocumentFieldClassificationImpl documentFieldClassification =
        (DocumentFieldClassificationImpl) o;
    return Objects.equals(this.result, documentFieldClassification.result);
  }

  @Override
  public int hashCode() {
    return Objects.hash(result);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocumentFieldClassificationImpl {\n");
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
  static class Builder implements DocumentFieldClassification.Builder {
    OptionalValue<List<Map<String, DocumentFieldClassificationData>>> result =
        OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_RESULT)
    public Builder setResult(List<Map<String, DocumentFieldClassificationData>> result) {
      this.result = OptionalValue.of(result);
      return this;
    }

    public DocumentFieldClassification build() {
      return new DocumentFieldClassificationImpl(result);
    }
  }
}
