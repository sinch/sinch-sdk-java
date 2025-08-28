package com.sinch.sdk.domains.verification.models.v1.start.response;

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
import com.sinch.sdk.domains.verification.models.v1.start.internal.VerificationMethodStart;
import com.sinch.sdk.domains.verification.models.v1.start.response.internal.VerificationStartResponseWhatsAppContent;
import com.sinch.sdk.domains.verification.models.v1.start.response.internal.VerificationStartResponseWhatsAppContentImpl;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonPropertyOrder({
  VerificationStartResponseWhatsAppImpl.JSON_PROPERTY_ID,
  VerificationStartResponseWhatsAppImpl.JSON_PROPERTY_METHOD,
  VerificationStartResponseWhatsAppImpl.JSON_PROPERTY_LINKS,
  VerificationStartResponseWhatsAppImpl.JSON_PROPERTY_WHATSAPP
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VerificationStartResponseWhatsAppImpl
    implements VerificationStartResponseWhatsApp,
        com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponse {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ID = "id";

  private OptionalValue<String> id;

  public static final String JSON_PROPERTY_METHOD = "method";

  private OptionalValue<VerificationMethodStart> method;

  public static final String JSON_PROPERTY_LINKS = "_links";

  private OptionalValue<List<Link>> links;

  public static final String JSON_PROPERTY_WHATSAPP = "whatsapp";

  private OptionalValue<VerificationStartResponseWhatsAppContent> whatsapp;

  public VerificationStartResponseWhatsAppImpl() {}

  protected VerificationStartResponseWhatsAppImpl(
      OptionalValue<String> id,
      OptionalValue<VerificationMethodStart> method,
      OptionalValue<List<Link>> links,
      OptionalValue<VerificationStartResponseWhatsAppContent> whatsapp) {
    this.id = id;
    this.method = method;
    this.links = links;
    this.whatsapp = whatsapp;
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
  public VerificationMethodStart getMethod() {
    return method.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_METHOD)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<VerificationMethodStart> method() {
    return method;
  }

  @JsonIgnore
  public List<Link> getLinks() {
    return links.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_LINKS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<Link>> links() {
    return links;
  }

  @JsonIgnore
  public VerificationStartResponseWhatsAppContent getWhatsapp() {
    return whatsapp.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_WHATSAPP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<VerificationStartResponseWhatsAppContent> whatsapp() {
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
            .map(f -> ((VerificationStartResponseWhatsAppContentImpl) f).codeType())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public Object getExtraOption(String key) {
    return null != whatsapp && whatsapp.isPresent() ? whatsapp.get().get(key) : null;
  }

  /** Return true if this VerificationStartResponseWhatsApp object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VerificationStartResponseWhatsAppImpl verificationStartResponseWhatsApp =
        (VerificationStartResponseWhatsAppImpl) o;
    return Objects.equals(this.id, verificationStartResponseWhatsApp.id)
        && Objects.equals(this.method, verificationStartResponseWhatsApp.method)
        && Objects.equals(this.links, verificationStartResponseWhatsApp.links)
        && Objects.equals(this.whatsapp, verificationStartResponseWhatsApp.whatsapp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, method, links, whatsapp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VerificationStartResponseWhatsAppImpl {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    links: ").append(toIndentedString(links)).append("\n");
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
  static class Builder implements VerificationStartResponseWhatsApp.Builder {
    OptionalValue<String> id = OptionalValue.empty();
    OptionalValue<VerificationMethodStart> method =
        OptionalValue.of(VerificationMethodStart.WHATSAPP);
    OptionalValue<List<Link>> links = OptionalValue.empty();
    OptionalValue<VerificationStartResponseWhatsAppContent> whatsapp = OptionalValue.empty();

    VerificationStartResponseWhatsAppContent.Builder _delegatedBuilder = null;

    @JsonProperty(value = JSON_PROPERTY_ID, required = true)
    public Builder setId(String id) {
      this.id = OptionalValue.of(id);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_LINKS)
    public Builder setLinks(List<Link> links) {
      this.links = OptionalValue.of(links);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_WHATSAPP)
    public Builder setWhatsapp(VerificationStartResponseWhatsAppContent whatsapp) {
      this.whatsapp = OptionalValue.of(whatsapp);
      return this;
    }

    @JsonIgnore
    public Builder setCodeType(WhatsAppCodeType codeType) {
      getDelegatedBuilder().setCodeType(codeType);
      return this;
    }

    public Builder putExtraOption(String key, Object value) {
      getDelegatedBuilder().put(key, value);
      return this;
    }

    private VerificationStartResponseWhatsAppContent.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = VerificationStartResponseWhatsAppContent.builder();
      }
      return this._delegatedBuilder;
    }

    public VerificationStartResponseWhatsApp build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.whatsapp = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new VerificationStartResponseWhatsAppImpl(id, method, links, whatsapp);
    }
  }

  public static class DelegatedSerializer
      extends JsonSerializer<OptionalValue<VerificationStartResponseWhatsApp>> {
    @Override
    public void serialize(
        OptionalValue<VerificationStartResponseWhatsApp> value,
        JsonGenerator jgen,
        SerializerProvider provider)
        throws IOException {

      if (!value.isPresent()) {
        return;
      }
      VerificationStartResponseWhatsAppImpl impl =
          (VerificationStartResponseWhatsAppImpl) value.get();
      jgen.writeObject(null != impl ? impl.getWhatsapp() : null);
    }
  }

  public static class DelegatedDeSerializer
      extends JsonDeserializer<VerificationStartResponseWhatsApp> {
    @Override
    public VerificationStartResponseWhatsApp deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      VerificationStartResponseWhatsAppImpl.Builder builder =
          new VerificationStartResponseWhatsAppImpl.Builder();
      VerificationStartResponseWhatsAppContentImpl deserialized =
          jp.readValueAs(VerificationStartResponseWhatsAppContentImpl.class);
      builder.setWhatsapp(deserialized);
      return builder.build();
    }
  }

  public static Optional<VerificationStartResponseWhatsApp> delegatedConverter(
      VerificationStartResponseWhatsAppContent internal) {
    if (null == internal) {
      return Optional.empty();
    }
    return Optional.of(new Builder().setWhatsapp(internal).build());
  }
}
