package com.sinch.sdk.domains.numbers.models.requests;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.numbers.models.Capability;
import com.sinch.sdk.domains.numbers.models.NumberPattern;
import com.sinch.sdk.domains.numbers.models.NumberType;
import java.util.Collection;

/**
 * Parameters request to list available numbers for a project
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/numbers/api-reference/numbers/tag/Available-Number/#tag/Available-Number/operation/NumberService_ListAvailableNumbers">https://developers.sinch.com/docs/numbers/api-reference/numbers/tag/Available-Number/#tag/Available-Number/operation/NumberService_ListAvailableNumbers/</a>
 * @since 1.0
 */
public class AvailableNumberListAllRequestParameters {
  private final OptionalValue<String> regionCode;
  private final OptionalValue<NumberType> type;
  private final OptionalValue<NumberPattern> numberPattern;
  private final OptionalValue<Collection<Capability>> capabilities;
  private final OptionalValue<Integer> size;

  private AvailableNumberListAllRequestParameters(
      OptionalValue<String> regionCode,
      OptionalValue<NumberType> type,
      OptionalValue<NumberPattern> numberPattern,
      OptionalValue<Collection<Capability>> capabilities,
      OptionalValue<Integer> size) {
    this.regionCode = regionCode;
    this.type = type;
    this.numberPattern = numberPattern;
    this.capabilities = capabilities;
    this.size = size;
  }

  public OptionalValue<String> getRegionCode() {
    return regionCode;
  }

  public OptionalValue<NumberType> getType() {
    return type;
  }

  public OptionalValue<NumberPattern> getNumberPattern() {
    return numberPattern;
  }

  public OptionalValue<Collection<Capability>> getCapabilities() {
    return capabilities;
  }

  public OptionalValue<Integer> getSize() {
    return size;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {
    OptionalValue<String> regionCode = OptionalValue.empty();
    OptionalValue<NumberType> type = OptionalValue.empty();
    OptionalValue<NumberPattern> numberPattern = OptionalValue.empty();
    OptionalValue<Collection<Capability>> capabilities = OptionalValue.empty();
    OptionalValue<Integer> size = OptionalValue.empty();

    private Builder() {}

    /**
     * @param regionCode Region code to filter by. ISO 3166-1 alpha-2 country code of the phone
     *     number. Example: US, GB or SE.
     * @return current builder
     */
    public Builder setRegionCode(String regionCode) {
      this.regionCode = OptionalValue.of(regionCode);
      return this;
    }

    /**
     * @param type Number type to filter by
     * @return current builder
     */
    public Builder setType(NumberType type) {
      this.type = OptionalValue.of(type);
      return this;
    }

    /**
     * @return current builder
     */
    public Builder setNumberPattern(NumberPattern numberPattern) {
      this.numberPattern = OptionalValue.of(numberPattern);
      return this;
    }

    /**
     * @return current builder
     */
    public Builder setCapabilities(Collection<Capability> capabilities) {
      this.capabilities = OptionalValue.of(capabilities);
      return this;
    }

    /**
     * @param size Optional. The maximum number of items to return.
     * @return current builder
     */
    public Builder setSize(Integer size) {
      this.size = OptionalValue.of(size);
      return this;
    }

    public AvailableNumberListAllRequestParameters build() {
      return new AvailableNumberListAllRequestParameters(
          regionCode, type, numberPattern, capabilities, size);
    }
  }
}
