package com.sinch.sdk.domains.sms.models.v1.deliveryreports;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.internal.BatchDeliveryReportOneOfImpl;

@JsonDeserialize(using = BatchDeliveryReportOneOfImpl.Deserializer.class)
public interface BatchDeliveryReport extends DeliveryReport {}
