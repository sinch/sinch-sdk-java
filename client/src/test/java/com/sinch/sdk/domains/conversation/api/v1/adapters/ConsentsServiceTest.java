package com.sinch.sdk.domains.conversation.api.v1.adapters;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
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
import com.sinch.sdk.domains.conversation.api.v1.ConsentsService;
import com.sinch.sdk.domains.conversation.models.v1.consents.ConsentsDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.consents.ConsentsListType;
import com.sinch.sdk.domains.conversation.models.v1.consents.Identity;
import com.sinch.sdk.domains.conversation.models.v1.consents.request.ConsentsListQueryParameters;
import com.sinch.sdk.domains.conversation.models.v1.consents.response.AuditRecordsResponse;
import com.sinch.sdk.domains.conversation.models.v1.consents.response.ConsentsListResponse;
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
class ConsentsServiceTest extends BaseTest {

  @Mock HttpClient httpClient;
  @Mock ServerConfiguration serverConfiguration;
  @Mock Map<String, AuthManager> authManagers;

  static final String uriUUID = "foo";
  static final String APP_ID = "an app id";
  static final String IDENTITY = "an identity value";
  static final Collection<String> AUTH_NAMES = Arrays.asList("Basic", "oAuth2");

  ConsentsService service;

  @GivenTextResource("/domains/conversation/v1/consents/ConsentsListResponseDtoPage0.json")
  String jsonConsentsListResponseDtoPage0;

  @GivenTextResource("/domains/conversation/v1/consents/ConsentsListResponseDtoPage1.json")
  String jsonConsentsListResponseDtoPage1;

  @GivenTextResource("/domains/conversation/v1/consents/AuditRecordsResponseDto.json")
  String jsonAuditRecordsResponseDto;

  @BeforeEach
  public void initMocks() {
    service =
        new ConsentsServiceImpl(
            httpClient, serverConfiguration, authManagers, HttpMapper.getInstance(), uriUUID);
  }

  @Test
  void listIdentities() throws ApiException {

    HttpRequest httpRequest1 =
        new HttpRequest(
            String.format(
                "/v1/projects/%s/apps/%s/consents/%s",
                URLPathUtils.encodePathSegment(uriUUID),
                URLPathUtils.encodePathSegment(APP_ID),
                URLPathUtils.encodePathSegment(ConsentsListType.OPT_OUT_ALL.toString())),
            HttpMethod.GET,
            Collections.emptyList(),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            AUTH_NAMES);
    HttpRequest httpRequest2 =
        new HttpRequest(
            String.format(
                "/v1/projects/%s/apps/%s/consents/%s",
                URLPathUtils.encodePathSegment(uriUUID),
                URLPathUtils.encodePathSegment(APP_ID),
                URLPathUtils.encodePathSegment(ConsentsListType.OPT_OUT_ALL.toString())),
            HttpMethod.GET,
            Collections.singletonList(
                new URLParameter("page_token", "the next page token value", STYLE.FORM, true)),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            AUTH_NAMES);
    HttpResponse httpResponse1 =
        new HttpResponse(
            200, null, Collections.emptyMap(), jsonConsentsListResponseDtoPage0.getBytes());
    HttpResponse httpResponse2 =
        new HttpResponse(
            200, null, Collections.emptyMap(), jsonConsentsListResponseDtoPage1.getBytes());

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

    ConsentsListResponse response = service.listIdentities(APP_ID, ConsentsListType.OPT_OUT_ALL);

    Iterator<Identity> iterator = response.iterator();

    Assertions.assertThat(iterator.hasNext()).isEqualTo(true);
    Identity item = iterator.next();
    TestHelpers.recursiveEquals(item, ConsentsDtoTest.expectedIdentityDto);

    item = iterator.next();
    TestHelpers.recursiveEquals(
        item, Identity.builder().setIdentity("a 2nd identity value").build());
    Assertions.assertThat(iterator.hasNext()).isEqualTo(true);

    item = iterator.next();
    TestHelpers.recursiveEquals(
        item, Identity.builder().setIdentity("a 3rd identity value").build());
    Assertions.assertThat(iterator.hasNext()).isEqualTo(false);
  }

  @Test
  void listIdentitiesWithQueryParameters() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            String.format(
                "/v1/projects/%s/apps/%s/consents/%s",
                URLPathUtils.encodePathSegment(uriUUID),
                URLPathUtils.encodePathSegment(APP_ID),
                URLPathUtils.encodePathSegment(ConsentsListType.OPT_OUT_MARKETING.toString())),
            HttpMethod.GET,
            Collections.singletonList(new URLParameter("page_size", 5, STYLE.FORM, true)),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(
            200, null, Collections.emptyMap(), jsonConsentsListResponseDtoPage1.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    ConsentsListQueryParameters queryParams =
        ConsentsListQueryParameters.builder().setPageSize(5).build();
    ConsentsListResponse response =
        service.listIdentities(APP_ID, ConsentsListType.OPT_OUT_MARKETING, queryParams);

    Assertions.assertThat(response.getContent()).isNotEmpty();
  }

  @Test
  void listAuditRecords() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            String.format(
                "/v1/projects/%s/apps/%s/consents/identities/%s",
                URLPathUtils.encodePathSegment(uriUUID),
                URLPathUtils.encodePathSegment(APP_ID),
                URLPathUtils.encodePathSegment(IDENTITY)),
            HttpMethod.GET,
            Collections.emptyList(),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonAuditRecordsResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    AuditRecordsResponse response = service.listAuditRecords(APP_ID, IDENTITY);

    TestHelpers.recursiveEquals(response, ConsentsDtoTest.expectedAuditRecordsResponseDto);
  }
}
