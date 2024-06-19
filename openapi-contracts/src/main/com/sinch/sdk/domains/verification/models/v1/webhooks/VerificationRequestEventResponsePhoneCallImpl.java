package com.sinch.sdk.domains.verification.models.v1.webhooks;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.verification.models.v1.start.request.PhoneCallSpeech;
import com.sinch.sdk.domains.verification.models.v1.webhooks.internal.VerificationRequestEventResponsePhoneCallContent;
import java.util.Objects;

@JsonPropertyOrder({
  VerificationRequestEventResponsePhoneCallImpl.JSON_PROPERTY_ACTION,
  VerificationRequestEventResponsePhoneCallImpl.JSON_PROPERTY_CALLOUT
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VerificationRequestEventResponsePhoneCallImpl
    implements VerificationRequestEventResponsePhoneCall,
        com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationRequestEventResponse {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ACTION = "action";

  private OptionalValue<VerificationEventResponseAction> action;

  public static final String JSON_PROPERTY_CALLOUT = "callout";

  private OptionalValue<VerificationRequestEventResponsePhoneCallContent> callout;

  public VerificationRequestEventResponsePhoneCallImpl() {}

  protected VerificationRequestEventResponsePhoneCallImpl(
      OptionalValue<VerificationEventResponseAction> action,
      OptionalValue<VerificationRequestEventResponsePhoneCallContent> callout) {
    this.action = action;
    this.callout = callout;
  }

  @JsonIgnore
  public VerificationEventResponseAction getAction() {
    return action.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ACTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<VerificationEventResponseAction> action() {
    return action;
  }

  @JsonIgnore
  public VerificationRequestEventResponsePhoneCallContent getCallout() {
    return callout.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CALLOUT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<VerificationRequestEventResponsePhoneCallContent> callout() {
    return callout;
  }

  @JsonIgnore
  public String getCode() {
    if (null == callout || !callout.isPresent() || null == callout.get().getCode()) {
      return null;
    }
    return callout.get().getCode();
  }

  public OptionalValue<String> code() {
    return null != callout
        ? callout.map(VerificationRequestEventResponsePhoneCallContent::getCode)
        : OptionalValue.empty();
  }

  @JsonIgnore
  public PhoneCallSpeech getSpeech() {
    if (null == callout || !callout.isPresent() || null == callout.get().getSpeech()) {
      return null;
    }
    return callout.get().getSpeech();
  }

  public OptionalValue<PhoneCallSpeech> speech() {
    return null != callout
        ? callout.map(VerificationRequestEventResponsePhoneCallContent::getSpeech)
        : OptionalValue.empty();
  }

  /** Return true if this VerificationRequestEventResponsePhoneCall object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VerificationRequestEventResponsePhoneCallImpl verificationRequestEventResponsePhoneCall =
        (VerificationRequestEventResponsePhoneCallImpl) o;
    return Objects.equals(this.action, verificationRequestEventResponsePhoneCall.action)
        && Objects.equals(this.callout, verificationRequestEventResponsePhoneCall.callout);
  }

  @Override
  public int hashCode() {
    return Objects.hash(action, callout);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VerificationRequestEventResponsePhoneCallImpl {\n");
    sb.append("    action: ").append(toIndentedString(action)).append("\n");
    sb.append("    callout: ").append(toIndentedString(callout)).append("\n");
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
  static class Builder implements VerificationRequestEventResponsePhoneCall.Builder {
    OptionalValue<VerificationEventResponseAction> action = OptionalValue.empty();
    OptionalValue<VerificationRequestEventResponsePhoneCallContent> callout = OptionalValue.empty();

    VerificationRequestEventResponsePhoneCallContent.Builder _delegatedBuilder = null;

    @JsonProperty(JSON_PROPERTY_ACTION)
    public Builder setAction(VerificationEventResponseAction action) {
      this.action = OptionalValue.of(action);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CALLOUT)
    public Builder setCallout(VerificationRequestEventResponsePhoneCallContent callout) {
      this.callout = OptionalValue.of(callout);
      return this;
    }

    @JsonIgnore
    public Builder setCode(String code) {
      getDelegatedBuilder().setCode(code);
      return this;
    }

    @JsonIgnore
    public Builder setSpeech(PhoneCallSpeech speech) {
      getDelegatedBuilder().setSpeech(speech);
      return this;
    }

    private VerificationRequestEventResponsePhoneCallContent.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = VerificationRequestEventResponsePhoneCallContent.builder();
      }
      return this._delegatedBuilder;
    }

    public VerificationRequestEventResponsePhoneCall build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.callout = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new VerificationRequestEventResponsePhoneCallImpl(action, callout);
    }
  }
}
