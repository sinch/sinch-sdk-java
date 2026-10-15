package com.sinch.sdk.domains.voice.models.v2.destination.internal;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = CallDestinationInternalImpl.CallDestinationInternalImplDeserializer.class)
public interface CallDestinationInternal {}
