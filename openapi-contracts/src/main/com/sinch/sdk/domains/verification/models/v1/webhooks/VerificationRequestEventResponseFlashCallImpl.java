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
import com.sinch.sdk.domains.verification.models.v1.webhooks.internal.VerificationRequestEventResponseFlashCallContent;
import com.sinch.sdk.domains.verification.models.v1.webhooks.internal.VerificationRequestEventResponseFlashCallContentImpl;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@JsonPropertyOrder({
  VerificationRequestEventResponseFlashCallImpl.JSON_PROPERTY_ACTION,
  VerificationRequestEventResponseFlashCallImpl.JSON_PROPERTY_FLASH_CALL
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VerificationRequestEventResponseFlashCallImpl
    implements VerificationRequestEventResponseFlashCall,
        com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationRequestEventResponse {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ACTION = "action";

  private OptionalValue<VerificationEventResponseAction> action;

  public static final String JSON_PROPERTY_FLASH_CALL = "flashCall";

  private OptionalValue<VerificationRequestEventResponseFlashCallContent> flashCall;

  public VerificationRequestEventResponseFlashCallImpl() {}

  protected VerificationRequestEventResponseFlashCallImpl(
      OptionalValue<VerificationEventResponseAction> action,
      OptionalValue<VerificationRequestEventResponseFlashCallContent> flashCall) {
    this.action = action;
    this.flashCall = flashCall;
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
  public VerificationRequestEventResponseFlashCallContent getFlashCall() {
    return flashCall.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FLASH_CALL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<VerificationRequestEventResponseFlashCallContent> flashCall() {
    return flashCall;
  }

  @JsonIgnore
  public String getCli() {
    if (null == flashCall || !flashCall.isPresent() || null == flashCall.get().getCli()) {
      return null;
    }
    return flashCall.get().getCli();
  }

  public OptionalValue<String> cli() {
    return null != flashCall && flashCall.isPresent()
        ? flashCall
            .map(f -> ((VerificationRequestEventResponseFlashCallContentImpl) f).cli())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public Integer getDialTimeout() {
    if (null == flashCall || !flashCall.isPresent() || null == flashCall.get().getDialTimeout()) {
      return null;
    }
    return flashCall.get().getDialTimeout();
  }

  public OptionalValue<Integer> dialTimeout() {
    return null != flashCall && flashCall.isPresent()
        ? flashCall
            .map(f -> ((VerificationRequestEventResponseFlashCallContentImpl) f).dialTimeout())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  /** Return true if this VerificationRequestEventResponseFlashCall object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VerificationRequestEventResponseFlashCallImpl verificationRequestEventResponseFlashCall =
        (VerificationRequestEventResponseFlashCallImpl) o;
    return Objects.equals(this.action, verificationRequestEventResponseFlashCall.action)
        && Objects.equals(this.flashCall, verificationRequestEventResponseFlashCall.flashCall);
  }

  @Override
  public int hashCode() {
    return Objects.hash(action, flashCall);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VerificationRequestEventResponseFlashCallImpl {\n");
    sb.append("    action: ").append(toIndentedString(action)).append("\n");
    sb.append("    flashCall: ").append(toIndentedString(flashCall)).append("\n");
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
  static class Builder implements VerificationRequestEventResponseFlashCall.Builder {
    OptionalValue<VerificationEventResponseAction> action = OptionalValue.empty();
    OptionalValue<VerificationRequestEventResponseFlashCallContent> flashCall =
        OptionalValue.empty();

    VerificationRequestEventResponseFlashCallContent.Builder _delegatedBuilder = null;

    @JsonProperty(value = JSON_PROPERTY_ACTION, required = true)
    public Builder setAction(VerificationEventResponseAction action) {
      this.action = OptionalValue.of(action);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_FLASH_CALL)
    public Builder setFlashCall(VerificationRequestEventResponseFlashCallContent flashCall) {
      this.flashCall = OptionalValue.of(flashCall);
      return this;
    }

    @JsonIgnore
    public Builder setCli(String cli) {
      getDelegatedBuilder().setCli(cli);
      return this;
    }

    @JsonIgnore
    public Builder setDialTimeout(Integer dialTimeout) {
      getDelegatedBuilder().setDialTimeout(dialTimeout);
      return this;
    }

    private VerificationRequestEventResponseFlashCallContent.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = VerificationRequestEventResponseFlashCallContent.builder();
      }
      return this._delegatedBuilder;
    }

    public VerificationRequestEventResponseFlashCall build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.flashCall = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new VerificationRequestEventResponseFlashCallImpl(action, flashCall);
    }
  }

  public static class DelegatedSerializer
      extends JsonSerializer<OptionalValue<VerificationRequestEventResponseFlashCall>> {
    @Override
    public void serialize(
        OptionalValue<VerificationRequestEventResponseFlashCall> value,
        JsonGenerator jgen,
        SerializerProvider provider)
        throws IOException {

      if (!value.isPresent()) {
        return;
      }
      VerificationRequestEventResponseFlashCallImpl impl =
          (VerificationRequestEventResponseFlashCallImpl) value.get();
      jgen.writeObject(null != impl ? impl.getFlashCall() : null);
    }
  }

  public static class DelegatedDeSerializer
      extends JsonDeserializer<VerificationRequestEventResponseFlashCall> {
    @Override
    public VerificationRequestEventResponseFlashCall deserialize(
        JsonParser jp, DeserializationContext ctxt) throws IOException {

      VerificationRequestEventResponseFlashCallImpl.Builder builder =
          new VerificationRequestEventResponseFlashCallImpl.Builder();
      VerificationRequestEventResponseFlashCallContentImpl deserialized =
          jp.readValueAs(VerificationRequestEventResponseFlashCallContentImpl.class);
      builder.setFlashCall(deserialized);
      return builder.build();
    }
  }

  public static Optional<VerificationRequestEventResponseFlashCall> delegatedConverter(
      VerificationRequestEventResponseFlashCallContent internal) {
    if (null == internal) {
      return Optional.empty();
    }
    return Optional.of(new Builder().setFlashCall(internal).build());
  }
}
