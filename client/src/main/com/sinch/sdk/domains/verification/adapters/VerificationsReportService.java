package com.sinch.sdk.domains.verification.adapters;

import com.sinch.sdk.domains.verification.adapters.converters.VerificationsDtoConverter;
import com.sinch.sdk.domains.verification.models.NumberIdentity;
import com.sinch.sdk.domains.verification.models.VerificationId;
import com.sinch.sdk.domains.verification.models.VerificationReportCallout;
import com.sinch.sdk.domains.verification.models.VerificationReportFlashCall;
import com.sinch.sdk.domains.verification.models.VerificationReportSMS;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportCalloutRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportFlashCallRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportSMSRequestParameters;
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponseFlashCall;
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponsePhoneCall;
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponseSms;

public class VerificationsReportService {

  private final com.sinch.sdk.domains.verification.api.v1.VerificationReportService v1;

  public VerificationsReportService(
      com.sinch.sdk.domains.verification.api.v1.VerificationReportService v1) {
    this.v1 = v1;
  }

  public VerificationReportSMS reportSmsByIdentity(
      NumberIdentity identity, VerificationReportSMSRequestParameters parameters) {

    VerificationReportResponseSms response =
        v1.reportSmsByIdentity(identity, VerificationsDtoConverter.convert(parameters));
    return (VerificationReportSMS) VerificationsDtoConverter.convert(response);
  }

  public VerificationReportFlashCall reportFlashCallByIdentity(
      NumberIdentity identity, VerificationReportFlashCallRequestParameters parameters) {
    VerificationReportResponseFlashCall response =
        v1.reportFlashCallByIdentity(identity, VerificationsDtoConverter.convert(parameters));
    return (VerificationReportFlashCall) VerificationsDtoConverter.convert(response);
  }

  public VerificationReportCallout reportCalloutByIdentity(
      NumberIdentity identity, VerificationReportCalloutRequestParameters parameters) {
    VerificationReportResponsePhoneCall response =
        v1.reportPhoneCallByIdentity(identity, VerificationsDtoConverter.convert(parameters));
    return (VerificationReportCallout) VerificationsDtoConverter.convert(response);
  }

  public VerificationReportSMS reportSmsById(
      VerificationId id, VerificationReportSMSRequestParameters parameters) {
    VerificationReportResponseSms response =
        v1.reportSmsById(id.getId(), VerificationsDtoConverter.convert(parameters));
    return (VerificationReportSMS) VerificationsDtoConverter.convert(response);
  }

  public VerificationReportFlashCall reportFlashCallById(
      VerificationId id, VerificationReportFlashCallRequestParameters parameters) {
    VerificationReportResponseFlashCall response =
        v1.reportFlashCallById(id.getId(), VerificationsDtoConverter.convert(parameters));
    return (VerificationReportFlashCall) VerificationsDtoConverter.convert(response);
  }

  public VerificationReportCallout reportCalloutById(
      VerificationId id, VerificationReportCalloutRequestParameters parameters) {
    VerificationReportResponsePhoneCall response =
        v1.reportPhoneCallById(id.getId(), VerificationsDtoConverter.convert(parameters));
    return (VerificationReportCallout) VerificationsDtoConverter.convert(response);
  }
}
