package com.sinch.sdk.core.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Instant;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Test;

class DateUtilTest {

  @Test
  void toInstantNullGuard() {
    Instant instant = DateUtil.toInstant(null);
    assertNull(instant);
  }

  @Test
  void toInstantFromOffset() {
    Instant instant = DateUtil.toInstant(OffsetDateTime.parse("2024-05-04T10:00:00+02"));
    assertEquals("2024-05-04T08:00:00Z", instant.toString());
  }

  @Test
  void toInstantFromUTC() {
    Instant instant = DateUtil.toInstant(OffsetDateTime.parse("2024-05-04T10:00:00Z"));
    assertEquals("2024-05-04T10:00:00Z", instant.toString());
  }

  @Test
  void failSafeTimeStampNullGuard() {
    Instant instant = DateUtil.failSafeTimeStampToInstant(null);
    assertNull(instant);
  }

  @Test
  void failSafeTimeStampNoTZ() {
    Instant instant = DateUtil.failSafeTimeStampToInstant("2024-05-04T10:00:00.1234");
    assertEquals("2024-05-04T10:00:00.123400Z", instant.toString());
  }

  @Test
  void failSafeTimeStampFromOffset() {
    Instant instant = DateUtil.failSafeTimeStampToInstant("2024-05-04T10:00:00.1234+02");
    assertEquals("2024-05-04T08:00:00.123400Z", instant.toString());
  }

  @Test
  void failSafeTimeStampFromUTC() {
    Instant instant = DateUtil.failSafeTimeStampToInstant("2024-05-04T10:00:00.1234Z");
    assertEquals("2024-05-04T10:00:00.123400Z", instant.toString());
  }
}
