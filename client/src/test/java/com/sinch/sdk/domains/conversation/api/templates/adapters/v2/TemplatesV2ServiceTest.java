package com.sinch.sdk.domains.conversation.api.templates.adapters.v2;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpContentType;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.http.HttpMethod;
import com.sinch.sdk.core.http.HttpRequest;
import com.sinch.sdk.core.http.HttpRequestTest.HttpRequestMatcher;
import com.sinch.sdk.core.http.HttpResponse;
import com.sinch.sdk.core.http.URLParameter;
import com.sinch.sdk.core.http.URLParameter.STYLE;
import com.sinch.sdk.core.http.URLPathUtils;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.core.models.pagination.Page;
import com.sinch.sdk.domains.conversation.templates.api.adapters.TemplatesBaseTest;
import com.sinch.sdk.domains.conversation.templates.api.v2.TemplatesV2Service;
import com.sinch.sdk.domains.conversation.templates.api.v2.adapters.TemplatesV2ServiceImpl;
import com.sinch.sdk.domains.conversation.templates.models.v2.TemplateTranslation;
import com.sinch.sdk.domains.conversation.templates.models.v2.TemplateV2;
import com.sinch.sdk.domains.conversation.templates.models.v2.TemplateV2DtoTest;
import com.sinch.sdk.domains.conversation.templates.models.v2.request.ListTranslationsQueryParameters;
import com.sinch.sdk.domains.conversation.templates.models.v2.response.TemplatesV2ListResponse;
import com.sinch.sdk.domains.conversation.templates.models.v2.response.TemplatesV2ListResponseDtoTest;
import com.sinch.sdk.domains.conversation.templates.models.v2.response.TranslationsV2ListResponse;
import com.sinch.sdk.domains.conversation.templates.models.v2.response.TranslationsV2ListResponseDtoTest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
public class TemplatesV2ServiceTest extends TemplatesBaseTest {
  @Mock HttpClient httpClient;

  @Mock ServerConfiguration serverConfiguration;
  @Mock Map<String, AuthManager> authManagers;

  String uriPartID = "foovalue";
  static final Collection<String> AUTH_NAMES = Arrays.asList("Basic", "oAuth2");

  TemplatesV2Service service;

  @GivenTextResource("/domains/conversation/templates/v2/request/TemplateV2RequestDto.json")
  String jsonTemplateV2RequestDto;

  @GivenTextResource("/domains/conversation/templates/v2/TemplateV2Dto.json")
  String jsonTemplateV2Dto;

  @GivenTextResource("/domains/conversation/templates/v2/response/TemplatesV2ListResponseDto.json")
  String jsonTemplatesV2ListResponseDto;

  @GivenTextResource(
      "/domains/conversation/templates/v2/response/TranslationsV2ListResponseDto.json")
  String jsonTranslationsV2ListResponseDto;

  @BeforeEach
  public void initMocks() {
    service =
        new TemplatesV2ServiceImpl(
            httpClient, serverConfiguration, authManagers, HttpMapper.getInstance(), uriPartID);
  }

  @Test
  void create() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            String.format("/v2/projects/%s/templates", URLPathUtils.encodePathSegment(uriPartID)),
            HttpMethod.POST,
            Collections.emptyList(),
            jsonTemplateV2RequestDto,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonTemplateV2Dto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    TemplateV2 response = service.create(TemplateV2DtoTest.expectedDto);

