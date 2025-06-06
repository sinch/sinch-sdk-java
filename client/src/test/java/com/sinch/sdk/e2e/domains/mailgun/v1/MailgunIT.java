package com.sinch.sdk.e2e.domains.mailgun.v1;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Mailgun V1")
@IncludeEngines("cucumber")
@SelectClasspathResource("features/mailgun")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.sinch.sdk.e2e.domains.mailgun.v1")
public class MailgunIT {}
