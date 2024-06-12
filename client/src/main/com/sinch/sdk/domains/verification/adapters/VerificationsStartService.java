package com.sinch.sdk.domains.verification.adapters;

import com.sinch.sdk.domains.verification.adapters.converters.VerificationsDtoConverter;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationCalloutRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationFlashCallRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationSMSRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationSeamlessRequestParameters;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseCallout;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseFlashCall;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseSMS;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseSeamless;
import com.sinch.sdk.domains.verification.models.v1.start.request.StartVerificationDataRequest;
import com.sinch.sdk.domains.verification.models.v1.start.request.StartVerificationFlashCallRequest;
import com.sinch.sdk.domains.verification.models.v1.start.request.StartVerificationPhoneCallRequest;
import com.sinch.sdk.domains.verification.models.v1.start.request.StartVerificationSmsRequest;
import com.sinch.sdk.domains.verification.models.v1.start.response.StartVerificationResponseSms;

public class VerificationsStartService {

  private final com.sinch.sdk.domains.verification.api.v1.VerificationStartService v1;

  public VerificationsStartService(
      com.sinch.sdk.domains.verification.api.v1.VerificationStartService v1) {
    this.v1 = v1;
  }

  public StartVerificationResponseSMS startSms(StartVerificationSMSRequestParameters parameters) {

    StartVerificationResponseSms response =
        v1.startSms((StartVerificationSmsRequest) VerificationsDtoConverter.convert(parameters));
    return (StartVerificationResponseSMS) VerificationsDtoConverter.convert(response);
  }

  public StartVerificationResponseFlashCall startFlashCall(
      StartVerificationFlashCallRequestParameters parameters) {

    com.sinch.sdk.domains.verification.models.v1.start.response.StartVerificationResponseFlashCall
        response =
            v1.startFlashCall(
                (StartVerificationFlashCallRequest) VerificationsDtoConverter.convert(parameters));
    return (StartVerificationResponseFlashCall) VerificationsDtoConverter.convert(response);
  }

  public StartVerificationResponseCallout startCallout(
      StartVerificationCalloutRequestParameters parameters) {

    com.sinch.sdk.domains.verification.models.v1.start.response.StartVerificationResponsePhoneCall
        response =
            v1.startPhoneCall(
                (StartVerificationPhoneCallRequest) VerificationsDtoConverter.convert(parameters));
    return (StartVerificationResponseCallout) VerificationsDtoConverter.convert(response);
  }

  public StartVerificationResponseSeamless startSeamless(
      StartVerificationSeamlessRequestParameters parameters) {

    com.sinch.sdk.domains.verification.models.v1.start.response.StartVerificationResponseData
        response =
            v1.startData(
                (StartVerificationDataRequest) VerificationsDtoConverter.convert(parameters));
    return (StartVerificationResponseSeamless) VerificationsDtoConverter.convert(response);
  }
}
