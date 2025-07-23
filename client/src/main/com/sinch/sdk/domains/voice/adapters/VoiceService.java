package com.sinch.sdk.domains.voice.adapters;

import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.models.ApplicationCredentials;
import com.sinch.sdk.models.VoiceContext;
import java.util.function.Supplier;

public class VoiceService implements com.sinch.sdk.domains.voice.VoiceService {

  private final com.sinch.sdk.domains.voice.api.v1.VoiceService v1;

  public VoiceService(
      ApplicationCredentials credentials,
      VoiceContext context,
      Supplier<HttpClient> httpClientSupplier) {

    this.v1 =
        new com.sinch.sdk.domains.voice.api.v1.adapters.VoiceService(
            credentials, context, httpClientSupplier);
  }

  public com.sinch.sdk.domains.voice.api.v1.VoiceService v1() {
    return this.v1;
  }
}
