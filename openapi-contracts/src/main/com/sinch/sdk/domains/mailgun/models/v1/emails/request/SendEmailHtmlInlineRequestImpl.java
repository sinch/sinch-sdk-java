package com.sinch.sdk.domains.mailgun.models.v1.emails.request;

import com.sinch.sdk.core.databind.annotation.FormSerialize;
import com.sinch.sdk.core.databind.annotation.Property;
import com.sinch.sdk.core.databind.annotation.Required;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.domains.mailgun.api.v1.adapters.MapOfPairsToJSONHelper;
import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class SendEmailHtmlInlineRequestImpl
    implements SendEmailHtmlInlineRequest, SendEmailRequest {
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

  private OptionalValue<String> recipientVariables;

  public static final String PROPERTY_OVERRIDE_PROPERTIES = "overrideProperties";

  private OptionalValue<OverrideProperties> overrideProperties;

  public static final String PROPERTY_CUSTOM_VARIABLES = "customVariables";

  private OptionalValue<List<Pair<String, String>>> customVariables;

  public static final String PROPERTY_CUSTOM_HEADERS = "customHeaders";

  private OptionalValue<List<Pair<String, String>>> customHeaders;

  public static final String PROPERTY_HTML = "html";

  private OptionalValue<String> html;

  public SendEmailHtmlInlineRequestImpl() {}

  protected SendEmailHtmlInlineRequestImpl(
      OptionalValue<List<String>> to,
      OptionalValue<String> from,
      OptionalValue<List<String>> cc,
      OptionalValue<List<String>> bcc,
      OptionalValue<String> subject,
      OptionalValue<String> text,
      OptionalValue<String> ampHtml,
      OptionalValue<List<File>> attachment,
      OptionalValue<List<File>> inline,
      OptionalValue<String> recipientVariables,
      OptionalValue<OverrideProperties> overrideProperties,
      OptionalValue<List<Pair<String, String>>> customVariables,
      OptionalValue<List<Pair<String, String>>> customHeaders,
      OptionalValue<String> html) {
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
    this.html = html;
  }

  public List<String> getTo() {
    return to.orElse(null);
  }

  @Required
  @Property(PROPERTY_TO)
  public OptionalValue<List<String>> to() {
    return to;
  }

  public String getFrom() {
    return from.orElse(null);
  }

  @Required
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

  @Required
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

  public String getRecipientVariables() {
    return recipientVariables.orElse(null);
  }

  @Property(PROPERTY_RECIPIENT_VARIABLES)
  public OptionalValue<String> recipientVariables() {
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

  public String getHtml() {
    return html.orElse(null);
  }

  @Property(PROPERTY_HTML)
  public OptionalValue<String> html() {
    return html;
  }

  /** Return true if this SendEmailHtmlInlineRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SendEmailHtmlInlineRequestImpl sendEmailHtmlInlineRequest = (SendEmailHtmlInlineRequestImpl) o;
    return Objects.equals(this.to, sendEmailHtmlInlineRequest.to)
        && Objects.equals(this.from, sendEmailHtmlInlineRequest.from)
        && Objects.equals(this.cc, sendEmailHtmlInlineRequest.cc)
        && Objects.equals(this.bcc, sendEmailHtmlInlineRequest.bcc)
        && Objects.equals(this.subject, sendEmailHtmlInlineRequest.subject)
        && Objects.equals(this.text, sendEmailHtmlInlineRequest.text)
        && Objects.equals(this.ampHtml, sendEmailHtmlInlineRequest.ampHtml)
        && Objects.equals(this.attachment, sendEmailHtmlInlineRequest.attachment)
        && Objects.equals(this.inline, sendEmailHtmlInlineRequest.inline)
        && Objects.equals(this.recipientVariables, sendEmailHtmlInlineRequest.recipientVariables)
        && Objects.equals(this.overrideProperties, sendEmailHtmlInlineRequest.overrideProperties)
        && Objects.equals(this.customVariables, sendEmailHtmlInlineRequest.customVariables)
        && Objects.equals(this.customHeaders, sendEmailHtmlInlineRequest.customHeaders)
        && Objects.equals(this.html, sendEmailHtmlInlineRequest.html);
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
        html);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SendEmailHtmlInlineRequestImpl {\n");
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
    sb.append("    html: ").append(toIndentedString(html)).append("\n");
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

  static class Builder implements SendEmailHtmlInlineRequest.Builder {
    OptionalValue<List<String>> to = OptionalValue.empty();
    OptionalValue<String> from = OptionalValue.empty();
    OptionalValue<List<String>> cc = OptionalValue.empty();
    OptionalValue<List<String>> bcc = OptionalValue.empty();
    OptionalValue<String> subject = OptionalValue.empty();
    OptionalValue<String> text = OptionalValue.empty();
    OptionalValue<String> ampHtml = OptionalValue.empty();
    OptionalValue<List<File>> attachment = OptionalValue.empty();
    OptionalValue<List<File>> inline = OptionalValue.empty();
    OptionalValue<String> recipientVariables = OptionalValue.empty();
    OptionalValue<OverrideProperties> overrideProperties = OptionalValue.empty();
    OptionalValue<List<Pair<String, String>>> customVariables = OptionalValue.empty();
    OptionalValue<List<Pair<String, String>>> customHeaders = OptionalValue.empty();
    OptionalValue<String> html = OptionalValue.empty();

    public Builder setRecipientVariables(
        Map<String, Collection<Pair<String, Object>>> recipientVariables) {
      return setRecipientVariables(MapOfPairsToJSONHelper.serialize(recipientVariables));
    }

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
    public Builder setRecipientVariables(String recipientVariables) {
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

    @Property(value = PROPERTY_HTML)
    public Builder setHtml(String html) {
      this.html = OptionalValue.of(html);
      return this;
    }

    public SendEmailHtmlInlineRequest build() {
      return new SendEmailHtmlInlineRequestImpl(
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
          html);
    }
  }
}
