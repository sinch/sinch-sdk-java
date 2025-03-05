package com.sinch.sdk.domains.conversation.api.v1.adapters;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.Webhook;
import com.sinch.sdk.models.ConversationContext;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
public class WebHooksAdaptorServiceTest extends ConversationBaseTest {

  @GivenTextResource("domains/conversation/v1/webhooks/events/capability/CapabilityEventDto.json")
  String jsonCapabilityEvent;

  WebHooksAdaptorService service;

  @Mock WebHooksApiService api;
  @Mock ConversationContext context;
  @Mock Runnable credentialValidation;
  @Mock Supplier<HttpClient> httpClient;
  @Mock Supplier<Map<String, AuthManager>> authManagers;

  String uriPartID = "foovalue";

  @BeforeEach
  public void initMocks() {
    service =
        spy(
            new WebHooksAdaptorService(
                uriPartID, context, credentialValidation, httpClient, authManagers));
  }

  @Test
  void list() throws ApiException {
    doReturn(api).when(service).getApiService();

    service.list("foo");

    verify(credentialValidation, times(1)).run();
  }

  @Test
  void get() throws ApiException {
    doReturn(api).when(service).getApiService();

    service.get("foo");

    verify(credentialValidation, times(1)).run();
  }

  @Test
  void create() throws ApiException {
    doReturn(api).when(service).getApiService();

    service.create(Webhook.builder().build());

    verify(credentialValidation, times(1)).run();
  }

  @Test
  void update() throws ApiException {
    doReturn(api).when(service).getApiService();

    service.update("foo", Webhook.builder().build());

    verify(credentialValidation, times(1)).run();
  }

  @Test
  void delete() throws ApiException {
    doReturn(api).when(service).getApiService();

    service.delete("foo");

    verify(credentialValidation, times(1)).run();
  }

  @Test
  void validateAuthenticationHeader() throws ApiException {

    service.validateAuthenticationHeader("", new HashMap<>(), "");

    verify(credentialValidation, times(0)).run();
  }

  @Test
  void parseEvent() throws ApiException {

    service.parseEvent(jsonCapabilityEvent);

    verify(credentialValidation, times(0)).run();
  }
}
