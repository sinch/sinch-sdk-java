/*
 * Template Management API
 *
 * OpenAPI document version: 457aacb5
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.templates.models.v2.internal;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.conversation.templates.models.v2.TemplateTranslationBase;
import java.util.List;

/** V2ListTranslationsResponseInternal */
@JsonDeserialize(builder = V2ListTranslationsResponseInternalImpl.Builder.class)
public interface V2ListTranslationsResponseInternal {

  /**
   * Get translations
   *
   * @return translations
   */
  List<TemplateTranslationBase> getTranslations();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new V2ListTranslationsResponseInternalImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param translations see getter
     * @return Current builder
     * @see #getTranslations
     */
    Builder setTranslations(List<TemplateTranslationBase> translations);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    V2ListTranslationsResponseInternal build();
  }
}