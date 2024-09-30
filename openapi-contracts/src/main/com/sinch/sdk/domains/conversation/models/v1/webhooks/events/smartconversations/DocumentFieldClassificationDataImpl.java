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

@JsonPropertyOrder({DocumentFieldClassificationDataImpl.JSON_PROPERTY_DATA})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class DocumentFieldClassificationDataImpl implements DocumentFieldClassificationData {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_DATA = "data";

  private OptionalValue<List<String>> data;

  public DocumentFieldClassificationDataImpl() {}

  protected DocumentFieldClassificationDataImpl(OptionalValue<List<String>> data) {
    this.data = data;
  }

  @JsonIgnore
  public List<String> getData() {
    return data.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<String>> data() {
    return data;
  }

  /** Return true if this DocumentFieldClassificationData_value object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DocumentFieldClassificationDataImpl documentFieldClassificationDataValue =
        (DocumentFieldClassificationDataImpl) o;
    return Objects.equals(this.data, documentFieldClassificationDataValue.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocumentFieldClassificationDataImpl {\n");
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
  static class Builder implements DocumentFieldClassificationData.Builder {
    OptionalValue<List<String>> data = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_DATA)
    public Builder setData(List<String> data) {
      this.data = OptionalValue.of(data);
      return this;
    }

    public DocumentFieldClassificationData build() {
      return new DocumentFieldClassificationDataImpl(data);
    }
  }
}
