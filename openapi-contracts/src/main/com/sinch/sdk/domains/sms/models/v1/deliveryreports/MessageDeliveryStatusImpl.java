package com.sinch.sdk.domains.sms.models.v1.deliveryreports;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;
import java.util.Set;

@JsonPropertyOrder({
  MessageDeliveryStatusImpl.JSON_PROPERTY_CODE,
  MessageDeliveryStatusImpl.JSON_PROPERTY_COUNT,
  MessageDeliveryStatusImpl.JSON_PROPERTY_RECIPIENTS,
  MessageDeliveryStatusImpl.JSON_PROPERTY_STATUS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class MessageDeliveryStatusImpl implements MessageDeliveryStatus {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CODE = "code";

  private OptionalValue<DeliveryReceiptErrorCode> code;

  public static final String JSON_PROPERTY_COUNT = "count";

  private OptionalValue<Integer> count;

  public static final String JSON_PROPERTY_RECIPIENTS = "recipients";

  private OptionalValue<Set<String>> recipients;

  public static final String JSON_PROPERTY_STATUS = "status";

  private OptionalValue<DeliveryStatus> status;

  public MessageDeliveryStatusImpl() {}

  protected MessageDeliveryStatusImpl(
      OptionalValue<DeliveryReceiptErrorCode> code,
      OptionalValue<Integer> count,
      OptionalValue<Set<String>> recipients,
      OptionalValue<DeliveryStatus> status) {
    this.code = code;
    this.count = count;
    this.recipients = recipients;
    this.status = status;
  }

  @JsonIgnore
  public DeliveryReceiptErrorCode getCode() {
    return code.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CODE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<DeliveryReceiptErrorCode> code() {
    return code;
  }

  @JsonIgnore
  public Integer getCount() {
    return count.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_COUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Integer> count() {
    return count;
  }

  @JsonIgnore
  public Set<String> getRecipients() {
    return recipients.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_RECIPIENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Set<String>> recipients() {
    return recipients;
  }

  @JsonIgnore
  public DeliveryStatus getStatus() {
    return status.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<DeliveryStatus> status() {
    return status;
  }

  /** Return true if this MessageDeliveryStatus object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MessageDeliveryStatusImpl messageDeliveryStatus = (MessageDeliveryStatusImpl) o;
    return Objects.equals(this.code, messageDeliveryStatus.code)
        && Objects.equals(this.count, messageDeliveryStatus.count)
        && Objects.equals(this.recipients, messageDeliveryStatus.recipients)
        && Objects.equals(this.status, messageDeliveryStatus.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, count, recipients, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MessageDeliveryStatusImpl {\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    recipients: ").append(toIndentedString(recipients)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
  static class Builder implements MessageDeliveryStatus.Builder {
    OptionalValue<DeliveryReceiptErrorCode> code = OptionalValue.empty();
    OptionalValue<Integer> count = OptionalValue.empty();
    OptionalValue<Set<String>> recipients = OptionalValue.empty();
    OptionalValue<DeliveryStatus> status = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_CODE, required = true)
    public Builder setCode(DeliveryReceiptErrorCode code) {
      this.code = OptionalValue.of(code);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_COUNT, required = true)
    public Builder setCount(Integer count) {
      this.count = OptionalValue.of(count);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_RECIPIENTS)
    public Builder setRecipients(Set<String> recipients) {
      this.recipients = OptionalValue.of(recipients);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_STATUS, required = true)
    public Builder setStatus(DeliveryStatus status) {
      this.status = OptionalValue.of(status);
      return this;
    }

    public MessageDeliveryStatus build() {
      return new MessageDeliveryStatusImpl(code, count, recipients, status);
    }
  }
}
