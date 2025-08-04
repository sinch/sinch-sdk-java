package com.sinch.sdk.domains.mailgun.models.v1.emails.request;

import com.sinch.sdk.core.databind.annotation.FormSerialize;
import com.sinch.sdk.core.databind.annotation.Property;
import com.sinch.sdk.core.models.OptionalValue;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

public class OverridePropertiesImpl implements OverrideProperties {
  private static final long serialVersionUID = 1L;

  public static final String PROPERTY_TAG = "o:tag";

  private OptionalValue<List<String>> tag;

  public static final String PROPERTY_DELIVERY_TIME_OPTIMIZE_PERIOD =
      "o:deliverytime-optimize-period";

  private OptionalValue<Integer> deliveryTimeOptimizePeriod;

  public static final String PROPERTY_ENABLE_DKIM_SIGNATURE = "o:dkim";

  private OptionalValue<Boolean> enableDkimSignature;

  public static final String PROPERTY_SECONDARY_DKIM = "o:secondary-dkim";

  private OptionalValue<String> secondaryDkim;

  public static final String PROPERTY_SECONDARY_DKIM_PUBLIC = "o:secondary-dkim-public";

  private OptionalValue<String> secondaryDkimPublic;

  public static final String PROPERTY_DELIVERY_TIME = "o:deliverytime";

  private OptionalValue<Instant> deliveryTime;

  public static final String PROPERTY_TIME_ZONE_LOCALIZE = "o:time-zone-localize";

  private OptionalValue<String> timeZoneLocalize;

  public static final String PROPERTY_TRACKING_CLICKS = "o:tracking-clicks";

  private OptionalValue<TrueFalseHtmlonlyEnum> trackingClicks;

  public static final String PROPERTY_TRACKING = "o:tracking";

  private OptionalValue<TrueFalseHtmlonlyEnum> tracking;

  public static final String PROPERTY_TRACKING_OPENS = "o:tracking-opens";

  private OptionalValue<Boolean> trackingOpens;

  public static final String PROPERTY_TRACKING_PIXEL_LOCATION_TOP = "o:tracking-pixel-location-top";

  private OptionalValue<TrueFalseHtmlonlyEnum> trackingPixelLocationTop;

  public static final String PROPERTY_SENDING_IP = "o:sending-ip";

  private OptionalValue<String> sendingIp;

  public static final String PROPERTY_SENDING_IP_POOL = "o:sending-ip-pool";

  private OptionalValue<String> sendingIpPool;

  public static final String PROPERTY_REQUIRE_TLS = "o:require-tls";

  private OptionalValue<Boolean> requireTls;

  public static final String PROPERTY_SKIP_VERIFICATION = "o:skip-verification";

  private OptionalValue<Boolean> skipVerification;

  public static final String PROPERTY_IS_TEST_MODE = "o:testmode";

  private OptionalValue<Boolean> testMode;

  public static final String PROPERTY_ARCHIVE_TO = "o:archive-to";

  private OptionalValue<String> archiveTo;

  public OverridePropertiesImpl() {}

  protected OverridePropertiesImpl(
      OptionalValue<List<String>> tag,
      OptionalValue<Integer> deliveryTimeOptimizePeriod,
      OptionalValue<Boolean> enableDkimSignature,
      OptionalValue<String> secondaryDkim,
      OptionalValue<String> secondaryDkimPublic,
      OptionalValue<Instant> deliveryTime,
      OptionalValue<String> timeZoneLocalize,
      OptionalValue<TrueFalseHtmlonlyEnum> trackingClicks,
      OptionalValue<TrueFalseHtmlonlyEnum> tracking,
      OptionalValue<Boolean> trackingOpens,
      OptionalValue<TrueFalseHtmlonlyEnum> trackingPixelLocationTop,
      OptionalValue<String> sendingIp,
      OptionalValue<String> sendingIpPool,
      OptionalValue<Boolean> requireTls,
      OptionalValue<Boolean> skipVerification,
      OptionalValue<Boolean> testMode,
      OptionalValue<String> archiveTo) {
    this.tag = tag;
    this.deliveryTimeOptimizePeriod = deliveryTimeOptimizePeriod;
    this.enableDkimSignature = enableDkimSignature;
    this.secondaryDkim = secondaryDkim;
    this.secondaryDkimPublic = secondaryDkimPublic;
    this.deliveryTime = deliveryTime;
    this.timeZoneLocalize = timeZoneLocalize;
    this.trackingClicks = trackingClicks;
    this.tracking = tracking;
    this.trackingOpens = trackingOpens;
    this.trackingPixelLocationTop = trackingPixelLocationTop;
    this.sendingIp = sendingIp;
    this.sendingIpPool = sendingIpPool;
    this.requireTls = requireTls;
    this.skipVerification = skipVerification;
    this.testMode = testMode;
    this.archiveTo = archiveTo;
  }

