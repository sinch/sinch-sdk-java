package com.sinch.sdk.domains.verification;

import com.sinch.sdk.domains.verification.models.NumberIdentity;
import com.sinch.sdk.domains.verification.models.VerificationId;
import com.sinch.sdk.domains.verification.models.VerificationReportCallout;
import com.sinch.sdk.domains.verification.models.VerificationReportFlashCall;
import com.sinch.sdk.domains.verification.models.VerificationReportSMS;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationCalloutRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationFlashCallRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationSMSRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationSeamlessRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportCalloutRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportFlashCallRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportSMSRequestParameters;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseCallout;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseFlashCall;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseSMS;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseSeamless;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestFlashCall;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestPhoneCall;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestSms;
import com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequestData;
import com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequestFlashCall;
import com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequestPhoneCall;
import com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequestSms;

/**
 * Verifications Service
 *
 * <p>Start new verification requests and report on existing verification requests.
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/verification/api-reference/verification/tag/Verifications">https://developers.sinch.com/docs/verification/api-reference/verification/tag/Verifications</a>
 * @since 1.0
 * @deprecated use {@link com.sinch.sdk.domains.verification.api.v1.VerificationStartService}
 *     instead.
 */
@Deprecated
public interface VerificationsService {

  /**
   * Start verification by {@link
   * com.sinch.sdk.domains.verification.models.VerificationMethodType#SMS SMS}
   *
   * <p>This method is used by the mobile and web Verification SDKs to start a verification. It can
   * also be used to request a verification from your backend, by making a request.
   *
   * @param parameters Parameters to be used to start verification
   * @return Verification response
   * @deprecated use {@link
   *     com.sinch.sdk.domains.verification.api.v1.VerificationStartService#startSms(VerificationStartRequestSms)}
   *     instead.
   * @since 1.0
   */
  @Deprecated
  StartVerificationResponseSMS startSms(StartVerificationSMSRequestParameters parameters);

  /**
   * Start verification by {@link
   * com.sinch.sdk.domains.verification.models.VerificationMethodType#FLASH_CALL FLASH_CALL}
   *
   * <p>This method is used by the mobile and web Verification SDKs to start a verification. It can
   * also be used to request a verification from your backend, by making a request.
   *
   * @param parameters Parameters to be used to start verification
   * @return Verification response
   * @since 1.0
   * @deprecated use {@link
   *     com.sinch.sdk.domains.verification.api.v1.VerificationStartService#startFlashCall(VerificationStartRequestFlashCall)}
   *     instead.
   */
  @Deprecated
  StartVerificationResponseFlashCall startFlashCall(
      StartVerificationFlashCallRequestParameters parameters);

  /**
   * Start verification by {@link
   * com.sinch.sdk.domains.verification.models.VerificationMethodType#CALLOUT CALLOUT}
   *
   * <p>This method is used by the mobile and web Verification SDKs to start a verification. It can
   * also be used to request a verification from your backend, by making a request.
   *
   * @param parameters Parameters to be used to start verification
   * @return Verification response
   * @deprecated use {@link
   *     com.sinch.sdk.domains.verification.api.v1.VerificationStartService#startPhoneCall(VerificationStartRequestPhoneCall)}
   *     instead.
   * @since 1.0
   */
  @Deprecated
  StartVerificationResponseCallout startCallout(
      StartVerificationCalloutRequestParameters parameters);

  /**
   * Start verification by {@link
   * com.sinch.sdk.domains.verification.models.VerificationMethodType#SEAMLESS SEAMLESS}
   *
   * <p>This method is used by the mobile and web Verification SDKs to start a verification. It can
   * also be used to request a verification from your backend, by making a request.
   *
   * @param parameters Parameters to be used to start verification
   * @return Verification response
   * @since 1.0
   * @deprecated use {@link
   *     com.sinch.sdk.domains.verification.api.v1.VerificationStartService#startData(VerificationStartRequestData)}
   *     instead.
   */
  @Deprecated
  StartVerificationResponseSeamless startSeamless(
      StartVerificationSeamlessRequestParameters parameters);

