package com.sinch.sdk.domains.conversation.models.v1;

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
import com.sinch.sdk.domains.conversation.models.v1.internal.TemplateReferenceInternal;
import com.sinch.sdk.domains.conversation.models.v1.internal.TemplateReferenceInternalImpl;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonPropertyOrder({TemplateReferenceImpl.JSON_PROPERTY_TEMPLATE_REFERENCE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class TemplateReferenceImpl
    implements TemplateReference,
        com.sinch.sdk.domains.conversation.models.v1.messages.OmniMessageOverride {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TEMPLATE_REFERENCE = "template_reference";

  private OptionalValue<TemplateReferenceInternal> templateReference;

  public TemplateReferenceImpl() {}

  protected TemplateReferenceImpl(OptionalValue<TemplateReferenceInternal> templateReference) {
    this.templateReference = templateReference;
  }

  @JsonIgnore
  public TemplateReferenceInternal getTemplateReference() {
    return templateReference.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TEMPLATE_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<TemplateReferenceInternal> templateReference() {
    return templateReference;
  }

  @JsonIgnore
  public String getLanguageCode() {
    if (null == templateReference
        || !templateReference.isPresent()
        || null == templateReference.get().getLanguageCode()) {
      return null;
    }
    return templateReference.get().getLanguageCode();
  }

  public OptionalValue<String> languageCode() {
    return null != templateReference && templateReference.isPresent()
        ? templateReference
            .map(f -> ((TemplateReferenceInternalImpl) f).languageCode())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public Map<String, String> getParameters() {
    if (null == templateReference
        || !templateReference.isPresent()
        || null == templateReference.get().getParameters()) {
      return null;
    }
    return templateReference.get().getParameters();
  }

  public OptionalValue<Map<String, String>> parameters() {
    return null != templateReference && templateReference.isPresent()
        ? templateReference
            .map(f -> ((TemplateReferenceInternalImpl) f).parameters())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public String getTemplateId() {
    if (null == templateReference
        || !templateReference.isPresent()
        || null == templateReference.get().getTemplateId()) {
      return null;
    }
    return templateReference.get().getTemplateId();
  }

  public OptionalValue<String> templateId() {
    return null != templateReference && templateReference.isPresent()
        ? templateReference
            .map(f -> ((TemplateReferenceInternalImpl) f).templateId())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public String getVersion() {
    if (null == templateReference
        || !templateReference.isPresent()
        || null == templateReference.get().getVersion()) {
      return null;
    }
    return templateReference.get().getVersion();
  }

  public OptionalValue<String> version() {
    return null != templateReference && templateReference.isPresent()
        ? templateReference
            .map(f -> ((TemplateReferenceInternalImpl) f).version())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  /** Return true if this TemplateReferenceField object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TemplateReferenceImpl templateReferenceField = (TemplateReferenceImpl) o;
    return Objects.equals(this.templateReference, templateReferenceField.templateReference);
  }

  @Override
  public int hashCode() {
    return Objects.hash(templateReference);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TemplateReferenceImpl {\n");
    sb.append("    templateReference: ").append(toIndentedString(templateReference)).append("\n");
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
  static class Builder implements TemplateReference.Builder {
    OptionalValue<TemplateReferenceInternal> templateReference = OptionalValue.empty();

    TemplateReferenceInternal.Builder _delegatedBuilder = null;

    @JsonProperty(value = JSON_PROPERTY_TEMPLATE_REFERENCE, required = true)
    public Builder setTemplateReference(TemplateReferenceInternal templateReference) {
      this.templateReference = OptionalValue.of(templateReference);
      return this;
    }

    @JsonIgnore
    public Builder setLanguageCode(String languageCode) {
      getDelegatedBuilder().setLanguageCode(languageCode);
      return this;
    }

    @JsonIgnore
    public Builder setParameters(Map<String, String> parameters) {
      getDelegatedBuilder().setParameters(parameters);
      return this;
    }

    @JsonIgnore
    public Builder setTemplateId(String templateId) {
      getDelegatedBuilder().setTemplateId(templateId);
      return this;
    }

    @JsonIgnore
    public Builder setVersion(String version) {
      getDelegatedBuilder().setVersion(version);
      return this;
    }

    private TemplateReferenceInternal.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = TemplateReferenceInternal.builder();
      }
      return this._delegatedBuilder;
    }

    public TemplateReference build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.templateReference = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new TemplateReferenceImpl(templateReference);
    }
  }

  public static class DelegatedSerializer extends JsonSerializer<OptionalValue<TemplateReference>> {
    @Override
    public void serialize(
        OptionalValue<TemplateReference> value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException {

      if (!value.isPresent()) {
        return;
      }
      TemplateReferenceImpl impl = (TemplateReferenceImpl) value.get();
      jgen.writeObject(null != impl ? impl.getTemplateReference() : null);
    }
  }

  public static class DelegatedDeSerializer extends JsonDeserializer<TemplateReference> {
    @Override
    public TemplateReference deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      TemplateReferenceImpl.Builder builder = new TemplateReferenceImpl.Builder();
      TemplateReferenceInternalImpl deserialized =
          jp.readValueAs(TemplateReferenceInternalImpl.class);
      builder.setTemplateReference(deserialized);
      return builder.build();
    }
  }

  public static Optional<TemplateReference> delegatedConverter(TemplateReferenceInternal internal) {
    if (null == internal) {
      return Optional.empty();
    }
    return Optional.of(new Builder().setTemplateReference(internal).build());
  }
}
