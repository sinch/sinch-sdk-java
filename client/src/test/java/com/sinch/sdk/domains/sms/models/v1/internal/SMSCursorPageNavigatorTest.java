package com.sinch.sdk.domains.sms.models.v1.internal;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SMSCursorPageNavigatorTest {

  @Test
  void getTokenNullPageSize() {
    SMSCursorPageNavigator cursorNavigator = new SMSCursorPageNavigator(45, null);
    Assertions.assertThat(cursorNavigator.getToken()).isEqualTo(null);
  }

  @Test
  void getTokenZeroPageSize() {
    SMSCursorPageNavigator cursorNavigator = new SMSCursorPageNavigator(45, 0);
    Assertions.assertThat(cursorNavigator.getToken()).isEqualTo(null);
  }

  @Test
  void getToken() {
    SMSCursorPageNavigator cursorNavigator = new SMSCursorPageNavigator(0, 15);
    Assertions.assertThat(cursorNavigator.getToken()).isEqualTo(1);
  }
}
