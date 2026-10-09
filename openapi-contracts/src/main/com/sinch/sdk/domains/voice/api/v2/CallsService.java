package com.sinch.sdk.domains.voice.api.v2;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.voice.models.v2.Call;
import com.sinch.sdk.domains.voice.models.v2.calls.request.CallPatchRequest;
import com.sinch.sdk.domains.voice.models.v2.calls.request.ListCallsQueryParameters;
import com.sinch.sdk.domains.voice.models.v2.calls.request.StartCallQueryParameters;
import com.sinch.sdk.domains.voice.models.v2.calls.request.StartCallRequest;
import com.sinch.sdk.domains.voice.models.v2.calls.response.CallsListResponse;
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

  /**
   * Retrieve call details by call ID
   *
   * <p>Retrieve detailed information about a specific call using its unique identifier.
   *
   * @param callId The ID of the call. (required)
   * @return Call
   * @throws ApiException if fails to make API call
   * @since 2.3
   */
  Call get(String callId) throws ApiException;

  /**
   * List calls made with Sinch Voice API
   *
   * <p>List and filter calls made with Sinch
   *
   * @return CallsListResponse
   * @throws ApiException if fails to make API call
   * @since 2.3
   */
  CallsListResponse list() throws ApiException;

  /**
   * List calls made with Sinch Voice API
   *
   * <p>List and filter calls made with Sinch
   *
   * @param queryParameter (optional)
   * @return CallsListResponse
   * @throws ApiException if fails to make API call
   * @since 2.3
   */
  CallsListResponse list(ListCallsQueryParameters queryParameter) throws ApiException;

  /**
   * Patch an ongoing call by call ID
   *
   * <p>Interact with an ongoing call by submitting a set of SVAML commands. Use this to force
   * disconnect, play messages, bridge with another call, or perform other call control actions.
   *
   * @param callId The ID of the call. (required)
   * @param callPatchRequest The SVAML commands to apply to the call (required)
   * @throws ApiException if fails to make API call
   * @since 2.3
   */
  void interactByCallId(String callId, CallPatchRequest callPatchRequest) throws ApiException;

  /**
   * Patch an ongoing call by session ID and call name
   *
   * <p>Interact with an ongoing call identified by its session and call name by submitting a set of
   * SVAML commands. Use this to force disconnect, play messages, bridge with another call, or
   * perform other call control actions.
   *
   * @param sessionId The ID of the session. (required)
   * @param callName The name of the call leg within the session, as assigned by the <code>callName
   *     </code> property in the <code>dial</code> command. (required)
   * @param callPatchRequest The SVAML commands to apply to the call (required)
   * @throws ApiException if fails to make API call
   * @since 2.3
   */
  void interactByCallName(String sessionId, String callName, CallPatchRequest callPatchRequest)
      throws ApiException;
}
