package com.sinch.sdk.domains.conversation.api.templates.adapters.v2;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.domains.conversation.api.templates.adapters.TemplatesBaseTest;
import com.sinch.sdk.domains.conversation.models.templates.v2.TemplateV2DtoTest;
import com.sinch.sdk.domains.conversation.models.templates.v2.internal.V2ListTemplatesResponseInternalDtoTest;
import com.sinch.sdk.domains.conversation.models.templates.v2.internal.V2ListTranslationsResponseInternalDtoTest;
import com.sinch.sdk.domains.conversation.templates.api.internal.TemplatesV2Api;
import com.sinch.sdk.domains.conversation.templates.models.v2.TemplateTranslation;
import com.sinch.sdk.domains.conversation.templates.models.v2.TemplateV2;
import com.sinch.sdk.domains.conversation.templates.models.v2.request.TranslationListRequest;
import com.sinch.sdk.models.ConversationContext;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;

@TestWithResources
public class TemplatesServiceV2Test extends TemplatesBaseTest {

  @Mock ConversationContext context;
  @Mock TemplatesV2Api api;
  @Mock HttpClient httpClient;
  @Mock Map<String, AuthManager> authManagers;
  @Captor ArgumentCaptor<String> uriPartIDCaptor;
  @Captor ArgumentCaptor<String> idCaptor;

  TemplatesServiceV2 service;
  String uriPartID = "foovalue";

  @BeforeEach
  public void initMocks() {
    service = spy(new TemplatesServiceV2(uriPartID, context, httpClient, authManagers));
    doReturn(api).when(service).getApi();
  }

  @Test
  void create() throws ApiException {

    when(api.templatesV2CreateTemplate(eq(uriPartID), eq(TemplateV2DtoTest.expectedDto)))
        .thenReturn(TemplateV2DtoTest.expectedDto);

    TemplateV2 response = service.create(TemplateV2DtoTest.expectedDto);

    TestHelpers.recursiveEquals(response, TemplateV2DtoTest.expectedDto);
  }

  @Test
  void get() throws ApiException {

    when(api.templatesV2GetTemplate(eq(uriPartID), eq(TemplateV2DtoTest.expectedDto.getId())))
        .thenReturn(TemplateV2DtoTest.expectedDto);

    TemplateV2 response = service.get(TemplateV2DtoTest.expectedDto.getId());

    TestHelpers.recursiveEquals(response, TemplateV2DtoTest.expectedDto);
  }

  @Test
  void list() throws ApiException {

    when(api.templatesV2ListTemplates(eq(uriPartID)))
        .thenReturn(V2ListTemplatesResponseInternalDtoTest.expectedDto);

    Collection<TemplateV2> response = service.list();

    Iterator<TemplateV2> iterator = response.iterator();
    Assertions.assertThat(iterator.hasNext()).isEqualTo(true);
    TemplateV2 item = iterator.next();
    TestHelpers.recursiveEquals(
        item, V2ListTemplatesResponseInternalDtoTest.expectedDto.getTemplates().get(0));
    Assertions.assertThat(iterator.hasNext()).isEqualTo(false);
  }

  @Test
  void listTranslations() throws ApiException {

    when(api.templatesV2ListTranslations(
            eq(uriPartID),
            eq(TemplateV2DtoTest.expectedDto.getId()),
            eq("language code"),
            eq("translation version")))
        .thenReturn(V2ListTranslationsResponseInternalDtoTest.expectedDto);

    Collection<TemplateTranslation> response =
        service.listTranslations(
            TemplateV2DtoTest.expectedDto.getId(),
            TranslationListRequest.builder()
                .setLanguageCode("language code")
                .setTranslationVersion("translation version")
                .build());

    Iterator<TemplateTranslation> iterator = response.iterator();
    Assertions.assertThat(iterator.hasNext()).isEqualTo(true);
    TemplateTranslation item = iterator.next();
    TestHelpers.recursiveEquals(
        item, V2ListTranslationsResponseInternalDtoTest.expectedDto.getTranslations().get(0));
    Assertions.assertThat(iterator.hasNext()).isEqualTo(false);
  }

  @Test
  void update() throws ApiException {

    when(api.templatesV2UpdateTemplate(
            eq(uriPartID),
            eq(TemplateV2DtoTest.expectedDto.getId()),
            eq(TemplateV2DtoTest.expectedDto)))
        .thenReturn(TemplateV2DtoTest.expectedDto);

    TemplateV2 response =
        service.update(TemplateV2DtoTest.expectedDto.getId(), TemplateV2DtoTest.expectedDto);

    TestHelpers.recursiveEquals(response, TemplateV2DtoTest.expectedDto);
  }

  @Test
  void delete() throws ApiException {

    service.delete(TemplateV2DtoTest.expectedDto.getId());

    verify(api).templatesV2DeleteTemplate(uriPartIDCaptor.capture(), idCaptor.capture());

    Assertions.assertThat(uriPartIDCaptor.getValue()).isEqualTo(uriPartID);
    Assertions.assertThat(idCaptor.getValue()).isEqualTo(TemplateV2DtoTest.expectedDto.getId());
  }
}
