package com.sinch.sdk.domains.voice.models.v2.services.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.voice.models.v2.services.CallBehavior;
import java.time.Instant;

/**
 * Full representation of a voice service resource, including its configuration and call behavior.
 */
@JsonDeserialize(builder = ServiceResponseImpl.Builder.class)
public interface ServiceResponse {

  /**
   * The ID of the service used.
   *
   * <p>Field is required
   *
   * @return serviceId
   */
  String getServiceId();

  /**
   * The ID of the project associated with the call.
   *
   * <p>Field is required
   *
   * @return projectId
   */
  String getProjectId();

  /**
   * Timestamp (RFC 3339) indicating when the service was created.
   *
   * <p>Field is required
   *
   * @return createTime
   * @readOnly <em>This field is returned by the server and cannot be modified</em>
   */
  Instant getCreateTime();

  /**
   * Timestamp (RFC 3339) indicating when the service was last updated.
   *
   * <p>Omitted if no updates were performed on this service.
   *
   * @return updateTime
   * @readOnly <em>This field is returned by the server and cannot be modified</em>
   */
  Instant getUpdateTime();

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
   * <p>Field is required
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
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new ServiceResponseImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

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
     * @param projectId see getter
     * @return Current builder
     * @see #getProjectId
     */
    Builder setProjectId(String projectId);

    /**
     * see getter
     *
     * @param createTime see getter
     * @return Current builder
     * @see #getCreateTime
     * @readOnly <em>This field is returned by the server and cannot be modified</em>
     */
    Builder setCreateTime(Instant createTime);

    /**
     * see getter
     *
     * @param updateTime see getter
     * @return Current builder
     * @see #getUpdateTime
     * @readOnly <em>This field is returned by the server and cannot be modified</em>
     */
    Builder setUpdateTime(Instant updateTime);

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
     * Create instance
     *
     * @return The instance build with current builder values
     */
    ServiceResponse build();
  }
}
