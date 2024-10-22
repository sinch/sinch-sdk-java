/*
 * Mailgun API
 *
 * OpenAPI document version: 0.0.0
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.mailgun.models.v1.emails.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/** SendEmailRequest */
@JsonDeserialize(builder = SendEmailRequestImpl.Builder.class)
public interface SendEmailRequest {

  /**
   * Email address for <code>From</code> header
   *
   * @return from
   */
  String getFrom();

  /**
   * Email address of the recipient(s). Example: <code>\&quot;Bob &lt;bob@host.com&gt;\&quot;</code>
   * . You can use commas to separate multiple recipients
   *
   * @return to
   */
  List<String> getTo();

  /**
   * Same as <code>To</code> but for <code>Cc</code>
   *
   * @return cc
   */
  List<String> getCc();

  /**
   * Same as <code>To</code> but for <code>Bcc</code>
   *
   * @return bcc
   */
  List<String> getBcc();

  /**
   * Message subject
   *
   * @return subject
   */
  String getSubject();

  /**
   * Body of the message (text version)
   *
   * @return text
   */
  String getText();

  /**
   * Body of the message (HTML version)
   *
   * @return html
   */
  String getHtml();

  /**
   * AMP part of the message. Please follow Google guidelines to compose and send AMP emails
   *
   * @return ampHtml
   */
  String getAmpHtml();

  /**
   * File attachment. You can post multiple <code>attachment</code> values.
   * <strong>Important:</strong> You must use <code>multipart/form-data</code> encoding for sending
   * attachments
   *
   * @return attachment
   */
  List<File> getAttachment();

  /**
   * Attachment with <code>inline</code> disposition. Can be used to send inline images (see
   * example). You can post multiple <code>inline</code> values
   *
   * @return inline
   */
  List<File> getInline();

  /**
   * Name of a template stored via template API to use to render the email body. See
   * <strong>Templates</strong> for more information
   *
   * @return template
   */
  String getTemplate();

  /**
   * Render a specific version of the given template instead of the latest version. <code>o:template
   * </code> option must also be provided.
   *
   * @return templateVersion
   */
  String getTemplateVersion();

  /** Render template in case of template sending */
  public class TemplateTextEnum extends EnumDynamic<String, TemplateTextEnum> {
    public static final TemplateTextEnum YES = new TemplateTextEnum("yes");

    private static final EnumSupportDynamic<String, TemplateTextEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(TemplateTextEnum.class, TemplateTextEnum::new, Arrays.asList(YES));

    private TemplateTextEnum(String value) {
      super(value);
    }

