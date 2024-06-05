package com.sinch.sdk.domains.verification.adapters.converters;

import com.sinch.sdk.core.utils.DateUtil;
import com.sinch.sdk.domains.verification.models.VerificationId;
import com.sinch.sdk.domains.verification.models.VerificationReference;
import com.sinch.sdk.domains.verification.models.VerificationSourceType;
import com.sinch.sdk.domains.verification.models.VerificationStatus;
import com.sinch.sdk.domains.verification.models.VerificationStatusCallout;
import com.sinch.sdk.domains.verification.models.VerificationStatusFlashCall;
import com.sinch.sdk.domains.verification.models.VerificationStatusReasonType;
import com.sinch.sdk.domains.verification.models.VerificationStatusSMS;
import com.sinch.sdk.domains.verification.models.VerificationStatusType;
import com.sinch.sdk.domains.verification.models.v1.status.StatusPriceImpl;
import com.sinch.sdk.domains.verification.models.v1.status.response.FlashCallVerificationStatusResponseImpl;
import com.sinch.sdk.domains.verification.models.v1.status.response.PhoneCallVerificationStatusResponseImpl;
import com.sinch.sdk.domains.verification.models.v1.status.response.SmsVerificationStatusResponseImpl;
import com.sinch.sdk.domains.verification.models.v1.status.response.SmsVerificationStatusResponsePriceImpl;
import com.sinch.sdk.domains.verification.models.v1.status.response.internal.VerificationStatusResponseInternal;
import com.sinch.sdk.domains.verification.models.v1.status.response.internal.VerificationStatusResponseInternalImpl;
import java.util.logging.Logger;

public class StatusDtoConverter {

  private static final Logger LOGGER = Logger.getLogger(VerificationsDtoConverter.class.getName());

  public static VerificationStatus convert(VerificationStatusResponseInternal _dto) {

    VerificationStatusResponseInternalImpl dto = (VerificationStatusResponseInternalImpl) _dto;

    VerificationStatus.Builder<?> builder;

    if (dto.getActualInstance()
        instanceof
        com.sinch.sdk.domains.verification.models.v1.status.response
            .SmsVerificationStatusResponse) {
      builder = convert(dto.getSmsVerificationStatusResponseImpl());
    } else if (dto.getActualInstance()
        instanceof
        com.sinch.sdk.domains.verification.models.v1.status.response
            .FlashCallVerificationStatusResponse) {
      builder = convert(dto.getFlashCallVerificationStatusResponseImpl());
    } else if (dto.getActualInstance()
        instanceof
        com.sinch.sdk.domains.verification.models.v1.status.response
            .PhoneCallVerificationStatusResponse) {
      builder = convert(dto.getPhoneCallVerificationStatusResponseImpl());
    } else {
      LOGGER.severe(String.format("Unexpected class '%s'", dto.getActualInstance()));
      builder = VerificationStatus.builder();
    }
    return builder.build();
  }

  static VerificationStatusFlashCall.Builder convert(FlashCallVerificationStatusResponseImpl dto) {

    VerificationStatusFlashCall.Builder builder = VerificationStatusFlashCall.builder();

    dto.id().ifPresent(f -> builder.setId(VerificationId.valueOf(f)));
    dto.status().ifPresent(f -> builder.setStatus(VerificationStatusType.from(f.value())));
    dto.reason().ifPresent(f -> builder.setReason(VerificationStatusReasonType.from(f.value())));
    dto.reference().ifPresent(f -> builder.setReference(VerificationReference.valueOf(f)));
    dto.identity().ifPresent(f -> builder.setIdentity(IdentityDtoConverter.convert(f)));
    dto.countryId().ifPresent(f -> builder.setCountryId(dto.getCountryId()));

    dto.verificationTimestamp()
        .ifPresent(f -> builder.setVerificationTimeStamp(DateUtil.failSafeTimeStampToInstant(f)));
    dto.source().ifPresent(f -> builder.setSource(VerificationSourceType.from(f.value())));

    dto.price()
        .ifPresent(
            f -> {
              StatusPriceImpl price = (StatusPriceImpl) f;
              price
                  .verificationPrice()
                  .ifPresent(p -> builder.setVerificationPrice(PriceDtoConverter.convert(p)));
              price
                  .terminationPrice()
                  .ifPresent(p -> builder.setTerminationPrice(PriceDtoConverter.convert(p)));
              price.billableDuration().ifPresent(builder::setBillableDuration);
            });
    return builder;
  }

  static VerificationStatusSMS.Builder convert(SmsVerificationStatusResponseImpl dto) {

    VerificationStatusSMS.Builder builder = VerificationStatusSMS.builder();

    dto.id().ifPresent(f -> builder.setId(VerificationId.valueOf(f)));
    dto.status().ifPresent(f -> builder.setStatus(VerificationStatusType.from(f.value())));
    dto.reason().ifPresent(f -> builder.setReason(VerificationStatusReasonType.from(f.value())));
    dto.reference().ifPresent(f -> builder.setReference(VerificationReference.valueOf(f)));
    dto.identity().ifPresent(f -> builder.setIdentity(IdentityDtoConverter.convert(f)));
    dto.countryId().ifPresent(f -> builder.setCountryId(dto.getCountryId()));

    dto.verificationTimestamp()
        .ifPresent(f -> builder.setVerificationTimeStamp(DateUtil.failSafeTimeStampToInstant(f)));
    dto.source().ifPresent(f -> builder.setSource(VerificationSourceType.from(f.value())));

    dto.price()
        .ifPresent(
            f -> {
              SmsVerificationStatusResponsePriceImpl price =
                  (SmsVerificationStatusResponsePriceImpl) f;
              price
                  .verificationPrice()
                  .ifPresent(p -> builder.setVerificationPrice(PriceDtoConverter.convert(p)));
            });
    return builder;
  }

  static VerificationStatusCallout.Builder convert(PhoneCallVerificationStatusResponseImpl dto) {

    VerificationStatusCallout.Builder builder = VerificationStatusCallout.builder();

    dto.id().ifPresent(f -> builder.setId(VerificationId.valueOf(f)));
    dto.status().ifPresent(f -> builder.setStatus(VerificationStatusType.from(f.value())));
    dto.reason().ifPresent(f -> builder.setReason(VerificationStatusReasonType.from(f.value())));
    dto.reference().ifPresent(f -> builder.setReference(VerificationReference.valueOf(f)));
    dto.identity().ifPresent(f -> builder.setIdentity(IdentityDtoConverter.convert(f)));
    dto.countryId().ifPresent(f -> builder.setCountryId(dto.getCountryId()));

    dto.verificationTimestamp()
        .ifPresent(f -> builder.setVerificationTimeStamp(DateUtil.failSafeTimeStampToInstant(f)));
    dto.callComplete().ifPresent(builder::setCallComplete);

    dto.price()
        .ifPresent(
            f -> {
              StatusPriceImpl price = (StatusPriceImpl) f;
              price
                  .verificationPrice()
                  .ifPresent(p -> builder.setVerificationPrice(PriceDtoConverter.convert(p)));
              price
                  .terminationPrice()
                  .ifPresent(p -> builder.setTerminationPrice(PriceDtoConverter.convert(p)));
              price.billableDuration().ifPresent(builder::setBillableDuration);
            });
    return builder;
  }
}