  /**
   * Report a verification using {@link
   * com.sinch.sdk.domains.verification.models.VerificationMethodType#SMS SMS} &amp; Identity
   *
   * <p>Report the received verification code to verify it, using the identity of the user
   *
   * @param identity Currently <b>Only</b> {@link
   *     com.sinch.sdk.domains.verification.models.NumberIdentity NumberIdentity} is supported
   * @param parameters Parameters to be used to get report
   * @return Verification report response
   * @since 1.0
   * @deprecated use {@link
   *     com.sinch.sdk.domains.verification.api.v1.VerificationReportService#reportSmsByIdentity(com.sinch.sdk.domains.verification.models.v1.NumberIdentity,
   *     VerificationReportRequestSms)} instead.
   */
  @Deprecated
  VerificationReportSMS reportSmsByIdentity(
      NumberIdentity identity, VerificationReportSMSRequestParameters parameters);

  /**
   * Report a verification using {@link
   * com.sinch.sdk.domains.verification.models.VerificationMethodType#FLASH_CALL FLASH_CALL} &amp;
   * Identity
   *
   * <p>Report the received verification code to verify it, using the identity of the user
   *
   * @param identity Currently <b>Only</b> {@link
   *     com.sinch.sdk.domains.verification.models.NumberIdentity NumberIdentity} is supported
   * @param parameters Parameters to be used to get report
   * @return Verification report response
   * @since 1.0
   * @deprecated use {@link
   *     com.sinch.sdk.domains.verification.api.v1.VerificationReportService#reportFlashCallByIdentity(com.sinch.sdk.domains.verification.models.v1.NumberIdentity,
   *     VerificationReportRequestFlashCall)} instead.
   */
  @Deprecated
  VerificationReportFlashCall reportFlashCallByIdentity(
      NumberIdentity identity, VerificationReportFlashCallRequestParameters parameters);

  /**
   * Report a verification using {@link
   * com.sinch.sdk.domains.verification.models.VerificationMethodType#CALLOUT CALLOUT} &amp;
   * Identity
   *
   * <p>Report the received verification code to verify it, using the identity of the user
   *
   * @param identity Currently <b>Only</b> {@link
   *     com.sinch.sdk.domains.verification.models.NumberIdentity NumberIdentity} is supported
   * @param parameters Parameters to be used to get report
   * @return Verification report response
   * @since 1.0
   * @deprecated use {@link
   *     com.sinch.sdk.domains.verification.api.v1.VerificationReportService#reportPhoneCallByIdentity(com.sinch.sdk.domains.verification.models.v1.NumberIdentity,
   *     VerificationReportRequestPhoneCall)} instead.
   */
  @Deprecated
  VerificationReportCallout reportCalloutByIdentity(
      NumberIdentity identity, VerificationReportCalloutRequestParameters parameters);

  /**
   * Report the received verification code to verify it, using the Verification ID of the {@link
   * com.sinch.sdk.domains.verification.models.VerificationMethodType#SMS SMS} Verification request
   *
   * @param id ID returned from start verification
   * @param parameters Parameters to be used to get report
   * @return Verification report response
   * @since 1.0
   * @deprecated use {@link
   *     com.sinch.sdk.domains.verification.api.v1.VerificationReportService#reportSmsById(String,
   *     VerificationReportRequestSms)} instead.
   */
  @Deprecated
  VerificationReportSMS reportSmsById(
      VerificationId id, VerificationReportSMSRequestParameters parameters);

  /**
   * Report the received verification code to verify it, using the Verification ID of the {@link
   * com.sinch.sdk.domains.verification.models.VerificationMethodType#FLASH_CALL FLASH_CALL}
   * Verification request
   *
   * @param id ID returned from start verification
   * @param parameters Parameters to be used to get report
   * @return Verification report response
   * @since 1.0
   * @deprecated use {@link
   *     com.sinch.sdk.domains.verification.api.v1.VerificationReportService#reportFlashCallById(String,
   *     VerificationReportRequestFlashCall)} instead.
   */
  @Deprecated
  VerificationReportFlashCall reportFlashCallById(
      VerificationId id, VerificationReportFlashCallRequestParameters parameters);

  /**
   * Report the received verification code to verify it, using the Verification ID of the {@link
   * com.sinch.sdk.domains.verification.models.VerificationMethodType#CALLOUT CALLOUT} Verification
   * request
   *
   * @param id ID returned from start verification
   * @param parameters Parameters to be used to get report
   * @return Verification report response
   * @since 1.0
   * @deprecated use {@link
   *     com.sinch.sdk.domains.verification.api.v1.VerificationReportService#reportPhoneCallByIdentity(com.sinch.sdk.domains.verification.models.v1.NumberIdentity,
   *     VerificationReportRequestPhoneCall)} instead.
   */
  @Deprecated
  VerificationReportCallout reportCalloutById(
      VerificationId id, VerificationReportCalloutRequestParameters parameters);
}
