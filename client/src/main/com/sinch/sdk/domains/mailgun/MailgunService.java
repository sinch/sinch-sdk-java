package com.sinch.sdk.domains.mailgun;

/**
 * Mailgun Service
 *
 * @see <a
 *     href="https://documentation.mailgun.com/docs/mailgun/">https://documentation.mailgun.com/docs/mailgun</a>
 * @since __TO_BE_DEFINED__
 */
public interface MailgunService {

  /**
   * Mailgun Service V1
   *
   * @return V1 service instance for project
   * @see <a href="__TO_BE_DEFINED__">__TO_BE_DEFINED__</a>
   * @since __TO_BE_DEFINED__
   */
  com.sinch.sdk.domains.mailgun.api.v1.MailgunService v1();
}
