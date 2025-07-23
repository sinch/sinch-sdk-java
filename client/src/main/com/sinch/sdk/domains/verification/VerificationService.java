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
}
