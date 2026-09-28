package com.sinch.sdk.domains.voice.models.v2.svaml.playback;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  SayImpl.JSON_PROPERTY_TEXT,
  SayImpl.JSON_PROPERTY_FORMAT,
  SayImpl.JSON_PROPERTY_VOICE_NAME
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class SayImpl implements Say {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TEXT = "text";

  private OptionalValue<String> text;

  public static final String JSON_PROPERTY_FORMAT = "format";

  private OptionalValue<FormatEnum> format;

  public static final String JSON_PROPERTY_VOICE_NAME = "voiceName";

  private OptionalValue<String> voiceName;

  public SayImpl() {}

  protected SayImpl(
      OptionalValue<String> text,
      OptionalValue<FormatEnum> format,
      OptionalValue<String> voiceName) {
    this.text = text;
    this.format = format;
    this.voiceName = voiceName;
  }

  @JsonIgnore
  public String getText() {
    return text.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TEXT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> text() {
    return text;
  }

  @JsonIgnore
  public FormatEnum getFormat() {
    return format.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FORMAT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<FormatEnum> format() {
    return format;
  }

  @JsonIgnore
  public String getVoiceName() {
    return voiceName.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_VOICE_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> voiceName() {
    return voiceName;
  }

  /** Return true if this Say object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SayImpl say = (SayImpl) o;
    return Objects.equals(this.text, say.text)
        && Objects.equals(this.format, say.format)
        && Objects.equals(this.voiceName, say.voiceName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(text, format, voiceName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SayImpl {\n");
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
    sb.append("    format: ").append(toIndentedString(format)).append("\n");
    sb.append("    voiceName: ").append(toIndentedString(voiceName)).append("\n");
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
  static class Builder implements Say.Builder {
    OptionalValue<String> text = OptionalValue.empty();
    OptionalValue<FormatEnum> format = OptionalValue.empty();
    OptionalValue<String> voiceName = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_TEXT, required = true)
    public Builder setText(String text) {
      this.text = OptionalValue.of(text);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_FORMAT)
    public Builder setFormat(FormatEnum format) {
      this.format = OptionalValue.of(format);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_VOICE_NAME, required = true)
    public Builder setVoiceName(String voiceName) {
      this.voiceName = OptionalValue.of(voiceName);
      return this;
    }

    public Say build() {
      return new SayImpl(text, format, voiceName);
    }
  }
}
