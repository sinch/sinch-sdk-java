package com.sinch.sdk.domains.verification.api.v1;

import com.sinch.sdk.domains.verification.models.v1.NumberIdentity;
import com.sinch.sdk.domains.verification.models.v1.VerificationMethod;
import com.sinch.sdk.domains.verification.models.v1.status.response.VerificationStatusResponse;

/**
 * Get the status of specific verification requests in the verification process. Returns the status
 * of pending and completed verifications. You can retrieve the status of verification requests by
 * using the ID of the request, the phone number of the user being verified, or a custom reference
 * string.
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/verification/api-reference/verification/tag/Verification-status">https://developers.sinch.com/docs/verification/api-reference/verification/tag/Verification-status</a>
 * @since 1.1
 */
public interface VerificationStatusService {

  /**
   * Queries the verification result by sending the verification Identity (usually a phone number)
   * and its method. With this query you can get the result of a verification.
   *
   * @param identity Currently <b>Only</b> {@link
   *     com.sinch.sdk.domains.verification.models.v1.NumberIdentity} is supported
   * @param method Method used for verification
   * @return Verification status response
   * @since 1.1
   */
  VerificationStatusResponse getByIdentity(NumberIdentity identity, VerificationMethod method);

  /**
   * Queries the verification result by sending the verification ID. With this query you can get the
   * result of a verification.
   *
   * @param id The ID of the verification
   * @return Verification status response
   * @since 1.1
   */
  VerificationStatusResponse getById(String id);

  /**
   * Queries the verification result by sending the verification Reference. With this query you can
   * get the result of a verification
   *
   * @param reference The custom reference of the verification
   * @return Verification status response
   * @since 1.1
   */
  VerificationStatusResponse getByReference(String reference);
}
