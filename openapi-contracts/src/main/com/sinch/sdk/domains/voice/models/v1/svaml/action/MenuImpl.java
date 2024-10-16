package com.sinch.sdk.domains.voice.models.v1.svaml.action;

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
  MenuImpl.JSON_PROPERTY_ID,
  MenuImpl.JSON_PROPERTY_MAIN_PROMPT,
  MenuImpl.JSON_PROPERTY_REPEAT_PROMPT,
  MenuImpl.JSON_PROPERTY_REPEATS,
  MenuImpl.JSON_PROPERTY_MAX_DIGITS,
  MenuImpl.JSON_PROPERTY_TIMEOUT_MILLS,
  MenuImpl.JSON_PROPERTY_MAX_TIMEOUT_MILLS,
  MenuImpl.JSON_PROPERTY_OPTIONS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class MenuImpl implements Menu {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ID = "id";

  private OptionalValue<String> id;

  public static final String JSON_PROPERTY_MAIN_PROMPT = "mainPrompt";

  private OptionalValue<String> mainPrompt;

  public static final String JSON_PROPERTY_REPEAT_PROMPT = "repeatPrompt";

  private OptionalValue<String> repeatPrompt;

  public static final String JSON_PROPERTY_REPEATS = "repeats";

  private OptionalValue<Integer> repeats;

  public static final String JSON_PROPERTY_MAX_DIGITS = "maxDigits";

  private OptionalValue<Integer> maxDigits;

  public static final String JSON_PROPERTY_TIMEOUT_MILLS = "timeoutMills";

  private OptionalValue<Integer> timeoutMills;

  public static final String JSON_PROPERTY_MAX_TIMEOUT_MILLS = "maxTimeoutMills";

  private OptionalValue<Integer> maxTimeoutMills;

  public static final String JSON_PROPERTY_OPTIONS = "options";

  private OptionalValue<List<MenuOption>> options;

  public MenuImpl() {}

  protected MenuImpl(
      OptionalValue<String> id,
      OptionalValue<String> mainPrompt,
      OptionalValue<String> repeatPrompt,
      OptionalValue<Integer> repeats,
      OptionalValue<Integer> maxDigits,
      OptionalValue<Integer> timeoutMills,
      OptionalValue<Integer> maxTimeoutMills,
      OptionalValue<List<MenuOption>> options) {
    this.id = id;
    this.mainPrompt = mainPrompt;
    this.repeatPrompt = repeatPrompt;
    this.repeats = repeats;
    this.maxDigits = maxDigits;
    this.timeoutMills = timeoutMills;
    this.maxTimeoutMills = maxTimeoutMills;
    this.options = options;
  }

  @JsonIgnore
  public String getId() {
    return id.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> id() {
    return id;
  }

  @JsonIgnore
  public String getMainPrompt() {
    return mainPrompt.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MAIN_PROMPT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> mainPrompt() {
    return mainPrompt;
  }

  @JsonIgnore
  public String getRepeatPrompt() {
    return repeatPrompt.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_REPEAT_PROMPT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> repeatPrompt() {
    return repeatPrompt;
  }

  @JsonIgnore
  public Integer getRepeats() {
    return repeats.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_REPEATS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> repeats() {
    return repeats;
  }

  @JsonIgnore
  public Integer getMaxDigits() {
    return maxDigits.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MAX_DIGITS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> maxDigits() {
    return maxDigits;
  }

  @JsonIgnore
  public Integer getTimeoutMills() {
    return timeoutMills.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TIMEOUT_MILLS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> timeoutMills() {
    return timeoutMills;
  }

  @JsonIgnore
  public Integer getMaxTimeoutMills() {
    return maxTimeoutMills.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MAX_TIMEOUT_MILLS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> maxTimeoutMills() {
    return maxTimeoutMills;
  }

  @JsonIgnore
  public List<MenuOption> getOptions() {
    return options.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_OPTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<MenuOption>> options() {
    return options;
  }

  /** Return true if this menu object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MenuImpl menu = (MenuImpl) o;
    return Objects.equals(this.id, menu.id)
        && Objects.equals(this.mainPrompt, menu.mainPrompt)
        && Objects.equals(this.repeatPrompt, menu.repeatPrompt)
        && Objects.equals(this.repeats, menu.repeats)
        && Objects.equals(this.maxDigits, menu.maxDigits)
        && Objects.equals(this.timeoutMills, menu.timeoutMills)
        && Objects.equals(this.maxTimeoutMills, menu.maxTimeoutMills)
        && Objects.equals(this.options, menu.options);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        id, mainPrompt, repeatPrompt, repeats, maxDigits, timeoutMills, maxTimeoutMills, options);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MenuImpl {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    mainPrompt: ").append(toIndentedString(mainPrompt)).append("\n");
    sb.append("    repeatPrompt: ").append(toIndentedString(repeatPrompt)).append("\n");
    sb.append("    repeats: ").append(toIndentedString(repeats)).append("\n");
    sb.append("    maxDigits: ").append(toIndentedString(maxDigits)).append("\n");
    sb.append("    timeoutMills: ").append(toIndentedString(timeoutMills)).append("\n");
    sb.append("    maxTimeoutMills: ").append(toIndentedString(maxTimeoutMills)).append("\n");
    sb.append("    options: ").append(toIndentedString(options)).append("\n");
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
  static class Builder implements Menu.Builder {
    OptionalValue<String> id = OptionalValue.empty();
    OptionalValue<String> mainPrompt = OptionalValue.empty();
    OptionalValue<String> repeatPrompt = OptionalValue.empty();
    OptionalValue<Integer> repeats = OptionalValue.empty();
    OptionalValue<Integer> maxDigits = OptionalValue.empty();
    OptionalValue<Integer> timeoutMills = OptionalValue.empty();
    OptionalValue<Integer> maxTimeoutMills = OptionalValue.empty();
    OptionalValue<List<MenuOption>> options = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_ID)
    public Builder setId(String id) {
      this.id = OptionalValue.of(id);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MAIN_PROMPT)
    public Builder setMainPrompt(String mainPrompt) {
      this.mainPrompt = OptionalValue.of(mainPrompt);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_REPEAT_PROMPT)
    public Builder setRepeatPrompt(String repeatPrompt) {
      this.repeatPrompt = OptionalValue.of(repeatPrompt);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_REPEATS)
    public Builder setRepeats(Integer repeats) {
      this.repeats = OptionalValue.of(repeats);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MAX_DIGITS)
    public Builder setMaxDigits(Integer maxDigits) {
      this.maxDigits = OptionalValue.of(maxDigits);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TIMEOUT_MILLS)
    public Builder setTimeoutMills(Integer timeoutMills) {
      this.timeoutMills = OptionalValue.of(timeoutMills);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MAX_TIMEOUT_MILLS)
    public Builder setMaxTimeoutMills(Integer maxTimeoutMills) {
      this.maxTimeoutMills = OptionalValue.of(maxTimeoutMills);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_OPTIONS)
    public Builder setOptions(List<MenuOption> options) {
      this.options = OptionalValue.of(options);
      return this;
    }

    public Menu build() {
      return new MenuImpl(
          id, mainPrompt, repeatPrompt, repeats, maxDigits, timeoutMills, maxTimeoutMills, options);
    }
  }
}
