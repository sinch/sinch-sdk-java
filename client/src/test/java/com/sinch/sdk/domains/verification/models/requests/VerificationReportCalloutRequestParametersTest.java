package com.sinch.sdk.domains.verification.models.requests;

import com.sinch.sdk.domains.verification.models.VerificationMethodType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class VerificationReportCalloutRequestParametersTest {

  final String code = "foo code";

  final VerificationReportCalloutRequestParameters value =
      VerificationReportCalloutRequestParameters.builder().setCode(code).build();

  @Test
  void getMethod() {
    Assertions.assertThat(value.getMethod().get()).isEqualTo(VerificationMethodType.CALLOUT);
  }

  @Test
  void getCode() {
    Assertions.assertThat(value.getCode().get()).isEqualTo(code);
  }
}
