package com.sinch.sdk.domains.mailgun.models.v1.emails.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  GetStoredEmailResponseImpl.JSON_PROPERTY_TO,
  GetStoredEmailResponseImpl.JSON_PROPERTY_SENDER,
  GetStoredEmailResponseImpl.JSON_PROPERTY_RECIPIENTS,
  GetStoredEmailResponseImpl.JSON_PROPERTY_FROM,
  GetStoredEmailResponseImpl.JSON_PROPERTY_SUBJECT,
  GetStoredEmailResponseImpl.JSON_PROPERTY_BODY_HTML,
  GetStoredEmailResponseImpl.JSON_PROPERTY_BODY_PLAIN,
  GetStoredEmailResponseImpl.JSON_PROPERTY_STRIPPED_HTML,
  GetStoredEmailResponseImpl.JSON_PROPERTY_STRIPPED_TEXT,
  GetStoredEmailResponseImpl.JSON_PROPERTY_STRIPPED_SIGNATURE,
  GetStoredEmailResponseImpl.JSON_PROPERTY_MESSAGE_HEADERS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class GetStoredEmailResponseImpl implements GetStoredEmailResponse {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TO = "To";

  private OptionalValue<String> to;

  public static final String JSON_PROPERTY_SENDER = "sender";

  private OptionalValue<String> sender;

  public static final String JSON_PROPERTY_RECIPIENTS = "recipients";

  private OptionalValue<String> recipients;

  public static final String JSON_PROPERTY_FROM = "from";

  private OptionalValue<String> from;

  public static final String JSON_PROPERTY_SUBJECT = "subject";

  private OptionalValue<String> subject;

  public static final String JSON_PROPERTY_BODY_HTML = "body-html";

  private OptionalValue<String> bodyHtml;

  public static final String JSON_PROPERTY_BODY_PLAIN = "body-plain";

  private OptionalValue<String> bodyPlain;

  public static final String JSON_PROPERTY_STRIPPED_HTML = "stripped-html";

  private OptionalValue<String> strippedHtml;

  public static final String JSON_PROPERTY_STRIPPED_TEXT = "stripped-text";

  private OptionalValue<String> strippedText;

  public static final String JSON_PROPERTY_STRIPPED_SIGNATURE = "stripped-signature";

  private OptionalValue<String> strippedSignature;

  public static final String JSON_PROPERTY_MESSAGE_HEADERS = "message-headers";

  private OptionalValue<List<List<String>>> messageHeaders;

  public GetStoredEmailResponseImpl() {}

  protected GetStoredEmailResponseImpl(
      OptionalValue<String> to,
      OptionalValue<String> sender,
      OptionalValue<String> recipients,
      OptionalValue<String> from,
      OptionalValue<String> subject,
      OptionalValue<String> bodyHtml,
      OptionalValue<String> bodyPlain,
      OptionalValue<String> strippedHtml,
      OptionalValue<String> strippedText,
      OptionalValue<String> strippedSignature,
      OptionalValue<List<List<String>>> messageHeaders) {
    this.to = to;
    this.sender = sender;
    this.recipients = recipients;
    this.from = from;
    this.subject = subject;
    this.bodyHtml = bodyHtml;
    this.bodyPlain = bodyPlain;
    this.strippedHtml = strippedHtml;
    this.strippedText = strippedText;
    this.strippedSignature = strippedSignature;
    this.messageHeaders = messageHeaders;
  }

  @JsonIgnore
  public String getTo() {
    return to.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TO)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> to() {
    return to;
  }

  @JsonIgnore
  public String getSender() {
    return sender.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SENDER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> sender() {
    return sender;
  }

  @JsonIgnore
  public String getRecipients() {
    return recipients.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_RECIPIENTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> recipients() {
    return recipients;
  }

  @JsonIgnore
  public String getFrom() {
    return from.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FROM)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> from() {
    return from;
  }

  @JsonIgnore
  public String getSubject() {
    return subject.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SUBJECT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> subject() {
    return subject;
  }

  @JsonIgnore
  public String getBodyHtml() {
    return bodyHtml.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_BODY_HTML)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> bodyHtml() {
    return bodyHtml;
  }

  @JsonIgnore
  public String getBodyPlain() {
    return bodyPlain.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_BODY_PLAIN)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> bodyPlain() {
    return bodyPlain;
  }

  @JsonIgnore
  public String getStrippedHtml() {
    return strippedHtml.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_STRIPPED_HTML)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> strippedHtml() {
    return strippedHtml;
  }

  @JsonIgnore
  public String getStrippedText() {
    return strippedText.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_STRIPPED_TEXT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> strippedText() {
    return strippedText;
  }

  @JsonIgnore
  public String getStrippedSignature() {
    return strippedSignature.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_STRIPPED_SIGNATURE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> strippedSignature() {
    return strippedSignature;
  }

  @JsonIgnore
  public List<List<String>> getMessageHeaders() {
    return messageHeaders.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MESSAGE_HEADERS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<List<List<String>>> messageHeaders() {
    return messageHeaders;
  }

  /**
   * Return true if this github.com-mailgun-influx-httpapi-GetMessageResponseBasicExample object is
   * equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetStoredEmailResponseImpl githubComMailgunInfluxHttpapiGetMessageResponseBasicExample =
        (GetStoredEmailResponseImpl) o;
    return Objects.equals(this.to, githubComMailgunInfluxHttpapiGetMessageResponseBasicExample.to)
        && Objects.equals(
            this.sender, githubComMailgunInfluxHttpapiGetMessageResponseBasicExample.sender)
        && Objects.equals(
            this.recipients, githubComMailgunInfluxHttpapiGetMessageResponseBasicExample.recipients)
        && Objects.equals(
            this.from, githubComMailgunInfluxHttpapiGetMessageResponseBasicExample.from)
        && Objects.equals(
            this.subject, githubComMailgunInfluxHttpapiGetMessageResponseBasicExample.subject)
        && Objects.equals(
            this.bodyHtml, githubComMailgunInfluxHttpapiGetMessageResponseBasicExample.bodyHtml)
        && Objects.equals(
            this.bodyPlain, githubComMailgunInfluxHttpapiGetMessageResponseBasicExample.bodyPlain)
        && Objects.equals(
            this.strippedHtml,
            githubComMailgunInfluxHttpapiGetMessageResponseBasicExample.strippedHtml)
        && Objects.equals(
            this.strippedText,
            githubComMailgunInfluxHttpapiGetMessageResponseBasicExample.strippedText)
        && Objects.equals(
            this.strippedSignature,
            githubComMailgunInfluxHttpapiGetMessageResponseBasicExample.strippedSignature)
        && Objects.equals(
            this.messageHeaders,
            githubComMailgunInfluxHttpapiGetMessageResponseBasicExample.messageHeaders);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        to,
        sender,
        recipients,
        from,
        subject,
        bodyHtml,
        bodyPlain,
        strippedHtml,
        strippedText,
        strippedSignature,
        messageHeaders);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetStoredEmailResponseImpl {\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    sender: ").append(toIndentedString(sender)).append("\n");
    sb.append("    recipients: ").append(toIndentedString(recipients)).append("\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
    sb.append("    bodyHtml: ").append(toIndentedString(bodyHtml)).append("\n");
    sb.append("    bodyPlain: ").append(toIndentedString(bodyPlain)).append("\n");
    sb.append("    strippedHtml: ").append(toIndentedString(strippedHtml)).append("\n");
    sb.append("    strippedText: ").append(toIndentedString(strippedText)).append("\n");
    sb.append("    strippedSignature: ").append(toIndentedString(strippedSignature)).append("\n");
    sb.append("    messageHeaders: ").append(toIndentedString(messageHeaders)).append("\n");
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
  static class Builder implements GetStoredEmailResponse.Builder {
    OptionalValue<String> to = OptionalValue.empty();
    OptionalValue<String> sender = OptionalValue.empty();
    OptionalValue<String> recipients = OptionalValue.empty();
    OptionalValue<String> from = OptionalValue.empty();
    OptionalValue<String> subject = OptionalValue.empty();
    OptionalValue<String> bodyHtml = OptionalValue.empty();
    OptionalValue<String> bodyPlain = OptionalValue.empty();
    OptionalValue<String> strippedHtml = OptionalValue.empty();
    OptionalValue<String> strippedText = OptionalValue.empty();
    OptionalValue<String> strippedSignature = OptionalValue.empty();
    OptionalValue<List<List<String>>> messageHeaders = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_TO)
    public Builder setTo(String to) {
      this.to = OptionalValue.of(to);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SENDER)
    public Builder setSender(String sender) {
      this.sender = OptionalValue.of(sender);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_RECIPIENTS)
    public Builder setRecipients(String recipients) {
      this.recipients = OptionalValue.of(recipients);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_FROM)
    public Builder setFrom(String from) {
      this.from = OptionalValue.of(from);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SUBJECT)
    public Builder setSubject(String subject) {
      this.subject = OptionalValue.of(subject);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_BODY_HTML)
    public Builder setBodyHtml(String bodyHtml) {
      this.bodyHtml = OptionalValue.of(bodyHtml);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_BODY_PLAIN)
    public Builder setBodyPlain(String bodyPlain) {
      this.bodyPlain = OptionalValue.of(bodyPlain);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_STRIPPED_HTML)
    public Builder setStrippedHtml(String strippedHtml) {
      this.strippedHtml = OptionalValue.of(strippedHtml);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_STRIPPED_TEXT)
    public Builder setStrippedText(String strippedText) {
      this.strippedText = OptionalValue.of(strippedText);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_STRIPPED_SIGNATURE)
    public Builder setStrippedSignature(String strippedSignature) {
      this.strippedSignature = OptionalValue.of(strippedSignature);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MESSAGE_HEADERS)
    public Builder setMessageHeaders(List<List<String>> messageHeaders) {
      this.messageHeaders = OptionalValue.of(messageHeaders);
      return this;
    }

    public GetStoredEmailResponse build() {
      return new GetStoredEmailResponseImpl(
          to,
          sender,
          recipients,
          from,
          subject,
          bodyHtml,
          bodyPlain,
          strippedHtml,
          strippedText,
          strippedSignature,
          messageHeaders);
    }
  }
}
