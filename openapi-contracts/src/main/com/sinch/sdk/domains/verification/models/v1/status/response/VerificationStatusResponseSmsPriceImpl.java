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

@JsonPropertyOrder({VerificationStatusResponseSmsPriceImpl.JSON_PROPERTY_VERIFICATION_PRICE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VerificationStatusResponseSmsPriceImpl implements VerificationStatusResponseSmsPrice {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_VERIFICATION_PRICE = "verificationPrice";

  private OptionalValue<Price> verificationPrice;

  public VerificationStatusResponseSmsPriceImpl() {}

  protected VerificationStatusResponseSmsPriceImpl(OptionalValue<Price> verificationPrice) {
    this.verificationPrice = verificationPrice;
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

  /** Return true if this VerificationStatusResponseSms_allOf_price object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VerificationStatusResponseSmsPriceImpl verificationStatusResponseSmsAllOfPrice =
        (VerificationStatusResponseSmsPriceImpl) o;
    return Objects.equals(
        this.verificationPrice, verificationStatusResponseSmsAllOfPrice.verificationPrice);
  }

  @Override
  public int hashCode() {
    return Objects.hash(verificationPrice);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VerificationStatusResponseSmsPriceImpl {\n");
    sb.append("    verificationPrice: ").append(toIndentedString(verificationPrice)).append("\n");
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
  static class Builder implements VerificationStatusResponseSmsPrice.Builder {
    OptionalValue<Price> verificationPrice = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_VERIFICATION_PRICE)
    public Builder setVerificationPrice(Price verificationPrice) {
      this.verificationPrice = OptionalValue.of(verificationPrice);
      return this;
    }

    public VerificationStatusResponseSmsPrice build() {
      return new VerificationStatusResponseSmsPriceImpl(verificationPrice);
    }
  }
}
