package com.sinch.sdk.domains.sms.models.v1.batches.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  DryRunResponseImpl.JSON_PROPERTY_NUMBER_OF_RECIPIENTS,
  DryRunResponseImpl.JSON_PROPERTY_NUMBER_OF_MESSAGES,
  DryRunResponseImpl.JSON_PROPERTY_PER_RECIPIENT
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class DryRunResponseImpl implements DryRunResponse {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_NUMBER_OF_RECIPIENTS = "number_of_recipients";

  private OptionalValue<Integer> numberOfRecipients;

  public static final String JSON_PROPERTY_NUMBER_OF_MESSAGES = "number_of_messages";

  private OptionalValue<Integer> numberOfMessages;

  public static final String JSON_PROPERTY_PER_RECIPIENT = "per_recipient";

  private OptionalValue<List<DryRunPerRecipientDetails>> perRecipient;

  public DryRunResponseImpl() {}

  protected DryRunResponseImpl(
      OptionalValue<Integer> numberOfRecipients,
      OptionalValue<Integer> numberOfMessages,
      OptionalValue<List<DryRunPerRecipientDetails>> perRecipient) {
    this.numberOfRecipients = numberOfRecipients;
    this.numberOfMessages = numberOfMessages;
    this.perRecipient = perRecipient;
  }

  @JsonIgnore
  public Integer getNumberOfRecipients() {
    return numberOfRecipients.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NUMBER_OF_RECIPIENTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Integer> numberOfRecipients() {
    return numberOfRecipients;
  }

  @JsonIgnore
  public Integer getNumberOfMessages() {
    return numberOfMessages.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NUMBER_OF_MESSAGES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Integer> numberOfMessages() {
    return numberOfMessages;
  }

  @JsonIgnore
  public List<DryRunPerRecipientDetails> getPerRecipient() {
    return perRecipient.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PER_RECIPIENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<DryRunPerRecipientDetails>> perRecipient() {
    return perRecipient;
  }

  /** Return true if this ApiMtMessageDryRun object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DryRunResponseImpl apiMtMessageDryRun = (DryRunResponseImpl) o;
    return Objects.equals(this.numberOfRecipients, apiMtMessageDryRun.numberOfRecipients)
        && Objects.equals(this.numberOfMessages, apiMtMessageDryRun.numberOfMessages)
        && Objects.equals(this.perRecipient, apiMtMessageDryRun.perRecipient);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numberOfRecipients, numberOfMessages, perRecipient);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DryRunResponseImpl {\n");
    sb.append("    numberOfRecipients: ").append(toIndentedString(numberOfRecipients)).append("\n");
    sb.append("    numberOfMessages: ").append(toIndentedString(numberOfMessages)).append("\n");
    sb.append("    perRecipient: ").append(toIndentedString(perRecipient)).append("\n");
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
  static class Builder implements DryRunResponse.Builder {
    OptionalValue<Integer> numberOfRecipients = OptionalValue.empty();
    OptionalValue<Integer> numberOfMessages = OptionalValue.empty();
    OptionalValue<List<DryRunPerRecipientDetails>> perRecipient = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_NUMBER_OF_RECIPIENTS, required = true)
    public Builder setNumberOfRecipients(Integer numberOfRecipients) {
      this.numberOfRecipients = OptionalValue.of(numberOfRecipients);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_NUMBER_OF_MESSAGES, required = true)
    public Builder setNumberOfMessages(Integer numberOfMessages) {
      this.numberOfMessages = OptionalValue.of(numberOfMessages);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_PER_RECIPIENT)
    public Builder setPerRecipient(List<DryRunPerRecipientDetails> perRecipient) {
      this.perRecipient = OptionalValue.of(perRecipient);
      return this;
    }

    public DryRunResponse build() {
      return new DryRunResponseImpl(numberOfRecipients, numberOfMessages, perRecipient);
    }
  }
}
