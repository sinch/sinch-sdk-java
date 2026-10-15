package com.sinch.sdk.domains.voice.models.v2.calls.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Response returned after starting a single outbound call.
 *
 * <p>Contains the ID of the created call session and of the project and service it belongs to.
 */
@JsonDeserialize(builder = StartCallResponseImpl.Builder.class)
public interface StartCallResponse {

  /**
   * The ID of the project.
   *
   * <p>Field is required
   *
   * @return projectId
   */
  String getProjectId();

  /**
   * The ID of the service.
   *
   * <p>Field is required
   *
   * @return serviceId
   */
  String getServiceId();

  /**
   * The ID of the call session.
   *
   * <p>Field is required
   *
   * @return sessionId
   */
  String getSessionId();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new StartCallResponseImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param projectId see getter
     * @return Current builder
     * @see #getProjectId
     */
    Builder setProjectId(String projectId);

    /**
     * see getter
     *
     * @param serviceId see getter
     * @return Current builder
     * @see #getServiceId
     */
    Builder setServiceId(String serviceId);

    /**
     * see getter
     *
     * @param sessionId see getter
     * @return Current builder
     * @see #getSessionId
     */
    Builder setSessionId(String sessionId);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    StartCallResponse build();
  }
}
