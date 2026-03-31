package com.sinch.sdk.domains.conversation.models.v1.apps;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  RetentionPolicyImpl.JSON_PROPERTY_RETENTION_TYPE,
  RetentionPolicyImpl.JSON_PROPERTY_TTL_DAYS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class RetentionPolicyImpl implements RetentionPolicy {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_RETENTION_TYPE = "retention_type";

  private OptionalValue<RetentionPolicyType> retentionType;

  public static final String JSON_PROPERTY_TTL_DAYS = "ttl_days";

  private OptionalValue<Long> ttlDays;

  public RetentionPolicyImpl() {}

  protected RetentionPolicyImpl(
      OptionalValue<RetentionPolicyType> retentionType, OptionalValue<Long> ttlDays) {
    this.retentionType = retentionType;
    this.ttlDays = ttlDays;
  }

  @JsonIgnore
  public RetentionPolicyType getRetentionType() {
    return retentionType.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_RETENTION_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<RetentionPolicyType> retentionType() {
    return retentionType;
  }

  @JsonIgnore
  public Long getTtlDays() {
    return ttlDays.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TTL_DAYS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Long> ttlDays() {
    return ttlDays;
  }

  /** Return true if this RetentionPolicy object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RetentionPolicyImpl retentionPolicy = (RetentionPolicyImpl) o;
    return Objects.equals(this.retentionType, retentionPolicy.retentionType)
        && Objects.equals(this.ttlDays, retentionPolicy.ttlDays);
  }

  @Override
  public int hashCode() {
    return Objects.hash(retentionType, ttlDays);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RetentionPolicyImpl {\n");
    sb.append("    retentionType: ").append(toIndentedString(retentionType)).append("\n");
    sb.append("    ttlDays: ").append(toIndentedString(ttlDays)).append("\n");
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
  static class Builder implements RetentionPolicy.Builder {
    OptionalValue<RetentionPolicyType> retentionType = OptionalValue.empty();
    OptionalValue<Long> ttlDays = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_RETENTION_TYPE)
    public Builder setRetentionType(RetentionPolicyType retentionType) {
      this.retentionType = OptionalValue.of(retentionType);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TTL_DAYS)
    public Builder setTtlDays(Long ttlDays) {
      this.ttlDays = OptionalValue.of(ttlDays);
      return this;
    }

    public RetentionPolicy build() {
      return new RetentionPolicyImpl(retentionType, ttlDays);
    }
  }
}
