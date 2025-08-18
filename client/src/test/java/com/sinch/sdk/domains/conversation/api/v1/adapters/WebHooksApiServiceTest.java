package com.sinch.sdk.domains.conversation.api.v1.adapters;

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
import com.sinch.sdk.core.http.URLPathUtils;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.core.models.pagination.Page;
import com.sinch.sdk.domains.conversation.api.v1.WebhooksService;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.Webhook;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.WebhookDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.response.ListWebhookResponseDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.response.WebhooksListResponse;
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
public class WebHooksApiServiceTest extends ConversationBaseTest {

  @Mock ServerConfiguration serverConfiguration;
  @Mock HttpClient httpClient;
  @Mock Map<String, AuthManager> authManagers;
  WebhooksService service;
  String uriPartID = "foovalue";
  String fooWebhookId = "barWebhookId";
  String fooAppId = "barAppId";

  static final Collection<String> AUTH_NAMES = Arrays.asList("Basic", "oAuth2");

  @GivenTextResource("domains/conversation/v1/webhooks/WebhookRequestDto.json")
  String jsonWebhookRequestDto;

  @GivenTextResource("/domains/conversation/v1/webhooks/WebhookResponseDto.json")
  String jsonWebhookResponseDto;

  @GivenTextResource("domains/conversation/v1/webhooks/response/ListWebhooksResponseDto.json")
  String jsonListWebhooksResponseDto;

  @BeforeEach
  public void initMocks() {
    service =
        new WebhooksServiceImpl(
            httpClient,
            serverConfiguration,
            authManagers,
            HttpMapper.getInstance(),
            uriPartID,
            null);
  }

  @Test
  void list() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            String.format(
                "/v1/projects/%s/apps/%s/webhooks",
                URLPathUtils.encodePathSegment(uriPartID),
                URLPathUtils.encodePathSegment(fooAppId)),
            HttpMethod.GET,
            Collections.emptyList(),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonListWebhooksResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    WebhooksListResponse response = service.list(fooAppId);
    Iterator<Webhook> iterator = response.iterator();

    WebhooksListResponse expectedListResponse =
        new WebhooksListResponse(
            new Page<>(null, ListWebhookResponseDtoTest.expectedResponseDto.getWebhooks(), null));
    Iterator<Webhook> expectedIterator = expectedListResponse.iterator();

    while (iterator.hasNext()) {
      Webhook item = iterator.next();
      Webhook expectedItem = expectedIterator.next();
      TestHelpers.recursiveEquals(item, expectedItem);
    }
    Assertions.assertThat(expectedIterator.hasNext()).isEqualTo(false);
  }

  @Test
  void get() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            String.format("/v1/projects/%s/webhooks/%s", uriPartID, fooWebhookId),
            HttpMethod.GET,
            Collections.emptyList(),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonWebhookResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    Webhook response = service.get(fooWebhookId);

    TestHelpers.recursiveEquals(response, WebhookDtoTest.expectedResponseDto);
  }

  @Test
  void create() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            String.format("/v1/projects/%s/webhooks", uriPartID),
            HttpMethod.POST,
            Collections.emptyList(),
            jsonWebhookRequestDto,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonWebhookResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    Webhook response = service.create(WebhookDtoTest.expectedRequestDto);

    TestHelpers.recursiveEquals(response, WebhookDtoTest.expectedResponseDto);
  }

  @Test
  void update() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            String.format("/v1/projects/%s/webhooks/%s", uriPartID, fooWebhookId),
            HttpMethod.PATCH,
            Collections.emptyList(),
            jsonWebhookRequestDto,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonWebhookResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    Webhook response = service.update(fooWebhookId, WebhookDtoTest.expectedResponseDto);

    TestHelpers.recursiveEquals(response, WebhookDtoTest.expectedResponseDto);
  }

  @Test
  void delete() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            String.format("/v1/projects/%s/webhooks/%s", uriPartID, fooWebhookId),
            HttpMethod.DELETE,
            Collections.emptyList(),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            AUTH_NAMES);
    HttpResponse httpResponse = new HttpResponse(204, null, Collections.emptyMap(), null);

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    service.delete(fooWebhookId);
  }
}
