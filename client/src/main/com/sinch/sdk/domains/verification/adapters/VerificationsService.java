package com.sinch.sdk.domains.verification.adapters;

import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.domains.verification.adapters.api.v1.SendingAndReportingVerificationsApi;
import com.sinch.sdk.domains.verification.adapters.converters.VerificationsDtoConverter;
import com.sinch.sdk.domains.verification.models.NumberIdentity;
import com.sinch.sdk.domains.verification.models.VerificationId;
import com.sinch.sdk.domains.verification.models.VerificationReport;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportRequestParameters;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponse;
import com.sinch.sdk.models.Configuration;
import java.util.Map;

public class VerificationsService
    implements com.sinch.sdk.domains.verification.VerificationsService {

  private final SendingAndReportingVerificationsApi api;

  public VerificationsService(
      Configuration configuration, HttpClient httpClient, Map<String, AuthManager> authManagers) {
    this.api =
        new SendingAndReportingVerificationsApi(
            httpClient, configuration.getVerificationServer(), authManagers, new HttpMapper());
  }

  protected SendingAndReportingVerificationsApi getApi() {
    return this.api;
  }

  public StartVerificationResponse start(StartVerificationRequestParameters parameters) {
    return VerificationsDtoConverter.convert(
        getApi().startVerification(VerificationsDtoConverter.convert(parameters)));
  }

  public VerificationReport report(
      NumberIdentity identity, VerificationReportRequestParameters parameters) {

    return VerificationsDtoConverter.convert(
        getApi()
            .reportVerificationByIdentity(
                "number", identity.getEndpoint(), VerificationsDtoConverter.convert(parameters)));
  }

  public VerificationReport report(
      VerificationId id, VerificationReportRequestParameters parameters) {

    return VerificationsDtoConverter.convert(
        getApi().reportVerificationById(id.getId(), VerificationsDtoConverter.convert(parameters)));
  }
}
