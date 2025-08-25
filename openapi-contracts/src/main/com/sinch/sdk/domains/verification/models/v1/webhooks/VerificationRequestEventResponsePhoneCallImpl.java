package com.sinch.sdk.domains.verification.models.v1.webhooks;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.verification.models.v1.start.request.PhoneCallSpeech;
import com.sinch.sdk.domains.verification.models.v1.webhooks.internal.VerificationRequestEventResponsePhoneCallContent;
import com.sinch.sdk.domains.verification.models.v1.webhooks.internal.VerificationRequestEventResponsePhoneCallContentImpl;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

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
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
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
    return null != callout && callout.isPresent()
        ? callout
            .map(f -> ((VerificationRequestEventResponsePhoneCallContentImpl) f).code())
            .orElse(OptionalValue.empty())
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
    return null != callout && callout.isPresent()
        ? callout
            .map(f -> ((VerificationRequestEventResponsePhoneCallContentImpl) f).speech())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public Object getExtraOption(String key) {
    return null != callout && callout.isPresent() ? callout.get().get(key) : null;
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

    @JsonProperty(value = JSON_PROPERTY_ACTION, required = true)
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

    public Builder putExtraOption(String key, Object value) {
      getDelegatedBuilder().put(key, value);
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

  public static class DelegatedSerializer
      extends JsonSerializer<OptionalValue<VerificationRequestEventResponsePhoneCall>> {
    @Override
    public void serialize(
        OptionalValue<VerificationRequestEventResponsePhoneCall> value,
        JsonGenerator jgen,
        SerializerProvider provider)
        throws IOException {

      if (!value.isPresent()) {
        return;
      }
      VerificationRequestEventResponsePhoneCallImpl impl =
          (VerificationRequestEventResponsePhoneCallImpl) value.get();
      jgen.writeObject(null != impl ? impl.getCallout() : null);
    }
  }

  public static class DelegatedDeSerializer
      extends JsonDeserializer<VerificationRequestEventResponsePhoneCall> {
    @Override
    public VerificationRequestEventResponsePhoneCall deserialize(
        JsonParser jp, DeserializationContext ctxt) throws IOException {

      VerificationRequestEventResponsePhoneCallImpl.Builder builder =
          new VerificationRequestEventResponsePhoneCallImpl.Builder();
      VerificationRequestEventResponsePhoneCallContentImpl deserialized =
          jp.readValueAs(VerificationRequestEventResponsePhoneCallContentImpl.class);
      builder.setCallout(deserialized);
      return builder.build();
    }
  }

  public static Optional<VerificationRequestEventResponsePhoneCall> delegatedConverter(
      VerificationRequestEventResponsePhoneCallContent internal) {
    if (null == internal) {
      return Optional.empty();
    }
    return Optional.of(new Builder().setCallout(internal).build());
  }
}
