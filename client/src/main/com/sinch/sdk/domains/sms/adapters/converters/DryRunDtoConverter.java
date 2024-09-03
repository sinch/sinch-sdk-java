package com.sinch.sdk.domains.sms.adapters.converters;

import com.sinch.sdk.domains.sms.models.DryRun;
import com.sinch.sdk.domains.sms.models.DryRunPerRecipientDetails;
import com.sinch.sdk.domains.sms.models.dto.v1.DryRun200ResponseDto;
import com.sinch.sdk.domains.sms.models.dto.v1.DryRun200ResponsePerRecipientInnerDto;
import java.util.stream.Collectors;

public class DryRunDtoConverter {

  public static DryRun convert(DryRun200ResponseDto dto) {
    return DryRun.builder()
        .setNumberOfRecipients(dto.getNumberOfRecipients())
        .setNumberOfMessages(dto.getNumberOfMessages())
        .setPerRecipient(
            dto.getPerRecipient().stream()
                .map(DryRunDtoConverter::convert)
                .collect(Collectors.toList()))
        .build();
  }

  private static DryRunPerRecipientDetails convert(DryRun200ResponsePerRecipientInnerDto dto) {
    return DryRunPerRecipientDetails.builder()
        .setRecipient(dto.getRecipient())
        .setNumberOfParts(dto.getNumberOfParts())
        .setBody(dto.getBody())
        .setEncoding(dto.getEncoding())
        .build();
  }
}
