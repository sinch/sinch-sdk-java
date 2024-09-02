package com.sinch.sdk.domains.conversation.api.templates;

import com.sinch.sdk.domains.conversation.api.templates.v1.TemplatesServiceV1;
import com.sinch.sdk.domains.conversation.api.templates.v2.TemplatesServiceV2;

/**
 * Service for working with templates
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/conversation/api-reference/template/overview/#section/Managing-templates">online
 *     documentation</a>
 * @since _NEXT_VERSION_
 */
public interface TemplatesService {

  /**
   * Service for working with templates V1
   *
   * @return Templates V1 service
   * @since _NEXT_VERSION_
   */
  TemplatesServiceV1 v1();

  /**
   * Service for working with templates V2
   *
   * @return Templates V2 service
   * @since _NEXT_VERSION_
   */
  TemplatesServiceV2 v2();
}
