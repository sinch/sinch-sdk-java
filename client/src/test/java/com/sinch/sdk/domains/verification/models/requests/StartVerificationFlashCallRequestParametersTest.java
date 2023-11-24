package com.sinch.sdk.domains.verification.models.requests;

import com.sinch.sdk.domains.verification.models.Identity;
import com.sinch.sdk.domains.verification.models.NumberIdentity;
import com.sinch.sdk.domains.verification.models.VerificationMethodType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class StartVerificationFlashCallRequestParametersTest {

  final Identity identity = NumberIdentity.builder().setEndpoint("foo identity").build();
  final VerificationMethodType method = VerificationMethodType.FLASH_CALL;
  final String reference = "foo reference";
  final String custom = "foo custom";

  final Integer dialTimeOut = 123;
  final StartVerificationFlashCallRequestParameters value =
      StartVerificationFlashCallRequestParameters.builder()
          .setIdentity(identity)
          .setReference(reference)
          .setCustom(custom)
          .setDialTimeOut(dialTimeOut)
          .build();

  @Test
  void getIdentity() {
    Assertions.assertThat(value.getIdentity()).isEqualTo(identity);
  }

  @Test
  void getMethod() {
    Assertions.assertThat(value.getMethod()).isEqualTo(method);
  }

  @Test
  void getReference() {
    Assertions.assertThat(value.getReference().get()).isEqualTo(reference);
  }

  @Test
  void getCustom() {
    Assertions.assertThat(value.getCustom().get()).isEqualTo(custom);
  }

  @Test
  void getDialTimeOut() {
    Assertions.assertThat(value.getDialTimeOut().get()).isEqualTo(dialTimeOut);
  }
}
