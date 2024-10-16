package com.sinch.sdk.domains.voice.models.v1.svaml.instruction;

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
  SvamlInstructionPlayFilesImpl.JSON_PROPERTY_NAME,
  SvamlInstructionPlayFilesImpl.JSON_PROPERTY_IDS,
  SvamlInstructionPlayFilesImpl.JSON_PROPERTY_LOCALE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class SvamlInstructionPlayFilesImpl
    implements SvamlInstructionPlayFiles,
        com.sinch.sdk.domains.voice.models.v1.svaml.instruction.SvamlInstruction {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_NAME = "name";

  private OptionalValue<NameEnum> name;

  public static final String JSON_PROPERTY_IDS = "ids";

  private OptionalValue<List<String>> ids;

  public static final String JSON_PROPERTY_LOCALE = "locale";

  private OptionalValue<String> locale;

  public SvamlInstructionPlayFilesImpl() {}

  protected SvamlInstructionPlayFilesImpl(
      OptionalValue<NameEnum> name, OptionalValue<List<String>> ids, OptionalValue<String> locale) {
    this.name = name;
    this.ids = ids;
    this.locale = locale;
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
  public List<String> getIds() {
    return ids.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_IDS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<List<String>> ids() {
    return ids;
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

  /** Return true if this svaml.instruction.playFiles object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SvamlInstructionPlayFilesImpl svamlInstructionPlayFiles = (SvamlInstructionPlayFilesImpl) o;
    return Objects.equals(this.name, svamlInstructionPlayFiles.name)
        && Objects.equals(this.ids, svamlInstructionPlayFiles.ids)
        && Objects.equals(this.locale, svamlInstructionPlayFiles.locale);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, ids, locale);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SvamlInstructionPlayFilesImpl {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    ids: ").append(toIndentedString(ids)).append("\n");
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
  static class Builder implements SvamlInstructionPlayFiles.Builder {
    OptionalValue<NameEnum> name = OptionalValue.of(NameEnum.PLAY_FILES);
    OptionalValue<List<String>> ids = OptionalValue.empty();
    OptionalValue<String> locale = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_IDS)
    public Builder setIds(List<String> ids) {
      this.ids = OptionalValue.of(ids);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_LOCALE)
    public Builder setLocale(String locale) {
      this.locale = OptionalValue.of(locale);
      return this;
    }

    public SvamlInstructionPlayFiles build() {
      return new SvamlInstructionPlayFilesImpl(name, ids, locale);
    }
  }
}
