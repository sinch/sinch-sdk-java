package com.sinch.sdk.domains.voice.models.v2.services.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.Instant;

/** Abbreviated representation of a voice service, returned in list responses. */
@JsonDeserialize(builder = ServiceShortResponseImpl.Builder.class)
public interface ServiceShortResponse {

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
   * Name of the service
   *
   * <p>Field is required
   *
   * @return name
   * @readOnly <em>This field is returned by the server and cannot be modified</em>
   */
  String getName();

  /**
   * Description of the service
   *
   * @return description
   * @readOnly <em>This field is returned by the server and cannot be modified</em>
   */
  String getDescription();

  /**
   * Indicates whether this service is set as the default for the project. The default service is
   * used when no specific service is specified in API requests.
   *
   * <p>Field is required
   *
   * @return isDefault
   * @readOnly <em>This field is returned by the server and cannot be modified</em>
   */
  Boolean getIsDefault();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new ServiceShortResponseImpl.Builder();
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
     * @readOnly <em>This field is returned by the server and cannot be modified</em>
     */
    Builder setName(String name);

    /**
     * see getter
     *
     * @param description see getter
     * @return Current builder
     * @see #getDescription
     * @readOnly <em>This field is returned by the server and cannot be modified</em>
     */
    Builder setDescription(String description);

    /**
     * see getter
     *
     * @param isDefault see getter
     * @return Current builder
     * @see #getIsDefault
     * @readOnly <em>This field is returned by the server and cannot be modified</em>
     */
    Builder setIsDefault(Boolean isDefault);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    ServiceShortResponse build();
  }
}
