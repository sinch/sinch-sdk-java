package com.sinch.sdk.domains.voice.models.v2.batches.request;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlCommand;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonPropertyOrder({
  StartBatchRequestImpl.JSON_PROPERTY_COMMANDS,
  StartBatchRequestImpl.JSON_PROPERTY_PARAMETERS,
  StartBatchRequestImpl.JSON_PROPERTY_BATCH_OPTIONS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class StartBatchRequestImpl implements StartBatchRequest {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_COMMANDS = "commands";

  private OptionalValue<List<SvamlCommand>> commands;

  public static final String JSON_PROPERTY_PARAMETERS = "parameters";

  private OptionalValue<List<Map<String, String>>> parameters;

  public static final String JSON_PROPERTY_BATCH_OPTIONS = "batchOptions";

  private OptionalValue<BatchOptions> batchOptions;

  private OptionalValue<String> idempotencyKey;

  public StartBatchRequestImpl() {}

  protected StartBatchRequestImpl(
      OptionalValue<List<SvamlCommand>> commands,
      OptionalValue<List<Map<String, String>>> parameters,
      OptionalValue<BatchOptions> batchOptions,
      OptionalValue<String> idempotencyKey) {
    this.commands = commands;
    this.parameters = parameters;
    this.batchOptions = batchOptions;
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
  public List<Map<String, String>> getParameters() {
    return parameters.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PARAMETERS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<List<Map<String, String>>> parameters() {
    return parameters;
  }

  @JsonIgnore
  public BatchOptions getBatchOptions() {
    return batchOptions.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_BATCH_OPTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<BatchOptions> batchOptions() {
    return batchOptions;
  }

  @JsonIgnore
  public String getIdempotencyKey() {
    return idempotencyKey.orElse(null);
  }

  @JsonIgnore
  public OptionalValue<String> idempotencyKey() {
    return idempotencyKey;
  }

  /** Return true if this StartBatchRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StartBatchRequestImpl startBatchRequest = (StartBatchRequestImpl) o;
    return Objects.equals(this.commands, startBatchRequest.commands)
        && Objects.equals(this.parameters, startBatchRequest.parameters)
        && Objects.equals(this.batchOptions, startBatchRequest.batchOptions)
        && Objects.equals(this.idempotencyKey, startBatchRequest.idempotencyKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(commands, parameters, batchOptions, idempotencyKey);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StartBatchRequestImpl {\n");
    sb.append("    commands: ").append(toIndentedString(commands)).append("\n");
    sb.append("    parameters: ").append(toIndentedString(parameters)).append("\n");
    sb.append("    batchOptions: ").append(toIndentedString(batchOptions)).append("\n");
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
  static class Builder implements StartBatchRequest.Builder {
    OptionalValue<List<SvamlCommand>> commands = OptionalValue.empty();
    OptionalValue<List<Map<String, String>>> parameters = OptionalValue.empty();
    OptionalValue<BatchOptions> batchOptions = OptionalValue.empty();
    OptionalValue<String> idempotencyKey = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_COMMANDS, required = true)
    public Builder setCommands(List<SvamlCommand> commands) {
      this.commands = OptionalValue.of(commands);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_PARAMETERS, required = true)
    public Builder setParameters(List<Map<String, String>> parameters) {
      this.parameters = OptionalValue.of(parameters);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_BATCH_OPTIONS)
    public Builder setBatchOptions(BatchOptions batchOptions) {
      this.batchOptions = OptionalValue.of(batchOptions);
      return this;
    }

    @JsonIgnore
    public Builder setIdempotencyKey(String idempotencyKey) {
      this.idempotencyKey = OptionalValue.of(idempotencyKey);
      return this;
    }

    public StartBatchRequest build() {
      return new StartBatchRequestImpl(commands, parameters, batchOptions, idempotencyKey);
    }
  }
}
