package com.sinch.sdk.domains.voice.models.v1.svaml.action;

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
  SvamlActionRunMenuImpl.JSON_PROPERTY_NAME,
  SvamlActionRunMenuImpl.JSON_PROPERTY_BARGE,
  SvamlActionRunMenuImpl.JSON_PROPERTY_LOCALE,
  SvamlActionRunMenuImpl.JSON_PROPERTY_MAIN_MENU,
  SvamlActionRunMenuImpl.JSON_PROPERTY_ENABLE_VOICE,
  SvamlActionRunMenuImpl.JSON_PROPERTY_MENUS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class SvamlActionRunMenuImpl
    implements SvamlActionRunMenu, com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlAction {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_NAME = "name";

  private OptionalValue<NameEnum> name;

  public static final String JSON_PROPERTY_BARGE = "barge";

  private OptionalValue<Boolean> barge;

  public static final String JSON_PROPERTY_LOCALE = "locale";

  private OptionalValue<String> locale;

  public static final String JSON_PROPERTY_MAIN_MENU = "mainMenu";

  private OptionalValue<String> mainMenu;

  public static final String JSON_PROPERTY_ENABLE_VOICE = "enableVoice";

  private OptionalValue<Boolean> enableVoice;

  public static final String JSON_PROPERTY_MENUS = "menus";

  private OptionalValue<List<Menu>> menus;

  public SvamlActionRunMenuImpl() {}

  protected SvamlActionRunMenuImpl(
      OptionalValue<NameEnum> name,
      OptionalValue<Boolean> barge,
      OptionalValue<String> locale,
      OptionalValue<String> mainMenu,
      OptionalValue<Boolean> enableVoice,
      OptionalValue<List<Menu>> menus) {
    this.name = name;
    this.barge = barge;
    this.locale = locale;
    this.mainMenu = mainMenu;
    this.enableVoice = enableVoice;
    this.menus = menus;
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
  public Boolean getBarge() {
    return barge.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_BARGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Boolean> barge() {
    return barge;
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

  @JsonIgnore
  public String getMainMenu() {
    return mainMenu.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MAIN_MENU)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> mainMenu() {
    return mainMenu;
  }

  @JsonIgnore
  public Boolean getEnableVoice() {
    return enableVoice.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ENABLE_VOICE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Boolean> enableVoice() {
    return enableVoice;
  }

  @JsonIgnore
  public List<Menu> getMenus() {
    return menus.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MENUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<Menu>> menus() {
    return menus;
  }

  /** Return true if this svaml.action.runMenu object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SvamlActionRunMenuImpl svamlActionRunMenu = (SvamlActionRunMenuImpl) o;
    return Objects.equals(this.name, svamlActionRunMenu.name)
        && Objects.equals(this.barge, svamlActionRunMenu.barge)
        && Objects.equals(this.locale, svamlActionRunMenu.locale)
        && Objects.equals(this.mainMenu, svamlActionRunMenu.mainMenu)
        && Objects.equals(this.enableVoice, svamlActionRunMenu.enableVoice)
        && Objects.equals(this.menus, svamlActionRunMenu.menus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, barge, locale, mainMenu, enableVoice, menus);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SvamlActionRunMenuImpl {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    barge: ").append(toIndentedString(barge)).append("\n");
    sb.append("    locale: ").append(toIndentedString(locale)).append("\n");
    sb.append("    mainMenu: ").append(toIndentedString(mainMenu)).append("\n");
    sb.append("    enableVoice: ").append(toIndentedString(enableVoice)).append("\n");
    sb.append("    menus: ").append(toIndentedString(menus)).append("\n");
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
  static class Builder implements SvamlActionRunMenu.Builder {
    OptionalValue<NameEnum> name = OptionalValue.of(NameEnum.RUN_MENU);
    OptionalValue<Boolean> barge = OptionalValue.empty();
    OptionalValue<String> locale = OptionalValue.empty();
    OptionalValue<String> mainMenu = OptionalValue.empty();
    OptionalValue<Boolean> enableVoice = OptionalValue.empty();
    OptionalValue<List<Menu>> menus = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_BARGE)
    public Builder setBarge(Boolean barge) {
      this.barge = OptionalValue.of(barge);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_LOCALE)
    public Builder setLocale(String locale) {
      this.locale = OptionalValue.of(locale);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MAIN_MENU)
    public Builder setMainMenu(String mainMenu) {
      this.mainMenu = OptionalValue.of(mainMenu);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ENABLE_VOICE)
    public Builder setEnableVoice(Boolean enableVoice) {
      this.enableVoice = OptionalValue.of(enableVoice);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MENUS)
    public Builder setMenus(List<Menu> menus) {
      this.menus = OptionalValue.of(menus);
      return this;
    }

    public SvamlActionRunMenu build() {
      return new SvamlActionRunMenuImpl(name, barge, locale, mainMenu, enableVoice, menus);
    }
  }
}
