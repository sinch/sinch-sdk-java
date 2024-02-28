/*
 * Conversation API | Sinch
 * Send and receive messages globally over SMS, RCS, WhatsApp, Viber Business, Facebook messenger and other popular channels using the Sinch Conversation API.  The Conversation API endpoint uses built-in transcoding to give you the power of conversation across all supported channels and, if required, full control over channel specific features.
 *
 * The version of the OpenAPI document: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.dto.v1;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

/** MachineLearningImageRecognitionResultDto */
@JsonPropertyOrder({
  MachineLearningImageRecognitionResultDto.JSON_PROPERTY_URL,
  MachineLearningImageRecognitionResultDto.JSON_PROPERTY_DOCUMENT_IMAGE_CLASSIFICATION,
  MachineLearningImageRecognitionResultDto.JSON_PROPERTY_OPTICAL_CHARACTER_RECOGNITION,
  MachineLearningImageRecognitionResultDto.JSON_PROPERTY_DOCUMENT_FIELD_CLASSIFICATION
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class MachineLearningImageRecognitionResultDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_URL = "url";
  private String url;
  private boolean urlDefined = false;

  public static final String JSON_PROPERTY_DOCUMENT_IMAGE_CLASSIFICATION =
      "document_image_classification";
  private DocumentImageClassificationDto documentImageClassification;
  private boolean documentImageClassificationDefined = false;

  public static final String JSON_PROPERTY_OPTICAL_CHARACTER_RECOGNITION =
      "optical_character_recognition";
  private OpticalCharacterRecognitionDto opticalCharacterRecognition;
  private boolean opticalCharacterRecognitionDefined = false;

  public static final String JSON_PROPERTY_DOCUMENT_FIELD_CLASSIFICATION =
      "document_field_classification";
  private DocumentFieldClassificationDto documentFieldClassification;
  private boolean documentFieldClassificationDefined = false;

  public MachineLearningImageRecognitionResultDto() {}

  public MachineLearningImageRecognitionResultDto url(String url) {
    this.url = url;
    this.urlDefined = true;
    return this;
  }

  /**
   * The URL of the image that was processed.
   *
   * @return url
   */
  @JsonProperty(JSON_PROPERTY_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getUrl() {
    return url;
  }

  @JsonIgnore
  public boolean getUrlDefined() {
    return urlDefined;
  }

  @JsonProperty(JSON_PROPERTY_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setUrl(String url) {
    this.url = url;
    this.urlDefined = true;
  }

  public MachineLearningImageRecognitionResultDto documentImageClassification(
      DocumentImageClassificationDto documentImageClassification) {
    this.documentImageClassification = documentImageClassification;
    this.documentImageClassificationDefined = true;
    return this;
  }

  /**
   * Get documentImageClassification
   *
   * @return documentImageClassification
   */
  @JsonProperty(JSON_PROPERTY_DOCUMENT_IMAGE_CLASSIFICATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public DocumentImageClassificationDto getDocumentImageClassification() {
    return documentImageClassification;
  }

  @JsonIgnore
  public boolean getDocumentImageClassificationDefined() {
    return documentImageClassificationDefined;
  }

  @JsonProperty(JSON_PROPERTY_DOCUMENT_IMAGE_CLASSIFICATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDocumentImageClassification(
      DocumentImageClassificationDto documentImageClassification) {
    this.documentImageClassification = documentImageClassification;
    this.documentImageClassificationDefined = true;
  }

  public MachineLearningImageRecognitionResultDto opticalCharacterRecognition(
      OpticalCharacterRecognitionDto opticalCharacterRecognition) {
    this.opticalCharacterRecognition = opticalCharacterRecognition;
    this.opticalCharacterRecognitionDefined = true;
    return this;
  }

  /**
   * Get opticalCharacterRecognition
   *
   * @return opticalCharacterRecognition
   */
  @JsonProperty(JSON_PROPERTY_OPTICAL_CHARACTER_RECOGNITION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OpticalCharacterRecognitionDto getOpticalCharacterRecognition() {
    return opticalCharacterRecognition;
  }

  @JsonIgnore
  public boolean getOpticalCharacterRecognitionDefined() {
    return opticalCharacterRecognitionDefined;
  }

  @JsonProperty(JSON_PROPERTY_OPTICAL_CHARACTER_RECOGNITION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setOpticalCharacterRecognition(
      OpticalCharacterRecognitionDto opticalCharacterRecognition) {
    this.opticalCharacterRecognition = opticalCharacterRecognition;
    this.opticalCharacterRecognitionDefined = true;
  }

  public MachineLearningImageRecognitionResultDto documentFieldClassification(
      DocumentFieldClassificationDto documentFieldClassification) {
    this.documentFieldClassification = documentFieldClassification;
    this.documentFieldClassificationDefined = true;
    return this;
  }

  /**
   * Get documentFieldClassification
   *
   * @return documentFieldClassification
   */
  @JsonProperty(JSON_PROPERTY_DOCUMENT_FIELD_CLASSIFICATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public DocumentFieldClassificationDto getDocumentFieldClassification() {
    return documentFieldClassification;
  }

  @JsonIgnore
  public boolean getDocumentFieldClassificationDefined() {
    return documentFieldClassificationDefined;
  }

  @JsonProperty(JSON_PROPERTY_DOCUMENT_FIELD_CLASSIFICATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDocumentFieldClassification(
      DocumentFieldClassificationDto documentFieldClassification) {
    this.documentFieldClassification = documentFieldClassification;
    this.documentFieldClassificationDefined = true;
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
    MachineLearningImageRecognitionResultDto machineLearningImageRecognitionResult =
        (MachineLearningImageRecognitionResultDto) o;
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
    sb.append("class MachineLearningImageRecognitionResultDto {\n");
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
}