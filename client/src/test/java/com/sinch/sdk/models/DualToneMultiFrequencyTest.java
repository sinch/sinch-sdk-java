package com.sinch.sdk.models;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;
import org.junit.jupiter.api.Test;

class DualToneMultiFrequencyTest {

  String dtfm = "ww1234#w#";
  Collection<String> valid = Arrays.asList(dtfm, "ww123456789#w#0");

  Collection<String> invalid = Arrays.asList(" ", "-", "W#", "wh", "ww1234#w-#");

  @Test
  void stringValue() {
    assertEquals(new DualToneMultiFrequency(dtfm).stringValue(), dtfm);
  }

  @Test
  void valueOf() {
    assertEquals(DualToneMultiFrequency.valueOf(dtfm), new DualToneMultiFrequency(dtfm));
  }

  @Test
  void throwExceptionOnInvalid() {
    String value = "my invalid value";
    Exception exception =
        assertThrows(IllegalArgumentException.class, () -> DualToneMultiFrequency.valueOf(value));
    assertTrue(
        exception.getMessage().contains(value),
        String.format("'%s' should contains '%s'", exception.getMessage(), value));
  }

  @Test
  void noExceptionOnRelax() {
    String value = "my invalid value";
    DualToneMultiFrequency.setStrict(false);
    assertEquals(DualToneMultiFrequency.valueOf(value).stringValue(), value);
    DualToneMultiFrequency.setStrict(true);
  }

  @Test
  void validateTrue() {
    valid.forEach(
        f -> assertTrue(DualToneMultiFrequency.validate(f), String.format("'%s' is valid", f)));
  }

  @Test
  void validateFalse() {
    invalid.forEach(
        f -> assertFalse(DualToneMultiFrequency.validate(f), String.format("'%s' is invalid", f)));
  }
}
