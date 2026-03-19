package com.sinch.sdk.domains.sms.models.v1.sinchevents;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.sms.api.v1.SinchEventsService;
import com.sinch.sdk.domains.sms.models.v1.sinchevents.internal.SmsSinchEventOneOfImpl;

/**
 * Base class for all Sinch event's class
 *
 * @see SinchEventsService#parseEvent(String)
 * @since 2.0
 */
@JsonDeserialize(using = SmsSinchEventOneOfImpl.Deserializer.class)
public interface SmsSinchEvent {}
