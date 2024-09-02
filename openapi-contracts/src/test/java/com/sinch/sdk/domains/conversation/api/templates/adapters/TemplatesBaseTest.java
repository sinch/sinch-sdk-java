package com.sinch.sdk.domains.conversation.api.templates.adapters;

import com.sinch.sdk.BaseTest;

public class TemplatesBaseTest extends BaseTest {

  static {
    // faking a service init to trigger dedicated serializers initialization
    TemplatesService.LocalLazyInit.init();
  }
}
