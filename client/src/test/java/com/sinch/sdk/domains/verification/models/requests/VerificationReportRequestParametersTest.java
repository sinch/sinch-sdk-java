package com.sinch.sdk.domains.verification.models.requests;

import com.sinch.sdk.domains.verification.models.VerificationMethodType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class VerificationReportRequestParametersTest {

  final VerificationMethodType method = VerificationMethodType.CALLOUT;

  final VerificationReportRequestParameters value =
      VerificationReportRequestParameters.builder().setMethod(method).build();

  @Test
  void getMethod() {
    Assertions.assertThat(value.getMethod().get()).isEqualTo(method);
  }
}
