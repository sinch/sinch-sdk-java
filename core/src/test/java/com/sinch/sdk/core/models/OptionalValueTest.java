package com.sinch.sdk.core.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Test;

class OptionalValueTest {

  @Test
  void empty() {
    assertFalse(OptionalValue.empty().isPresent());
    NoSuchElementException thrown =
        assertThrows(
            NoSuchElementException.class,
            () -> OptionalValue.empty().get(),
            "Expected OptionalValue.empty().get() to throw, but it didn't");
    assertTrue(thrown.getMessage().contains("No value present"));
  }

  @Test
  void ofNull() {
    OptionalValue<String> value = OptionalValue.of(null);
    assertTrue(value.isPresent());
    assertNull(value.get());
  }

  @Test
  void of() {
    OptionalValue<String> value = OptionalValue.of("my value");
    assertTrue(value.isPresent());
    assertEquals("my value", value.get());
  }

  @Test
  void ifPresentTrue() {
    OptionalValue<String> value = OptionalValue.of("my value");
    AtomicBoolean initited = new AtomicBoolean(false);
    value.ifPresent(f -> initited.set(true));
    assertTrue(initited.get());
  }

  @Test
  void ifPresentFalse() {
    OptionalValue<String> value = OptionalValue.empty();
    AtomicBoolean initited = new AtomicBoolean(false);
    value.ifPresent(f -> initited.set(true));
    assertFalse(initited.get());
  }

  @Test
  void ifPresentOrElseTrue() {
    OptionalValue<String> value = OptionalValue.of("my value");
    AtomicInteger initited = new AtomicInteger();
    value.ifPresentOrElse(f -> initited.set(1), () -> initited.set(0));
    assertEquals(1, initited.get());
  }

  @Test
  void ifPresentOrElseFalse() {
    OptionalValue<String> value = OptionalValue.empty();
    AtomicInteger initited = new AtomicInteger();
    value.ifPresentOrElse(f -> initited.set(1), () -> initited.set(0));
    assertEquals(0, initited.get());
  }

  @Test
  void orElseTrue() {
    OptionalValue<String> value = OptionalValue.of("my value");
    assertEquals("my value", value.orElse("else value"));
  }

  @Test
  void orElseFalse() {
    OptionalValue<String> value = OptionalValue.empty();
    assertEquals("else value", value.orElse("else value"));
  }

  @Test
  void orElseGetTrue() {
    OptionalValue<String> value = OptionalValue.of("my value");
    assertEquals("my value", value.orElseGet(() -> "else value"));
  }

  @Test
  void orElseGetFalse() {
    OptionalValue<String> value = OptionalValue.empty();
    assertEquals("else value", value.orElseGet(() -> "else value"));
  }

  @Test
  void orElseThrowTrue() {
    OptionalValue<String> value = OptionalValue.of("my value");
    assertEquals("my value", value.orElseThrow(IllegalAccessError::new));
  }

  @Test
  void orElseThrowFalse() {
    OptionalValue<String> value = OptionalValue.empty();

    assertThrows(
        IllegalAccessError.class,
        () -> value.orElseThrow(IllegalAccessError::new),
        "Expected .orElseThrow() to throw, but it didn't");
  }

  @Test
  void orElseThrowSupplierTrue() {
    OptionalValue<String> value = OptionalValue.of("my value");
    assertEquals("my value", value.orElseThrow(() -> new IllegalAccessError("foo")));
  }

  @Test
  void orElseThrowSupplierFalse() {
    OptionalValue<String> value = OptionalValue.empty();
    assertThrows(
        IllegalAccessError.class,
        () -> value.orElseThrow(() -> new IllegalAccessError("foo")),
        "Expected .orElseThrow() to throw, but it didn't");
  }
}
