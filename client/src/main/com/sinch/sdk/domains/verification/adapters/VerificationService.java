package com.sinch.sdk.domains.verification.adapters;

import com.sinch.sdk.auth.adapters.BasicAuthManager;
import com.sinch.sdk.auth.adapters.VerificationApplicationAuthManager;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.domains.verification.VerificationsService;
import com.sinch.sdk.models.Configuration;
import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VerificationService implements com.sinch.sdk.domains.verification.VerificationService {

  // FIXME: Verification OAS file claim it support "Basic" but miss the "Application" definition
  // trick to adapt the mapping of "Basic" keyword to the dedicated "Application" auth manager
  private static final String SECURITY_SCHEME_KEYWORD_VERIFICATION = "Basic";

  private final Configuration configuration;
  private final HttpClient httpClient;
  private VerificationsService verifications;
  private final Map<String, AuthManager> authManagers;

  public VerificationService(Configuration configuration, HttpClient httpClient) {
    this.configuration = configuration;
    this.httpClient = httpClient;

    AuthManager authManager;
    boolean useApplicationAuth = true;
    if (useApplicationAuth) {
      authManager =
          new VerificationApplicationAuthManager(
              configuration.getKeyId(),
              // TODO: Currently Verification do not accept project related key/secret. TBC
              // fallback to the verifications usage ones for POC
              // Base64.getEncoder().encodeToString(configuration.getKeySecret().getBytes(StandardCharsets.UTF_8))
              configuration.getKeySecret());
    } else {
      authManager = new BasicAuthManager(configuration);
    }
    authManagers =
        Stream.of(new AbstractMap.SimpleEntry<>(SECURITY_SCHEME_KEYWORD_VERIFICATION, authManager))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
  }

  @Override
  public VerificationsService verifications() {
    if (null == this.verifications) {
      this.verifications =
          new com.sinch.sdk.domains.verification.adapters.VerificationsService(
              configuration, httpClient, authManagers);
    }
    return this.verifications;
  }
}
