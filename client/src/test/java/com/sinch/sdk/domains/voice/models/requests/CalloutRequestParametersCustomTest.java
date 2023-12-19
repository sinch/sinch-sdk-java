package com.sinch.sdk.domains.voice.models.requests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.sinch.sdk.domains.voice.models.CalloutMethodType;
import com.sinch.sdk.models.E164PhoneNumber;
import org.junit.jupiter.api.Test;

public class CalloutRequestParametersCustomTest {

  public static final CalloutRequestParametersCustom customRequestParameters =
      CalloutRequestParametersCustom.builder()
          .setDestination(DestinationNumber.valueOf("+14045005000"))
          .setCli(E164PhoneNumber.valueOf("+14045001000"))
          .setCustom("my custom value")
          .setDtfm("dtfm value")
          .setMaxDuration(32)
          .setIce(
              "{\"action\": {\"name\": \"connectPstn\", \"number\": \"+12233445566\", \"cli\":"
                  + " \"+12234325234\", \"amd\": {\"enabled\": \"true\"}}}")
          .setAce(
              "{\"instructions\": [{\"name\": \"say\", \"text\": \"Hello, this is a call from"
                  + " Sinch!\"}], \"action\": {\"name\": \"hangup\"}}")
          .setPie("https://your-application-server-host/application")
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
  void getMethod() {
    assertEquals(CalloutMethodType.CUSTOM_CALLOUT, customRequestParameters.getMethod());
  }

  @Test
  void getDestination() {
    assertEquals(
        DestinationNumber.valueOf("+14045005000"), customRequestParameters.getDestination());
  }

  @Test
  void getCli() {
    assertEquals(E164PhoneNumber.valueOf("+14045001000"), customRequestParameters.getCli().get());
  }

  @Test
  void getDtfm() {
    assertEquals("dtfm value", customRequestParameters.getDtfm().get());
  }

  @Test
  void getCustom() {
    assertEquals("my custom value", customRequestParameters.getCustom().get());
  }

  @Test
  void getIce() {
    assertEquals(
        "{\"action\": {\"name\": \"connectPstn\", \"number\": \"+12233445566\", \"cli\":"
            + " \"+12234325234\", \"amd\": {\"enabled\": \"true\"}}}",
        customRequestParameters.getIce().get());
  }

  @Test
  void getAce() {
    assertEquals(
        "{\"instructions\": [{\"name\": \"say\", \"text\": \"Hello, this is a call from Sinch!\"}],"
            + " \"action\": {\"name\": \"hangup\"}}",
        customRequestParameters.getAce().get());
  }

  @Test
  void getPie() {
    assertEquals(
        "https://your-application-server-host/application", customRequestParameters.getPie().get());
  }
}
