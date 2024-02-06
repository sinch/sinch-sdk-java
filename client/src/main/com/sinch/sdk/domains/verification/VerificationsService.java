package com.sinch.sdk.domains.verification;

import com.sinch.sdk.domains.verification.models.NumberIdentity;
import com.sinch.sdk.domains.verification.models.VerificationId;
import com.sinch.sdk.domains.verification.models.VerificationReport;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportRequestParameters;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponse;

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
   * also be used to request a verification from your backend, by making a request.
   *
   * @param parameters Parameters to be used to start verification
   * @return Verification response
   * @since 1.0
   */
  StartVerificationResponse start(StartVerificationRequestParameters parameters);

  /**
   * Report a verification using Identity
   *
   * <p>Report the received verification code to verify it, using the identity of the user (in most
   * cases, the phone number). For an SMS PIN verification or Phone Call verification, this is the
   * OTP code. For flashcalls, this is the CLI.
   *
   * @param identity Currently <b>Only</b> {@link
   *     com.sinch.sdk.domains.verification.models.NumberIdentity NumberIdentity} is supported
   * @param parameters Parameters to be used to get report
   * @return Verification report response
   * @since 1.0
   */
  VerificationReport report(
      NumberIdentity identity, VerificationReportRequestParameters parameters);

  /**
   * Report the received verification code to verify it, using the Verification ID of the
   * Verification request
   *
   * @param id Id returned from start verification
   * @param parameters Parameters to be used to get report
   * @return Verification report response
   * @since 1.0
   */
  VerificationReport report(VerificationId id, VerificationReportRequestParameters parameters);
}
