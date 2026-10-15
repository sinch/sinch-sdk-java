package com.sinch.sdk.domains.voice.models.v2.services.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.voice.models.v2.services.CallBehavior;

/**
 * Request body for updating an existing voice service. Only the fields provided will be modified;
 * omitted fields remain unchanged.
 */
@JsonDeserialize(builder = UpdateServiceRequestImpl.Builder.class)
public interface UpdateServiceRequest {

  /**
   * Voice service name. No leading or trailing whitespaces allowed.
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
   * <p>Each project can have only one default service: setting a new default removes the default
   * status from the previously designated service. This property cannot be set to <code>false
   * </code>: in such case, a BadRequest will be returned by the API.
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
   * <p>Sent as the <code>Idempotency-Key</code> header. If not set, the SDK generates one for the
   * call and sends it again on the retries of that call. Set your own key if you need to retry the
   * call yourself, since the generated one is not returned.
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
    return new UpdateServiceRequestImpl.Builder();
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
     * Set this service as the default for the project
     *
     * <p>The API does not accept <code>false</code> on update, so there is no value to pass
     *
     * @return Current builder
     * @see #getIsDefault
     */
    Builder setAsDefault();

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
    UpdateServiceRequest build();
  }
}
