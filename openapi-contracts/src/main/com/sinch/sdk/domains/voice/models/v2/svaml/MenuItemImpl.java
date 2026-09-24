package com.sinch.sdk.domains.voice.models.v2.svaml;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonPropertyOrder({
  MenuItemImpl.JSON_PROPERTY_PROMPT,
  MenuItemImpl.JSON_PROPERTY_REPEAT_PROMPT,
  MenuItemImpl.JSON_PROPERTY_INPUT_TIMEOUT_DURATION_SECONDS,
  MenuItemImpl.JSON_PROPERTY_REPEAT_COUNT,
  MenuItemImpl.JSON_PROPERTY_MINIMUM_INPUT_LENGTH,
  MenuItemImpl.JSON_PROPERTY_MAXIMUM_INPUT_LENGTH,
  MenuItemImpl.JSON_PROPERTY_TERMINATING_SEQUENCE,
  MenuItemImpl.JSON_PROPERTY_INPUT_METHODS,
  MenuItemImpl.JSON_PROPERTY_MATCHES,
  MenuItemImpl.JSON_PROPERTY_ON_FAIL
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class MenuItemImpl implements MenuItem {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_PROMPT = "prompt";

  private OptionalValue<MenuPrompt> prompt;

  public static final String JSON_PROPERTY_REPEAT_PROMPT = "repeatPrompt";

  private OptionalValue<MenuPrompt> repeatPrompt;

  public static final String JSON_PROPERTY_INPUT_TIMEOUT_DURATION_SECONDS =
      "inputTimeoutDurationSeconds";

  private OptionalValue<Integer> inputTimeoutDurationSeconds;

  public static final String JSON_PROPERTY_REPEAT_COUNT = "repeatCount";

  private OptionalValue<Integer> repeatCount;

  public static final String JSON_PROPERTY_MINIMUM_INPUT_LENGTH = "minimumInputLength";

  private OptionalValue<Integer> minimumInputLength;

  public static final String JSON_PROPERTY_MAXIMUM_INPUT_LENGTH = "maximumInputLength";

  private OptionalValue<Integer> maximumInputLength;

  public static final String JSON_PROPERTY_TERMINATING_SEQUENCE = "terminatingSequence";

  private OptionalValue<String> terminatingSequence;

  public static final String JSON_PROPERTY_INPUT_METHODS = "inputMethods";

  private OptionalValue<List<InputMethodsEnum>> inputMethods;

  public static final String JSON_PROPERTY_MATCHES = "matches";

  private OptionalValue<Map<String, List<SvamlCommand>>> matches;

  public static final String JSON_PROPERTY_ON_FAIL = "onFail";

  private OptionalValue<List<SvamlCommand>> onFail;

  public MenuItemImpl() {}

  protected MenuItemImpl(
      OptionalValue<MenuPrompt> prompt,
      OptionalValue<MenuPrompt> repeatPrompt,
      OptionalValue<Integer> inputTimeoutDurationSeconds,
      OptionalValue<Integer> repeatCount,
      OptionalValue<Integer> minimumInputLength,
      OptionalValue<Integer> maximumInputLength,
      OptionalValue<String> terminatingSequence,
      OptionalValue<List<InputMethodsEnum>> inputMethods,
      OptionalValue<Map<String, List<SvamlCommand>>> matches,
      OptionalValue<List<SvamlCommand>> onFail) {
    this.prompt = prompt;
    this.repeatPrompt = repeatPrompt;
    this.inputTimeoutDurationSeconds = inputTimeoutDurationSeconds;
    this.repeatCount = repeatCount;
    this.minimumInputLength = minimumInputLength;
    this.maximumInputLength = maximumInputLength;
    this.terminatingSequence = terminatingSequence;
    this.inputMethods = inputMethods;
    this.matches = matches;
    this.onFail = onFail;
  }

  @JsonIgnore
  public MenuPrompt getPrompt() {
    return prompt.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PROMPT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<MenuPrompt> prompt() {
    return prompt;
  }

  @JsonIgnore
  public MenuPrompt getRepeatPrompt() {
    return repeatPrompt.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_REPEAT_PROMPT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<MenuPrompt> repeatPrompt() {
    return repeatPrompt;
  }

  @JsonIgnore
  public Integer getInputTimeoutDurationSeconds() {
    return inputTimeoutDurationSeconds.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_INPUT_TIMEOUT_DURATION_SECONDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> inputTimeoutDurationSeconds() {
    return inputTimeoutDurationSeconds;
  }

  @JsonIgnore
  public Integer getRepeatCount() {
    return repeatCount.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_REPEAT_COUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> repeatCount() {
    return repeatCount;
  }

  @JsonIgnore
  public Integer getMinimumInputLength() {
    return minimumInputLength.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MINIMUM_INPUT_LENGTH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> minimumInputLength() {
    return minimumInputLength;
  }

  @JsonIgnore
  public Integer getMaximumInputLength() {
    return maximumInputLength.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MAXIMUM_INPUT_LENGTH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> maximumInputLength() {
    return maximumInputLength;
  }

  @JsonIgnore
  public String getTerminatingSequence() {
    return terminatingSequence.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TERMINATING_SEQUENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> terminatingSequence() {
    return terminatingSequence;
  }

  @JsonIgnore
  public List<InputMethodsEnum> getInputMethods() {
    return inputMethods.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_INPUT_METHODS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<InputMethodsEnum>> inputMethods() {
    return inputMethods;
  }

  @JsonIgnore
  public Map<String, List<SvamlCommand>> getMatches() {
    return matches.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MATCHES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Map<String, List<SvamlCommand>>> matches() {
    return matches;
  }

  @JsonIgnore
  public List<SvamlCommand> getOnFail() {
    return onFail.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ON_FAIL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<SvamlCommand>> onFail() {
    return onFail;
  }

  /** Return true if this MenuItem object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MenuItemImpl menuItem = (MenuItemImpl) o;
    return Objects.equals(this.prompt, menuItem.prompt)
        && Objects.equals(this.repeatPrompt, menuItem.repeatPrompt)
        && Objects.equals(this.inputTimeoutDurationSeconds, menuItem.inputTimeoutDurationSeconds)
        && Objects.equals(this.repeatCount, menuItem.repeatCount)
        && Objects.equals(this.minimumInputLength, menuItem.minimumInputLength)
        && Objects.equals(this.maximumInputLength, menuItem.maximumInputLength)
        && Objects.equals(this.terminatingSequence, menuItem.terminatingSequence)
        && Objects.equals(this.inputMethods, menuItem.inputMethods)
        && Objects.equals(this.matches, menuItem.matches)
        && Objects.equals(this.onFail, menuItem.onFail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        prompt,
        repeatPrompt,
        inputTimeoutDurationSeconds,
        repeatCount,
        minimumInputLength,
        maximumInputLength,
        terminatingSequence,
        inputMethods,
        matches,
        onFail);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MenuItemImpl {\n");
    sb.append("    prompt: ").append(toIndentedString(prompt)).append("\n");
    sb.append("    repeatPrompt: ").append(toIndentedString(repeatPrompt)).append("\n");
    sb.append("    inputTimeoutDurationSeconds: ")
        .append(toIndentedString(inputTimeoutDurationSeconds))
        .append("\n");
    sb.append("    repeatCount: ").append(toIndentedString(repeatCount)).append("\n");
    sb.append("    minimumInputLength: ").append(toIndentedString(minimumInputLength)).append("\n");
    sb.append("    maximumInputLength: ").append(toIndentedString(maximumInputLength)).append("\n");
    sb.append("    terminatingSequence: ")
        .append(toIndentedString(terminatingSequence))
        .append("\n");
    sb.append("    inputMethods: ").append(toIndentedString(inputMethods)).append("\n");
    sb.append("    matches: ").append(toIndentedString(matches)).append("\n");
    sb.append("    onFail: ").append(toIndentedString(onFail)).append("\n");
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
  static class Builder implements MenuItem.Builder {
    OptionalValue<MenuPrompt> prompt = OptionalValue.empty();
    OptionalValue<MenuPrompt> repeatPrompt = OptionalValue.empty();
    OptionalValue<Integer> inputTimeoutDurationSeconds = OptionalValue.empty();
    OptionalValue<Integer> repeatCount = OptionalValue.empty();
    OptionalValue<Integer> minimumInputLength = OptionalValue.empty();
    OptionalValue<Integer> maximumInputLength = OptionalValue.empty();
    OptionalValue<String> terminatingSequence = OptionalValue.empty();
    OptionalValue<List<InputMethodsEnum>> inputMethods = OptionalValue.empty();
    OptionalValue<Map<String, List<SvamlCommand>>> matches = OptionalValue.empty();
    OptionalValue<List<SvamlCommand>> onFail = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_PROMPT)
    public Builder setPrompt(MenuPrompt prompt) {
      this.prompt = OptionalValue.of(prompt);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_REPEAT_PROMPT)
    public Builder setRepeatPrompt(MenuPrompt repeatPrompt) {
      this.repeatPrompt = OptionalValue.of(repeatPrompt);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_INPUT_TIMEOUT_DURATION_SECONDS)
    public Builder setInputTimeoutDurationSeconds(Integer inputTimeoutDurationSeconds) {
      this.inputTimeoutDurationSeconds = OptionalValue.of(inputTimeoutDurationSeconds);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_REPEAT_COUNT)
    public Builder setRepeatCount(Integer repeatCount) {
      this.repeatCount = OptionalValue.of(repeatCount);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MINIMUM_INPUT_LENGTH)
    public Builder setMinimumInputLength(Integer minimumInputLength) {
      this.minimumInputLength = OptionalValue.of(minimumInputLength);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MAXIMUM_INPUT_LENGTH)
    public Builder setMaximumInputLength(Integer maximumInputLength) {
      this.maximumInputLength = OptionalValue.of(maximumInputLength);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TERMINATING_SEQUENCE)
    public Builder setTerminatingSequence(String terminatingSequence) {
      this.terminatingSequence = OptionalValue.of(terminatingSequence);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_INPUT_METHODS)
    public Builder setInputMethods(List<InputMethodsEnum> inputMethods) {
      this.inputMethods = OptionalValue.of(inputMethods);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MATCHES)
    public Builder setMatches(Map<String, List<SvamlCommand>> matches) {
      this.matches = OptionalValue.of(matches);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ON_FAIL)
    public Builder setOnFail(List<SvamlCommand> onFail) {
      this.onFail = OptionalValue.of(onFail);
      return this;
    }

    public MenuItem build() {
      return new MenuItemImpl(
          prompt,
          repeatPrompt,
          inputTimeoutDurationSeconds,
          repeatCount,
          minimumInputLength,
          maximumInputLength,
          terminatingSequence,
          inputMethods,
          matches,
          onFail);
    }
  }
}
