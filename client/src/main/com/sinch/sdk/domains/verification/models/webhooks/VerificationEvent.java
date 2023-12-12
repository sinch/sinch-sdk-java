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

  /**
   * Base class for verification event
   *
   * @param id The ID of the verification request.
   * @param event The type of the event.
   * @param method The verification method
   * @param identity Specifies the type of endpoint that will be verified and the particular
   *     endpoint. number is currently the only supported endpoint type
   * @param reference The reference ID that was optionally passed together with the verification
   *     request
   * @param custom A custom string that can be provided during a verification request. see <a
   *     href="https://developers.sinch.com/docs/verification/api-reference/verification/tag/Verification-callbacks/">https://developers.sinch.com/docs/verification/api-reference/verification/tag/Verification-callbacks/</a>
   * @since 1.0
   */
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

  public VerificationId getId() {
    return id;
  }

  public String getEvent() {
    return event;
  }

  public VerificationMethodType getMethod() {
    return method;
  }

  public Identity getIdentity() {
    return identity;
  }

  public Optional<VerificationReference> getReference() {
    return Optional.ofNullable(reference);
  }

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
