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
  MachineLearningNLUResultImpl.JSON_PROPERTY_MESSAGE,
  MachineLearningNLUResultImpl.JSON_PROPERTY_RESULTS,
  MachineLearningNLUResultImpl.JSON_PROPERTY_INTENT,
  MachineLearningNLUResultImpl.JSON_PROPERTY_SCORE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class MachineLearningNLUResultImpl implements MachineLearningNLUResult {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_MESSAGE = "message";

  private OptionalValue<String> message;

  public static final String JSON_PROPERTY_RESULTS = "results";

  private OptionalValue<List<IntentResult>> results;

  public static final String JSON_PROPERTY_INTENT = "intent";

  private OptionalValue<String> intent;

  public static final String JSON_PROPERTY_SCORE = "score";

  private OptionalValue<Float> score;

  public MachineLearningNLUResultImpl() {}

  protected MachineLearningNLUResultImpl(
      OptionalValue<String> message,
      OptionalValue<List<IntentResult>> results,
      OptionalValue<String> intent,
      OptionalValue<Float> score) {
    this.message = message;
    this.results = results;
    this.intent = intent;
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
  public List<IntentResult> getResults() {
    return results.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_RESULTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<IntentResult>> results() {
    return results;
  }

  @JsonIgnore
  public String getIntent() {
    return intent.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_INTENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> intent() {
    return intent;
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

  /** Return true if this MachineLearningNLUResult object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MachineLearningNLUResultImpl machineLearningNLUResult = (MachineLearningNLUResultImpl) o;
    return Objects.equals(this.message, machineLearningNLUResult.message)
        && Objects.equals(this.results, machineLearningNLUResult.results)
        && Objects.equals(this.intent, machineLearningNLUResult.intent)
        && Objects.equals(this.score, machineLearningNLUResult.score);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message, results, intent, score);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MachineLearningNLUResultImpl {\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    results: ").append(toIndentedString(results)).append("\n");
    sb.append("    intent: ").append(toIndentedString(intent)).append("\n");
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
  static class Builder implements MachineLearningNLUResult.Builder {
    OptionalValue<String> message = OptionalValue.empty();
    OptionalValue<List<IntentResult>> results = OptionalValue.empty();
    OptionalValue<String> intent = OptionalValue.empty();
    OptionalValue<Float> score = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_MESSAGE)
    public Builder setMessage(String message) {
      this.message = OptionalValue.of(message);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_RESULTS)
    public Builder setResults(List<IntentResult> results) {
      this.results = OptionalValue.of(results);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_INTENT)
    public Builder setIntent(String intent) {
      this.intent = OptionalValue.of(intent);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SCORE)
    public Builder setScore(Float score) {
      this.score = OptionalValue.of(score);
      return this;
    }

    public MachineLearningNLUResult build() {
      return new MachineLearningNLUResultImpl(message, results, intent, score);
    }
  }
}
