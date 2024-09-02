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
import com.sinch.sdk.domains.conversation.templates.models.v2.TemplateV2;
import java.util.List;

/** V2ListTemplatesResponseInternal */
@JsonDeserialize(builder = V2ListTemplatesResponseInternalImpl.Builder.class)
public interface V2ListTemplatesResponseInternal {

  /**
   * Get templates
   *
   * @return templates
   */
  List<TemplateV2> getTemplates();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new V2ListTemplatesResponseInternalImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param templates see getter
     * @return Current builder
     * @see #getTemplates
     */
    Builder setTemplates(List<TemplateV2> templates);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    V2ListTemplatesResponseInternal build();
  }
}
