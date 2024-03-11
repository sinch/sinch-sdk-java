package com.sinch.sdk.domains.conversation.models.v1.credentials;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({StaticBearerFieldImpl.JSON_PROPERTY_STATIC_BEARER})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class StaticBearerFieldImpl implements StaticBearerField {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_STATIC_BEARER = "static_bearer";

  private OptionalValue<StaticBearerCredentials> staticBearer;

  public StaticBearerFieldImpl() {}

  protected StaticBearerFieldImpl(OptionalValue<StaticBearerCredentials> staticBearer) {
    this.staticBearer = staticBearer;
  }

  @JsonIgnore
  public StaticBearerCredentials getStaticBearer() {
    return staticBearer.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_STATIC_BEARER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<StaticBearerCredentials> staticBearer() {
    return staticBearer;
  }

  /** Return true if this StaticBearerField object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StaticBearerFieldImpl staticBearerField = (StaticBearerFieldImpl) o;
    return Objects.equals(this.staticBearer, staticBearerField.staticBearer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(staticBearer);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StaticBearerFieldImpl {\n");
    sb.append("    staticBearer: ").append(toIndentedString(staticBearer)).append("\n");
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
  static class Builder implements StaticBearerField.Builder {
    OptionalValue<StaticBearerCredentials> staticBearer = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_STATIC_BEARER)
    public Builder setStaticBearer(StaticBearerCredentials staticBearer) {
      this.staticBearer = OptionalValue.of(staticBearer);
      return this;
    }

    public StaticBearerField build() {
      return new StaticBearerFieldImpl(staticBearer);
    }
  }
}
