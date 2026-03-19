package com.sinch.sdk.domains.sms.models.v1.deliveryreports;

import com.sinch.sdk.domains.sms.api.v1.SinchEventsService;
import com.sinch.sdk.domains.sms.models.v1.sinchevents.SmsSinchEvent;

/**
 * Base class for all classes supporting DeliveryReport
 *
 * @see SinchEventsService#parseEvent(String)
 * @since 1.5
 */
public interface DeliveryReport extends SmsSinchEvent {}
