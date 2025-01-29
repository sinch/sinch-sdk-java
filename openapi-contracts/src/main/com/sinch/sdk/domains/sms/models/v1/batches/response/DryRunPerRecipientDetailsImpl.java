package com.sinch.sdk.domains.sms.models.v1.batches.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  DryRunPerRecipientDetailsImpl.JSON_PROPERTY_RECIPIENT,
  DryRunPerRecipientDetailsImpl.JSON_PROPERTY_NUMBER_OF_PARTS,
  DryRunPerRecipientDetailsImpl.JSON_PROPERTY_BODY,
  DryRunPerRecipientDetailsImpl.JSON_PROPERTY_ENCODING
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class DryRunPerRecipientDetailsImpl implements DryRunPerRecipientDetails {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_RECIPIENT = "recipient";

  private OptionalValue<String> recipient;

  public static final String JSON_PROPERTY_NUMBER_OF_PARTS = "number_of_parts";

  private OptionalValue<Integer> numberOfParts;

  public static final String JSON_PROPERTY_BODY = "body";

  private OptionalValue<String> body;

  public static final String JSON_PROPERTY_ENCODING = "encoding";

  private OptionalValue<String> encoding;

  public DryRunPerRecipientDetailsImpl() {}

  protected DryRunPerRecipientDetailsImpl(
      OptionalValue<String> recipient,
      OptionalValue<Integer> numberOfParts,
      OptionalValue<String> body,
      OptionalValue<String> encoding) {
    this.recipient = recipient;
    this.numberOfParts = numberOfParts;
    this.body = body;
    this.encoding = encoding;
  }

  @JsonIgnore
  public String getRecipient() {
    return recipient.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_RECIPIENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> recipient() {
    return recipient;
  }

  @JsonIgnore
  public Integer getNumberOfParts() {
    return numberOfParts.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NUMBER_OF_PARTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> numberOfParts() {
    return numberOfParts;
  }

  @JsonIgnore
  public String getBody() {
    return body.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_BODY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> body() {
    return body;
  }

  @JsonIgnore
  public String getEncoding() {
    return encoding.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ENCODING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> encoding() {
    return encoding;
  }

  /** Return true if this DryRunResponse_per_recipient_inner object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DryRunPerRecipientDetailsImpl dryRunResponsePerRecipientInner =
        (DryRunPerRecipientDetailsImpl) o;
    return Objects.equals(this.recipient, dryRunResponsePerRecipientInner.recipient)
        && Objects.equals(this.numberOfParts, dryRunResponsePerRecipientInner.numberOfParts)
        && Objects.equals(this.body, dryRunResponsePerRecipientInner.body)
        && Objects.equals(this.encoding, dryRunResponsePerRecipientInner.encoding);
  }

  @Override
  public int hashCode() {
    return Objects.hash(recipient, numberOfParts, body, encoding);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DryRunPerRecipientDetailsImpl {\n");
    sb.append("    recipient: ").append(toIndentedString(recipient)).append("\n");
    sb.append("    numberOfParts: ").append(toIndentedString(numberOfParts)).append("\n");
    sb.append("    body: ").append(toIndentedString(body)).append("\n");
    sb.append("    encoding: ").append(toIndentedString(encoding)).append("\n");
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
  static class Builder implements DryRunPerRecipientDetails.Builder {
    OptionalValue<String> recipient = OptionalValue.empty();
    OptionalValue<Integer> numberOfParts = OptionalValue.empty();
    OptionalValue<String> body = OptionalValue.empty();
    OptionalValue<String> encoding = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_RECIPIENT)
    public Builder setRecipient(String recipient) {
      this.recipient = OptionalValue.of(recipient);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_NUMBER_OF_PARTS)
    public Builder setNumberOfParts(Integer numberOfParts) {
      this.numberOfParts = OptionalValue.of(numberOfParts);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_BODY)
    public Builder setBody(String body) {
      this.body = OptionalValue.of(body);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ENCODING)
    public Builder setEncoding(String encoding) {
      this.encoding = OptionalValue.of(encoding);
      return this;
    }

    public DryRunPerRecipientDetails build() {
      return new DryRunPerRecipientDetailsImpl(recipient, numberOfParts, body, encoding);
    }
  }
}
