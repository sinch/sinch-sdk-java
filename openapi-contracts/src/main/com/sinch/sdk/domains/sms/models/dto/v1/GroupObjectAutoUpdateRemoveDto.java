/*
 * API Overview | Sinch
 * Sinch SMS API is one of the easiest APIs we offer and enables you to add fast and reliable global SMS to your applications. Send single messages, scheduled batch messages, use available message templates and more.
 *
 * The version of the OpenAPI document: v1
 * Contact: Support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.sms.models.dto.v1;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

/** Keyword to be sent in MO to remove from a group. */
@JsonPropertyOrder({
  GroupObjectAutoUpdateRemoveDto.JSON_PROPERTY_FIRST_WORD,
  GroupObjectAutoUpdateRemoveDto.JSON_PROPERTY_SECOND_WORD
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class GroupObjectAutoUpdateRemoveDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_FIRST_WORD = "first_word";
  private String firstWord;
  private boolean firstWordDefined = false;

  public static final String JSON_PROPERTY_SECOND_WORD = "second_word";
  private String secondWord;
  private boolean secondWordDefined = false;

  public GroupObjectAutoUpdateRemoveDto() {}

  public GroupObjectAutoUpdateRemoveDto firstWord(String firstWord) {
    this.firstWord = firstWord;
    this.firstWordDefined = true;
    return this;
  }

  /**
   * Opt-out keyword like \&quot;LEAVE\&quot; If auto_update.to is dedicated long/short number or
   * unique brand keyword like \&quot;Sinch\&quot; if it is a shared short code. Constraints: Must
   * be one word.
   *
   * @return firstWord
   */
  @JsonProperty(JSON_PROPERTY_FIRST_WORD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getFirstWord() {
    return firstWord;
  }

  @JsonIgnore
  public boolean getFirstWordDefined() {
    return firstWordDefined;
  }

  @JsonProperty(JSON_PROPERTY_FIRST_WORD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFirstWord(String firstWord) {
    this.firstWord = firstWord;
    this.firstWordDefined = true;
  }

  public GroupObjectAutoUpdateRemoveDto secondWord(String secondWord) {
    this.secondWord = secondWord;
    this.secondWordDefined = true;
    return this;
  }

  /**
   * Opt-out keyword like \&quot;LEAVE\&quot; if auto_update.to is shared short code. Constraints:
   * Must be one word.
   *
   * @return secondWord
   */
  @JsonProperty(JSON_PROPERTY_SECOND_WORD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getSecondWord() {
    return secondWord;
  }

  @JsonIgnore
  public boolean getSecondWordDefined() {
    return secondWordDefined;
  }

  @JsonProperty(JSON_PROPERTY_SECOND_WORD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSecondWord(String secondWord) {
    this.secondWord = secondWord;
    this.secondWordDefined = true;
  }

  /** Return true if this groupObject_auto_update_remove object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GroupObjectAutoUpdateRemoveDto groupObjectAutoUpdateRemove = (GroupObjectAutoUpdateRemoveDto) o;
    return Objects.equals(this.firstWord, groupObjectAutoUpdateRemove.firstWord)
        && Objects.equals(this.secondWord, groupObjectAutoUpdateRemove.secondWord);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstWord, secondWord);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GroupObjectAutoUpdateRemoveDto {\n");
    sb.append("    firstWord: ").append(toIndentedString(firstWord)).append("\n");
    sb.append("    secondWord: ").append(toIndentedString(secondWord)).append("\n");
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
