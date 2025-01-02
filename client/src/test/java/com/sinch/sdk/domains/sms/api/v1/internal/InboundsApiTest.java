package com.sinch.sdk.domains.sms.api.v1.internal;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.spy;
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
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.domains.sms.models.v1.inbounds.InboundMessage;
import com.sinch.sdk.domains.sms.models.v1.inbounds.TextMessage;
import com.sinch.sdk.domains.sms.models.v1.inbounds.request.ListInboundMessagesQueryParameters;
import com.sinch.sdk.domains.sms.models.v1.inbounds.response.internal.ApiInboundList;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
public class InboundsApiTest extends BaseTest {

  static final String SMS_AUTH_NAMES = "BearerAuth";

  @GivenTextResource("/domains/sms/v1/inbounds/InboundTextDto.json")
  String jsonTextMessageDto;

  @GivenJsonResource("/domains/sms/v1/inbounds/InboundTextDto.json")
  TextMessage textMessageDto;

  @GivenTextResource("/domains/sms/v1/inbounds/response/internal/InboundsListResponseDtoPage0.json")
  String jsonInboundsListResponseDto;

  @GivenJsonResource("/domains/sms/v1/inbounds/response/internal/InboundsListResponseDtoPage0.json")
  ApiInboundList listInboundsListResponseDto;

  @Mock HttpClient httpClient;
  @Mock ServerConfiguration serverConfiguration;

  HttpMapper httpMapper = new HttpMapper();
  @Mock Map<String, AuthManager> authManagers;
  InboundsApi api;
  String uriPartID = "foovalue";

  @BeforeEach
  public void initMocks() {
    api =
        spy(new InboundsApi(httpClient, serverConfiguration, authManagers, httpMapper, uriPartID));
  }

  @Test
  void get() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/xms/v1/foovalue/inbounds/foo%20binary%20batch%20id",
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

    InboundMessage response = api.get("foo binary batch id");

    TestHelpers.recursiveEquals(response, textMessageDto);
  }

  @Test
  void list() throws ApiException {

    Collection<URLParameter> urlParameters =
        Arrays.asList(
            new URLParameter("page", 1, STYLE.FORM, true),
            new URLParameter("page_size", 2, STYLE.FORM, true),
            new URLParameter("to", "+1234567890", STYLE.FORM, true),
            new URLParameter("start_date", "2023-11-03T15:21:21.113Z", STYLE.FORM, true),
            new URLParameter("end_date", "2023-12-12T15:54:21.321Z", STYLE.FORM, true),
            new URLParameter("client_reference", "client reference", STYLE.FORM, true));

    HttpRequest httpRequest =
        new HttpRequest(
            "/xms/v1/foovalue/inbounds",
            HttpMethod.GET,
            urlParameters,
            null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            Collections.singletonList(SMS_AUTH_NAMES));
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonInboundsListResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    ListInboundMessagesQueryParameters initialRequest =
        ListInboundMessagesQueryParameters.builder()
            .setPage(1)
            .setPageSize(2)
            .setTo(Arrays.asList("+1234567890"))
            .setClientReference("client reference")
            .setStartDate(Instant.parse("2023-11-03T15:21:21.113Z"))
            .setEndDate(Instant.parse("2023-12-12T15:54:21.321Z"))
            .build();

    ApiInboundList response = api.list(initialRequest);

    TestHelpers.recursiveEquals(response, listInboundsListResponseDto);
  }
}
