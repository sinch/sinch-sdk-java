package com.sinch.sdk.domains.verification;

import com.sinch.sdk.domains.verification.models.requests.StartVerificationRequestParameters;

/**
 * Verifications Service
 *
 * <p>Start new verification requests and report on existing verification requests.
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/verification/api-reference/verification/tag/Verifications///">https://developers.sinch.com/docs/verification/api-reference/verification/tag/Verifications///</a>
 * @since 1.0
 */
public interface VerificationsService {

  /**
   * Start verification
   *
   * <p>This method is used by the mobile and web Verification SDKs to start a verification. It can
   * also be used to request a verification from your backend, by making an request.
   *
   * @param parameters Parameters to be used to start verification return service instance for
   *     project
   * @since 1.0
   */
  void start(StartVerificationRequestParameters parameters);
}
