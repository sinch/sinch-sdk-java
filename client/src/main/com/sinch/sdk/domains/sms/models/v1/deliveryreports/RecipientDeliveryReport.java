package com.sinch.sdk.domains.sms.models.v1.deliveryreports;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.internal.RecipientDeliveryReportOneOfImpl;

@JsonDeserialize(using = RecipientDeliveryReportOneOfImpl.Deserializer.class)
public interface RecipientDeliveryReport extends DeliveryReport {}
