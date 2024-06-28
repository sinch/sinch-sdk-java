package com.sinch.sdk.domains.verification.api.v1;

/**
 * Verification Domain Level Service
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/verification">https://developers.sinch.com/docs/verification</a>
 * @since 1.1
 */
public interface VerificationService {

  /**
   * Verifications Start Service instance
   *
   * @return service instance for project
   * @see <a
   *     href="https://developers.sinch.com/docs/verification/api-reference/verification/tag/Verifications">Documentation</a>
   * @since 1.1
   */
  VerificationStartService verificationStart();

  /**
   * Verifications Report Service instance
   *
   * @return service instance for project
   * @see <a
   *     href="https://developers.sinch.com/docs/verification/api-reference/verification/tag/Verifications">Documentation</a>
   * @since 1.1
   */
  VerificationReportService verificationReport();

  /**
   * Verifications Status Service instance
   *
   * @return service instance for project
   * @see <a
   *     href="https://developers.sinch.com/docs/verification/api-reference/verification/tag/Verification-status">Documentation</a>
   * @since 1.1
   */
  VerificationStatusService verificationStatus();

  /**
   * Webhooks helpers instance
   *
   * @return service instance for project
   * @see <a
   *     href="https://developers.sinch.com/docs/verification/api-reference/verification/tag/Verification-callbacks">Documentation</a>
   * @since 1.1
   */
  WebHooksService webhooks();
}
