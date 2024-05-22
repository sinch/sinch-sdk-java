package com.sinch.sdk.domains.verification.models.webhooks;

import com.sinch.sdk.domains.verification.models.Identity;
import com.sinch.sdk.domains.verification.models.NumberIdentity;
import com.sinch.sdk.domains.verification.models.VerificationId;
import com.sinch.sdk.domains.verification.models.VerificationMethodType;
import com.sinch.sdk.domains.verification.models.VerificationReference;
import java.util.Optional;

/**
 * Base class for received Verification Events onto webhooks callback
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/verification/api-reference/verification/tag/Verification-callbacks">https://developers.sinch.com/docs/verification/api-reference/verification/tag/Verification-callbacks</a>
 */
public class VerificationEvent {
  private final VerificationId id;
  private final VerificationMethodType method;
  private final Identity identity;
  private final VerificationReference reference;
  private final String custom;

  public VerificationEvent(
      String id,
      VerificationMethodType method,
      Identity identity,
      VerificationReference reference,
      String custom) {
    this.id = VerificationId.valueOf(id);
    this.method = method;
    this.identity = identity;
    this.reference = reference;
    this.custom = custom;
  }

  /**
   * The ID of the verification request.
   *
   * @return Id value
   * @since 1.0
   */
  public VerificationId getId() {
    return id;
  }

  /**
   * The verification method
   *
   * @return The method value
   * @since 1.0
   */
  public VerificationMethodType getMethod() {
    return method;
  }

  /**
   * Specifies the type of endpoint that will be verified and the particular endpoint. {@link
   * NumberIdentity} is currently the only supported endpoint type
   *
   * @return identity
   * @since 1.0
   */
  public Identity getIdentity() {
    return identity;
  }

  /**
   * The reference that was optionally passed together with the verification request
   *
   * @return Reference value
   * @since 1.0
   */
  public Optional<VerificationReference> getReference() {
    return Optional.ofNullable(reference);
  }

  /**
   * A custom string that can be provided during a verification request
   *
   * @return The custom value
   * @since 1.0
   */
  public Optional<String> getCustom() {
    return Optional.ofNullable(custom);
  }

  @Override
  public String toString() {
    return "VerificationEvent{"
        + "id="
        + id
        + ", method="
        + method
        + ", identity="
        + identity
        + ", reference="
        + reference
        + ", custom='"
        + custom
        + '\''
        + '}';
  }
}
