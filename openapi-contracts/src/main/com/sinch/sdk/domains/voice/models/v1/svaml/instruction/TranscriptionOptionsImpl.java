package com.sinch.sdk.domains.voice.models.v1.svaml.instruction;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  TranscriptionOptionsImpl.JSON_PROPERTY_ENABLED,
  TranscriptionOptionsImpl.JSON_PROPERTY_LOCALE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class TranscriptionOptionsImpl implements TranscriptionOptions {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ENABLED = "enabled";

  private OptionalValue<Boolean> enabled;

  public static final String JSON_PROPERTY_LOCALE = "locale";

  private OptionalValue<String> locale;

  public TranscriptionOptionsImpl() {}

  protected TranscriptionOptionsImpl(OptionalValue<Boolean> enabled, OptionalValue<String> locale) {
    this.enabled = enabled;
    this.locale = locale;
  }

  @JsonIgnore
  public Boolean getEnabled() {
    return enabled.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ENABLED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Boolean> enabled() {
    return enabled;
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

  /**
   * Return true if this svaml_instruction_startRecordingOptions_transcriptionOptions object is
   * equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TranscriptionOptionsImpl svamlInstructionStartRecordingOptionsTranscriptionOptions =
        (TranscriptionOptionsImpl) o;
    return Objects.equals(
            this.enabled, svamlInstructionStartRecordingOptionsTranscriptionOptions.enabled)
        && Objects.equals(
            this.locale, svamlInstructionStartRecordingOptionsTranscriptionOptions.locale);
  }

  @Override
  public int hashCode() {
    return Objects.hash(enabled, locale);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TranscriptionOptionsImpl {\n");
    sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
    sb.append("    locale: ").append(toIndentedString(locale)).append("\n");
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
  static class Builder implements TranscriptionOptions.Builder {
    OptionalValue<Boolean> enabled = OptionalValue.empty();
    OptionalValue<String> locale = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_ENABLED)
    public Builder setEnabled(Boolean enabled) {
      this.enabled = OptionalValue.of(enabled);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_LOCALE)
    public Builder setLocale(String locale) {
      this.locale = OptionalValue.of(locale);
      return this;
    }

    public TranscriptionOptions build() {
      return new TranscriptionOptionsImpl(enabled, locale);
    }
  }
}
