package com.sinch.sdk.domains.numbers.adapters;

import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.models.NumbersContext;
import com.sinch.sdk.models.UnifiedCredentials;

public class NumbersService implements com.sinch.sdk.domains.numbers.NumbersService {

  private final com.sinch.sdk.domains.numbers.api.v1.NumbersService v1;

  private AvailableNumberService available;
  private ActiveNumberService active;
  private AvailableRegionService regions;
  private CallbackConfigurationService callback;
  private WebHooksService webhooks;

  public NumbersService(
      UnifiedCredentials credentials, NumbersContext context, HttpClient httpClient) {

    this.v1 =
        new com.sinch.sdk.domains.numbers.api.v1.adapters.NumbersService(
            credentials, context, httpClient);
  }

  public com.sinch.sdk.domains.numbers.api.v1.NumbersService v1() {
    return v1;
  }

  public AvailableNumberService available() {
    if (null == this.available) {
      this.available = new AvailableNumberService(v1.available());
    }
    return this.available;
  }

  public AvailableRegionService regions() {
    if (null == this.regions) {
      this.regions = new AvailableRegionService(v1.regions());
    }
    return this.regions;
  }

  public ActiveNumberService active() {
    if (null == this.active) {
      this.active = new ActiveNumberService(v1.active());
    }
    return this.active;
  }

  public CallbackConfigurationService callback() {
    if (null == this.callback) {
      this.callback = new CallbackConfigurationService(v1().callback());
    }
    return this.callback;
  }

  public WebHooksService webhooks() {

    if (null == this.webhooks) {
      this.webhooks = new WebHooksService(v1().webhooks());
    }
    return this.webhooks;
  }
}
