package com.sinch.sdk.domains.voice.models.v2.calls.request;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlCommand;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({StartCallRequestImpl.JSON_PROPERTY_COMMANDS})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class StartCallRequestImpl implements StartCallRequest {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_COMMANDS = "commands";

  private OptionalValue<List<SvamlCommand>> commands;

  private OptionalValue<String> serviceId;

  private OptionalValue<String> idempotencyKey;

  public StartCallRequestImpl() {}

  protected StartCallRequestImpl(
      OptionalValue<List<SvamlCommand>> commands,
      OptionalValue<String> serviceId,
      OptionalValue<String> idempotencyKey) {
    this.commands = commands;
    this.serviceId = serviceId;
    this.idempotencyKey = idempotencyKey;
  }

  @JsonIgnore
  public List<SvamlCommand> getCommands() {
    return commands.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_COMMANDS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<List<SvamlCommand>> commands() {
    return commands;
  }

  @JsonIgnore
  public String getServiceId() {
    return serviceId.orElse(null);
  }

  @JsonIgnore
  public OptionalValue<String> serviceId() {
    return serviceId;
  }

  @JsonIgnore
  public String getIdempotencyKey() {
    return idempotencyKey.orElse(null);
  }

  @JsonIgnore
  public OptionalValue<String> idempotencyKey() {
    return idempotencyKey;
  }

  /** Return true if this StartCallRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StartCallRequestImpl startCallRequest = (StartCallRequestImpl) o;
    return Objects.equals(this.commands, startCallRequest.commands)
        && Objects.equals(this.serviceId, startCallRequest.serviceId)
        && Objects.equals(this.idempotencyKey, startCallRequest.idempotencyKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(commands, serviceId, idempotencyKey);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StartCallRequestImpl {\n");
    sb.append("    commands: ").append(toIndentedString(commands)).append("\n");
    sb.append("    serviceId: ").append(toIndentedString(serviceId)).append("\n");
    sb.append("    idempotencyKey: ").append(toIndentedString(idempotencyKey)).append("\n");
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
  static class Builder implements StartCallRequest.Builder {
    OptionalValue<List<SvamlCommand>> commands = OptionalValue.empty();
    OptionalValue<String> serviceId = OptionalValue.empty();
    OptionalValue<String> idempotencyKey = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_COMMANDS, required = true)
    public Builder setCommands(List<SvamlCommand> commands) {
      this.commands = OptionalValue.of(commands);
      return this;
    }

    @JsonIgnore
    public Builder setServiceId(String serviceId) {
      this.serviceId = OptionalValue.of(serviceId);
      return this;
    }

    @JsonIgnore
    public Builder setIdempotencyKey(String idempotencyKey) {
      this.idempotencyKey = OptionalValue.of(idempotencyKey);
      return this;
    }

    public StartCallRequest build() {
      return new StartCallRequestImpl(commands, serviceId, idempotencyKey);
    }
  }
}
