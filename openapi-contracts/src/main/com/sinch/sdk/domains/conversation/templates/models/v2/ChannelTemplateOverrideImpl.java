package com.sinch.sdk.domains.conversation.templates.models.v2;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.TemplateReference;
import java.util.Map;
import java.util.Objects;

@JsonPropertyOrder({
  ChannelTemplateOverrideImpl.JSON_PROPERTY_TEMPLATE_REFERENCE,
  ChannelTemplateOverrideImpl.JSON_PROPERTY_PARAMETER_MAPPINGS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ChannelTemplateOverrideImpl implements ChannelTemplateOverride {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TEMPLATE_REFERENCE = "template_reference";

  private OptionalValue<TemplateReference> templateReference;

  public static final String JSON_PROPERTY_PARAMETER_MAPPINGS = "parameter_mappings";

  private OptionalValue<Map<String, String>> parameterMappings;

  public ChannelTemplateOverrideImpl() {}

  protected ChannelTemplateOverrideImpl(
      OptionalValue<TemplateReference> templateReference,
      OptionalValue<Map<String, String>> parameterMappings) {
    this.templateReference = templateReference;
    this.parameterMappings = parameterMappings;
  }

  @JsonIgnore
  public TemplateReference getTemplateReference() {
    return templateReference.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TEMPLATE_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<TemplateReference> templateReference() {
    return templateReference;
  }

  @JsonIgnore
  public Map<String, String> getParameterMappings() {
    return parameterMappings.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PARAMETER_MAPPINGS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Map<String, String>> parameterMappings() {
    return parameterMappings;
  }

  /** Return true if this ChannelTemplateOverride object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChannelTemplateOverrideImpl channelTemplateOverride = (ChannelTemplateOverrideImpl) o;
    return Objects.equals(this.templateReference, channelTemplateOverride.templateReference)
        && Objects.equals(this.parameterMappings, channelTemplateOverride.parameterMappings);
  }

  @Override
  public int hashCode() {
    return Objects.hash(templateReference, parameterMappings);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChannelTemplateOverrideImpl {\n");
    sb.append("    templateReference: ").append(toIndentedString(templateReference)).append("\n");
    sb.append("    parameterMappings: ").append(toIndentedString(parameterMappings)).append("\n");
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
  static class Builder implements ChannelTemplateOverride.Builder {
    OptionalValue<TemplateReference> templateReference = OptionalValue.empty();
    OptionalValue<Map<String, String>> parameterMappings = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_TEMPLATE_REFERENCE)
    public Builder setTemplateReference(TemplateReference templateReference) {
      this.templateReference = OptionalValue.of(templateReference);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_PARAMETER_MAPPINGS)
    public Builder setParameterMappings(Map<String, String> parameterMappings) {
      this.parameterMappings = OptionalValue.of(parameterMappings);
      return this;
    }

    public ChannelTemplateOverride build() {
      return new ChannelTemplateOverrideImpl(templateReference, parameterMappings);
    }
  }
}
