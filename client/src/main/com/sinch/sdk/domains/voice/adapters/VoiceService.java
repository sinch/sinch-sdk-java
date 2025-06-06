package com.sinch.sdk.domains.voice.adapters;

import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.domains.voice.ApplicationsService;
import com.sinch.sdk.domains.voice.CalloutsService;
import com.sinch.sdk.domains.voice.WebHooksService;
import com.sinch.sdk.models.ApplicationCredentials;
import com.sinch.sdk.models.VoiceContext;
import java.util.function.Supplier;

public class VoiceService implements com.sinch.sdk.domains.voice.VoiceService {

  private CalloutsService callouts;
  private ConferencesService conferences;
  private CallsService calls;
  private ApplicationsService applications;
  private WebHooksService webhooks;

  private final com.sinch.sdk.domains.voice.api.v1.VoiceService v1;

  public VoiceService(
      ApplicationCredentials credentials,
      VoiceContext context,
      Supplier<HttpClient> httpClientSupplier) {

    this.v1 =
        new com.sinch.sdk.domains.voice.api.v1.adapters.VoiceService(
            credentials, context, httpClientSupplier);
  }

  public CalloutsService callouts() {
    if (null == this.callouts) {
      this.callouts = new com.sinch.sdk.domains.voice.adapters.CalloutsService(v1().callouts());
    }
    return this.callouts;
  }

  public ConferencesService conferences() {
    if (null == this.conferences) {
      this.conferences =
          new com.sinch.sdk.domains.voice.adapters.ConferencesService(v1.conferences());
    }
    return this.conferences;
  }

  public CallsService calls() {
    if (null == this.calls) {
      this.calls = new com.sinch.sdk.domains.voice.adapters.CallsService(v1.calls());
    }
    return this.calls;
  }

  public ApplicationsService applications() {
    if (null == this.applications) {
      this.applications =
          new com.sinch.sdk.domains.voice.adapters.ApplicationsService(v1.applications());
    }
    return this.applications;
  }

  public WebHooksService webhooks() {
    if (null == this.webhooks) {
      this.webhooks = new com.sinch.sdk.domains.voice.adapters.WebHooksService(v1.webhooks());
    }
    return this.webhooks;
  }

  public com.sinch.sdk.domains.voice.api.v1.VoiceService v1() {
    return this.v1;
  }
}
