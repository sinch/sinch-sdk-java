package com.sinch.sdk.domains.voice.models.v2.batches.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Response returned after starting a batch of outbound calls.
 *
 * <p>Contains the ID of the created batch and of the project and service it belongs to.
 */
@JsonDeserialize(builder = StartBatchResponseImpl.Builder.class)
public interface StartBatchResponse {

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
   * The ID of the batch.
   *
   * <p>Field is required
   *
   * @return batchId
   */
  String getBatchId();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new StartBatchResponseImpl.Builder();
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
     * @param batchId see getter
     * @return Current builder
     * @see #getBatchId
     */
    Builder setBatchId(String batchId);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    StartBatchResponse build();
  }
}
