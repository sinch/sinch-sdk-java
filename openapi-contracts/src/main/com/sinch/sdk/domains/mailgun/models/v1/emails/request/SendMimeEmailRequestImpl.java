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
  SendMimeEmailRequestImpl.JSON_PROPERTY_TO,
  SendMimeEmailRequestImpl.JSON_PROPERTY_MESSAGE,
  SendMimeEmailRequestImpl.JSON_PROPERTY_TEMPLATE,
  SendMimeEmailRequestImpl.JSON_PROPERTY_T_COLON_VERSION,
  SendMimeEmailRequestImpl.JSON_PROPERTY_T_COLON_TEXT,
  SendMimeEmailRequestImpl.JSON_PROPERTY_T_COLON_VARIABLES,
  SendMimeEmailRequestImpl.JSON_PROPERTY_O_COLON_TAG,
  SendMimeEmailRequestImpl.JSON_PROPERTY_O_COLON_DKIM,
  SendMimeEmailRequestImpl.JSON_PROPERTY_O_COLON_SECONDARY_DKIM,
  SendMimeEmailRequestImpl.JSON_PROPERTY_O_COLON_SECONDARY_DKIM_PUBLIC,
  SendMimeEmailRequestImpl.JSON_PROPERTY_O_COLON_DELIVERYTIME,
  SendMimeEmailRequestImpl.JSON_PROPERTY_O_COLON_DELIVERYTIME_OPTIMIZE_PERIOD,
  SendMimeEmailRequestImpl.JSON_PROPERTY_O_COLON_TIME_ZONE_LOCALIZE,
  SendMimeEmailRequestImpl.JSON_PROPERTY_O_COLON_TESTMODE,
  SendMimeEmailRequestImpl.JSON_PROPERTY_O_COLON_TRACKING,
  SendMimeEmailRequestImpl.JSON_PROPERTY_O_COLON_TRACKING_CLICKS,
  SendMimeEmailRequestImpl.JSON_PROPERTY_O_COLON_TRACKING_OPENS,
  SendMimeEmailRequestImpl.JSON_PROPERTY_O_COLON_REQUIRE_TLS,
  SendMimeEmailRequestImpl.JSON_PROPERTY_O_COLON_SKIP_VERIFICATION,
  SendMimeEmailRequestImpl.JSON_PROPERTY_O_COLON_SENDING_IP,
  SendMimeEmailRequestImpl.JSON_PROPERTY_O_COLON_SENDING_IP_POOL,
  SendMimeEmailRequestImpl.JSON_PROPERTY_O_COLON_TRACKING_PIXEL_LOCATION_TOP,
  SendMimeEmailRequestImpl.JSON_PROPERTY_H_COLON_X_MY_HEADER,
  SendMimeEmailRequestImpl.JSON_PROPERTY_V_COLON_MY_VAR,
  SendMimeEmailRequestImpl.JSON_PROPERTY_RECIPIENT_VARIABLES
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class SendMimeEmailRequestImpl implements SendMimeEmailRequest {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TO = "to";

  private OptionalValue<List<String>> to;

  public static final String JSON_PROPERTY_MESSAGE = "message";

  private OptionalValue<File> message;

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

  private OptionalValue<TestModeEnum> isTestMode;

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

  public SendMimeEmailRequestImpl() {}

  protected SendMimeEmailRequestImpl(
      OptionalValue<List<String>> to,
      OptionalValue<File> message,
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
      OptionalValue<TestModeEnum> isTestMode,
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
    this.to = to;
    this.message = message;
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
    this.isTestMode = isTestMode;
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
  public List<String> getTo() {
    return to.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TO)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<List<String>> to() {
    return to;
  }

  @JsonIgnore
  public File getMessage() {
    return message.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<File> message() {
    return message;
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
  public TestModeEnum getIsTestMode() {
    return isTestMode.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_O_COLON_TESTMODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<TestModeEnum> isTestMode() {
    return isTestMode;
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
   * Return true if this POST-v3-domain_name-messages-mime-multipart-form-data-RequestBody object is
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
    SendMimeEmailRequestImpl poSTV3DomainNameMessagesMimeMultipartFormDataRequestBody =
        (SendMimeEmailRequestImpl) o;
    return Objects.equals(this.to, poSTV3DomainNameMessagesMimeMultipartFormDataRequestBody.to)
        && Objects.equals(
            this.message, poSTV3DomainNameMessagesMimeMultipartFormDataRequestBody.message)
        && Objects.equals(
            this.template, poSTV3DomainNameMessagesMimeMultipartFormDataRequestBody.template)
        && Objects.equals(
            this.templateVersion,
            poSTV3DomainNameMessagesMimeMultipartFormDataRequestBody.templateVersion)
        && Objects.equals(
            this.templateText,
            poSTV3DomainNameMessagesMimeMultipartFormDataRequestBody.templateText)
        && Objects.equals(
            this.templateVariables,
            poSTV3DomainNameMessagesMimeMultipartFormDataRequestBody.templateVariables)
        && Objects.equals(this.tag, poSTV3DomainNameMessagesMimeMultipartFormDataRequestBody.tag)
        && Objects.equals(
            this.enableDkimSignature,
            poSTV3DomainNameMessagesMimeMultipartFormDataRequestBody.enableDkimSignature)
        && Objects.equals(
            this.secondaryDkim,
            poSTV3DomainNameMessagesMimeMultipartFormDataRequestBody.secondaryDkim)
        && Objects.equals(
            this.secondaryDkimPublic,
            poSTV3DomainNameMessagesMimeMultipartFormDataRequestBody.secondaryDkimPublic)
        && Objects.equals(
            this.deliveryTime,
            poSTV3DomainNameMessagesMimeMultipartFormDataRequestBody.deliveryTime)
        && Objects.equals(
            this.deliveryTimeOptimizePeriod,
            poSTV3DomainNameMessagesMimeMultipartFormDataRequestBody.deliveryTimeOptimizePeriod)
        && Objects.equals(
            this.timezoneLocalize,
            poSTV3DomainNameMessagesMimeMultipartFormDataRequestBody.timezoneLocalize)
        && Objects.equals(
            this.isTestMode, poSTV3DomainNameMessagesMimeMultipartFormDataRequestBody.isTestMode)
        && Objects.equals(
            this.tracking, poSTV3DomainNameMessagesMimeMultipartFormDataRequestBody.tracking)
        && Objects.equals(
            this.trackingClicks,
            poSTV3DomainNameMessagesMimeMultipartFormDataRequestBody.trackingClicks)
        && Objects.equals(
            this.trackingOpens,
            poSTV3DomainNameMessagesMimeMultipartFormDataRequestBody.trackingOpens)
        && Objects.equals(
            this.requireTls, poSTV3DomainNameMessagesMimeMultipartFormDataRequestBody.requireTls)
        && Objects.equals(
            this.skipVerification,
            poSTV3DomainNameMessagesMimeMultipartFormDataRequestBody.skipVerification)
        && Objects.equals(
            this.sendingIp, poSTV3DomainNameMessagesMimeMultipartFormDataRequestBody.sendingIp)
        && Objects.equals(
            this.sendingIpPool,
            poSTV3DomainNameMessagesMimeMultipartFormDataRequestBody.sendingIpPool)
        && Objects.equals(
            this.trackingPixelLocationTop,
            poSTV3DomainNameMessagesMimeMultipartFormDataRequestBody.trackingPixelLocationTop)
        && Objects.equals(
            this.hColonXMyHeader,
            poSTV3DomainNameMessagesMimeMultipartFormDataRequestBody.hColonXMyHeader)
        && Objects.equals(
            this.vColonMyVar, poSTV3DomainNameMessagesMimeMultipartFormDataRequestBody.vColonMyVar)
        && Objects.equals(
            this.recipientVariables,
            poSTV3DomainNameMessagesMimeMultipartFormDataRequestBody.recipientVariables)
        && Objects.equals(
            this.additionalProperties,
            poSTV3DomainNameMessagesMimeMultipartFormDataRequestBody.additionalProperties)
        && super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        to,
        message,
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
        isTestMode,
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
    sb.append("class SendMimeEmailRequestImpl {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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
    sb.append("    isTestMode: ").append(toIndentedString(isTestMode)).append("\n");
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
  static class Builder implements SendMimeEmailRequest.Builder {
    OptionalValue<List<String>> to = OptionalValue.empty();
    OptionalValue<File> message = OptionalValue.empty();
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
    OptionalValue<TestModeEnum> isTestMode = OptionalValue.empty();
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

    @JsonProperty(JSON_PROPERTY_TO)
    public Builder setTo(List<String> to) {
      this.to = OptionalValue.of(to);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MESSAGE)
    public Builder setMessage(File message) {
      this.message = OptionalValue.of(message);
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
    public Builder setIsTestMode(TestModeEnum isTestMode) {
      this.isTestMode = OptionalValue.of(isTestMode);
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

    public SendMimeEmailRequest build() {
      return new SendMimeEmailRequestImpl(
          to,
          message,
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
          isTestMode,
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
