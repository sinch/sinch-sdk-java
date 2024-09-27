package com.sinch.sdk.domains.conversation.api.v1.adapters;

import static org.mockito.ArgumentMatchers.any;
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
import com.sinch.sdk.domains.conversation.api.v1.internal.WebhooksApi;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.ClientCredentialsDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.Webhook;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.WebhookDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.WebhookImpl;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.WebhookTargetType;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.WebhookTrigger;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.internal.CreateWebhookRequestInternal;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.response.ListWebhookResponseDtoTest;
import com.sinch.sdk.models.ConversationContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;

@TestWithResources
public class WebHooksClientServiceTest extends ConversationBaseTest {
  @Mock ConversationContext context;
  @Mock WebhooksApi api;
  @Mock HttpClient httpClient;
  @Mock Map<String, AuthManager> authManagers;
  @Mock ConversationWebhooksAuthenticationValidation authenticationValidation;

  @Captor ArgumentCaptor<String> uriPartIDCaptor;
  @Captor ArgumentCaptor<String> idCaptor;
  @Captor ArgumentCaptor<Webhook> webhookCaptor;
  @Captor ArgumentCaptor<CreateWebhookRequestInternal> webhookCreateRequestCaptor;

  @Captor ArgumentCaptor<List<String>> maskCaptor;

  WebHooksService service;
  String uriPartID = "foovalue";

  @BeforeEach
  public void initMocks() {
    service =
        spy(
            new WebHooksService(
                uriPartID, context, httpClient, authManagers, authenticationValidation));
    doReturn(api).when(service).getApi();
  }

  @Test
  void list() throws ApiException {
    when(api.webhooksListWebhooks(
            eq(uriPartID),
            eq(ListWebhookResponseDtoTest.expectedRequestDto.getWebhooks().get(0).getAppId())))
        .thenReturn(ListWebhookResponseDtoTest.expectedResponseDto);

    Collection<Webhook> response =
        service.list(ListWebhookResponseDtoTest.expectedRequestDto.getWebhooks().get(0).getAppId());

    TestHelpers.recursiveEquals(
        response, ListWebhookResponseDtoTest.expectedResponseDto.getWebhooks());
  }

  @Test
  void get() throws ApiException {
    when(api.webhooksGetWebhook(eq(uriPartID), eq(WebhookDtoTest.expectedRequestDto.getId())))
        .thenReturn(WebhookDtoTest.expectedRequestDto);

    Webhook response = service.get(WebhookDtoTest.expectedRequestDto.getId());

    TestHelpers.recursiveEquals(response, WebhookDtoTest.expectedRequestDto);
  }

  @Test
  void create() throws ApiException {

    when(api.webhooksCreateWebhook(eq(uriPartID), any(CreateWebhookRequestInternal.class)))
        .thenReturn(WebhookDtoTest.expectedRequestDto);

    Webhook response = service.create(WebhookDtoTest.expectedRequestDto);

    verify(api)
        .webhooksCreateWebhook(uriPartIDCaptor.capture(), webhookCreateRequestCaptor.capture());

    WebhookImpl webhook = (WebhookImpl) WebhookDtoTest.expectedRequestDto;
    CreateWebhookRequestInternal.Builder builder = CreateWebhookRequestInternal.builder();
    webhook.appId().ifPresent(builder::setAppId);
    webhook.clientCredentials().ifPresent(builder::setClientCredentials);
    webhook.secret().ifPresent(builder::setSecret);
    webhook.target().ifPresent(builder::setTarget);
    webhook.targetType().ifPresent(builder::setTargetType);
    webhook.triggers().ifPresent(builder::setTriggers);

    Assertions.assertThat(uriPartIDCaptor.getValue()).isEqualTo(uriPartID);
    Assertions.assertThat(webhookCreateRequestCaptor.getValue()).isEqualTo(builder.build());

    TestHelpers.recursiveEquals(response, WebhookDtoTest.expectedRequestDto);
  }

  @Test
  void update() throws ApiException {
    Webhook update =
        Webhook.builder()
            .setAppId("my app id")
            .setTarget("my target")
            .setTriggers(Arrays.asList(WebhookTrigger.from("my trigger")))
            .setClientCredentials(ClientCredentialsDtoTest.expectedDto)
            .setTargetType(WebhookTargetType.HTTP)
            .build();

    List<String> mask =
        new ArrayList<>(
            Arrays.asList(
                WebhookImpl.JSON_PROPERTY_APP_ID,
                WebhookImpl.JSON_PROPERTY_CLIENT_CREDENTIALS,
                WebhookImpl.JSON_PROPERTY_TARGET,
                WebhookImpl.JSON_PROPERTY_TARGET_TYPE,
                WebhookImpl.JSON_PROPERTY_TRIGGERS));

    when(api.webhooksUpdateWebhook(
            eq(uriPartID),
            eq(WebhookDtoTest.expectedRequestDto.getId()),
            eq(update),
            any(List.class)))
        .thenReturn(WebhookDtoTest.expectedRequestDto);

    Webhook response = service.update(WebhookDtoTest.expectedRequestDto.getId(), update);

    verify(api)
        .webhooksUpdateWebhook(
            uriPartIDCaptor.capture(),
            idCaptor.capture(),
            webhookCaptor.capture(),
            maskCaptor.capture());

    TestHelpers.recursiveEquals(maskCaptor.getValue(), mask);

    TestHelpers.recursiveEquals(response, WebhookDtoTest.expectedRequestDto);
  }

  @Test
  void delete() throws ApiException {

    service.delete(WebhookDtoTest.expectedRequestDto.getId());

    verify(api).webhooksDeleteWebhook(uriPartIDCaptor.capture(), idCaptor.capture());

    Assertions.assertThat(uriPartIDCaptor.getValue()).isEqualTo(uriPartID);
    Assertions.assertThat(idCaptor.getValue()).isEqualTo(WebhookDtoTest.expectedRequestDto.getId());
  }
}
