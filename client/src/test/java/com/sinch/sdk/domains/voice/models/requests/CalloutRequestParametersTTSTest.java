package com.sinch.sdk.domains.voice.models.requests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.sinch.sdk.domains.voice.models.CalloutMethodType;
import com.sinch.sdk.models.E164PhoneNumber;
import org.junit.jupiter.api.Test;

public class CalloutRequestParametersTTSTest {

  public static final CalloutRequestParametersTTS ttsRequestParameters =
      CalloutRequestParametersTTS.builder()
          .setDestination(DestinationNumber.valueOf("+14045005000"))
          .setCli(E164PhoneNumber.valueOf("+14045001000"))
          .setDtfm("dtfm value")
          .setEnableAce(Boolean.TRUE)
          .setEnableDice(Boolean.TRUE)
          .setEnablePie(Boolean.TRUE)
          .setLocale("en-US")
          .setCustom("my custom value")
          .setDomain(DomainType.PSTN)
          .setText("text value")
          .setPrompts(
              "#ssml[<speak><p>Your PIN code is <say-as"
                  + " interpret-as=\"digits\">1234</say-as></p><p>Please enter it now</p></speak>]")
          .build();

  @Test
  void destinationRequired() {

    Exception exception =
        assertThrows(
            NullPointerException.class,
            () -> {
              CalloutRequestParametersConference.builder().setConferenceId("foo").build();
            });
    assertTrue(exception.getMessage().contains("destination"));
  }

  @Test
  void destination() {
    assertEquals(DestinationNumber.valueOf("+14045005000"), ttsRequestParameters.getDestination());
  }

  @Test
  void getMethod() {
    assertEquals(CalloutMethodType.TTS_CALLOUT, ttsRequestParameters.getMethod());
  }

  @Test
  void getDestination() {
    assertEquals(DestinationNumber.valueOf("+14045005000"), ttsRequestParameters.getDestination());
  }

  @Test
  void getCli() {
    assertEquals(E164PhoneNumber.valueOf("+14045001000"), ttsRequestParameters.getCli().get());
  }

  @Test
  void getDtfm() {
    assertEquals("dtfm value", ttsRequestParameters.getDtfm().get());
  }

  @Test
  void getCustom() {
    assertEquals("my custom value", ttsRequestParameters.getCustom().get());
  }

  @Test
  void getEnableAce() {
    assertEquals(Boolean.TRUE, ttsRequestParameters.getEnableAce().get());
  }

  @Test
  void getEnableDice() {
    assertEquals(Boolean.TRUE, ttsRequestParameters.getEnableDice().get());
  }

  @Test
  void getEnablePie() {
    assertEquals(Boolean.TRUE, ttsRequestParameters.getEnablePie().get());
  }

  @Test
  void getLocale() {
    assertEquals("en-US", ttsRequestParameters.getLocale().get());
  }

  @Test
  void getDomain() {
    assertEquals(DomainType.PSTN, ttsRequestParameters.getDomain().get());
  }

  @Test
  void getText() {
    assertEquals("text value", ttsRequestParameters.getText().get());
  }

  @Test
  void getPrompts() {
    assertEquals(
        "#ssml[<speak><p>Your PIN code is <say-as"
            + " interpret-as=\"digits\">1234</say-as></p><p>Please enter it now</p></speak>]",
        ttsRequestParameters.getPrompts().get());
  }
}
