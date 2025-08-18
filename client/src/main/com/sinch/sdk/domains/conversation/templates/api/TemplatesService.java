package com.sinch.sdk.domains.conversation.templates.api;

import com.sinch.sdk.domains.conversation.templates.api.v2.TemplatesV2Service;

/**
 * Service for working with Conversation templates
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/conversation/api-reference/template/overview/#section/Managing-templates">online
 *     documentation</a>
 * @since 1.3
 */
public interface TemplatesService {

  /**
   * Service for working with templates V2
   *
   * @return Templates V2 service
   * @since 1.3
   */
  TemplatesV2Service v2();
}
