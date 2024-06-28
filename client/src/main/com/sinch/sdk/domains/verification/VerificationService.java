package com.sinch.sdk.domains.verification;

/**
 * Verification Domain Level Service
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/verification">https://developers.sinch.com/docs/verification</a>
 * @since 1.0
 */
public interface VerificationService {

  /**
   * Verifications Service V1
   *
   * @return V1 service instance for project
   * @see <a
   *     href="https://developers.sinch.com/docs/verification/api-reference/verification/tag/Verifications/">Documentation</a>
   * @since 1.1
   */
  com.sinch.sdk.domains.verification.api.v1.VerificationService v1();

  /**
   * Non versioned Verifications Service instance
   *
   * @apiNote This version is no longer updated, to get updates use V1 version: {@link
   *     com.sinch.sdk.domains.verification.api.v1.VerificationService#verificationStart()} or
   *     {@link com.sinch.sdk.domains.verification.api.v1.VerificationService#verificationReport()}
   * @return service instance for project
   * @see <a
   *     href="https://developers.sinch.com/docs/verification/api-reference/verification/tag/Verifications/">Documentation</a>
   * @since 1.0
   */
  VerificationsService verifications();

  /**
   * Non versioned Status Service instance
   *
   * @apiNote This version is no longer updated, to get updates use V1 version: {@link
   *     com.sinch.sdk.domains.verification.api.v1.VerificationService#verificationStatus()}
   * @return service instance for project
   * @see <a
   *     href="https://developers.sinch.com/docs/verification/api-reference/verification/tag/Verification-status/">Documentation</a>
   * @since 1.0
   */
  VerificationStatusService verificationStatus();

  /**
   * Non versioned Webhooks helpers instance
   *
   * @apiNote This version is no longer updated, to get updates use V1 version: {@link
   *     com.sinch.sdk.domains.verification.api.v1.VerificationService#webhooks()}
   * @return instance service related to webhooks helpers
   * @see <a
   *     href="https://developers.sinch.com/docs/verification/api-reference/verification/tag/Verification-callbacks/">Documentation</a>
   * @since 1.0
   */
  WebHooksService webhooks();
}
