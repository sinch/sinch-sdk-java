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

public class SendEmailHtmlInTemplateRequestImpl
    implements SendEmailHtmlInTemplateRequest, SendEmailRequest {
  private static final long serialVersionUID = 1L;

  public static final String PROPERTY_TO = "to";

  private OptionalValue<List<String>> to;

  public static final String PROPERTY_FROM = "from";

  private OptionalValue<String> from;

  public static final String PROPERTY_CC = "cc";

  private OptionalValue<List<String>> cc;

  public static final String PROPERTY_BCC = "bcc";

  private OptionalValue<List<String>> bcc;

  public static final String PROPERTY_SUBJECT = "subject";

  private OptionalValue<String> subject;

  public static final String PROPERTY_TEXT = "text";

  private OptionalValue<String> text;

  public static final String PROPERTY_AMP_HTML = "amp-html";

  private OptionalValue<String> ampHtml;

  public static final String PROPERTY_ATTACHMENT = "attachment";

  private OptionalValue<List<File>> attachment;

  public static final String PROPERTY_INLINE = "inline";

  private OptionalValue<List<File>> inline;

  public static final String PROPERTY_RECIPIENT_VARIABLES = "recipient-variables";

  private OptionalValue<Map<String, Collection<Pair<String, String>>>> recipientVariables;

  public static final String PROPERTY_OVERRIDE_PROPERTIES = "overrideProperties";

  private OptionalValue<OverrideProperties> overrideProperties;

  public static final String PROPERTY_CUSTOM_VARIABLES = "customVariables";

  private OptionalValue<List<Pair<String, String>>> customVariables;

  public static final String PROPERTY_CUSTOM_HEADERS = "customHeaders";

  private OptionalValue<List<Pair<String, String>>> customHeaders;

  public static final String PROPERTY_TEMPLATE = "template";

  private OptionalValue<String> template;

  public static final String PROPERTY_TEMPLATE_PROPERTIES = "templateProperties";

  private OptionalValue<TemplateProperties> templateProperties;

  public SendEmailHtmlInTemplateRequestImpl() {}

  protected SendEmailHtmlInTemplateRequestImpl(
      OptionalValue<List<String>> to,
      OptionalValue<String> from,
      OptionalValue<List<String>> cc,
      OptionalValue<List<String>> bcc,
      OptionalValue<String> subject,
      OptionalValue<String> text,
      OptionalValue<String> ampHtml,
      OptionalValue<List<File>> attachment,
      OptionalValue<List<File>> inline,
      OptionalValue<Map<String, Collection<Pair<String, String>>>> recipientVariables,
      OptionalValue<OverrideProperties> overrideProperties,
      OptionalValue<List<Pair<String, String>>> customVariables,
      OptionalValue<List<Pair<String, String>>> customHeaders,
      OptionalValue<String> template,
      OptionalValue<TemplateProperties> templateProperties) {
    this.to = to;
    this.from = from;
    this.cc = cc;
    this.bcc = bcc;
    this.subject = subject;
    this.text = text;
    this.ampHtml = ampHtml;
    this.attachment = attachment;
    this.inline = inline;
    this.recipientVariables = recipientVariables;
    this.overrideProperties = overrideProperties;
    this.customVariables = customVariables;
    this.customHeaders = customHeaders;
    this.template = template;
    this.templateProperties = templateProperties;
  }

  public List<String> getTo() {
    return to.orElse(null);
  }

  @Property(PROPERTY_TO)
  public OptionalValue<List<String>> to() {
    return to;
  }

  public String getFrom() {
    return from.orElse(null);
  }

  @Property(PROPERTY_FROM)
  public OptionalValue<String> from() {
    return from;
  }

  public List<String> getCc() {
    return cc.orElse(null);
  }

  @Property(PROPERTY_CC)
  public OptionalValue<List<String>> cc() {
    return cc;
  }

  public List<String> getBcc() {
    return bcc.orElse(null);
  }

  @Property(PROPERTY_BCC)
  public OptionalValue<List<String>> bcc() {
    return bcc;
  }

  public String getSubject() {
    return subject.orElse(null);
  }

  @Property(PROPERTY_SUBJECT)
  public OptionalValue<String> subject() {
    return subject;
  }

  public String getText() {
    return text.orElse(null);
  }

  @Property(PROPERTY_TEXT)
  public OptionalValue<String> text() {
    return text;
  }

  public String getAmpHtml() {
    return ampHtml.orElse(null);
  }

  @Property(PROPERTY_AMP_HTML)
  public OptionalValue<String> ampHtml() {
    return ampHtml;
  }

  public List<File> getAttachment() {
    return attachment.orElse(null);
  }

  @Property(PROPERTY_ATTACHMENT)
  public OptionalValue<List<File>> attachment() {
    return attachment;
  }

  public List<File> getInline() {
    return inline.orElse(null);
  }

  @Property(PROPERTY_INLINE)
  public OptionalValue<List<File>> inline() {
    return inline;
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

  public String getTemplate() {
    return template.orElse(null);
  }

  @Property(PROPERTY_TEMPLATE)
  public OptionalValue<String> template() {
    return template;
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

  /** Return true if this SendEmailHtmlInTemplateRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SendEmailHtmlInTemplateRequestImpl sendEmailHtmlInTemplateRequest =
        (SendEmailHtmlInTemplateRequestImpl) o;
    return Objects.equals(this.to, sendEmailHtmlInTemplateRequest.to)
        && Objects.equals(this.from, sendEmailHtmlInTemplateRequest.from)
        && Objects.equals(this.cc, sendEmailHtmlInTemplateRequest.cc)
        && Objects.equals(this.bcc, sendEmailHtmlInTemplateRequest.bcc)
        && Objects.equals(this.subject, sendEmailHtmlInTemplateRequest.subject)
        && Objects.equals(this.text, sendEmailHtmlInTemplateRequest.text)
        && Objects.equals(this.ampHtml, sendEmailHtmlInTemplateRequest.ampHtml)
        && Objects.equals(this.attachment, sendEmailHtmlInTemplateRequest.attachment)
        && Objects.equals(this.inline, sendEmailHtmlInTemplateRequest.inline)
        && Objects.equals(
            this.recipientVariables, sendEmailHtmlInTemplateRequest.recipientVariables)
        && Objects.equals(
            this.overrideProperties, sendEmailHtmlInTemplateRequest.overrideProperties)
        && Objects.equals(this.customVariables, sendEmailHtmlInTemplateRequest.customVariables)
        && Objects.equals(this.customHeaders, sendEmailHtmlInTemplateRequest.customHeaders)
        && Objects.equals(this.template, sendEmailHtmlInTemplateRequest.template)
        && Objects.equals(
            this.templateProperties, sendEmailHtmlInTemplateRequest.templateProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        to,
        from,
        cc,
        bcc,
        subject,
        text,
        ampHtml,
        attachment,
        inline,
        recipientVariables,
        overrideProperties,
        customVariables,
        customHeaders,
        template,
        templateProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SendEmailHtmlInTemplateRequestImpl {\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    cc: ").append(toIndentedString(cc)).append("\n");
    sb.append("    bcc: ").append(toIndentedString(bcc)).append("\n");
    sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
    sb.append("    ampHtml: ").append(toIndentedString(ampHtml)).append("\n");
    sb.append("    attachment: ").append(toIndentedString(attachment)).append("\n");
    sb.append("    inline: ").append(toIndentedString(inline)).append("\n");
    sb.append("    recipientVariables: ").append(toIndentedString(recipientVariables)).append("\n");
    sb.append("    overrideProperties: ").append(toIndentedString(overrideProperties)).append("\n");
    sb.append("    customVariables: ").append(toIndentedString(customVariables)).append("\n");
    sb.append("    customHeaders: ").append(toIndentedString(customHeaders)).append("\n");
    sb.append("    template: ").append(toIndentedString(template)).append("\n");
    sb.append("    templateProperties: ").append(toIndentedString(templateProperties)).append("\n");
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

  static class Builder implements SendEmailHtmlInTemplateRequest.Builder {
    OptionalValue<List<String>> to = OptionalValue.empty();
    OptionalValue<String> from = OptionalValue.empty();
    OptionalValue<List<String>> cc = OptionalValue.empty();
    OptionalValue<List<String>> bcc = OptionalValue.empty();
    OptionalValue<String> subject = OptionalValue.empty();
    OptionalValue<String> text = OptionalValue.empty();
    OptionalValue<String> ampHtml = OptionalValue.empty();
    OptionalValue<List<File>> attachment = OptionalValue.empty();
    OptionalValue<List<File>> inline = OptionalValue.empty();
    OptionalValue<Map<String, Collection<Pair<String, String>>>> recipientVariables =
        OptionalValue.empty();
    OptionalValue<OverrideProperties> overrideProperties = OptionalValue.empty();
    OptionalValue<List<Pair<String, String>>> customVariables = OptionalValue.empty();
    OptionalValue<List<Pair<String, String>>> customHeaders = OptionalValue.empty();
    OptionalValue<String> template = OptionalValue.empty();
    OptionalValue<TemplateProperties> templateProperties = OptionalValue.empty();

    @Property(value = PROPERTY_TO)
    public Builder setTo(List<String> to) {
      this.to = OptionalValue.of(to);
      return this;
    }

    @Property(value = PROPERTY_FROM)
    public Builder setFrom(String from) {
      this.from = OptionalValue.of(from);
      return this;
    }

    @Property(value = PROPERTY_CC)
    public Builder setCc(List<String> cc) {
      this.cc = OptionalValue.of(cc);
      return this;
    }

    @Property(value = PROPERTY_BCC)
    public Builder setBcc(List<String> bcc) {
      this.bcc = OptionalValue.of(bcc);
      return this;
    }

    @Property(value = PROPERTY_SUBJECT)
    public Builder setSubject(String subject) {
      this.subject = OptionalValue.of(subject);
      return this;
    }

    @Property(value = PROPERTY_TEXT)
    public Builder setText(String text) {
      this.text = OptionalValue.of(text);
      return this;
    }

    @Property(value = PROPERTY_AMP_HTML)
    public Builder setAmpHtml(String ampHtml) {
      this.ampHtml = OptionalValue.of(ampHtml);
      return this;
    }

    @Property(value = PROPERTY_ATTACHMENT)
    public Builder setAttachment(List<File> attachment) {
      this.attachment = OptionalValue.of(attachment);
      return this;
    }

    @Property(value = PROPERTY_INLINE)
    public Builder setInline(List<File> inline) {
      this.inline = OptionalValue.of(inline);
      return this;
    }

    @Property(value = PROPERTY_RECIPIENT_VARIABLES)
    public Builder setRecipientVariables(
        Map<String, Collection<Pair<String, String>>> recipientVariables) {
      this.recipientVariables = OptionalValue.of(recipientVariables);
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

    @Property(value = PROPERTY_TEMPLATE)
    public Builder setTemplate(String template) {
      this.template = OptionalValue.of(template);
      return this;
    }

    @Property(value = PROPERTY_TEMPLATE_PROPERTIES)
    public Builder setTemplateProperties(TemplateProperties templateProperties) {
      this.templateProperties = OptionalValue.of(templateProperties);
      return this;
    }

    public SendEmailHtmlInTemplateRequest build() {
      return new SendEmailHtmlInTemplateRequestImpl(
          to,
          from,
          cc,
          bcc,
          subject,
          text,
          ampHtml,
          attachment,
          inline,
          recipientVariables,
          overrideProperties,
          customVariables,
          customHeaders,
          template,
          templateProperties);
    }
  }
}
