package com.sinch.sdk.domains.voice.models.v2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class VoiceRegionTest {

  @Test
  void fromValue() {
    assertEquals(VoiceRegion.AUSTRALIA, VoiceRegion.from("au1"));
  }

  @Test
  void fromName() {
    assertEquals(VoiceRegion.GLOBAL, VoiceRegion.from("GLOBAL"));
    assertEquals(VoiceRegion.NORTH_AMERICA, VoiceRegion.from("NORTH_AMERICA"));
    assertEquals(VoiceRegion.SOUTH_AMERICA, VoiceRegion.from("SOUTH_AMERICA"));
    assertEquals(VoiceRegion.EUROPE, VoiceRegion.from("EUROPE"));
    assertEquals(VoiceRegion.ASIA_PACIFIC, VoiceRegion.from("ASIA_PACIFIC"));
    assertEquals(VoiceRegion.AUSTRALIA, VoiceRegion.from("AUSTRALIA"));
  }

  @Test
  void fromNameIsCaseInsensitive() {
    assertEquals(VoiceRegion.AUSTRALIA, VoiceRegion.from("australia"));
  }

  @Test
  void fromUnknownValue() {
    assertEquals("foo", VoiceRegion.from("foo").value());
  }

  @Test
  void fromNull() {
    assertNull(VoiceRegion.from(null));
  }
}
