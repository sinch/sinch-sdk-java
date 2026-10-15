package com.sinch.sdk.domains.voice.models.v2.svaml.playback;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.voice.models.v2.svaml.playback.internal.MessageInternalImpl;

/**
 * Base interface for messages played by SVAML v2 commands.
 *
 * @since 2.3
 */
@JsonDeserialize(using = MessageInternalImpl.Deserializer.class)
public interface Message {}
