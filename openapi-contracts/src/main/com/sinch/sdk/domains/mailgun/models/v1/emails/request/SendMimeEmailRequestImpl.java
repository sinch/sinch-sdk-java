package com.sinch.sdk.domains.mailgun.models.v1.emails.request;

import com.sinch.sdk.core.databind.annotation.FormSerialize;
import com.sinch.sdk.core.databind.annotation.Property;
import com.sinch.sdk.core.models.OptionalValue;
import java.io.File;
import java.time.Instant;
import java.util.HashMap;
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

  public static final String PROPERTY_T_COLON_VERSION = "t:version";

  private OptionalValue<String> templateVersion;

  public static final String PROPERTY_T_COLON_TEXT = "t:text";

  private OptionalValue<TemplateTextEnum> templateText;

  public static final String PROPERTY_T_COLON_VARIABLES = "t:variables";

  private OptionalValue<String> templateVariables;

  public static final String PROPERTY_O_COLON_TAG = "o:tag";

  private OptionalValue<List<String>> tag;

  public static final String PROPERTY_O_COLON_DKIM = "o:dkim";

  private OptionalValue<DkimSignatureEnum> enableDkimSignature;

  public static final String PROPERTY_O_COLON_SECONDARY_DKIM = "o:secondary-dkim";

  private OptionalValue<String> secondaryDkim;

  public static final String PROPERTY_O_COLON_SECONDARY_DKIM_PUBLIC = "o:secondary-dkim-public";

  private OptionalValue<String> secondaryDkimPublic;

  public static final String PROPERTY_O_COLON_DELIVERYTIME = "o:deliverytime";

  private OptionalValue<Instant> deliveryTime;

  public static final String PROPERTY_O_COLON_DELIVERYTIME_OPTIMIZE_PERIOD =
      "o:deliverytime-optimize-period";

  private OptionalValue<Integer> deliveryTimeOptimizePeriod;

  public static final String PROPERTY_O_COLON_TIME_ZONE_LOCALIZE = "o:time-zone-localize";

  private OptionalValue<String> timezoneLocalize;

  public static final String PROPERTY_O_COLON_TESTMODE = "o:testmode";

  private OptionalValue<TestModeEnum> testMode;

  public static final String PROPERTY_O_COLON_TRACKING = "o:tracking";

  private OptionalValue<TrackingEnum> tracking;

  public static final String PROPERTY_O_COLON_TRACKING_CLICKS = "o:tracking-clicks";

  private OptionalValue<TrackingClicksEnum> trackingClicks;

  public static final String PROPERTY_O_COLON_TRACKING_OPENS = "o:tracking-opens";

  private OptionalValue<TrackingOpensEnum> trackingOpens;

  public static final String PROPERTY_O_COLON_REQUIRE_TLS = "o:require-tls";

  private OptionalValue<RequireTlsEnum> requireTls;

  public static final String PROPERTY_O_COLON_SKIP_VERIFICATION = "o:skip-verification";

  private OptionalValue<SkipVerificationEnum> skipVerification;

  public static final String PROPERTY_O_COLON_SENDING_IP = "o:sending-ip";

  private OptionalValue<String> sendingIp;

  public static final String PROPERTY_O_COLON_SENDING_IP_POOL = "o:sending-ip-pool";

  private OptionalValue<String> sendingIpPool;

  public static final String PROPERTY_O_COLON_TRACKING_PIXEL_LOCATION_TOP =
      "o:tracking-pixel-location-top";

  private OptionalValue<String> trackingPixelLocationTop;

  public static final String PROPERTY_RECIPIENT_VARIABLES = "recipient-variables";

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
      OptionalValue<Instant> deliveryTime,
      OptionalValue<Integer> deliveryTimeOptimizePeriod,
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
    this.testMode = testMode;
    this.tracking = tracking;
    this.trackingClicks = trackingClicks;
    this.trackingOpens = trackingOpens;
    this.requireTls = requireTls;
    this.skipVerification = skipVerification;
    this.sendingIp = sendingIp;
    this.sendingIpPool = sendingIpPool;
    this.trackingPixelLocationTop = trackingPixelLocationTop;
    this.recipientVariables = recipientVariables;
    this.additionalProperties = additionalProperties;
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

  public String getTemplateVersion() {
    return templateVersion.orElse(null);
  }

  @Property(PROPERTY_T_COLON_VERSION)
  public OptionalValue<String> templateVersion() {
    return templateVersion;
  }

  public TemplateTextEnum getTemplateText() {
    return templateText.orElse(null);
  }

  @Property(PROPERTY_T_COLON_TEXT)
  public OptionalValue<TemplateTextEnum> templateText() {
    return templateText;
  }

  public String getTemplateVariables() {
    return templateVariables.orElse(null);
  }

  @Property(PROPERTY_T_COLON_VARIABLES)
  public OptionalValue<String> templateVariables() {
    return templateVariables;
  }

  public List<String> getTag() {
    return tag.orElse(null);
  }

  @Property(PROPERTY_O_COLON_TAG)
  public OptionalValue<List<String>> tag() {
    return tag;
  }

  public DkimSignatureEnum getEnableDkimSignature() {
    return enableDkimSignature.orElse(null);
  }

  @Property(PROPERTY_O_COLON_DKIM)
  public OptionalValue<DkimSignatureEnum> enableDkimSignature() {
    return enableDkimSignature;
  }

  public String getSecondaryDkim() {
    return secondaryDkim.orElse(null);
  }

  @Property(PROPERTY_O_COLON_SECONDARY_DKIM)
  public OptionalValue<String> secondaryDkim() {
    return secondaryDkim;
  }

  public String getSecondaryDkimPublic() {
    return secondaryDkimPublic.orElse(null);
  }

  @Property(PROPERTY_O_COLON_SECONDARY_DKIM_PUBLIC)
  public OptionalValue<String> secondaryDkimPublic() {
    return secondaryDkimPublic;
  }

  public Instant getDeliveryTime() {
    return deliveryTime.orElse(null);
  }

  @Property(PROPERTY_O_COLON_DELIVERYTIME)
  @FormSerialize(using = com.sinch.sdk.core.utils.databind.RFC822FormSerializer.class)
  public OptionalValue<Instant> deliveryTime() {
    return deliveryTime;
  }

  public Integer getDeliveryTimeOptimizePeriod() {
    return deliveryTimeOptimizePeriod.orElse(null);
  }

  @Property(PROPERTY_O_COLON_DELIVERYTIME_OPTIMIZE_PERIOD)
  @FormSerialize(
      using = com.sinch.sdk.domains.mailgun.api.v1.adapters.DeliveryTimeFormSerializer.class)
  public OptionalValue<Integer> deliveryTimeOptimizePeriod() {
    return deliveryTimeOptimizePeriod;
  }

  public String getTimezoneLocalize() {
    return timezoneLocalize.orElse(null);
  }

  @Property(PROPERTY_O_COLON_TIME_ZONE_LOCALIZE)
  public OptionalValue<String> timezoneLocalize() {
    return timezoneLocalize;
  }

  public TestModeEnum getTestMode() {
    return testMode.orElse(null);
  }

  @Property(PROPERTY_O_COLON_TESTMODE)
  public OptionalValue<TestModeEnum> testMode() {
    return testMode;
  }

  public TrackingEnum getTracking() {
    return tracking.orElse(null);
  }

  @Property(PROPERTY_O_COLON_TRACKING)
  public OptionalValue<TrackingEnum> tracking() {
    return tracking;
  }

  public TrackingClicksEnum getTrackingClicks() {
    return trackingClicks.orElse(null);
  }

  @Property(PROPERTY_O_COLON_TRACKING_CLICKS)
  public OptionalValue<TrackingClicksEnum> trackingClicks() {
    return trackingClicks;
  }

  public TrackingOpensEnum getTrackingOpens() {
    return trackingOpens.orElse(null);
  }

  @Property(PROPERTY_O_COLON_TRACKING_OPENS)
  public OptionalValue<TrackingOpensEnum> trackingOpens() {
    return trackingOpens;
  }

  public RequireTlsEnum getRequireTls() {
    return requireTls.orElse(null);
  }

  @Property(PROPERTY_O_COLON_REQUIRE_TLS)
  public OptionalValue<RequireTlsEnum> requireTls() {
    return requireTls;
  }

  public SkipVerificationEnum getSkipVerification() {
    return skipVerification.orElse(null);
  }

  @Property(PROPERTY_O_COLON_SKIP_VERIFICATION)
  public OptionalValue<SkipVerificationEnum> skipVerification() {
    return skipVerification;
  }

  public String getSendingIp() {
    return sendingIp.orElse(null);
  }

  @Property(PROPERTY_O_COLON_SENDING_IP)
  public OptionalValue<String> sendingIp() {
    return sendingIp;
  }

  public String getSendingIpPool() {
    return sendingIpPool.orElse(null);
  }

  @Property(PROPERTY_O_COLON_SENDING_IP_POOL)
  public OptionalValue<String> sendingIpPool() {
    return sendingIpPool;
  }

  public String getTrackingPixelLocationTop() {
    return trackingPixelLocationTop.orElse(null);
  }

  @Property(PROPERTY_O_COLON_TRACKING_PIXEL_LOCATION_TOP)
  public OptionalValue<String> trackingPixelLocationTop() {
    return trackingPixelLocationTop;
  }

  public String getRecipientVariables() {
    return recipientVariables.orElse(null);
  }

  @Property(PROPERTY_RECIPIENT_VARIABLES)
  public OptionalValue<String> recipientVariables() {
    return recipientVariables;
  }

  public Object get(String key) {

    if (null == this.additionalProperties || !additionalProperties.isPresent()) {
      return null;
    }
    return this.additionalProperties.get().get(key);
  }

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
            this.testMode, poSTV3DomainNameMessagesMimeMultipartFormDataRequestBody.testMode)
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
        testMode,
        tracking,
        trackingClicks,
        trackingOpens,
        requireTls,
        skipVerification,
        sendingIp,
        sendingIpPool,
        trackingPixelLocationTop,
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
    OptionalValue<Instant> deliveryTime = OptionalValue.empty();
    OptionalValue<Integer> deliveryTimeOptimizePeriod = OptionalValue.empty();
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
    OptionalValue<String> recipientVariables = OptionalValue.empty();
    OptionalValue<Map<String, Object>> additionalProperties = OptionalValue.empty();

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

    @Property(value = PROPERTY_T_COLON_VERSION)
    public Builder setTemplateVersion(String templateVersion) {
      this.templateVersion = OptionalValue.of(templateVersion);
      return this;
    }

    @Property(value = PROPERTY_T_COLON_TEXT)
    public Builder setTemplateText(TemplateTextEnum templateText) {
      this.templateText = OptionalValue.of(templateText);
      return this;
    }

    @Property(value = PROPERTY_T_COLON_VARIABLES)
    public Builder setTemplateVariables(String templateVariables) {
      this.templateVariables = OptionalValue.of(templateVariables);
      return this;
    }

    @Property(value = PROPERTY_O_COLON_TAG)
    public Builder setTag(List<String> tag) {
      this.tag = OptionalValue.of(tag);
      return this;
    }

    @Property(value = PROPERTY_O_COLON_DKIM)
    public Builder setEnableDkimSignature(DkimSignatureEnum enableDkimSignature) {
      this.enableDkimSignature = OptionalValue.of(enableDkimSignature);
      return this;
    }

    @Property(value = PROPERTY_O_COLON_SECONDARY_DKIM)
    public Builder setSecondaryDkim(String secondaryDkim) {
      this.secondaryDkim = OptionalValue.of(secondaryDkim);
      return this;
    }

    @Property(value = PROPERTY_O_COLON_SECONDARY_DKIM_PUBLIC)
    public Builder setSecondaryDkimPublic(String secondaryDkimPublic) {
      this.secondaryDkimPublic = OptionalValue.of(secondaryDkimPublic);
      return this;
    }

    @Property(value = PROPERTY_O_COLON_DELIVERYTIME)
    public Builder setDeliveryTime(Instant deliveryTime) {
      this.deliveryTime = OptionalValue.of(deliveryTime);
      return this;
    }

    @Property(value = PROPERTY_O_COLON_DELIVERYTIME_OPTIMIZE_PERIOD)
    public Builder setDeliveryTimeOptimizePeriod(Integer deliveryTimeOptimizePeriod) {
      this.deliveryTimeOptimizePeriod = OptionalValue.of(deliveryTimeOptimizePeriod);
      return this;
    }

    @Property(value = PROPERTY_O_COLON_TIME_ZONE_LOCALIZE)
    public Builder setTimezoneLocalize(String timezoneLocalize) {
      this.timezoneLocalize = OptionalValue.of(timezoneLocalize);
      return this;
    }

    @Property(value = PROPERTY_O_COLON_TESTMODE)
    public Builder setTestMode(TestModeEnum testMode) {
      this.testMode = OptionalValue.of(testMode);
      return this;
    }

    @Property(value = PROPERTY_O_COLON_TRACKING)
    public Builder setTracking(TrackingEnum tracking) {
      this.tracking = OptionalValue.of(tracking);
      return this;
    }

    @Property(value = PROPERTY_O_COLON_TRACKING_CLICKS)
    public Builder setTrackingClicks(TrackingClicksEnum trackingClicks) {
      this.trackingClicks = OptionalValue.of(trackingClicks);
      return this;
    }

    @Property(value = PROPERTY_O_COLON_TRACKING_OPENS)
    public Builder setTrackingOpens(TrackingOpensEnum trackingOpens) {
      this.trackingOpens = OptionalValue.of(trackingOpens);
      return this;
    }

    @Property(value = PROPERTY_O_COLON_REQUIRE_TLS)
    public Builder setRequireTls(RequireTlsEnum requireTls) {
      this.requireTls = OptionalValue.of(requireTls);
      return this;
    }

    @Property(value = PROPERTY_O_COLON_SKIP_VERIFICATION)
    public Builder setSkipVerification(SkipVerificationEnum skipVerification) {
      this.skipVerification = OptionalValue.of(skipVerification);
      return this;
    }

    @Property(value = PROPERTY_O_COLON_SENDING_IP)
    public Builder setSendingIp(String sendingIp) {
      this.sendingIp = OptionalValue.of(sendingIp);
      return this;
    }

    @Property(value = PROPERTY_O_COLON_SENDING_IP_POOL)
    public Builder setSendingIpPool(String sendingIpPool) {
      this.sendingIpPool = OptionalValue.of(sendingIpPool);
      return this;
    }

    @Property(value = PROPERTY_O_COLON_TRACKING_PIXEL_LOCATION_TOP)
    public Builder setTrackingPixelLocationTop(String trackingPixelLocationTop) {
      this.trackingPixelLocationTop = OptionalValue.of(trackingPixelLocationTop);
      return this;
    }

    @Property(value = PROPERTY_RECIPIENT_VARIABLES)
    public Builder setRecipientVariables(String recipientVariables) {
      this.recipientVariables = OptionalValue.of(recipientVariables);
      return this;
    }

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
          testMode,
          tracking,
          trackingClicks,
          trackingOpens,
          requireTls,
          skipVerification,
          sendingIp,
          sendingIpPool,
          trackingPixelLocationTop,
          recipientVariables,
          additionalProperties);
    }
  }
}