  public List<String> getTag() {
    return tag.orElse(null);
  }

  @Property(PROPERTY_TAG)
  public OptionalValue<List<String>> tag() {
    return tag;
  }

  public Integer getDeliveryTimeOptimizePeriod() {
    return deliveryTimeOptimizePeriod.orElse(null);
  }

  @Property(PROPERTY_DELIVERY_TIME_OPTIMIZE_PERIOD)
  @FormSerialize(
      using = com.sinch.sdk.domains.mailgun.api.v1.adapters.DeliveryTimeFormSerializer.class)
  public OptionalValue<Integer> deliveryTimeOptimizePeriod() {
    return deliveryTimeOptimizePeriod;
  }

  public Boolean getEnableDkimSignature() {
    return enableDkimSignature.orElse(null);
  }

  @Property(PROPERTY_ENABLE_DKIM_SIGNATURE)
  @FormSerialize(using = com.sinch.sdk.domains.mailgun.api.v1.adapters.BooleanFormSerializer.class)
  public OptionalValue<Boolean> enableDkimSignature() {
    return enableDkimSignature;
  }

  public String getSecondaryDkim() {
    return secondaryDkim.orElse(null);
  }

  @Property(PROPERTY_SECONDARY_DKIM)
  public OptionalValue<String> secondaryDkim() {
    return secondaryDkim;
  }

  public String getSecondaryDkimPublic() {
    return secondaryDkimPublic.orElse(null);
  }

  @Property(PROPERTY_SECONDARY_DKIM_PUBLIC)
  public OptionalValue<String> secondaryDkimPublic() {
    return secondaryDkimPublic;
  }

  public Instant getDeliveryTime() {
    return deliveryTime.orElse(null);
  }

  @Property(PROPERTY_DELIVERY_TIME)
  @FormSerialize(using = com.sinch.sdk.core.utils.databind.RFC822FormSerializer.class)
  public OptionalValue<Instant> deliveryTime() {
    return deliveryTime;
  }

  public String getTimeZoneLocalize() {
    return timeZoneLocalize.orElse(null);
  }

  @Property(PROPERTY_TIME_ZONE_LOCALIZE)
  public OptionalValue<String> timeZoneLocalize() {
    return timeZoneLocalize;
  }

  public TrueFalseHtmlonlyEnum getTrackingClicks() {
    return trackingClicks.orElse(null);
  }

  @Property(PROPERTY_TRACKING_CLICKS)
  public OptionalValue<TrueFalseHtmlonlyEnum> trackingClicks() {
    return trackingClicks;
  }

  public TrueFalseHtmlonlyEnum getTracking() {
    return tracking.orElse(null);
  }

  @Property(PROPERTY_TRACKING)
  public OptionalValue<TrueFalseHtmlonlyEnum> tracking() {
    return tracking;
  }

  public Boolean getTrackingOpens() {
    return trackingOpens.orElse(null);
  }

  @Property(PROPERTY_TRACKING_OPENS)
  @FormSerialize(using = com.sinch.sdk.domains.mailgun.api.v1.adapters.BooleanFormSerializer.class)
  public OptionalValue<Boolean> trackingOpens() {
    return trackingOpens;
  }

