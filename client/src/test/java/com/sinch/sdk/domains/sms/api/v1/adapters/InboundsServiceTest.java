package com.sinch.sdk.domains.sms.api.v1.adapters;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
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
import com.sinch.sdk.domains.PaginationFillerHelper;
import com.sinch.sdk.domains.sms.api.v1.InboundsService;
import com.sinch.sdk.domains.sms.models.v1.inbounds.InboundMessage;
import com.sinch.sdk.domains.sms.models.v1.inbounds.TextMessage;
import com.sinch.sdk.domains.sms.models.v1.inbounds.request.ListInboundMessagesQueryParameters;
import com.sinch.sdk.domains.sms.models.v1.inbounds.response.ListInboundsResponse;
import com.sinch.sdk.domains.sms.models.v1.inbounds.response.internal.ApiInboundList;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
public class InboundsServiceTest extends BaseTest {

  static final String SMS_AUTH_NAMES = "BearerAuth";
  static final String SERVICE_PLAN_ID = "foo value";
  static final String BATCH_ID = "foo batchID";

  @GivenTextResource("/domains/sms/v1/inbounds/InboundTextDto.json")
  String jsonTextMessageDto;

  @GivenJsonResource("/domains/sms/v1/inbounds/InboundTextDto.json")
  TextMessage textMessageDto;

  @GivenTextResource("/domains/sms/v1/inbounds/response/internal/InboundsListResponseDtoPage0.json")
  String jsonInboundsListResponseDto0;

  @GivenJsonResource("/domains/sms/v1/inbounds/response/internal/InboundsListResponseDtoPage0.json")
  ApiInboundList listInboundsListResponseDto0;

  @GivenTextResource("/domains/sms/v1/inbounds/response/internal/InboundsListResponseDtoPage1.json")
  String jsonInboundsListResponseDto1;

  @GivenJsonResource("/domains/sms/v1/inbounds/response/internal/InboundsListResponseDtoPage1.json")
  ApiInboundList listInboundsListResponseDto1;

  @GivenTextResource("/domains/sms/v1/inbounds/response/internal/InboundsListResponseDtoPage2.json")
  String jsonInboundsListResponseDto2;

  @Mock HttpClient httpClient;
  @Mock ServerConfiguration serverConfiguration;
  @Mock Map<String, AuthManager> authManagers;

  InboundsService service;

  @BeforeEach
  public void initMocks() {
    service =
        new InboundsServiceImpl(
            httpClient,
            serverConfiguration,
            authManagers,
            HttpMapper.getInstance(),
            SERVICE_PLAN_ID);
  }

  @Test
  void get() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/xms/v1/"
                + URLPathUtils.encodePathSegment(SERVICE_PLAN_ID)
                + "/inbounds/"
                + URLPathUtils.encodePathSegment(BATCH_ID),
            HttpMethod.GET,
            Collections.emptyList(),
            null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            Collections.singletonList(SMS_AUTH_NAMES));
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonTextMessageDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    InboundMessage response = service.get(BATCH_ID);

    TestHelpers.recursiveEquals(response, textMessageDto);
  }

  @Test
  void listDefault() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/xms/v1/" + URLPathUtils.encodePathSegment(SERVICE_PLAN_ID) + "/inbounds",
            HttpMethod.GET,
            Collections.emptyList(),
            null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            Collections.singletonList(SMS_AUTH_NAMES));
    HttpResponse httpResponse =
        new HttpResponse(
            200, null, Collections.emptyMap(), jsonInboundsListResponseDto0.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    ListInboundsResponse response = service.list();
    TestHelpers.recursiveEquals(response.getContent(), listInboundsListResponseDto0.getItems());
  }

  @Test
  void list() throws ApiException {

    List<Object> commonParameters =
        Arrays.asList(
            "page_size",
            2,
            STYLE.FORM,
            true,
            "to",
            "+1234567890",
            STYLE.FORM,
            true,
            "start_date",
            "2023-11-03T15:21:21.113Z",
            STYLE.FORM,
            true,
            "end_date",
            "2023-12-12T15:54:21.321Z",
            STYLE.FORM,
            true,
            "client_reference",
            "client reference",
            STYLE.FORM,
            true);

    Collection<URLParameter> urlParameters0 =
        PaginationFillerHelper.parametersFiller("page", 0, STYLE.FORM, true, commonParameters);
    Collection<URLParameter> urlParameters1 =
        PaginationFillerHelper.parametersFiller("page", 1, STYLE.FORM, true, commonParameters);
    Collection<URLParameter> urlParameters2 =
        PaginationFillerHelper.parametersFiller("page", 2, STYLE.FORM, true, commonParameters);

    HttpRequest httpRequest0 =
        new HttpRequest(
            "/xms/v1/" + URLPathUtils.encodePathSegment(SERVICE_PLAN_ID) + "/inbounds",
            HttpMethod.GET,
            urlParameters0,
            null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            Collections.singletonList(SMS_AUTH_NAMES));
    HttpRequest httpRequest1 =
        new HttpRequest(
            "/xms/v1/" + URLPathUtils.encodePathSegment(SERVICE_PLAN_ID) + "/inbounds",
            HttpMethod.GET,
            urlParameters1,
            null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            Collections.singletonList(SMS_AUTH_NAMES));
    HttpRequest httpRequest2 =
        new HttpRequest(
            "/xms/v1/" + URLPathUtils.encodePathSegment(SERVICE_PLAN_ID) + "/inbounds",
            HttpMethod.GET,
            urlParameters2,
            null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            Collections.singletonList(SMS_AUTH_NAMES));
    HttpResponse httpResponse0 =
        new HttpResponse(
            200, null, Collections.emptyMap(), jsonInboundsListResponseDto0.getBytes());
    HttpResponse httpResponse1 =
        new HttpResponse(
            200, null, Collections.emptyMap(), jsonInboundsListResponseDto1.getBytes());
    HttpResponse httpResponse2 =
        new HttpResponse(
            200, null, Collections.emptyMap(), jsonInboundsListResponseDto2.getBytes());
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

    ListInboundMessagesQueryParameters initialRequest =
        ListInboundMessagesQueryParameters.builder()
            .setPage(0)
            .setPageSize(2)
            .setTo(Arrays.asList("+1234567890"))
            .setClientReference("client reference")
            .setStartDate(Instant.parse("2023-11-03T15:21:21.113Z"))
            .setEndDate(Instant.parse("2023-12-12T15:54:21.321Z"))
            .build();

    ListInboundsResponse response = service.list(initialRequest);

    Iterator<InboundMessage> iterator = response.iterator();

    InboundMessage item = iterator.next();
    TestHelpers.recursiveEquals(item, listInboundsListResponseDto0.getItems().get(0));
    Assertions.assertThat(iterator.hasNext()).isEqualTo(true);

    item = iterator.next();
    TestHelpers.recursiveEquals(item, listInboundsListResponseDto0.getItems().get(1));
    Assertions.assertThat(iterator.hasNext()).isEqualTo(true);

    item = iterator.next();
    TestHelpers.recursiveEquals(item, listInboundsListResponseDto1.getItems().get(0));

    Assertions.assertThat(iterator.hasNext()).isEqualTo(false);
  }
}
