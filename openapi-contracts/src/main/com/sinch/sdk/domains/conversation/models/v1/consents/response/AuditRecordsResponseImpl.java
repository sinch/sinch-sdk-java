package com.sinch.sdk.domains.conversation.models.v1.consents.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.consents.Identity;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  AuditRecordsResponseImpl.JSON_PROPERTY_IDENTITY,
  AuditRecordsResponseImpl.JSON_PROPERTY_AUDIT_RECORDS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class AuditRecordsResponseImpl implements AuditRecordsResponse {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_IDENTITY = "identity";

  private OptionalValue<Identity> identity;

  public static final String JSON_PROPERTY_AUDIT_RECORDS = "audit_records";

  private OptionalValue<List<AuditRecord>> auditRecords;

  public AuditRecordsResponseImpl() {}

  protected AuditRecordsResponseImpl(
      OptionalValue<Identity> identity, OptionalValue<List<AuditRecord>> auditRecords) {
    this.identity = identity;
    this.auditRecords = auditRecords;
  }

  @JsonIgnore
  public Identity getIdentity() {
    return identity.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_IDENTITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Identity> identity() {
    return identity;
  }

  @JsonIgnore
  public List<AuditRecord> getAuditRecords() {
    return auditRecords.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_AUDIT_RECORDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<AuditRecord>> auditRecords() {
    return auditRecords;
  }

  /** Return true if this GetAuditRecordsFromConsentResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuditRecordsResponseImpl getAuditRecordsFromConsentResponse = (AuditRecordsResponseImpl) o;
    return Objects.equals(this.identity, getAuditRecordsFromConsentResponse.identity)
        && Objects.equals(this.auditRecords, getAuditRecordsFromConsentResponse.auditRecords);
  }

  @Override
  public int hashCode() {
    return Objects.hash(identity, auditRecords);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuditRecordsResponseImpl {\n");
    sb.append("    identity: ").append(toIndentedString(identity)).append("\n");
    sb.append("    auditRecords: ").append(toIndentedString(auditRecords)).append("\n");
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
  static class Builder implements AuditRecordsResponse.Builder {
    OptionalValue<Identity> identity = OptionalValue.empty();
    OptionalValue<List<AuditRecord>> auditRecords = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_IDENTITY)
    public Builder setIdentity(Identity identity) {
      this.identity = OptionalValue.of(identity);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_AUDIT_RECORDS)
    public Builder setAuditRecords(List<AuditRecord> auditRecords) {
      this.auditRecords = OptionalValue.of(auditRecords);
      return this;
    }

    public AuditRecordsResponse build() {
      return new AuditRecordsResponseImpl(identity, auditRecords);
    }
  }
}
