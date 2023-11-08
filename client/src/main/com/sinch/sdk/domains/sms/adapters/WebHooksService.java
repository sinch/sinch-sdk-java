package com.sinch.sdk.domains.sms.adapters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.exceptions.ApiMappingException;
import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.sms.models.BaseDeliveryReport;
import com.sinch.sdk.domains.sms.models.webhooks.BaseIncomingSMS;

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
      BaseDeliveryReport generic =
          Mapper.getInstance().readValue(jsonPayload, BaseDeliveryReport.class);
      if (null == generic && !StringUtil.isEmpty(jsonPayload)) {
        throw new ApiMappingException(jsonPayload, null);
      }
      return generic;
    } catch (JsonProcessingException e) {
      throw new ApiMappingException(jsonPayload, e);
    }
  }
}
