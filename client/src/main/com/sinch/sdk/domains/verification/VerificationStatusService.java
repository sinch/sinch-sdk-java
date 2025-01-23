package com.sinch.sdk.domains.verification;

import com.sinch.sdk.domains.verification.models.NumberIdentity;
import com.sinch.sdk.domains.verification.models.VerificationId;
import com.sinch.sdk.domains.verification.models.VerificationMethodType;
import com.sinch.sdk.domains.verification.models.VerificationReference;
import com.sinch.sdk.domains.verification.models.VerificationStatus;
import com.sinch.sdk.domains.verification.models.v1.VerificationMethod;

/**
 * Get the status of specific verification requests in the verification process. Returns the status
 * of pending and completed verifications. You can retrieve the status of verification requests by
 * using the ID of the request, the phone number of the user being verified, or a custom reference
 * string.
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/verification/api-reference/verification/tag/Verification-status">https://developers.sinch.com/docs/verification/api-reference/verification/tag/Verification-status</a>
 * @since 1.0
 * @deprecated use {@link com.sinch.sdk.domains.verification.api.v1.VerificationStatusService}
 *     instead.
 */
@Deprecated
public interface VerificationStatusService {

  /**
   * Queries the verification result by sending the verification Identity (usually a phone number)
   * and its method. With this query you can get the result of a verification.
   *
   * @param identity Currently <b>Only</b> {@link
   *     com.sinch.sdk.domains.verification.models.NumberIdentity NumberIdentity} is supported
   * @param method Method used for verification
   * @return Verification status response
   * @since 1.0
   * @deprecated use {@link
   *     com.sinch.sdk.domains.verification.api.v1.VerificationStatusService#getByIdentity(com.sinch.sdk.domains.verification.models.v1.NumberIdentity,
   *     VerificationMethod)} instead.
   */
  @Deprecated
  VerificationStatus getByIdentity(NumberIdentity identity, VerificationMethodType method);

  /**
   * Queries the verification result by sending the verification ID. With this query you can get the
   * result of a verification.
   *
   * @param id The ID of the verification
   * @return Verification status response
   * @since 1.0
   * @deprecated use {@link
   *     com.sinch.sdk.domains.verification.api.v1.VerificationStatusService#getById(String)}
   *     instead.
   */
  @Deprecated
  VerificationStatus getById(VerificationId id);

  /**
   * Queries the verification result by sending the verification Reference. With this query you can
   * get the result of a verification
   *
   * @param reference The custom reference of the verification
   * @return Verification status response
   * @since 1.0
   * @deprecated use {@link
   *     com.sinch.sdk.domains.verification.api.v1.VerificationStatusService#getByReference(String)}
   *     instead.
   */
  @Deprecated
  VerificationStatus getByReference(VerificationReference reference);
}
