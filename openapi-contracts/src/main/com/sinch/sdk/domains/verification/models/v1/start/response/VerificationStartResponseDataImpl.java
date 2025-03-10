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
import com.sinch.sdk.domains.verification.models.v1.VerificationMethod;
import com.sinch.sdk.domains.verification.models.v1.start.response.internal.VerificationStartResponseDataContent;
import com.sinch.sdk.domains.verification.models.v1.start.response.internal.VerificationStartResponseDataContentImpl;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonPropertyOrder({
  VerificationStartResponseDataImpl.JSON_PROPERTY_ID,
  VerificationStartResponseDataImpl.JSON_PROPERTY_METHOD,
  VerificationStartResponseDataImpl.JSON_PROPERTY_LINKS,
  VerificationStartResponseDataImpl.JSON_PROPERTY_SEAMLESS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VerificationStartResponseDataImpl
    implements VerificationStartResponseData,
        com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponse {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ID = "id";

  private OptionalValue<String> id;

  public static final String JSON_PROPERTY_METHOD = "method";

  private OptionalValue<VerificationMethod> method;

  public static final String JSON_PROPERTY_LINKS = "_links";

  private OptionalValue<List<Link>> links;

  public static final String JSON_PROPERTY_SEAMLESS = "seamless";

  private OptionalValue<VerificationStartResponseDataContent> seamless;

  public VerificationStartResponseDataImpl() {}

  protected VerificationStartResponseDataImpl(
      OptionalValue<String> id,
      OptionalValue<VerificationMethod> method,
      OptionalValue<List<Link>> links,
      OptionalValue<VerificationStartResponseDataContent> seamless) {
    this.id = id;
    this.method = method;
    this.links = links;
    this.seamless = seamless;
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
  public VerificationMethod getMethod() {
    return method.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_METHOD)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<VerificationMethod> method() {
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
  public VerificationStartResponseDataContent getSeamless() {
    return seamless.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SEAMLESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<VerificationStartResponseDataContent> seamless() {
    return seamless;
  }

  @JsonIgnore
  public String getTargetUri() {
    if (null == seamless || !seamless.isPresent() || null == seamless.get().getTargetUri()) {
      return null;
    }
    return seamless.get().getTargetUri();
  }

  public OptionalValue<String> targetUri() {
    return null != seamless && seamless.isPresent()
        ? seamless
            .map(f -> ((VerificationStartResponseDataContentImpl) f).targetUri())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  /** Return true if this VerificationStartResponseData object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VerificationStartResponseDataImpl verificationStartResponseData =
        (VerificationStartResponseDataImpl) o;
    return Objects.equals(this.id, verificationStartResponseData.id)
        && Objects.equals(this.method, verificationStartResponseData.method)
        && Objects.equals(this.links, verificationStartResponseData.links)
        && Objects.equals(this.seamless, verificationStartResponseData.seamless);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, method, links, seamless);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VerificationStartResponseDataImpl {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    links: ").append(toIndentedString(links)).append("\n");
    sb.append("    seamless: ").append(toIndentedString(seamless)).append("\n");
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
  static class Builder implements VerificationStartResponseData.Builder {
    OptionalValue<String> id = OptionalValue.empty();
    OptionalValue<VerificationMethod> method = OptionalValue.of(VerificationMethod.DATA);
    OptionalValue<List<Link>> links = OptionalValue.empty();
    OptionalValue<VerificationStartResponseDataContent> seamless = OptionalValue.empty();

    VerificationStartResponseDataContent.Builder _delegatedBuilder = null;

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

    @JsonProperty(value = JSON_PROPERTY_SEAMLESS, required = true)
    public Builder setSeamless(VerificationStartResponseDataContent seamless) {
      this.seamless = OptionalValue.of(seamless);
      return this;
    }

    @JsonIgnore
    public Builder setTargetUri(String targetUri) {
      getDelegatedBuilder().setTargetUri(targetUri);
      return this;
    }

    private VerificationStartResponseDataContent.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = VerificationStartResponseDataContent.builder();
      }
      return this._delegatedBuilder;
    }

    public VerificationStartResponseData build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.seamless = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new VerificationStartResponseDataImpl(id, method, links, seamless);
    }
  }

  public static class DelegatedSerializer
      extends JsonSerializer<OptionalValue<VerificationStartResponseData>> {
    @Override
    public void serialize(
        OptionalValue<VerificationStartResponseData> value,
        JsonGenerator jgen,
        SerializerProvider provider)
        throws IOException {

      if (!value.isPresent()) {
        return;
      }
      VerificationStartResponseDataImpl impl = (VerificationStartResponseDataImpl) value.get();
      jgen.writeObject(null != impl ? impl.getSeamless() : null);
    }
  }

  public static class DelegatedDeSerializer
      extends JsonDeserializer<VerificationStartResponseData> {
    @Override
    public VerificationStartResponseData deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      VerificationStartResponseDataImpl.Builder builder =
          new VerificationStartResponseDataImpl.Builder();
      VerificationStartResponseDataContentImpl deserialized =
          jp.readValueAs(VerificationStartResponseDataContentImpl.class);
      builder.setSeamless(deserialized);
      return builder.build();
    }
  }

  public static Optional<VerificationStartResponseData> delegatedConverter(
      VerificationStartResponseDataContent internal) {
    if (null == internal) {
      return Optional.empty();
    }
    return Optional.of(new Builder().setSeamless(internal).build());
  }
}
