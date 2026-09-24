package com.sinch.sdk.domains.voice.models.v2.destination;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.voice.models.v2.destination.internal.CallOriginInternalImpl;

/**
 * Base interface for the origin of a call (the <code>from</code> of a <code>dial</code> command).
 *
 * @since 2.3
 */
@JsonDeserialize(using = CallOriginInternalImpl.Deserializer.class)
public interface CallOrigin {}
