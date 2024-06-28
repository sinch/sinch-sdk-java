package com.sinch.sdk.domains.verification.adapters.converters;

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
import com.sinch.sdk.domains.verification.models.v1.status.response.VerificationStatusResponse;
import com.sinch.sdk.domains.verification.models.v1.status.response.VerificationStatusResponseFlashCall;
import com.sinch.sdk.domains.verification.models.v1.status.response.VerificationStatusResponseFlashCallImpl;
import com.sinch.sdk.domains.verification.models.v1.status.response.VerificationStatusResponsePhoneCall;
import com.sinch.sdk.domains.verification.models.v1.status.response.VerificationStatusResponsePhoneCallImpl;
import com.sinch.sdk.domains.verification.models.v1.status.response.VerificationStatusResponseSms;
import com.sinch.sdk.domains.verification.models.v1.status.response.VerificationStatusResponseSmsImpl;
import com.sinch.sdk.domains.verification.models.v1.status.response.VerificationStatusResponseSmsPriceImpl;
import java.util.logging.Logger;

public class StatusDtoConverter {

  private static final Logger LOGGER = Logger.getLogger(VerificationsDtoConverter.class.getName());

  public static VerificationStatus convert(VerificationStatusResponse dto) {

    VerificationStatus.Builder<?> builder;

    if (dto instanceof VerificationStatusResponseSms) {
      builder = convert((VerificationStatusResponseSmsImpl) dto);
    } else if (dto instanceof VerificationStatusResponseFlashCall) {
      builder = convert((VerificationStatusResponseFlashCallImpl) dto);
    } else if (dto instanceof VerificationStatusResponsePhoneCall) {
      builder = convert((VerificationStatusResponsePhoneCallImpl) dto);
    } else {
      LOGGER.severe(String.format("Unexpected class '%s'", dto));
      builder = VerificationStatus.builder();
    }
    return builder.build();
  }

  private static VerificationStatusFlashCall.Builder convert(
      VerificationStatusResponseFlashCallImpl dto) {

    VerificationStatusFlashCall.Builder builder = VerificationStatusFlashCall.builder();

    dto.id().ifPresent(f -> builder.setId(VerificationId.valueOf(f)));
    dto.status().ifPresent(f -> builder.setStatus(VerificationStatusType.from(f.value())));
    dto.reason().ifPresent(f -> builder.setReason(VerificationStatusReasonType.from(f.value())));
    dto.reference().ifPresent(f -> builder.setReference(VerificationReference.valueOf(f)));
    dto.identity().ifPresent(f -> builder.setIdentity(IdentityDtoConverter.convert(f)));
    dto.countryId().ifPresent(f -> builder.setCountryId(dto.getCountryId()));

    dto.verificationTimestamp().ifPresent(builder::setVerificationTimeStamp);
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

  private static VerificationStatusSMS.Builder convert(VerificationStatusResponseSmsImpl dto) {

    VerificationStatusSMS.Builder builder = VerificationStatusSMS.builder();

    dto.id().ifPresent(f -> builder.setId(VerificationId.valueOf(f)));
    dto.status().ifPresent(f -> builder.setStatus(VerificationStatusType.from(f.value())));
    dto.reason().ifPresent(f -> builder.setReason(VerificationStatusReasonType.from(f.value())));
    dto.reference().ifPresent(f -> builder.setReference(VerificationReference.valueOf(f)));
    dto.identity().ifPresent(f -> builder.setIdentity(IdentityDtoConverter.convert(f)));
    dto.countryId().ifPresent(f -> builder.setCountryId(dto.getCountryId()));

    dto.verificationTimestamp().ifPresent(builder::setVerificationTimeStamp);
    dto.source().ifPresent(f -> builder.setSource(VerificationSourceType.from(f.value())));

    dto.price()
        .ifPresent(
            f -> {
              VerificationStatusResponseSmsPriceImpl price =
                  (VerificationStatusResponseSmsPriceImpl) f;
              price
                  .verificationPrice()
                  .ifPresent(p -> builder.setVerificationPrice(PriceDtoConverter.convert(p)));
            });
    return builder;
  }

  private static VerificationStatusCallout.Builder convert(
      VerificationStatusResponsePhoneCallImpl dto) {

    VerificationStatusCallout.Builder builder = VerificationStatusCallout.builder();

    dto.id().ifPresent(f -> builder.setId(VerificationId.valueOf(f)));
    dto.status().ifPresent(f -> builder.setStatus(VerificationStatusType.from(f.value())));
    dto.reason().ifPresent(f -> builder.setReason(VerificationStatusReasonType.from(f.value())));
    dto.reference().ifPresent(f -> builder.setReference(VerificationReference.valueOf(f)));
    dto.identity().ifPresent(f -> builder.setIdentity(IdentityDtoConverter.convert(f)));
    dto.countryId().ifPresent(f -> builder.setCountryId(dto.getCountryId()));

    dto.verificationTimestamp().ifPresent(builder::setVerificationTimeStamp);
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
