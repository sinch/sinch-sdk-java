package com.sinch.sdk.domains.sms.models.v1.batches.request;

import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

public class DryRunQueryParametersImpl implements DryRunQueryParameters {

  private final OptionalValue<Boolean> perRecipient;
  private final OptionalValue<Integer> numberOfRecipients;

  private DryRunQueryParametersImpl(
      OptionalValue<Boolean> perRecipient, OptionalValue<Integer> numberOfRecipients) {
    this.perRecipient = perRecipient;
    this.numberOfRecipients = numberOfRecipients;
  }

  public OptionalValue<Boolean> getPerRecipient() {
    return perRecipient;
  }

  public OptionalValue<Integer> getNumberOfRecipients() {
    return numberOfRecipients;
  }

  /** Return true if this DryRunQueryParameters object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DryRunQueryParametersImpl dryRunQueryParameters = (DryRunQueryParametersImpl) o;
    return Objects.equals(this.perRecipient, dryRunQueryParameters.perRecipient)
        && Objects.equals(this.numberOfRecipients, dryRunQueryParameters.numberOfRecipients);
  }

  @Override
  public int hashCode() {
    return Objects.hash(perRecipient, numberOfRecipients);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DryRunQueryParametersImpl {\n");
    sb.append("    perRecipient: ").append(toIndentedString(perRecipient)).append("\n");
    sb.append("    numberOfRecipients: ").append(toIndentedString(numberOfRecipients)).append("\n");
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

  static class Builder implements DryRunQueryParameters.Builder {
    OptionalValue<Boolean> perRecipient = OptionalValue.empty();
    OptionalValue<Integer> numberOfRecipients = OptionalValue.empty();

    protected Builder() {}

    protected Builder(DryRunQueryParameters _parameters) {
      if (null == _parameters) {
        return;
      }
      DryRunQueryParametersImpl parameters = (DryRunQueryParametersImpl) _parameters;
      this.perRecipient = parameters.getPerRecipient();
      this.numberOfRecipients = parameters.getNumberOfRecipients();
    }

    public Builder setPerRecipient(Boolean perRecipient) {
      this.perRecipient = OptionalValue.of(perRecipient);
      return this;
    }

    public Builder setNumberOfRecipients(Integer numberOfRecipients) {
      this.numberOfRecipients = OptionalValue.of(numberOfRecipients);
      return this;
    }

    public DryRunQueryParameters build() {
      return new DryRunQueryParametersImpl(perRecipient, numberOfRecipients);
    }
  }
}
