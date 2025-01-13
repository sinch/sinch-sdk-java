package com.sinch.sdk.domains.sms.api.v1;

import com.sinch.sdk.core.exceptions.ApiMappingException;
import com.sinch.sdk.domains.sms.models.v1.webhooks.SmsEvent;

public interface WebHooksService {

  SmsEvent parseEvent(String jsonPayload) throws ApiMappingException;
}
