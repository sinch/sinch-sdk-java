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
 * @since _NEXT_VERSION_
 */
public interface TemplatesServiceV2 {

  /**
   * List all templates belonging to a project ID.
   *
   * @return List of templates
   * @since _NEXT_VERSION_
   */
  Collection<TemplateV2> list();

  /**
   * List translations for a template
   *
   * @param templateId The ID of the template to fetch
   * @param request Parameters for request
   * @return The translations list
   * @since _NEXT_VERSION_
   */
  Collection<TemplateTranslation> listTranslations(
      String templateId, TranslationListRequest request);

  /**
   * Creates a template
   *
   * @param template Information for creation
   * @return Created template
   * @since _NEXT_VERSION_
   */
  TemplateV2 create(TemplateV2 template);

  /***
   * Get a template
   * @param templateId  The ID of the template to fetch.
   * @return The template information
   * @since _NEXT_VERSION_
   */
  TemplateV2 get(String templateId);

  /***
   * Delete a template
   * @param templateId  The ID of the template to delete.
   * @since _NEXT_VERSION_
   */
  void delete(String templateId);

  /**
   * Updates a template
   *
   * @param template Information to be updated
   * @return Updated template
   * @since _NEXT_VERSION_
   */
  TemplateV2 update(String templateId, TemplateV2 template);
}
