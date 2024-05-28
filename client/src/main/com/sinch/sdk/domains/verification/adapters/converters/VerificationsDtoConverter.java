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
import com.sinch.sdk.domains.verification.models.requests.VerificationReportCalloutRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportFlashCallRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportSMSRequestParameters;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponse;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseCallout;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseFlashCall;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseSMS;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseSeamless;
import com.sinch.sdk.domains.verification.models.v1.VerificationMethod;
import com.sinch.sdk.domains.verification.models.v1.internal.IdentityInternal;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestParametersCallout;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestParametersCalloutOptions;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestParametersFlashCall;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestParametersFlashCallOptions;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestParametersSMS;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestParametersSMSOptions;
import com.sinch.sdk.domains.verification.models.v1.report.request.internal.VerificationReportRequestParametersInternal;
import com.sinch.sdk.domains.verification.models.v1.report.request.internal.VerificationReportRequestParametersInternalImpl;
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponse;
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponseImpl;
import com.sinch.sdk.domains.verification.models.v1.start.request.StartVerificationCalloutOptionsSpeech;
import com.sinch.sdk.domains.verification.models.v1.start.request.StartVerificationFlashCallOptions;
import com.sinch.sdk.domains.verification.models.v1.start.request.StartVerificationSMSOptions.CodeTypeEnum;
import com.sinch.sdk.domains.verification.models.v1.start.response.StartVerificationResponseFlashCallContentImpl;
import com.sinch.sdk.domains.verification.models.v1.start.response.StartVerificationResponseSMSContentImpl;
import com.sinch.sdk.domains.verification.models.v1.start.response.StartVerificationResponseSeamlessContentImpl;
import java.util.logging.Logger;

public class VerificationsDtoConverter {

  private static final Logger LOGGER = Logger.getLogger(VerificationsDtoConverter.class.getName());

  public static com.sinch.sdk.domains.verification.models.v1.start.request
          .StartVerificationRequestParameters
      convert(StartVerificationRequestParameters client) {
    com.sinch.sdk.domains.verification.models.v1.start.request.StartVerificationRequestParameters
            .Builder
        dto =
            com.sinch.sdk.domains.verification.models.v1.start.request
                .StartVerificationRequestParameters.builder();

    dto.setMethod(convert(client.getMethod()));
    client.getIdentity().ifPresent(f -> dto.setIdentity(convert(f)));
    client.getReference().ifPresent(f -> dto.setReference(f.getReference()));
    client.getCustom().ifPresent(dto::setCustom);

    if (client instanceof StartVerificationFlashCallRequestParameters) {
      StartVerificationFlashCallRequestParameters options =
          (StartVerificationFlashCallRequestParameters) client;
      options
          .getDialTimeOut()
          .ifPresent(
              f ->
                  dto.setFlashCallOptions(
                      StartVerificationFlashCallOptions.builder().setDialTimeout(f).build()));
    } else if (client instanceof StartVerificationSMSRequestParameters) {
      StartVerificationSMSRequestParameters options =
          (StartVerificationSMSRequestParameters) client;
      options.getOptions().ifPresent(f -> dto.setSmsOptions(convert(f)));
    } else if (client instanceof StartVerificationCalloutRequestParameters) {
      StartVerificationCalloutRequestParameters options =
          (StartVerificationCalloutRequestParameters) client;
      options.getOptions().ifPresent(f -> dto.setCalloutOptions(convert(f)));
    } else {
      LOGGER.severe(String.format("Unexpected class '%s'", client.getClass()));
    }
    return dto.build();
  }

  static com.sinch.sdk.domains.verification.models.v1.start.request.StartVerificationSMSOptions
      convert(StartVerificationSMSOptions client) {
    com.sinch.sdk.domains.verification.models.v1.start.request.StartVerificationSMSOptions.Builder
        dto =
            com.sinch.sdk.domains.verification.models.v1.start.request.StartVerificationSMSOptions
                .builder();
    client.getExpiry().ifPresent(dto::setExpiry);
    client.getCodeType().ifPresent(f -> dto.setCodeType(CodeTypeEnum.from(f.value())));
    client.getTemplate().ifPresent(dto::setTemplate);
    return dto.build();
  }

