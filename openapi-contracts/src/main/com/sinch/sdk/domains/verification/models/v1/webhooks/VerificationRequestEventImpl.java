package com.sinch.sdk.domains.verification.models.v1.webhooks;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.verification.models.v1.Identity;
import com.sinch.sdk.domains.verification.models.v1.Price;
import com.sinch.sdk.domains.verification.models.v1.VerificationMethod;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  VerificationRequestEventImpl.JSON_PROPERTY_ID,
  VerificationRequestEventImpl.JSON_PROPERTY_EVENT,
  VerificationRequestEventImpl.JSON_PROPERTY_METHOD,
  VerificationRequestEventImpl.JSON_PROPERTY_IDENTITY,
  VerificationRequestEventImpl.JSON_PROPERTY_REFERENCE,
  VerificationRequestEventImpl.JSON_PROPERTY_CUSTOM,
  VerificationRequestEventImpl.JSON_PROPERTY_PRICE,
  VerificationRequestEventImpl.JSON_PROPERTY_ACCEPT_LANGUAGE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VerificationRequestEventImpl
    implements VerificationRequestEvent,
        com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationEvent {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ID = "id";

  private OptionalValue<String> id;

  public static final String JSON_PROPERTY_EVENT = "event";

  private OptionalValue<EventEnum> event;

  public static final String JSON_PROPERTY_METHOD = "method";

  private OptionalValue<VerificationMethod> method;

  public static final String JSON_PROPERTY_IDENTITY = "identity";

  private OptionalValue<Identity> identity;

  public static final String JSON_PROPERTY_REFERENCE = "reference";

  private OptionalValue<String> reference;

  public static final String JSON_PROPERTY_CUSTOM = "custom";

  private OptionalValue<String> custom;

  public static final String JSON_PROPERTY_PRICE = "price";

  private OptionalValue<Price> price;

  public static final String JSON_PROPERTY_ACCEPT_LANGUAGE = "acceptLanguage";

  private OptionalValue<List<String>> acceptLanguage;

  public VerificationRequestEventImpl() {}

  protected VerificationRequestEventImpl(
      OptionalValue<String> id,
      OptionalValue<EventEnum> event,
      OptionalValue<VerificationMethod> method,
      OptionalValue<Identity> identity,
      OptionalValue<String> reference,
      OptionalValue<String> custom,
      OptionalValue<Price> price,
      OptionalValue<List<String>> acceptLanguage) {
    this.id = id;
    this.event = event;
    this.method = method;
    this.identity = identity;
    this.reference = reference;
    this.custom = custom;
    this.price = price;
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
  public VerificationMethod getMethod() {
    return method.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_METHOD)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<VerificationMethod> method() {
    return method;
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
  public Price getPrice() {
    return price.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PRICE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Price> price() {
    return price;
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
        && Objects.equals(this.reference, verificationRequestEvent.reference)
        && Objects.equals(this.custom, verificationRequestEvent.custom)
        && Objects.equals(this.price, verificationRequestEvent.price)
        && Objects.equals(this.acceptLanguage, verificationRequestEvent.acceptLanguage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, event, method, identity, reference, custom, price, acceptLanguage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VerificationRequestEventImpl {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    event: ").append(toIndentedString(event)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    identity: ").append(toIndentedString(identity)).append("\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
    sb.append("    custom: ").append(toIndentedString(custom)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
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
    OptionalValue<EventEnum> event = OptionalValue.of(EventEnum.VERIFICATION_REQUEST_EVENT);
    OptionalValue<VerificationMethod> method = OptionalValue.empty();
    OptionalValue<Identity> identity = OptionalValue.empty();
    OptionalValue<String> reference = OptionalValue.empty();
    OptionalValue<String> custom = OptionalValue.empty();
    OptionalValue<Price> price = OptionalValue.empty();
    OptionalValue<List<String>> acceptLanguage = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_ID, required = true)
    public Builder setId(String id) {
      this.id = OptionalValue.of(id);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_EVENT, required = true)
    Builder setEvent(EventEnum event) {
      if (!Objects.equals(event, EventEnum.VERIFICATION_REQUEST_EVENT)) {
        throw new IllegalArgumentException(
            String.format(
                "'event' must be '%s' (is '%s')", EventEnum.VERIFICATION_REQUEST_EVENT, event));
      }
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_METHOD, required = true)
    public Builder setMethod(VerificationMethod method) {
      this.method = OptionalValue.of(method);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_IDENTITY, required = true)
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

    @JsonProperty(JSON_PROPERTY_PRICE)
    public Builder setPrice(Price price) {
      this.price = OptionalValue.of(price);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ACCEPT_LANGUAGE)
    public Builder setAcceptLanguage(List<String> acceptLanguage) {
      this.acceptLanguage = OptionalValue.of(acceptLanguage);
      return this;
    }

    public VerificationRequestEvent build() {
      return new VerificationRequestEventImpl(
          id, event, method, identity, reference, custom, price, acceptLanguage);
    }
  }
}
