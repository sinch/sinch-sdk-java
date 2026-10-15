package com.sinch.sdk.domains.voice.models.v2.batches.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  StartBatchResponseImpl.JSON_PROPERTY_PROJECT_ID,
  StartBatchResponseImpl.JSON_PROPERTY_SERVICE_ID,
  StartBatchResponseImpl.JSON_PROPERTY_BATCH_ID
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class StartBatchResponseImpl implements StartBatchResponse {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_PROJECT_ID = "projectId";

  private OptionalValue<String> projectId;

  public static final String JSON_PROPERTY_SERVICE_ID = "serviceId";

  private OptionalValue<String> serviceId;

  public static final String JSON_PROPERTY_BATCH_ID = "batchId";

  private OptionalValue<String> batchId;

  public StartBatchResponseImpl() {}

  protected StartBatchResponseImpl(
      OptionalValue<String> projectId,
      OptionalValue<String> serviceId,
      OptionalValue<String> batchId) {
    this.projectId = projectId;
    this.serviceId = serviceId;
    this.batchId = batchId;
  }

  @JsonIgnore
  public String getProjectId() {
    return projectId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PROJECT_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> projectId() {
    return projectId;
  }

  @JsonIgnore
  public String getServiceId() {
    return serviceId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SERVICE_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> serviceId() {
    return serviceId;
  }

  @JsonIgnore
  public String getBatchId() {
    return batchId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_BATCH_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> batchId() {
    return batchId;
  }

  /** Return true if this StartBatchResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StartBatchResponseImpl startBatchResponse = (StartBatchResponseImpl) o;
    return Objects.equals(this.projectId, startBatchResponse.projectId)
        && Objects.equals(this.serviceId, startBatchResponse.serviceId)
        && Objects.equals(this.batchId, startBatchResponse.batchId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(projectId, serviceId, batchId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StartBatchResponseImpl {\n");
    sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
    sb.append("    serviceId: ").append(toIndentedString(serviceId)).append("\n");
    sb.append("    batchId: ").append(toIndentedString(batchId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  @JsonPOJOBuilder(withPrefix = "set")
  static class Builder implements StartBatchResponse.Builder {
    OptionalValue<String> projectId = OptionalValue.empty();
    OptionalValue<String> serviceId = OptionalValue.empty();
    OptionalValue<String> batchId = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_PROJECT_ID, required = true)
    public Builder setProjectId(String projectId) {
      this.projectId = OptionalValue.of(projectId);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_SERVICE_ID, required = true)
    public Builder setServiceId(String serviceId) {
      this.serviceId = OptionalValue.of(serviceId);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_BATCH_ID, required = true)
    public Builder setBatchId(String batchId) {
      this.batchId = OptionalValue.of(batchId);
      return this;
    }

    public StartBatchResponse build() {
      return new StartBatchResponseImpl(projectId, serviceId, batchId);
    }
  }
}
