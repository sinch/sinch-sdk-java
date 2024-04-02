/*
 * Conversation API | Sinch
 * Send and receive messages globally over SMS, RCS, WhatsApp, Viber Business, Facebook messenger and other popular channels using the Sinch Conversation API.  The Conversation API endpoint uses built-in transcoding to give you the power of conversation across all supported channels and, if required, full control over channel specific features.
 *
 * The version of the OpenAPI document: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Map;

/**
 * The referenced template can be an omnichannel template stored in Conversation API Template Store
 * as AppMessage or it can reference external channel-specific template such as WhatsApp Business
 * Template.
 */
@JsonDeserialize(builder = TemplateReferenceImpl.Builder.class)
public interface TemplateReference {

  /**
   * The BCP-47 language code, such as &#x60;en-US&#x60; or &#x60;sr-Latn&#x60;. For more
   * information, see http://www.unicode.org/reports/tr35/#Unicode_locale_identifier. English is the
   * default language_code.
   *
   * @return languageCode
   */
  String getLanguageCode();

  /**
   * Required if the template has parameters. Concrete values must be present for all defined
   * parameters in the template. Parameters can be different for different versions and/or languages
   * of the template.
   *
   * @return parameters
   */
  Map<String, String> getParameters();

  /**
   * The ID of the template.
   *
   * @return templateId
   */
  String getTemplateId();

  /**
   * Used to specify what version of a template to use. This will be used in conjunction with
   * &#x60;language_code&#x60;.
   *
   * @return version
   */
  String getVersion();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new TemplateReferenceImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param languageCode see getter
     * @return Current builder
     * @see #getLanguageCode
     */
    Builder setLanguageCode(String languageCode);

    /**
     * see getter
     *
     * @param parameters see getter
     * @return Current builder
     * @see #getParameters
     */
    Builder setParameters(Map<String, String> parameters);

    /**
     * see getter
     *
     * @param templateId see getter
     * @return Current builder
     * @see #getTemplateId
     */
    Builder setTemplateId(String templateId);

    /**
     * see getter
     *
     * @param version see getter
     * @return Current builder
     * @see #getVersion
     */
    Builder setVersion(String version);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    TemplateReference build();
  }
}
