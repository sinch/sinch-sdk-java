package com.sinch.sdk.domains.voice.models.v2.services.internal;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = CallBehaviorInternalImpl.CallBehaviorInternalImplDeserializer.class)
public interface CallBehaviorInternal {}
