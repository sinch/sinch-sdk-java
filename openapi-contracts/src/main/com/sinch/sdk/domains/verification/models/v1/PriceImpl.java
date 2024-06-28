package com.sinch.sdk.domains.verification.models.v1;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({PriceImpl.JSON_PROPERTY_CURRENCY_ID, PriceImpl.JSON_PROPERTY_AMOUNT})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class PriceImpl implements Price {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CURRENCY_ID = "currencyId";

  private OptionalValue<String> currencyId;

  public static final String JSON_PROPERTY_AMOUNT = "amount";

  private OptionalValue<Float> amount;

  public PriceImpl() {}

  protected PriceImpl(OptionalValue<String> currencyId, OptionalValue<Float> amount) {
    this.currencyId = currencyId;
    this.amount = amount;
  }

  @JsonIgnore
  public String getCurrencyId() {
    return currencyId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CURRENCY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> currencyId() {
    return currencyId;
  }

  @JsonIgnore
  public Float getAmount() {
    return amount.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Float> amount() {
    return amount;
  }

  /** Return true if this Price object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PriceImpl price = (PriceImpl) o;
    return Objects.equals(this.currencyId, price.currencyId)
        && Objects.equals(this.amount, price.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(currencyId, amount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PriceImpl {\n");
    sb.append("    currencyId: ").append(toIndentedString(currencyId)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
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
  static class Builder implements Price.Builder {
    OptionalValue<String> currencyId = OptionalValue.empty();
    OptionalValue<Float> amount = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CURRENCY_ID)
    public Builder setCurrencyId(String currencyId) {
      this.currencyId = OptionalValue.of(currencyId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_AMOUNT)
    public Builder setAmount(Float amount) {
      this.amount = OptionalValue.of(amount);
      return this;
    }

    public Price build() {
      return new PriceImpl(currencyId, amount);
    }
  }
}
