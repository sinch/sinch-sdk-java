package com.sinch.sdk.domains.sms.models.v1.deliveryreports;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.internal.BatchDeliveryReportOneOfImpl;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.request.BatchDeliveryReportQueryParameters;

/**
 * Base class for all classes supporting Batch DeliveryReport
 *
 * @see com.sinch.sdk.domains.sms.api.v1.DeliveryReportsService#get(String,
 *     BatchDeliveryReportQueryParameters)
 * @see com.sinch.sdk.domains.sms.api.v1.WebHooksService#parseEvent(String)
 * @since 1.5
 */
@JsonDeserialize(using = BatchDeliveryReportOneOfImpl.Deserializer.class)
public interface BatchDeliveryReport extends DeliveryReport {}
