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

@JsonPropertyOrder({
  AnalysisResultImpl.JSON_PROPERTY_ML_SENTIMENT_RESULT,
  AnalysisResultImpl.JSON_PROPERTY_ML_NLU_RESULT,
  AnalysisResultImpl.JSON_PROPERTY_ML_IMAGE_RECOGNITION_RESULT,
  AnalysisResultImpl.JSON_PROPERTY_ML_PII_RESULT,
  AnalysisResultImpl.JSON_PROPERTY_ML_OFFENSIVE_ANALYSIS_RESULT
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class AnalysisResultImpl implements AnalysisResult {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ML_SENTIMENT_RESULT = "ml_sentiment_result";

  private OptionalValue<List<MachineLearningSentimentResult>> mlSentimentResult;

  public static final String JSON_PROPERTY_ML_NLU_RESULT = "ml_nlu_result";

  private OptionalValue<List<MachineLearningNLUResult>> mlNluResult;

  public static final String JSON_PROPERTY_ML_IMAGE_RECOGNITION_RESULT =
      "ml_image_recognition_result";

  private OptionalValue<List<MachineLearningImageRecognitionResult>> mlImageRecognitionResult;

  public static final String JSON_PROPERTY_ML_PII_RESULT = "ml_pii_result";

  private OptionalValue<List<MachineLearningPIIResult>> mlPiiResult;

  public static final String JSON_PROPERTY_ML_OFFENSIVE_ANALYSIS_RESULT =
      "ml_offensive_analysis_result";

  private OptionalValue<List<OffensiveAnalysis>> mlOffensiveAnalysisResult;

  public AnalysisResultImpl() {}

  protected AnalysisResultImpl(
      OptionalValue<List<MachineLearningSentimentResult>> mlSentimentResult,
      OptionalValue<List<MachineLearningNLUResult>> mlNluResult,
      OptionalValue<List<MachineLearningImageRecognitionResult>> mlImageRecognitionResult,
      OptionalValue<List<MachineLearningPIIResult>> mlPiiResult,
      OptionalValue<List<OffensiveAnalysis>> mlOffensiveAnalysisResult) {
    this.mlSentimentResult = mlSentimentResult;
    this.mlNluResult = mlNluResult;
    this.mlImageRecognitionResult = mlImageRecognitionResult;
    this.mlPiiResult = mlPiiResult;
    this.mlOffensiveAnalysisResult = mlOffensiveAnalysisResult;
  }

  @JsonIgnore
  public List<MachineLearningSentimentResult> getMlSentimentResult() {
    return mlSentimentResult.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ML_SENTIMENT_RESULT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<MachineLearningSentimentResult>> mlSentimentResult() {
    return mlSentimentResult;
  }

  @JsonIgnore
  public List<MachineLearningNLUResult> getMlNluResult() {
    return mlNluResult.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ML_NLU_RESULT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<MachineLearningNLUResult>> mlNluResult() {
    return mlNluResult;
  }

  @JsonIgnore
  public List<MachineLearningImageRecognitionResult> getMlImageRecognitionResult() {
    return mlImageRecognitionResult.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ML_IMAGE_RECOGNITION_RESULT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<MachineLearningImageRecognitionResult>> mlImageRecognitionResult() {
    return mlImageRecognitionResult;
  }

  @JsonIgnore
  public List<MachineLearningPIIResult> getMlPiiResult() {
    return mlPiiResult.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ML_PII_RESULT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<MachineLearningPIIResult>> mlPiiResult() {
    return mlPiiResult;
  }

  @JsonIgnore
  public List<OffensiveAnalysis> getMlOffensiveAnalysisResult() {
    return mlOffensiveAnalysisResult.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ML_OFFENSIVE_ANALYSIS_RESULT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<OffensiveAnalysis>> mlOffensiveAnalysisResult() {
    return mlOffensiveAnalysisResult;
  }

  /** Return true if this AnalysisResult object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AnalysisResultImpl analysisResult = (AnalysisResultImpl) o;
    return Objects.equals(this.mlSentimentResult, analysisResult.mlSentimentResult)
        && Objects.equals(this.mlNluResult, analysisResult.mlNluResult)
        && Objects.equals(this.mlImageRecognitionResult, analysisResult.mlImageRecognitionResult)
        && Objects.equals(this.mlPiiResult, analysisResult.mlPiiResult)
        && Objects.equals(this.mlOffensiveAnalysisResult, analysisResult.mlOffensiveAnalysisResult);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        mlSentimentResult,
        mlNluResult,
        mlImageRecognitionResult,
        mlPiiResult,
        mlOffensiveAnalysisResult);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AnalysisResultImpl {\n");
    sb.append("    mlSentimentResult: ").append(toIndentedString(mlSentimentResult)).append("\n");
    sb.append("    mlNluResult: ").append(toIndentedString(mlNluResult)).append("\n");
    sb.append("    mlImageRecognitionResult: ")
        .append(toIndentedString(mlImageRecognitionResult))
        .append("\n");
    sb.append("    mlPiiResult: ").append(toIndentedString(mlPiiResult)).append("\n");
    sb.append("    mlOffensiveAnalysisResult: ")
        .append(toIndentedString(mlOffensiveAnalysisResult))
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
  static class Builder implements AnalysisResult.Builder {
    OptionalValue<List<MachineLearningSentimentResult>> mlSentimentResult = OptionalValue.empty();
    OptionalValue<List<MachineLearningNLUResult>> mlNluResult = OptionalValue.empty();
    OptionalValue<List<MachineLearningImageRecognitionResult>> mlImageRecognitionResult =
        OptionalValue.empty();
    OptionalValue<List<MachineLearningPIIResult>> mlPiiResult = OptionalValue.empty();
    OptionalValue<List<OffensiveAnalysis>> mlOffensiveAnalysisResult = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_ML_SENTIMENT_RESULT)
    public Builder setMlSentimentResult(List<MachineLearningSentimentResult> mlSentimentResult) {
      this.mlSentimentResult = OptionalValue.of(mlSentimentResult);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ML_NLU_RESULT)
    public Builder setMlNluResult(List<MachineLearningNLUResult> mlNluResult) {
      this.mlNluResult = OptionalValue.of(mlNluResult);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ML_IMAGE_RECOGNITION_RESULT)
    public Builder setMlImageRecognitionResult(
        List<MachineLearningImageRecognitionResult> mlImageRecognitionResult) {
      this.mlImageRecognitionResult = OptionalValue.of(mlImageRecognitionResult);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ML_PII_RESULT)
    public Builder setMlPiiResult(List<MachineLearningPIIResult> mlPiiResult) {
      this.mlPiiResult = OptionalValue.of(mlPiiResult);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ML_OFFENSIVE_ANALYSIS_RESULT)
    public Builder setMlOffensiveAnalysisResult(List<OffensiveAnalysis> mlOffensiveAnalysisResult) {
      this.mlOffensiveAnalysisResult = OptionalValue.of(mlOffensiveAnalysisResult);
      return this;
    }

    public AnalysisResult build() {
      return new AnalysisResultImpl(
          mlSentimentResult,
          mlNluResult,
          mlImageRecognitionResult,
          mlPiiResult,
          mlOffensiveAnalysisResult);
    }
  }
}