    public static Stream<TemplateTextEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static TemplateTextEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(TemplateTextEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  /**
   * Render template in case of template sending
   *
   * @return templateText
   */
  TemplateTextEnum getTemplateText();

  /**
   * A valid JSON-encoded dictionary used as the input for template variable expansion. See <a
   * href="https://documentation.mailgun.com/docs/mailgun/user-manual/sending-messages/#templates">Templates</a>
   * for more information
   *
   * @return templateVariables
   */
  String getTemplateVariables();

  /**
   * Tag string. See <a
   * href="https://documentation.mailgun.com/docs/mailgun/user-manual/tracking-messages/#tagging">Tagging</a>
   * for more information
   *
   * @return tag
   */
  List<String> getTag();

  /** Enables/disables DKIM signatures on a per-message basis */
  public class DkimSignatureEnum extends EnumDynamic<String, DkimSignatureEnum> {
    public static final DkimSignatureEnum YES = new DkimSignatureEnum("yes");
    public static final DkimSignatureEnum NO = new DkimSignatureEnum("no");
    public static final DkimSignatureEnum TRUE = new DkimSignatureEnum("true");
    public static final DkimSignatureEnum FALSE = new DkimSignatureEnum("false");

    private static final EnumSupportDynamic<String, DkimSignatureEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(
            DkimSignatureEnum.class, DkimSignatureEnum::new, Arrays.asList(YES, NO, TRUE, FALSE));

    private DkimSignatureEnum(String value) {
      super(value);
    }

    public static Stream<DkimSignatureEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static DkimSignatureEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(DkimSignatureEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  /**
   * Enables/disables DKIM signatures on a per-message basis
   *
   * @return enableDkimSignature
   */
  DkimSignatureEnum getEnableDkimSignature();

  /**
   * Specify a second domain key to sign the email with. The value is formatted as <code>
   * signing_domain/selector</code>, e.g. <code>example.com/s1</code>. This tells Mailgun to sign
   * the message with the signing domain <code>example.com</code> using the selector <code>s1</code>
   * . Note: the domain key specified must have been previously created and activated.
   *
   * @return secondaryDkim
   */
  String getSecondaryDkim();

  /**
   * Specify an alias of the domain key specified in <code>o:secondary-dkim</code>. Also formatted
   * as <code>public_signing_domain/selector</code>. <code>o:secondary-dkim</code> option must also
   * be provided. Mailgun will sign the message with the provided key of the secondary DKIM, but use
   * the public secondary DKIM name and selector. Note: We will perform a DNS check prior to signing
   * the message to ensure the public keys matches the secondary DKIM.
   *
   * @return secondaryDkimPublic
   */
  String getSecondaryDkimPublic();

  /**
   * Specifies the scheduled delivery time in RFC-2822 format
   * (https://documentation.mailgun.com/docs/mailgun/user-manual/get-started/#date-format).
   * Depending on your plan, you can schedule messages up to 3 or 7 days in advance. If your domain
   * has a custom message_ttl (time-to-live) setting, this value determines the maximum scheduling
   * duration.
   *
   * @return deliveryTime
   */
  String getDeliveryTime();

  /**
   * Toggles Send Time Optimization (STO) on a per-message basis. String should be set to the number
   * of hours in <code>[0-9]+h</code> format, with the minimum being <code>24h</code> and the
   * maximum being <code>72h</code>. This value defines the time window in which Mailgun will run
   * the optimization algorithm based on prior engagement data of a given recipient. See
   * <strong>Sending a Message with STO</strong> for details. <em>Please note that STO is only
   * available on certain plans. See www.mailgun.com/pricing for more info</em>
   *
   * @return deliveryTimeOptimizePeriod
   */
  String getDeliveryTimeOptimizePeriod();

  /**
   * Toggles Timezone Optimization (TZO) on a per message basis. String should be set to preferred
   * delivery time in <code>HH:mm</code> or <code>hh:mmaa</code> format, where <code>HH:mm</code> is
   * used for 24 hour format without AM/PM and hh:mmaa is used for 12 hour format with AM/PM. See
   * <strong>Sending a Message with TZO</strong> for details. <em>Please note that TZO is only
   * available on certain plans. See www.mailgun.com/pricing for more info</em>
   *
   * @return timezoneLocalize
   */
  String getTimezoneLocalize();

  /**
   * Enables sending in test mode. See <a
   * href="https://documentation.mailgun.com/docs/mailgun/user-manual/sending-messages/#sending-in-test-mode">Sending
   * in Test Mode</a>
   */
  public class TestModeEnum extends EnumDynamic<String, TestModeEnum> {
    public static final TestModeEnum YES = new TestModeEnum("yes");

    private static final EnumSupportDynamic<String, TestModeEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(TestModeEnum.class, TestModeEnum::new, Arrays.asList(YES));

    private TestModeEnum(String value) {
      super(value);
    }

    public static Stream<TestModeEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static TestModeEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(TestModeEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  /**
   * Enables sending in test mode. See <a
   * href="https://documentation.mailgun.com/docs/mailgun/user-manual/sending-messages/#sending-in-test-mode">Sending
   * in Test Mode</a>
   *
   * @return testMode
   */
  TestModeEnum getTestMode();

  /**
   * Toggles both click and open tracking on a per-message basis, see <a
   * href="https://documentation.mailgun.com/docs/mailgun/user-manual/tracking-messages">Tracking
   * Messages</a> for details.
   */
  public class TrackingEnum extends EnumDynamic<String, TrackingEnum> {
    public static final TrackingEnum YES = new TrackingEnum("yes");
    public static final TrackingEnum NO = new TrackingEnum("no");
    public static final TrackingEnum TRUE = new TrackingEnum("true");
    public static final TrackingEnum FALSE = new TrackingEnum("false");
    public static final TrackingEnum HTMLONLY = new TrackingEnum("htmlonly");

    private static final EnumSupportDynamic<String, TrackingEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(
            TrackingEnum.class, TrackingEnum::new, Arrays.asList(YES, NO, TRUE, FALSE, HTMLONLY));

    private TrackingEnum(String value) {
      super(value);
    }

    public static Stream<TrackingEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static TrackingEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(TrackingEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  /**
   * Toggles both click and open tracking on a per-message basis, see <a
   * href="https://documentation.mailgun.com/docs/mailgun/user-manual/tracking-messages">Tracking
   * Messages</a> for details.
   *
   * @return tracking
   */
  TrackingEnum getTracking();

  /**
   * Toggles click tracking on a per-message basis, see <a
   * href="https://documentation.mailgun.com/docs/mailgun/user-manual/tracking-messages/#tracking-clicks">Tracking
   * Clicks</a>. Has higher priority than domain-level setting.
   */
  public class TrackingClicksEnum extends EnumDynamic<String, TrackingClicksEnum> {
    public static final TrackingClicksEnum YES = new TrackingClicksEnum("yes");
    public static final TrackingClicksEnum NO = new TrackingClicksEnum("no");
    public static final TrackingClicksEnum TRUE = new TrackingClicksEnum("true");
    public static final TrackingClicksEnum FALSE = new TrackingClicksEnum("false");
    public static final TrackingClicksEnum HTMLONLY = new TrackingClicksEnum("htmlonly");

    private static final EnumSupportDynamic<String, TrackingClicksEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(
            TrackingClicksEnum.class,
            TrackingClicksEnum::new,
            Arrays.asList(YES, NO, TRUE, FALSE, HTMLONLY));

    private TrackingClicksEnum(String value) {
      super(value);
    }

    public static Stream<TrackingClicksEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static TrackingClicksEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(TrackingClicksEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  /**
   * Toggles click tracking on a per-message basis, see <a
   * href="https://documentation.mailgun.com/docs/mailgun/user-manual/tracking-messages/#tracking-clicks">Tracking
   * Clicks</a>. Has higher priority than domain-level setting.
   *
   * @return trackingClicks
   */
  TrackingClicksEnum getTrackingClicks();

  /**
   * Toggles opens tracking on a per-message basis, see <a
   * href="https://documentation.mailgun.com/docs/mailgun/user-manual/tracking-messages/#tracking-opens">Tracking
   * Opens</a>. Has higher priority than domain-level setting.
   */
  public class TrackingOpensEnum extends EnumDynamic<String, TrackingOpensEnum> {
    public static final TrackingOpensEnum YES = new TrackingOpensEnum("yes");
    public static final TrackingOpensEnum NO = new TrackingOpensEnum("no");
    public static final TrackingOpensEnum TRUE = new TrackingOpensEnum("true");
    public static final TrackingOpensEnum FALSE = new TrackingOpensEnum("false");

    private static final EnumSupportDynamic<String, TrackingOpensEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(
            TrackingOpensEnum.class, TrackingOpensEnum::new, Arrays.asList(YES, NO, TRUE, FALSE));

    private TrackingOpensEnum(String value) {
      super(value);
    }

    public static Stream<TrackingOpensEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static TrackingOpensEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(TrackingOpensEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  /**
   * Toggles opens tracking on a per-message basis, see <a
   * href="https://documentation.mailgun.com/docs/mailgun/user-manual/tracking-messages/#tracking-opens">Tracking
   * Opens</a>. Has higher priority than domain-level setting.
   *
   * @return trackingOpens
   */
  TrackingOpensEnum getTrackingOpens();

  /**
   * Requires the message only be sent over a TLS connection, see <a
   * href="https://documentation.mailgun.com/docs/mailgun/user-manual/tls-sending/">TLS Sending
   * Connection Settings</a>. If a TLS connection can not be established, Mailgun will not deliver
   * the message. If set to <code>false</code> or <code>no</code>, Mailgun will still try and
   * upgrade the connection, but if Mailgun cannot, the message will be delivered over a plaintext
   * SMTP connection. The default is <code>false</code>
   */
  public class RequireTlsEnum extends EnumDynamic<String, RequireTlsEnum> {
    public static final RequireTlsEnum YES = new RequireTlsEnum("yes");
    public static final RequireTlsEnum NO = new RequireTlsEnum("no");
    public static final RequireTlsEnum TRUE = new RequireTlsEnum("true");
    public static final RequireTlsEnum FALSE = new RequireTlsEnum("false");

    private static final EnumSupportDynamic<String, RequireTlsEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(
            RequireTlsEnum.class, RequireTlsEnum::new, Arrays.asList(YES, NO, TRUE, FALSE));

    private RequireTlsEnum(String value) {
      super(value);
    }

    public static Stream<RequireTlsEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static RequireTlsEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(RequireTlsEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  /**
   * Requires the message only be sent over a TLS connection, see <a
   * href="https://documentation.mailgun.com/docs/mailgun/user-manual/tls-sending/">TLS Sending
   * Connection Settings</a>. If a TLS connection can not be established, Mailgun will not deliver
   * the message. If set to <code>false</code> or <code>no</code>, Mailgun will still try and
   * upgrade the connection, but if Mailgun cannot, the message will be delivered over a plaintext
   * SMTP connection. The default is <code>false</code>
   *
   * @return requireTls
   */
  RequireTlsEnum getRequireTls();

  /**
   * If <code>skip</code> activated, the certificate and hostname of the resolved MX Host will not
   * be verified when trying to establish a TLS connection. If not, Mailgun will verify the
   * certificate and hostname. If either one can not be verified, a TLS connection will not be
   * established. The default is <code>false</code>
   */
  public class SkipVerificationEnum extends EnumDynamic<String, SkipVerificationEnum> {
    public static final SkipVerificationEnum YES = new SkipVerificationEnum("yes");
    public static final SkipVerificationEnum NO = new SkipVerificationEnum("no");
    public static final SkipVerificationEnum TRUE = new SkipVerificationEnum("true");
    public static final SkipVerificationEnum FALSE = new SkipVerificationEnum("false");

    private static final EnumSupportDynamic<String, SkipVerificationEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(
            SkipVerificationEnum.class,
            SkipVerificationEnum::new,
            Arrays.asList(YES, NO, TRUE, FALSE));

    private SkipVerificationEnum(String value) {
      super(value);
    }

    public static Stream<SkipVerificationEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static SkipVerificationEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(SkipVerificationEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  /**
   * If <code>skip</code> activated, the certificate and hostname of the resolved MX Host will not
   * be verified when trying to establish a TLS connection. If not, Mailgun will verify the
   * certificate and hostname. If either one can not be verified, a TLS connection will not be
   * established. The default is <code>false</code>
   *
   * @return skipVerification
   */
  SkipVerificationEnum getSkipVerification();

  /**
   * Used to specify an IP Address to send an email that is owned by your account
   *
   * @return sendingIp
   */
  String getSendingIp();

  /**
   * If an IP Pool ID is provided, the email will be delivered with an IP that belongs in that pool
   *
   * @return sendingIpPool
   */
  String getSendingIpPool();

  /**
   * If you send long emails that experience truncation or other rendering issues at the recipient,
   * you can ensure opens are being tracked accurately with placement of the tracking pixel at the
   * top of your emails
   *
   * @return trackingPixelLocationTop
   */
  String getTrackingPixelLocationTop();

  /**
   * h: prefix followed by a Header/Value pair. For example:
   * h:X-Mailgun-Sending-Ip-Pool=xx.xx.xxx.x.
   *
   * @return hColonXMyHeader
   */
  String gethColonXMyHeader();

  /**
   * <code>v:</code> prefix followed by an arbitrary name allows to attach a custom JSON data to the
   * message. See <strong>Attaching Data to Messages</strong> for more information
   *
   * @return vColonMyVar
   */
  String getvColonMyVar();

  /**
   * A valid JSON-encoded dictionary, where key is a plain recipient address and value is a
   * dictionary with variables that can be referenced in the message body. See <strong>Batch
   * Sending</strong> for more information
   *
   * @return recipientVariables
   */
  String getRecipientVariables();

  /**
   * Return the additional property with the specified name.
   *
   * @param key the name of the property
   * @return the additional property with the specified name
   */
  Object get(String key);

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new SendEmailRequestImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param from see getter
     * @return Current builder
     * @see #getFrom
     */
    Builder setFrom(String from);

    /**
     * see getter
     *
     * @param to see getter
     * @return Current builder
     * @see #getTo
     */
    Builder setTo(List<String> to);

    /**
     * see getter
     *
     * @param cc see getter
     * @return Current builder
     * @see #getCc
     */
    Builder setCc(List<String> cc);

    /**
     * see getter
     *
     * @param bcc see getter
     * @return Current builder
     * @see #getBcc
     */
    Builder setBcc(List<String> bcc);

    /**
     * see getter
     *
     * @param subject see getter
     * @return Current builder
     * @see #getSubject
     */
    Builder setSubject(String subject);

    /**
     * see getter
     *
     * @param text see getter
     * @return Current builder
     * @see #getText
     */
    Builder setText(String text);

    /**
     * see getter
     *
     * @param html see getter
     * @return Current builder
     * @see #getHtml
     */
    Builder setHtml(String html);

    /**
     * see getter
     *
     * @param ampHtml see getter
     * @return Current builder
     * @see #getAmpHtml
     */
    Builder setAmpHtml(String ampHtml);

    /**
     * see getter
     *
     * @param attachment see getter
     * @return Current builder
     * @see #getAttachment
     */
    Builder setAttachment(List<File> attachment);

    /**
     * see getter
     *
     * @param inline see getter
     * @return Current builder
     * @see #getInline
     */
    Builder setInline(List<File> inline);

    /**
     * see getter
     *
     * @param template see getter
     * @return Current builder
     * @see #getTemplate
     */
    Builder setTemplate(String template);

    /**
     * see getter
     *
     * @param templateVersion see getter
     * @return Current builder
     * @see #getTemplateVersion
     */
    Builder setTemplateVersion(String templateVersion);

    /**
     * see getter
     *
     * @param templateText see getter
     * @return Current builder
     * @see #getTemplateText
     */
    Builder setTemplateText(TemplateTextEnum templateText);

    /**
     * see getter
     *
     * @param templateVariables see getter
     * @return Current builder
     * @see #getTemplateVariables
     */
    Builder setTemplateVariables(String templateVariables);

    /**
     * see getter
     *
     * @param tag see getter
     * @return Current builder
     * @see #getTag
     */
    Builder setTag(List<String> tag);

    /**
     * see getter
     *
     * @param enableDkimSignature see getter
     * @return Current builder
     * @see #getEnableDkimSignature
     */
    Builder setEnableDkimSignature(DkimSignatureEnum enableDkimSignature);

    /**
     * see getter
     *
     * @param secondaryDkim see getter
     * @return Current builder
     * @see #getSecondaryDkim
     */
    Builder setSecondaryDkim(String secondaryDkim);

    /**
     * see getter
     *
     * @param secondaryDkimPublic see getter
     * @return Current builder
     * @see #getSecondaryDkimPublic
     */
    Builder setSecondaryDkimPublic(String secondaryDkimPublic);

    /**
     * see getter
     *
     * @param deliveryTime see getter
     * @return Current builder
     * @see #getDeliveryTime
     */
    Builder setDeliveryTime(String deliveryTime);

    /**
     * see getter
     *
     * @param deliveryTimeOptimizePeriod see getter
     * @return Current builder
     * @see #getDeliveryTimeOptimizePeriod
     */
    Builder setDeliveryTimeOptimizePeriod(String deliveryTimeOptimizePeriod);

    /**
     * see getter
     *
     * @param timezoneLocalize see getter
     * @return Current builder
     * @see #getTimezoneLocalize
     */
    Builder setTimezoneLocalize(String timezoneLocalize);

    /**
     * see getter
     *
     * @param testMode see getter
     * @return Current builder
     * @see #getTestMode
     */
    Builder setTestMode(TestModeEnum testMode);

    /**
     * see getter
     *
     * @param tracking see getter
     * @return Current builder
     * @see #getTracking
     */
    Builder setTracking(TrackingEnum tracking);

    /**
     * see getter
     *
     * @param trackingClicks see getter
     * @return Current builder
     * @see #getTrackingClicks
     */
    Builder setTrackingClicks(TrackingClicksEnum trackingClicks);

    /**
     * see getter
     *
     * @param trackingOpens see getter
     * @return Current builder
     * @see #getTrackingOpens
     */
    Builder setTrackingOpens(TrackingOpensEnum trackingOpens);

    /**
     * see getter
     *
     * @param requireTls see getter
     * @return Current builder
     * @see #getRequireTls
     */
    Builder setRequireTls(RequireTlsEnum requireTls);

    /**
     * see getter
     *
     * @param skipVerification see getter
     * @return Current builder
     * @see #getSkipVerification
     */
    Builder setSkipVerification(SkipVerificationEnum skipVerification);

    /**
     * see getter
     *
     * @param sendingIp see getter
     * @return Current builder
     * @see #getSendingIp
     */
    Builder setSendingIp(String sendingIp);

    /**
     * see getter
     *
     * @param sendingIpPool see getter
     * @return Current builder
     * @see #getSendingIpPool
     */
    Builder setSendingIpPool(String sendingIpPool);

    /**
     * see getter
     *
     * @param trackingPixelLocationTop see getter
     * @return Current builder
     * @see #getTrackingPixelLocationTop
     */
    Builder setTrackingPixelLocationTop(String trackingPixelLocationTop);

    /**
     * see getter
     *
     * @param hColonXMyHeader see getter
     * @return Current builder
     * @see #gethColonXMyHeader
     */
    Builder sethColonXMyHeader(String hColonXMyHeader);

    /**
     * see getter
     *
     * @param vColonMyVar see getter
     * @return Current builder
     * @see #getvColonMyVar
     */
    Builder setvColonMyVar(String vColonMyVar);

    /**
     * see getter
     *
     * @param recipientVariables see getter
     * @return Current builder
     * @see #getRecipientVariables
     */
    Builder setRecipientVariables(String recipientVariables);

    /**
     * see getter
     *
     * @return Current builder
     * @see #get
     */
    Builder put(String key, Object value);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    SendEmailRequest build();
  }
}
