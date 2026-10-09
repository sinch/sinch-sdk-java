package com.sinch.sdk.domains.voice.models.v2.services;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.voice.models.v2.services.internal.CallBehaviorInternalImpl;

/**
 * Base interface for the call behavior of a service: defines how calls are handled for this
 * service.
 *
 * @since 2.3
 */
@JsonDeserialize(using = CallBehaviorInternalImpl.Deserializer.class)
public interface CallBehavior {}
