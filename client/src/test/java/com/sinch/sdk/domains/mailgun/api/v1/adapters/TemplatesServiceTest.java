package com.sinch.sdk.domains.mailgun.api.v1.adapters;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.databind.multipart.ObjectMapperTest;
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
import com.sinch.sdk.domains.mailgun.api.v1.TemplatesService;
import com.sinch.sdk.domains.mailgun.models.v1.templates.Template;
import com.sinch.sdk.domains.mailgun.models.v1.templates.TemplateImpl;
import com.sinch.sdk.domains.mailgun.models.v1.templates.Version;
import com.sinch.sdk.domains.mailgun.models.v1.templates.VersionTest;
import com.sinch.sdk.domains.mailgun.models.v1.templates.request.CreateTemplateRequest;
import com.sinch.sdk.domains.mailgun.models.v1.templates.request.CreateVersionRequest;
import com.sinch.sdk.domains.mailgun.models.v1.templates.request.GetTemplateQueryParameters;
import com.sinch.sdk.domains.mailgun.models.v1.templates.request.UpdateVersionRequest;
import com.sinch.sdk.domains.mailgun.models.v1.templates.response.CreateTemplateResponseTest;
import com.sinch.sdk.domains.mailgun.models.v1.templates.response.GetTemplateResponseTest;
import com.sinch.sdk.domains.mailgun.models.v1.templates.response.ListTemplatesResponse;
import com.sinch.sdk.domains.mailgun.models.v1.templates.response.internal.ListTemplatesResponseInternal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
class TemplatesServiceTest extends BaseTest {

  static final String AUTH_NAME = "basicAuth";

  @GivenTextResource("/domains/mailgun/v1/templates/response/GetTemplateResponseDto.json")
  String jsonGetTemplateResponseDto;

  @GivenTextResource("/domains/mailgun/v1/templates/response/ListTemplatesResponseDtoPage0.json")
  String jsonListTemplatesResponseDtoPage0;

  @GivenJsonResource("/domains/mailgun/v1/templates/response/ListTemplatesResponseDtoPage0.json")
  ListTemplatesResponseInternal listTemplatesResponseDtoPage0;

  @GivenTextResource("/domains/mailgun/v1/templates/response/ListTemplatesResponseDtoPage1.json")
  String jsonListTemplatesResponseDtoPage1;

  @GivenJsonResource("/domains/mailgun/v1/templates/response/ListTemplatesResponseDtoPage1.json")
  ListTemplatesResponseInternal listTemplatesResponseDtoPage1;

  @GivenTextResource("/domains/mailgun/v1/templates/response/ListTemplatesResponseDtoPage2.json")
  String jsonListTemplatesResponseDtoPage2;

  @GivenTextResource("/domains/mailgun/v1/templates/response/CreateTemplateResponseDto.json")
  String jsonCreateTemplateResponseDto;

  @GivenTextResource("/domains/mailgun/v1/templates/response/CreateVersionResponseDto.json")
  String jsonCreateVersionResponseDto;

  @GivenTextResource("/domains/mailgun/v1/templates/response/UpdateVersionResponseDto.json")
  String jsonUpdateVersionResponseDto;

  @Mock ServerConfiguration serverConfiguration;
  @Mock HttpClient httpClient;
  @Mock Map<String, AuthManager> authManagers;

  TemplatesService service;

  String domainName = "foo Domain";
  String templateName = "template.test";
  String versionName = "version name value";

  @BeforeEach
  public void initMocks() {
    service =
        new TemplatesServiceImpl(
            httpClient, serverConfiguration, authManagers, HttpMapper.getInstance());
  }

  @Test
  void get() {

    HttpRequest httpRequest =
        new HttpRequest(
            "/v3/"
                + URLPathUtils.encodePathSegment(domainName)
                + "/templates/"
                + URLPathUtils.encodePathSegment(templateName),
            HttpMethod.GET,
            Collections.emptyList(),
            (Map) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            Collections.singletonList(AUTH_NAME));
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonGetTemplateResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    Template response = service.get(domainName, templateName);

    TestHelpers.recursiveEquals(response, GetTemplateResponseTest.expectedTemplate.getTemplate());
  }

  @Test
  void getWithActive() {

    HttpRequest httpRequest =
        new HttpRequest(
            "/v3/"
                + URLPathUtils.encodePathSegment(domainName)
                + "/templates/"
                + URLPathUtils.encodePathSegment(templateName),
            HttpMethod.GET,
            Arrays.asList(new URLParameter("active", true, STYLE.FORM, true)),
            (Map) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            Collections.singletonList(AUTH_NAME));
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonGetTemplateResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    Template response =
        service.get(
            domainName, templateName, GetTemplateQueryParameters.builder().setActive(true).build());

    TestHelpers.recursiveEquals(response, GetTemplateResponseTest.expectedTemplate.getTemplate());
  }

