package com.sinch.sdk.domains.voice.models.v2.sinchevents;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({MenuInputImpl.JSON_PROPERTY_MENU_NAME, MenuInputImpl.JSON_PROPERTY_INPUT})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class MenuInputImpl implements MenuInput {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_MENU_NAME = "menuName";

  private OptionalValue<String> menuName;

  public static final String JSON_PROPERTY_INPUT = "input";

  private OptionalValue<String> input;

  public MenuInputImpl() {}

  protected MenuInputImpl(OptionalValue<String> menuName, OptionalValue<String> input) {
    this.menuName = menuName;
    this.input = input;
  }

  @JsonIgnore
  public String getMenuName() {
    return menuName.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MENU_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> menuName() {
    return menuName;
  }

  @JsonIgnore
  public String getInput() {
    return input.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_INPUT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> input() {
    return input;
  }

  /** Return true if this MenuInput object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MenuInputImpl menuInput = (MenuInputImpl) o;
    return Objects.equals(this.menuName, menuInput.menuName)
        && Objects.equals(this.input, menuInput.input);
  }

  @Override
  public int hashCode() {
    return Objects.hash(menuName, input);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MenuInputImpl {\n");
    sb.append("    menuName: ").append(toIndentedString(menuName)).append("\n");
    sb.append("    input: ").append(toIndentedString(input)).append("\n");
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
  static class Builder implements MenuInput.Builder {
    OptionalValue<String> menuName = OptionalValue.empty();
    OptionalValue<String> input = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_MENU_NAME, required = true)
    public Builder setMenuName(String menuName) {
      this.menuName = OptionalValue.of(menuName);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_INPUT, required = true)
    public Builder setInput(String input) {
      this.input = OptionalValue.of(input);
      return this;
    }

    public MenuInput build() {
      return new MenuInputImpl(menuName, input);
    }
  }
}
