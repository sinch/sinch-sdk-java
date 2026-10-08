package com.sinch.sdk.domains.voice.models.v2.services.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.voice.models.v2.services.CallBehavior;

/** Request body for creating a new voice service. */
@JsonDeserialize(builder = CreateServiceRequestImpl.Builder.class)
public interface CreateServiceRequest {

  /**
   * Voice service name. No leading or trailing whitespaces allowed.
   *
   * <p>Field is required
   *
   * @return name
   */
  String getName();

  /**
   * Description of the service
   *
   * @return description
   */
  String getDescription();

  /**
   * Indicates whether this service is set as the default for the project. The default service is
   * used when no specific service is specified in API requests.
   *
   * @return isDefault
   */
  Boolean getIsDefault();

  /**
   * Defines how calls are handled for this service
   *
   * @return callBehavior
   */
  CallBehavior getCallBehavior();

  /**
   * Client-generated idempotency key to safely retry requests. The server uses this key to
   * recognize retries of the same request. If a request with the same key is received within 10
   * minutes, the server returns the cached response from the original request. Using a random UUID
   * (v4) is strongly recommended.
   *
   * <p>Sent as the <code>Idempotency-Key</code> header.
   *
   * @return idempotencyKey
   */
  String getIdempotencyKey();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new CreateServiceRequestImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param name see getter
     * @return Current builder
     * @see #getName
     */
    Builder setName(String name);

    /**
     * see getter
     *
     * @param description see getter
     * @return Current builder
     * @see #getDescription
     */
    Builder setDescription(String description);

    /**
     * see getter
     *
     * @param isDefault see getter
     * @return Current builder
     * @see #getIsDefault
     */
    Builder setIsDefault(Boolean isDefault);

    /**
     * see getter
     *
     * @param callBehavior see getter
     * @return Current builder
     * @see #getCallBehavior
     */
    Builder setCallBehavior(CallBehavior callBehavior);

    /**
     * see getter
     *
     * @param idempotencyKey see getter
     * @return Current builder
     * @see #getIdempotencyKey
     */
    Builder setIdempotencyKey(String idempotencyKey);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    CreateServiceRequest build();
  }
}
