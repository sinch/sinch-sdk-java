package com.sinch.sdk.domains.verification.models.requests;

import com.sinch.sdk.domains.verification.models.Identity;
import com.sinch.sdk.domains.verification.models.NumberIdentity;
import com.sinch.sdk.domains.verification.models.VerificationMethodType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class StartVerificationRequestParametersTest {

  final Identity identity = NumberIdentity.builder().setEndpoint("foo identity").build();
  final VerificationMethodType method = VerificationMethodType.CALLOUT;
  final String reference = "foo reference";
  final String custom = "foo custom";

  final StartVerificationRequestParameters value =
      StartVerificationRequestParameters.builder()
          .setIdentity(identity)
          .setMethod(method)
          .setReference(reference)
          .setCustom(custom)
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
}
