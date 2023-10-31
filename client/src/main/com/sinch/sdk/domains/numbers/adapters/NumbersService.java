package com.sinch.sdk.domains.numbers.adapters;

import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.models.Configuration;

public class NumbersService implements com.sinch.sdk.domains.numbers.NumbersService {

  private final Configuration configuration;
  private final HttpClient httpClient;
  private AvailableNumberService available;
  private ActiveNumberService active;
  private AvailableRegionService regions;
  private CallbackConfigurationService callback;

  public NumbersService(Configuration configuration, HttpClient httpClient) {
    this.configuration = configuration;
    this.httpClient = httpClient;
  }

  public AvailableNumberService available() {
    if (null == this.available) {
      this.available = new AvailableNumberService(configuration, httpClient);
    }
    return this.available;
  }

  public AvailableRegionService regions() {
    if (null == this.regions) {
      this.regions = new AvailableRegionService(configuration, httpClient);
    }
    return this.regions;
  }

  public ActiveNumberService active() {
    if (null == this.active) {
      this.active = new ActiveNumberService(configuration, httpClient);
    }
    return this.active;
  }

  public CallbackConfigurationService callback() {
    if (null == this.callback) {
      this.callback = new CallbackConfigurationService(configuration, httpClient);
    }
    return this.callback;
  }
}
