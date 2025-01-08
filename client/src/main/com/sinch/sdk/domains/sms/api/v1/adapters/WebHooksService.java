package com.sinch.sdk.domains.sms.api.v1.adapters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.exceptions.ApiMappingException;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.sms.models.v1.webhooks.SmsEvent;

public class WebHooksService implements com.sinch.sdk.domains.sms.api.v1.WebHooksService {

  public SmsEvent parse(String jsonPayload) throws ApiMappingException {

    try {
      return Mapper.getInstance().readValue(jsonPayload, SmsEvent.class);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }
}
