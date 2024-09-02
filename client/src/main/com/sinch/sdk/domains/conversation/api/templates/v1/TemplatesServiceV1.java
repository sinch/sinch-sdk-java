package com.sinch.sdk.domains.conversation.api.templates.v1;

import com.sinch.sdk.domains.conversation.templates.models.v1.TemplateV1;
import java.util.Collection;

/**
 * Templates V1
 *
 * <p>Version 1 endpoints for managing message templates. Currently maintained for existing users.
 * Version 2 is recommended.
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/conversation/api-reference/template/tag/Templates-V1">online
 *     documentation</a>
 * @since _NEXT_VERSION_
 */
public interface TemplatesServiceV1 {

  /**
   * List all templates belonging to a project ID.
   *
   * @return List of templates * @since _NEXT_VERSION_
   * @since _NEXT_VERSION_
   */
  Collection<TemplateV1> list();

  /**
   * Creates a template
   *
   * @param template Information for creation
   * @return Created template
   * @since _NEXT_VERSION_
   */
  TemplateV1 create(TemplateV1 template);

  /***
   * Get a template
   * @param templateId  The ID of the template to fetch.
   * @return The template information
   * @since _NEXT_VERSION_
   */
  TemplateV1 get(String templateId);

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
  TemplateV1 update(String templateId, TemplateV1 template);
}
