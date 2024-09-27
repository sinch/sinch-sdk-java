package com.sinch.sdk.domains.conversation.api.v1.adapters;

import com.sinch.sdk.BaseTest;

public class ConversationBaseTest extends BaseTest {

  static {
    // faking a service init to trigger dedicated serializers initialization
    ConversationService.LocalLazyInit.init();
  }
}
