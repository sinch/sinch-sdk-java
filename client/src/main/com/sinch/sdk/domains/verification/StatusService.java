package com.sinch.sdk.domains.verification;

import com.sinch.sdk.domains.verification.models.Identity;
import com.sinch.sdk.domains.verification.models.VerificationMethodType;
import com.sinch.sdk.domains.verification.models.VerificationReport;

/**
 * Get the status of specific verification requests in the verification process. Returns the status
 * of pending and completed verifications. You can retrieve the status of verification requests by
 * using the ID of the request, the phone number of the user being verified, or a custom reference
 * string.
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/verification/api-reference/verification/tag/Verification-status">https://developers.sinch.com/docs/verification/api-reference/verification/tag/Verification-status</a>
 * @since 1.0
 */
public interface StatusService {

  /**
   * Queries the verification result by sending the verification Identity (usually a phone number)
   * and its method. With this query you can get the result of a verification.
   *
   * @param identity Only number identity is supported
   * @param method Method used for verification
   * @return Verification report response
   * @since 1.0
   */
  VerificationReport getByIdentity(Identity identity, VerificationMethodType method);

  /**
   * Queries the verification result by sending the verification ID. With this query you can get the
   * result of a verification.
   *
   * @param id The ID of the verification
   * @return Verification report response
   * @since 1.0
   */
  VerificationReport getById(String id);

  /**
   * Queries the verification result by sending the verification Reference. With this query you can
   * get the result of a verification
   *
   * @param reference The custom reference of the verification
   * @return Verification report response
   * @since 1.0
   */
  VerificationReport getByReference(String reference);
}
