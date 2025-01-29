package com.sinch.sdk.domains.sms.models.v1.deliveryreports;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.internal.RecipientDeliveryReportOneOfImpl;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.request.ListDeliveryReportsQueryParameters;

/**
 * Base class for all classes supporting Recipient DeliveryReport
 *
 * @see com.sinch.sdk.domains.sms.api.v1.DeliveryReportsService#getForNumber(String, String)
 * @see
 *     com.sinch.sdk.domains.sms.api.v1.DeliveryReportsService#list(ListDeliveryReportsQueryParameters)
 * @see com.sinch.sdk.domains.sms.api.v1.WebHooksService#parseEvent(String)
 * @since 1.5
 */
@JsonDeserialize(using = RecipientDeliveryReportOneOfImpl.Deserializer.class)
public interface RecipientDeliveryReport extends DeliveryReport {}
