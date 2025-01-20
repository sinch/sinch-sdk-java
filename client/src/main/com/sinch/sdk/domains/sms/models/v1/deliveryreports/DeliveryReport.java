package com.sinch.sdk.domains.sms.models.v1.deliveryreports;

import com.sinch.sdk.domains.sms.models.v1.webhooks.SmsEvent;

/**
 * Base class for all classes supporting DeliveryReport
 *
 * @see com.sinch.sdk.domains.sms.api.v1.WebHooksService#parseEvent(String)
 * @since 1,5
 */
public interface DeliveryReport extends SmsEvent {}
