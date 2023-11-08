package com.sinch.sdk.domains.sms.adapters.converters;

import com.sinch.sdk.domains.sms.models.DeliveryReportStatus;
import com.sinch.sdk.domains.sms.models.dto.v1.DeliveryReportDto;
import com.sinch.sdk.domains.sms.models.dto.v1.DeliveryReportDto.TypeEnum;
import com.sinch.sdk.domains.sms.models.dto.v1.MessageDeliveryStatusDto;
import com.sinch.sdk.domains.sms.models.webhooks.DeliveryReport;
import com.sinch.sdk.domains.sms.models.webhooks.DeliveryReportMMS;
import com.sinch.sdk.domains.sms.models.webhooks.DeliveryReportSMS;
import com.sinch.sdk.domains.sms.models.webhooks.DeliveryReportStatusDetails;
import java.util.Objects;
import java.util.stream.Collectors;

public class DeliveryReportDtoConverter {

  public static DeliveryReport convert(DeliveryReportDto dto) {
    DeliveryReport.Builder<?> builder;

    if (Objects.equals(dto.getType(), TypeEnum.MMS.getValue())) {
      builder = DeliveryReportMMS.builder();
    } else if (Objects.equals(dto.getType(), TypeEnum.SMS.getValue())) {
      builder = DeliveryReportSMS.builder();
    } else {
      return null;
    }

    return builder
        .setBatchId(dto.getBatchId())
        .setClientReference(dto.getClientReference())
        .setStatuses(
            null != dto.getStatuses()
                ? dto.getStatuses().stream()
                    .map(DeliveryReportDtoConverter::convert)
                    .collect(Collectors.toList())
                : null)
        .setTotalMessageCount(dto.getTotalMessageCount())
        .build();
  }

  private static DeliveryReportStatusDetails convert(MessageDeliveryStatusDto dto) {
    return DeliveryReportStatusDetails.builder()
        .setCode(dto.getCode())
        .setCount(dto.getCount())
        .setStatus(DeliveryReportStatus.from(dto.getStatus()))
        .setRecipients(dto.getRecipients())
        .build();
  }
}
