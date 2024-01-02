package com.sinch.sdk.domains.verification.models.requests;

import com.sinch.sdk.domains.verification.models.VerificationMethodType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class VerificationReportFlashCallRequestParametersTest {

  final String cli = "foo cli";

  final VerificationReportFlashCallRequestParameters value =
      VerificationReportFlashCallRequestParameters.builder().setCli(cli).build();

  @Test
  void getMethod() {
    Assertions.assertThat(value.getMethod().get()).isEqualTo(VerificationMethodType.FLASH_CALL);
  }

  @Test
  void getCli() {
    Assertions.assertThat(value.getCli().get()).isEqualTo(cli);
  }
}
