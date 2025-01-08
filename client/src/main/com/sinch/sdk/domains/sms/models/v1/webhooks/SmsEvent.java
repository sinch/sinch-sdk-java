package com.sinch.sdk.domains.sms.models.v1.webhooks;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.sms.models.v1.webhooks.internal.WebhookEventOneOfImpl;

/** Interface defining a WebHook event */
@JsonDeserialize(using = WebhookEventOneOfImpl.Deserializer.class)
public interface SmsEvent {}
