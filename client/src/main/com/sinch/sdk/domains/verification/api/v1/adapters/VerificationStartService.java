package com.sinch.sdk.domains.verification.api.v1.adapters;

import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.domains.verification.api.v1.internal.VerificationsStartApi;
import com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequest;
import com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequestData;
import com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequestFlashCall;
import com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequestPhoneCall;
import com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequestSms;
import com.sinch.sdk.domains.verification.models.v1.start.request.internal.VerificationStartRequestInternalImpl;
import com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponse;
import com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponseData;
import com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponseFlashCall;
import com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponsePhoneCall;
import com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponseSms;
import com.sinch.sdk.domains.verification.models.v1.start.response.internal.VerificationStartResponseInternalImpl;
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

  public VerificationStartResponseSms startSms(VerificationStartRequestSms parameters) {
    String acceptLanguage = parameters.getAcceptLanguage();
    return (VerificationStartResponseSms) start(parameters, acceptLanguage).orElse(null);
  }

  public VerificationStartResponseFlashCall startFlashCall(
      VerificationStartRequestFlashCall parameters) {
    return (VerificationStartResponseFlashCall) start(parameters).orElse(null);
  }

  public VerificationStartResponsePhoneCall startPhoneCall(
      VerificationStartRequestPhoneCall parameters) {
    return (VerificationStartResponsePhoneCall) start(parameters).orElse(null);
  }

  public VerificationStartResponseData startData(VerificationStartRequestData parameters) {
    return (VerificationStartResponseData) start(parameters).orElse(null);
  }

  private Optional<VerificationStartResponse> start(VerificationStartRequest parameters) {
    return start(parameters, null);
  }

  private Optional<VerificationStartResponse> start(
      VerificationStartRequest parameters, String acceptLanguage) {
    VerificationStartRequestInternalImpl impl = new VerificationStartRequestInternalImpl();
    impl.setActualInstance(parameters);
    VerificationStartResponseInternalImpl response =
        (VerificationStartResponseInternalImpl) getApi().startVerification(impl, acceptLanguage);
    if (null == response) {
      return Optional.empty();
    }
    return Optional.ofNullable((VerificationStartResponse) response.getActualInstance());
  }
}
