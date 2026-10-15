package com.sinch.sdk.domains.voice.models.v2.svaml.internal;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = SvamlCommandInternalImpl.SvamlCommandInternalImplDeserializer.class)
public interface SvamlCommandInternal {}
