package com.sinch.sdk.domains.numbers.api.v1.adapters;

import com.sinch.sdk.BaseTest;

public class NumbersBaseTest extends BaseTest {

  static {
    // faking a service init to trigger dedicated serializers initialization
    NumbersService.LocalLazyInit.init();
  }
}
