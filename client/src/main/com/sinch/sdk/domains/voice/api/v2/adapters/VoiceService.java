package com.sinch.sdk.domains.voice.api.v2.adapters;

import com.sinch.sdk.auth.adapters.OAuthManager;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.domains.voice.api.v2.BatchesService;
import com.sinch.sdk.domains.voice.api.v2.CallsService;
import com.sinch.sdk.domains.voice.api.v2.SessionsService;
import com.sinch.sdk.domains.voice.models.v2.VoiceContext;
import com.sinch.sdk.models.UnifiedCredentials;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VoiceService implements com.sinch.sdk.domains.voice.api.v2.VoiceService {

  private static final Logger LOGGER = Logger.getLogger(VoiceService.class.getName());
  private static final String SECURITY_SCHEME_KEYWORD_VOICE = "SinchOAuth2";

  private final UnifiedCredentials credentials;
  private final VoiceContext context;
  private final ServerConfiguration oAuthServer;
  private final Supplier<HttpClient> httpClientSupplier;

  private volatile String uriUUID;
  private volatile Map<String, AuthManager> authManagers;

  private volatile CallsService calls;
  private volatile BatchesService batches;
  private volatile SessionsService sessions;
  private volatile SinchEventsService sinchEvents;

  public VoiceService(
      UnifiedCredentials credentials,
      VoiceContext context,
      ServerConfiguration oAuthServer,
      Supplier<HttpClient> httpClientSupplier) {
    this.credentials = credentials;
    this.context = context;
    this.oAuthServer = oAuthServer;
    this.httpClientSupplier = httpClientSupplier;
  }

  public CallsService calls() {
    if (null == this.calls) {
      synchronized (this) {
        if (null == this.calls) {
          instanceLazyInit();
          this.calls =
              new CallsServiceImpl(
                  httpClientSupplier.get(),
                  context.getVoiceServer(),
                  authManagers,
                  HttpMapper.getInstance(),
                  uriUUID);
        }
      }
    }
    return this.calls;
  }

  public BatchesService batches() {
    if (null == this.batches) {
      synchronized (this) {
        if (null == this.batches) {
          instanceLazyInit();
          this.batches =
              new BatchesServiceImpl(
                  httpClientSupplier.get(),
                  context.getVoiceServer(),
                  authManagers,
                  HttpMapper.getInstance(),
                  uriUUID);
        }
      }
    }
    return this.batches;
  }

  public SessionsService sessions() {
    if (null == this.sessions) {
      synchronized (this) {
        if (null == this.sessions) {
          instanceLazyInit();
          this.sessions =
              new SessionsServiceImpl(
                  httpClientSupplier.get(),
                  context.getVoiceServer(),
                  authManagers,
                  HttpMapper.getInstance(),
                  uriUUID);
        }
      }
    }
    return this.sessions;
  }

  public SinchEventsService sinchEvents() {
    // no lazy init: validating a Sinch Event takes service credentials on each call
    if (null == this.sinchEvents) {
      synchronized (this) {
        if (null == this.sinchEvents) {
          this.sinchEvents = new SinchEventsService();
        }
      }
    }
    return this.sinchEvents;
  }

  private void instanceLazyInit() {
    if (null != this.authManagers) {
      return;
    }
    synchronized (this) {
      if (null == this.authManagers) {
        Objects.requireNonNull(
            credentials, "Voice V2 service requires unified credentials to be defined");
        Objects.requireNonNull(context, "Voice V2 service requires context to be defined");
        StringUtil.requireNonEmpty(
            credentials.getKeyId(), "Voice V2 service requires 'keyId' to be defined");
        StringUtil.requireNonEmpty(
            credentials.getKeySecret(), "Voice V2 service requires 'keySecret' to be defined");
        StringUtil.requireNonEmpty(
            credentials.getProjectId(), "Voice V2 service requires 'projectId' to be defined");
        StringUtil.requireNonEmpty(
            context.getVoiceUrl(), "Voice V2 service requires 'voiceUrl' to be defined");

        LOGGER.fine(
            "Activate Voice V2 API with server='" + context.getVoiceServer().getUrl() + "'");

        AuthManager authManager =
            new OAuthManager(
                credentials, oAuthServer, HttpMapper.getInstance(), httpClientSupplier);

        uriUUID = credentials.getProjectId();
        authManagers =
            Stream.of(new AbstractMap.SimpleEntry<>(SECURITY_SCHEME_KEYWORD_VOICE, authManager))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
      }
    }
  }
}
