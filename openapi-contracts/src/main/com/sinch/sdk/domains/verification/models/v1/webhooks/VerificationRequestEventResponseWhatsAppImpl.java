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
import com.sinch.sdk.domains.verification.models.v1.WhatsAppCodeType;
import com.sinch.sdk.domains.verification.models.v1.webhooks.internal.VerificationRequestEventResponseWhatsAppContent;
import com.sinch.sdk.domains.verification.models.v1.webhooks.internal.VerificationRequestEventResponseWhatsAppContentImpl;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonPropertyOrder({
  VerificationRequestEventResponseWhatsAppImpl.JSON_PROPERTY_ACTION,
  VerificationRequestEventResponseWhatsAppImpl.JSON_PROPERTY_WHATSAPP
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VerificationRequestEventResponseWhatsAppImpl
    implements VerificationRequestEventResponseWhatsApp,
        com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationRequestEventResponse {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ACTION = "action";

  private OptionalValue<VerificationEventResponseAction> action;

  public static final String JSON_PROPERTY_WHATSAPP = "whatsapp";

  private OptionalValue<VerificationRequestEventResponseWhatsAppContent> whatsapp;

  public VerificationRequestEventResponseWhatsAppImpl() {}

  protected VerificationRequestEventResponseWhatsAppImpl(
      OptionalValue<VerificationEventResponseAction> action,
      OptionalValue<VerificationRequestEventResponseWhatsAppContent> whatsapp) {
    this.action = action;
    this.whatsapp = whatsapp;
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
  public VerificationRequestEventResponseWhatsAppContent getWhatsapp() {
    return whatsapp.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_WHATSAPP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<VerificationRequestEventResponseWhatsAppContent> whatsapp() {
    return whatsapp;
  }

  @JsonIgnore
  public WhatsAppCodeType getCodeType() {
    if (null == whatsapp || !whatsapp.isPresent() || null == whatsapp.get().getCodeType()) {
      return null;
    }
    return whatsapp.get().getCodeType();
  }

  public OptionalValue<WhatsAppCodeType> codeType() {
    return null != whatsapp && whatsapp.isPresent()
        ? whatsapp
            .map(f -> ((VerificationRequestEventResponseWhatsAppContentImpl) f).codeType())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public List<String> getAcceptLanguage() {
    if (null == whatsapp || !whatsapp.isPresent() || null == whatsapp.get().getAcceptLanguage()) {
      return null;
    }
    return whatsapp.get().getAcceptLanguage();
  }

  public OptionalValue<List<String>> acceptLanguage() {
    return null != whatsapp && whatsapp.isPresent()
        ? whatsapp
            .map(f -> ((VerificationRequestEventResponseWhatsAppContentImpl) f).acceptLanguage())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public Object getExtraOption(String key) {
    return null != whatsapp && whatsapp.isPresent() ? whatsapp.get().get(key) : null;
  }

  /** Return true if this VerificationRequestEventResponseWhatsApp object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VerificationRequestEventResponseWhatsAppImpl verificationRequestEventResponseWhatsApp =
        (VerificationRequestEventResponseWhatsAppImpl) o;
    return Objects.equals(this.action, verificationRequestEventResponseWhatsApp.action)
        && Objects.equals(this.whatsapp, verificationRequestEventResponseWhatsApp.whatsapp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(action, whatsapp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VerificationRequestEventResponseWhatsAppImpl {\n");
    sb.append("    action: ").append(toIndentedString(action)).append("\n");
    sb.append("    whatsapp: ").append(toIndentedString(whatsapp)).append("\n");
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
  static class Builder implements VerificationRequestEventResponseWhatsApp.Builder {
    OptionalValue<VerificationEventResponseAction> action = OptionalValue.empty();
    OptionalValue<VerificationRequestEventResponseWhatsAppContent> whatsapp = OptionalValue.empty();

    VerificationRequestEventResponseWhatsAppContent.Builder _delegatedBuilder = null;

    @JsonProperty(value = JSON_PROPERTY_ACTION, required = true)
    public Builder setAction(VerificationEventResponseAction action) {
      this.action = OptionalValue.of(action);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_WHATSAPP)
    public Builder setWhatsapp(VerificationRequestEventResponseWhatsAppContent whatsapp) {
      this.whatsapp = OptionalValue.of(whatsapp);
      return this;
    }

    @JsonIgnore
    public Builder setCodeType(WhatsAppCodeType codeType) {
      getDelegatedBuilder().setCodeType(codeType);
      return this;
    }

    @JsonIgnore
    public Builder setAcceptLanguage(List<String> acceptLanguage) {
      getDelegatedBuilder().setAcceptLanguage(acceptLanguage);
      return this;
    }

    public Builder putExtraOption(String key, Object value) {
      getDelegatedBuilder().put(key, value);
      return this;
    }

    private VerificationRequestEventResponseWhatsAppContent.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = VerificationRequestEventResponseWhatsAppContent.builder();
      }
      return this._delegatedBuilder;
    }

    public VerificationRequestEventResponseWhatsApp build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.whatsapp = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new VerificationRequestEventResponseWhatsAppImpl(action, whatsapp);
    }
  }

  public static class DelegatedSerializer
      extends JsonSerializer<OptionalValue<VerificationRequestEventResponseWhatsApp>> {
    @Override
    public void serialize(
        OptionalValue<VerificationRequestEventResponseWhatsApp> value,
        JsonGenerator jgen,
        SerializerProvider provider)
        throws IOException {

      if (!value.isPresent()) {
        return;
      }
      VerificationRequestEventResponseWhatsAppImpl impl =
          (VerificationRequestEventResponseWhatsAppImpl) value.get();
      jgen.writeObject(null != impl ? impl.getWhatsapp() : null);
    }
  }

  public static class DelegatedDeSerializer
      extends JsonDeserializer<VerificationRequestEventResponseWhatsApp> {
    @Override
    public VerificationRequestEventResponseWhatsApp deserialize(
        JsonParser jp, DeserializationContext ctxt) throws IOException {

      VerificationRequestEventResponseWhatsAppImpl.Builder builder =
          new VerificationRequestEventResponseWhatsAppImpl.Builder();
      VerificationRequestEventResponseWhatsAppContentImpl deserialized =
          jp.readValueAs(VerificationRequestEventResponseWhatsAppContentImpl.class);
      builder.setWhatsapp(deserialized);
      return builder.build();
    }
  }

  public static Optional<VerificationRequestEventResponseWhatsApp> delegatedConverter(
      VerificationRequestEventResponseWhatsAppContent internal) {
    if (null == internal) {
      return Optional.empty();
    }
    return Optional.of(new Builder().setWhatsapp(internal).build());
  }
}