  static com.sinch.sdk.domains.verification.models.v1.start.request.StartVerificationCalloutOptions
      convert(StartVerificationCalloutOptions client) {
    com.sinch.sdk.domains.verification.models.v1.start.request.StartVerificationCalloutOptions
            .Builder
        dto =
            com.sinch.sdk.domains.verification.models.v1.start.request
                .StartVerificationCalloutOptions.builder();
    client.getSpeech().ifPresent(f -> dto.setSpeech(convert(f)));
    return dto.build();
  }

  static StartVerificationCalloutOptionsSpeech convert(
      StartVerificationCalloutSpeechOptions client) {
    StartVerificationCalloutOptionsSpeech.Builder dto =
        StartVerificationCalloutOptionsSpeech.builder();
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
      com.sinch.sdk.domains.verification.models.v1.start.response.internal
              .StartVerificationResponseInternal
          _dto) {

    com.sinch.sdk.domains.verification.models.v1.start.response.internal
            .StartVerificationResponseInternalImpl
        dto =
            (com.sinch.sdk.domains.verification.models.v1.start.response.internal
                    .StartVerificationResponseInternalImpl)
                _dto;
    StartVerificationResponse.Builder<?> builder;

    if (dto.getActualInstance()
        instanceof
        com.sinch.sdk.domains.verification.models.v1.start.response.StartVerificationResponseSMS) {
      builder = convert(dto.getStartVerificationResponseSMSImpl());
    } else if (dto.getActualInstance()
        instanceof
        com.sinch.sdk.domains.verification.models.v1.start.response
            .StartVerificationResponseFlashCall) {
      builder = convert(dto.getStartVerificationResponseFlashCallImpl());
    } else if (dto.getActualInstance()
        instanceof
        com.sinch.sdk.domains.verification.models.v1.start.response
            .StartVerificationResponseCallout) {
      builder = convert(dto.getStartVerificationResponseCalloutImpl());
    } else if (dto.getActualInstance()
        instanceof
        com.sinch.sdk.domains.verification.models.v1.start.response
            .StartVerificationResponseSeamless) {
      builder = convert(dto.getStartVerificationResponseSeamlessImpl());
    } else {
      LOGGER.severe(String.format("Unexpected class '%s'", dto.getActualInstance()));
      builder = StartVerificationResponse.builder();
    }
    return builder.build();
  }

  static StartVerificationResponseSMS.Builder convert(
      com.sinch.sdk.domains.verification.models.v1.start.response.StartVerificationResponseSMSImpl
          dto) {
    StartVerificationResponseSMS.Builder builder = StartVerificationResponseSMS.builder();

    dto.id().ifPresent(f -> builder.setId(VerificationId.valueOf(f)));
    dto.links().ifPresent(f -> builder.setLinks(LinkDtoConverter.convert(f)));

    dto.sms()
        .ifPresent(
            _sms -> {
              StartVerificationResponseSMSContentImpl sms =
                  (StartVerificationResponseSMSContentImpl) _sms;
              sms.template().ifPresent(builder::setTemplate);
              sms.interceptionTimeout()
                  .ifPresent(f -> builder.setInterceptionTimeOut(Integer.valueOf(f)));
            });

    return builder;
  }

  static StartVerificationResponseFlashCall.Builder convert(
      com.sinch.sdk.domains.verification.models.v1.start.response
              .StartVerificationResponseFlashCallImpl
          dto) {

    StartVerificationResponseFlashCall.Builder builder =
        StartVerificationResponseFlashCall.builder();

    dto.id().ifPresent(f -> builder.setId(VerificationId.valueOf(f)));
    dto.links().ifPresent(f -> builder.setLinks(LinkDtoConverter.convert(f)));

    dto.flashCall()
        .ifPresent(
            _flashCall -> {
              StartVerificationResponseFlashCallContentImpl flashCall =
                  (StartVerificationResponseFlashCallContentImpl) _flashCall;
              flashCall.cliFilter().ifPresent(builder::setCliFilter);
              flashCall.interceptionTimeout().ifPresent(builder::setInterceptionTimeOut);
              flashCall.reportTimeout().ifPresent(builder::setReportTimeout);
              flashCall.denyCallAfter().ifPresent(builder::setDenyCallAfter);
            });
    return builder;
  }

  static StartVerificationResponseCallout.Builder convert(
      com.sinch.sdk.domains.verification.models.v1.start.response
              .StartVerificationResponseCalloutImpl
          dto) {

    StartVerificationResponseCallout.Builder builder = StartVerificationResponseCallout.builder();

    dto.id().ifPresent(f -> builder.setId(VerificationId.valueOf(f)));
    dto.links().ifPresent(f -> builder.setLinks(LinkDtoConverter.convert(f)));

    return builder;
  }

