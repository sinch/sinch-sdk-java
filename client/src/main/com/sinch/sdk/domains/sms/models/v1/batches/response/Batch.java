package com.sinch.sdk.domains.sms.models.v1.batches.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.sms.models.v1.batches.response.internal.BatchResponseInternalImpl;

@JsonDeserialize(using = BatchResponseInternalImpl.Deserializer.class)
public interface Batch {}
