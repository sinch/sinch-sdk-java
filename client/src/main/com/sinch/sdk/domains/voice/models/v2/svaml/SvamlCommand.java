package com.sinch.sdk.domains.voice.models.v2.svaml;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.voice.models.v2.svaml.internal.SvamlCommandInternalImpl;

/**
 * Base interface for SVAML v2 commands.
 *
 * @since 2.3
 */
@JsonDeserialize(using = SvamlCommandInternalImpl.Deserializer.class)
public interface SvamlCommand {}
