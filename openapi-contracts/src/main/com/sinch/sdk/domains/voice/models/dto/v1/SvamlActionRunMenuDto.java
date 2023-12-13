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
 * Plays an interactive voice response (IVR) menu to the callee. This menu can play pre-recorded
 * files or text-to-speech messages, collect DTMF tones, and trigger the [Prompt Input
 * Event](../../voice/tag/Callbacks/#tag/Callbacks/operation/pie) (PIE) callback towards your
 * backend, notifying you of the actions the callee took. Available to use in a response to an
 * [Incoming Call Event](../../voice/tag/Callbacks/#tag/Callbacks/operation/ice) callback or an
 * [Answered Call Event](../../voice/tag/Callbacks/#tag/Callbacks/operation/ace) callback. Also be
 * used in combination with the
 * [Conferences](/docs/voice/api-reference/voice/tag/Conferences/#tag/Conferences) endpoint of the
 * Calling API.
 */
@JsonPropertyOrder({
  SvamlActionRunMenuDto.JSON_PROPERTY_NAME,
  SvamlActionRunMenuDto.JSON_PROPERTY_BARGE,
  SvamlActionRunMenuDto.JSON_PROPERTY_LOCALE,
  SvamlActionRunMenuDto.JSON_PROPERTY_MAIN_MENU,
  SvamlActionRunMenuDto.JSON_PROPERTY_ENABLE_VOICE,
  SvamlActionRunMenuDto.JSON_PROPERTY_MENUS
})
// @javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class SvamlActionRunMenuDto {
  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_BARGE = "barge";
  private Boolean barge;

  public static final String JSON_PROPERTY_LOCALE = "locale";
  private String locale;

  public static final String JSON_PROPERTY_MAIN_MENU = "mainMenu";
  private String mainMenu;

  public static final String JSON_PROPERTY_ENABLE_VOICE = "enableVoice";
  private Boolean enableVoice;

  public static final String JSON_PROPERTY_MENUS = "menus";
  private List<MenuDto> menus;

  public SvamlActionRunMenuDto() {}

  public SvamlActionRunMenuDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The name property. Must have the value &#x60;runMenu&#x60;.
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

  public SvamlActionRunMenuDto barge(Boolean barge) {
    this.barge = barge;
    return this;
  }

  /**
   * &#39;Barging&#39; means that the user can press a DTMF digit before the prompt has finished
   * playing. If a valid input is pressed, the message will stop playing and accept the input. If
   * &#x60;barge&#x60; is disabled, the user must listen to the entire prompt before input is
   * accepted. By default, barging is enabled.
   *
   * @return barge
   */
  @JsonProperty(JSON_PROPERTY_BARGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Boolean getBarge() {
    return barge;
  }

  @JsonProperty(JSON_PROPERTY_BARGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBarge(Boolean barge) {
    this.barge = barge;
  }

  public SvamlActionRunMenuDto locale(String locale) {
    this.locale = locale;
    return this;
  }

  /**
   * The voice and language you want to use for the text-to-speech message. This can either be
   * defined by the ISO 639 locale and language code or by specifying a particular voice. Supported
   * languages and voices are detailed [here](../../voice-locales). If using the
   * &#x60;enableVoice&#x60; to enable voice detection, the &#x60;locale&#x60; property is required
   * in order to select the input language.
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

  public SvamlActionRunMenuDto mainMenu(String mainMenu) {
    this.mainMenu = mainMenu;
    return this;
  }

  /**
   * Selects the menu item from the &#x60;menus&#x60; array to play first.
   *
   * @return mainMenu
   */
  @JsonProperty(JSON_PROPERTY_MAIN_MENU)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getMainMenu() {
    return mainMenu;
  }

  @JsonProperty(JSON_PROPERTY_MAIN_MENU)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMainMenu(String mainMenu) {
    this.mainMenu = mainMenu;
  }

  public SvamlActionRunMenuDto enableVoice(Boolean enableVoice) {
    this.enableVoice = enableVoice;
    return this;
  }

  /**
   * Enables voice detection. If enabled, users can say their answers to prompts in addition to
   * entering them using the keypad.
   *
   * @return enableVoice
   */
  @JsonProperty(JSON_PROPERTY_ENABLE_VOICE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Boolean getEnableVoice() {
    return enableVoice;
  }

  @JsonProperty(JSON_PROPERTY_ENABLE_VOICE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEnableVoice(Boolean enableVoice) {
    this.enableVoice = enableVoice;
  }

  public SvamlActionRunMenuDto menus(List<MenuDto> menus) {
    this.menus = menus;
    return this;
  }

  public SvamlActionRunMenuDto addMenusItem(MenuDto menusItem) {
    if (this.menus == null) {
      this.menus = new ArrayList<>();
    }
    this.menus.add(menusItem);
    return this;
  }

  /**
   * The list of menus available. The menu with the &#x60;id&#x60; value of &#x60;main&#x60; will
   * always play first. If no menu has an &#x60;id&#x60; value of &#x60;main&#x60;, an error is
   * returned.
   *
   * @return menus
   */
  @JsonProperty(JSON_PROPERTY_MENUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<MenuDto> getMenus() {
    return menus;
  }

  @JsonProperty(JSON_PROPERTY_MENUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMenus(List<MenuDto> menus) {
    this.menus = menus;
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
    SvamlActionRunMenuDto svamlActionRunMenu = (SvamlActionRunMenuDto) o;
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
    sb.append("class SvamlActionRunMenuDto {\n");
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
}
