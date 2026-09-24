package com.sinch.sdk.domains.voice.adapters;

import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.models.ApplicationCredentials;
import com.sinch.sdk.models.UnifiedCredentials;
import com.sinch.sdk.models.VoiceContext;
import java.util.function.Supplier;

public class VoiceService implements com.sinch.sdk.domains.voice.VoiceService {

  private final ApplicationCredentials credentials;
  private final UnifiedCredentials unifiedCredentials;
  private final VoiceContext context;
  private final ServerConfiguration oAuthServer;
  private final Supplier<HttpClient> httpClientSupplier;

  private volatile com.sinch.sdk.domains.voice.api.v1.VoiceService v1;
  private volatile com.sinch.sdk.domains.voice.api.v2.VoiceService v2;

  public VoiceService(
      ApplicationCredentials credentials,
      VoiceContext context,
      Supplier<HttpClient> httpClientSupplier) {
    this(credentials, null, context, null, httpClientSupplier);
  }

  public VoiceService(
      ApplicationCredentials credentials,
      UnifiedCredentials unifiedCredentials,
      VoiceContext context,
      ServerConfiguration oAuthServer,
      Supplier<HttpClient> httpClientSupplier) {
    this.credentials = credentials;
    this.unifiedCredentials = unifiedCredentials;
    this.context = context;
    this.oAuthServer = oAuthServer;
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

  public com.sinch.sdk.domains.voice.api.v2.VoiceService v2() {
    if (null == this.v2) {
      synchronized (this) {
        if (null == this.v2) {
          this.v2 =
              new com.sinch.sdk.domains.voice.api.v2.adapters.VoiceService(
                  unifiedCredentials, context, oAuthServer, httpClientSupplier);
        }
      }
    }
    return this.v2;
  }
}
