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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;

/** OffensiveAnalysisDto */
@JsonPropertyOrder({
  OffensiveAnalysisDto.JSON_PROPERTY_MESSAGE,
  OffensiveAnalysisDto.JSON_PROPERTY_URL,
  OffensiveAnalysisDto.JSON_PROPERTY_EVALUATION,
  OffensiveAnalysisDto.JSON_PROPERTY_SCORE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class OffensiveAnalysisDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_MESSAGE = "message";
  private String message;
  private boolean messageDefined = false;

  public static final String JSON_PROPERTY_URL = "url";
  private String url;
  private boolean urlDefined = false;

  /** A label, either SAFE or UNSAFE, that classifies the analyzed content. */
  public enum EvaluationEnum {
    SAFE("SAFE"),

    UNSAFE("UNSAFE"),

    UNKNOWN_DEFAULT_OPEN_API("unknown_default_open_api");

    private String value;

    EvaluationEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static EvaluationEnum fromValue(String value) {
      for (EvaluationEnum b : EvaluationEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return UNKNOWN_DEFAULT_OPEN_API;
    }
  }

  public static final String JSON_PROPERTY_EVALUATION = "evaluation";
  private String evaluation;
  private boolean evaluationDefined = false;

  public static final String JSON_PROPERTY_SCORE = "score";
  private Float score;
  private boolean scoreDefined = false;

  public OffensiveAnalysisDto() {}

  public OffensiveAnalysisDto message(String message) {
    this.message = message;
    this.messageDefined = true;
    return this;
  }

  /**
   * Either the message text or the URL of the image that was analyzed.
   *
   * @return message
   */
  @JsonProperty(JSON_PROPERTY_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getMessage() {
    return message;
  }

  @JsonIgnore
  public boolean getMessageDefined() {
    return messageDefined;
  }

  @JsonProperty(JSON_PROPERTY_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMessage(String message) {
    this.message = message;
    this.messageDefined = true;
  }

  public OffensiveAnalysisDto url(String url) {
    this.url = url;
    this.urlDefined = true;
    return this;
  }

  /**
   * URL of the image that was analyzed.
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

  public OffensiveAnalysisDto evaluation(String evaluation) {
    this.evaluation = evaluation;
    this.evaluationDefined = true;
    return this;
  }

  /**
   * A label, either SAFE or UNSAFE, that classifies the analyzed content.
   *
   * @return evaluation
   */
  @JsonProperty(JSON_PROPERTY_EVALUATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getEvaluation() {
    return evaluation;
  }

  @JsonIgnore
  public boolean getEvaluationDefined() {
    return evaluationDefined;
  }

  @JsonProperty(JSON_PROPERTY_EVALUATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEvaluation(String evaluation) {
    this.evaluation = evaluation;
    this.evaluationDefined = true;
  }

  public OffensiveAnalysisDto score(Float score) {
    this.score = score;
    this.scoreDefined = true;
    return this;
  }

  /**
   * The likelihood that the assigned evaluation represents the analyzed message correctly. 1 is the
   * maximum value, representing the highest likelihood that the content of the message matches the
   * evaluation. 0 is the minimum value, representing the lowest likelihood that the content of the
   * message matches the evaluation.
   *
   * @return score
   */
  @JsonProperty(JSON_PROPERTY_SCORE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Float getScore() {
    return score;
  }

  @JsonIgnore
  public boolean getScoreDefined() {
    return scoreDefined;
  }

  @JsonProperty(JSON_PROPERTY_SCORE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setScore(Float score) {
    this.score = score;
    this.scoreDefined = true;
  }

  /** Return true if this OffensiveAnalysis object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OffensiveAnalysisDto offensiveAnalysis = (OffensiveAnalysisDto) o;
    return Objects.equals(this.message, offensiveAnalysis.message)
        && Objects.equals(this.url, offensiveAnalysis.url)
        && Objects.equals(this.evaluation, offensiveAnalysis.evaluation)
        && Objects.equals(this.score, offensiveAnalysis.score);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message, url, evaluation, score);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OffensiveAnalysisDto {\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    evaluation: ").append(toIndentedString(evaluation)).append("\n");
    sb.append("    score: ").append(toIndentedString(score)).append("\n");
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