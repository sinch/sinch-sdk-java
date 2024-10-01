package com.sinch.sdk.e2e.domains.voice;

import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features/voice/callouts.feature")
@SelectClasspathResource("features/voice/calls.feature")
@SelectClasspathResource("features/voice/conferences.feature")
@SelectClasspathResource("features/voice/webhooks-events.feature")
public class VoiceIT {}
