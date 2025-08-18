package com.sinch.sdk.domains.conversation.templates.api.adapters;

import com.sinch.sdk.BaseTest;

public class TemplatesBaseTest extends BaseTest {

  static {
    // faking a service init to trigger dedicated serializers initialization
    TemplatesService.LocalLazyInit.init();
  }
}
