package com.sinch.sdk.domains.conversation.models.v1.consents.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.consents.ConsentsListType;
import java.time.Instant;
import java.util.Objects;

@JsonPropertyOrder({
  AuditRecordImpl.JSON_PROPERTY_ORIGIN,
  AuditRecordImpl.JSON_PROPERTY_OPERATION,
  AuditRecordImpl.JSON_PROPERTY_LIST_TYPE,
  AuditRecordImpl.JSON_PROPERTY_PROJECT_ID,
  AuditRecordImpl.JSON_PROPERTY_APP_ID,
  AuditRecordImpl.JSON_PROPERTY_DATETIME
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class AuditRecordImpl implements AuditRecord {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ORIGIN = "origin";

  private OptionalValue<OriginEnum> origin;

  public static final String JSON_PROPERTY_OPERATION = "operation";

  private OptionalValue<OperationEnum> operation;

  public static final String JSON_PROPERTY_LIST_TYPE = "list_type";

  private OptionalValue<ConsentsListType> listType;

  public static final String JSON_PROPERTY_PROJECT_ID = "project_id";

  private OptionalValue<String> projectId;

  public static final String JSON_PROPERTY_APP_ID = "app_id";

  private OptionalValue<String> appId;

  public static final String JSON_PROPERTY_DATETIME = "datetime";

  private OptionalValue<Instant> datetime;

  public AuditRecordImpl() {}

  protected AuditRecordImpl(
      OptionalValue<OriginEnum> origin,
      OptionalValue<OperationEnum> operation,
      OptionalValue<ConsentsListType> listType,
      OptionalValue<String> projectId,
      OptionalValue<String> appId,
      OptionalValue<Instant> datetime) {
    this.origin = origin;
    this.operation = operation;
    this.listType = listType;
    this.projectId = projectId;
    this.appId = appId;
    this.datetime = datetime;
  }

  @JsonIgnore
  public OriginEnum getOrigin() {
    return origin.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ORIGIN)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<OriginEnum> origin() {
    return origin;
  }

  @JsonIgnore
  public OperationEnum getOperation() {
    return operation.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_OPERATION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<OperationEnum> operation() {
    return operation;
  }

  @JsonIgnore
  public ConsentsListType getListType() {
    return listType.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_LIST_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<ConsentsListType> listType() {
    return listType;
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
  public String getAppId() {
    return appId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_APP_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> appId() {
    return appId;
  }

  @JsonIgnore
  public Instant getDatetime() {
    return datetime.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DATETIME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Instant> datetime() {
    return datetime;
  }

  /** Return true if this AuditRecord object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuditRecordImpl auditRecord = (AuditRecordImpl) o;
    return Objects.equals(this.origin, auditRecord.origin)
        && Objects.equals(this.operation, auditRecord.operation)
        && Objects.equals(this.listType, auditRecord.listType)
        && Objects.equals(this.projectId, auditRecord.projectId)
        && Objects.equals(this.appId, auditRecord.appId)
        && Objects.equals(this.datetime, auditRecord.datetime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(origin, operation, listType, projectId, appId, datetime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuditRecordImpl {\n");
    sb.append("    origin: ").append(toIndentedString(origin)).append("\n");
    sb.append("    operation: ").append(toIndentedString(operation)).append("\n");
    sb.append("    listType: ").append(toIndentedString(listType)).append("\n");
    sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
    sb.append("    appId: ").append(toIndentedString(appId)).append("\n");
    sb.append("    datetime: ").append(toIndentedString(datetime)).append("\n");
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
  static class Builder implements AuditRecord.Builder {
    OptionalValue<OriginEnum> origin = OptionalValue.empty();
    OptionalValue<OperationEnum> operation = OptionalValue.empty();
    OptionalValue<ConsentsListType> listType = OptionalValue.empty();
    OptionalValue<String> projectId = OptionalValue.empty();
    OptionalValue<String> appId = OptionalValue.empty();
    OptionalValue<Instant> datetime = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_ORIGIN, required = true)
    public Builder setOrigin(OriginEnum origin) {
      this.origin = OptionalValue.of(origin);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_OPERATION, required = true)
    public Builder setOperation(OperationEnum operation) {
      this.operation = OptionalValue.of(operation);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_LIST_TYPE, required = true)
    public Builder setListType(ConsentsListType listType) {
      this.listType = OptionalValue.of(listType);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_PROJECT_ID, required = true)
    public Builder setProjectId(String projectId) {
      this.projectId = OptionalValue.of(projectId);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_APP_ID, required = true)
    public Builder setAppId(String appId) {
      this.appId = OptionalValue.of(appId);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_DATETIME, required = true)
    public Builder setDatetime(Instant datetime) {
      this.datetime = OptionalValue.of(datetime);
      return this;
    }

    public AuditRecord build() {
      return new AuditRecordImpl(origin, operation, listType, projectId, appId, datetime);
    }
  }
}
