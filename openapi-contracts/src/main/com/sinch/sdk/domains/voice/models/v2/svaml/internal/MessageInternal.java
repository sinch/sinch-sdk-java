package com.sinch.sdk.domains.voice.models.v2.svaml.internal;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = MessageInternalImpl.MessageInternalImplDeserializer.class)
public interface MessageInternal {}
