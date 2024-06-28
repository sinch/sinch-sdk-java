package com.sinch.sdk.domains.verification.models.requests;

import com.sinch.sdk.domains.verification.models.VerificationMethodType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class VerificationStatusSMSRequestParametersTest {

  final String code = "foo code";
  final String cli = "foo cli";

  final VerificationReportSMSRequestParameters value =
      VerificationReportSMSRequestParameters.builder().setCode(code).setCli(cli).build();

  @Test
  void getMethod() {
    Assertions.assertThat(value.getMethod().get()).isEqualTo(VerificationMethodType.SMS);
  }

  @Test
  void getCode() {
    Assertions.assertThat(value.getCode().get()).isEqualTo(code);
  }

  @Test
  void getCli() {
    Assertions.assertThat(value.getCli().get()).isEqualTo(cli);
  }
}
