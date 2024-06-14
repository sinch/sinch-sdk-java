package com.sinch.sdk.domains.verification.api.v1;

import com.sinch.sdk.domains.verification.api.v1.adapters.VerificationStatusService;

public interface VerificationService {

  VerificationStartService verificationStart();

  VerificationReportService verificationReport();

  VerificationStatusService verificationStatus();
}
