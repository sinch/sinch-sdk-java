package com.sinch.sdk.domains.sms.adapters.converters;

import com.sinch.sdk.core.models.pagination.CursorPageNavigator;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.domains.sms.models.DeliveryReportBatch;
import com.sinch.sdk.domains.sms.models.DeliveryReportBatchMMS;
import com.sinch.sdk.domains.sms.models.DeliveryReportBatchSMS;
import com.sinch.sdk.domains.sms.models.DeliveryReportErrorCode;
import com.sinch.sdk.domains.sms.models.DeliveryReportRecipient;
import com.sinch.sdk.domains.sms.models.DeliveryReportRecipientEncoding;
import com.sinch.sdk.domains.sms.models.DeliveryReportRecipientMMS;
import com.sinch.sdk.domains.sms.models.DeliveryReportRecipientSMS;
import com.sinch.sdk.domains.sms.models.DeliveryReportStatus;
import com.sinch.sdk.domains.sms.models.DeliveryReportStatusDetails;
import com.sinch.sdk.domains.sms.models.dto.v1.DeliveryReportDto;
import com.sinch.sdk.domains.sms.models.dto.v1.DeliveryReportListDto;
import com.sinch.sdk.domains.sms.models.dto.v1.MessageDeliveryStatusDto;
import com.sinch.sdk.domains.sms.models.dto.v1.RecipientDeliveryReportDto;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

public class DeliveryReportDtoConverter {

  public static DeliveryReportBatch convert(DeliveryReportDto dto) {
    DeliveryReportBatch.Builder<?> builder;

    if (Objects.equals(dto.getType(), DeliveryReportDto.TypeEnum.MMS.getValue())) {
      builder = DeliveryReportBatchMMS.builder();
    } else if (Objects.equals(dto.getType(), DeliveryReportDto.TypeEnum.SMS.getValue())) {
      builder = DeliveryReportBatchSMS.builder();
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

  public static DeliveryReportRecipient convert(RecipientDeliveryReportDto dto) {
    DeliveryReportRecipient.Builder<?> builder;

    if (Objects.equals(dto.getType(), RecipientDeliveryReportDto.TypeEnum.MMS.getValue())) {
      builder = DeliveryReportRecipientMMS.builder();
    } else if (Objects.equals(dto.getType(), RecipientDeliveryReportDto.TypeEnum.SMS.getValue())) {
      builder = DeliveryReportRecipientSMS.builder();
    } else {
      return null;
    }

    return builder
        .setBatchId(dto.getBatchId())
        .setClientReference(dto.getClientReference())
        .setAt(null != dto.getAt() ? dto.getAt().toInstant() : null)
        .setCode(DeliveryReportErrorCode.from(dto.getCode()))
        .setRecipient(dto.getRecipient())
        .setStatus(DeliveryReportStatus.from(dto.getStatus()))
        .setAppliedOriginator(dto.getAppliedOriginator())
        .setEncoding(DeliveryReportRecipientEncoding.from(dto.getEncoding()))
        .setNumberOfMessageParts(dto.getNumberOfMessageParts())
        .setOperator(dto.getOperator())
        .setOperatorStatusAt(
            null != dto.getOperatorStatusAt() ? dto.getOperatorStatusAt().toInstant() : null)
        .build();
  }

  public static Pair<Collection<DeliveryReportRecipient>, CursorPageNavigator> convert(
      DeliveryReportListDto dto) {
    CursorPageNavigator navigator =
        new CursorPageNavigator(dto.getPage(), dto.getPageSize(), dto.getCount());
    Collection<RecipientDeliveryReportDto> collection = dto.getDeliveryReports();
    Collection<DeliveryReportRecipient> pageContent = new ArrayList<>();
    if (null != collection) {
      for (RecipientDeliveryReportDto innerDto : collection) {
        DeliveryReportRecipient convert = convert(innerDto);
        pageContent.add(convert);
      }
    }
    return new Pair<>(pageContent, navigator);
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
