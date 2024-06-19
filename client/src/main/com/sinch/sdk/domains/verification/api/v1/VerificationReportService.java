package com.sinch.sdk.domains.verification.api.v1;

import com.sinch.sdk.domains.verification.models.v1.NumberIdentity;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestFlashCall;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestPhoneCall;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestSms;
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponseFlashCall;
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponsePhoneCall;
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponseSms;

public interface VerificationReportService {

  VerificationReportResponseSms reportSmsByIdentity(
      NumberIdentity identity, VerificationReportRequestSms parameters);

  VerificationReportResponseFlashCall reportFlashCallByIdentity(
      NumberIdentity identity, VerificationReportRequestFlashCall parameters);

  VerificationReportResponsePhoneCall reportPhoneCallByIdentity(
      NumberIdentity identity, VerificationReportRequestPhoneCall parameters);

  VerificationReportResponseSms reportSmsById(String id, VerificationReportRequestSms parameters);

  VerificationReportResponseFlashCall reportFlashCallById(
      String id, VerificationReportRequestFlashCall parameters);

  VerificationReportResponsePhoneCall reportPhoneCallById(
      String id, VerificationReportRequestPhoneCall parameters);
}
