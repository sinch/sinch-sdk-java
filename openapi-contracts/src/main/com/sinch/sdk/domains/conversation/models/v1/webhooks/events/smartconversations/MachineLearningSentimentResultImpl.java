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
  MachineLearningSentimentResultImpl.JSON_PROPERTY_SENTIMENT,
  MachineLearningSentimentResultImpl.JSON_PROPERTY_SCORE,
  MachineLearningSentimentResultImpl.JSON_PROPERTY_MESSAGE,
  MachineLearningSentimentResultImpl.JSON_PROPERTY_RESULTS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class MachineLearningSentimentResultImpl implements MachineLearningSentimentResult {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_SENTIMENT = "sentiment";

  private OptionalValue<Sentiment> sentiment;

  public static final String JSON_PROPERTY_SCORE = "score";

  private OptionalValue<Float> score;

  public static final String JSON_PROPERTY_MESSAGE = "message";

  private OptionalValue<String> message;

  public static final String JSON_PROPERTY_RESULTS = "results";

  private OptionalValue<List<SentimentResult>> results;

  public MachineLearningSentimentResultImpl() {}

  protected MachineLearningSentimentResultImpl(
      OptionalValue<Sentiment> sentiment,
      OptionalValue<Float> score,
      OptionalValue<String> message,
      OptionalValue<List<SentimentResult>> results) {
    this.sentiment = sentiment;
    this.score = score;
    this.message = message;
    this.results = results;
  }

  @JsonIgnore
  public Sentiment getSentiment() {
    return sentiment.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SENTIMENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Sentiment> sentiment() {
    return sentiment;
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
  public List<SentimentResult> getResults() {
    return results.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_RESULTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<SentimentResult>> results() {
    return results;
  }

  /** Return true if this MachineLearningSentimentResult object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MachineLearningSentimentResultImpl machineLearningSentimentResult =
        (MachineLearningSentimentResultImpl) o;
    return Objects.equals(this.sentiment, machineLearningSentimentResult.sentiment)
        && Objects.equals(this.score, machineLearningSentimentResult.score)
        && Objects.equals(this.message, machineLearningSentimentResult.message)
        && Objects.equals(this.results, machineLearningSentimentResult.results);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sentiment, score, message, results);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MachineLearningSentimentResultImpl {\n");
    sb.append("    sentiment: ").append(toIndentedString(sentiment)).append("\n");
    sb.append("    score: ").append(toIndentedString(score)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    results: ").append(toIndentedString(results)).append("\n");
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
  static class Builder implements MachineLearningSentimentResult.Builder {
    OptionalValue<Sentiment> sentiment = OptionalValue.empty();
    OptionalValue<Float> score = OptionalValue.empty();
    OptionalValue<String> message = OptionalValue.empty();
    OptionalValue<List<SentimentResult>> results = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_SENTIMENT)
    public Builder setSentiment(Sentiment sentiment) {
      this.sentiment = OptionalValue.of(sentiment);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SCORE)
    public Builder setScore(Float score) {
      this.score = OptionalValue.of(score);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MESSAGE)
    public Builder setMessage(String message) {
      this.message = OptionalValue.of(message);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_RESULTS)
    public Builder setResults(List<SentimentResult> results) {
      this.results = OptionalValue.of(results);
      return this;
    }

    public MachineLearningSentimentResult build() {
      return new MachineLearningSentimentResultImpl(sentiment, score, message, results);
    }
  }
}
