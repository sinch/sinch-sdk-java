package com.sinch.sdk.domains.verification.adapters;

import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.domains.verification.models.NumberIdentity;
import com.sinch.sdk.domains.verification.models.VerificationId;
import com.sinch.sdk.domains.verification.models.VerificationReportCallout;
import com.sinch.sdk.domains.verification.models.VerificationReportFlashCall;
import com.sinch.sdk.domains.verification.models.VerificationReportSMS;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationCalloutRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationFlashCallRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationSMSRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationSeamlessRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportCalloutRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportFlashCallRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportSMSRequestParameters;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseCallout;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseFlashCall;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseSMS;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseSeamless;
import com.sinch.sdk.models.VerificationContext;
import java.util.Map;

public class VerificationsService
    implements com.sinch.sdk.domains.verification.VerificationsService {

  private final VerificationsReportService reportService;
  private final VerificationsStartService startService;

  public VerificationsService(
      VerificationContext context, HttpClient httpClient, Map<String, AuthManager> authManagers) {
    this.reportService = new VerificationsReportService(context, httpClient, authManagers);
    this.startService = new VerificationsStartService(context, httpClient, authManagers);
  }

  public StartVerificationResponseSMS startSms(StartVerificationSMSRequestParameters parameters) {
    return startService.startSms(parameters);
  }

  public StartVerificationResponseFlashCall startFlashCall(
      StartVerificationFlashCallRequestParameters parameters) {
    return startService.startFlashCall(parameters);
  }

  public StartVerificationResponseCallout startCallout(
      StartVerificationCalloutRequestParameters parameters) {
    return startService.startCallout(parameters);
  }

  public StartVerificationResponseSeamless startSeamless(
      StartVerificationSeamlessRequestParameters parameters) {
    return startService.startSeamless(parameters);
  }

  public VerificationReportSMS reportSmsByIdentity(
      NumberIdentity identity, VerificationReportSMSRequestParameters parameters) {
    return reportService.reportSmsByIdentity(identity, parameters);
  }

  public VerificationReportFlashCall reportFlashCallByIdentity(
      NumberIdentity identity, VerificationReportFlashCallRequestParameters parameters) {
    return reportService.reportFlashCallByIdentity(identity, parameters);
  }

  public VerificationReportCallout reportCalloutByIdentity(
      NumberIdentity identity, VerificationReportCalloutRequestParameters parameters) {
    return reportService.reportCalloutByIdentity(identity, parameters);
  }

  public VerificationReportSMS reportSmsById(
      VerificationId id, VerificationReportSMSRequestParameters parameters) {
    return reportService.reportSmsById(id, parameters);
  }

  public VerificationReportFlashCall reportFlashCallById(
      VerificationId id, VerificationReportFlashCallRequestParameters parameters) {
    return reportService.reportFlashCallById(id, parameters);
  }

  public VerificationReportCallout reportCalloutById(
      VerificationId id, VerificationReportCalloutRequestParameters parameters) {
    return reportService.reportCalloutById(id, parameters);
  }
}
