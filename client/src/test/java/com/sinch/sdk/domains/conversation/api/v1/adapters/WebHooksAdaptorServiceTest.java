package com.sinch.sdk.domains.conversation.api.v1.adapters;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.conversation.api.v1.WebHooksService;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.Webhook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
public class WebHooksAdaptorServiceTest extends ConversationBaseTest {

  WebHooksService service;

  @Mock Runnable credentialValidation;
  @Mock WebHooksApiService apiService;
  @Mock WebHooksCallbackService callbackService;

  @BeforeEach
  public void initMocks() {
    service = spy(new WebHooksAdaptorService(credentialValidation, apiService, callbackService));
  }

  @Test
  void list() throws ApiException {

    service.list("foo");

    verify(credentialValidation, times(1)).run();
  }

  @Test
  void get() throws ApiException {

    service.get("foo");

    verify(credentialValidation, times(1)).run();
  }

  @Test
  void create() throws ApiException {

    service.create(Webhook.builder().build());

    verify(credentialValidation, times(1)).run();
  }

  @Test
  void update() throws ApiException {

    service.update("foo", Webhook.builder().build());

    verify(credentialValidation, times(1)).run();
  }

  @Test
  void delete() throws ApiException {

    service.delete("foo");

    verify(credentialValidation, times(1)).run();
  }
}