  static StartVerificationResponseSeamless.Builder convert(
      com.sinch.sdk.domains.verification.models.v1.start.response
              .StartVerificationResponseSeamlessImpl
          dto) {

    StartVerificationResponseSeamless.Builder builder = StartVerificationResponseSeamless.builder();

    dto.id().ifPresent(f -> builder.setId(VerificationId.valueOf(f)));
    dto.links().ifPresent(f -> builder.setLinks(LinkDtoConverter.convert(f)));

    dto.seamless()
        .ifPresent(
            _seamless -> {
              StartVerificationResponseSeamlessContentImpl seamless =
                  (StartVerificationResponseSeamlessContentImpl) _seamless;
              seamless.targetUri().ifPresent(builder::setTargetUri);
            });
    return builder;
  }

  public static VerificationReportRequestParametersInternal convert(
      VerificationReportRequestParameters client) {

    VerificationReportRequestParametersInternalImpl dto =
        new VerificationReportRequestParametersInternalImpl();

    if (client instanceof VerificationReportFlashCallRequestParameters) {
      VerificationReportFlashCallRequestParameters typedClient =
          (VerificationReportFlashCallRequestParameters) client;
      dto.setActualInstance(convert(typedClient));
    } else if (client instanceof VerificationReportSMSRequestParameters) {
      VerificationReportSMSRequestParameters typedClient =
          (VerificationReportSMSRequestParameters) client;
      dto.setActualInstance(convert(typedClient));
    } else if (client instanceof VerificationReportCalloutRequestParameters) {
      VerificationReportCalloutRequestParameters typedClient =
          (VerificationReportCalloutRequestParameters) client;
      dto.setActualInstance(convert(typedClient));
    }
    return dto;
  }

  private static VerificationReportRequestParametersFlashCall convert(
      VerificationReportFlashCallRequestParameters client) {

    VerificationReportRequestParametersFlashCallOptions.Builder subfield =
        VerificationReportRequestParametersFlashCallOptions.builder();
    client.getCli().ifPresent(subfield::setCli);

    return VerificationReportRequestParametersFlashCall.builder()
        .setMethod(VerificationReportRequestParametersFlashCall.MethodEnum.FLASHCALL)
        .setFlashCall(subfield.build())
        .build();
  }

  private static VerificationReportRequestParametersSMS convert(
      VerificationReportSMSRequestParameters client) {

    VerificationReportRequestParametersSMSOptions.Builder subfield =
        VerificationReportRequestParametersSMSOptions.builder();
    client.getCode().ifPresent(subfield::setCode);
    client.getCli().ifPresent(subfield::setCli);

    return VerificationReportRequestParametersSMS.builder()
        .setMethod(VerificationReportRequestParametersSMS.MethodEnum.SMS)
        .setSms(subfield.build())
        .build();
  }

  private static VerificationReportRequestParametersCallout convert(
      VerificationReportCalloutRequestParameters client) {

    VerificationReportRequestParametersCalloutOptions.Builder subfield =
        VerificationReportRequestParametersCalloutOptions.builder();
    client.getCode().ifPresent(subfield::setCode);

    return VerificationReportRequestParametersCallout.builder()
        .setMethod(VerificationReportRequestParametersCallout.MethodEnum.CALLOUT)
        .setCallout(subfield.build())
        .build();
  }

  public static VerificationReport convert(VerificationReportResponse _dto) {
    VerificationReportResponseImpl dto = (VerificationReportResponseImpl) _dto;
    VerificationReport.Builder<?> builder;
    VerificationMethod method = dto.getMethod();
    if (method.equals(VerificationMethod.SMS)) {
      builder = VerificationReportSMS.builder();
    } else if (method.equals(VerificationMethod.FLASHCALL)) {
      builder = VerificationReportFlashCall.builder();
    } else if (method.equals(VerificationMethod.CALLOUT)) {
      builder = VerificationReportCallout.builder();
    } else {
      LOGGER.severe(String.format("Unexpected value '%s'", dto.getMethod()));
      return VerificationReport.builder().build();
    }

    dto.id().ifPresent(f -> builder.setId(VerificationId.valueOf(f)));
    dto.status()
        .ifPresent(f -> builder.setStatus(VerificationStatusType.from(dto.getStatus().value())));

    return builder.build();
  }
}
