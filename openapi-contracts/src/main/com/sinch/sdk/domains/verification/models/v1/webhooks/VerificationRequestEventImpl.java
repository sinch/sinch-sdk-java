package com.sinch.sdk.domains.verification.models.v1.webhooks;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.verification.models.v1.Price;
import com.sinch.sdk.domains.verification.models.v1.internal.IdentityInternal;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  VerificationRequestEventImpl.JSON_PROPERTY_ID,
  VerificationRequestEventImpl.JSON_PROPERTY_EVENT,
  VerificationRequestEventImpl.JSON_PROPERTY_METHOD,
  VerificationRequestEventImpl.JSON_PROPERTY_IDENTITY,
  VerificationRequestEventImpl.JSON_PROPERTY_PRICE,
  VerificationRequestEventImpl.JSON_PROPERTY_REFERENCE,
  VerificationRequestEventImpl.JSON_PROPERTY_CUSTOM,
  VerificationRequestEventImpl.JSON_PROPERTY_ACCEPT_LANGUAGE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VerificationRequestEventImpl implements VerificationRequestEvent {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ID = "id";

  private OptionalValue<String> id;

  public static final String JSON_PROPERTY_EVENT = "event";

  private OptionalValue<EventEnum> event;

  public static final String JSON_PROPERTY_METHOD = "method";

  private OptionalValue<MethodEnum> method;

  public static final String JSON_PROPERTY_IDENTITY = "identity";

  private OptionalValue<IdentityInternal> identity;

  public static final String JSON_PROPERTY_PRICE = "price";

  private OptionalValue<Price> price;

  public static final String JSON_PROPERTY_REFERENCE = "reference";

  private OptionalValue<String> reference;

  public static final String JSON_PROPERTY_CUSTOM = "custom";

  private OptionalValue<String> custom;

  public static final String JSON_PROPERTY_ACCEPT_LANGUAGE = "acceptLanguage";

  private OptionalValue<List<String>> acceptLanguage;

  public VerificationRequestEventImpl() {}

  protected VerificationRequestEventImpl(
      OptionalValue<String> id,
      OptionalValue<EventEnum> event,
      OptionalValue<MethodEnum> method,
      OptionalValue<IdentityInternal> identity,
      OptionalValue<Price> price,
      OptionalValue<String> reference,
      OptionalValue<String> custom,
      OptionalValue<List<String>> acceptLanguage) {
    this.id = id;
    this.event = event;
    this.method = method;
    this.identity = identity;
    this.price = price;
    this.reference = reference;
    this.custom = custom;
    this.acceptLanguage = acceptLanguage;
  }

  @JsonIgnore
  public String getId() {
    return id.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> id() {
    return id;
  }

  @JsonIgnore
  public EventEnum getEvent() {
    return event.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_EVENT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<EventEnum> event() {
    return event;
  }

  @JsonIgnore
  public MethodEnum getMethod() {
    return method.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_METHOD)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<MethodEnum> method() {
    return method;
  }

  @JsonIgnore
  public IdentityInternal getIdentity() {
    return identity.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_IDENTITY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<IdentityInternal> identity() {
    return identity;
  }

  @JsonIgnore
  public Price getPrice() {
    return price.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PRICE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Price> price() {
    return price;
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

  @JsonIgnore
  public List<String> getAcceptLanguage() {
    return acceptLanguage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ACCEPT_LANGUAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<String>> acceptLanguage() {
    return acceptLanguage;
  }

  /** Return true if this VerificationRequestEvent object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VerificationRequestEventImpl verificationRequestEvent = (VerificationRequestEventImpl) o;
    return Objects.equals(this.id, verificationRequestEvent.id)
        && Objects.equals(this.event, verificationRequestEvent.event)
        && Objects.equals(this.method, verificationRequestEvent.method)
        && Objects.equals(this.identity, verificationRequestEvent.identity)
        && Objects.equals(this.price, verificationRequestEvent.price)
        && Objects.equals(this.reference, verificationRequestEvent.reference)
        && Objects.equals(this.custom, verificationRequestEvent.custom)
        && Objects.equals(this.acceptLanguage, verificationRequestEvent.acceptLanguage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, event, method, identity, price, reference, custom, acceptLanguage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VerificationRequestEventImpl {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    event: ").append(toIndentedString(event)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    identity: ").append(toIndentedString(identity)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
    sb.append("    custom: ").append(toIndentedString(custom)).append("\n");
    sb.append("    acceptLanguage: ").append(toIndentedString(acceptLanguage)).append("\n");
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
  static class Builder implements VerificationRequestEvent.Builder {
    OptionalValue<String> id = OptionalValue.empty();
    OptionalValue<EventEnum> event = OptionalValue.empty();
    OptionalValue<MethodEnum> method = OptionalValue.empty();
    OptionalValue<IdentityInternal> identity = OptionalValue.empty();
    OptionalValue<Price> price = OptionalValue.empty();
    OptionalValue<String> reference = OptionalValue.empty();
    OptionalValue<String> custom = OptionalValue.empty();
    OptionalValue<List<String>> acceptLanguage = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_ID)
    public Builder setId(String id) {
      this.id = OptionalValue.of(id);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_EVENT)
    public Builder setEvent(EventEnum event) {
      this.event = OptionalValue.of(event);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_METHOD)
    public Builder setMethod(MethodEnum method) {
      this.method = OptionalValue.of(method);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_IDENTITY)
    public Builder setIdentity(IdentityInternal identity) {
      this.identity = OptionalValue.of(identity);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_PRICE)
    public Builder setPrice(Price price) {
      this.price = OptionalValue.of(price);
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

    @JsonProperty(JSON_PROPERTY_ACCEPT_LANGUAGE)
    public Builder setAcceptLanguage(List<String> acceptLanguage) {
      this.acceptLanguage = OptionalValue.of(acceptLanguage);
      return this;
    }

    public VerificationRequestEvent build() {
      return new VerificationRequestEventImpl(
          id, event, method, identity, price, reference, custom, acceptLanguage);
    }
  }
}
