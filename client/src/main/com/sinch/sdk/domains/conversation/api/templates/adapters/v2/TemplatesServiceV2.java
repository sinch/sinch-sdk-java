package com.sinch.sdk.domains.conversation.api.templates.adapters.v2;

import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.domains.conversation.templates.api.internal.TemplatesV2Api;
import com.sinch.sdk.domains.conversation.templates.models.v2.TemplateTranslation;
import com.sinch.sdk.domains.conversation.templates.models.v2.TemplateV2;
import com.sinch.sdk.domains.conversation.templates.models.v2.internal.V2ListTranslationsResponseInternal;
import com.sinch.sdk.domains.conversation.templates.models.v2.request.TranslationListRequest;
import com.sinch.sdk.models.ConversationContext;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public class TemplatesServiceV2
    implements com.sinch.sdk.domains.conversation.api.templates.v2.TemplatesServiceV2 {

  private final String uriUUID;
  private final TemplatesV2Api api;

  public TemplatesServiceV2(
      String uriUUID,
      ConversationContext context,
      HttpClient httpClient,
      Map<String, AuthManager> authManagers) {
    this.uriUUID = uriUUID;
    this.api =
        new TemplatesV2Api(
            httpClient,
            context.getTemplateManagementServer(),
            authManagers,
            HttpMapper.getInstance());
  }

  protected TemplatesV2Api getApi() {
    return this.api;
  }

  public Collection<TemplateV2> list() {
    return getApi().templatesV2ListTemplates(uriUUID).getTemplates();
  }

  public Collection<TemplateTranslation> listTranslations(
      String templateId, TranslationListRequest request) {

    if (null == request) {
      request = TranslationListRequest.builder().build();
    }
    String languageCode = request.getLanguageCode().orElse(null);
    String translationVersion = request.getTranslationVersion().orElse(null);

    V2ListTranslationsResponseInternal response =
        getApi().templatesV2ListTranslations(uriUUID, templateId, languageCode, translationVersion);
    if (null == response || null == response.getTranslations()) {
      return Collections.emptyList();
    }
    return response.getTranslations().stream()
        .map(TemplateTranslation::from)
        .collect(Collectors.toList());
  }

  public TemplateV2 create(TemplateV2 template) {
    return getApi().templatesV2CreateTemplate(uriUUID, template);
  }

  public TemplateV2 get(String templateId) {
    return getApi().templatesV2GetTemplate(uriUUID, templateId);
  }

  public void delete(String templateId) {
    getApi().templatesV2DeleteTemplate(uriUUID, templateId);
  }

  public TemplateV2 update(String templateId, TemplateV2 template) {
    return getApi().templatesV2UpdateTemplate(uriUUID, templateId, template);
  }
}
