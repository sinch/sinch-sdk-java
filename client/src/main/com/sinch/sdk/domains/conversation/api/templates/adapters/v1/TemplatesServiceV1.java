package com.sinch.sdk.domains.conversation.api.templates.adapters.v1;

import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.domains.conversation.templates.api.internal.V1Api;
import com.sinch.sdk.domains.conversation.templates.models.v1.TemplateV1;
import com.sinch.sdk.models.ConversationContext;
import java.util.Collection;
import java.util.Map;

public class TemplatesServiceV1
    implements com.sinch.sdk.domains.conversation.api.templates.v1.TemplatesServiceV1 {

  private final String uriUUID;
  private final V1Api api;

  public TemplatesServiceV1(
      String uriUUID,
      ConversationContext context,
      HttpClient httpClient,
      Map<String, AuthManager> authManagers) {
    this.uriUUID = uriUUID;
    this.api =
        new V1Api(
            httpClient,
            context.getTemplateManagementServer(),
            authManagers,
            HttpMapper.getInstance());
  }

  protected V1Api getApi() {
    return this.api;
  }

  public Collection<TemplateV1> list() {
    return getApi().templatesListTemplates(uriUUID).getTemplates();
  }

  public TemplateV1 create(TemplateV1 template) {
    return getApi().templatesCreateTemplate(uriUUID, template);
  }

  public TemplateV1 get(String templateId) {
    return getApi().templatesGetTemplate(uriUUID, templateId);
  }

  public void delete(String templateId) {
    getApi().templatesDeleteTemplate(uriUUID, templateId);
  }

  public TemplateV1 update(String templateId, TemplateV1 template) {
    return getApi().templatesUpdateTemplate(uriUUID, templateId, template, null);
  }
}
