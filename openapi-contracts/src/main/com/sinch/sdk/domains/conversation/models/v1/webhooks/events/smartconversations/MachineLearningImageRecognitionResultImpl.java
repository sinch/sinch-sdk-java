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
  MachineLearningImageRecognitionResultImpl.JSON_PROPERTY_URL,
  MachineLearningImageRecognitionResultImpl.JSON_PROPERTY_DOCUMENT_IMAGE_CLASSIFICATION,
  MachineLearningImageRecognitionResultImpl.JSON_PROPERTY_OPTICAL_CHARACTER_RECOGNITION,
  MachineLearningImageRecognitionResultImpl.JSON_PROPERTY_DOCUMENT_FIELD_CLASSIFICATION
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class MachineLearningImageRecognitionResultImpl
    implements MachineLearningImageRecognitionResult {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_URL = "url";

  private OptionalValue<String> url;

  public static final String JSON_PROPERTY_DOCUMENT_IMAGE_CLASSIFICATION =
      "document_image_classification";

  private OptionalValue<DocumentImageClassification> documentImageClassification;

  public static final String JSON_PROPERTY_OPTICAL_CHARACTER_RECOGNITION =
      "optical_character_recognition";

  private OptionalValue<OpticalCharacterRecognition> opticalCharacterRecognition;

  public static final String JSON_PROPERTY_DOCUMENT_FIELD_CLASSIFICATION =
      "document_field_classification";

  private OptionalValue<DocumentFieldClassification> documentFieldClassification;

  public MachineLearningImageRecognitionResultImpl() {}

  protected MachineLearningImageRecognitionResultImpl(
      OptionalValue<String> url,
      OptionalValue<DocumentImageClassification> documentImageClassification,
      OptionalValue<OpticalCharacterRecognition> opticalCharacterRecognition,
      OptionalValue<DocumentFieldClassification> documentFieldClassification) {
    this.url = url;
    this.documentImageClassification = documentImageClassification;
    this.opticalCharacterRecognition = opticalCharacterRecognition;
    this.documentFieldClassification = documentFieldClassification;
  }

  @JsonIgnore
  public String getUrl() {
    return url.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> url() {
    return url;
  }

  @JsonIgnore
  public DocumentImageClassification getDocumentImageClassification() {
    return documentImageClassification.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DOCUMENT_IMAGE_CLASSIFICATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<DocumentImageClassification> documentImageClassification() {
    return documentImageClassification;
  }

  @JsonIgnore
  public OpticalCharacterRecognition getOpticalCharacterRecognition() {
    return opticalCharacterRecognition.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_OPTICAL_CHARACTER_RECOGNITION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<OpticalCharacterRecognition> opticalCharacterRecognition() {
    return opticalCharacterRecognition;
  }

  @JsonIgnore
  public DocumentFieldClassification getDocumentFieldClassification() {
    return documentFieldClassification.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DOCUMENT_FIELD_CLASSIFICATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<DocumentFieldClassification> documentFieldClassification() {
    return documentFieldClassification;
  }

  /** Return true if this MachineLearningImageRecognitionResult object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MachineLearningImageRecognitionResultImpl machineLearningImageRecognitionResult =
        (MachineLearningImageRecognitionResultImpl) o;
    return Objects.equals(this.url, machineLearningImageRecognitionResult.url)
        && Objects.equals(
            this.documentImageClassification,
            machineLearningImageRecognitionResult.documentImageClassification)
        && Objects.equals(
            this.opticalCharacterRecognition,
            machineLearningImageRecognitionResult.opticalCharacterRecognition)
        && Objects.equals(
            this.documentFieldClassification,
            machineLearningImageRecognitionResult.documentFieldClassification);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        url, documentImageClassification, opticalCharacterRecognition, documentFieldClassification);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MachineLearningImageRecognitionResultImpl {\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    documentImageClassification: ")
        .append(toIndentedString(documentImageClassification))
        .append("\n");
    sb.append("    opticalCharacterRecognition: ")
        .append(toIndentedString(opticalCharacterRecognition))
        .append("\n");
    sb.append("    documentFieldClassification: ")
        .append(toIndentedString(documentFieldClassification))
        .append("\n");
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
  static class Builder implements MachineLearningImageRecognitionResult.Builder {
    OptionalValue<String> url = OptionalValue.empty();
    OptionalValue<DocumentImageClassification> documentImageClassification = OptionalValue.empty();
    OptionalValue<OpticalCharacterRecognition> opticalCharacterRecognition = OptionalValue.empty();
    OptionalValue<DocumentFieldClassification> documentFieldClassification = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_URL)
    public Builder setUrl(String url) {
      this.url = OptionalValue.of(url);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DOCUMENT_IMAGE_CLASSIFICATION)
    public Builder setDocumentImageClassification(
        DocumentImageClassification documentImageClassification) {
      this.documentImageClassification = OptionalValue.of(documentImageClassification);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_OPTICAL_CHARACTER_RECOGNITION)
    public Builder setOpticalCharacterRecognition(
        OpticalCharacterRecognition opticalCharacterRecognition) {
      this.opticalCharacterRecognition = OptionalValue.of(opticalCharacterRecognition);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DOCUMENT_FIELD_CLASSIFICATION)
    public Builder setDocumentFieldClassification(
        DocumentFieldClassification documentFieldClassification) {
      this.documentFieldClassification = OptionalValue.of(documentFieldClassification);
      return this;
    }

    public MachineLearningImageRecognitionResult build() {
      return new MachineLearningImageRecognitionResultImpl(
          url,
          documentImageClassification,
          opticalCharacterRecognition,
          documentFieldClassification);
    }
  }
}
