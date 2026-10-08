package com.sinch.sdk.e2e.domains.voice.v2;

import static io.cucumber.junit.platform.engine.Constants.FILTER_NAME_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PARALLEL_EXECUTION_ENABLED_PROPERTY_NAME;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

/**
 * Only the scenarios of the operations this SDK implements. Widen the resource and the name filter
 * as the other Voice V2 operations land.
 *
 * <p>The filter matches scenario names across all features, and they share the same {@code [Get]}
 * prefix. Each {@code [Get]} is therefore matched by its full name, so that a {@code [Get]}
 * scenario of an operation not implemented yet stays out.
 */
@Suite
@SuiteDisplayName("Voice V2")
@IncludeEngines("cucumber")
@SelectClasspathResource("features/voice-v2/calls.feature")
@SelectClasspathResource("features/voice-v2/batches.feature")
@SelectClasspathResource("features/voice-v2/sessions.feature")
@SelectClasspathResource("features/voice-v2/services.feature")
@SelectClasspathResource("features/voice-v2/webhooks-events.feature")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.sinch.sdk.e2e.domains.voice.v2")
@ConfigurationParameter(
    key = FILTER_NAME_PROPERTY_NAME,
    value =
        "^\\[Start\\].*|^\\[Get\\] get a batch call summary$|^\\[GetDetails\\] get batch call"
            + " details$|^\\[Stop\\] stop batch processing$|^\\[Get\\] get a session$"
            + "|^\\[Get\\] get call details$"
            + "|^\\[List\\] list (a page of|all the) calls.*$"
            + "|^\\[InteractByCallId\\] interact with an ongoing call by call ID$"
            + "|^\\[InteractByCallName\\] interact with an ongoing call by call name$"
            + "|^\\[Create\\] create a Voice-V2 service$"
            + "|^\\[Get\\] get Voice-V2 service details$"
            + "|^\\[List\\] list (a page of|all the) Voice-V2 services.*$"
            + "|^\\[(Incoming Call|Answered Call|Answer Webhook) Event\\].*")
@ConfigurationParameter(key = PARALLEL_EXECUTION_ENABLED_PROPERTY_NAME, value = "true")
public class VoiceIT {}
