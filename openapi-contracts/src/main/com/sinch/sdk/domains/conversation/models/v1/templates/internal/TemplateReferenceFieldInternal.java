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

package com.sinch.sdk.domains.conversation.models.v1.templates.internal;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.conversation.models.v1.templates.TemplateReference;

/** Template (Reference) */
@JsonDeserialize(builder = TemplateReferenceFieldInternalImpl.Builder.class)
public interface TemplateReferenceFieldInternal {

  /**
   * Get templateReference
   *
   * @return templateReference
   */
  TemplateReference getTemplateReference();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new TemplateReferenceFieldInternalImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param templateReference see getter
     * @return Current builder
     * @see #getTemplateReference
     */
    Builder setTemplateReference(TemplateReference templateReference);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    TemplateReferenceFieldInternal build();
  }
}
