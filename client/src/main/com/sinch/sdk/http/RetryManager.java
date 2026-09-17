package com.sinch.sdk.http;

import com.sinch.sdk.core.http.HttpResponse;
import com.sinch.sdk.models.RetryConfiguration;
import com.sinch.sdk.models.RetryPolicy;
import java.util.concurrent.Callable;

/**
 * Applies a retry policy to a request. {@link DefaultRetryManager} is the implementation the SDK
 * ships with; an HTTP client supplied by the caller can provide its own if implementing the {@link
 * RetryCapable} interface.
 *
 * @since 2.2
 */
public interface RetryManager {

  /** Applied to a client that carries no manager of its own. */
  RetryManager DEFAULTS = new DefaultRetryManager(RetryConfiguration.DEFAULTS);

  /** Applied to a client that deliberately carries none, so nothing is retried. */
  RetryManager NO_RETRY =
      new DefaultRetryManager(
          RetryConfiguration.builder().setRetryPolicy(RetryPolicy.NONE).build());

  /**
   * Retry policy in use.
   *
   * @return Configuration applied to rate-limited responses
   * @since 2.2
   */
  RetryConfiguration getRetryConfiguration();

  /**
   * Performs the request, retrying a rate-limited response for as long as the policy allows.
   *
   * @param call The request to perform
   * @return The response of the last attempt
   * @throws Exception Whatever the request itself throws
   * @since 2.2
   */
  HttpResponse execute(Callable<HttpResponse> call) throws Exception;
}
