/*
 * Mailgun API
 *
 * OpenAPI document version: 0.0.0
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.mailgun.models.v1.templates.response.internal;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.mailgun.models.v1.response.internal.PagingResponse;
import com.sinch.sdk.domains.mailgun.models.v1.templates.Template;

/** ListVersionResponseInternal */
@JsonDeserialize(builder = ListVersionResponseInternalImpl.Builder.class)
public interface ListVersionResponseInternal {

  /**
   * Get template
   *
   * @return template
   */
  Template getTemplate();

  /**
   * Get paging
   *
   * @return paging
   */
  PagingResponse getPaging();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new ListVersionResponseInternalImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param template see getter
     * @return Current builder
     * @see #getTemplate
     */
    Builder setTemplate(Template template);

    /**
     * see getter
     *
     * @param paging see getter
     * @return Current builder
     * @see #getPaging
     */
    Builder setPaging(PagingResponse paging);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    ListVersionResponseInternal build();
  }
}
