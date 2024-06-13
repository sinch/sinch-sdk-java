package com.sinch.sdk.domains.verification.adapters.converters;

import com.sinch.sdk.domains.common.adapters.converters.EnumDynamicConverter;
import com.sinch.sdk.domains.verification.models.Identity;
import com.sinch.sdk.domains.verification.models.NumberIdentity;
import com.sinch.sdk.domains.verification.models.VerificationId;
import com.sinch.sdk.domains.verification.models.VerificationMethodType;
import com.sinch.sdk.domains.verification.models.VerificationReport;
import com.sinch.sdk.domains.verification.models.VerificationReportCallout;
import com.sinch.sdk.domains.verification.models.VerificationReportFlashCall;
import com.sinch.sdk.domains.verification.models.VerificationReportSMS;
import com.sinch.sdk.domains.verification.models.VerificationStatusType;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationCalloutOptions;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationCalloutRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationCalloutSpeechOptions;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationFlashCallRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationSMSOptions;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationSMSRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationSeamlessRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportCalloutRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportFlashCallRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportSMSRequestParameters;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponse;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseCallout;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseFlashCall;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseSMS;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseSeamless;
import com.sinch.sdk.domains.verification.models.v1.VerificationMethod;
import com.sinch.sdk.domains.verification.models.v1.internal.IdentityInternal;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestFlashCall;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestPhoneCall;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestSms;
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponse;
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponseFlashCall;
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponseFlashCallImpl;
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponsePhoneCall;
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponsePhoneCallImpl;
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponseSms;
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponseSmsImpl;
import com.sinch.sdk.domains.verification.models.v1.start.request.PhoneCallSpeech;
import com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequestSms;
import com.sinch.sdk.domains.verification.models.v1.start.response.internal.VerificationStartResponseDataContentImpl;
import com.sinch.sdk.domains.verification.models.v1.start.response.internal.VerificationStartResponseFlashCallContentImpl;
import com.sinch.sdk.domains.verification.models.v1.start.response.internal.VerificationStartResponseSmsContentImpl;
import java.util.logging.Logger;

public class VerificationsDtoConverter {

  private static final Logger LOGGER = Logger.getLogger(VerificationsDtoConverter.class.getName());

  public static com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequest
      convert(StartVerificationRequestParameters client) {

    com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequest.Builder dto;

    if (client instanceof StartVerificationFlashCallRequestParameters) {
      com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequestFlashCall
              .Builder
          flashCallBuilder =
              com.sinch.sdk.domains.verification.models.v1.start.request
                  .VerificationStartRequestFlashCall.builder();
      dto = flashCallBuilder;
      StartVerificationFlashCallRequestParameters options =
          (StartVerificationFlashCallRequestParameters) client;
      options.getDialTimeOut().ifPresent(flashCallBuilder::setDialTimeout);
    } else if (client instanceof StartVerificationSMSRequestParameters) {
      com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequestSms.Builder
          smsBuilder =
              com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequestSms
                  .builder();
      dto = smsBuilder;
      StartVerificationSMSRequestParameters options =
          (StartVerificationSMSRequestParameters) client;
      options.getOptions().ifPresent(f -> convert(smsBuilder, f));
    } else if (client instanceof StartVerificationCalloutRequestParameters) {
      com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequestPhoneCall
              .Builder
          phoneCallBuilder =
              com.sinch.sdk.domains.verification.models.v1.start.request
                  .VerificationStartRequestPhoneCall.builder();
      dto = phoneCallBuilder;
      StartVerificationCalloutRequestParameters options =
          (StartVerificationCalloutRequestParameters) client;
      options.getOptions().ifPresent(f -> convert(phoneCallBuilder, f));
    } else if (client instanceof StartVerificationSeamlessRequestParameters) {
      dto =
          com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequestData
              .builder();
    } else {
      LOGGER.severe(String.format("Unexpected class '%s'", client.getClass()));
      return null;
    }

    client.getIdentity().ifPresent(dto::setIdentity);
    client.getReference().ifPresent(f -> dto.setReference(f.getReference()));
    client.getCustom().ifPresent(dto::setCustom);

    return dto.build();
  }

  private static void convert(
      com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequestSms.Builder
          smsBuilder,
      StartVerificationSMSOptions client) {

    client.getExpiry().ifPresent(smsBuilder::setExpiry);
    client
        .getCodeType()
        .ifPresent(
            f -> smsBuilder.setCodeType(VerificationStartRequestSms.CodeTypeEnum.from(f.value())));
    client.getTemplate().ifPresent(smsBuilder::setTemplate);
    client.getAcceptLanguage().ifPresent(smsBuilder::setAcceptLanguage);
  }

