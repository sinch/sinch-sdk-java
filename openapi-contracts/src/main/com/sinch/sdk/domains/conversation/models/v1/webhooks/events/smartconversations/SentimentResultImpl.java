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
  SentimentResultImpl.JSON_PROPERTY_SENTIMENT,
  SentimentResultImpl.JSON_PROPERTY_SCORE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class SentimentResultImpl implements SentimentResult {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_SENTIMENT = "sentiment";

  private OptionalValue<Sentiment> sentiment;

  public static final String JSON_PROPERTY_SCORE = "score";

  private OptionalValue<Float> score;

  public SentimentResultImpl() {}

  protected SentimentResultImpl(OptionalValue<Sentiment> sentiment, OptionalValue<Float> score) {
    this.sentiment = sentiment;
    this.score = score;
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

  /** Return true if this SentimentResult object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SentimentResultImpl sentimentResult = (SentimentResultImpl) o;
    return Objects.equals(this.sentiment, sentimentResult.sentiment)
        && Objects.equals(this.score, sentimentResult.score);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sentiment, score);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SentimentResultImpl {\n");
    sb.append("    sentiment: ").append(toIndentedString(sentiment)).append("\n");
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
  static class Builder implements SentimentResult.Builder {
    OptionalValue<Sentiment> sentiment = OptionalValue.empty();
    OptionalValue<Float> score = OptionalValue.empty();

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

    public SentimentResult build() {
      return new SentimentResultImpl(sentiment, score);
    }
  }
}
