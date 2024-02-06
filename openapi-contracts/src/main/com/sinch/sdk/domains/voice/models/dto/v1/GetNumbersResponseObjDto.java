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

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** GetNumbersResponseObjDto */
@JsonPropertyOrder({GetNumbersResponseObjDto.JSON_PROPERTY_NUMBERS})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class GetNumbersResponseObjDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_NUMBERS = "numbers";
  private List<GetNumbersResponseObjNumbersInnerDto> numbers;
  private boolean numbersDefined = false;

  public GetNumbersResponseObjDto() {}

  public GetNumbersResponseObjDto numbers(List<GetNumbersResponseObjNumbersInnerDto> numbers) {
    this.numbers = numbers;
    this.numbersDefined = true;
    return this;
  }

  public GetNumbersResponseObjDto addNumbersItem(GetNumbersResponseObjNumbersInnerDto numbersItem) {
    if (this.numbers == null) {
      this.numbers = new ArrayList<>();
    }
    this.numbersDefined = true;
    this.numbers.add(numbersItem);
    return this;
  }

  /**
   * The object type. Will always be list of numbers, associated application keys and capabilities
   *
   * @return numbers
   */
  @JsonProperty(JSON_PROPERTY_NUMBERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<GetNumbersResponseObjNumbersInnerDto> getNumbers() {
    return numbers;
  }

  @JsonIgnore
  public boolean getNumbersDefined() {
    return numbersDefined;
  }

  @JsonProperty(JSON_PROPERTY_NUMBERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNumbers(List<GetNumbersResponseObjNumbersInnerDto> numbers) {
    this.numbers = numbers;
    this.numbersDefined = true;
  }

  /** Return true if this getNumbersResponseObj object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetNumbersResponseObjDto getNumbersResponseObj = (GetNumbersResponseObjDto) o;
    return Objects.equals(this.numbers, getNumbersResponseObj.numbers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numbers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetNumbersResponseObjDto {\n");
    sb.append("    numbers: ").append(toIndentedString(numbers)).append("\n");
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
