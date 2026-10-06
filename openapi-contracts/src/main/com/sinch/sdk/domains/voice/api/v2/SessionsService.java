package com.sinch.sdk.domains.voice.api.v2;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.voice.models.v2.sessions.response.Session;

/** Sessions Service */
public interface SessionsService {

  /**
   * Get a session details by the session ID
   *
   * <p>Retrieve detailed information about a specific session, including all associated calls and
   * their current states. Sessions represent the complete interaction lifecycle and can contain
   * multiple related calls.
   *
   * @param sessionId The ID of the session (required)
   * @return Session
   * @throws ApiException if fails to make API call
   * @since 2.3
   */
  Session get(String sessionId) throws ApiException;
}
