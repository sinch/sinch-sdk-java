package com.sinch.sdk.domains.numbers.models.requests;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.numbers.models.NumberType;
import java.util.Collection;

/**
 * Parameters request to list all regions by criteria
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/numbers/api-reference/numbers/tag/Available-Regions/">https://developers.sinch.com/docs/numbers/api-reference/numbers/tag/Available-Regions/</a>
 * @since 1.0
 */
public class AvailableRegionListAllRequestParameters {

  private final OptionalValue<Collection<NumberType>> types;

  private AvailableRegionListAllRequestParameters(OptionalValue<Collection<NumberType>> types) {
    this.types = types;
  }

  public OptionalValue<Collection<NumberType>> getTypes() {
    return types;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {
    OptionalValue<Collection<NumberType>> types = OptionalValue.empty();

    private Builder() {}

    /**
     * @param types Only return regions for which numbers are provided with the given types
     * @return current builder
     */
    public Builder setTypes(Collection<NumberType> types) {
      this.types = OptionalValue.of(types);
      return this;
    }

    public AvailableRegionListAllRequestParameters build() {
      return new AvailableRegionListAllRequestParameters(types);
    }
  }
}
