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
 */
@Suite
@SuiteDisplayName("Voice V2")
@IncludeEngines("cucumber")
@SelectClasspathResource("features/voice-v2/calls.feature")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.sinch.sdk.e2e.domains.voice.v2")
@ConfigurationParameter(key = FILTER_NAME_PROPERTY_NAME, value = "^\\[Start\\].*")
@ConfigurationParameter(key = PARALLEL_EXECUTION_ENABLED_PROPERTY_NAME, value = "true")
public class VoiceV2IT {}
