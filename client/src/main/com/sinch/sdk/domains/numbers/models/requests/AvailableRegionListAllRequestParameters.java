package com.sinch.sdk.domains.numbers.models.requests;

import com.sinch.sdk.domains.numbers.models.NumberType;
import java.util.Collection;
import java.util.Optional;

/**
 * Parameters request to list all regions by criteria
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/numbers/api-reference/numbers/tag/Available-Regions/">https://developers.sinch.com/docs/numbers/api-reference/numbers/tag/Available-Regions/</a>
 * @since 1.0
 */
public class AvailableRegionListAllRequestParameters {

  private final Collection<NumberType> types;

  /** @param types Only return regions for which numbers are provided with the given types */
  public AvailableRegionListAllRequestParameters(Collection<NumberType> types) {
    this.types = types;
  }

  public Optional<Collection<NumberType>> getTypes() {
    return Optional.ofNullable(types);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {
    Collection<NumberType> types;

    private Builder() {}

    public Builder setTypes(Collection<NumberType> types) {
      this.types = types;
      return this;
    }

    public AvailableRegionListAllRequestParameters build() {
      return new AvailableRegionListAllRequestParameters(types);
    }
  }
}
