package com.sinch.sdk.models;

/**
 * Strategy used to compute the delay before retrying a rate-limited request: the {@code
 * Retry-After} header the server sent, a client-side exponential backoff, or neither.
 *
 * @see RetryConfiguration
 * @since 2.2
 */
public enum RetryPolicy {

  /** Honor {@code Retry-After} when the response carries a usable one, otherwise back off. */
  DEFAULT,

  /** Honor {@code Retry-After} only: without a usable one, the response is not retried. */
  RETRY_AFTER,

  /** Exponential backoff only: any {@code Retry-After} header is ignored. */
  BACKOFF,

  /** Disable retries. The rate-limited response is returned to the caller as-is. */
  NONE
}
