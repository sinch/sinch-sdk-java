package com.sinch.sdk.e2e.domains.sms.v0;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("SMS V0")
@IncludeEngines("cucumber")
@SelectClasspathResource("features/sms/batches.feature")
@SelectClasspathResource("features/sms/delivery-reports.feature")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.sinch.sdk.e2e.domains.sms.v0")
public class SmsIT {}
