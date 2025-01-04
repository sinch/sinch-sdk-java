package com.sinch.sdk.domains.mailgun.models.v1.emails.request;

import com.sinch.sdk.core.databind.annotation.FormSerialize;
import com.sinch.sdk.core.databind.annotation.Property;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.core.utils.Pair;
import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class SendMimeEmailRequestImpl implements SendMimeEmailRequest {
  private static final long serialVersionUID = 1L;

  public static final String PROPERTY_TO = "to";

  private OptionalValue<List<String>> to;

  public static final String PROPERTY_MESSAGE = "message";

  private OptionalValue<File> message;

  public static final String PROPERTY_TEMPLATE = "template";

  private OptionalValue<String> template;

  public static final String PROPERTY_RECIPIENT_VARIABLES = "recipient-variables";

  private OptionalValue<Map<String, Collection<Pair<String, String>>>> recipientVariables;

  public static final String PROPERTY_TEMPLATE_PROPERTIES = "templateProperties";

  private OptionalValue<TemplateProperties> templateProperties;

  public static final String PROPERTY_OVERRIDE_PROPERTIES = "overrideProperties";

  private OptionalValue<OverrideProperties> overrideProperties;

  public static final String PROPERTY_CUSTOM_VARIABLES = "customVariables";

  private OptionalValue<List<Pair<String, String>>> customVariables;

  public static final String PROPERTY_CUSTOM_HEADERS = "customHeaders";

  private OptionalValue<List<Pair<String, String>>> customHeaders;

  public SendMimeEmailRequestImpl() {}

  protected SendMimeEmailRequestImpl(
      OptionalValue<List<String>> to,
      OptionalValue<File> message,
      OptionalValue<String> template,
      OptionalValue<Map<String, Collection<Pair<String, String>>>> recipientVariables,
      OptionalValue<TemplateProperties> templateProperties,
      OptionalValue<OverrideProperties> overrideProperties,
      OptionalValue<List<Pair<String, String>>> customVariables,
      OptionalValue<List<Pair<String, String>>> customHeaders) {
    this.to = to;
    this.message = message;
    this.template = template;
    this.recipientVariables = recipientVariables;
    this.templateProperties = templateProperties;
    this.overrideProperties = overrideProperties;
    this.customVariables = customVariables;
    this.customHeaders = customHeaders;
  }

  public List<String> getTo() {
    return to.orElse(null);
  }

  @Property(PROPERTY_TO)
  public OptionalValue<List<String>> to() {
    return to;
  }

  public File getMessage() {
    return message.orElse(null);
  }

  @Property(PROPERTY_MESSAGE)
  public OptionalValue<File> message() {
    return message;
  }

  public String getTemplate() {
    return template.orElse(null);
  }

  @Property(PROPERTY_TEMPLATE)
  public OptionalValue<String> template() {
    return template;
  }

  public Map<String, Collection<Pair<String, String>>> getRecipientVariables() {
    return recipientVariables.orElse(null);
  }

  @Property(PROPERTY_RECIPIENT_VARIABLES)
  @FormSerialize(
      using = com.sinch.sdk.domains.mailgun.api.v1.adapters.MapOfPairsToJSONFormSerializer.class)
  public OptionalValue<Map<String, Collection<Pair<String, String>>>> recipientVariables() {
    return recipientVariables;
  }

  public TemplateProperties getTemplateProperties() {
    return templateProperties.orElse(null);
  }

  @Property(PROPERTY_TEMPLATE_PROPERTIES)
  @FormSerialize(
      using = com.sinch.sdk.domains.mailgun.api.v1.adapters.NestedFieldFormSerializer.class)
  public OptionalValue<TemplateProperties> templateProperties() {
    return templateProperties;
  }

  public OverrideProperties getOverrideProperties() {
    return overrideProperties.orElse(null);
  }

  @Property(PROPERTY_OVERRIDE_PROPERTIES)
  @FormSerialize(
      using = com.sinch.sdk.domains.mailgun.api.v1.adapters.NestedFieldFormSerializer.class)
  public OptionalValue<OverrideProperties> overrideProperties() {
    return overrideProperties;
  }

  public List<Pair<String, String>> getCustomVariables() {
    return customVariables.orElse(null);
  }

  @Property(PROPERTY_CUSTOM_VARIABLES)
  @FormSerialize(
      using = com.sinch.sdk.domains.mailgun.api.v1.adapters.CustomVariablesFormSerializer.class)
  public OptionalValue<List<Pair<String, String>>> customVariables() {
    return customVariables;
  }

  public List<Pair<String, String>> getCustomHeaders() {
    return customHeaders.orElse(null);
  }

  @Property(PROPERTY_CUSTOM_HEADERS)
  @FormSerialize(
      using = com.sinch.sdk.domains.mailgun.api.v1.adapters.CustomHeadersFormSerializer.class)
  public OptionalValue<List<Pair<String, String>>> customHeaders() {
    return customHeaders;
  }

  /** Return true if this sendMimeEmailRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SendMimeEmailRequestImpl sendMimeEmailRequest = (SendMimeEmailRequestImpl) o;
    return Objects.equals(this.to, sendMimeEmailRequest.to)
        && Objects.equals(this.message, sendMimeEmailRequest.message)
        && Objects.equals(this.template, sendMimeEmailRequest.template)
        && Objects.equals(this.recipientVariables, sendMimeEmailRequest.recipientVariables)
        && Objects.equals(this.templateProperties, sendMimeEmailRequest.templateProperties)
        && Objects.equals(this.overrideProperties, sendMimeEmailRequest.overrideProperties)
        && Objects.equals(this.customVariables, sendMimeEmailRequest.customVariables)
        && Objects.equals(this.customHeaders, sendMimeEmailRequest.customHeaders);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        to,
        message,
        template,
        recipientVariables,
        templateProperties,
        overrideProperties,
        customVariables,
        customHeaders);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SendMimeEmailRequestImpl {\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    template: ").append(toIndentedString(template)).append("\n");
    sb.append("    recipientVariables: ").append(toIndentedString(recipientVariables)).append("\n");
    sb.append("    templateProperties: ").append(toIndentedString(templateProperties)).append("\n");
    sb.append("    overrideProperties: ").append(toIndentedString(overrideProperties)).append("\n");
    sb.append("    customVariables: ").append(toIndentedString(customVariables)).append("\n");
    sb.append("    customHeaders: ").append(toIndentedString(customHeaders)).append("\n");
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

  static class Builder implements SendMimeEmailRequest.Builder {
    OptionalValue<List<String>> to = OptionalValue.empty();
    OptionalValue<File> message = OptionalValue.empty();
    OptionalValue<String> template = OptionalValue.empty();
    OptionalValue<Map<String, Collection<Pair<String, String>>>> recipientVariables =
        OptionalValue.empty();
    OptionalValue<TemplateProperties> templateProperties = OptionalValue.empty();
    OptionalValue<OverrideProperties> overrideProperties = OptionalValue.empty();
    OptionalValue<List<Pair<String, String>>> customVariables = OptionalValue.empty();
    OptionalValue<List<Pair<String, String>>> customHeaders = OptionalValue.empty();

    @Property(value = PROPERTY_TO)
    public Builder setTo(List<String> to) {
      this.to = OptionalValue.of(to);
      return this;
    }

    @Property(value = PROPERTY_MESSAGE)
    public Builder setMessage(File message) {
      this.message = OptionalValue.of(message);
      return this;
    }

    @Property(value = PROPERTY_TEMPLATE)
    public Builder setTemplate(String template) {
      this.template = OptionalValue.of(template);
      return this;
    }

    @Property(value = PROPERTY_RECIPIENT_VARIABLES)
    public Builder setRecipientVariables(
        Map<String, Collection<Pair<String, String>>> recipientVariables) {
      this.recipientVariables = OptionalValue.of(recipientVariables);
      return this;
    }

    @Property(value = PROPERTY_TEMPLATE_PROPERTIES)
    public Builder setTemplateProperties(TemplateProperties templateProperties) {
      this.templateProperties = OptionalValue.of(templateProperties);
      return this;
    }

    @Property(value = PROPERTY_OVERRIDE_PROPERTIES)
    public Builder setOverrideProperties(OverrideProperties overrideProperties) {
      this.overrideProperties = OptionalValue.of(overrideProperties);
      return this;
    }

    @Property(value = PROPERTY_CUSTOM_VARIABLES)
    public Builder setCustomVariables(List<Pair<String, String>> customVariables) {
      this.customVariables = OptionalValue.of(customVariables);
      return this;
    }

    @Property(value = PROPERTY_CUSTOM_HEADERS)
    public Builder setCustomHeaders(List<Pair<String, String>> customHeaders) {
      this.customHeaders = OptionalValue.of(customHeaders);
      return this;
    }

    public SendMimeEmailRequest build() {
      return new SendMimeEmailRequestImpl(
          to,
          message,
          template,
          recipientVariables,
          templateProperties,
          overrideProperties,
          customVariables,
          customHeaders);
    }
  }
}
