package com.sinch.sdk.http;

import com.sinch.sdk.core.http.HttpClient;
import java.util.Optional;

/**
 * Implemented by an {@link HttpClient} that knows which retry policy it is working under, so that
 * anything sending requests through it can follow that same policy rather than quietly falling back
 * to the defaults. {@link com.sinch.sdk.auth.adapters.OAuthManager} relies on this to retry the
 * token exchange under whatever was configured on the client, and to share that budget rather than
 * opening a second one of its own.
 *
 * @since 2.2
 */
public interface RetryCapable {

  /**
   * Retry policy this client applies.
   *
   * @return Manager in use, or empty when the client deliberately carries none and nothing is to be
   *     retried
   * @since 2.2
   */
  Optional<RetryManager> getRetryManager();
}
