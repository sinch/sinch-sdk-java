package com.sinch.sdk.domains.numbers.models.v1.available.request;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.numbers.models.v1.Capability;
import com.sinch.sdk.domains.numbers.models.v1.NumberType;
import com.sinch.sdk.domains.numbers.models.v1.SearchPattern;
import java.util.Collection;
import java.util.Objects;

/**
 * Parameters request to list available numbers for a project
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/numbers/api-reference/numbers/tag/Available-Number/#tag/Available-Number/operation/NumberService_ListAvailableNumbers">https://developers.sinch.com/docs/numbers/api-reference/numbers/tag/Available-Number/#tag/Available-Number/operation/NumberService_ListAvailableNumbers/</a>
 * @since 1.2
 */
public class AvailableNumberListRequestImpl implements AvailableNumberListRequest {
  private final OptionalValue<String> regionCode;
  private final OptionalValue<NumberType> type;
  private final OptionalValue<SearchPattern> searchPattern;
  private final OptionalValue<Collection<Capability>> capabilities;
  private final OptionalValue<Integer> size;

  private AvailableNumberListRequestImpl(
      OptionalValue<String> regionCode,
      OptionalValue<NumberType> type,
      OptionalValue<SearchPattern> searchPattern,
      OptionalValue<Collection<Capability>> capabilities,
      OptionalValue<Integer> size) {
    this.regionCode = regionCode;
    this.type = type;
    this.searchPattern = searchPattern;
    this.capabilities = capabilities;
    this.size = size;
  }

  public String getRegionCode() {
    return regionCode.orElse(null);
  }

  public OptionalValue<String> regionCode() {
    return regionCode;
  }

  public NumberType getType() {
    return type.orElse(null);
  }

  public OptionalValue<NumberType> type() {
    return type;
  }

  public SearchPattern getSearchPattern() {
    return searchPattern.orElse(null);
  }

  public OptionalValue<SearchPattern> searchPattern() {
    return searchPattern;
  }

  public Collection<Capability> getCapabilities() {
    return capabilities.orElse(null);
  }

  public OptionalValue<Collection<Capability>> capabilities() {
    return capabilities;
  }

  public Integer getSize() {
    return size.orElse(null);
  }

  public OptionalValue<Integer> size() {
    return size;
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AvailableNumberListRequestImpl)) {
      return false;
    }
    AvailableNumberListRequestImpl that = (AvailableNumberListRequestImpl) o;
    return Objects.equals(getRegionCode(), that.getRegionCode())
        && Objects.equals(getType(), that.getType())
        && Objects.equals(getSearchPattern(), that.getSearchPattern())
        && Objects.equals(getCapabilities(), that.getCapabilities())
        && Objects.equals(getSize(), that.getSize());
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        getRegionCode(), getType(), getSearchPattern(), getCapabilities(), getSize());
  }

  public static class Builder implements AvailableNumberListRequest.Builder {
    OptionalValue<String> regionCode = OptionalValue.empty();
    OptionalValue<NumberType> type = OptionalValue.empty();
    OptionalValue<SearchPattern> searchPattern = OptionalValue.empty();
    OptionalValue<Collection<Capability>> capabilities = OptionalValue.empty();
    OptionalValue<Integer> size = OptionalValue.empty();

    private Builder() {}

    public Builder setRegionCode(String regionCode) {
      this.regionCode = OptionalValue.of(regionCode);
      return this;
    }

    public Builder setType(NumberType type) {
      this.type = OptionalValue.of(type);
      return this;
    }

    public Builder setSearchPattern(SearchPattern searchPattern) {
      this.searchPattern = OptionalValue.of(searchPattern);
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

    public AvailableNumberListRequestImpl build() {
      return new AvailableNumberListRequestImpl(
          regionCode, type, searchPattern, capabilities, size);
    }
  }
}
