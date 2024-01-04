package com.sinch.sdk.models;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;
import org.junit.jupiter.api.Test;

class E164PhoneNumberTest {

  String phoneNumber = "+123456789";
  Collection<String> validNumbers =
      Arrays.asList(
          phoneNumber,
          "+13172222222",
          "+1447851987654",
          "+1 44 7851 987654",
          "+1 3172222222",
          "+1 33 628254417");

  Collection<String> invalidNumbers =
      Arrays.asList("text value", "1447851987654", "+", "+1123", "+11234");

  @Test
  void stringValue() {
    assertEquals(new E164PhoneNumber(phoneNumber).stringValue(), phoneNumber);
  }

  @Test
  void valueOf() {
    assertEquals(E164PhoneNumber.valueOf(phoneNumber), new E164PhoneNumber(phoneNumber));
  }

  @Test
  void throwExceptionOnInvalid() {
    String value = "my invalid value";
    Exception exception =
        assertThrows(NumberFormatException.class, () -> E164PhoneNumber.valueOf(value));
    assertTrue(
        exception.getMessage().contains(value),
        String.format("'%s' should contains '%s'", exception.getMessage(), value));
  }

  @Test
  void validateTrue() {
    validNumbers.forEach(
        f -> assertTrue(E164PhoneNumber.validate(f), String.format("'%s' is valid", f)));
  }

  @Test
  void validateFalse() {
    invalidNumbers.forEach(
        f -> assertFalse(E164PhoneNumber.validate(f), String.format("'%s' is invalid", f)));
  }
}
