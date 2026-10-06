package com.sinch.sdk.domains.voice.api.v2;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.voice.models.v2.batches.request.StartBatchQueryParameters;
import com.sinch.sdk.domains.voice.models.v2.batches.request.StartBatchRequest;
import com.sinch.sdk.domains.voice.models.v2.batches.response.BatchDetails;
import com.sinch.sdk.domains.voice.models.v2.batches.response.BatchStopResponse;
import com.sinch.sdk.domains.voice.models.v2.batches.response.BatchSummary;
import com.sinch.sdk.domains.voice.models.v2.batches.response.StartBatchResponse;

/** Batches Service */
public interface BatchesService {

  /**
   * Create and initiate a batch of outbound voice calls, associated to the project's default
   * service
   *
   * <p>One call is queued for each entry in {@link StartBatchRequest#getParameters()}.
   *
   * <p>Uses the same API operation as {@link CallsService#start}.
   *
   * @param startBatchRequest The batch of calls to start (required)
   * @return StartBatchResponse
   * @throws ApiException if fails to make API call
   * @since 2.3
   */
  StartBatchResponse start(StartBatchRequest startBatchRequest) throws ApiException;

  /**
   * Create and initiate a batch of outbound voice calls
   *
   * <p>Create a batch of outbound calls associated to the project's default service or to the
   * service specified by {@link StartBatchQueryParameters#getServiceId()}. One call is queued for
   * each entry in {@link StartBatchRequest#getParameters()}.
   *
   * <p>Uses the same API operation as {@link CallsService#start}.
   *
   * @param queryParameter (optional)
   * @param startBatchRequest The batch of calls to start (required)
   * @return StartBatchResponse
   * @throws ApiException if fails to make API call
   * @since 2.3
   */
  StartBatchResponse start(
      StartBatchQueryParameters queryParameter, StartBatchRequest startBatchRequest)
      throws ApiException;

  /**
   * Get a batch summary
   *
   * <p>Retrieve a summary of a batch call operation, including statistics on completed,
   * in-progress, queued and expired call sessions.
   *
   * @param batchId The ID of the batch, as returned by {@link #start} (required)
   * @return BatchSummary
   * @throws ApiException if fails to make API call
   * @since 2.3
   */
  BatchSummary get(String batchId) throws ApiException;

  /**
   * Get batch details
   *
   * <p>Retrieve per-session details for a batch call operation, including the current state of each
   * call session in the batch.
   *
   * <p>Use this operation when individual session-level visibility is needed (for example, to
   * inspect which sessions are <code>QUEUED</code>, <code>IN_PROGRESS</code> or <code>COMPLETED
   * </code>). <code>EXPIRED</code> sessions are never returned because they were never initiated.
   *
   * @param batchId The ID of the batch, as returned by {@link #start} (required)
   * @return BatchDetails
   * @throws ApiException if fails to make API call
   * @since 2.3
   */
  BatchDetails getDetails(String batchId) throws ApiException;

  /**
   * Stop processing a batch of call sessions
   *
   * <p>Prevents any queued calls in the batch from being initiated. Calls that are already in
   * progress are not affected and continue until completion.
   *
   * @param batchId The ID of the batch, as returned by {@link #start} (required)
   * @return BatchStopResponse
   * @throws ApiException if fails to make API call
   * @since 2.3
   */
  BatchStopResponse stop(String batchId) throws ApiException;
}
