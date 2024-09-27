package com.sinch.sdk.domains.conversation.models.v1.webhooks.events.smartconversations;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({IntentResultImpl.JSON_PROPERTY_INTENT, IntentResultImpl.JSON_PROPERTY_SCORE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class IntentResultImpl implements IntentResult {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_INTENT = "intent";

  private OptionalValue<String> intent;

  public static final String JSON_PROPERTY_SCORE = "score";

  private OptionalValue<Float> score;

  public IntentResultImpl() {}

  protected IntentResultImpl(OptionalValue<String> intent, OptionalValue<Float> score) {
    this.intent = intent;
    this.score = score;
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

  /** Return true if this IntentResult object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IntentResultImpl intentResult = (IntentResultImpl) o;
    return Objects.equals(this.intent, intentResult.intent)
        && Objects.equals(this.score, intentResult.score);
  }

  @Override
  public int hashCode() {
    return Objects.hash(intent, score);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IntentResultImpl {\n");
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
  static class Builder implements IntentResult.Builder {
    OptionalValue<String> intent = OptionalValue.empty();
    OptionalValue<Float> score = OptionalValue.empty();

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

    public IntentResult build() {
      return new IntentResultImpl(intent, score);
    }
  }
}
