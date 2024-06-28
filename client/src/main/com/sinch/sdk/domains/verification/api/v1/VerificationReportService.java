package com.sinch.sdk.domains.verification.api.v1;

import com.sinch.sdk.domains.verification.models.v1.NumberIdentity;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestFlashCall;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestPhoneCall;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestSms;
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponseFlashCall;
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponsePhoneCall;
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponseSms;

/**
 * Verification Report Service
 *
 * <p>Report about a verification request
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/verification/api-reference/verification/tag/Verifications">https://developers.sinch.com/docs/verification/api-reference/verification/tag/Verifications</a>
 * @since 1.1
 */
public interface VerificationReportService {

  /**
   * Report a verification using {@link
   * com.sinch.sdk.domains.verification.models.v1.VerificationMethod#SMS} &amp; Identity
   *
   * <p>Report the received verification code to verify it, using the identity of the user
   *
   * @param identity Currently <b>Only</b> {@link
   *     com.sinch.sdk.domains.verification.models.v1.NumberIdentity NumberIdentity} is supported
   * @param parameters Parameters to be used to get report
   * @return Verification report response
   * @since 1.1
   */
  VerificationReportResponseSms reportSmsByIdentity(
      NumberIdentity identity, VerificationReportRequestSms parameters);

  /**
   * Report a verification using {@link
   * com.sinch.sdk.domains.verification.models.v1.VerificationMethod#FLASH_CALL} &amp; Identity
   *
   * <p>Report the received verification code to verify it, using the identity of the user
   *
   * @param identity Currently <b>Only</b> {@link
   *     com.sinch.sdk.domains.verification.models.v1.NumberIdentity NumberIdentity} is supported
   * @param parameters Parameters to be used to get report
   * @return Verification report response
   * @since 1.1
   */
  VerificationReportResponseFlashCall reportFlashCallByIdentity(
      NumberIdentity identity, VerificationReportRequestFlashCall parameters);

  /**
   * Report a verification using {@link
   * com.sinch.sdk.domains.verification.models.v1.VerificationMethod#PHONE_CALL} &amp; Identity
   *
   * <p>Report the received verification code to verify it, using the identity of the user
   *
   * @param identity Currently <b>Only</b> {@link
   *     com.sinch.sdk.domains.verification.models.v1.NumberIdentity NumberIdentity} is supported
   * @param parameters Parameters to be used to get report
   * @return Verification report response
   * @since 1.1
   */
  VerificationReportResponsePhoneCall reportPhoneCallByIdentity(
      NumberIdentity identity, VerificationReportRequestPhoneCall parameters);

  /**
   * Report the received verification code to verify it, using the Verification ID of the {@link
   * com.sinch.sdk.domains.verification.models.v1.VerificationMethod#SMS} Verification request
   *
   * @param id ID returned from start verification
   * @param parameters Parameters to be used to get report
   * @return Verification report response
   * @since 1.1
   */
  VerificationReportResponseSms reportSmsById(String id, VerificationReportRequestSms parameters);

  /**
   * Report the received verification code to verify it, using the Verification ID of the {@link
   * com.sinch.sdk.domains.verification.models.v1.VerificationMethod#FLASH_CALL} Verification
   * request
   *
   * @param id ID returned from start verification
   * @param parameters Parameters to be used to get report
   * @return Verification report response
   * @since 1.1
   */
  VerificationReportResponseFlashCall reportFlashCallById(
      String id, VerificationReportRequestFlashCall parameters);

  /**
   * Report the received verification code to verify it, using the Verification ID of the {@link
   * com.sinch.sdk.domains.verification.models.v1.VerificationMethod#PHONE_CALL} Verification
   * request
   *
   * @param id ID returned from start verification
   * @param parameters Parameters to be used to get report
   * @return Verification report response
   * @since 1.1
   */
  VerificationReportResponsePhoneCall reportPhoneCallById(
      String id, VerificationReportRequestPhoneCall parameters);
}
