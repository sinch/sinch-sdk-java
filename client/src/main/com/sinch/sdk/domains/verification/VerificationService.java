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
   * @return service instance for project
   * @see <a
   *     href="https://developers.sinch.com/docs/verification/api-reference/verification/tag/Verifications/">Documentation</a>
   * @since 1.0
   * @deprecated use {@link
   *     com.sinch.sdk.domains.verification.api.v1.VerificationService#verificationReport()} and
   *     {@link com.sinch.sdk.domains.verification.api.v1.VerificationService#verificationStart()}
   *     instead.
   */
  @Deprecated
  VerificationsService verifications();

  /**
   * Non versioned Status Service instance
   *
   * @return service instance for project
   * @see <a
   *     href="https://developers.sinch.com/docs/verification/api-reference/verification/tag/Verification-status/">Documentation</a>
   * @since 1.0
   * @deprecated use {@link
   *     com.sinch.sdk.domains.verification.api.v1.VerificationService#verificationStatus()}
   *     instead.
   */
  @Deprecated
  VerificationStatusService verificationStatus();

  /**
   * Non versioned Webhooks helpers instance
   *
   * @return instance service related to webhooks helpers
   * @see <a
   *     href="https://developers.sinch.com/docs/verification/api-reference/verification/tag/Verification-callbacks/">Documentation</a>
   * @since 1.0
   * @deprecated use {@link
   *     com.sinch.sdk.domains.verification.api.v1.VerificationService#webhooks()} instead.
   */
  @Deprecated
  WebHooksService webhooks();
}
