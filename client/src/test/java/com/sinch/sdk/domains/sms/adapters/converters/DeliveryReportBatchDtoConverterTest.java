package com.sinch.sdk.domains.sms.adapters.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.sms.models.DeliveryReportBatch;
import com.sinch.sdk.domains.sms.models.DeliveryReportBatchMMS;
import com.sinch.sdk.domains.sms.models.DeliveryReportBatchSMS;
import com.sinch.sdk.domains.sms.models.DeliveryReportStatusDetails;
import com.sinch.sdk.domains.sms.models.dto.v1.DeliveryReportDto;
import com.sinch.sdk.domains.sms.models.dto.v1.DeliveryReportDto.TypeEnum;
import com.sinch.sdk.domains.sms.models.dto.v1.MessageDeliveryStatusDto;
import java.rmi.UnexpectedException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import org.junit.jupiter.api.Test;

@TestWithResources
class DeliveryReportBatchDtoConverterTest extends BaseTest {

  @GivenJsonResource("/domains/sms/v1/deliveryreports/BatchDeliveryReportSMSDto.json")
  DeliveryReportDto deliveryReportSMSClientDto;

  @GivenJsonResource("/domains/sms/v1/deliveryreports/BatchDeliveryReportMMSDto.json")
  DeliveryReportDto deliveryReportMMSClientDto;

  public static void compareWithDto(
      DeliveryReportStatusDetails client, MessageDeliveryStatusDto dto) {
    assertEquals(dto.getCode(), client.getCode());
    assertEquals(dto.getCount(), client.getCount());
    assertEquals(dto.getRecipients(), client.getRecipients());
    assertEquals(dto.getStatus(), client.getStatus().value());
  }

  public static void compareWithDto(
      Collection<DeliveryReportStatusDetails> client, Collection<MessageDeliveryStatusDto> dto) {
    assertEquals(dto.size(), client.size());
    Iterator<MessageDeliveryStatusDto> dtoIterator = dto.iterator();
    Iterator<DeliveryReportStatusDetails> clientIterator = client.iterator();

    dtoIterator.forEachRemaining(dtoItem -> compareWithDto(clientIterator.next(), dtoItem));
  }

  public static void compareWithDto(DeliveryReportBatch client, DeliveryReportDto dto)
      throws UnexpectedException {
    String type = dto.getType();
    if (Objects.equals(type, TypeEnum.MMS.getValue())) {
      assertInstanceOf(DeliveryReportBatchMMS.class, client);
    } else if (Objects.equals(type, TypeEnum.SMS.getValue())) {
      assertInstanceOf(DeliveryReportBatchSMS.class, client);
    } else {
      throw new UnexpectedException("Unexpected type " + type);
    }

    assertEquals(dto.getBatchId(), client.getBatchId());
    compareWithDto(client.getStatuses(), dto.getStatuses());
    assertEquals(dto.getTotalMessageCount(), client.getTotalMessageCount());
    assertEquals(dto.getClientReference(), client.getClientReference().orElse(null));
  }

  @Test
  void convertSMS() throws UnexpectedException {
    compareWithDto(
        DeliveryReportDtoConverter.convert(deliveryReportSMSClientDto), deliveryReportSMSClientDto);
  }

  @Test
  void convertMMS() throws UnexpectedException {
    compareWithDto(
        DeliveryReportDtoConverter.convert(deliveryReportMMSClientDto), deliveryReportMMSClientDto);
  }
}
