package com.sinch.sdk.domains.mailgun.api.v1;

/**
 * Mailgun Service V1
 *
 * @see <a
 *     href="https://documentation.mailgun.com/docs/mailgun">https://documentation.mailgun.com/docs/mailgun</a>
 * @since __TO_BE_DEFINED__
 */
public interface MailgunService {

  /**
   * Emails Service instance
   *
   * @return service instance for project
   * @see <a
   *     href="https://documentation.mailgun.com/docs/mailgun/api-reference/openapi-final/tag/Messages/">Messages
   *     API documentation</a>
   */
  EmailsService emails();
}
