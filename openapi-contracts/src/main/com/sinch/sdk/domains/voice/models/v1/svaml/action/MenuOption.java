/*
 * Voice API | Sinch
 *
 * OpenAPI document version: 1.0.1
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.voice.models.v1.svaml.action;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * A configured option that the user can trigger to perform an action.
 *
 * <p>Use the <b>{@link
 * com.sinch.sdk.domains.voice.models.v1.svaml.action.MenuOptionActionFactory}</b> factory builder
 * helper to create menu action
 *
 * @see com.sinch.sdk.domains.voice.models.v1.svaml.action.MenuOptionActionFactory
 */
@JsonDeserialize(builder = MenuOptionImpl.Builder.class)
public interface MenuOption {

  /**
   * A DTMF digit the user can press to trigger the configured action.
   *
   * @return dtmf
   */
  String getDtmf();

  /**
   * Determines which action is taken when the DTMF digit is pressed. The following values are
   * accepted: - If you want to navigate to another menu, use <code>menu(value)</code>. - If you
   * want to perform another behavior you have coded in your application, use <code>return (value)
   * </code>, where <code>(value)</code> is the name of the method you want to execute.
   *
   * @return action
   */
  String getAction();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new MenuOptionImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param dtmf see getter
     * @return Current builder
     * @see #getDtmf
     */
    Builder setDtmf(String dtmf);

    /**
     * see getter
     *
     * @param action see getter
     * @return Current builder
     * @see #getAction
     */
    Builder setAction(String action);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    MenuOption build();
  }
}
