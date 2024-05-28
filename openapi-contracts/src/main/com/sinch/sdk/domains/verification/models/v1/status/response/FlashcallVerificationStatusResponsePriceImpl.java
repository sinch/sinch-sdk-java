package com.sinch.sdk.domains.verification.models.v1.status.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.verification.models.v1.Price;
import java.util.Objects;

@JsonPropertyOrder({
  FlashcallVerificationStatusResponsePriceImpl.JSON_PROPERTY_VERIFICATION_PRICE,
  FlashcallVerificationStatusResponsePriceImpl.JSON_PROPERTY_TERMINATION_PRICE,
  FlashcallVerificationStatusResponsePriceImpl.JSON_PROPERTY_BILLABLE_DURATION
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class FlashcallVerificationStatusResponsePriceImpl
    implements FlashcallVerificationStatusResponsePrice {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_VERIFICATION_PRICE = "verificationPrice";

  private OptionalValue<Price> verificationPrice;

  public static final String JSON_PROPERTY_TERMINATION_PRICE = "terminationPrice";

  private OptionalValue<Price> terminationPrice;

  public static final String JSON_PROPERTY_BILLABLE_DURATION = "billableDuration";

  private OptionalValue<Integer> billableDuration;

  public FlashcallVerificationStatusResponsePriceImpl() {}

  protected FlashcallVerificationStatusResponsePriceImpl(
      OptionalValue<Price> verificationPrice,
      OptionalValue<Price> terminationPrice,
      OptionalValue<Integer> billableDuration) {
    this.verificationPrice = verificationPrice;
    this.terminationPrice = terminationPrice;
    this.billableDuration = billableDuration;
  }

  @JsonIgnore
  public Price getVerificationPrice() {
    return verificationPrice.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_VERIFICATION_PRICE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Price> verificationPrice() {
    return verificationPrice;
  }

  @JsonIgnore
  public Price getTerminationPrice() {
    return terminationPrice.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TERMINATION_PRICE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Price> terminationPrice() {
    return terminationPrice;
  }

  @JsonIgnore
  public Integer getBillableDuration() {
    return billableDuration.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_BILLABLE_DURATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> billableDuration() {
    return billableDuration;
  }

  /** Return true if this FlashcallVerificationStatusResponse_allOf_price object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FlashcallVerificationStatusResponsePriceImpl flashcallVerificationStatusResponseAllOfPrice =
        (FlashcallVerificationStatusResponsePriceImpl) o;
    return Objects.equals(
            this.verificationPrice, flashcallVerificationStatusResponseAllOfPrice.verificationPrice)
        && Objects.equals(
            this.terminationPrice, flashcallVerificationStatusResponseAllOfPrice.terminationPrice)
        && Objects.equals(
            this.billableDuration, flashcallVerificationStatusResponseAllOfPrice.billableDuration);
  }

  @Override
  public int hashCode() {
    return Objects.hash(verificationPrice, terminationPrice, billableDuration);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FlashcallVerificationStatusResponsePriceImpl {\n");
    sb.append("    verificationPrice: ").append(toIndentedString(verificationPrice)).append("\n");
    sb.append("    terminationPrice: ").append(toIndentedString(terminationPrice)).append("\n");
    sb.append("    billableDuration: ").append(toIndentedString(billableDuration)).append("\n");
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
  static class Builder implements FlashcallVerificationStatusResponsePrice.Builder {
    OptionalValue<Price> verificationPrice = OptionalValue.empty();
    OptionalValue<Price> terminationPrice = OptionalValue.empty();
    OptionalValue<Integer> billableDuration = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_VERIFICATION_PRICE)
    public Builder setVerificationPrice(Price verificationPrice) {
      this.verificationPrice = OptionalValue.of(verificationPrice);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TERMINATION_PRICE)
    public Builder setTerminationPrice(Price terminationPrice) {
      this.terminationPrice = OptionalValue.of(terminationPrice);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_BILLABLE_DURATION)
    public Builder setBillableDuration(Integer billableDuration) {
      this.billableDuration = OptionalValue.of(billableDuration);
      return this;
    }

    public FlashcallVerificationStatusResponsePrice build() {
      return new FlashcallVerificationStatusResponsePriceImpl(
          verificationPrice, terminationPrice, billableDuration);
    }
  }
}
