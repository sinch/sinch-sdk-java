package com.sinch.sdk.domains.voice.models.v1.svaml.action;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  SvamlActionParkImpl.JSON_PROPERTY_NAME,
  SvamlActionParkImpl.JSON_PROPERTY_LOCALE,
  SvamlActionParkImpl.JSON_PROPERTY_INTRO_PROMPT,
  SvamlActionParkImpl.JSON_PROPERTY_HOLD_PROMPT,
  SvamlActionParkImpl.JSON_PROPERTY_MAX_DURATION
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class SvamlActionParkImpl
    implements SvamlActionPark, com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlAction {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_NAME = "name";

  private OptionalValue<NameEnum> name;

  public static final String JSON_PROPERTY_LOCALE = "locale";

  private OptionalValue<String> locale;

  public static final String JSON_PROPERTY_INTRO_PROMPT = "introPrompt";

  private OptionalValue<String> introPrompt;

  public static final String JSON_PROPERTY_HOLD_PROMPT = "holdPrompt";

  private OptionalValue<String> holdPrompt;

  public static final String JSON_PROPERTY_MAX_DURATION = "maxDuration";

  private OptionalValue<Integer> maxDuration;

  public SvamlActionParkImpl() {}

  protected SvamlActionParkImpl(
      OptionalValue<NameEnum> name,
      OptionalValue<String> locale,
      OptionalValue<String> introPrompt,
      OptionalValue<String> holdPrompt,
      OptionalValue<Integer> maxDuration) {
    this.name = name;
    this.locale = locale;
    this.introPrompt = introPrompt;
    this.holdPrompt = holdPrompt;
    this.maxDuration = maxDuration;
  }

  @JsonIgnore
  public NameEnum getName() {
    return name.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<NameEnum> name() {
    return name;
  }

  @JsonIgnore
  public String getLocale() {
    return locale.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_LOCALE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> locale() {
    return locale;
  }

  @JsonIgnore
  public String getIntroPrompt() {
    return introPrompt.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_INTRO_PROMPT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> introPrompt() {
    return introPrompt;
  }

  @JsonIgnore
  public String getHoldPrompt() {
    return holdPrompt.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_HOLD_PROMPT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> holdPrompt() {
    return holdPrompt;
  }

  @JsonIgnore
  public Integer getMaxDuration() {
    return maxDuration.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MAX_DURATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> maxDuration() {
    return maxDuration;
  }

  /** Return true if this svaml.action.park object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SvamlActionParkImpl svamlActionPark = (SvamlActionParkImpl) o;
    return Objects.equals(this.name, svamlActionPark.name)
        && Objects.equals(this.locale, svamlActionPark.locale)
        && Objects.equals(this.introPrompt, svamlActionPark.introPrompt)
        && Objects.equals(this.holdPrompt, svamlActionPark.holdPrompt)
        && Objects.equals(this.maxDuration, svamlActionPark.maxDuration);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, locale, introPrompt, holdPrompt, maxDuration);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SvamlActionParkImpl {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    locale: ").append(toIndentedString(locale)).append("\n");
    sb.append("    introPrompt: ").append(toIndentedString(introPrompt)).append("\n");
    sb.append("    holdPrompt: ").append(toIndentedString(holdPrompt)).append("\n");
    sb.append("    maxDuration: ").append(toIndentedString(maxDuration)).append("\n");
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
  static class Builder implements SvamlActionPark.Builder {
    OptionalValue<NameEnum> name = OptionalValue.of(NameEnum.PARK);
    OptionalValue<String> locale = OptionalValue.empty();
    OptionalValue<String> introPrompt = OptionalValue.empty();
    OptionalValue<String> holdPrompt = OptionalValue.empty();
    OptionalValue<Integer> maxDuration = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_LOCALE)
    public Builder setLocale(String locale) {
      this.locale = OptionalValue.of(locale);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_INTRO_PROMPT)
    public Builder setIntroPrompt(String introPrompt) {
      this.introPrompt = OptionalValue.of(introPrompt);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_HOLD_PROMPT)
    public Builder setHoldPrompt(String holdPrompt) {
      this.holdPrompt = OptionalValue.of(holdPrompt);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MAX_DURATION)
    public Builder setMaxDuration(Integer maxDuration) {
      this.maxDuration = OptionalValue.of(maxDuration);
      return this;
    }

    public SvamlActionPark build() {
      return new SvamlActionParkImpl(name, locale, introPrompt, holdPrompt, maxDuration);
    }
  }
}
