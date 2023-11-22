package com.sinch.sdk.domains.verification.adapters;

import com.sinch.sdk.auth.adapters.BasicAuthManager;
import com.sinch.sdk.auth.adapters.VerificationApplicationAuthManager;
import com.sinch.sdk.core.exceptions.ApiAuthException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.domains.verification.StatusService;
import com.sinch.sdk.domains.verification.VerificationsService;
import com.sinch.sdk.models.Configuration;
import java.util.AbstractMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VerificationService implements com.sinch.sdk.domains.verification.VerificationService {

  // FIXME: Verification OAS file claim it support "Basic" but miss the "Application" definition
  // trick to adapt the mapping of "Basic" keyword to the dedicated "Application" auth manager
  private static final String SECURITY_SCHEME_KEYWORD_VERIFICATION = "Basic";

  private final Configuration configuration;
  private final HttpClient httpClient;
  private VerificationsService verifications;
  private StatusService status;
  private Map<String, AuthManager> authManagers;
  private final Supplier<Map<String, AuthManager>> authManagersSupplier = () -> authManagers;

  public VerificationService(Configuration configuration, HttpClient httpClient) {
    this.configuration = configuration;
    this.httpClient = httpClient;
  }

  public VerificationService setApplicationCredentials(String key, String secret) {

    AuthManager authManager;
    boolean useApplicationAuth = true;
    if (useApplicationAuth) {
      authManager = new VerificationApplicationAuthManager(key, secret);
    } else {
      authManager = new BasicAuthManager(key, secret);
    }
    authManagers =
        Stream.of(new AbstractMap.SimpleEntry<>(SECURITY_SCHEME_KEYWORD_VERIFICATION, authManager))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    return this;
  }

  public VerificationsService verifications() {
    if (null == this.verifications) {
      checkCredentials();
      this.verifications =
          new com.sinch.sdk.domains.verification.adapters.VerificationsService(
              configuration, httpClient, authManagersSupplier);
    }
    return this.verifications;
  }

  public StatusService status() {
    if (null == this.status) {
      checkCredentials();
      this.status =
          new com.sinch.sdk.domains.verification.adapters.StatusService(
              configuration, httpClient, authManagersSupplier);
    }
    return this.status;
  }

  private void checkCredentials() throws ApiAuthException {
    if (null == authManagers || authManagers.isEmpty()) {
      throw new ApiAuthException(
          String.format(
              "Service '%s' cannot be called without defined credentials",
              this.getClass().getSimpleName()));
    }
  }
}
