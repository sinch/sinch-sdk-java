package com.sinch.sdk.domains.mailgun.api.v1.adapters;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
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
import com.sinch.sdk.domains.mailgun.models.v1.templates.request.GetTemplateQueryParameters;
import com.sinch.sdk.domains.mailgun.models.v1.templates.response.GetTemplateResponseTest;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
class TemplatesServiceTest extends BaseTest {

  static final String AUTH_NAME = "basicAuth";

  @GivenTextResource("/domains/mailgun/v1/templates/response/GetTemplateResponseDto.json")
  String jsonGetTemplateResponseDto;

  @Mock ServerConfiguration serverConfiguration;
  @Mock HttpClient httpClient;
  @Mock Map<String, AuthManager> authManagers;

  TemplatesService service;

  String domainName = "foo Domain";
  String templateName = "template.test";

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
}
