package com.sinch.sdk.domains.sms.models.v1.batches.request;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({SendDeliveryFeedbackRequestImpl.JSON_PROPERTY_RECIPIENTS})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class SendDeliveryFeedbackRequestImpl implements SendDeliveryFeedbackRequest {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_RECIPIENTS = "recipients";

  private OptionalValue<List<String>> recipients;

  public SendDeliveryFeedbackRequestImpl() {}

  protected SendDeliveryFeedbackRequestImpl(OptionalValue<List<String>> recipients) {
    this.recipients = recipients;
  }

  @JsonIgnore
  public List<String> getRecipients() {
    return recipients.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_RECIPIENTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<List<String>> recipients() {
    return recipients;
  }

  /** Return true if this ApiDeliveryFeedback object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SendDeliveryFeedbackRequestImpl apiDeliveryFeedback = (SendDeliveryFeedbackRequestImpl) o;
    return Objects.equals(this.recipients, apiDeliveryFeedback.recipients);
  }

  @Override
  public int hashCode() {
    return Objects.hash(recipients);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SendDeliveryFeedbackRequestImpl {\n");
    sb.append("    recipients: ").append(toIndentedString(recipients)).append("\n");
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
  static class Builder implements SendDeliveryFeedbackRequest.Builder {
    OptionalValue<List<String>> recipients = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_RECIPIENTS, required = true)
    public Builder setRecipients(List<String> recipients) {
      this.recipients = OptionalValue.of(recipients);
      return this;
    }

    public SendDeliveryFeedbackRequest build() {
      return new SendDeliveryFeedbackRequestImpl(recipients);
    }
  }
}
