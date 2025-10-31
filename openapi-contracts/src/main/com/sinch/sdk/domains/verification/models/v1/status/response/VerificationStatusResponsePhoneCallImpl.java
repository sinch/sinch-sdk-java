package com.sinch.sdk.domains.verification.models.v1.status.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.verification.models.v1.Identity;
import com.sinch.sdk.domains.verification.models.v1.VerificationStatus;
import com.sinch.sdk.domains.verification.models.v1.VerificationStatusReason;
import com.sinch.sdk.domains.verification.models.v1.status.StatusCallResult;
import com.sinch.sdk.domains.verification.models.v1.status.StatusPrice;
import java.time.Instant;
import java.util.Objects;

@JsonPropertyOrder({
  VerificationStatusResponsePhoneCallImpl.JSON_PROPERTY_ID,
  VerificationStatusResponsePhoneCallImpl.JSON_PROPERTY_STATUS,
  VerificationStatusResponsePhoneCallImpl.JSON_PROPERTY_REASON,
  VerificationStatusResponsePhoneCallImpl.JSON_PROPERTY_REFERENCE,
  VerificationStatusResponsePhoneCallImpl.JSON_PROPERTY_IDENTITY,
  VerificationStatusResponsePhoneCallImpl.JSON_PROPERTY_COUNTRY_ID,
  VerificationStatusResponsePhoneCallImpl.JSON_PROPERTY_VERIFICATION_TIMESTAMP,
  VerificationStatusResponsePhoneCallImpl.JSON_PROPERTY_METHOD,
  VerificationStatusResponsePhoneCallImpl.JSON_PROPERTY_CALL_COMPLETE,
  VerificationStatusResponsePhoneCallImpl.JSON_PROPERTY_CALL_RESULT,
  VerificationStatusResponsePhoneCallImpl.JSON_PROPERTY_PRICE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VerificationStatusResponsePhoneCallImpl
    implements VerificationStatusResponsePhoneCall,
        com.sinch.sdk.domains.verification.models.v1.status.response.VerificationStatusResponse {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ID = "id";

  private OptionalValue<String> id;

  public static final String JSON_PROPERTY_STATUS = "status";

  private OptionalValue<VerificationStatus> status;

  public static final String JSON_PROPERTY_REASON = "reason";

  private OptionalValue<VerificationStatusReason> reason;

  public static final String JSON_PROPERTY_REFERENCE = "reference";

  private OptionalValue<String> reference;

  public static final String JSON_PROPERTY_IDENTITY = "identity";

  private OptionalValue<Identity> identity;

  public static final String JSON_PROPERTY_COUNTRY_ID = "countryId";

  private OptionalValue<String> countryId;

  public static final String JSON_PROPERTY_VERIFICATION_TIMESTAMP = "verificationTimestamp";

  private OptionalValue<Instant> verificationTimestamp;

  public static final String JSON_PROPERTY_METHOD = "method";

  private OptionalValue<MethodEnum> method;

  public static final String JSON_PROPERTY_CALL_COMPLETE = "callComplete";

  private OptionalValue<Boolean> callComplete;

  public static final String JSON_PROPERTY_CALL_RESULT = "callResult";

  private OptionalValue<StatusCallResult> callResult;

  public static final String JSON_PROPERTY_PRICE = "price";

  private OptionalValue<StatusPrice> price;

  public VerificationStatusResponsePhoneCallImpl() {}

  protected VerificationStatusResponsePhoneCallImpl(
      OptionalValue<String> id,
      OptionalValue<VerificationStatus> status,
      OptionalValue<VerificationStatusReason> reason,
      OptionalValue<String> reference,
      OptionalValue<Identity> identity,
      OptionalValue<String> countryId,
      OptionalValue<Instant> verificationTimestamp,
      OptionalValue<MethodEnum> method,
      OptionalValue<Boolean> callComplete,
      OptionalValue<StatusCallResult> callResult,
      OptionalValue<StatusPrice> price) {
    this.id = id;
    this.status = status;
    this.reason = reason;
    this.reference = reference;
    this.identity = identity;
    this.countryId = countryId;
    this.verificationTimestamp = verificationTimestamp;
    this.method = method;
    this.callComplete = callComplete;
    this.callResult = callResult;
    this.price = price;
  }

  @JsonIgnore
  public String getId() {
    return id.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> id() {
    return id;
  }

  @JsonIgnore
  public VerificationStatus getStatus() {
    return status.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<VerificationStatus> status() {
    return status;
  }

  @JsonIgnore
  public VerificationStatusReason getReason() {
    return reason.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_REASON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<VerificationStatusReason> reason() {
    return reason;
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
  public Identity getIdentity() {
    return identity.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_IDENTITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Identity> identity() {
    return identity;
  }

  @JsonIgnore
  public String getCountryId() {
    return countryId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_COUNTRY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> countryId() {
    return countryId;
  }

  @JsonIgnore
  public Instant getVerificationTimestamp() {
    return verificationTimestamp.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_VERIFICATION_TIMESTAMP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Instant> verificationTimestamp() {
    return verificationTimestamp;
  }

  @JsonIgnore
  public MethodEnum getMethod() {
    return method.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_METHOD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<MethodEnum> method() {
    return method;
  }

  @JsonIgnore
  public Boolean getCallComplete() {
    return callComplete.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CALL_COMPLETE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Boolean> callComplete() {
    return callComplete;
  }

  @JsonIgnore
  public StatusCallResult getCallResult() {
    return callResult.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CALL_RESULT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<StatusCallResult> callResult() {
    return callResult;
  }

  @JsonIgnore
  public StatusPrice getPrice() {
    return price.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PRICE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<StatusPrice> price() {
    return price;
  }

  /** Return true if this VerificationStatusResponsePhoneCall object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VerificationStatusResponsePhoneCallImpl verificationStatusResponsePhoneCall =
        (VerificationStatusResponsePhoneCallImpl) o;
    return Objects.equals(this.id, verificationStatusResponsePhoneCall.id)
        && Objects.equals(this.status, verificationStatusResponsePhoneCall.status)
        && Objects.equals(this.reason, verificationStatusResponsePhoneCall.reason)
        && Objects.equals(this.reference, verificationStatusResponsePhoneCall.reference)
        && Objects.equals(this.identity, verificationStatusResponsePhoneCall.identity)
        && Objects.equals(this.countryId, verificationStatusResponsePhoneCall.countryId)
        && Objects.equals(
            this.verificationTimestamp, verificationStatusResponsePhoneCall.verificationTimestamp)
        && Objects.equals(this.method, verificationStatusResponsePhoneCall.method)
        && Objects.equals(this.callComplete, verificationStatusResponsePhoneCall.callComplete)
        && Objects.equals(this.callResult, verificationStatusResponsePhoneCall.callResult)
        && Objects.equals(this.price, verificationStatusResponsePhoneCall.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        id,
        status,
        reason,
        reference,
        identity,
        countryId,
        verificationTimestamp,
        method,
        callComplete,
        callResult,
        price);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VerificationStatusResponsePhoneCallImpl {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
    sb.append("    identity: ").append(toIndentedString(identity)).append("\n");
    sb.append("    countryId: ").append(toIndentedString(countryId)).append("\n");
    sb.append("    verificationTimestamp: ")
        .append(toIndentedString(verificationTimestamp))
        .append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    callComplete: ").append(toIndentedString(callComplete)).append("\n");
    sb.append("    callResult: ").append(toIndentedString(callResult)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
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
  static class Builder implements VerificationStatusResponsePhoneCall.Builder {
    OptionalValue<String> id = OptionalValue.empty();
    OptionalValue<VerificationStatus> status = OptionalValue.empty();
    OptionalValue<VerificationStatusReason> reason = OptionalValue.empty();
    OptionalValue<String> reference = OptionalValue.empty();
    OptionalValue<Identity> identity = OptionalValue.empty();
    OptionalValue<String> countryId = OptionalValue.empty();
    OptionalValue<Instant> verificationTimestamp = OptionalValue.empty();
    OptionalValue<MethodEnum> method = OptionalValue.of(MethodEnum.PHONE_CALL);
    OptionalValue<Boolean> callComplete = OptionalValue.empty();
    OptionalValue<StatusCallResult> callResult = OptionalValue.empty();
    OptionalValue<StatusPrice> price = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_ID)
    public Builder setId(String id) {
      this.id = OptionalValue.of(id);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_STATUS)
    public Builder setStatus(VerificationStatus status) {
      this.status = OptionalValue.of(status);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_REASON)
    public Builder setReason(VerificationStatusReason reason) {
      this.reason = OptionalValue.of(reason);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_REFERENCE)
    public Builder setReference(String reference) {
      this.reference = OptionalValue.of(reference);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_IDENTITY)
    public Builder setIdentity(Identity identity) {
      this.identity = OptionalValue.of(identity);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_COUNTRY_ID)
    public Builder setCountryId(String countryId) {
      this.countryId = OptionalValue.of(countryId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_VERIFICATION_TIMESTAMP)
    public Builder setVerificationTimestamp(Instant verificationTimestamp) {
      this.verificationTimestamp = OptionalValue.of(verificationTimestamp);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_METHOD)
    Builder setMethod(MethodEnum method) {
      if (!Objects.equals(method, MethodEnum.PHONE_CALL)) {
        throw new IllegalArgumentException(
            String.format("'method' must be '%s' (is '%s')", MethodEnum.PHONE_CALL, method));
      }
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CALL_COMPLETE)
    public Builder setCallComplete(Boolean callComplete) {
      this.callComplete = OptionalValue.of(callComplete);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CALL_RESULT)
    public Builder setCallResult(StatusCallResult callResult) {
      this.callResult = OptionalValue.of(callResult);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_PRICE)
    public Builder setPrice(StatusPrice price) {
      this.price = OptionalValue.of(price);
      return this;
    }

    public VerificationStatusResponsePhoneCall build() {
      return new VerificationStatusResponsePhoneCallImpl(
          id,
          status,
          reason,
          reference,
          identity,
          countryId,
          verificationTimestamp,
          method,
          callComplete,
          callResult,
          price);
    }
  }
}
