package com.sinch.sdk.domains.voice.models.v2.destination.internal;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = CallOriginInternalImpl.CallOriginInternalImplDeserializer.class)
public interface CallOriginInternal {}
