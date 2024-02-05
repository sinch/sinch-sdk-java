package com.sinch.sdk.domains.verification.models.requests;

import com.sinch.sdk.domains.verification.models.NumberIdentity;
import com.sinch.sdk.domains.verification.models.VerificationMethodType;
import com.sinch.sdk.domains.verification.models.VerificationReference;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class StartVerificationFlashCallRequestParametersTest {

  final NumberIdentity identity = NumberIdentity.builder().setEndpoint("foo identity").build();
  final VerificationMethodType method = VerificationMethodType.FLASH_CALL;
  final String reference = "foo reference";
  final String custom = "foo custom";

  final Integer dialTimeOut = 123;
  final StartVerificationFlashCallRequestParameters value =
      StartVerificationFlashCallRequestParameters.builder()
          .setIdentity(identity)
          .setReference(VerificationReference.valueOf(reference))
          .setCustom(custom)
          .setDialTimeOut(dialTimeOut)
          .build();

  @Test
  void getIdentity() {
    Assertions.assertThat(value.getIdentity().get()).isEqualTo(identity);
  }

  @Test
  void getMethod() {
    Assertions.assertThat(value.getMethod().get()).isEqualTo(method);
  }

  @Test
  void getReference() {
    Assertions.assertThat(value.getReference().get().getReference()).isEqualTo(reference);
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
