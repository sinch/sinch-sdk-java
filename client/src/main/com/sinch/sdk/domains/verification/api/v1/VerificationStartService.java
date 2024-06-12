package com.sinch.sdk.domains.verification.api.v1;

import com.sinch.sdk.domains.verification.models.v1.start.request.StartVerificationDataRequest;
import com.sinch.sdk.domains.verification.models.v1.start.request.StartVerificationFlashCallRequest;
import com.sinch.sdk.domains.verification.models.v1.start.request.StartVerificationPhoneCallRequest;
import com.sinch.sdk.domains.verification.models.v1.start.request.StartVerificationSmsRequest;
import com.sinch.sdk.domains.verification.models.v1.start.response.StartVerificationResponseData;
import com.sinch.sdk.domains.verification.models.v1.start.response.StartVerificationResponseFlashCall;
import com.sinch.sdk.domains.verification.models.v1.start.response.StartVerificationResponsePhoneCall;
import com.sinch.sdk.domains.verification.models.v1.start.response.StartVerificationResponseSms;

public interface VerificationStartService {

  StartVerificationResponseSms startSms(StartVerificationSmsRequest parameters);

  StartVerificationResponseFlashCall startFlashCall(StartVerificationFlashCallRequest parameters);

  StartVerificationResponsePhoneCall startPhoneCall(StartVerificationPhoneCallRequest parameters);

  StartVerificationResponseData startData(StartVerificationDataRequest parameters);
}
