package com.sinch.sdk.domains.verification.adapters;

import com.sinch.sdk.BaseTest;

public class VerificationBaseTest extends BaseTest {

  static {
    // faking a service init to trigger dedicated serializers initialization
    VerificationService.LocalLazyInit.init();
  }
}
