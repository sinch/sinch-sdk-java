package com.sinch.sdk.domains.conversation.api.templates.adapters.v1;

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
import com.sinch.sdk.domains.conversation.models.templates.v1.TemplateV1DtoTest;
import com.sinch.sdk.domains.conversation.models.templates.v1.internal.V1ListTemplatesResponseInternalDtoTest;
import com.sinch.sdk.domains.conversation.templates.api.internal.TemplatesV1Api;
import com.sinch.sdk.domains.conversation.templates.models.v1.TemplateV1;
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
public class TemplatesServiceV1Test extends TemplatesBaseTest {

  @Mock ConversationContext context;
  @Mock TemplatesV1Api api;
  @Mock HttpClient httpClient;
  @Mock Map<String, AuthManager> authManagers;
  @Captor ArgumentCaptor<String> uriPartIDCaptor;
  @Captor ArgumentCaptor<String> idCaptor;

  TemplatesServiceV1 service;
  String uriPartID = "foovalue";

  @BeforeEach
  public void initMocks() {
    service = spy(new TemplatesServiceV1(uriPartID, context, httpClient, authManagers));
    doReturn(api).when(service).getApi();
  }

  @Test
  void create() throws ApiException {

    when(api.templatesCreateTemplate(eq(uriPartID), eq(TemplateV1DtoTest.expectedDto)))
        .thenReturn(TemplateV1DtoTest.expectedDto);

    TemplateV1 response = service.create(TemplateV1DtoTest.expectedDto);

    TestHelpers.recursiveEquals(response, TemplateV1DtoTest.expectedDto);
  }

  @Test
  void get() throws ApiException {

    when(api.templatesGetTemplate(eq(uriPartID), eq(TemplateV1DtoTest.expectedDto.getId())))
        .thenReturn(TemplateV1DtoTest.expectedDto);

    TemplateV1 response = service.get(TemplateV1DtoTest.expectedDto.getId());

    TestHelpers.recursiveEquals(response, TemplateV1DtoTest.expectedDto);
  }

  @Test
  void list() throws ApiException {

    when(api.templatesListTemplates(eq(uriPartID)))
        .thenReturn(V1ListTemplatesResponseInternalDtoTest.expectedDto);

    Collection<TemplateV1> response = service.list();

    Iterator<TemplateV1> iterator = response.iterator();
    Assertions.assertThat(iterator.hasNext()).isEqualTo(true);
    TemplateV1 item = iterator.next();
    TestHelpers.recursiveEquals(
        item, V1ListTemplatesResponseInternalDtoTest.expectedDto.getTemplates().get(0));
    Assertions.assertThat(iterator.hasNext()).isEqualTo(false);
  }

  @Test
  void update() throws ApiException {

    when(api.templatesUpdateTemplate(
            eq(uriPartID),
            eq(TemplateV1DtoTest.expectedDto.getId()),
            eq(TemplateV1DtoTest.expectedDto),
            eq(null)))
        .thenReturn(TemplateV1DtoTest.expectedDto);

    TemplateV1 response =
        service.update(TemplateV1DtoTest.expectedDto.getId(), TemplateV1DtoTest.expectedDto);

    TestHelpers.recursiveEquals(response, TemplateV1DtoTest.expectedDto);
  }

  @Test
  void delete() throws ApiException {

    service.delete(TemplateV1DtoTest.expectedDto.getId());

    verify(api).templatesDeleteTemplate(uriPartIDCaptor.capture(), idCaptor.capture());

    Assertions.assertThat(uriPartIDCaptor.getValue()).isEqualTo(uriPartID);
    Assertions.assertThat(idCaptor.getValue()).isEqualTo(TemplateV1DtoTest.expectedDto.getId());
  }
}
