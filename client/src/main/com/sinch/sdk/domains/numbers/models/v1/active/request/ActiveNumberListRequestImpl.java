package com.sinch.sdk.domains.numbers.models.v1.active.request;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.numbers.models.v1.Capability;
import com.sinch.sdk.domains.numbers.models.v1.NumberType;
import com.sinch.sdk.domains.numbers.models.v1.SearchPattern;
import java.util.Collection;
import java.util.Objects;

/**
 * Parameters request to list active numbers for a project
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/numbers/api-reference/numbers/tag/Active-Number">https://developers.sinch.com/docs/numbers/api-reference/numbers/tag/Active-Number/</a>
 * @since 1.2
 */
public class ActiveNumberListRequestImpl implements ActiveNumberListRequest {

  private final OptionalValue<String> regionCode;
  private final OptionalValue<NumberType> type;
  private final OptionalValue<SearchPattern> searchPattern;
  private final OptionalValue<Collection<Capability>> capabilities;
  private final OptionalValue<Integer> pageSize;
  private final OptionalValue<String> pageToken;
  private final OptionalValue<OrderBy> orderBy;

  private ActiveNumberListRequestImpl(
      OptionalValue<String> regionCode,
      OptionalValue<NumberType> type,
      OptionalValue<SearchPattern> searchPattern,
      OptionalValue<Collection<Capability>> capabilities,
      OptionalValue<Integer> pageSize,
      OptionalValue<String> pageToken,
      OptionalValue<OrderBy> orderBy) {
    this.regionCode = regionCode;
    this.type = type;
    this.searchPattern = searchPattern;
    this.capabilities = capabilities;
    this.pageSize = pageSize;
    this.pageToken = pageToken;
    this.orderBy = orderBy;
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

  public Integer getPageSize() {
    return pageSize.orElse(null);
  }

  public OptionalValue<Integer> pageSize() {
    return pageSize;
  }

  public String getPageToken() {
    return pageToken.orElse(null);
  }

  public OptionalValue<String> pageToken() {
    return pageToken;
  }

  public OrderBy getOrderBy() {
    return orderBy.orElse(null);
  }

  public OptionalValue<OrderBy> orderBy() {
    return orderBy;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ActiveNumberListRequestImpl)) {
      return false;
    }
    ActiveNumberListRequestImpl that = (ActiveNumberListRequestImpl) o;
    return Objects.equals(getRegionCode(), that.getRegionCode())
        && Objects.equals(getType(), that.getType())
        && Objects.equals(getSearchPattern(), that.getSearchPattern())
        && Objects.equals(getCapabilities(), that.getCapabilities())
        && Objects.equals(getPageSize(), that.getPageSize())
        && Objects.equals(getPageToken(), that.getPageToken())
        && Objects.equals(getOrderBy(), that.getOrderBy());
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        getRegionCode(),
        getType(),
        getSearchPattern(),
        getCapabilities(),
        getPageSize(),
        getPageToken(),
        getOrderBy());
  }

  public static Builder builder() {
    return new Builder();
  }

  public static Builder builder(ActiveNumberListRequest parameters) {
    return new Builder(parameters);
  }

  public static class Builder implements ActiveNumberListRequest.Builder {

    OptionalValue<String> regionCode = OptionalValue.empty();
    OptionalValue<NumberType> type = OptionalValue.empty();
    OptionalValue<SearchPattern> searchPattern = OptionalValue.empty();
    OptionalValue<Collection<Capability>> capabilities = OptionalValue.empty();
    OptionalValue<Integer> pageSize = OptionalValue.empty();
    OptionalValue<String> pageToken = OptionalValue.empty();
    OptionalValue<OrderBy> orderBy = OptionalValue.empty();

    protected Builder() {}

    protected Builder(ActiveNumberListRequest _parameters) {
      ActiveNumberListRequestImpl parameters = (ActiveNumberListRequestImpl) _parameters;
      parameters.regionCode.ifPresent(this::setRegionCode);
      parameters.type.ifPresent(this::setType);
      parameters.searchPattern.ifPresent(this::setSearchPattern);
      parameters.capabilities.ifPresent(this::setCapabilities);
      parameters.pageSize.ifPresent(this::setPageSize);
      parameters.pageToken.ifPresent(this::setPageToken);
      parameters.orderBy.ifPresent(this::setOrderBy);
    }

    /**
     * see getter
     *
     * @param regionCode see getter
     * @return Current builder
     * @see #getRegionCode()
     */
    public Builder setRegionCode(String regionCode) {
      this.regionCode = OptionalValue.of(regionCode);
      return this;
    }

    /**
     * see getter
     *
     * @param type see getter
     * @return Current builder
     * @see #getType
     */
    public Builder setType(NumberType type) {
      this.type = OptionalValue.of(type);
      return this;
    }

    /**
     * see getter
     *
     * @param searchPattern see getter
     * @return Current builder
     * @see #getSearchPattern()
     */
    public Builder setSearchPattern(SearchPattern searchPattern) {
      this.searchPattern = OptionalValue.of(searchPattern);
      return this;
    }

    /**
     * see getter
     *
     * @param capabilities see getter
     * @return Current builder
     * @see #getCapabilities()
     */
    public Builder setCapabilities(Collection<Capability> capabilities) {
      this.capabilities = OptionalValue.of(capabilities);
      return this;
    }

    /**
     * see getter
     *
     * @param pageSize see getter
     * @return Current builder
     * @see #getPageSize()
     */
    public Builder setPageSize(Integer pageSize) {
      this.pageSize = OptionalValue.of(pageSize);
      return this;
    }

    /**
     * see getter
     *
     * @param pageToken see getter
     * @return Current builder
     * @see #getPageToken()
     */
    public Builder setPageToken(String pageToken) {
      this.pageToken = OptionalValue.of(pageToken);
      return this;
    }

    /**
     * see getter
     *
     * @param orderBy see getter
     * @return Current builder
     * @see #getOrderBy()
     */
    public Builder setOrderBy(OrderBy orderBy) {
      this.orderBy = OptionalValue.of(orderBy);
      return this;
    }

    public ActiveNumberListRequest build() {
      return new ActiveNumberListRequestImpl(
          regionCode, type, searchPattern, capabilities, pageSize, pageToken, orderBy);
    }
  }
}
