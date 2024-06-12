package com.sinch.sdk.domains.verification.models.v1.start.request;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.verification.models.Identity;
import com.sinch.sdk.domains.verification.models.v1.VerificationMethod;
import java.util.Objects;

@JsonPropertyOrder({
  StartVerificationDataRequestImpl.JSON_PROPERTY_IDENTITY,
  StartVerificationDataRequestImpl.JSON_PROPERTY_METHOD,
  StartVerificationDataRequestImpl.JSON_PROPERTY_REFERENCE,
  StartVerificationDataRequestImpl.JSON_PROPERTY_CUSTOM
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class StartVerificationDataRequestImpl
    implements StartVerificationDataRequest,
        com.sinch.sdk.domains.verification.models.v1.start.request.StartVerificationRequest {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_IDENTITY = "identity";

  private OptionalValue<Identity> identity;

  public static final String JSON_PROPERTY_METHOD = "method";

  private OptionalValue<VerificationMethod> method;

  public static final String JSON_PROPERTY_REFERENCE = "reference";

  private OptionalValue<String> reference;

  public static final String JSON_PROPERTY_CUSTOM = "custom";

  private OptionalValue<String> custom;

  public StartVerificationDataRequestImpl() {}

  protected StartVerificationDataRequestImpl(
      OptionalValue<Identity> identity,
      OptionalValue<VerificationMethod> method,
      OptionalValue<String> reference,
      OptionalValue<String> custom) {
    this.identity = identity;
    this.method = method;
    this.reference = reference;
    this.custom = custom;
  }

  @JsonIgnore
  public Identity getIdentity() {
    return identity.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_IDENTITY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Identity> identity() {
    return identity;
  }

  @JsonIgnore
  public VerificationMethod getMethod() {
    return method.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_METHOD)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<VerificationMethod> method() {
    return method;
  }

  @JsonIgnore
  public String getReference() {
    return reference.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> reference() {
    return reference;
  }

  @JsonIgnore
  public String getCustom() {
    return custom.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CUSTOM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> custom() {
    return custom;
  }

  /** Return true if this StartVerificationDataRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StartVerificationDataRequestImpl startVerificationDataRequest =
        (StartVerificationDataRequestImpl) o;
    return Objects.equals(this.identity, startVerificationDataRequest.identity)
        && Objects.equals(this.method, startVerificationDataRequest.method)
        && Objects.equals(this.reference, startVerificationDataRequest.reference)
        && Objects.equals(this.custom, startVerificationDataRequest.custom);
  }

  @Override
  public int hashCode() {
    return Objects.hash(identity, method, reference, custom);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StartVerificationDataRequestImpl {\n");
    sb.append("    identity: ").append(toIndentedString(identity)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
    sb.append("    custom: ").append(toIndentedString(custom)).append("\n");
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
  static class Builder implements StartVerificationDataRequest.Builder {
    OptionalValue<Identity> identity = OptionalValue.empty();
    OptionalValue<VerificationMethod> method = OptionalValue.of(VerificationMethod.DATA);
    OptionalValue<String> reference = OptionalValue.empty();
    OptionalValue<String> custom = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_IDENTITY)
    public Builder setIdentity(Identity identity) {
      this.identity = OptionalValue.of(identity);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_REFERENCE)
    public Builder setReference(String reference) {
      this.reference = OptionalValue.of(reference);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CUSTOM)
    public Builder setCustom(String custom) {
      this.custom = OptionalValue.of(custom);
      return this;
    }

    public StartVerificationDataRequest build() {
      return new StartVerificationDataRequestImpl(identity, method, reference, custom);
    }
  }
}
