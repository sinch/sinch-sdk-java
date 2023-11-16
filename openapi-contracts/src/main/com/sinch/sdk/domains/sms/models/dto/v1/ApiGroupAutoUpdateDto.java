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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

/** ApiGroupAutoUpdateDto */
@JsonPropertyOrder({
  ApiGroupAutoUpdateDto.JSON_PROPERTY_TO,
  ApiGroupAutoUpdateDto.JSON_PROPERTY_ADD,
  ApiGroupAutoUpdateDto.JSON_PROPERTY_REMOVE
})
// @javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ApiGroupAutoUpdateDto {
  public static final String JSON_PROPERTY_TO = "to";
  private String to;

  public static final String JSON_PROPERTY_ADD = "add";
  private AddKeywordDto add;

  public static final String JSON_PROPERTY_REMOVE = "remove";
  private RemoveKeywordDto remove;

  public ApiGroupAutoUpdateDto() {}

  public ApiGroupAutoUpdateDto to(String to) {
    this.to = to;
    return this;
  }

  /**
   * Short code or long number addressed in MO. Constraints: Must be valid MSISDN or short code.
   *
   * @return to
   */
  @JsonProperty(JSON_PROPERTY_TO)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getTo() {
    return to;
  }

  @JsonProperty(JSON_PROPERTY_TO)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTo(String to) {
    this.to = to;
  }

  public ApiGroupAutoUpdateDto add(AddKeywordDto add) {
    this.add = add;
    return this;
  }

  /**
   * Get add
   *
   * @return add
   */
  @JsonProperty(JSON_PROPERTY_ADD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public AddKeywordDto getAdd() {
    return add;
  }

  @JsonProperty(JSON_PROPERTY_ADD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAdd(AddKeywordDto add) {
    this.add = add;
  }

  public ApiGroupAutoUpdateDto remove(RemoveKeywordDto remove) {
    this.remove = remove;
    return this;
  }

  /**
   * Get remove
   *
   * @return remove
   */
  @JsonProperty(JSON_PROPERTY_REMOVE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public RemoveKeywordDto getRemove() {
    return remove;
  }

  @JsonProperty(JSON_PROPERTY_REMOVE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRemove(RemoveKeywordDto remove) {
    this.remove = remove;
  }

  /** Return true if this ApiGroupAutoUpdate object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiGroupAutoUpdateDto apiGroupAutoUpdate = (ApiGroupAutoUpdateDto) o;
    return Objects.equals(this.to, apiGroupAutoUpdate.to)
        && Objects.equals(this.add, apiGroupAutoUpdate.add)
        && Objects.equals(this.remove, apiGroupAutoUpdate.remove);
  }

  @Override
  public int hashCode() {
    return Objects.hash(to, add, remove);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiGroupAutoUpdateDto {\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    add: ").append(toIndentedString(add)).append("\n");
    sb.append("    remove: ").append(toIndentedString(remove)).append("\n");
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