  private static void convert(
      com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequestPhoneCall
              .Builder
          phoneCallBuilder,
      StartVerificationCalloutOptions client) {
    client.getSpeech().ifPresent(f -> phoneCallBuilder.setSpeech(convert(f)));
  }

  private static PhoneCallSpeech convert(StartVerificationCalloutSpeechOptions client) {
    PhoneCallSpeech.Builder dto = PhoneCallSpeech.builder();
    client.getLocale().ifPresent(dto::setLocale);
    return dto.build();
  }

  public static IdentityInternal convert(Identity client) {
    IdentityInternal.Builder dto = IdentityInternal.builder();
    if (client instanceof NumberIdentity) {
      dto.setType(IdentityInternal.TypeEnum.NUMBER)
          .setEndpoint(((NumberIdentity) client).getEndpoint());
    } else {
      LOGGER.severe(String.format("Unexpected class '%s'", client.getClass()));
    }
    return dto.build();
  }

  public static Identity convert(IdentityInternal dto) {
    Identity identity = null;
    if (IdentityInternal.TypeEnum.NUMBER.equals(dto.getType())) {
      identity = NumberIdentity.valueOf(dto.getEndpoint());
    } else {
      LOGGER.severe(String.format("Unexpected '%s'", dto));
    }
    return identity;
  }

  public static VerificationMethod convert(VerificationMethodType client) {
    return VerificationMethod.from(EnumDynamicConverter.convert(client));
  }

  public static StartVerificationResponse convert(
      com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponse dto) {

    StartVerificationResponse.Builder<?> builder;

    if (dto
        instanceof
        com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponseSms) {
      builder =
          convert(
              (com.sinch.sdk.domains.verification.models.v1.start.response
                      .VerificationStartResponseSms)
                  dto);
    } else if (dto
        instanceof
        com.sinch.sdk.domains.verification.models.v1.start.response
            .VerificationStartResponseFlashCall) {
      builder =
          convert(
              (com.sinch.sdk.domains.verification.models.v1.start.response
                      .VerificationStartResponseFlashCall)
                  dto);
    } else if (dto
        instanceof
        com.sinch.sdk.domains.verification.models.v1.start.response
            .VerificationStartResponsePhoneCall) {
      builder =
          convert(
              (com.sinch.sdk.domains.verification.models.v1.start.response
                      .VerificationStartResponsePhoneCall)
                  dto);
    } else if (dto
        instanceof
        com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponseData) {
      builder =
          convert(
              (com.sinch.sdk.domains.verification.models.v1.start.response
                      .VerificationStartResponseData)
                  dto);
    } else {
      LOGGER.severe(String.format("Unexpected class '%s'", dto));
      builder = StartVerificationResponse.builder();
    }
    return builder.build();
  }

  private static StartVerificationResponseSMS.Builder convert(
      com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponseSms
          _dto) {

    com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponseSmsImpl
        dto =
            (com.sinch.sdk.domains.verification.models.v1.start.response
                    .VerificationStartResponseSmsImpl)
                _dto;
    StartVerificationResponseSMS.Builder builder = StartVerificationResponseSMS.builder();

    dto.id().ifPresent(f -> builder.setId(VerificationId.valueOf(f)));
    dto.links().ifPresent(f -> builder.setLinks(LinkDtoConverter.convert(f)));

    dto.sms()
        .ifPresent(
            _sms -> {
              VerificationStartResponseSmsContentImpl sms =
                  (VerificationStartResponseSmsContentImpl) _sms;
              sms.template().ifPresent(builder::setTemplate);
              sms.interceptionTimeout().ifPresent(builder::setInterceptionTimeOut);
            });

    return builder;
  }

  private static StartVerificationResponseFlashCall.Builder convert(
      com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponseFlashCall
          _dto) {

    com.sinch.sdk.domains.verification.models.v1.start.response
            .VerificationStartResponseFlashCallImpl
        dto =
            (com.sinch.sdk.domains.verification.models.v1.start.response
                    .VerificationStartResponseFlashCallImpl)
                _dto;
    StartVerificationResponseFlashCall.Builder builder =
        StartVerificationResponseFlashCall.builder();

    dto.id().ifPresent(f -> builder.setId(VerificationId.valueOf(f)));
    dto.links().ifPresent(f -> builder.setLinks(LinkDtoConverter.convert(f)));

    dto.flashCall()
        .ifPresent(
            _flashCall -> {
              VerificationStartResponseFlashCallContentImpl flashCall =
                  (VerificationStartResponseFlashCallContentImpl) _flashCall;
              flashCall.cliFilter().ifPresent(builder::setCliFilter);
              flashCall.interceptionTimeout().ifPresent(builder::setInterceptionTimeOut);
              flashCall.reportTimeout().ifPresent(builder::setReportTimeout);
              flashCall.denyCallAfter().ifPresent(builder::setDenyCallAfter);
            });
    return builder;
  }

