package com.sinch.sdk.domains.numbers.models.v1.numberorder.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.numbers.models.v1.Capability;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  OrderNumberImpl.JSON_PROPERTY_PHONE_NUMBER,
  OrderNumberImpl.JSON_PROPERTY_NUMBER_PRICE,
  OrderNumberImpl.JSON_PROPERTY_CAPABILITY
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class OrderNumberImpl implements OrderNumber {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_PHONE_NUMBER = "phoneNumber";

  private OptionalValue<String> phoneNumber;

  public static final String JSON_PROPERTY_NUMBER_PRICE = "numberPrice";

  private OptionalValue<NumberPrice> numberPrice;

  public static final String JSON_PROPERTY_CAPABILITY = "capability";

  private OptionalValue<List<Capability>> capability;

  public OrderNumberImpl() {}

  protected OrderNumberImpl(
      OptionalValue<String> phoneNumber,
      OptionalValue<NumberPrice> numberPrice,
      OptionalValue<List<Capability>> capability) {
    this.phoneNumber = phoneNumber;
    this.numberPrice = numberPrice;
    this.capability = capability;
  }

  @JsonIgnore
  public String getPhoneNumber() {
    return phoneNumber.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PHONE_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> phoneNumber() {
    return phoneNumber;
  }

  @JsonIgnore
  public NumberPrice getNumberPrice() {
    return numberPrice.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NUMBER_PRICE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<NumberPrice> numberPrice() {
    return numberPrice;
  }

  @JsonIgnore
  public List<Capability> getCapability() {
    return capability.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CAPABILITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<Capability>> capability() {
    return capability;
  }

  /** Return true if this OrderNumber object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderNumberImpl orderNumber = (OrderNumberImpl) o;
    return Objects.equals(this.phoneNumber, orderNumber.phoneNumber)
        && Objects.equals(this.numberPrice, orderNumber.numberPrice)
        && Objects.equals(this.capability, orderNumber.capability);
  }

  @Override
  public int hashCode() {
    return Objects.hash(phoneNumber, numberPrice, capability);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderNumberImpl {\n");
    sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
    sb.append("    numberPrice: ").append(toIndentedString(numberPrice)).append("\n");
    sb.append("    capability: ").append(toIndentedString(capability)).append("\n");
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
  static class Builder implements OrderNumber.Builder {
    OptionalValue<String> phoneNumber = OptionalValue.empty();
    OptionalValue<NumberPrice> numberPrice = OptionalValue.empty();
    OptionalValue<List<Capability>> capability = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_PHONE_NUMBER)
    public Builder setPhoneNumber(String phoneNumber) {
      this.phoneNumber = OptionalValue.of(phoneNumber);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_NUMBER_PRICE)
    public Builder setNumberPrice(NumberPrice numberPrice) {
      this.numberPrice = OptionalValue.of(numberPrice);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CAPABILITY)
    public Builder setCapability(List<Capability> capability) {
      this.capability = OptionalValue.of(capability);
      return this;
    }

    public OrderNumber build() {
      return new OrderNumberImpl(phoneNumber, numberPrice, capability);
    }
  }
}
