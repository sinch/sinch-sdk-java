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
import com.sinch.sdk.domains.verification.models.v1.SmsCodeType;
import com.sinch.sdk.domains.verification.models.v1.start.internal.VerificationMethodStart;
import com.sinch.sdk.domains.verification.models.v1.start.response.internal.VerificationStartResponseSmsContent;
import com.sinch.sdk.domains.verification.models.v1.start.response.internal.VerificationStartResponseSmsContentImpl;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonPropertyOrder({
  VerificationStartResponseSmsImpl.JSON_PROPERTY_ID,
  VerificationStartResponseSmsImpl.JSON_PROPERTY_METHOD,
  VerificationStartResponseSmsImpl.JSON_PROPERTY_LINKS,
  VerificationStartResponseSmsImpl.JSON_PROPERTY_SMS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VerificationStartResponseSmsImpl
    implements VerificationStartResponseSms,
        com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponse {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ID = "id";

  private OptionalValue<String> id;

  public static final String JSON_PROPERTY_METHOD = "method";

  private OptionalValue<VerificationMethodStart> method;

  public static final String JSON_PROPERTY_LINKS = "_links";

  private OptionalValue<List<Link>> links;

  public static final String JSON_PROPERTY_SMS = "sms";

  private OptionalValue<VerificationStartResponseSmsContent> sms;

  public VerificationStartResponseSmsImpl() {}

  protected VerificationStartResponseSmsImpl(
      OptionalValue<String> id,
      OptionalValue<VerificationMethodStart> method,
      OptionalValue<List<Link>> links,
      OptionalValue<VerificationStartResponseSmsContent> sms) {
    this.id = id;
    this.method = method;
    this.links = links;
    this.sms = sms;
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
  public VerificationStartResponseSmsContent getSms() {
    return sms.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SMS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<VerificationStartResponseSmsContent> sms() {
    return sms;
  }

  @JsonIgnore
  public String getTemplate() {
    if (null == sms || !sms.isPresent() || null == sms.get().getTemplate()) {
      return null;
    }
    return sms.get().getTemplate();
  }

  public OptionalValue<String> template() {
    return null != sms && sms.isPresent()
        ? sms.map(f -> ((VerificationStartResponseSmsContentImpl) f).template())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public Integer getInterceptionTimeout() {
    if (null == sms || !sms.isPresent() || null == sms.get().getInterceptionTimeout()) {
      return null;
    }
    return sms.get().getInterceptionTimeout();
  }

  public OptionalValue<Integer> interceptionTimeout() {
    return null != sms && sms.isPresent()
        ? sms.map(f -> ((VerificationStartResponseSmsContentImpl) f).interceptionTimeout())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public SmsCodeType getCodeType() {
    if (null == sms || !sms.isPresent() || null == sms.get().getCodeType()) {
      return null;
    }
    return sms.get().getCodeType();
  }

  public OptionalValue<SmsCodeType> codeType() {
    return null != sms && sms.isPresent()
        ? sms.map(f -> ((VerificationStartResponseSmsContentImpl) f).codeType())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public Object getExtraOption(String key) {
    return null != sms && sms.isPresent() ? sms.get().get(key) : null;
  }

  /** Return true if this VerificationStartResponseSms object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VerificationStartResponseSmsImpl verificationStartResponseSms =
        (VerificationStartResponseSmsImpl) o;
    return Objects.equals(this.id, verificationStartResponseSms.id)
        && Objects.equals(this.method, verificationStartResponseSms.method)
        && Objects.equals(this.links, verificationStartResponseSms.links)
        && Objects.equals(this.sms, verificationStartResponseSms.sms);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, method, links, sms);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VerificationStartResponseSmsImpl {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    links: ").append(toIndentedString(links)).append("\n");
    sb.append("    sms: ").append(toIndentedString(sms)).append("\n");
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
  static class Builder implements VerificationStartResponseSms.Builder {
    OptionalValue<String> id = OptionalValue.empty();
    OptionalValue<VerificationMethodStart> method = OptionalValue.of(VerificationMethodStart.SMS);
    OptionalValue<List<Link>> links = OptionalValue.empty();
    OptionalValue<VerificationStartResponseSmsContent> sms = OptionalValue.empty();

    VerificationStartResponseSmsContent.Builder _delegatedBuilder = null;

    @JsonProperty(value = JSON_PROPERTY_ID, required = true)
    public Builder setId(String id) {
      this.id = OptionalValue.of(id);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_METHOD, required = true)
    Builder setMethod(VerificationMethodStart method) {
      if (!Objects.equals(method, VerificationMethodStart.SMS)) {
        throw new IllegalArgumentException(
            String.format("'method' must be '%s' (is '%s')", VerificationMethodStart.SMS, method));
      }
      return this;
    }

    @JsonProperty(JSON_PROPERTY_LINKS)
    public Builder setLinks(List<Link> links) {
      this.links = OptionalValue.of(links);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SMS)
    public Builder setSms(VerificationStartResponseSmsContent sms) {
      this.sms = OptionalValue.of(sms);
      return this;
    }

    @JsonIgnore
    public Builder setTemplate(String template) {
      getDelegatedBuilder().setTemplate(template);
      return this;
    }

    @JsonIgnore
    public Builder setInterceptionTimeout(Integer interceptionTimeout) {
      getDelegatedBuilder().setInterceptionTimeout(interceptionTimeout);
      return this;
    }

    @JsonIgnore
    public Builder setCodeType(SmsCodeType codeType) {
      getDelegatedBuilder().setCodeType(codeType);
      return this;
    }

    public Builder putExtraOption(String key, Object value) {
      getDelegatedBuilder().put(key, value);
      return this;
    }

    private VerificationStartResponseSmsContent.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = VerificationStartResponseSmsContent.builder();
      }
      return this._delegatedBuilder;
    }

    public VerificationStartResponseSms build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.sms = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new VerificationStartResponseSmsImpl(id, method, links, sms);
    }
  }

  public static class DelegatedSerializer
      extends JsonSerializer<OptionalValue<VerificationStartResponseSms>> {
    @Override
    public void serialize(
        OptionalValue<VerificationStartResponseSms> value,
        JsonGenerator jgen,
        SerializerProvider provider)
        throws IOException {

      if (!value.isPresent()) {
        return;
      }
      VerificationStartResponseSmsImpl impl = (VerificationStartResponseSmsImpl) value.get();
      jgen.writeObject(null != impl ? impl.getSms() : null);
    }
  }

  public static class DelegatedDeSerializer extends JsonDeserializer<VerificationStartResponseSms> {
    @Override
    public VerificationStartResponseSms deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      VerificationStartResponseSmsImpl.Builder builder =
          new VerificationStartResponseSmsImpl.Builder();
      VerificationStartResponseSmsContentImpl deserialized =
          jp.readValueAs(VerificationStartResponseSmsContentImpl.class);
      builder.setSms(deserialized);
      return builder.build();
    }
  }

  public static Optional<VerificationStartResponseSms> delegatedConverter(
      VerificationStartResponseSmsContent internal) {
    if (null == internal) {
      return Optional.empty();
    }
    return Optional.of(new Builder().setSms(internal).build());
  }
}
