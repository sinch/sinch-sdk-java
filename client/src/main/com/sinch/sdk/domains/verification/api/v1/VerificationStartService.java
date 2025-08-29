package com.sinch.sdk.domains.verification.api.v1;

import com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequestData;
import com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequestFlashCall;
import com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequestPhoneCall;
import com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequestSms;
import com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequestWhatsApp;
import com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponseData;
import com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponseFlashCall;
import com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponsePhoneCall;
import com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponseSms;
import com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponseWhatsApp;

/**
 * Verification Start Service
 *
 * <p>Start new verification requests
 *
 * <p>This method is used by the mobile and web Verification SDKs to start a verification. It can
 * also be used to request a verification from your backend, by making a request.
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/verification/api-reference/verification/tag/Verifications">https://developers.sinch.com/docs/verification/api-reference/verification/tag/Verifications</a>
 * @since 1.1
 */
public interface VerificationStartService {

  /**
   * Start verification by SMS
   *
   * @param parameters Parameters to be used to start verification
   * @return Verification response
   * @since 1.1
   */
  VerificationStartResponseSms startSms(VerificationStartRequestSms parameters);

  /**
   * Start verification by FLASH_CALL
   *
   * @param parameters Parameters to be used to start verification
   * @return Verification response
   * @since 1.1
   */
  VerificationStartResponseFlashCall startFlashCall(VerificationStartRequestFlashCall parameters);

  /**
   * Start verification by PHONE_CALL
   *
   * @param parameters Parameters to be used to start verification
   * @return Verification response
   * @since 1.1
   */
  VerificationStartResponsePhoneCall startPhoneCall(VerificationStartRequestPhoneCall parameters);

  /**
   * Start verification by DATA
   *
   * @param parameters Parameters to be used to start verification
   * @return Verification response
   * @since 1.1
   */
  VerificationStartResponseData startData(VerificationStartRequestData parameters);

  /**
   * Start verification by WhatsApp
   *
   * @apiNote This is a <b>BETA</b> feature and can be changed before GA
   * @param parameters Parameters to be used to start verification
   * @return Verification response
   * @since 2.0
   */
  VerificationStartResponseWhatsApp startWhatsApp(VerificationStartRequestWhatsApp parameters);
}
