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
  void failSafeTimeStampFromBlankString() {
    Instant instant = DateUtil.failSafeTimeStampToInstant("    ");
    assertNull(instant);
  }

  @Test
  void failSafeTimeStampFromStringWithBlanks() {
    Instant instant = DateUtil.failSafeTimeStampToInstant("  2024-05-04T10:00:00.1234   ");
    assertEquals("2024-05-04T10:00:00.123400Z", instant.toString());
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
  void failSafeTimeStampInvalid() {
    Instant instant = DateUtil.failSafeTimeStampToInstant("2024 05 04 10 00 00 1234 ");
    assertNull(instant);
  }

  @Test
  void failSafeTimeFromUnixTimeStamp() {
    Instant instant = DateUtil.failSafeTimeStampToInstant("1741934627");
    assertEquals("2025-03-14T06:43:47Z", instant.toString());
  }

  @Test
  void RFC822NullGuard() {
    Instant instant = DateUtil.RFC822StringToInstant(null);
    assertNull(instant);
  }

  @Test
  void RFC822FromBlankString() {
    Instant instant = DateUtil.RFC822StringToInstant("    ");
    assertNull(instant);
  }

  @Test
  void RFC822FromStringWithBlanks() {
    Instant instant = DateUtil.RFC822StringToInstant("  Mon, 2 Jan 2006 15:04:05 GMT  ");
    assertEquals("2006-01-02T15:04:05Z", instant.toString());
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
  void RFC822WithOffset() {
    Instant instant = DateUtil.RFC822StringToInstant("Mon, 2 Jan 2006 15:04:05 +0100");
    assertEquals("2006-01-02T14:04:05Z", instant.toString());
  }

  @Test
  void RFC822NoOffset() {
    Instant instant = DateUtil.RFC822StringToInstant("Mon, 2 Jan 2006 15:04:05");
    assertEquals("2006-01-02T15:04:05Z", instant.toString());
  }

  @Test
  void RFC822Invalid() {
    // 12th of January 2006 is not a Monday (it was a Thursday)
    Instant instant = DateUtil.RFC822StringToInstant("Mon, 12 Jan 2006 15:04:05 +0100");
    assertNull(instant);
  }

  @Test
  void RFC7231AcceptsTheThreeRequiredFormats() {
    // the three spellings RFC 7231 section 7.1.1.1 requires a recipient to accept
    assertEquals(
        "1994-11-06T08:49:37Z",
        DateUtil.RFC7231StringToInstant("Sun, 06 Nov 1994 08:49:37 GMT").toString());
    assertEquals(
        "1994-11-06T08:49:37Z",
        DateUtil.RFC7231StringToInstant("Sunday, 06-Nov-94 08:49:37 GMT").toString());
    assertEquals(
        "1994-11-06T08:49:37Z",
        DateUtil.RFC7231StringToInstant("Sun Nov  6 08:49:37 1994").toString());
  }

  @Test
  void RFC7231ResolvesTwoDigitYearsIntoThePast() {
    // "94" must resolve to 1994, not 2094: the accepted window ends 50 years from now
    Instant instant = DateUtil.RFC7231StringToInstant("Sunday, 06-Nov-94 08:49:37 GMT");
    assertTrue(instant.isBefore(Instant.now()), "expected a past date, got: " + instant);
  }

  @Test
  void RFC7231AcceptsATwoDigitDayInAsctime() {
    assertEquals(
        "1994-11-16T08:49:37Z",
        DateUtil.RFC7231StringToInstant("Wed Nov 16 08:49:37 1994").toString());
  }

  @Test
  void RFC7231RejectsAnythingElse() {
    assertNull(DateUtil.RFC7231StringToInstant(null));
    assertNull(DateUtil.RFC7231StringToInstant("   "));
    assertNull(DateUtil.RFC7231StringToInstant("not-a-date"));
    // 12th of January 2006 is not a Monday (it was a Thursday)
    assertNull(DateUtil.RFC7231StringToInstant("Mon, 12 Jan 2006 15:04:05 GMT"));
  }
}
