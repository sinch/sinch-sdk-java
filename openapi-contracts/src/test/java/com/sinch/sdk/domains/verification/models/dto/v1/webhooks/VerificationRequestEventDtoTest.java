package com.sinch.sdk.domains.verification.models.dto.v1.webhooks;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.domains.verification.models.dto.v1.IdentityDto;
import com.sinch.sdk.domains.verification.models.dto.v1.PriceDto;
import com.sinch.sdk.domains.verification.models.dto.v1.VerificationRequestEventDto;
import java.util.Collections;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@TestWithResources
public class VerificationRequestEventDtoTest {

  @GivenJsonResource("/domains/verification/v1/webhooks/VerificationRequestEventDto.json")
  static VerificationRequestEventDto requestEventDto;

  public static VerificationRequestEventDto expectedRequestEventDto =
      new VerificationRequestEventDto()
          .id("1234567890")
          .event("VerificationRequestEvent")
          .method("sms")
          .identity(new IdentityDto().type("number").endpoint("+11235551234"))
          .reference("reference string")
          .custom("custom string")
          .price(new PriceDto().amount(10.5F).currencyId("USD"))
          .acceptLanguage(Collections.singletonList("es-ES"));

  @Test
  void deserialize() {
    Assertions.assertThat(requestEventDto)
        .usingRecursiveComparison()
        .isEqualTo(expectedRequestEventDto);
  }
}
