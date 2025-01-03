package com.sinch.sdk.domains.sms.models.v1.deliveryreports;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@JsonPropertyOrder({
  BatchDeliveryReportSMSImpl.JSON_PROPERTY_BATCH_ID,
  BatchDeliveryReportSMSImpl.JSON_PROPERTY_CLIENT_REFERENCE,
  BatchDeliveryReportSMSImpl.JSON_PROPERTY_STATUSES,
  BatchDeliveryReportSMSImpl.JSON_PROPERTY_TOTAL_MESSAGE_COUNT,
  BatchDeliveryReportSMSImpl.JSON_PROPERTY_TYPE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class BatchDeliveryReportSMSImpl implements BatchDeliveryReportSMS, BatchDeliveryReport {
  private static final long serialVersionUID = 1L;

  /** Gets or Sets type */
  public static class TypeEnum extends EnumDynamic<String, TypeEnum> {
    public static final TypeEnum DELIVERY_REPORT_SMS = new TypeEnum("delivery_report_sms");

    private static final EnumSupportDynamic<String, TypeEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(TypeEnum.class, TypeEnum::new, Arrays.asList(DELIVERY_REPORT_SMS));

    private TypeEnum(String value) {
      super(value);
    }

    public static Stream<TypeEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static TypeEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(TypeEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  public static final String JSON_PROPERTY_BATCH_ID = "batch_id";

  private OptionalValue<String> batchId;

  public static final String JSON_PROPERTY_CLIENT_REFERENCE = "client_reference";

  private OptionalValue<String> clientReference;

  public static final String JSON_PROPERTY_STATUSES = "statuses";

  private OptionalValue<List<MessageDeliveryStatus>> statuses;

  public static final String JSON_PROPERTY_TOTAL_MESSAGE_COUNT = "total_message_count";

  private OptionalValue<Integer> totalMessageCount;

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<TypeEnum> type;

  public BatchDeliveryReportSMSImpl() {}

  protected BatchDeliveryReportSMSImpl(
      OptionalValue<String> batchId,
      OptionalValue<String> clientReference,
      OptionalValue<List<MessageDeliveryStatus>> statuses,
      OptionalValue<Integer> totalMessageCount,
      OptionalValue<TypeEnum> type) {
    this.batchId = batchId;
    this.clientReference = clientReference;
    this.statuses = statuses;
    this.totalMessageCount = totalMessageCount;
    this.type = type;
  }

  @JsonIgnore
  public String getBatchId() {
    return batchId.orElse(null);
  }

  @JsonIgnore
  public OptionalValue<String> batchId() {
    return batchId;
  }

  @JsonIgnore
  public String getClientReference() {
    return clientReference.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CLIENT_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> clientReference() {
    return clientReference;
  }

  @JsonIgnore
  public List<MessageDeliveryStatus> getStatuses() {
    return statuses.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_STATUSES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<List<MessageDeliveryStatus>> statuses() {
    return statuses;
  }

  @JsonIgnore
  public Integer getTotalMessageCount() {
    return totalMessageCount.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TOTAL_MESSAGE_COUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Integer> totalMessageCount() {
    return totalMessageCount;
  }

  @JsonIgnore
  public TypeEnum getType() {
    return type.orElse(null);
  }

  @JsonIgnore
  public OptionalValue<TypeEnum> type() {
    return type;
  }

  /** Return true if this BatchDeliveryReportSMS object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BatchDeliveryReportSMSImpl batchDeliveryReportSMS = (BatchDeliveryReportSMSImpl) o;
    return Objects.equals(this.batchId, batchDeliveryReportSMS.batchId)
        && Objects.equals(this.clientReference, batchDeliveryReportSMS.clientReference)
        && Objects.equals(this.statuses, batchDeliveryReportSMS.statuses)
        && Objects.equals(this.totalMessageCount, batchDeliveryReportSMS.totalMessageCount)
        && Objects.equals(this.type, batchDeliveryReportSMS.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(batchId, clientReference, statuses, totalMessageCount, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BatchDeliveryReportSMSImpl {\n");
    sb.append("    batchId: ").append(toIndentedString(batchId)).append("\n");
    sb.append("    clientReference: ").append(toIndentedString(clientReference)).append("\n");
    sb.append("    statuses: ").append(toIndentedString(statuses)).append("\n");
    sb.append("    totalMessageCount: ").append(toIndentedString(totalMessageCount)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
  static class Builder implements BatchDeliveryReportSMS.Builder {
    OptionalValue<String> batchId = OptionalValue.empty();
    OptionalValue<String> clientReference = OptionalValue.empty();
    OptionalValue<List<MessageDeliveryStatus>> statuses = OptionalValue.empty();
    OptionalValue<Integer> totalMessageCount = OptionalValue.empty();
    OptionalValue<TypeEnum> type = OptionalValue.of(TypeEnum.DELIVERY_REPORT_SMS);

    @JsonProperty(JSON_PROPERTY_BATCH_ID)
    public Builder setBatchId(String batchId) {
      this.batchId = OptionalValue.of(batchId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CLIENT_REFERENCE)
    public Builder setClientReference(String clientReference) {
      this.clientReference = OptionalValue.of(clientReference);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_STATUSES)
    public Builder setStatuses(List<MessageDeliveryStatus> statuses) {
      this.statuses = OptionalValue.of(statuses);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TOTAL_MESSAGE_COUNT)
    public Builder setTotalMessageCount(Integer totalMessageCount) {
      this.totalMessageCount = OptionalValue.of(totalMessageCount);
      return this;
    }

    public BatchDeliveryReportSMS build() {
      return new BatchDeliveryReportSMSImpl(
          batchId, clientReference, statuses, totalMessageCount, type);
    }
  }
}
