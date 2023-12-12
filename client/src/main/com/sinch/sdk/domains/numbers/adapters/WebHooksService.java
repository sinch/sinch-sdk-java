package com.sinch.sdk.domains.numbers.adapters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.exceptions.ApiMappingException;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.numbers.adapters.converters.CallbackPayloadDtoConverter;
import com.sinch.sdk.domains.numbers.models.dto.v1.CallbackPayloadDto;
import com.sinch.sdk.domains.numbers.models.webhooks.EventNotification;

public class WebHooksService implements com.sinch.sdk.domains.numbers.WebHooksService {

  @Override
  public EventNotification unserializeEventNotification(String jsonPayload)
      throws ApiMappingException {

    try {
      CallbackPayloadDto dto =
          Mapper.getInstance().readValue(jsonPayload, CallbackPayloadDto.class);
      if (null != dto) {
        return CallbackPayloadDtoConverter.convert(dto);
      }
      throw new ApiMappingException(jsonPayload, null);

    } catch (JsonProcessingException e) {
      throw new ApiMappingException(jsonPayload, e);
    }
  }
}
