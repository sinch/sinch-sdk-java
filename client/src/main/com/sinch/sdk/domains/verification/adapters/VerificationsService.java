package com.sinch.sdk.domains.verification.adapters;

import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.domains.verification.adapters.api.v1.VerificationsApi;
import com.sinch.sdk.domains.verification.adapters.converters.VerificationsDtoConverter;
import com.sinch.sdk.domains.verification.models.NumberIdentity;
import com.sinch.sdk.domains.verification.models.VerificationId;
import com.sinch.sdk.domains.verification.models.VerificationStatus;
import com.sinch.sdk.domains.verification.models.VerificationStatusCallout;
import com.sinch.sdk.domains.verification.models.VerificationStatusFlashCall;
import com.sinch.sdk.domains.verification.models.VerificationStatusSMS;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationCalloutRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationFlashCallRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationSMSRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationSeamlessRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportCalloutRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportFlashCallRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportSMSRequestParameters;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponse;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseCallout;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseFlashCall;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseSMS;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseSeamless;
import com.sinch.sdk.models.VerificationContext;
import java.util.Map;

public class VerificationsService
    implements com.sinch.sdk.domains.verification.VerificationsService {

  private final VerificationsApi api;

  public VerificationsService(
      VerificationContext context, HttpClient httpClient, Map<String, AuthManager> authManagers) {
    this.api =
        new VerificationsApi(
            httpClient, context.getVerificationServer(), authManagers, new HttpMapper());
  }

  protected VerificationsApi getApi() {
    return this.api;
  }

  public StartVerificationResponseSMS startSms(StartVerificationSMSRequestParameters parameters) {
    return (StartVerificationResponseSMS) start(parameters);
  }

  public StartVerificationResponseFlashCall startFlashCall(
      StartVerificationFlashCallRequestParameters parameters) {
    return (StartVerificationResponseFlashCall) start(parameters);
  }

  public StartVerificationResponseCallout startCallout(
      StartVerificationCalloutRequestParameters parameters) {
    return (StartVerificationResponseCallout) start(parameters);
  }

  public StartVerificationResponseSeamless startSeamless(
      StartVerificationSeamlessRequestParameters parameters) {
    return (StartVerificationResponseSeamless) start(parameters);
  }

  private StartVerificationResponse start(StartVerificationRequestParameters parameters) {
    return VerificationsDtoConverter.convert(
        getApi().startVerification(VerificationsDtoConverter.convert(parameters)));
  }

  public VerificationStatusSMS reportSmsByIdentity(
      NumberIdentity identity, VerificationReportSMSRequestParameters parameters) {
    return (VerificationStatusSMS) report(identity, parameters);
  }

  public VerificationStatusFlashCall reportFlashCallByIdentity(
      NumberIdentity identity, VerificationReportFlashCallRequestParameters parameters) {
    return (VerificationStatusFlashCall) report(identity, parameters);
  }

  public VerificationStatusCallout reportCalloutByIdentity(
      NumberIdentity identity, VerificationReportCalloutRequestParameters parameters) {
    return (VerificationStatusCallout) report(identity, parameters);
  }

  private VerificationStatus report(
      NumberIdentity identity, VerificationReportRequestParameters parameters) {

    return VerificationsDtoConverter.convert(
        getApi()
            .reportVerificationByIdentity(identity.getEndpoint(), VerificationsDtoConverter.convert(parameters)));
  }

  public VerificationStatusSMS reportSmsById(
      VerificationId id, VerificationReportSMSRequestParameters parameters) {
    return (VerificationStatusSMS) report(id, parameters);
  }

  public VerificationStatusFlashCall reportFlashCallById(
      VerificationId id, VerificationReportFlashCallRequestParameters parameters) {
    return (VerificationStatusFlashCall) report(id, parameters);
  }

  public VerificationStatusCallout reportCalloutById(
      VerificationId id, VerificationReportCalloutRequestParameters parameters) {
    return (VerificationStatusCallout) report(id, parameters);
  }

  private VerificationStatus report(
      VerificationId id, VerificationReportRequestParameters parameters) {

    return VerificationsDtoConverter.convert(
        getApi().reportVerificationById(id.getId(), VerificationsDtoConverter.convert(parameters)));
  }
}
