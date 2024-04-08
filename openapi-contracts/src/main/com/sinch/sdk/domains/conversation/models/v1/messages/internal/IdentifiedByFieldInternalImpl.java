package com.sinch.sdk.domains.conversation.models.v1.messages.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.IdentifiedBy;
import java.util.Objects;

@JsonPropertyOrder({IdentifiedByFieldInternalImpl.JSON_PROPERTY_IDENTIFIED_BY})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class IdentifiedByFieldInternalImpl implements IdentifiedByFieldInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_IDENTIFIED_BY = "identified_by";

  private OptionalValue<IdentifiedBy> identifiedBy;

  public IdentifiedByFieldInternalImpl() {}

  protected IdentifiedByFieldInternalImpl(OptionalValue<IdentifiedBy> identifiedBy) {
    this.identifiedBy = identifiedBy;
  }

  @JsonIgnore
  public IdentifiedBy getIdentifiedBy() {
    return identifiedBy.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_IDENTIFIED_BY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<IdentifiedBy> identifiedBy() {
    return identifiedBy;
  }

  /** Return true if this IdentifiedByField object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IdentifiedByFieldInternalImpl identifiedByField = (IdentifiedByFieldInternalImpl) o;
    return Objects.equals(this.identifiedBy, identifiedByField.identifiedBy);
  }

  @Override
  public int hashCode() {
    return Objects.hash(identifiedBy);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IdentifiedByFieldInternalImpl {\n");
    sb.append("    identifiedBy: ").append(toIndentedString(identifiedBy)).append("\n");
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
  static class Builder implements IdentifiedByFieldInternal.Builder {
    OptionalValue<IdentifiedBy> identifiedBy = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_IDENTIFIED_BY)
    public Builder setIdentifiedBy(IdentifiedBy identifiedBy) {
      this.identifiedBy = OptionalValue.of(identifiedBy);
      return this;
    }

    public IdentifiedByFieldInternal build() {
      return new IdentifiedByFieldInternalImpl(identifiedBy);
    }
  }
}
