package com.sinch.sdk.domains.numbers.api.v1.adapters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.exceptions.ApiMappingException;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.numbers.models.v1.webhooks.NumberEvent;

public class WebHooksService implements com.sinch.sdk.domains.numbers.api.v1.WebHooksService {

  @Override
  public NumberEvent parseEvent(String jsonPayload) throws ApiMappingException {

    try {
      return Mapper.getInstance().readValue(jsonPayload, NumberEvent.class);
    } catch (JsonProcessingException e) {
      throw new ApiMappingException(jsonPayload, e);
    }
  }
}