  @Test
  void listDefault() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/v3/" + URLPathUtils.encodePathSegment(domainName) + "/templates",
            HttpMethod.GET,
            Collections.emptyList(),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            Collections.singletonList(AUTH_NAME));
    HttpResponse httpResponse =
        new HttpResponse(
            200, null, Collections.emptyMap(), jsonListTemplatesResponseDtoPage0.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    ListTemplatesResponse response = service.list(domainName);

    TestHelpers.recursiveEquals(response.getContent(), listTemplatesResponseDtoPage0.getItems());
  }

  @Test
  void list() throws ApiException {

    HttpRequest httpRequest0 =
        new HttpRequest(
            "/v3/" + URLPathUtils.encodePathSegment(domainName) + "/templates",
            HttpMethod.GET,
            Collections.emptyList(),
            (Map) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            Collections.singletonList(AUTH_NAME));

    HttpRequest httpRequest1 =
        new HttpRequest(
            "https://api.mailgun.net/v3/sandboxFOO.mailgun.org/templates?page=next&p=letter+tempalte+from+dashboard&limit=2",
            HttpMethod.GET,
            null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            Collections.singletonList(AUTH_NAME));

    HttpRequest httpRequest2 =
        new HttpRequest(
            "https://api.mailgun.net/v3/sandboxFOO.mailgun.org/templates?page=next&p=template.test&limit=2",
            HttpMethod.GET,
            null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            Collections.singletonList(AUTH_NAME));

    HttpResponse httpResponse0 =
        new HttpResponse(
            200, null, Collections.emptyMap(), jsonListTemplatesResponseDtoPage0.getBytes());
    HttpResponse httpResponse1 =
        new HttpResponse(
            200, null, Collections.emptyMap(), jsonListTemplatesResponseDtoPage1.getBytes());
    HttpResponse httpResponse2 =
        new HttpResponse(
            200, null, Collections.emptyMap(), jsonListTemplatesResponseDtoPage2.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest0))))
        .thenReturn(httpResponse0);

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest1))))
        .thenReturn(httpResponse1);

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest2))))
        .thenReturn(httpResponse2);

    ListTemplatesResponse response = service.list(domainName);

    Iterator<Template> iterator = response.iterator();

    Template item = iterator.next();
    TestHelpers.recursiveEquals(item, listTemplatesResponseDtoPage0.getItems().get(0));
    Assertions.assertThat(iterator.hasNext()).isEqualTo(true);

    item = iterator.next();
    TestHelpers.recursiveEquals(item, listTemplatesResponseDtoPage0.getItems().get(1));
    Assertions.assertThat(iterator.hasNext()).isEqualTo(true);

    item = iterator.next();
    TestHelpers.recursiveEquals(item, listTemplatesResponseDtoPage1.getItems().get(0));

    Assertions.assertThat(iterator.hasNext()).isEqualTo(false);
  }

  @Test
  void create() {

    HttpRequest httpRequest =
        new HttpRequest(
            "/v3/" + URLPathUtils.encodePathSegment(domainName) + "/templates",
            HttpMethod.POST,
            Collections.emptyList(),
            ObjectMapperTest.fillMap("name", "template name"),
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.MULTIPART_FORM_DATA),
            Collections.singletonList(AUTH_NAME));
    HttpResponse httpResponse =
        new HttpResponse(
            200, null, Collections.emptyMap(), jsonCreateTemplateResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    CreateTemplateRequest request =
        CreateTemplateRequest.builder().setName("template name").build();
    Template response = service.create(domainName, request);

    TestHelpers.recursiveEquals(
        response, CreateTemplateResponseTest.expectedTemplate.getTemplate());
  }

  @Test
  void createVersion() {

    HttpRequest httpRequest =
        new HttpRequest(
            "/v3/"
                + URLPathUtils.encodePathSegment(domainName)
                + "/templates/"
                + templateName
                + "/versions",
            HttpMethod.POST,
            Collections.emptyList(),
            ObjectMapperTest.fillMap("template", "foo template value", "tag", versionName),
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.MULTIPART_FORM_DATA),
            Collections.singletonList(AUTH_NAME));
    HttpResponse httpResponse =
        new HttpResponse(
            200, null, Collections.emptyMap(), jsonCreateVersionResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    CreateVersionRequest request =
        CreateVersionRequest.builder()
            .setTag(versionName)
            .setTemplate("foo template value")
            .build();
    Version response = service.createVersion(domainName, templateName, request);

    TestHelpers.recursiveEquals(
        response, ((TemplateImpl) (VersionTest.expectedCreatedVersion.getTemplate())).getVersion());
  }

  @Test
  void updateVersion() {

    HttpRequest httpRequest =
        new HttpRequest(
            "/v3/"
                + URLPathUtils.encodePathSegment(domainName)
                + "/templates/"
                + templateName
                + "/versions/"
                + URLPathUtils.encodePathSegment(versionName),
            HttpMethod.PUT,
            Collections.emptyList(),
            ObjectMapperTest.fillMap("comment", "comment value"),
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.MULTIPART_FORM_DATA),
            Collections.singletonList(AUTH_NAME));
    HttpResponse httpResponse =
        new HttpResponse(
            200, null, Collections.emptyMap(), jsonUpdateVersionResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    UpdateVersionRequest request =
        UpdateVersionRequest.builder().setComment("comment value").build();
    service.updateVersion(domainName, templateName, versionName, request);
  }
}
