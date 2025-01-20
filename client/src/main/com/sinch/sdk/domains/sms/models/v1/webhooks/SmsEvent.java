package com.sinch.sdk.domains.sms.models.v1.webhooks;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.sms.models.v1.webhooks.internal.WebhookEventOneOfImpl;

/**
 * Base class for all WebHook event's class
 *
 * @see com.sinch.sdk.domains.sms.api.v1.WebHooksService#parseEvent(String)
 * @since 1,5
 */
@JsonDeserialize(using = WebhookEventOneOfImpl.Deserializer.class)
public interface SmsEvent {}
