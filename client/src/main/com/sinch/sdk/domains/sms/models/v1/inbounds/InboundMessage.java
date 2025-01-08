package com.sinch.sdk.domains.sms.models.v1.inbounds;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.sms.models.v1.inbounds.response.internal.InboundInternalImpl;
import com.sinch.sdk.domains.sms.models.v1.webhooks.SmsEvent;

@JsonDeserialize(using = InboundInternalImpl.Deserializer.class)
public interface InboundMessage extends SmsEvent {}
