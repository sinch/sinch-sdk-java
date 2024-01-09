package com.sinch.sdk.domains.voice.models.requests;

import static org.junit.jupiter.api.Assertions.*;

import com.sinch.sdk.domains.voice.models.CalloutMethodType;
import com.sinch.sdk.domains.voice.models.ConferenceDtfmOptions;
import com.sinch.sdk.domains.voice.models.DestinationNumber;
import com.sinch.sdk.domains.voice.models.DomainType;
import com.sinch.sdk.domains.voice.models.DtfmModeType;
import com.sinch.sdk.domains.voice.models.MohClassType;
import com.sinch.sdk.models.DualToneMultiFrequency;
import com.sinch.sdk.models.E164PhoneNumber;
import org.junit.jupiter.api.Test;

public class CalloutRequestParametersConferenceTest {

  static final ConferenceDtfmOptions dtfmOptions =
      ConferenceDtfmOptions.builder()
          .setMode(DtfmModeType.DETECT)
          .setMaxDigits(3)
          .setTimeoutMills(456)
          .build();
  public static final CalloutRequestParametersConference conferenceRequestParameters =
      CalloutRequestParametersConference.builder()
          .setDestination(DestinationNumber.valueOf("+14045005000"))
          .setConferenceId("MyConfId")
          .setCli(E164PhoneNumber.valueOf("+14045001000"))
          .setDtfmOptions(dtfmOptions)
          .setDtfm(DualToneMultiFrequency.valueOf("w123#"))
          .setMaxDuration(32)
          .setEnableAce(Boolean.TRUE)
          .setEnableDice(Boolean.TRUE)
          .setEnablePie(Boolean.TRUE)
          .setLocale("en-US")
          .setGreeting("Welcome to my conference")
          .setMohClass(MohClassType.MUSIC2)
          .setCustom("my custom value")
          .setDomain(DomainType.PSTN)
          .build();

  @Test
  void getMethod() {
    assertEquals(
        CalloutMethodType.CONFERENCE_CALLOUT, conferenceRequestParameters.getMethod().get());
  }

  @Test
  void getDestination() {
    assertEquals(
        DestinationNumber.valueOf("+14045005000"),
        conferenceRequestParameters.getDestination().get());
  }

  @Test
  void getCli() {
    assertEquals(
        E164PhoneNumber.valueOf("+14045001000"), conferenceRequestParameters.getCli().get());
  }

  @Test
  void getDtfm() {
    assertEquals("w123#", conferenceRequestParameters.getDtfm().get().stringValue());
  }

  @Test
  void getCustom() {
    assertEquals("my custom value", conferenceRequestParameters.getCustom().get());
  }

  @Test
  void getConferenceId() {
    assertEquals("MyConfId", conferenceRequestParameters.getConferenceId().get());
  }

  @Test
  void getDtfmOptions() {
    assertEquals(dtfmOptions, conferenceRequestParameters.getDtfmOptions().get());
  }

  @Test
  void getMaxDuration() {
    assertEquals(32, conferenceRequestParameters.getMaxDuration().get());
  }

  @Test
  void getEnableAce() {
    assertEquals(Boolean.TRUE, conferenceRequestParameters.getEnableAce().get());
  }

  @Test
  void getEnableDice() {
    assertEquals(Boolean.TRUE, conferenceRequestParameters.getEnableDice().get());
  }

  @Test
  void getEnablePie() {
    assertEquals(Boolean.TRUE, conferenceRequestParameters.getEnablePie().get());
  }

  @Test
  void getLocale() {
    assertEquals("en-US", conferenceRequestParameters.getLocale().get());
  }

  @Test
  void getGreeting() {
    assertEquals("Welcome to my conference", conferenceRequestParameters.getGreeting().get());
  }

  @Test
  void getMohClass() {
    assertEquals(MohClassType.MUSIC2, conferenceRequestParameters.getMohClass().get());
  }

  @Test
  void getDomain() {
    assertEquals(DomainType.PSTN, conferenceRequestParameters.getDomain().get());
  }
}
