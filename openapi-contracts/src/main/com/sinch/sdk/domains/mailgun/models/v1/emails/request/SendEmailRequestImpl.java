package com.sinch.sdk.domains.mailgun.models.v1.emails.request;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonPropertyOrder({
  SendEmailRequestImpl.JSON_PROPERTY_FROM,
  SendEmailRequestImpl.JSON_PROPERTY_TO,
  SendEmailRequestImpl.JSON_PROPERTY_CC,
  SendEmailRequestImpl.JSON_PROPERTY_BCC,
  SendEmailRequestImpl.JSON_PROPERTY_SUBJECT,
  SendEmailRequestImpl.JSON_PROPERTY_TEXT,
  SendEmailRequestImpl.JSON_PROPERTY_HTML,
  SendEmailRequestImpl.JSON_PROPERTY_AMP_HTML,
  SendEmailRequestImpl.JSON_PROPERTY_ATTACHMENT,
  SendEmailRequestImpl.JSON_PROPERTY_INLINE,
  SendEmailRequestImpl.JSON_PROPERTY_TEMPLATE,
  SendEmailRequestImpl.JSON_PROPERTY_T_COLON_VERSION,
  SendEmailRequestImpl.JSON_PROPERTY_T_COLON_TEXT,
  SendEmailRequestImpl.JSON_PROPERTY_T_COLON_VARIABLES,
  SendEmailRequestImpl.JSON_PROPERTY_O_COLON_TAG,
  SendEmailRequestImpl.JSON_PROPERTY_O_COLON_DKIM,
  SendEmailRequestImpl.JSON_PROPERTY_O_COLON_SECONDARY_DKIM,
  SendEmailRequestImpl.JSON_PROPERTY_O_COLON_SECONDARY_DKIM_PUBLIC,
  SendEmailRequestImpl.JSON_PROPERTY_O_COLON_DELIVERYTIME,
  SendEmailRequestImpl.JSON_PROPERTY_O_COLON_DELIVERYTIME_OPTIMIZE_PERIOD,
  SendEmailRequestImpl.JSON_PROPERTY_O_COLON_TIME_ZONE_LOCALIZE,
  SendEmailRequestImpl.JSON_PROPERTY_O_COLON_TESTMODE,
  SendEmailRequestImpl.JSON_PROPERTY_O_COLON_TRACKING,
  SendEmailRequestImpl.JSON_PROPERTY_O_COLON_TRACKING_CLICKS,
  SendEmailRequestImpl.JSON_PROPERTY_O_COLON_TRACKING_OPENS,
  SendEmailRequestImpl.JSON_PROPERTY_O_COLON_REQUIRE_TLS,
  SendEmailRequestImpl.JSON_PROPERTY_O_COLON_SKIP_VERIFICATION,
  SendEmailRequestImpl.JSON_PROPERTY_O_COLON_SENDING_IP,
  SendEmailRequestImpl.JSON_PROPERTY_O_COLON_SENDING_IP_POOL,
  SendEmailRequestImpl.JSON_PROPERTY_O_COLON_TRACKING_PIXEL_LOCATION_TOP,
  SendEmailRequestImpl.JSON_PROPERTY_H_COLON_X_MY_HEADER,
  SendEmailRequestImpl.JSON_PROPERTY_V_COLON_MY_VAR,
  SendEmailRequestImpl.JSON_PROPERTY_RECIPIENT_VARIABLES
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class SendEmailRequestImpl implements SendEmailRequest {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_FROM = "from";

  private OptionalValue<String> from;

  public static final String JSON_PROPERTY_TO = "to";

  private OptionalValue<List<String>> to;

  public static final String JSON_PROPERTY_CC = "cc";

  private OptionalValue<List<String>> cc;

  public static final String JSON_PROPERTY_BCC = "bcc";

  private OptionalValue<List<String>> bcc;

  public static final String JSON_PROPERTY_SUBJECT = "subject";

  private OptionalValue<String> subject;

  public static final String JSON_PROPERTY_TEXT = "text";

  private OptionalValue<String> text;

  public static final String JSON_PROPERTY_HTML = "html";

  private OptionalValue<String> html;

  public static final String JSON_PROPERTY_AMP_HTML = "amp-html";

  private OptionalValue<String> ampHtml;

  public static final String JSON_PROPERTY_ATTACHMENT = "attachment";

  private OptionalValue<List<File>> attachment;

  public static final String JSON_PROPERTY_INLINE = "inline";

  private OptionalValue<List<File>> inline;

  public static final String JSON_PROPERTY_TEMPLATE = "template";

  private OptionalValue<String> template;

  public static final String JSON_PROPERTY_T_COLON_VERSION = "t:version";

  private OptionalValue<String> templateVersion;

  public static final String JSON_PROPERTY_T_COLON_TEXT = "t:text";

  private OptionalValue<TemplateTextEnum> templateText;

  public static final String JSON_PROPERTY_T_COLON_VARIABLES = "t:variables";

  private OptionalValue<String> templateVariables;

  public static final String JSON_PROPERTY_O_COLON_TAG = "o:tag";

  private OptionalValue<List<String>> tag;

  public static final String JSON_PROPERTY_O_COLON_DKIM = "o:dkim";

  private OptionalValue<DkimSignatureEnum> enableDkimSignature;

  public static final String JSON_PROPERTY_O_COLON_SECONDARY_DKIM = "o:secondary-dkim";

  private OptionalValue<String> secondaryDkim;

  public static final String JSON_PROPERTY_O_COLON_SECONDARY_DKIM_PUBLIC =
      "o:secondary-dkim-public";

  private OptionalValue<String> secondaryDkimPublic;

  public static final String JSON_PROPERTY_O_COLON_DELIVERYTIME = "o:deliverytime";

  private OptionalValue<String> deliveryTime;

  public static final String JSON_PROPERTY_O_COLON_DELIVERYTIME_OPTIMIZE_PERIOD =
      "o:deliverytime-optimize-period";

  private OptionalValue<String> deliveryTimeOptimizePeriod;

  public static final String JSON_PROPERTY_O_COLON_TIME_ZONE_LOCALIZE = "o:time-zone-localize";

  private OptionalValue<String> timezoneLocalize;

  public static final String JSON_PROPERTY_O_COLON_TESTMODE = "o:testmode";

  private OptionalValue<TestModeEnum> testMode;

  public static final String JSON_PROPERTY_O_COLON_TRACKING = "o:tracking";

  private OptionalValue<TrackingEnum> tracking;

  public static final String JSON_PROPERTY_O_COLON_TRACKING_CLICKS = "o:tracking-clicks";

  private OptionalValue<TrackingClicksEnum> trackingClicks;

  public static final String JSON_PROPERTY_O_COLON_TRACKING_OPENS = "o:tracking-opens";

  private OptionalValue<TrackingOpensEnum> trackingOpens;

  public static final String JSON_PROPERTY_O_COLON_REQUIRE_TLS = "o:require-tls";

  private OptionalValue<RequireTlsEnum> requireTls;

  public static final String JSON_PROPERTY_O_COLON_SKIP_VERIFICATION = "o:skip-verification";

  private OptionalValue<SkipVerificationEnum> skipVerification;

  public static final String JSON_PROPERTY_O_COLON_SENDING_IP = "o:sending-ip";

  private OptionalValue<String> sendingIp;

  public static final String JSON_PROPERTY_O_COLON_SENDING_IP_POOL = "o:sending-ip-pool";

  private OptionalValue<String> sendingIpPool;

  public static final String JSON_PROPERTY_O_COLON_TRACKING_PIXEL_LOCATION_TOP =
      "o:tracking-pixel-location-top";

  private OptionalValue<String> trackingPixelLocationTop;

  public static final String JSON_PROPERTY_H_COLON_X_MY_HEADER = "h:X-My-Header";

  private OptionalValue<String> hColonXMyHeader;

  public static final String JSON_PROPERTY_V_COLON_MY_VAR = "v:my-var";

  private OptionalValue<String> vColonMyVar;

  public static final String JSON_PROPERTY_RECIPIENT_VARIABLES = "recipient-variables";

  private OptionalValue<String> recipientVariables;

  /**
   * A container for additional, undeclared properties. This is a holder for any undeclared
   * properties as specified with the 'additionalProperties' keyword in the OAS document.
   */
  private OptionalValue<Map<String, Object>> additionalProperties;

  public SendEmailRequestImpl() {}

  protected SendEmailRequestImpl(
      OptionalValue<String> from,
      OptionalValue<List<String>> to,
      OptionalValue<List<String>> cc,
      OptionalValue<List<String>> bcc,
      OptionalValue<String> subject,
      OptionalValue<String> text,
      OptionalValue<String> html,
      OptionalValue<String> ampHtml,
      OptionalValue<List<File>> attachment,
      OptionalValue<List<File>> inline,
      OptionalValue<String> template,
      OptionalValue<String> templateVersion,
      OptionalValue<TemplateTextEnum> templateText,
      OptionalValue<String> templateVariables,
      OptionalValue<List<String>> tag,
      OptionalValue<DkimSignatureEnum> enableDkimSignature,
      OptionalValue<String> secondaryDkim,
      OptionalValue<String> secondaryDkimPublic,
      OptionalValue<String> deliveryTime,
      OptionalValue<String> deliveryTimeOptimizePeriod,
      OptionalValue<String> timezoneLocalize,
      OptionalValue<TestModeEnum> testMode,
      OptionalValue<TrackingEnum> tracking,
      OptionalValue<TrackingClicksEnum> trackingClicks,
      OptionalValue<TrackingOpensEnum> trackingOpens,
      OptionalValue<RequireTlsEnum> requireTls,
      OptionalValue<SkipVerificationEnum> skipVerification,
      OptionalValue<String> sendingIp,
      OptionalValue<String> sendingIpPool,
      OptionalValue<String> trackingPixelLocationTop,
      OptionalValue<String> hColonXMyHeader,
      OptionalValue<String> vColonMyVar,
      OptionalValue<String> recipientVariables,
      OptionalValue<Map<String, Object>> additionalProperties) {
    this.from = from;
    this.to = to;
    this.cc = cc;
    this.bcc = bcc;
    this.subject = subject;
    this.text = text;
    this.html = html;
    this.ampHtml = ampHtml;
    this.attachment = attachment;
    this.inline = inline;
    this.template = template;
    this.templateVersion = templateVersion;
    this.templateText = templateText;
    this.templateVariables = templateVariables;
    this.tag = tag;
    this.enableDkimSignature = enableDkimSignature;
    this.secondaryDkim = secondaryDkim;
    this.secondaryDkimPublic = secondaryDkimPublic;
    this.deliveryTime = deliveryTime;
    this.deliveryTimeOptimizePeriod = deliveryTimeOptimizePeriod;
    this.timezoneLocalize = timezoneLocalize;
    this.testMode = testMode;
    this.tracking = tracking;
    this.trackingClicks = trackingClicks;
    this.trackingOpens = trackingOpens;
    this.requireTls = requireTls;
    this.skipVerification = skipVerification;
    this.sendingIp = sendingIp;
    this.sendingIpPool = sendingIpPool;
    this.trackingPixelLocationTop = trackingPixelLocationTop;
    this.hColonXMyHeader = hColonXMyHeader;
    this.vColonMyVar = vColonMyVar;
    this.recipientVariables = recipientVariables;
    this.additionalProperties = additionalProperties;
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
  public List<String> getTo() {
    return to.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TO)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<List<String>> to() {
    return to;
  }

  @JsonIgnore
  public List<String> getCc() {
    return cc.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CC)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<String>> cc() {
    return cc;
  }

  @JsonIgnore
  public List<String> getBcc() {
    return bcc.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_BCC)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<String>> bcc() {
    return bcc;
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
  public String getText() {
    return text.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TEXT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> text() {
    return text;
  }

  @JsonIgnore
  public String getHtml() {
    return html.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_HTML)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> html() {
    return html;
  }

  @JsonIgnore
  public String getAmpHtml() {
    return ampHtml.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_AMP_HTML)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> ampHtml() {
    return ampHtml;
  }

  @JsonIgnore
  public List<File> getAttachment() {
    return attachment.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ATTACHMENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<File>> attachment() {
    return attachment;
  }

  @JsonIgnore
  public List<File> getInline() {
    return inline.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_INLINE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<File>> inline() {
    return inline;
  }

  @JsonIgnore
  public String getTemplate() {
    return template.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TEMPLATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> template() {
    return template;
  }

  @JsonIgnore
  public String getTemplateVersion() {
    return templateVersion.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_T_COLON_VERSION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> templateVersion() {
    return templateVersion;
  }

  @JsonIgnore
  public TemplateTextEnum getTemplateText() {
    return templateText.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_T_COLON_TEXT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<TemplateTextEnum> templateText() {
    return templateText;
  }

  @JsonIgnore
  public String getTemplateVariables() {
    return templateVariables.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_T_COLON_VARIABLES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> templateVariables() {
    return templateVariables;
  }

  @JsonIgnore
  public List<String> getTag() {
    return tag.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_O_COLON_TAG)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<String>> tag() {
    return tag;
  }

  @JsonIgnore
  public DkimSignatureEnum getEnableDkimSignature() {
    return enableDkimSignature.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_O_COLON_DKIM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<DkimSignatureEnum> enableDkimSignature() {
    return enableDkimSignature;
  }

  @JsonIgnore
  public String getSecondaryDkim() {
    return secondaryDkim.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_O_COLON_SECONDARY_DKIM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> secondaryDkim() {
    return secondaryDkim;
  }

  @JsonIgnore
  public String getSecondaryDkimPublic() {
    return secondaryDkimPublic.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_O_COLON_SECONDARY_DKIM_PUBLIC)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> secondaryDkimPublic() {
    return secondaryDkimPublic;
  }

  @JsonIgnore
  public String getDeliveryTime() {
    return deliveryTime.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_O_COLON_DELIVERYTIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> deliveryTime() {
    return deliveryTime;
  }

  @JsonIgnore
  public String getDeliveryTimeOptimizePeriod() {
    return deliveryTimeOptimizePeriod.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_O_COLON_DELIVERYTIME_OPTIMIZE_PERIOD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> deliveryTimeOptimizePeriod() {
    return deliveryTimeOptimizePeriod;
  }

  @JsonIgnore
  public String getTimezoneLocalize() {
    return timezoneLocalize.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_O_COLON_TIME_ZONE_LOCALIZE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> timezoneLocalize() {
    return timezoneLocalize;
  }

  @JsonIgnore
  public TestModeEnum getTestMode() {
    return testMode.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_O_COLON_TESTMODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<TestModeEnum> testMode() {
    return testMode;
  }

  @JsonIgnore
  public TrackingEnum getTracking() {
    return tracking.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_O_COLON_TRACKING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<TrackingEnum> tracking() {
    return tracking;
  }

  @JsonIgnore
  public TrackingClicksEnum getTrackingClicks() {
    return trackingClicks.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_O_COLON_TRACKING_CLICKS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<TrackingClicksEnum> trackingClicks() {
    return trackingClicks;
  }

  @JsonIgnore
  public TrackingOpensEnum getTrackingOpens() {
    return trackingOpens.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_O_COLON_TRACKING_OPENS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<TrackingOpensEnum> trackingOpens() {
    return trackingOpens;
  }

  @JsonIgnore
  public RequireTlsEnum getRequireTls() {
    return requireTls.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_O_COLON_REQUIRE_TLS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<RequireTlsEnum> requireTls() {
    return requireTls;
  }

  @JsonIgnore
  public SkipVerificationEnum getSkipVerification() {
    return skipVerification.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_O_COLON_SKIP_VERIFICATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<SkipVerificationEnum> skipVerification() {
    return skipVerification;
  }

  @JsonIgnore
  public String getSendingIp() {
    return sendingIp.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_O_COLON_SENDING_IP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> sendingIp() {
    return sendingIp;
  }

  @JsonIgnore
  public String getSendingIpPool() {
    return sendingIpPool.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_O_COLON_SENDING_IP_POOL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> sendingIpPool() {
    return sendingIpPool;
  }

  @JsonIgnore
  public String getTrackingPixelLocationTop() {
    return trackingPixelLocationTop.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_O_COLON_TRACKING_PIXEL_LOCATION_TOP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> trackingPixelLocationTop() {
    return trackingPixelLocationTop;
  }

  @JsonIgnore
  public String gethColonXMyHeader() {
    return hColonXMyHeader.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_H_COLON_X_MY_HEADER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> hColonXMyHeader() {
    return hColonXMyHeader;
  }

  @JsonIgnore
  public String getvColonMyVar() {
    return vColonMyVar.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_V_COLON_MY_VAR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> vColonMyVar() {
    return vColonMyVar;
  }

  @JsonIgnore
  public String getRecipientVariables() {
    return recipientVariables.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_RECIPIENT_VARIABLES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> recipientVariables() {
    return recipientVariables;
  }

  @JsonIgnore
  public Object get(String key) {

    if (null == this.additionalProperties || !additionalProperties.isPresent()) {
      return null;
    }
    return this.additionalProperties.get().get(key);
  }

  @JsonAnyGetter
  public Map<String, Object> additionalProperties() {
    if (null == this.additionalProperties || !additionalProperties.isPresent()) {
      return null;
    }
    return additionalProperties.get();
  }

  /**
   * Return true if this POST-v3-domain_name-messages-multipart-form-data-RequestBody object is
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
    SendEmailRequestImpl poSTV3DomainNameMessagesMultipartFormDataRequestBody =
        (SendEmailRequestImpl) o;
    return Objects.equals(this.from, poSTV3DomainNameMessagesMultipartFormDataRequestBody.from)
        && Objects.equals(this.to, poSTV3DomainNameMessagesMultipartFormDataRequestBody.to)
        && Objects.equals(this.cc, poSTV3DomainNameMessagesMultipartFormDataRequestBody.cc)
        && Objects.equals(this.bcc, poSTV3DomainNameMessagesMultipartFormDataRequestBody.bcc)
        && Objects.equals(
            this.subject, poSTV3DomainNameMessagesMultipartFormDataRequestBody.subject)
        && Objects.equals(this.text, poSTV3DomainNameMessagesMultipartFormDataRequestBody.text)
        && Objects.equals(this.html, poSTV3DomainNameMessagesMultipartFormDataRequestBody.html)
        && Objects.equals(
            this.ampHtml, poSTV3DomainNameMessagesMultipartFormDataRequestBody.ampHtml)
        && Objects.equals(
            this.attachment, poSTV3DomainNameMessagesMultipartFormDataRequestBody.attachment)
        && Objects.equals(this.inline, poSTV3DomainNameMessagesMultipartFormDataRequestBody.inline)
        && Objects.equals(
            this.template, poSTV3DomainNameMessagesMultipartFormDataRequestBody.template)
        && Objects.equals(
            this.templateVersion,
            poSTV3DomainNameMessagesMultipartFormDataRequestBody.templateVersion)
        && Objects.equals(
            this.templateText, poSTV3DomainNameMessagesMultipartFormDataRequestBody.templateText)
        && Objects.equals(
            this.templateVariables,
            poSTV3DomainNameMessagesMultipartFormDataRequestBody.templateVariables)
        && Objects.equals(this.tag, poSTV3DomainNameMessagesMultipartFormDataRequestBody.tag)
        && Objects.equals(
            this.enableDkimSignature,
            poSTV3DomainNameMessagesMultipartFormDataRequestBody.enableDkimSignature)
        && Objects.equals(
            this.secondaryDkim, poSTV3DomainNameMessagesMultipartFormDataRequestBody.secondaryDkim)
        && Objects.equals(
            this.secondaryDkimPublic,
            poSTV3DomainNameMessagesMultipartFormDataRequestBody.secondaryDkimPublic)
        && Objects.equals(
            this.deliveryTime, poSTV3DomainNameMessagesMultipartFormDataRequestBody.deliveryTime)
        && Objects.equals(
            this.deliveryTimeOptimizePeriod,
            poSTV3DomainNameMessagesMultipartFormDataRequestBody.deliveryTimeOptimizePeriod)
        && Objects.equals(
            this.timezoneLocalize,
            poSTV3DomainNameMessagesMultipartFormDataRequestBody.timezoneLocalize)
        && Objects.equals(
            this.testMode, poSTV3DomainNameMessagesMultipartFormDataRequestBody.testMode)
        && Objects.equals(
            this.tracking, poSTV3DomainNameMessagesMultipartFormDataRequestBody.tracking)
        && Objects.equals(
            this.trackingClicks,
            poSTV3DomainNameMessagesMultipartFormDataRequestBody.trackingClicks)
        && Objects.equals(
            this.trackingOpens, poSTV3DomainNameMessagesMultipartFormDataRequestBody.trackingOpens)
        && Objects.equals(
            this.requireTls, poSTV3DomainNameMessagesMultipartFormDataRequestBody.requireTls)
        && Objects.equals(
            this.skipVerification,
            poSTV3DomainNameMessagesMultipartFormDataRequestBody.skipVerification)
        && Objects.equals(
            this.sendingIp, poSTV3DomainNameMessagesMultipartFormDataRequestBody.sendingIp)
        && Objects.equals(
            this.sendingIpPool, poSTV3DomainNameMessagesMultipartFormDataRequestBody.sendingIpPool)
        && Objects.equals(
            this.trackingPixelLocationTop,
            poSTV3DomainNameMessagesMultipartFormDataRequestBody.trackingPixelLocationTop)
        && Objects.equals(
            this.hColonXMyHeader,
            poSTV3DomainNameMessagesMultipartFormDataRequestBody.hColonXMyHeader)
        && Objects.equals(
            this.vColonMyVar, poSTV3DomainNameMessagesMultipartFormDataRequestBody.vColonMyVar)
        && Objects.equals(
            this.recipientVariables,
            poSTV3DomainNameMessagesMultipartFormDataRequestBody.recipientVariables)
        && Objects.equals(
            this.additionalProperties,
            poSTV3DomainNameMessagesMultipartFormDataRequestBody.additionalProperties)
        && super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        from,
        to,
        cc,
        bcc,
        subject,
        text,
        html,
        ampHtml,
        attachment,
        inline,
        template,
        templateVersion,
        templateText,
        templateVariables,
        tag,
        enableDkimSignature,
        secondaryDkim,
        secondaryDkimPublic,
        deliveryTime,
        deliveryTimeOptimizePeriod,
        timezoneLocalize,
        testMode,
        tracking,
        trackingClicks,
        trackingOpens,
        requireTls,
        skipVerification,
        sendingIp,
        sendingIpPool,
        trackingPixelLocationTop,
        hColonXMyHeader,
        vColonMyVar,
        recipientVariables,
        super.hashCode(),
        additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SendEmailRequestImpl {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    cc: ").append(toIndentedString(cc)).append("\n");
    sb.append("    bcc: ").append(toIndentedString(bcc)).append("\n");
    sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
    sb.append("    html: ").append(toIndentedString(html)).append("\n");
    sb.append("    ampHtml: ").append(toIndentedString(ampHtml)).append("\n");
    sb.append("    attachment: ").append(toIndentedString(attachment)).append("\n");
    sb.append("    inline: ").append(toIndentedString(inline)).append("\n");
    sb.append("    template: ").append(toIndentedString(template)).append("\n");
    sb.append("    templateVersion: ").append(toIndentedString(templateVersion)).append("\n");
    sb.append("    templateText: ").append(toIndentedString(templateText)).append("\n");
    sb.append("    templateVariables: ").append(toIndentedString(templateVariables)).append("\n");
    sb.append("    tag: ").append(toIndentedString(tag)).append("\n");
    sb.append("    enableDkimSignature: ")
        .append(toIndentedString(enableDkimSignature))
        .append("\n");
    sb.append("    secondaryDkim: ").append(toIndentedString(secondaryDkim)).append("\n");
    sb.append("    secondaryDkimPublic: ")
        .append(toIndentedString(secondaryDkimPublic))
        .append("\n");
    sb.append("    deliveryTime: ").append(toIndentedString(deliveryTime)).append("\n");
    sb.append("    deliveryTimeOptimizePeriod: ")
        .append(toIndentedString(deliveryTimeOptimizePeriod))
        .append("\n");
    sb.append("    timezoneLocalize: ").append(toIndentedString(timezoneLocalize)).append("\n");
    sb.append("    testMode: ").append(toIndentedString(testMode)).append("\n");
    sb.append("    tracking: ").append(toIndentedString(tracking)).append("\n");
    sb.append("    trackingClicks: ").append(toIndentedString(trackingClicks)).append("\n");
    sb.append("    trackingOpens: ").append(toIndentedString(trackingOpens)).append("\n");
    sb.append("    requireTls: ").append(toIndentedString(requireTls)).append("\n");
    sb.append("    skipVerification: ").append(toIndentedString(skipVerification)).append("\n");
    sb.append("    sendingIp: ").append(toIndentedString(sendingIp)).append("\n");
    sb.append("    sendingIpPool: ").append(toIndentedString(sendingIpPool)).append("\n");
    sb.append("    trackingPixelLocationTop: ")
        .append(toIndentedString(trackingPixelLocationTop))
        .append("\n");
    sb.append("    hColonXMyHeader: ").append(toIndentedString(hColonXMyHeader)).append("\n");
    sb.append("    vColonMyVar: ").append(toIndentedString(vColonMyVar)).append("\n");
    sb.append("    recipientVariables: ").append(toIndentedString(recipientVariables)).append("\n");
    sb.append("    additionalProperties: ")
        .append(toIndentedString(additionalProperties))
        .append("\n");
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
  static class Builder implements SendEmailRequest.Builder {
    OptionalValue<String> from = OptionalValue.empty();
    OptionalValue<List<String>> to = OptionalValue.empty();
    OptionalValue<List<String>> cc = OptionalValue.empty();
    OptionalValue<List<String>> bcc = OptionalValue.empty();
    OptionalValue<String> subject = OptionalValue.empty();
    OptionalValue<String> text = OptionalValue.empty();
    OptionalValue<String> html = OptionalValue.empty();
    OptionalValue<String> ampHtml = OptionalValue.empty();
    OptionalValue<List<File>> attachment = OptionalValue.empty();
    OptionalValue<List<File>> inline = OptionalValue.empty();
    OptionalValue<String> template = OptionalValue.empty();
    OptionalValue<String> templateVersion = OptionalValue.empty();
    OptionalValue<TemplateTextEnum> templateText = OptionalValue.empty();
    OptionalValue<String> templateVariables = OptionalValue.empty();
    OptionalValue<List<String>> tag = OptionalValue.empty();
    OptionalValue<DkimSignatureEnum> enableDkimSignature = OptionalValue.empty();
    OptionalValue<String> secondaryDkim = OptionalValue.empty();
    OptionalValue<String> secondaryDkimPublic = OptionalValue.empty();
    OptionalValue<String> deliveryTime = OptionalValue.empty();
    OptionalValue<String> deliveryTimeOptimizePeriod = OptionalValue.empty();
    OptionalValue<String> timezoneLocalize = OptionalValue.empty();
    OptionalValue<TestModeEnum> testMode = OptionalValue.empty();
    OptionalValue<TrackingEnum> tracking = OptionalValue.empty();
    OptionalValue<TrackingClicksEnum> trackingClicks = OptionalValue.empty();
    OptionalValue<TrackingOpensEnum> trackingOpens = OptionalValue.empty();
    OptionalValue<RequireTlsEnum> requireTls = OptionalValue.empty();
    OptionalValue<SkipVerificationEnum> skipVerification = OptionalValue.empty();
    OptionalValue<String> sendingIp = OptionalValue.empty();
    OptionalValue<String> sendingIpPool = OptionalValue.empty();
    OptionalValue<String> trackingPixelLocationTop = OptionalValue.empty();
    OptionalValue<String> hColonXMyHeader = OptionalValue.empty();
    OptionalValue<String> vColonMyVar = OptionalValue.empty();
    OptionalValue<String> recipientVariables = OptionalValue.empty();
    OptionalValue<Map<String, Object>> additionalProperties = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_FROM)
    public Builder setFrom(String from) {
      this.from = OptionalValue.of(from);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TO)
    public Builder setTo(List<String> to) {
      this.to = OptionalValue.of(to);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CC)
    public Builder setCc(List<String> cc) {
      this.cc = OptionalValue.of(cc);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_BCC)
    public Builder setBcc(List<String> bcc) {
      this.bcc = OptionalValue.of(bcc);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SUBJECT)
    public Builder setSubject(String subject) {
      this.subject = OptionalValue.of(subject);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TEXT)
    public Builder setText(String text) {
      this.text = OptionalValue.of(text);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_HTML)
    public Builder setHtml(String html) {
      this.html = OptionalValue.of(html);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_AMP_HTML)
    public Builder setAmpHtml(String ampHtml) {
      this.ampHtml = OptionalValue.of(ampHtml);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ATTACHMENT)
    public Builder setAttachment(List<File> attachment) {
      this.attachment = OptionalValue.of(attachment);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_INLINE)
    public Builder setInline(List<File> inline) {
      this.inline = OptionalValue.of(inline);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TEMPLATE)
    public Builder setTemplate(String template) {
      this.template = OptionalValue.of(template);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_T_COLON_VERSION)
    public Builder setTemplateVersion(String templateVersion) {
      this.templateVersion = OptionalValue.of(templateVersion);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_T_COLON_TEXT)
    public Builder setTemplateText(TemplateTextEnum templateText) {
      this.templateText = OptionalValue.of(templateText);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_T_COLON_VARIABLES)
    public Builder setTemplateVariables(String templateVariables) {
      this.templateVariables = OptionalValue.of(templateVariables);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_O_COLON_TAG)
    public Builder setTag(List<String> tag) {
      this.tag = OptionalValue.of(tag);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_O_COLON_DKIM)
    public Builder setEnableDkimSignature(DkimSignatureEnum enableDkimSignature) {
      this.enableDkimSignature = OptionalValue.of(enableDkimSignature);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_O_COLON_SECONDARY_DKIM)
    public Builder setSecondaryDkim(String secondaryDkim) {
      this.secondaryDkim = OptionalValue.of(secondaryDkim);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_O_COLON_SECONDARY_DKIM_PUBLIC)
    public Builder setSecondaryDkimPublic(String secondaryDkimPublic) {
      this.secondaryDkimPublic = OptionalValue.of(secondaryDkimPublic);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_O_COLON_DELIVERYTIME)
    public Builder setDeliveryTime(String deliveryTime) {
      this.deliveryTime = OptionalValue.of(deliveryTime);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_O_COLON_DELIVERYTIME_OPTIMIZE_PERIOD)
    public Builder setDeliveryTimeOptimizePeriod(String deliveryTimeOptimizePeriod) {
      this.deliveryTimeOptimizePeriod = OptionalValue.of(deliveryTimeOptimizePeriod);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_O_COLON_TIME_ZONE_LOCALIZE)
    public Builder setTimezoneLocalize(String timezoneLocalize) {
      this.timezoneLocalize = OptionalValue.of(timezoneLocalize);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_O_COLON_TESTMODE)
    public Builder setTestMode(TestModeEnum testMode) {
      this.testMode = OptionalValue.of(testMode);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_O_COLON_TRACKING)
    public Builder setTracking(TrackingEnum tracking) {
      this.tracking = OptionalValue.of(tracking);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_O_COLON_TRACKING_CLICKS)
    public Builder setTrackingClicks(TrackingClicksEnum trackingClicks) {
      this.trackingClicks = OptionalValue.of(trackingClicks);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_O_COLON_TRACKING_OPENS)
    public Builder setTrackingOpens(TrackingOpensEnum trackingOpens) {
      this.trackingOpens = OptionalValue.of(trackingOpens);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_O_COLON_REQUIRE_TLS)
    public Builder setRequireTls(RequireTlsEnum requireTls) {
      this.requireTls = OptionalValue.of(requireTls);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_O_COLON_SKIP_VERIFICATION)
    public Builder setSkipVerification(SkipVerificationEnum skipVerification) {
      this.skipVerification = OptionalValue.of(skipVerification);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_O_COLON_SENDING_IP)
    public Builder setSendingIp(String sendingIp) {
      this.sendingIp = OptionalValue.of(sendingIp);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_O_COLON_SENDING_IP_POOL)
    public Builder setSendingIpPool(String sendingIpPool) {
      this.sendingIpPool = OptionalValue.of(sendingIpPool);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_O_COLON_TRACKING_PIXEL_LOCATION_TOP)
    public Builder setTrackingPixelLocationTop(String trackingPixelLocationTop) {
      this.trackingPixelLocationTop = OptionalValue.of(trackingPixelLocationTop);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_H_COLON_X_MY_HEADER)
    public Builder sethColonXMyHeader(String hColonXMyHeader) {
      this.hColonXMyHeader = OptionalValue.of(hColonXMyHeader);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_V_COLON_MY_VAR)
    public Builder setvColonMyVar(String vColonMyVar) {
      this.vColonMyVar = OptionalValue.of(vColonMyVar);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_RECIPIENT_VARIABLES)
    public Builder setRecipientVariables(String recipientVariables) {
      this.recipientVariables = OptionalValue.of(recipientVariables);
      return this;
    }

    @JsonAnySetter
    public Builder put(String key, Object value) {
      if (!this.additionalProperties.isPresent()) {
        this.additionalProperties = OptionalValue.of(new HashMap<String, Object>());
      }
      this.additionalProperties.get().put(key, value);
      return this;
    }

    public SendEmailRequest build() {
      return new SendEmailRequestImpl(
          from,
          to,
          cc,
          bcc,
          subject,
          text,
          html,
          ampHtml,
          attachment,
          inline,
          template,
          templateVersion,
          templateText,
          templateVariables,
          tag,
          enableDkimSignature,
          secondaryDkim,
          secondaryDkimPublic,
          deliveryTime,
          deliveryTimeOptimizePeriod,
          timezoneLocalize,
          testMode,
          tracking,
          trackingClicks,
          trackingOpens,
          requireTls,
          skipVerification,
          sendingIp,
          sendingIpPool,
          trackingPixelLocationTop,
          hColonXMyHeader,
          vColonMyVar,
          recipientVariables,
          additionalProperties);
    }
  }
}
