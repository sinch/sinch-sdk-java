/*
 * Voice API | Sinch
 * The Voice API exposes calling- and conference-related functionality in the Sinch Voice Platform.
 *
 * The version of the OpenAPI document: 1.0.1
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.voice.models.dto.v1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Plays Interactive Voice Response (IVR) files for the supported locale or SSML commands at the
 * Sinch backend. An IVR message is played only on the caller&#39;s side.
 */
@JsonPropertyOrder({
  SvamlInstructionPlayFilesDto.JSON_PROPERTY_NAME,
  SvamlInstructionPlayFilesDto.JSON_PROPERTY_IDS,
  SvamlInstructionPlayFilesDto.JSON_PROPERTY_LOCALE
})
// @javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class SvamlInstructionPlayFilesDto {
  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_IDS = "ids";
  private List<String> ids;

  public static final String JSON_PROPERTY_LOCALE = "locale";
  private String locale;

  public SvamlInstructionPlayFilesDto() {}

  public SvamlInstructionPlayFilesDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The &#x60;name&#x60; property. Must have the value &#x60;playFiles&#x60;.
   *
   * @return name
   */
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getName() {
    return name;
  }

  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setName(String name) {
    this.name = name;
  }

  public SvamlInstructionPlayFilesDto ids(List<String> ids) {
    this.ids = ids;
    return this;
  }

  public SvamlInstructionPlayFilesDto addIdsItem(String idsItem) {
    if (this.ids == null) {
      this.ids = new ArrayList<>();
    }
    this.ids.add(idsItem);
    return this;
  }

  /**
   * The IDs of the files which will be played. These can be a URL to a file, SSML commands using
   * the &#x60;#ssml[]&#x60; element, or text using the &#x60;#tts[]&#x60; element.
   *
   * @return ids
   */
  @JsonProperty(JSON_PROPERTY_IDS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public List<String> getIds() {
    return ids;
  }

  @JsonProperty(JSON_PROPERTY_IDS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setIds(List<String> ids) {
    this.ids = ids;
  }

  public SvamlInstructionPlayFilesDto locale(String locale) {
    this.locale = locale;
    return this;
  }

  /**
   * If using SSML or TTS, this is a required field. The voice and language you want to use for the
   * text-to-speech message. This can either be defined by the ISO 639 locale and language code or
   * by specifying a particular voice. Supported languages and voices are detailed
   * [here](../../voice-locales).
   *
   * @return locale
   */
  @JsonProperty(JSON_PROPERTY_LOCALE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getLocale() {
    return locale;
  }

  @JsonProperty(JSON_PROPERTY_LOCALE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setLocale(String locale) {
    this.locale = locale;
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
    SvamlInstructionPlayFilesDto svamlInstructionPlayFiles = (SvamlInstructionPlayFilesDto) o;
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
    sb.append("class SvamlInstructionPlayFilesDto {\n");
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
}
