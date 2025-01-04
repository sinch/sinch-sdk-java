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

import com.sinch.sdk.core.utils.Pair;
import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/** SendEmailHtmlInTemplateRequest */
public interface SendEmailHtmlInTemplateRequest extends SendEmailRequest {

  /**
   * Email address of the recipient(s). Example: <code>\&quot;Bob &lt;bob@host.com&gt;\&quot;</code>
   * . You can use commas to separate multiple recipients
   *
   * @return to
   */
  List<String> getTo();

  /**
   * Email address for <code>From</code> header
   *
   * @return from
   */
  String getFrom();

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
   * Get recipientVariables
   *
   * @return recipientVariables
   */
  Map<String, Collection<Pair<String, String>>> getRecipientVariables();

  /**
   * Get overrideProperties
   *
   * @return overrideProperties
   */
  OverrideProperties getOverrideProperties();

  /**
   * Get customVariables
   *
   * @return customVariables
   */
  List<Pair<String, String>> getCustomVariables();

  /**
   * Get customHeaders
   *
   * @return customHeaders
   */
  List<Pair<String, String>> getCustomHeaders();

  /**
   * Name of a template stored via template API to use to render the email body. See
   * <strong>Templates</strong> for more information
   *
   * @return template
   */
  String getTemplate();

  /**
   * Get templateProperties
   *
   * @return templateProperties
   */
  TemplateProperties getTemplateProperties();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new SendEmailHtmlInTemplateRequestImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

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
     * @param from see getter
     * @return Current builder
     * @see #getFrom
     */
    Builder setFrom(String from);

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
     * @param recipientVariables see getter
     * @return Current builder
     * @see #getRecipientVariables
     */
    Builder setRecipientVariables(Map<String, Collection<Pair<String, String>>> recipientVariables);

    /**
     * see getter
     *
     * @param overrideProperties see getter
     * @return Current builder
     * @see #getOverrideProperties
     */
    Builder setOverrideProperties(OverrideProperties overrideProperties);

    /**
     * see getter
     *
     * @param customVariables see getter
     * @return Current builder
     * @see #getCustomVariables
     */
    Builder setCustomVariables(List<Pair<String, String>> customVariables);

    /**
     * see getter
     *
     * @param customHeaders see getter
     * @return Current builder
     * @see #getCustomHeaders
     */
    Builder setCustomHeaders(List<Pair<String, String>> customHeaders);

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
     * @param templateProperties see getter
     * @return Current builder
     * @see #getTemplateProperties
     */
    Builder setTemplateProperties(TemplateProperties templateProperties);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    SendEmailHtmlInTemplateRequest build();
  }
}
