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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;

/** An object containing information about the returned menu result. */
@JsonPropertyOrder({
  PieRequestAllOfMenuResultDto.JSON_PROPERTY_MENU_ID,
  PieRequestAllOfMenuResultDto.JSON_PROPERTY_TYPE,
  PieRequestAllOfMenuResultDto.JSON_PROPERTY_VALUE,
  PieRequestAllOfMenuResultDto.JSON_PROPERTY_INPUT_METHOD
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class PieRequestAllOfMenuResultDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_MENU_ID = "menuId";
  private String menuId;
  private boolean menuIdDefined = false;

  /** The type of information that&#39;s returned. */
  public enum TypeEnum {
    ERROR("error"),

    RETURN("return"),

    SEQUENCE("sequence"),

    TIMEOUT("timeout"),

    HANGUP("hangup"),

    INVALIDINPUT("invalidinput"),

    UNKNOWN_DEFAULT_OPEN_API("unknown_default_open_api");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return UNKNOWN_DEFAULT_OPEN_API;
    }
  }

  public static final String JSON_PROPERTY_TYPE = "type";
  private String type;
  private boolean typeDefined = false;

  public static final String JSON_PROPERTY_VALUE = "value";
  private String value;
  private boolean valueDefined = false;

  public static final String JSON_PROPERTY_INPUT_METHOD = "inputMethod";
  private String inputMethod;
  private boolean inputMethodDefined = false;

  public PieRequestAllOfMenuResultDto() {}

  public PieRequestAllOfMenuResultDto menuId(String menuId) {
    this.menuId = menuId;
    this.menuIdDefined = true;
    return this;
  }

  /**
   * The ID of the menu that triggered the prompt input event.
   *
   * @return menuId
   */
  @JsonProperty(JSON_PROPERTY_MENU_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getMenuId() {
    return menuId;
  }

  @JsonIgnore
  public boolean getMenuIdDefined() {
    return menuIdDefined;
  }

  @JsonProperty(JSON_PROPERTY_MENU_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMenuId(String menuId) {
    this.menuId = menuId;
    this.menuIdDefined = true;
  }

  public PieRequestAllOfMenuResultDto type(String type) {
    this.type = type;
    this.typeDefined = true;
    return this;
  }

  /**
   * The type of information that&#39;s returned.
   *
   * @return type
   */
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getType() {
    return type;
  }

  @JsonIgnore
  public boolean getTypeDefined() {
    return typeDefined;
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setType(String type) {
    this.type = type;
    this.typeDefined = true;
  }

  public PieRequestAllOfMenuResultDto value(String value) {
    this.value = value;
    this.valueDefined = true;
    return this;
  }

  /**
   * The value of the returned information.
   *
   * @return value
   */
  @JsonProperty(JSON_PROPERTY_VALUE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getValue() {
    return value;
  }

  @JsonIgnore
  public boolean getValueDefined() {
    return valueDefined;
  }

  @JsonProperty(JSON_PROPERTY_VALUE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setValue(String value) {
    this.value = value;
    this.valueDefined = true;
  }

  public PieRequestAllOfMenuResultDto inputMethod(String inputMethod) {
    this.inputMethod = inputMethod;
    this.inputMethodDefined = true;
    return this;
  }

  /**
   * The type of input received.
   *
   * @return inputMethod
   */
  @JsonProperty(JSON_PROPERTY_INPUT_METHOD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getInputMethod() {
    return inputMethod;
  }

  @JsonIgnore
  public boolean getInputMethodDefined() {
    return inputMethodDefined;
  }

  @JsonProperty(JSON_PROPERTY_INPUT_METHOD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInputMethod(String inputMethod) {
    this.inputMethod = inputMethod;
    this.inputMethodDefined = true;
  }

  /** Return true if this pieRequest_allOf_menuResult object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PieRequestAllOfMenuResultDto pieRequestAllOfMenuResult = (PieRequestAllOfMenuResultDto) o;
    return Objects.equals(this.menuId, pieRequestAllOfMenuResult.menuId)
        && Objects.equals(this.type, pieRequestAllOfMenuResult.type)
        && Objects.equals(this.value, pieRequestAllOfMenuResult.value)
        && Objects.equals(this.inputMethod, pieRequestAllOfMenuResult.inputMethod);
  }

  @Override
  public int hashCode() {
    return Objects.hash(menuId, type, value, inputMethod);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PieRequestAllOfMenuResultDto {\n");
    sb.append("    menuId: ").append(toIndentedString(menuId)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    inputMethod: ").append(toIndentedString(inputMethod)).append("\n");
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
