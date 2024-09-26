/*
 * Template Management API
 *
 * OpenAPI document version: 457aacb5
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.templates.models.v2;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.Instant;
import java.util.Collection;

/** TemplateV2 */
@JsonDeserialize(builder = TemplateV2Impl.Builder.class)
public interface TemplateV2 {

  /**
   * The id of the template. Specify this yourself during creation. Otherwise, we will generate an
   * ID for you. This must be unique for a given project.
   *
   * @return id
   * @readOnly <em>This field is returned by the server and cannot be modified</em>
   */
  String getId();

  /**
   * The description of the template.
   *
   * @return description
   */
  String getDescription();

  /**
   * The version of the template. While creating a template, this will be defaulted to 1. When
   * updating a template, you must supply the latest version of the template in order for the update
   * to be successful.
   *
   * @return version
   */
  Integer getVersion();

  /**
   * The default translation to use if not specified. Specified as a BCP-47 <code>language_code
   * </code> and the <code>language_code</code> must exist in the translations list.
   *
   * @return defaultTranslation
   */
  String getDefaultTranslation();

  /**
   * Get translations
   *
   * @return translations
   */
  Collection<TemplateTranslation> getTranslations();

  /**
   * Timestamp when the template was created.
   *
   * @return createTime
   * @readOnly <em>This field is returned by the server and cannot be modified</em>
   */
  Instant getCreateTime();

  /**
   * Timestamp when the template was updated.
   *
   * @return updateTime
   * @readOnly <em>This field is returned by the server and cannot be modified</em>
   */
  Instant getUpdateTime();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new TemplateV2Impl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param id see getter
     * @return Current builder
     * @see #getId
     * @readOnly <em>This field is returned by the server and cannot be modified</em>
     */
    Builder setId(String id);

    /**
     * see getter
     *
     * @param description see getter
     * @return Current builder
     * @see #getDescription
     */
    Builder setDescription(String description);

    /**
     * see getter
     *
     * @param version see getter
     * @return Current builder
     * @see #getVersion
     */
    Builder setVersion(Integer version);

    /**
     * see getter
     *
     * @param defaultTranslation see getter
     * @return Current builder
     * @see #getDefaultTranslation
     */
    Builder setDefaultTranslation(String defaultTranslation);

    /**
     * see getter
     *
     * @param translations see getter
     * @return Current builder
     * @see #getTranslations
     */
    Builder setTranslations(Collection<TemplateTranslation> translations);

    /**
     * see getter
     *
     * @param createTime see getter
     * @return Current builder
     * @see #getCreateTime
     * @readOnly <em>This field is returned by the server and cannot be modified</em>
     */
    Builder setCreateTime(Instant createTime);

    /**
     * see getter
     *
     * @param updateTime see getter
     * @return Current builder
     * @see #getUpdateTime
     * @readOnly <em>This field is returned by the server and cannot be modified</em>
     */
    Builder setUpdateTime(Instant updateTime);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    TemplateV2 build();
  }
}
