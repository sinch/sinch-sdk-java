package com.sinch.sdk.domains.verification.models.webhooks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
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
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    property = "event",
    visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = VerificationRequestEvent.class, name = "VerificationRequestEvent"),
  @JsonSubTypes.Type(value = VerificationResultEvent.class, name = "VerificationResultEvent")
})
public class VerificationEvent {
  private final VerificationId id;
  private final String event;
  private final VerificationMethodType method;
  private final Identity identity;
  private final VerificationReference reference;
  private final String custom;

  @JsonCreator
  VerificationEvent(
      @JsonProperty("id") String id,
      @JsonProperty("event") String event,
      @JsonProperty("method") String method,
      @JsonProperty("identity") jsonIdentity identity,
      @JsonProperty("reference") String reference,
      @JsonProperty("custom") String custom) {
    this.id = VerificationId.valueOf(id);
    this.event = event;
    this.method = VerificationMethodType.from(method);
    this.identity = NumberIdentity.builder().setEndpoint(identity.endpoint).build();
    if (null != reference) {
      this.reference = VerificationReference.valueOf(reference);
    } else {
      this.reference = null;
    }
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
   * The type of the event
   *
   * @return event value
   * @since 1.0
   */
  public String getEvent() {
    return event;
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
        + ", event='"
        + event
        + '\''
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

  static class jsonIdentity {
    String type;
    String endpoint;

    @JsonCreator
    public jsonIdentity(
        @JsonProperty("type") String type, @JsonProperty("endpoint") String endpoint) {
      this.type = type;
      this.endpoint = endpoint;
    }
  }
}
