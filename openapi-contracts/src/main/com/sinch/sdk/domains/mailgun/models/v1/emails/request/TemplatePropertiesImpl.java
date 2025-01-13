package com.sinch.sdk.domains.mailgun.models.v1.emails.request;

import com.sinch.sdk.core.databind.annotation.FormSerialize;
import com.sinch.sdk.core.databind.annotation.Property;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.mailgun.api.v1.adapters.MapToJSONStringHelper;
import java.util.Map;
import java.util.Objects;

public class TemplatePropertiesImpl implements TemplateProperties {
  private static final long serialVersionUID = 1L;

  public static final String PROPERTY_TEXT = "t:text";

  private OptionalValue<Boolean> text;

  public static final String PROPERTY_VERSION = "t:version";

  private OptionalValue<String> version;

  public static final String PROPERTY_VARIABLES = "t:variables";

  private OptionalValue<String> variables;

  public TemplatePropertiesImpl() {}

  protected TemplatePropertiesImpl(
      OptionalValue<Boolean> text, OptionalValue<String> version, OptionalValue<String> variables) {
    this.text = text;
    this.version = version;
    this.variables = variables;
  }

  public Boolean getText() {
    return text.orElse(null);
  }

  @Property(PROPERTY_TEXT)
  @FormSerialize(using = com.sinch.sdk.domains.mailgun.api.v1.adapters.BooleanFormSerializer.class)
  public OptionalValue<Boolean> text() {
    return text;
  }

  public String getVersion() {
    return version.orElse(null);
  }

  @Property(PROPERTY_VERSION)
  public OptionalValue<String> version() {
    return version;
  }

  public String getVariables() {
    return variables.orElse(null);
  }

  @Property(PROPERTY_VARIABLES)
  public OptionalValue<String> variables() {
    return variables;
  }

  /** Return true if this templateProperties object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TemplatePropertiesImpl templateProperties = (TemplatePropertiesImpl) o;
    return Objects.equals(this.text, templateProperties.text)
        && Objects.equals(this.version, templateProperties.version)
        && Objects.equals(this.variables, templateProperties.variables);
  }

  @Override
  public int hashCode() {
    return Objects.hash(text, version, variables);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TemplatePropertiesImpl {\n");
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    variables: ").append(toIndentedString(variables)).append("\n");
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

  static class Builder implements TemplateProperties.Builder {
    OptionalValue<Boolean> text = OptionalValue.empty();
    OptionalValue<String> version = OptionalValue.empty();
    OptionalValue<String> variables = OptionalValue.empty();

    public Builder setVariables(Map<String, Object> variables) {
      return setVariables(MapToJSONStringHelper.serialize(variables));
    }

    @Property(value = PROPERTY_TEXT)
    public Builder setText(Boolean text) {
      this.text = OptionalValue.of(text);
      return this;
    }

    @Property(value = PROPERTY_VERSION)
    public Builder setVersion(String version) {
      this.version = OptionalValue.of(version);
      return this;
    }

    @Property(value = PROPERTY_VARIABLES)
    public Builder setVariables(String variables) {
      this.variables = OptionalValue.of(variables);
      return this;
    }

    public TemplateProperties build() {
      return new TemplatePropertiesImpl(text, version, variables);
    }
  }
}
