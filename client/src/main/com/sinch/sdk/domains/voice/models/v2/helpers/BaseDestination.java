package com.sinch.sdk.domains.voice.models.v2.helpers;

import com.sinch.sdk.domains.voice.models.v2.destination.CallDestination;
import com.sinch.sdk.domains.voice.models.v2.destination.CallOrigin;

/**
 * Call endpoint built by {@link Destination#of(String)}
 *
 * <p>Valid as <code>to</code> ({@link CallDestination}) and <code>from</code> ({@link CallOrigin}).
 *
 * <p>A stream endpoint is only valid as <code>to</code>: the API rejects it as <code>from</code>.
 *
 * @since 2.4
 */
public interface BaseDestination extends CallOrigin, CallDestination {}
