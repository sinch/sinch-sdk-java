package com.sinch.sdk.domains.verification.api.v1;

import com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequestData;
import com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequestFlashCall;
import com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequestPhoneCall;
import com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequestSms;
import com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponseData;
import com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponseFlashCall;
import com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponsePhoneCall;
import com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponseSms;

public interface VerificationStartService {

  VerificationStartResponseSms startSms(VerificationStartRequestSms parameters);

  VerificationStartResponseFlashCall startFlashCall(VerificationStartRequestFlashCall parameters);

  VerificationStartResponsePhoneCall startPhoneCall(VerificationStartRequestPhoneCall parameters);

  VerificationStartResponseData startData(VerificationStartRequestData parameters);
}
