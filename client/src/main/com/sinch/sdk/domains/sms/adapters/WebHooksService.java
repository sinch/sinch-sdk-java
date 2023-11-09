package com.sinch.sdk.domains.sms.adapters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.exceptions.ApiMappingException;
import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.sms.adapters.converters.DeliveryReportDtoConverter;
import com.sinch.sdk.domains.sms.models.BaseDeliveryReport;
import com.sinch.sdk.domains.sms.models.dto.v1.DeliveryReportDto;
import com.sinch.sdk.domains.sms.models.dto.v1.DeliveryReportDto.TypeEnum;
import com.sinch.sdk.domains.sms.models.dto.v1.RecipientDeliveryReportDto;
import com.sinch.sdk.domains.sms.models.webhooks.BaseIncomingSMS;
import java.util.Objects;

public class WebHooksService implements com.sinch.sdk.domains.sms.WebHooksService {

  @Override
  public BaseIncomingSMS<?> incomingSMS(String jsonPayload) throws ApiMappingException {
    try {
      BaseIncomingSMS<?> generic =
          Mapper.getInstance().readValue(jsonPayload, BaseIncomingSMS.class);
      if (null == generic && !StringUtil.isEmpty(jsonPayload)) {
        throw new ApiMappingException(jsonPayload, null);
      }
      return generic;
    } catch (JsonProcessingException e) {
      throw new ApiMappingException(jsonPayload, e);
    }
  }

  @Override
  public BaseDeliveryReport deliveryReport(String jsonPayload) throws ApiMappingException {
    try {
      // Can we convert payload to Recipient DeliveryReport or Batch Delivery Report ?
      RecipientDeliveryReportDto recipient =
          Mapper.getInstance().readValue(jsonPayload, RecipientDeliveryReportDto.class);
      if (null != recipient
          && (Objects.equals(
                  recipient.getType(), RecipientDeliveryReportDto.TypeEnum.MMS.getValue())
              || Objects.equals(
                  recipient.getType(), RecipientDeliveryReportDto.TypeEnum.SMS.getValue()))) {
        return DeliveryReportDtoConverter.convert(recipient);
      }

      DeliveryReportDto batch =
          Mapper.getInstance().readValue(jsonPayload, DeliveryReportDto.class);
      if (null != batch
          && (Objects.equals(batch.getType(), TypeEnum.MMS.getValue())
              || Objects.equals(batch.getType(), TypeEnum.SMS.getValue()))) {
        return DeliveryReportDtoConverter.convert(batch);
      }

      throw new ApiMappingException(jsonPayload, null);

    } catch (JsonProcessingException e) {
      throw new ApiMappingException(jsonPayload, e);
    }
  }
}
