package com.sinch.sdk.domains.verification.adapters;

import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.domains.verification.adapters.api.v1.SendingAndReportingVerificationsApi;
import com.sinch.sdk.domains.verification.adapters.converters.VerificationsDtoConverter;
import com.sinch.sdk.domains.verification.models.NumberIdentity;
import com.sinch.sdk.domains.verification.models.VerificationId;
import com.sinch.sdk.domains.verification.models.VerificationReport;
import com.sinch.sdk.domains.verification.models.VerificationReportCallout;
import com.sinch.sdk.domains.verification.models.VerificationReportFlashCall;
import com.sinch.sdk.domains.verification.models.VerificationReportSMS;
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

  private final SendingAndReportingVerificationsApi api;

  public VerificationsService(
      VerificationContext context, HttpClient httpClient, Map<String, AuthManager> authManagers) {
    this.api =
        new SendingAndReportingVerificationsApi(
            httpClient, context.getVerificationServer(), authManagers, new HttpMapper());
  }

  protected SendingAndReportingVerificationsApi getApi() {
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

  public VerificationReportSMS reportSmsByIdentity(
      NumberIdentity identity, VerificationReportSMSRequestParameters parameters) {
    return (VerificationReportSMS) report(identity, parameters);
  }

  public VerificationReportFlashCall reportFlashCallByIdentity(
      NumberIdentity identity, VerificationReportFlashCallRequestParameters parameters) {
    return (VerificationReportFlashCall) report(identity, parameters);
  }

  public VerificationReportCallout reportCalloutByIdentity(
      NumberIdentity identity, VerificationReportCalloutRequestParameters parameters) {
    return (VerificationReportCallout) report(identity, parameters);
  }

  private VerificationReport report(
      NumberIdentity identity, VerificationReportRequestParameters parameters) {

    return VerificationsDtoConverter.convert(
        getApi()
            .reportVerificationByIdentity(
                "number", identity.getEndpoint(), VerificationsDtoConverter.convert(parameters)));
  }

  public VerificationReportSMS reportSmsById(
      VerificationId id, VerificationReportSMSRequestParameters parameters) {
    return (VerificationReportSMS) report(id, parameters);
  }

  public VerificationReportFlashCall reportFlashCallById(
      VerificationId id, VerificationReportFlashCallRequestParameters parameters) {
    return (VerificationReportFlashCall) report(id, parameters);
  }

  public VerificationReportCallout reportCalloutById(
      VerificationId id, VerificationReportCalloutRequestParameters parameters) {
    return (VerificationReportCallout) report(id, parameters);
  }

  private VerificationReport report(
      VerificationId id, VerificationReportRequestParameters parameters) {

    return VerificationsDtoConverter.convert(
        getApi().reportVerificationById(id.getId(), VerificationsDtoConverter.convert(parameters)));
  }
}
