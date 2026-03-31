package com.sinch.sdk.domains.voice.adapters;

import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.models.ApplicationCredentials;
import com.sinch.sdk.models.VoiceContext;
import java.util.function.Supplier;

public class VoiceService implements com.sinch.sdk.domains.voice.VoiceService {

  private final ApplicationCredentials credentials;
  private final VoiceContext context;
  private final Supplier<HttpClient> httpClientSupplier;

  private volatile com.sinch.sdk.domains.voice.api.v1.VoiceService v1;

  public VoiceService(
      ApplicationCredentials credentials,
      VoiceContext context,
      Supplier<HttpClient> httpClientSupplier) {
    this.credentials = credentials;
    this.context = context;
    this.httpClientSupplier = httpClientSupplier;
  }

  public com.sinch.sdk.domains.voice.api.v1.VoiceService v1() {
    if (null == this.v1) {
      synchronized (this) {
        if (null == this.v1) {
          this.v1 =
              new com.sinch.sdk.domains.voice.api.v1.adapters.VoiceService(
                  credentials, context, httpClientSupplier);
        }
      }
    }
    return this.v1;
  }
}