  public TrueFalseHtmlonlyEnum getTrackingPixelLocationTop() {
    return trackingPixelLocationTop.orElse(null);
  }

  @Property(PROPERTY_TRACKING_PIXEL_LOCATION_TOP)
  public OptionalValue<TrueFalseHtmlonlyEnum> trackingPixelLocationTop() {
    return trackingPixelLocationTop;
  }

  public String getSendingIp() {
    return sendingIp.orElse(null);
  }

  @Property(PROPERTY_SENDING_IP)
  public OptionalValue<String> sendingIp() {
    return sendingIp;
  }

  public String getSendingIpPool() {
    return sendingIpPool.orElse(null);
  }

  @Property(PROPERTY_SENDING_IP_POOL)
  public OptionalValue<String> sendingIpPool() {
    return sendingIpPool;
  }

  public Boolean getRequireTls() {
    return requireTls.orElse(null);
  }

  @Property(PROPERTY_REQUIRE_TLS)
  @FormSerialize(using = com.sinch.sdk.domains.mailgun.api.v1.adapters.BooleanFormSerializer.class)
  public OptionalValue<Boolean> requireTls() {
    return requireTls;
  }

  public Boolean getSkipVerification() {
    return skipVerification.orElse(null);
  }

  @Property(PROPERTY_SKIP_VERIFICATION)
  @FormSerialize(using = com.sinch.sdk.domains.mailgun.api.v1.adapters.BooleanFormSerializer.class)
  public OptionalValue<Boolean> skipVerification() {
    return skipVerification;
  }

  public Boolean getTestMode() {
    return testMode.orElse(null);
  }

  @Property(PROPERTY_IS_TEST_MODE)
  @FormSerialize(using = com.sinch.sdk.domains.mailgun.api.v1.adapters.BooleanFormSerializer.class)
  public OptionalValue<Boolean> testMode() {
    return testMode;
  }

  public String getArchiveTo() {
    return archiveTo.orElse(null);
  }

  @Property(PROPERTY_ARCHIVE_TO)
  public OptionalValue<String> archiveTo() {
    return archiveTo;
  }

