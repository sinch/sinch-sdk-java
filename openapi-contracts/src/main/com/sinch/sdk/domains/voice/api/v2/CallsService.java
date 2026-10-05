package com.sinch.sdk.domains.voice.api.v2;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.voice.models.v2.calls.request.StartCallQueryParameters;
import com.sinch.sdk.domains.voice.models.v2.calls.request.StartCallRequest;
import com.sinch.sdk.domains.voice.models.v2.calls.response.StartCallResponse;

/** Calls Service */
public interface CallsService {

  /**
   * Create and initiate a new outbound voice call, associated to the project's default service
   *
   * @param startCallRequest The call to start (required)
   * @return StartCallResponse
   * @throws ApiException if fails to make API call
   * @since 2.3
   */
  StartCallResponse start(StartCallRequest startCallRequest) throws ApiException;

  /**
   * Create and initiate a new outbound voice call
   *
   * <p>Create a new outbound call associated to the project's default service or to the service
   * specified by {@link StartCallQueryParameters#getServiceId()}.
   *
   * @param queryParameter (optional)
   * @param startCallRequest The call to start (required)
   * @return StartCallResponse
   * @throws ApiException if fails to make API call
   * @since 2.3
   */
  StartCallResponse start(
      StartCallQueryParameters queryParameter, StartCallRequest startCallRequest)
      throws ApiException;
}
