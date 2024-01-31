package com.sinch.sdk.domains.voice.models.webhooks;

public class MenuResult {

  private final String menuId;
  private final MenuInputType type;
  private final String value;
  private final MenuResultInputMethodType inputMethod;

  private MenuResult(
      String menuId, MenuInputType type, String value, MenuResultInputMethodType inputMethod) {
    this.menuId = menuId;
    this.type = type;
    this.value = value;
    this.inputMethod = inputMethod;
  }

  public String getMenuId() {
    return menuId;
  }

  public MenuInputType getType() {
    return type;
  }

  public String getValue() {
    return value;
  }

  public MenuResultInputMethodType getInputMethod() {
    return inputMethod;
  }

  @Override
  public String toString() {
    return "MenuResult{"
        + "menuId='"
        + menuId
        + '\''
        + ", type="
        + type
        + ", value='"
        + value
        + '\''
        + ", inputMethod="
        + inputMethod
        + '}';
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    String menuId;
    MenuInputType type;
    String value;
    MenuResultInputMethodType inputMethod;

    public Builder setMenuId(String menuId) {
      this.menuId = menuId;
      return this;
    }

    public Builder setType(MenuInputType type) {
      this.type = type;
      return this;
    }

    public Builder setValue(String value) {
      this.value = value;
      return this;
    }

    public Builder setInputMethod(MenuResultInputMethodType inputMethod) {
      this.inputMethod = inputMethod;
      return this;
    }

    public MenuResult build() {
      return new MenuResult(menuId, type, value, inputMethod);
    }
  }
}
