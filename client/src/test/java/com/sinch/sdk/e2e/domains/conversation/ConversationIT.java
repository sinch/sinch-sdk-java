package com.sinch.sdk.e2e.domains.conversation;

import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features/conversation/apps.feature")
@SelectClasspathResource("features/conversation/capability.feature")
@SelectClasspathResource("features/conversation/contacts.feature")
@SelectClasspathResource("features/conversation/conversations.feature")
@SelectClasspathResource("features/conversation/events.feature")
@SelectClasspathResource("features/conversation/messages.feature")
public class ConversationIT {}
