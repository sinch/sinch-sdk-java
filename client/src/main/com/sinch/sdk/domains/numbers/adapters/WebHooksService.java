package com.sinch.sdk.domains.numbers.adapters;

import com.sinch.sdk.core.exceptions.ApiMappingException;
import com.sinch.sdk.domains.numbers.adapters.converters.CallbackPayloadDtoConverter;
import com.sinch.sdk.domains.numbers.models.v1.webhooks.NumberEvent;
import com.sinch.sdk.domains.numbers.models.webhooks.EventNotification;

public class WebHooksService implements com.sinch.sdk.domains.numbers.WebHooksService {

  com.sinch.sdk.domains.numbers.api.v1.WebHooksService v1;

  public WebHooksService(com.sinch.sdk.domains.numbers.api.v1.WebHooksService v1) {
    this.v1 = v1;
  }

  @Override
  public EventNotification unserializeEventNotification(String jsonPayload)
      throws ApiMappingException {

    NumberEvent dto = v1.parseEvent(jsonPayload);
    if (null != dto) {
      return CallbackPayloadDtoConverter.convert(dto);
    }
    throw new ApiMappingException(jsonPayload, null);
  }
}
