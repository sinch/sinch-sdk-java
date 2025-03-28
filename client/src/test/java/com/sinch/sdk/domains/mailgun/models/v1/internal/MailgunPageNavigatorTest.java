package com.sinch.sdk.domains.mailgun.models.v1.internal;

import com.sinch.sdk.core.http.HttpMethod;
import com.sinch.sdk.core.http.HttpRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MailgunPageNavigatorTest {

  @Test
  void getToken() {
    HttpRequest request =
        new HttpRequest(
            "https://my-full-url.com/path?query", HttpMethod.GET, null, null, null, null, null);
    MailgunPageNavigator cursorNavigator = new MailgunPageNavigator(request);
    Assertions.assertThat(cursorNavigator.getToken()).isEqualTo(request);
  }
}
