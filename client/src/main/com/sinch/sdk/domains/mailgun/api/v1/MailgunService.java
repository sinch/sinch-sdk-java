package com.sinch.sdk.domains.mailgun.api.v1;

/**
 * Mailgun Service V1
 *
 * @see <a
 *     href="https://documentation.mailgun.com/docs/mailgun">https://documentation.mailgun.com/docs/mailgun</a>
 * @since 1.6
 */
public interface MailgunService {

  /**
   * Emails Service instance V1
   *
   * @return service instance for project
   * @see <a
   *     href="https://documentation.mailgun.com/docs/mailgun/api-reference/openapi-final/tag/Messages">Messages
   *     API documentation</a>
   * @since 1.6
   */
  EmailsService emails();

  /**
   * Templates Service instance V1
   *
   * @return service instance for project
   * @see <a
   *     href="https://documentation.mailgun.com/docs/mailgun/api-reference/openapi-final/tag/Templates">Templates
   *     API documentation</a>
   * @since 1.6
   */
  TemplatesService templates();
}
