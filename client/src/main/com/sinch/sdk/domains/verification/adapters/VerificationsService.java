package com.sinch.sdk.domains.verification.adapters;

import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.domains.verification.adapters.api.v1.SendingAndReportingVerificationsApi;
import com.sinch.sdk.domains.verification.adapters.converters.VerificationsDtoConverter;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationRequestParameters;
import com.sinch.sdk.models.Configuration;
import java.util.Map;

public class VerificationsService
    implements com.sinch.sdk.domains.verification.VerificationsService {

  private SendingAndReportingVerificationsApi api;

  public VerificationsService() {}

  public VerificationsService(
      Configuration configuration, HttpClient httpClient, Map<String, AuthManager> authManager) {
    this.api =
        new SendingAndReportingVerificationsApi(
            httpClient, configuration.getVerificationServer(), authManager, new HttpMapper());
  }

  private SendingAndReportingVerificationsApi getApi() {
    return this.api;
  }

  public void start(StartVerificationRequestParameters parameters) {
    getApi().startVerification(VerificationsDtoConverter.convert(parameters));
  }
}
