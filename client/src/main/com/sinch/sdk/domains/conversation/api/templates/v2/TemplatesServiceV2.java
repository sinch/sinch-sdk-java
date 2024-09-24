package com.sinch.sdk.domains.conversation.api.templates.v2;

import com.sinch.sdk.domains.conversation.templates.models.v2.TemplateTranslation;
import com.sinch.sdk.domains.conversation.templates.models.v2.TemplateV2;
import com.sinch.sdk.domains.conversation.templates.models.v2.request.TranslationListRequest;
import java.util.Collection;

/**
 * Templates V2
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/conversation/api-reference/template/tag/Templates-V2">online
 *     documentation</a>
 * @since 1.3
 */
public interface TemplatesServiceV2 {

  /**
   * List all templates belonging to a project ID.
   *
   * @return List of templates
   * @since 1.3
   */
  Collection<TemplateV2> list();

  /**
   * List translations for a template
   *
   * @param templateId The ID of the template to fetch
   * @param request Parameters for request
   * @return The translations list
   * @since 1.3
   */
  Collection<TemplateTranslation> listTranslations(
      String templateId, TranslationListRequest request);

  /**
   * Creates a template
   *
   * @param template Information for creation
   * @return Created template
   * @since 1.3
   */
  TemplateV2 create(TemplateV2 template);

  /***
   * Get a template
   * @param templateId  The ID of the template to fetch.
   * @return The template information
   * @since 1.3
   */
  TemplateV2 get(String templateId);

  /***
   * Delete a template
   * @param templateId  The ID of the template to delete.
   * @since 1.3
   */
  void delete(String templateId);

  /**
   * Updates a template
   *
   * @param template Information to be updated
   * @return Updated template
   * @since 1.3
   */
  TemplateV2 update(String templateId, TemplateV2 template);
}
