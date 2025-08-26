package com.sinch.sdk.domains.verification.api.v1.adapters;

import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.domains.verification.api.v1.internal.VerificationsReportApi;
import com.sinch.sdk.domains.verification.models.v1.NumberIdentity;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequest;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestFlashCall;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestPhoneCall;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestSms;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestWhatsApp;
import com.sinch.sdk.domains.verification.models.v1.report.request.internal.VerificationReportRequestInternalImpl;
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponse;
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponseFlashCall;
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponsePhoneCall;
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponseSms;
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponseWhatsApp;
import com.sinch.sdk.domains.verification.models.v1.report.response.internal.VerificationReportResponseInternalImpl;
import com.sinch.sdk.models.VerificationContext;
import java.util.Map;

public class VerificationReportService
    implements com.sinch.sdk.domains.verification.api.v1.VerificationReportService {

  private final VerificationsReportApi api;

  public VerificationReportService(
      VerificationContext context, HttpClient httpClient, Map<String, AuthManager> authManagers) {
    this.api =
        new VerificationsReportApi(
            httpClient, context.getVerificationServer(), authManagers, HttpMapper.getInstance());
  }

  protected VerificationsReportApi getApi() {
    return this.api;
  }

  @Override
  public VerificationReportResponseSms reportSmsByIdentity(
      NumberIdentity identity, VerificationReportRequestSms parameters) {

    return (VerificationReportResponseSms) reportByIdentity(identity, parameters);
  }

  @Override
  public VerificationReportResponseFlashCall reportFlashCallByIdentity(
      NumberIdentity identity, VerificationReportRequestFlashCall parameters) {

    return (VerificationReportResponseFlashCall) reportByIdentity(identity, parameters);
  }

  @Override
  public VerificationReportResponsePhoneCall reportPhoneCallByIdentity(
      NumberIdentity identity, VerificationReportRequestPhoneCall parameters) {

    return (VerificationReportResponsePhoneCall) reportByIdentity(identity, parameters);
  }

  @Override
  public VerificationReportResponseWhatsApp reportWhatsAppByIdentity(
      NumberIdentity identity, VerificationReportRequestWhatsApp parameters) {

    return (VerificationReportResponseWhatsApp) reportByIdentity(identity, parameters);
  }

  @Override
  public VerificationReportResponseSms reportSmsById(
      String id, VerificationReportRequestSms parameters) {

    return (VerificationReportResponseSms) reportById(id, parameters);
  }

  @Override
  public VerificationReportResponseFlashCall reportFlashCallById(
      String id, VerificationReportRequestFlashCall parameters) {

    return (VerificationReportResponseFlashCall) reportById(id, parameters);
  }

  @Override
  public VerificationReportResponsePhoneCall reportPhoneCallById(
      String id, VerificationReportRequestPhoneCall parameters) {

    return (VerificationReportResponsePhoneCall) reportById(id, parameters);
  }

  @Override
  public VerificationReportResponseWhatsApp reportWhatsAppById(
      String id, VerificationReportRequestWhatsApp parameters) {

    return (VerificationReportResponseWhatsApp) reportById(id, parameters);
  }

  private VerificationReportResponse reportByIdentity(
      NumberIdentity identity, VerificationReportRequest parameters) {
    VerificationReportRequestInternalImpl internal = new VerificationReportRequestInternalImpl();
    internal.setActualInstance(parameters);
    VerificationReportResponseInternalImpl response =
        (VerificationReportResponseInternalImpl)
            getApi().reportVerificationByIdentity(identity.getEndpoint(), internal);
    return (VerificationReportResponse) response.getActualInstance();
  }

  private VerificationReportResponse reportById(String id, VerificationReportRequest parameters) {
    VerificationReportRequestInternalImpl internal = new VerificationReportRequestInternalImpl();
    internal.setActualInstance(parameters);
    VerificationReportResponseInternalImpl response =
        (VerificationReportResponseInternalImpl) getApi().reportVerificationById(id, internal);
    return (VerificationReportResponse) response.getActualInstance();
  }
}