  private static StartVerificationResponseCallout.Builder convert(
      com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponsePhoneCall
          _dto) {

    com.sinch.sdk.domains.verification.models.v1.start.response
            .VerificationStartResponsePhoneCallImpl
        dto =
            (com.sinch.sdk.domains.verification.models.v1.start.response
                    .VerificationStartResponsePhoneCallImpl)
                _dto;
    StartVerificationResponseCallout.Builder builder = StartVerificationResponseCallout.builder();

    dto.id().ifPresent(f -> builder.setId(VerificationId.valueOf(f)));
    dto.links().ifPresent(f -> builder.setLinks(LinkDtoConverter.convert(f)));

    return builder;
  }

  private static StartVerificationResponseSeamless.Builder convert(
      com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponseData
          _dto) {

    com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponseDataImpl
        dto =
            (com.sinch.sdk.domains.verification.models.v1.start.response
                    .VerificationStartResponseDataImpl)
                _dto;
    StartVerificationResponseSeamless.Builder builder = StartVerificationResponseSeamless.builder();

    dto.id().ifPresent(f -> builder.setId(VerificationId.valueOf(f)));
    dto.links().ifPresent(f -> builder.setLinks(LinkDtoConverter.convert(f)));

    dto.seamless()
        .ifPresent(
            _seamless -> {
              VerificationStartResponseDataContentImpl seamless =
                  (VerificationStartResponseDataContentImpl) _seamless;
              seamless.targetUri().ifPresent(builder::setTargetUri);
            });
    return builder;
  }

  public static VerificationReportRequestFlashCall convert(
      VerificationReportFlashCallRequestParameters client) {

    VerificationReportRequestFlashCall.Builder builder =
        VerificationReportRequestFlashCall.builder();

    client.getCli().ifPresent(builder::setCli);

    return builder.build();
  }

  public static VerificationReportRequestSms convert(
      VerificationReportSMSRequestParameters client) {

    VerificationReportRequestSms.Builder builder = VerificationReportRequestSms.builder();

    client.getCode().ifPresent(builder::setCode);
    client.getCli().ifPresent(builder::setCli);

    return builder.build();
  }

  public static VerificationReportRequestPhoneCall convert(
      VerificationReportCalloutRequestParameters client) {

    VerificationReportRequestPhoneCall.Builder builder =
        VerificationReportRequestPhoneCall.builder();

    client.getCode().ifPresent(builder::setCode);

    return builder.build();
  }

  public static VerificationReport convert(VerificationReportResponse _dto) {

    VerificationReport.Builder<?> builder;
    if (_dto instanceof VerificationReportResponseSms) {
      builder = VerificationReportSMS.builder();
      VerificationReportResponseSmsImpl dto = (VerificationReportResponseSmsImpl) _dto;
      dto.id().ifPresent(f -> builder.setId(VerificationId.valueOf(f)));
      dto.status()
          .ifPresent(f -> builder.setStatus(VerificationStatusType.from(dto.getStatus().value())));
    } else if (_dto instanceof VerificationReportResponseFlashCall) {
      builder = VerificationReportFlashCall.builder();
      VerificationReportResponseFlashCallImpl dto = (VerificationReportResponseFlashCallImpl) _dto;
      dto.id().ifPresent(f -> builder.setId(VerificationId.valueOf(f)));
      dto.status()
          .ifPresent(f -> builder.setStatus(VerificationStatusType.from(dto.getStatus().value())));
    } else if (_dto instanceof VerificationReportResponsePhoneCall) {
      builder = VerificationReportCallout.builder();
      VerificationReportResponsePhoneCallImpl dto = (VerificationReportResponsePhoneCallImpl) _dto;
      dto.id().ifPresent(f -> builder.setId(VerificationId.valueOf(f)));
      dto.status()
          .ifPresent(f -> builder.setStatus(VerificationStatusType.from(dto.getStatus().value())));
    } else {
      LOGGER.severe(String.format("Unexpected value '%s'", _dto));
      return VerificationReport.builder().build();
    }

    return builder.build();
  }
}
