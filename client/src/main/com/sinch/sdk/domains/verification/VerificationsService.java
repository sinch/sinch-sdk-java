package com.sinch.sdk.domains.verification;

import com.sinch.sdk.domains.verification.models.NumberIdentity;
import com.sinch.sdk.domains.verification.models.VerificationId;
import com.sinch.sdk.domains.verification.models.VerificationReport;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportCalloutRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportFlashCallRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportSMSRequestParameters;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponse;

/**
 * Verifications Service
 *
 * <p>Start new verification requests and report on existing verification requests.
 *
 * @see <a
 * href="https://developers.sinch.com/docs/verification/api-reference/verification/tag/Verifications">https://developers.sinch.com/docs/verification/api-reference/verification/tag/Verifications</a>
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
   * Report a verification using {@link com.sinch.sdk.domains.verification.models.VerificationMethodType#SMS SMS} &amp; Identity
   *
   * <p>Report the received verification code to verify it, using the identity of the user
   * @param identity   Currently <b>Only</b>
   *                   {@link com.sinch.sdk.domains.verification.models.NumberIdentity
   *                   NumberIdentity} is supported
   * @param parameters Parameters to be used to get report
   * @return Verification report response
   * @since 1.0
   */
  VerificationReport reportSmsByIdentity(
      NumberIdentity identity, VerificationReportSMSRequestParameters parameters);

  /**
   * Report a verification using {@link com.sinch.sdk.domains.verification.models.VerificationMethodType#FLASH_CALL FLASH_CALL} &amp; Identity
   *
   * <p>Report the received verification code to verify it, using the identity of the user
   * @param identity   Currently <b>Only</b>
   *                   {@link com.sinch.sdk.domains.verification.models.NumberIdentity
   *                   NumberIdentity} is supported
   * @param parameters Parameters to be used to get report
   * @return Verification report response
   * @since 1.0
   */ VerificationReport reportFlashCallByIdentity(
      NumberIdentity identity, VerificationReportFlashCallRequestParameters parameters);

  /**
   * Report a verification using {@link com.sinch.sdk.domains.verification.models.VerificationMethodType#CALLOUT CALLOUT} &amp; Identity
   *
   * <p>Report the received verification code to verify it, using the identity of the user
   * @param identity   Currently <b>Only</b>
   *                   {@link com.sinch.sdk.domains.verification.models.NumberIdentity
   *                   NumberIdentity} is supported
   * @param parameters Parameters to be used to get report
   * @return Verification report response
   * @since 1.0
   */ VerificationReport reportCalloutByIdentity(
      NumberIdentity identity, VerificationReportCalloutRequestParameters parameters);

  /**
   * Report the received verification code to verify it, using the Verification ID of the
   * {@link com.sinch.sdk.domains.verification.models.VerificationMethodType#SMS SMS} Verification request
   *
   * @param id         ID returned from start verification
   * @param parameters Parameters to be used to get report
   * @return Verification report response
   * @since 1.0
   */
  VerificationReport reportSmsById(
      VerificationId id, VerificationReportSMSRequestParameters parameters);

  /**
   * Report the received verification code to verify it, using the Verification ID of the
   * {@link com.sinch.sdk.domains.verification.models.VerificationMethodType#FLASH_CALL FLASH_CALL} Verification request
   *
   * @param id         ID returned from start verification
   * @param parameters Parameters to be used to get report
   * @return Verification report response
   * @since 1.0
   */VerificationReport reportFlashCallById(
      VerificationId id, VerificationReportFlashCallRequestParameters parameters);

  /**
   * Report the received verification code to verify it, using the Verification ID of the
   * {@link com.sinch.sdk.domains.verification.models.VerificationMethodType#CALLOUT CALLOUT} Verification request
   *
   * @param id         ID returned from start verification
   * @param parameters Parameters to be used to get report
   * @return Verification report response
   * @since 1.0
   */ VerificationReport reportCalloutById(
      VerificationId id, VerificationReportCalloutRequestParameters parameters);
}