  /** Return true if this overrideProperties object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OverridePropertiesImpl overrideProperties = (OverridePropertiesImpl) o;
    return Objects.equals(this.tag, overrideProperties.tag)
        && Objects.equals(
            this.deliveryTimeOptimizePeriod, overrideProperties.deliveryTimeOptimizePeriod)
        && Objects.equals(this.enableDkimSignature, overrideProperties.enableDkimSignature)
        && Objects.equals(this.secondaryDkim, overrideProperties.secondaryDkim)
        && Objects.equals(this.secondaryDkimPublic, overrideProperties.secondaryDkimPublic)
        && Objects.equals(this.deliveryTime, overrideProperties.deliveryTime)
        && Objects.equals(this.timeZoneLocalize, overrideProperties.timeZoneLocalize)
        && Objects.equals(this.trackingClicks, overrideProperties.trackingClicks)
        && Objects.equals(this.tracking, overrideProperties.tracking)
        && Objects.equals(this.trackingOpens, overrideProperties.trackingOpens)
        && Objects.equals(
            this.trackingPixelLocationTop, overrideProperties.trackingPixelLocationTop)
        && Objects.equals(this.sendingIp, overrideProperties.sendingIp)
        && Objects.equals(this.sendingIpPool, overrideProperties.sendingIpPool)
        && Objects.equals(this.requireTls, overrideProperties.requireTls)
        && Objects.equals(this.skipVerification, overrideProperties.skipVerification)
        && Objects.equals(this.testMode, overrideProperties.testMode)
        && Objects.equals(this.archiveTo, overrideProperties.archiveTo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        tag,
        deliveryTimeOptimizePeriod,
        enableDkimSignature,
        secondaryDkim,
        secondaryDkimPublic,
        deliveryTime,
        timeZoneLocalize,
        trackingClicks,
        tracking,
        trackingOpens,
        trackingPixelLocationTop,
        sendingIp,
        sendingIpPool,
        requireTls,
        skipVerification,
        testMode,
        archiveTo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OverridePropertiesImpl {\n");
    sb.append("    tag: ").append(toIndentedString(tag)).append("\n");
    sb.append("    deliveryTimeOptimizePeriod: ")
        .append(toIndentedString(deliveryTimeOptimizePeriod))
        .append("\n");
    sb.append("    enableDkimSignature: ")
        .append(toIndentedString(enableDkimSignature))
        .append("\n");
    sb.append("    secondaryDkim: ").append(toIndentedString(secondaryDkim)).append("\n");
    sb.append("    secondaryDkimPublic: ")
        .append(toIndentedString(secondaryDkimPublic))
        .append("\n");
    sb.append("    deliveryTime: ").append(toIndentedString(deliveryTime)).append("\n");
    sb.append("    timeZoneLocalize: ").append(toIndentedString(timeZoneLocalize)).append("\n");
    sb.append("    trackingClicks: ").append(toIndentedString(trackingClicks)).append("\n");
    sb.append("    tracking: ").append(toIndentedString(tracking)).append("\n");
    sb.append("    trackingOpens: ").append(toIndentedString(trackingOpens)).append("\n");
    sb.append("    trackingPixelLocationTop: ")
        .append(toIndentedString(trackingPixelLocationTop))
        .append("\n");
    sb.append("    sendingIp: ").append(toIndentedString(sendingIp)).append("\n");
    sb.append("    sendingIpPool: ").append(toIndentedString(sendingIpPool)).append("\n");
    sb.append("    requireTls: ").append(toIndentedString(requireTls)).append("\n");
    sb.append("    skipVerification: ").append(toIndentedString(skipVerification)).append("\n");
    sb.append("    testMode: ").append(toIndentedString(testMode)).append("\n");
    sb.append("    archiveTo: ").append(toIndentedString(archiveTo)).append("\n");
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

  static class Builder implements OverrideProperties.Builder {
    OptionalValue<List<String>> tag = OptionalValue.empty();
    OptionalValue<Integer> deliveryTimeOptimizePeriod = OptionalValue.empty();
    OptionalValue<Boolean> enableDkimSignature = OptionalValue.empty();
    OptionalValue<String> secondaryDkim = OptionalValue.empty();
    OptionalValue<String> secondaryDkimPublic = OptionalValue.empty();
    OptionalValue<Instant> deliveryTime = OptionalValue.empty();
    OptionalValue<String> timeZoneLocalize = OptionalValue.empty();
    OptionalValue<TrueFalseHtmlonlyEnum> trackingClicks = OptionalValue.empty();
    OptionalValue<TrueFalseHtmlonlyEnum> tracking = OptionalValue.empty();
    OptionalValue<Boolean> trackingOpens = OptionalValue.empty();
    OptionalValue<TrueFalseHtmlonlyEnum> trackingPixelLocationTop = OptionalValue.empty();
    OptionalValue<String> sendingIp = OptionalValue.empty();
    OptionalValue<String> sendingIpPool = OptionalValue.empty();
    OptionalValue<Boolean> requireTls = OptionalValue.empty();
    OptionalValue<Boolean> skipVerification = OptionalValue.empty();
    OptionalValue<Boolean> testMode = OptionalValue.empty();
    OptionalValue<String> archiveTo = OptionalValue.empty();

    @Property(value = PROPERTY_TAG)
    public Builder setTag(List<String> tag) {
      this.tag = OptionalValue.of(tag);
      return this;
    }

    @Property(value = PROPERTY_DELIVERY_TIME_OPTIMIZE_PERIOD)
    public Builder setDeliveryTimeOptimizePeriod(Integer deliveryTimeOptimizePeriod) {
      this.deliveryTimeOptimizePeriod = OptionalValue.of(deliveryTimeOptimizePeriod);
      return this;
    }

    @Property(value = PROPERTY_ENABLE_DKIM_SIGNATURE)
    public Builder setEnableDkimSignature(Boolean enableDkimSignature) {
      this.enableDkimSignature = OptionalValue.of(enableDkimSignature);
      return this;
    }

    @Property(value = PROPERTY_SECONDARY_DKIM)
    public Builder setSecondaryDkim(String secondaryDkim) {
      this.secondaryDkim = OptionalValue.of(secondaryDkim);
      return this;
    }

    @Property(value = PROPERTY_SECONDARY_DKIM_PUBLIC)
    public Builder setSecondaryDkimPublic(String secondaryDkimPublic) {
      this.secondaryDkimPublic = OptionalValue.of(secondaryDkimPublic);
      return this;
    }

    @Property(value = PROPERTY_DELIVERY_TIME)
    public Builder setDeliveryTime(Instant deliveryTime) {
      this.deliveryTime = OptionalValue.of(deliveryTime);
      return this;
    }

    @Property(value = PROPERTY_TIME_ZONE_LOCALIZE)
    public Builder setTimeZoneLocalize(String timeZoneLocalize) {
      this.timeZoneLocalize = OptionalValue.of(timeZoneLocalize);
      return this;
    }

    @Property(value = PROPERTY_TRACKING_CLICKS)
    public Builder setTrackingClicks(TrueFalseHtmlonlyEnum trackingClicks) {
      this.trackingClicks = OptionalValue.of(trackingClicks);
      return this;
    }

    @Property(value = PROPERTY_TRACKING)
    public Builder setTracking(TrueFalseHtmlonlyEnum tracking) {
      this.tracking = OptionalValue.of(tracking);
      return this;
    }

    @Property(value = PROPERTY_TRACKING_OPENS)
    public Builder setTrackingOpens(Boolean trackingOpens) {
      this.trackingOpens = OptionalValue.of(trackingOpens);
      return this;
    }

    @Property(value = PROPERTY_TRACKING_PIXEL_LOCATION_TOP)
    public Builder setTrackingPixelLocationTop(TrueFalseHtmlonlyEnum trackingPixelLocationTop) {
      this.trackingPixelLocationTop = OptionalValue.of(trackingPixelLocationTop);
      return this;
    }

    @Property(value = PROPERTY_SENDING_IP)
    public Builder setSendingIp(String sendingIp) {
      this.sendingIp = OptionalValue.of(sendingIp);
      return this;
    }

    @Property(value = PROPERTY_SENDING_IP_POOL)
    public Builder setSendingIpPool(String sendingIpPool) {
      this.sendingIpPool = OptionalValue.of(sendingIpPool);
      return this;
    }

    @Property(value = PROPERTY_REQUIRE_TLS)
    public Builder setRequireTls(Boolean requireTls) {
      this.requireTls = OptionalValue.of(requireTls);
      return this;
    }

    @Property(value = PROPERTY_SKIP_VERIFICATION)
    public Builder setSkipVerification(Boolean skipVerification) {
      this.skipVerification = OptionalValue.of(skipVerification);
      return this;
    }

    @Property(value = PROPERTY_IS_TEST_MODE)
    public Builder setTestMode(Boolean testMode) {
      this.testMode = OptionalValue.of(testMode);
      return this;
    }

    @Property(value = PROPERTY_ARCHIVE_TO)
    public Builder setArchiveTo(String archiveTo) {
      this.archiveTo = OptionalValue.of(archiveTo);
      return this;
    }

    public OverrideProperties build() {
      return new OverridePropertiesImpl(
          tag,
          deliveryTimeOptimizePeriod,
          enableDkimSignature,
          secondaryDkim,
          secondaryDkimPublic,
          deliveryTime,
          timeZoneLocalize,
          trackingClicks,
          tracking,
          trackingOpens,
          trackingPixelLocationTop,
          sendingIp,
          sendingIpPool,
          requireTls,
          skipVerification,
          testMode,
          archiveTo);
    }
  }
}
