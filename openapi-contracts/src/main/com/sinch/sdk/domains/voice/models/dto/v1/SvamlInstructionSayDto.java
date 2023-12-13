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
import java.util.Objects;

/**
 * Plays a synthesized text-to-speech message to the end user. The message is provided in the text
 * field.
 */
@JsonPropertyOrder({
  SvamlInstructionSayDto.JSON_PROPERTY_NAME,
  SvamlInstructionSayDto.JSON_PROPERTY_TEXT,
  SvamlInstructionSayDto.JSON_PROPERTY_LOCALE
})
// @javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class SvamlInstructionSayDto {
  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_TEXT = "text";
  private String text;

  public static final String JSON_PROPERTY_LOCALE = "locale";
  private String locale;

  public SvamlInstructionSayDto() {}

  public SvamlInstructionSayDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The &#x60;name&#x60; property. Must have the value &#x60;say&#x60;.
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

  public SvamlInstructionSayDto text(String text) {
    this.text = text;
    return this;
  }

  /**
   * Contains the message that will be spoken. Default maximum length is 600 characters. To change
   * this limit, please contact support.
   *
   * @return text
   */
  @JsonProperty(JSON_PROPERTY_TEXT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getText() {
    return text;
  }

  @JsonProperty(JSON_PROPERTY_TEXT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setText(String text) {
    this.text = text;
  }

  public SvamlInstructionSayDto locale(String locale) {
    this.locale = locale;
    return this;
  }

  /**
   * The voice and language you want to use for the text-to-speech message. This can either be
   * defined by the ISO 639 locale and language code or by specifying a particular voice. Supported
   * languages and voices are detailed [here](../../voice-locales).
   *
   * @return locale
   */
  @JsonProperty(JSON_PROPERTY_LOCALE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getLocale() {
    return locale;
  }

  @JsonProperty(JSON_PROPERTY_LOCALE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLocale(String locale) {
    this.locale = locale;
  }

  /** Return true if this svaml.instruction.say object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SvamlInstructionSayDto svamlInstructionSay = (SvamlInstructionSayDto) o;
    return Objects.equals(this.name, svamlInstructionSay.name)
        && Objects.equals(this.text, svamlInstructionSay.text)
        && Objects.equals(this.locale, svamlInstructionSay.locale);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, text, locale);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SvamlInstructionSayDto {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
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
