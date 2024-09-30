package com.sinch.sdk.domains.conversation.models.v1.webhooks.events.smartconversations;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  DocumentImageClassificationImpl.JSON_PROPERTY_DOC_TYPE,
  DocumentImageClassificationImpl.JSON_PROPERTY_CONFIDENCE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class DocumentImageClassificationImpl implements DocumentImageClassification {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_DOC_TYPE = "doc_type";

  private OptionalValue<String> docType;

  public static final String JSON_PROPERTY_CONFIDENCE = "confidence";

  private OptionalValue<Float> confidence;

  public DocumentImageClassificationImpl() {}

  protected DocumentImageClassificationImpl(
      OptionalValue<String> docType, OptionalValue<Float> confidence) {
    this.docType = docType;
    this.confidence = confidence;
  }

  @JsonIgnore
  public String getDocType() {
    return docType.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DOC_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> docType() {
    return docType;
  }

  @JsonIgnore
  public Float getConfidence() {
    return confidence.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CONFIDENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Float> confidence() {
    return confidence;
  }

  /** Return true if this DocumentImageClassification object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DocumentImageClassificationImpl documentImageClassification =
        (DocumentImageClassificationImpl) o;
    return Objects.equals(this.docType, documentImageClassification.docType)
        && Objects.equals(this.confidence, documentImageClassification.confidence);
  }

  @Override
  public int hashCode() {
    return Objects.hash(docType, confidence);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocumentImageClassificationImpl {\n");
    sb.append("    docType: ").append(toIndentedString(docType)).append("\n");
    sb.append("    confidence: ").append(toIndentedString(confidence)).append("\n");
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
  static class Builder implements DocumentImageClassification.Builder {
    OptionalValue<String> docType = OptionalValue.empty();
    OptionalValue<Float> confidence = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_DOC_TYPE)
    public Builder setDocType(String docType) {
      this.docType = OptionalValue.of(docType);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CONFIDENCE)
    public Builder setConfidence(Float confidence) {
      this.confidence = OptionalValue.of(confidence);
      return this;
    }

    public DocumentImageClassification build() {
      return new DocumentImageClassificationImpl(docType, confidence);
    }
  }
}
