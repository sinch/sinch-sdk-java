/*
 * Template Management API
 *
 * OpenAPI document version: 457aacb5
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.templates.models.v1;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.Instant;
import java.util.List;

/** TemplateV1 */
@JsonDeserialize(builder = TemplateV1Impl.Builder.class)
public interface TemplateV1 {

  /**
   * Get channel
   *
   * @return channel
   */
  TemplateChannel getChannel();

  /**
   * Timestamp when the template was created.
   *
   * @return createTime
   */
  Instant getCreateTime();

  /**
   * The default translation to use if not specified. Specified as a BCP-47 <code>language_code
   * </code> and the <code>language_code</code> must exist in the translations list.
   *
   * @return defaultTranslation
   */
  String getDefaultTranslation();

  /**
   * The description of the template.
   *
   * @return description
   */
  String getDescription();

  /**
   * The id of the template. Specify this yourself during creation otherwise we will generate an ID
   * for you. This has to be unique for a given project.
   *
   * @return id
   */
  String getId();

  /**
   * List of translations for the template.
   *
   * @return translations
   */
  List<TemplateTranslation> getTranslations();

  /**
   * Timestamp when the template was updated.
   *
   * @return updateTime
   */
  Instant getUpdateTime();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new TemplateV1Impl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param channel see getter
     * @return Current builder
     * @see #getChannel
     */
    Builder setChannel(TemplateChannel channel);

    /**
     * see getter
     *
     * @param createTime see getter
     * @return Current builder
     * @see #getCreateTime
     */
    Builder setCreateTime(Instant createTime);

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
     * @param description see getter
     * @return Current builder
     * @see #getDescription
     */
    Builder setDescription(String description);

    /**
     * see getter
     *
     * @param id see getter
     * @return Current builder
     * @see #getId
     */
    Builder setId(String id);

    /**
     * see getter
     *
     * @param translations see getter
     * @return Current builder
     * @see #getTranslations
     */
    Builder setTranslations(List<TemplateTranslation> translations);

    /**
     * see getter
     *
     * @param updateTime see getter
     * @return Current builder
     * @see #getUpdateTime
     */
    Builder setUpdateTime(Instant updateTime);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    TemplateV1 build();
  }
}
