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

  @Test
  void RFC822NullGuard() {
    Instant instant = DateUtil.RFC822StringToInstant(null);
    assertNull(instant);
  }

  @Test
  void RFC822WithUnsupportedMST() {
    Instant instant = DateUtil.RFC822StringToInstant("Mon, 2 Jan 2006 15:04:05 MST");
    assertEquals("2006-01-02T22:04:05Z", instant.toString());
  }

  @Test
  void RFC822WithGMT() {
    Instant instant = DateUtil.RFC822StringToInstant("Mon, 2 Jan 2006 15:04:05 GMT");
    assertEquals("2006-01-02T15:04:05Z", instant.toString());
  }

  @Test
  void RFC822WithUnsupportedUT() {
    Instant instant = DateUtil.RFC822StringToInstant("Mon, 2 Jan 2006 15:04:05 UT");
    assertEquals("2006-01-02T15:04:05Z", instant.toString());
  }

  @Test
  void RFC822WithUnsupportedEST() {
    Instant instant = DateUtil.RFC822StringToInstant("Mon, 2 Jan 2006 15:04:05 EST");
    assertEquals("2006-01-02T20:04:05Z", instant.toString());
  }

  @Test
  void RFC822WithOffset() {
    Instant instant = DateUtil.RFC822StringToInstant("Mon, 2 Jan 2006 15:04:05 +0100");
    assertEquals("2006-01-02T14:04:05Z", instant.toString());
  }

  @Test
  void RFC822NoOffset() {
    Instant instant = DateUtil.RFC822StringToInstant("Mon, 2 Jan 2006 15:04:05");
    assertNull(instant);
  }

  @Test
  void RFC822Invalid() {
    // 12th of January 2006 is not a Monday (it was a Thursday)
    Instant instant = DateUtil.RFC822StringToInstant("Mon, 12 Jan 2006 15:04:05 +0100");
    assertNull(instant);
  }
}
