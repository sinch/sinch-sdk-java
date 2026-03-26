package com.sinch.sdk.domains.sms.adapters;

import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.models.SmsContext;
import com.sinch.sdk.models.SmsServicePlanCredentials;
import com.sinch.sdk.models.UnifiedCredentials;
import java.util.function.Supplier;

public class SMSService implements com.sinch.sdk.domains.sms.SMSService {

  private final Supplier<com.sinch.sdk.domains.sms.api.v1.SMSService> v1Initializer;

  private volatile com.sinch.sdk.domains.sms.api.v1.SMSService v1;

  public SMSService(
      UnifiedCredentials credentials,
      SmsContext context,
      ServerConfiguration oAuthServer,
      Supplier<HttpClient> httpClientSupplier) {
    this.v1Initializer =
        () ->
            new com.sinch.sdk.domains.sms.api.v1.adapters.SMSService(
                credentials, context, oAuthServer, httpClientSupplier);
  }

  public SMSService(
      SmsServicePlanCredentials credentials,
      SmsContext context,
      Supplier<HttpClient> httpClientSupplier) {
    this.v1Initializer =
        () ->
            new com.sinch.sdk.domains.sms.api.v1.adapters.SMSService(
                credentials, context, httpClientSupplier);
  }

  @Override
  public com.sinch.sdk.domains.sms.api.v1.SMSService v1() {
    if (null == this.v1) {
      synchronized (this) {
        if (null == this.v1) {
          this.v1 = v1Initializer.get();
        }
      }
    }
    return this.v1;
  }
}
