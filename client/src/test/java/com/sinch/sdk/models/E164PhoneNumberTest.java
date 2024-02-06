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
          "+11234567890",
          "+(1)1234567890",
          "+4407123456789",
          "+461234567890",
          "+13172222222",
          "+1447851987654",
          "+1 4478519876",
          "+33628254417",
          "+(33)628254417",
          "+(33) 628254417",
          "+33 628254417",
          "+6773771234");

  Collection<String> invalidNumbers =
      Arrays.asList("text value", "1447851987654", "+", "+1123", "+11234", "+03172222222");

  @Test
  void stringValue() {
    assertEquals(E164PhoneNumber.valueOf(phoneNumber).stringValue(), phoneNumber);
  }

  @Test
  void throwExceptionOnInvalid() {
    String value = "my invalid value";
    E164PhoneNumber.setStrict(true);
    Exception exception =
        assertThrows(NumberFormatException.class, () -> E164PhoneNumber.valueOf(value));
    E164PhoneNumber.setStrict(false);
    assertTrue(
        exception.getMessage().contains(value),
        String.format("'%s' should contains '%s'", exception.getMessage(), value));
  }

  @Test
  void noExceptionOnRelax() {
    String value = "my invalid value";
    E164PhoneNumber.setStrict(false);
    assertEquals(E164PhoneNumber.valueOf(value).stringValue(), value);
    E164PhoneNumber.setStrict(true);
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
