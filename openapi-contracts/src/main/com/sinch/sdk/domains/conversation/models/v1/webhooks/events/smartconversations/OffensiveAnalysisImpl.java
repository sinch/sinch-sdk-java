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
  OffensiveAnalysisImpl.JSON_PROPERTY_MESSAGE,
  OffensiveAnalysisImpl.JSON_PROPERTY_URL,
  OffensiveAnalysisImpl.JSON_PROPERTY_EVALUATION,
  OffensiveAnalysisImpl.JSON_PROPERTY_SCORE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class OffensiveAnalysisImpl implements OffensiveAnalysis {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_MESSAGE = "message";

  private OptionalValue<String> message;

  public static final String JSON_PROPERTY_URL = "url";

  private OptionalValue<String> url;

  public static final String JSON_PROPERTY_EVALUATION = "evaluation";

  private OptionalValue<EvaluationEnum> evaluation;

  public static final String JSON_PROPERTY_SCORE = "score";

  private OptionalValue<Float> score;

  public OffensiveAnalysisImpl() {}

  protected OffensiveAnalysisImpl(
      OptionalValue<String> message,
      OptionalValue<String> url,
      OptionalValue<EvaluationEnum> evaluation,
      OptionalValue<Float> score) {
    this.message = message;
    this.url = url;
    this.evaluation = evaluation;
    this.score = score;
  }

  @JsonIgnore
  public String getMessage() {
    return message.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> message() {
    return message;
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
  public EvaluationEnum getEvaluation() {
    return evaluation.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_EVALUATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<EvaluationEnum> evaluation() {
    return evaluation;
  }

  @JsonIgnore
  public Float getScore() {
    return score.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SCORE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Float> score() {
    return score;
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
    OffensiveAnalysisImpl offensiveAnalysis = (OffensiveAnalysisImpl) o;
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
    sb.append("class OffensiveAnalysisImpl {\n");
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

  @JsonPOJOBuilder(withPrefix = "set")
  static class Builder implements OffensiveAnalysis.Builder {
    OptionalValue<String> message = OptionalValue.empty();
    OptionalValue<String> url = OptionalValue.empty();
    OptionalValue<EvaluationEnum> evaluation = OptionalValue.empty();
    OptionalValue<Float> score = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_MESSAGE)
    public Builder setMessage(String message) {
      this.message = OptionalValue.of(message);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_URL)
    public Builder setUrl(String url) {
      this.url = OptionalValue.of(url);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_EVALUATION)
    public Builder setEvaluation(EvaluationEnum evaluation) {
      this.evaluation = OptionalValue.of(evaluation);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SCORE)
    public Builder setScore(Float score) {
      this.score = OptionalValue.of(score);
      return this;
    }

    public OffensiveAnalysis build() {
      return new OffensiveAnalysisImpl(message, url, evaluation, score);
    }
  }
}
