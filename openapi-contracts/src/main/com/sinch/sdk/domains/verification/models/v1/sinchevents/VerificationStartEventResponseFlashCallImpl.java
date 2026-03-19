package com.sinch.sdk.domains.verification.models.v1.sinchevents;

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
import com.sinch.sdk.domains.verification.models.v1.sinchevents.internal.VerificationStartEventResponseFlashCallContent;
import com.sinch.sdk.domains.verification.models.v1.sinchevents.internal.VerificationStartEventResponseFlashCallContentImpl;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@JsonPropertyOrder({
  VerificationStartEventResponseFlashCallImpl.JSON_PROPERTY_ACTION,
  VerificationStartEventResponseFlashCallImpl.JSON_PROPERTY_FLASH_CALL
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VerificationStartEventResponseFlashCallImpl
    implements VerificationStartEventResponseFlashCall,
        com.sinch.sdk.domains.verification.models.v1.sinchevents.VerificationStartEventResponse {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ACTION = "action";

  private OptionalValue<VerificationStartEventAction> action;

  public static final String JSON_PROPERTY_FLASH_CALL = "flashCall";

  private OptionalValue<VerificationStartEventResponseFlashCallContent> flashCall;

  public VerificationStartEventResponseFlashCallImpl() {}

  protected VerificationStartEventResponseFlashCallImpl(
      OptionalValue<VerificationStartEventAction> action,
      OptionalValue<VerificationStartEventResponseFlashCallContent> flashCall) {
    this.action = action;
    this.flashCall = flashCall;
  }

  @JsonIgnore
  public VerificationStartEventAction getAction() {
    return action.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ACTION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<VerificationStartEventAction> action() {
    return action;
  }

  @JsonIgnore
  public VerificationStartEventResponseFlashCallContent getFlashCall() {
    return flashCall.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FLASH_CALL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<VerificationStartEventResponseFlashCallContent> flashCall() {
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
            .map(f -> ((VerificationStartEventResponseFlashCallContentImpl) f).cli())
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
            .map(f -> ((VerificationStartEventResponseFlashCallContentImpl) f).dialTimeout())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public Integer getInterceptionTimeout() {
    if (null == flashCall
        || !flashCall.isPresent()
        || null == flashCall.get().getInterceptionTimeout()) {
      return null;
    }
    return flashCall.get().getInterceptionTimeout();
  }

  public OptionalValue<Integer> interceptionTimeout() {
    return null != flashCall && flashCall.isPresent()
        ? flashCall
            .map(
                f -> ((VerificationStartEventResponseFlashCallContentImpl) f).interceptionTimeout())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public Object getExtraOption(String key) {
    return null != flashCall && flashCall.isPresent() ? flashCall.get().get(key) : null;
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
    VerificationStartEventResponseFlashCallImpl verificationRequestEventResponseFlashCall =
        (VerificationStartEventResponseFlashCallImpl) o;
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
    sb.append("class VerificationStartEventResponseFlashCallImpl {\n");
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
  static class Builder implements VerificationStartEventResponseFlashCall.Builder {
    OptionalValue<VerificationStartEventAction> action = OptionalValue.empty();
    OptionalValue<VerificationStartEventResponseFlashCallContent> flashCall = OptionalValue.empty();

    VerificationStartEventResponseFlashCallContent.Builder _delegatedBuilder = null;

    @JsonProperty(value = JSON_PROPERTY_ACTION, required = true)
    public Builder setAction(VerificationStartEventAction action) {
      this.action = OptionalValue.of(action);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_FLASH_CALL)
    public Builder setFlashCall(VerificationStartEventResponseFlashCallContent flashCall) {
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

    @JsonIgnore
    public Builder setInterceptionTimeout(Integer interceptionTimeout) {
      getDelegatedBuilder().setInterceptionTimeout(interceptionTimeout);
      return this;
    }

    public Builder putExtraOption(String key, Object value) {
      getDelegatedBuilder().put(key, value);
      return this;
    }

    private VerificationStartEventResponseFlashCallContent.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = VerificationStartEventResponseFlashCallContent.builder();
      }
      return this._delegatedBuilder;
    }

    public VerificationStartEventResponseFlashCall build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.flashCall = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new VerificationStartEventResponseFlashCallImpl(action, flashCall);
    }
  }

  public static class DelegatedSerializer
      extends JsonSerializer<OptionalValue<VerificationStartEventResponseFlashCall>> {
    @Override
    public void serialize(
        OptionalValue<VerificationStartEventResponseFlashCall> value,
        JsonGenerator jgen,
        SerializerProvider provider)
        throws IOException {

      if (!value.isPresent()) {
        return;
      }
      VerificationStartEventResponseFlashCallImpl impl =
          (VerificationStartEventResponseFlashCallImpl) value.get();
      jgen.writeObject(null != impl ? impl.getFlashCall() : null);
    }
  }

  public static class DelegatedDeSerializer
      extends JsonDeserializer<VerificationStartEventResponseFlashCall> {
    @Override
    public VerificationStartEventResponseFlashCall deserialize(
        JsonParser jp, DeserializationContext ctxt) throws IOException {

      VerificationStartEventResponseFlashCallImpl.Builder builder =
          new VerificationStartEventResponseFlashCallImpl.Builder();
      VerificationStartEventResponseFlashCallContentImpl deserialized =
          jp.readValueAs(VerificationStartEventResponseFlashCallContentImpl.class);
      builder.setFlashCall(deserialized);
      return builder.build();
    }
  }

  public static Optional<VerificationStartEventResponseFlashCall> delegatedConverter(
      VerificationStartEventResponseFlashCallContent internal) {
    if (null == internal) {
      return Optional.empty();
    }
    return Optional.of(new Builder().setFlashCall(internal).build());
  }
}
