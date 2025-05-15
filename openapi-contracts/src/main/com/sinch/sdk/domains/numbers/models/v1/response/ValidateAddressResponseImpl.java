package com.sinch.sdk.domains.numbers.models.v1.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.numbers.models.v1.EmergencyAddress;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  ValidateAddressResponseImpl.JSON_PROPERTY_PHONE_NUMBER,
  ValidateAddressResponseImpl.JSON_PROPERTY_DISPLAY_NAME,
  ValidateAddressResponseImpl.JSON_PROPERTY_VALIDATED_ADDRESS,
  ValidateAddressResponseImpl.JSON_PROPERTY_VALIDATION_RESULT,
  ValidateAddressResponseImpl.JSON_PROPERTY_VALIDATION_MESSAGE,
  ValidateAddressResponseImpl.JSON_PROPERTY_CORRECTED_ADDRESS,
  ValidateAddressResponseImpl.JSON_PROPERTY_CANDIDATE_ADDRESSES
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ValidateAddressResponseImpl implements ValidateAddressResponse {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_PHONE_NUMBER = "phoneNumber";

  private OptionalValue<String> phoneNumber;

  public static final String JSON_PROPERTY_DISPLAY_NAME = "displayName";

  private OptionalValue<String> displayName;

  public static final String JSON_PROPERTY_VALIDATED_ADDRESS = "validatedAddress";

  private OptionalValue<EmergencyAddress> validatedAddress;

  public static final String JSON_PROPERTY_VALIDATION_RESULT = "validationResult";

  private OptionalValue<AddressValidationResultCode> validationResult;

  public static final String JSON_PROPERTY_VALIDATION_MESSAGE = "validationMessage";

  private OptionalValue<String> validationMessage;

  public static final String JSON_PROPERTY_CORRECTED_ADDRESS = "correctedAddress";

  private OptionalValue<EmergencyAddress> correctedAddress;

  public static final String JSON_PROPERTY_CANDIDATE_ADDRESSES = "candidateAddresses";

  private OptionalValue<List<EmergencyAddress>> candidateAddresses;

  public ValidateAddressResponseImpl() {}

  protected ValidateAddressResponseImpl(
      OptionalValue<String> phoneNumber,
      OptionalValue<String> displayName,
      OptionalValue<EmergencyAddress> validatedAddress,
      OptionalValue<AddressValidationResultCode> validationResult,
      OptionalValue<String> validationMessage,
      OptionalValue<EmergencyAddress> correctedAddress,
      OptionalValue<List<EmergencyAddress>> candidateAddresses) {
    this.phoneNumber = phoneNumber;
    this.displayName = displayName;
    this.validatedAddress = validatedAddress;
    this.validationResult = validationResult;
    this.validationMessage = validationMessage;
    this.correctedAddress = correctedAddress;
    this.candidateAddresses = candidateAddresses;
  }

  @JsonIgnore
  public String getPhoneNumber() {
    return phoneNumber.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PHONE_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> phoneNumber() {
    return phoneNumber;
  }

  @JsonIgnore
  public String getDisplayName() {
    return displayName.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> displayName() {
    return displayName;
  }

  @JsonIgnore
  public EmergencyAddress getValidatedAddress() {
    return validatedAddress.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_VALIDATED_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<EmergencyAddress> validatedAddress() {
    return validatedAddress;
  }

  @JsonIgnore
  public AddressValidationResultCode getValidationResult() {
    return validationResult.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_VALIDATION_RESULT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<AddressValidationResultCode> validationResult() {
    return validationResult;
  }

  @JsonIgnore
  public String getValidationMessage() {
    return validationMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_VALIDATION_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> validationMessage() {
    return validationMessage;
  }

  @JsonIgnore
  public EmergencyAddress getCorrectedAddress() {
    return correctedAddress.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CORRECTED_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<EmergencyAddress> correctedAddress() {
    return correctedAddress;
  }

  @JsonIgnore
  public List<EmergencyAddress> getCandidateAddresses() {
    return candidateAddresses.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CANDIDATE_ADDRESSES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<EmergencyAddress>> candidateAddresses() {
    return candidateAddresses;
  }

  /** Return true if this ValidateAddressResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ValidateAddressResponseImpl validateAddressResponse = (ValidateAddressResponseImpl) o;
    return Objects.equals(this.phoneNumber, validateAddressResponse.phoneNumber)
        && Objects.equals(this.displayName, validateAddressResponse.displayName)
        && Objects.equals(this.validatedAddress, validateAddressResponse.validatedAddress)
        && Objects.equals(this.validationResult, validateAddressResponse.validationResult)
        && Objects.equals(this.validationMessage, validateAddressResponse.validationMessage)
        && Objects.equals(this.correctedAddress, validateAddressResponse.correctedAddress)
        && Objects.equals(this.candidateAddresses, validateAddressResponse.candidateAddresses);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        phoneNumber,
        displayName,
        validatedAddress,
        validationResult,
        validationMessage,
        correctedAddress,
        candidateAddresses);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ValidateAddressResponseImpl {\n");
    sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    validatedAddress: ").append(toIndentedString(validatedAddress)).append("\n");
    sb.append("    validationResult: ").append(toIndentedString(validationResult)).append("\n");
    sb.append("    validationMessage: ").append(toIndentedString(validationMessage)).append("\n");
    sb.append("    correctedAddress: ").append(toIndentedString(correctedAddress)).append("\n");
    sb.append("    candidateAddresses: ").append(toIndentedString(candidateAddresses)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  @JsonPOJOBuilder(withPrefix = "set")
  static class Builder implements ValidateAddressResponse.Builder {
    OptionalValue<String> phoneNumber = OptionalValue.empty();
    OptionalValue<String> displayName = OptionalValue.empty();
    OptionalValue<EmergencyAddress> validatedAddress = OptionalValue.empty();
    OptionalValue<AddressValidationResultCode> validationResult = OptionalValue.empty();
    OptionalValue<String> validationMessage = OptionalValue.empty();
    OptionalValue<EmergencyAddress> correctedAddress = OptionalValue.empty();
    OptionalValue<List<EmergencyAddress>> candidateAddresses = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_PHONE_NUMBER)
    public Builder setPhoneNumber(String phoneNumber) {
      this.phoneNumber = OptionalValue.of(phoneNumber);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
    public Builder setDisplayName(String displayName) {
      this.displayName = OptionalValue.of(displayName);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_VALIDATED_ADDRESS)
    public Builder setValidatedAddress(EmergencyAddress validatedAddress) {
      this.validatedAddress = OptionalValue.of(validatedAddress);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_VALIDATION_RESULT)
    public Builder setValidationResult(AddressValidationResultCode validationResult) {
      this.validationResult = OptionalValue.of(validationResult);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_VALIDATION_MESSAGE)
    public Builder setValidationMessage(String validationMessage) {
      this.validationMessage = OptionalValue.of(validationMessage);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CORRECTED_ADDRESS)
    public Builder setCorrectedAddress(EmergencyAddress correctedAddress) {
      this.correctedAddress = OptionalValue.of(correctedAddress);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CANDIDATE_ADDRESSES)
    public Builder setCandidateAddresses(List<EmergencyAddress> candidateAddresses) {
      this.candidateAddresses = OptionalValue.of(candidateAddresses);
      return this;
    }

    public ValidateAddressResponse build() {
      return new ValidateAddressResponseImpl(
          phoneNumber,
          displayName,
          validatedAddress,
          validationResult,
          validationMessage,
          correctedAddress,
          candidateAddresses);
    }
  }
}
