package com.sinch.sdk.core.http;

import java.util.UUID;
import java.util.logging.Logger;

/**
 * Keys for the operations that accept an <code>Idempotency-Key</code> header.
 *
 * <p>A key identifies one operation: it is sent again on the retries of that operation and never
 * reused for another one.
 *
 * @since 2.3
 */
public final class IdempotencyKey {

  private static final Logger LOGGER = Logger.getLogger(IdempotencyKey.class.getName());

  /** Name of the HTTP header carrying the key */
  public static final String HEADER = "Idempotency-Key";

  private IdempotencyKey() {}

  /**
   * Generate a new key: a random UUID, as recommended by the Sinch API standards.
   *
   * @return A new key, to use for one operation and its retries
   */
  public static String generate() {
    String key = UUID.randomUUID().toString();
    LOGGER.fine("Generated idempotency key: " + key);
    return key;
  }
}
