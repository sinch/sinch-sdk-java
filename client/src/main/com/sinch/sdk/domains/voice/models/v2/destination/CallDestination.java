package com.sinch.sdk.domains.voice.models.v2.destination;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.voice.models.v2.destination.internal.CallDestinationInternalImpl;

/**
 * Base interface for the destination of a call (the <code>to</code> of a <code>dial</code>
 * command).
 *
 * @since 2.3
 */
@JsonDeserialize(using = CallDestinationInternalImpl.Deserializer.class)
public interface CallDestination {}
