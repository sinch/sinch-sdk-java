package com.sinch.sdk.domains.sms.adapters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.exceptions.ApiMappingException;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.sms.adapters.converters.DeliveryReportDtoConverter;
import com.sinch.sdk.domains.sms.adapters.converters.InboundsDtoConverter;
import com.sinch.sdk.domains.sms.models.BaseDeliveryReport;
import com.sinch.sdk.domains.sms.models.Inbound;
import com.sinch.sdk.domains.sms.models.dto.v1.DeliveryReportDto;
import com.sinch.sdk.domains.sms.models.dto.v1.DeliveryReportDto.TypeEnum;
import com.sinch.sdk.domains.sms.models.dto.v1.MOBinaryDto;
import com.sinch.sdk.domains.sms.models.dto.v1.MOTextDto;
import com.sinch.sdk.domains.sms.models.dto.v1.RecipientDeliveryReportDto;
import com.sinch.sdk.domains.sms.models.webhooks.WebhooksEvent;
import java.util.Objects;

public class WebHooksService implements com.sinch.sdk.domains.sms.WebHooksService {

  public WebhooksEvent parse(String jsonPayload) throws ApiMappingException {

    WebhooksEvent event;
    try {
      event = incomingSMS(jsonPayload);
      if (null == event) {
        event = deliveryReport(jsonPayload);
      }
      if (null == event) {
        throw new ApiMappingException(jsonPayload, null);
      }
    } catch (JsonProcessingException e) {
      throw new ApiMappingException(jsonPayload, e);
    }
    return event;
  }

  private Inbound<?> incomingSMS(String jsonPayload) throws JsonProcessingException {
    MOBinaryDto binary = Mapper.getInstance().readValue(jsonPayload, MOBinaryDto.class);
    if (null != binary
        && (Objects.equals(binary.getType(), MOBinaryDto.TypeEnum.MO_BINARY.getValue()))) {
      return InboundsDtoConverter.convert(binary);
    }
    MOTextDto text = Mapper.getInstance().readValue(jsonPayload, MOTextDto.class);
    if (null != text && (Objects.equals(text.getType(), MOTextDto.TypeEnum.MO_TEXT.getValue()))) {
      return InboundsDtoConverter.convert(text);
    }
    return null;
  }

  private BaseDeliveryReport deliveryReport(String jsonPayload) throws JsonProcessingException {
    // Can we convert payload to Recipient DeliveryReport or Batch Delivery Report ?
    RecipientDeliveryReportDto recipient =
        Mapper.getInstance().readValue(jsonPayload, RecipientDeliveryReportDto.class);
    if (null != recipient
        && (Objects.equals(recipient.getType(), RecipientDeliveryReportDto.TypeEnum.MMS.getValue())
            || Objects.equals(
                recipient.getType(), RecipientDeliveryReportDto.TypeEnum.SMS.getValue()))) {
      return DeliveryReportDtoConverter.convert(recipient);
    }

    DeliveryReportDto deliveryReport =
        Mapper.getInstance().readValue(jsonPayload, DeliveryReportDto.class);
    if (null != deliveryReport
        && (Objects.equals(deliveryReport.getType(), TypeEnum.MMS.getValue())
            || Objects.equals(deliveryReport.getType(), TypeEnum.SMS.getValue()))) {
      return DeliveryReportDtoConverter.convert(deliveryReport);
    }
    return null;
  }
}
