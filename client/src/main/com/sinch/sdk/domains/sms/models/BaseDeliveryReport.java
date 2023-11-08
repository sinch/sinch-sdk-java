package com.sinch.sdk.domains.sms.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.util.Objects;
import java.util.Optional;

/**
 * Base class for Delivery Report WebHook
 *
 * @since 1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    property = "type",
    visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(
      value = DeliveryReportRecipientSMS.class,
      name = "recipient_delivery_report_sms"),
  @JsonSubTypes.Type(
      value = DeliveryReportRecipientMMS.class,
      name = "recipient_delivery_report_mms"),
  @JsonSubTypes.Type(value = DeliveryReportBatchSMS.class, name = "delivery_report_sms"),
  @JsonSubTypes.Type(value = DeliveryReportBatchMMS.class, name = "delivery_report_mms")
})
public abstract class BaseDeliveryReport {

  static final String JSON_PROPERTY_BATCH_ID = "batch_id";
  private final String batchId;
  static final String JSON_PROPERTY_CLIENT_REFERENCE = "client_reference";
  private final String clientReference;

  /**
   * @param batchId <code>Required.</code> The ID of the batch this delivery report belongs to.
   * @param clientReference The client identifier of the batch this delivery report belongs to, if
   *     set when submitting batch.
   */
  @JsonCreator
  public BaseDeliveryReport(
      @JsonProperty(JSON_PROPERTY_BATCH_ID) String batchId,
      @JsonProperty(JSON_PROPERTY_CLIENT_REFERENCE) String clientReference) {
    Objects.requireNonNull(batchId);
    this.batchId = batchId;
    this.clientReference = clientReference;
  }

  public String getBatchId() {
    return batchId;
  }

  public Optional<String> getClientReference() {
    return Optional.ofNullable(clientReference);
  }

  @Override
  public String toString() {
    return "BaseDeliveryReport{"
        + "batchId='"
        + batchId
        + '\''
        + ", clientReference='"
        + clientReference
        + '\''
        + '}';
  }

  public abstract static class Builder<B extends Builder<B>> {
    protected String batchId;
    protected String clientReference;

    public B setBatchId(String batchId) {
      this.batchId = batchId;
      return self();
    }

    public B setClientReference(String clientReference) {
      this.clientReference = clientReference;
      return self();
    }

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }
  }
}
