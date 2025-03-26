package com.sinch.sdk.domains.mailgun;

/**
 * Mailgun Service
 *
 * @see <a
 *     href="https://documentation.mailgun.com/docs/mailgun/user-manual/get-started">https://documentation.mailgun.com/docs/mailgun/user-manual/get-started/</a>
 * @since 1.6
 */
public interface MailgunService {

  /**
   * Mailgun Service V1
   *
   * @return V1 service instance for project
   * @since 1.6
   */
  com.sinch.sdk.domains.mailgun.api.v1.MailgunService v1();
}
