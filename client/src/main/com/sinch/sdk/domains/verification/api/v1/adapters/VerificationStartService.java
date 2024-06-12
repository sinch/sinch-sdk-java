package com.sinch.sdk.domains.verification.api.v1.adapters;

import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.domains.verification.api.v1.internal.VerificationsStartApi;
import com.sinch.sdk.domains.verification.models.v1.start.request.StartVerificationDataRequest;
import com.sinch.sdk.domains.verification.models.v1.start.request.StartVerificationFlashCallRequest;
import com.sinch.sdk.domains.verification.models.v1.start.request.StartVerificationPhoneCallRequest;
import com.sinch.sdk.domains.verification.models.v1.start.request.StartVerificationRequest;
import com.sinch.sdk.domains.verification.models.v1.start.request.StartVerificationSmsRequest;
import com.sinch.sdk.domains.verification.models.v1.start.request.internal.StartVerificationRequestInternalImpl;
import com.sinch.sdk.domains.verification.models.v1.start.response.StartVerificationResponse;
import com.sinch.sdk.domains.verification.models.v1.start.response.StartVerificationResponseData;
import com.sinch.sdk.domains.verification.models.v1.start.response.StartVerificationResponseFlashCall;
import com.sinch.sdk.domains.verification.models.v1.start.response.StartVerificationResponsePhoneCall;
import com.sinch.sdk.domains.verification.models.v1.start.response.StartVerificationResponseSms;
import com.sinch.sdk.domains.verification.models.v1.start.response.internal.StartVerificationResponseInternalImpl;
import com.sinch.sdk.models.VerificationContext;
import java.util.Map;
import java.util.Optional;

public class VerificationStartService
    implements com.sinch.sdk.domains.verification.api.v1.VerificationStartService {

  private final VerificationsStartApi api;

  public VerificationStartService(
      VerificationContext context, HttpClient httpClient, Map<String, AuthManager> authManagers) {
    this.api =
        new VerificationsStartApi(
            httpClient, context.getVerificationServer(), authManagers, new HttpMapper());
  }

  protected VerificationsStartApi getApi() {
    return this.api;
  }

  public StartVerificationResponseSms startSms(StartVerificationSmsRequest parameters) {
    String acceptLanguage = parameters.getAcceptLanguage();
    return (StartVerificationResponseSms) start(parameters, acceptLanguage).orElse(null);
  }

  public StartVerificationResponseFlashCall startFlashCall(
      StartVerificationFlashCallRequest parameters) {
    return (StartVerificationResponseFlashCall) start(parameters).orElse(null);
  }

  public StartVerificationResponsePhoneCall startPhoneCall(
      StartVerificationPhoneCallRequest parameters) {
    return (StartVerificationResponsePhoneCall) start(parameters).orElse(null);
  }

  public StartVerificationResponseData startData(StartVerificationDataRequest parameters) {
    return (StartVerificationResponseData) start(parameters).orElse(null);
  }

  private Optional<StartVerificationResponse> start(StartVerificationRequest parameters) {
    return start(parameters, null);
  }

  private Optional<StartVerificationResponse> start(
      StartVerificationRequest parameters, String acceptLanguage) {
    StartVerificationRequestInternalImpl impl = new StartVerificationRequestInternalImpl();
    impl.setActualInstance(parameters);
    StartVerificationResponseInternalImpl response =
        (StartVerificationResponseInternalImpl) getApi().startVerification(impl, acceptLanguage);
    if (null == response) {
      return Optional.empty();
    }
    return Optional.ofNullable((StartVerificationResponse) response.getActualInstance());
  }
}
