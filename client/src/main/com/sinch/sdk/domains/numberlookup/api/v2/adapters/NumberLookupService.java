package com.sinch.sdk.domains.numberlookup.api.v2.adapters;

import com.sinch.sdk.auth.adapters.OAuthManager;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.domains.numberlookup.models.v2.request.NumberLookupRequest;
import com.sinch.sdk.domains.numberlookup.models.v2.response.NumberLookupResponse;
import com.sinch.sdk.models.NumberLookupContext;
import com.sinch.sdk.models.UnifiedCredentials;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberLookupService
    implements com.sinch.sdk.domains.numberlookup.api.v2.NumberLookupService {

  private static final Logger LOGGER = Logger.getLogger(NumberLookupService.class.getName());
  private static final String SECURITY_SCHEME_KEYWORD_NUMBER_LOOKUP = "OAuth2";

  private final UnifiedCredentials credentials;
  private final NumberLookupContext context;
  private final ServerConfiguration oAuthServer;
  private final Supplier<HttpClient> httpClientSupplier;

  private volatile String uriUUID;
  private volatile Map<String, AuthManager> authManagers;

  private volatile NumberLookupServiceFacade lookup;

  public NumberLookupService(
      UnifiedCredentials credentials,
      NumberLookupContext context,
      ServerConfiguration oAuthServer,
      Supplier<HttpClient> httpClientSupplier) {
    this.credentials = credentials;
    this.context = context;
    this.oAuthServer = oAuthServer;
    this.httpClientSupplier = httpClientSupplier;
  }

  NumberLookupServiceFacade getLookupFacade() {
    if (null == this.lookup) {
      synchronized (this) {
        if (null == this.lookup) {
          instanceLazyInit();
          this.lookup =
              new NumberLookupServiceFacade(uriUUID, context, httpClientSupplier, authManagers);
        }
      }
    }
    return this.lookup;
  }

  @Override
  public NumberLookupResponse lookup(NumberLookupRequest numberLookupRequest) throws ApiException {
    return getLookupFacade().lookup(numberLookupRequest);
  }

  private void instanceLazyInit() {
    if (null != this.authManagers) {
      return;
    }
    synchronized (this) {
      if (null == this.authManagers) {
        Objects.requireNonNull(
            credentials, "Number Lookup service requires unified credentials to be defined");
        Objects.requireNonNull(context, "Number Lookup service requires context to be defined");
        StringUtil.requireNonEmpty(
            credentials.getKeyId(), "Number Lookup service requires 'keyId' to be defined");
        StringUtil.requireNonEmpty(
            credentials.getKeySecret(), "Number Lookup service requires 'keySecret' to be defined");
        StringUtil.requireNonEmpty(
            credentials.getProjectId(), "Number Lookup service requires 'projectId' to be defined");
        StringUtil.requireNonEmpty(
            context.getNumberLookupUrl(),
            "Number Lookup service requires 'numberLookupUrl' to be defined");

        LOGGER.fine(
            "Activate Number Lookup API with server='"
                + context.getNumberLookupServer().getUrl()
                + "'");

        AuthManager authManager =
            new OAuthManager(
                credentials, oAuthServer, HttpMapper.getInstance(), httpClientSupplier);

        uriUUID = credentials.getProjectId();
        authManagers =
            Stream.of(
                    new AbstractMap.SimpleEntry<>(
                        SECURITY_SCHEME_KEYWORD_NUMBER_LOOKUP, authManager))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
      }
    }
  }
}
