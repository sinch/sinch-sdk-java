/*
 * Mailgun API
 *
 * OpenAPI document version: 0.0.0
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.mailgun.models.v1.emails.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;

/** GetStoredEmailResponse */
@JsonDeserialize(builder = GetStoredEmailResponseImpl.Builder.class)
public interface GetStoredEmailResponse {

  /**
   * The full 'From' email address entry of the email
   *
   * @return from
   */
  String getFrom();

  /**
   * Subject of the email
   *
   * @return subject
   */
  String getSubject();

  /**
   * Just the email address from the provided 'From'' field
   *
   * @return sender
   */
  String getSender();

  /**
   * A list of email addresses from the 'To'' field
   *
   * @return recipients
   */
  String getRecipients();

  /**
   * The full HTML body of the full message
   *
   * @return bodyHtml
   */
  String getBodyHtml();

  /**
   * The plain text body of the full message
   *
   * @return bodyPlain
   */
  String getBodyPlain();

  /**
   * Only the body of the email in HTML
   *
   * @return strippedHtml
   */
  String getStrippedHtml();

  /**
   * Only the body of the email in plain text
   *
   * @return strippedText
   */
  String getStrippedText();

  /**
   * The signature stripped from the body
   *
   * @return strippedSignature
   */
  String getStrippedSignature();

  /**
   * The full list of headers of the MIME upon send
   *
   * @return messageHeaders
   */
  List<List<String>> getMessageHeaders();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new GetStoredEmailResponseImpl.Builder();
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
     * @param subject see getter
     * @return Current builder
     * @see #getSubject
     */
    Builder setSubject(String subject);

    /**
     * see getter
     *
     * @param sender see getter
     * @return Current builder
     * @see #getSender
     */
    Builder setSender(String sender);

    /**
     * see getter
     *
     * @param recipients see getter
     * @return Current builder
     * @see #getRecipients
     */
    Builder setRecipients(String recipients);

    /**
     * see getter
     *
     * @param bodyHtml see getter
     * @return Current builder
     * @see #getBodyHtml
     */
    Builder setBodyHtml(String bodyHtml);

    /**
     * see getter
     *
     * @param bodyPlain see getter
     * @return Current builder
     * @see #getBodyPlain
     */
    Builder setBodyPlain(String bodyPlain);

    /**
     * see getter
     *
     * @param strippedHtml see getter
     * @return Current builder
     * @see #getStrippedHtml
     */
    Builder setStrippedHtml(String strippedHtml);

    /**
     * see getter
     *
     * @param strippedText see getter
     * @return Current builder
     * @see #getStrippedText
     */
    Builder setStrippedText(String strippedText);

    /**
     * see getter
     *
     * @param strippedSignature see getter
     * @return Current builder
     * @see #getStrippedSignature
     */
    Builder setStrippedSignature(String strippedSignature);

    /**
     * see getter
     *
     * @param messageHeaders see getter
     * @return Current builder
     * @see #getMessageHeaders
     */
    Builder setMessageHeaders(List<List<String>> messageHeaders);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    GetStoredEmailResponse build();
  }
}
