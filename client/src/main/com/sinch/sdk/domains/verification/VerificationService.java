package com.sinch.sdk.domains.verification;

/**
 * Verification Service
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/verification//">https://developers.sinch.com/docs/verification//</a>
 * @since 1.0
 */
public interface VerificationService {

  /**
   * Use application secret in place of unified configuration for authentication (see Sinch
   * dashboard for details)
   *
   * @param key see <a href="https://dashboard.sinch.com/voice/apps">dashboard</a>
   * @param secret see <a href="https://dashboard.sinch.com/voice/apps">dashboard</a>
   * @return service instance for project
   * @since 1.0
   */
  VerificationService useSecrets(String key, String secret);

  /**
   * Verifications Service instance
   *
   * @return service instance for project
   * @since 1.0
   */
  VerificationsService verifications();

  /**
   * Status Service instance
   *
   * @return service instance for project
   * @since 1.0
   */
  StatusService status();
}
