package com.sinch.sdk.domains.voice.adapters.converters;

import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.voice.models.dto.v1.CalloutRequestDtoTest;
import com.sinch.sdk.domains.voice.models.requests.CalloutRequestParametersConferenceTest;
import com.sinch.sdk.domains.voice.models.requests.CalloutRequestParametersCustomTest;
import com.sinch.sdk.domains.voice.models.requests.CalloutRequestParametersTTSTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@TestWithResources
public class CalloutsDtoConverterTest extends BaseTest {

  @Test
  void convertConferenceCallRequest() {

    Assertions.assertThat(
            CalloutsDtoConverter.convert(
                CalloutRequestParametersConferenceTest.conferenceRequestParameters))
        .usingRecursiveComparison()
        .isEqualTo(CalloutRequestDtoTest.conferenceRequestCalloutDto);
  }

  @Test
  void convertTTSCallRequest() {

    Assertions.assertThat(
            CalloutsDtoConverter.convert(CalloutRequestParametersTTSTest.ttsRequestParameters))
        .usingRecursiveComparison()
        .isEqualTo(CalloutRequestDtoTest.ttsRequestDto);
  }

  @Test
  void convertCustomCallRequest() {

    Assertions.assertThat(
            CalloutsDtoConverter.convert(
                CalloutRequestParametersCustomTest.customRequestParameters))
        .usingRecursiveComparison()
        .isEqualTo(CalloutRequestDtoTest.customRequestDto);
  }

  @Test
  void convertCallResponse() {

    Assertions.assertThat(
            CalloutsDtoConverter.convert(
                CalloutRequestParametersConferenceTest.conferenceRequestParameters))
        .usingRecursiveComparison()
        .isEqualTo(CalloutRequestDtoTest.conferenceRequestCalloutDto);
  }
}
