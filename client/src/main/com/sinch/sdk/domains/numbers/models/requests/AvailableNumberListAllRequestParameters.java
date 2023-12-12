package com.sinch.sdk.domains.numbers.models.requests;

import com.sinch.sdk.domains.numbers.models.Capability;
import com.sinch.sdk.domains.numbers.models.NumberPattern;
import com.sinch.sdk.domains.numbers.models.NumberType;
import java.util.Collection;
import java.util.Optional;

/**
 * Parameters request to list available numbers for a project
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/numbers/api-reference/numbers/tag/Available-Number/#tag/Available-Number/operation/NumberService_ListAvailableNumbers">https://developers.sinch.com/docs/numbers/api-reference/numbers/tag/Available-Number/#tag/Available-Number/operation/NumberService_ListAvailableNumbers/</a>
 * @since 1.0
 */
public class AvailableNumberListAllRequestParameters {
  private final String regionCode;
  private final NumberType type;
  private final NumberPattern numberPattern;
  private final Collection<Capability> capabilities;
  private final Integer size;

  /**
   * @param regionCode Region code to filter by. ISO 3166-1 alpha-2 country code of the phone
   *     number. Example: US, GB or SE.
   * @param type Number type to filter by
   * @param numberPattern Search pattern
   * @param capabilities Capabilities to filter by
   * @param size Optional. The maximum number of items to return.
   */
  public AvailableNumberListAllRequestParameters(
      String regionCode,
      NumberType type,
      NumberPattern numberPattern,
      Collection<Capability> capabilities,
      Integer size) {
    this.regionCode = regionCode;
    this.type = type;
    this.numberPattern = numberPattern;
    this.capabilities = capabilities;
    this.size = size;
  }

  public String getRegionCode() {
    return regionCode;
  }

  public NumberType getType() {
    return type;
  }

  public Optional<NumberPattern> getNumberPattern() {
    return Optional.ofNullable(numberPattern);
  }

  public Optional<Collection<Capability>> getCapabilities() {
    return Optional.ofNullable(capabilities);
  }

  public Optional<Integer> getSize() {
    return Optional.ofNullable(size);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {
    String regionCode;
    NumberType type;
    NumberPattern numberPattern;
    Collection<Capability> capabilities;
    Integer size;

    private Builder() {}

    public Builder setRegionCode(String regionCode) {
      this.regionCode = regionCode;
      return this;
    }

    public Builder setType(NumberType type) {
      this.type = type;
      return this;
    }

    public Builder setNumberPattern(NumberPattern numberPattern) {
      this.numberPattern = numberPattern;
      return this;
    }

    public Builder setCapabilities(Collection<Capability> capabilities) {
      this.capabilities = capabilities;
      return this;
    }

    public Builder setSize(Integer size) {
      this.size = size;
      return this;
    }

    public AvailableNumberListAllRequestParameters build() {
      return new AvailableNumberListAllRequestParameters(
          regionCode, type, numberPattern, capabilities, size);
    }
  }
}
