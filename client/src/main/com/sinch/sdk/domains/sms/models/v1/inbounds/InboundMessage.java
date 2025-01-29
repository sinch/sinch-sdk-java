package com.sinch.sdk.domains.sms.models.v1.inbounds;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.sms.models.v1.inbounds.request.ListInboundMessagesQueryParameters;
import com.sinch.sdk.domains.sms.models.v1.inbounds.response.internal.InboundInternalImpl;
import com.sinch.sdk.domains.sms.models.v1.webhooks.SmsEvent;

/**
 * Base class for all classes supporting InBounds
 *
 * @see com.sinch.sdk.domains.sms.api.v1.InboundsService#get(String)
 * @see com.sinch.sdk.domains.sms.api.v1.InboundsService#list(ListInboundMessagesQueryParameters)
 * @see com.sinch.sdk.domains.sms.api.v1.WebHooksService#parseEvent(String)
 * @since 1.5
 */
@JsonDeserialize(using = InboundInternalImpl.Deserializer.class)
public interface InboundMessage extends SmsEvent {}
