package com.sinch.sdk.domains.voice.adapters.converters;

import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.voice.models.DestinationNumber;
import com.sinch.sdk.domains.voice.models.DestinationUser;
import com.sinch.sdk.domains.voice.models.DomainType;
import com.sinch.sdk.domains.voice.models.Price;
import com.sinch.sdk.domains.voice.models.dto.v1.CallsResponseDtoTest;
import com.sinch.sdk.domains.voice.models.response.CallInformation;
import com.sinch.sdk.domains.voice.models.response.CallReasonType;
import com.sinch.sdk.domains.voice.models.response.CallResultType;
import com.sinch.sdk.domains.voice.models.response.CallStatusType;
import java.time.Instant;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@TestWithResources
public class CallsDtoConverterTest extends BaseTest {

  public static CallInformation expectedCallInformation =
      CallInformation.builder()
          .setFrom(DestinationUser.valueOf("user name endpoint validation"))
          .setTo(DestinationNumber.valueOf("+33123456789"))
          .setDomain(DomainType.PSTN)
          .setCallId("a call UUID")
          .setDuration(138)
          .setStatus(CallStatusType.FINAL)
          .setResult(CallResultType.ANSWERED)
          .setReason(CallReasonType.CALLEEHANGUP)
          .setTimeStamp(Instant.parse("2024-01-08T09:48:12Z"))
          .setCustom("{}")
          .setUserRate(Price.builder().setCurrencyId("EUR").setAmount(0.1758F).build())
          .setDebit(Price.builder().setCurrencyId("EUR").setAmount(0.5274F).build())
          .build();

  @Test
  void callsGet() {

    Assertions.assertThat(
            CallsDtoConverter.convert(CallsResponseDtoTest.expectedCallsGetInformationResponseDto))
        .usingRecursiveComparison()
        .isEqualTo(expectedCallInformation);
  }
}
