package com.sinch.sdk.domains.verification;

/**
 * Verification Domain Level Service
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/verification">https://developers.sinch.com/docs/verification</a>
 * @since 1.0
 */
public interface VerificationService {

  com.sinch.sdk.domains.verification.api.v1.VerificationService v1();

  /**
   * Verifications Service instance
   *
   * @return service instance for project
   * @see <a
   *     href="https://developers.sinch.com/docs/verification/api-reference/verification/tag/Verifications/">Documentation</a>
   * @since 1.0
   */
  VerificationsService verifications();

  /**
   * Status Service instance
   *
   * @return service instance for project
   * @see <a
   *     href="https://developers.sinch.com/docs/verification/api-reference/verification/tag/Verification-status/">Documentation</a>
   * @since 1.0
   */
  VerificationStatusService verificationStatus();

  /**
   * Webhooks helpers instance
   *
   * @return instance service related to webhooks helpers
   * @see <a
   *     href="https://developers.sinch.com/docs/verification/api-reference/verification/tag/Verification-callbacks/">Documentation</a>
   * @since 1.0
   */
  WebHooksService webhooks();
}
