package com.sinch.sdk.domains.conversation.adapters;

import com.sinch.sdk.BaseTest;

public class ConversationBaseTest extends BaseTest {

  static {
    // faking a service init to trigger dedicated serializers initialization
    ContactService.LocalLazyInit.init();
  }
}
