package com.sinch.sdk.domains.voice.models.v1.webhooks;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  MenuResultImpl.JSON_PROPERTY_MENU_ID,
  MenuResultImpl.JSON_PROPERTY_TYPE,
  MenuResultImpl.JSON_PROPERTY_VALUE,
  MenuResultImpl.JSON_PROPERTY_INPUT_METHOD
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class MenuResultImpl implements MenuResult {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_MENU_ID = "menuId";

  private OptionalValue<String> menuId;

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<TypeEnum> type;

  public static final String JSON_PROPERTY_VALUE = "value";

  private OptionalValue<String> value;

  public static final String JSON_PROPERTY_INPUT_METHOD = "inputMethod";

  private OptionalValue<InputMethodEnum> inputMethod;

  public MenuResultImpl() {}

  protected MenuResultImpl(
      OptionalValue<String> menuId,
      OptionalValue<TypeEnum> type,
      OptionalValue<String> value,
      OptionalValue<InputMethodEnum> inputMethod) {
    this.menuId = menuId;
    this.type = type;
    this.value = value;
    this.inputMethod = inputMethod;
  }

  @JsonIgnore
  public String getMenuId() {
    return menuId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MENU_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> menuId() {
    return menuId;
  }

  @JsonIgnore
  public TypeEnum getType() {
    return type.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<TypeEnum> type() {
    return type;
  }

  @JsonIgnore
  public String getValue() {
    return value.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_VALUE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> value() {
    return value;
  }

  @JsonIgnore
  public InputMethodEnum getInputMethod() {
    return inputMethod.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_INPUT_METHOD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<InputMethodEnum> inputMethod() {
    return inputMethod;
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
    MenuResultImpl pieRequestAllOfMenuResult = (MenuResultImpl) o;
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
    sb.append("class MenuResultImpl {\n");
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

  @JsonPOJOBuilder(withPrefix = "set")
  static class Builder implements MenuResult.Builder {
    OptionalValue<String> menuId = OptionalValue.empty();
    OptionalValue<TypeEnum> type = OptionalValue.empty();
    OptionalValue<String> value = OptionalValue.empty();
    OptionalValue<InputMethodEnum> inputMethod = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_MENU_ID)
    public Builder setMenuId(String menuId) {
      this.menuId = OptionalValue.of(menuId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TYPE)
    public Builder setType(TypeEnum type) {
      this.type = OptionalValue.of(type);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_VALUE)
    public Builder setValue(String value) {
      this.value = OptionalValue.of(value);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_INPUT_METHOD)
    public Builder setInputMethod(InputMethodEnum inputMethod) {
      this.inputMethod = OptionalValue.of(inputMethod);
      return this;
    }

    public MenuResult build() {
      return new MenuResultImpl(menuId, type, value, inputMethod);
    }
  }
}
