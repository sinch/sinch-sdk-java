package com.sinch.sdk.domains.voice.api.v2;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.voice.models.v2.batches.request.StartBatchRequest;
import com.sinch.sdk.domains.voice.models.v2.batches.response.StartBatchResponse;

/** Batches Service */
public interface BatchesService {

  /**
   * Create and initiate a batch of outbound voice calls
   *
   * <p>Create a batch of outbound calls associated to the project's default service or to the
   * service specified by {@link StartBatchRequest#getServiceId()}. One call is queued for each
   * entry in {@link StartBatchRequest#getParameters()}.
   *
   * <p>Uses the same API operation as {@link CallsService#start}.
   *
   * @param startBatchRequest The SVAML commands describing the call flow, the parameter sets and
   *     batch options, plus the optional service ID and idempotency key (required)
   * @return StartBatchResponse
   * @throws ApiException if fails to make API call
   * @since 2.3
   */
  StartBatchResponse start(StartBatchRequest startBatchRequest) throws ApiException;
}