    TestHelpers.recursiveEquals(response, TemplateV2DtoTest.expectedDto);
  }

  @Test
  void get() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            String.format(
                "/v2/projects/%s/templates/%s",
                URLPathUtils.encodePathSegment(uriPartID),
                URLPathUtils.encodePathSegment(TemplateV2DtoTest.expectedDto.getId())),
            HttpMethod.GET,
            Collections.emptyList(),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonTemplateV2Dto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    TemplateV2 response = service.get(TemplateV2DtoTest.expectedDto.getId());

    TestHelpers.recursiveEquals(response, TemplateV2DtoTest.expectedDto);
  }

  @Test
  void list() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            String.format("/v2/projects/%s/templates", URLPathUtils.encodePathSegment(uriPartID)),
            HttpMethod.GET,
            Collections.emptyList(),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(
            200, null, Collections.emptyMap(), jsonTemplatesV2ListResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    TemplatesV2ListResponse response = service.list();
    Iterator<TemplateV2> iterator = response.iterator();

    TemplatesV2ListResponse expectedListResponse =
        new TemplatesV2ListResponse(
            new Page<>(null, TemplatesV2ListResponseDtoTest.expectedDto.getTemplates(), null));
    Iterator<TemplateV2> expectedIterator = expectedListResponse.iterator();

    while (iterator.hasNext()) {
      TemplateV2 item = iterator.next();
      TemplateV2 expectedItem = expectedIterator.next();
      TestHelpers.recursiveEquals(item, expectedItem);
    }
    Assertions.assertThat(expectedIterator.hasNext()).isEqualTo(false);
  }

  @Test
  void listTranslations() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            String.format(
                "/v2/projects/%s/templates/%s/translations",
                URLPathUtils.encodePathSegment(uriPartID),
                URLPathUtils.encodePathSegment(TemplateV2DtoTest.expectedDto.getId())),
            HttpMethod.GET,
            Collections.emptyList(),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(
            200, null, Collections.emptyMap(), jsonTranslationsV2ListResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    TranslationsV2ListResponse response =
        service.listTranslations(TemplateV2DtoTest.expectedDto.getId());
    Iterator<TemplateTranslation> iterator = response.iterator();

    TranslationsV2ListResponse expectedListResponse =
        new TranslationsV2ListResponse(
            new Page<>(
                null, TranslationsV2ListResponseDtoTest.expectedDto.getTranslations(), null));
    Iterator<TemplateTranslation> expectedIterator = expectedListResponse.iterator();

    while (iterator.hasNext()) {
      TemplateTranslation item = iterator.next();
      TemplateTranslation expectedItem = expectedIterator.next();
      TestHelpers.recursiveEquals(item, expectedItem);
    }
    Assertions.assertThat(expectedIterator.hasNext()).isEqualTo(false);
  }

  @Test
  void listTranslationsWithParameters() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            String.format(
                "/v2/projects/%s/templates/%s/translations",
                URLPathUtils.encodePathSegment(uriPartID),
                URLPathUtils.encodePathSegment(TemplateV2DtoTest.expectedDto.getId())),
            HttpMethod.GET,
            Arrays.asList(
                new URLParameter("language_code", "language code", STYLE.FORM, true),
                new URLParameter("translation_version", "translation version", STYLE.FORM, true)),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(
            200, null, Collections.emptyMap(), jsonTranslationsV2ListResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    TranslationsV2ListResponse response =
        service.listTranslations(
            TemplateV2DtoTest.expectedDto.getId(),
            ListTranslationsQueryParameters.builder()
                .setLanguageCode("language code")
                .setTranslationVersion("translation version")
                .build());
    Iterator<TemplateTranslation> iterator = response.iterator();

    TranslationsV2ListResponse expectedListResponse =
        new TranslationsV2ListResponse(
            new Page<>(
                null, TranslationsV2ListResponseDtoTest.expectedDto.getTranslations(), null));
    Iterator<TemplateTranslation> expectedIterator = expectedListResponse.iterator();

    while (iterator.hasNext()) {
      TemplateTranslation item = iterator.next();
      TemplateTranslation expectedItem = expectedIterator.next();
      TestHelpers.recursiveEquals(item, expectedItem);
    }
    Assertions.assertThat(expectedIterator.hasNext()).isEqualTo(false);
  }

  @Test
  void update() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            String.format(
                "/v2/projects/%s/templates/%s",
                URLPathUtils.encodePathSegment(uriPartID),
                URLPathUtils.encodePathSegment(TemplateV2DtoTest.expectedDto.getId())),
            HttpMethod.PUT,
            Collections.emptyList(),
            jsonTemplateV2RequestDto,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonTemplateV2Dto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    TemplateV2 response =
        service.update(TemplateV2DtoTest.expectedDto.getId(), TemplateV2DtoTest.expectedDto);

    TestHelpers.recursiveEquals(response, TemplateV2DtoTest.expectedDto);
  }

  @Test
  void delete() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            String.format(
                "/v2/projects/%s/templates/%s",
                URLPathUtils.encodePathSegment(uriPartID),
                URLPathUtils.encodePathSegment(TemplateV2DtoTest.expectedDto.getId())),
            HttpMethod.DELETE,
            Collections.emptyList(),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            AUTH_NAMES);
    HttpResponse httpResponse = new HttpResponse(200, null, Collections.emptyMap(), null);

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    service.delete(TemplateV2DtoTest.expectedDto.getId());
  }
}
