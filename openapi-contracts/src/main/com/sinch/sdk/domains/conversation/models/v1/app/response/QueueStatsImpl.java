package com.sinch.sdk.domains.conversation.models.v1.app.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  QueueStatsImpl.JSON_PROPERTY_OUTBOUND_SIZE,
  QueueStatsImpl.JSON_PROPERTY_OUTBOUND_LIMIT
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class QueueStatsImpl implements QueueStats {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_OUTBOUND_SIZE = "outbound_size";

  private OptionalValue<Long> outboundSize;

  public static final String JSON_PROPERTY_OUTBOUND_LIMIT = "outbound_limit";

  private OptionalValue<Long> outboundLimit;

  public QueueStatsImpl() {}

  protected QueueStatsImpl(OptionalValue<Long> outboundSize, OptionalValue<Long> outboundLimit) {
    this.outboundSize = outboundSize;
    this.outboundLimit = outboundLimit;
  }

  @JsonIgnore
  public Long getOutboundSize() {
    return outboundSize.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_OUTBOUND_SIZE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Long> outboundSize() {
    return outboundSize;
  }

  @JsonIgnore
  public Long getOutboundLimit() {
    return outboundLimit.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_OUTBOUND_LIMIT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Long> outboundLimit() {
    return outboundLimit;
  }

  /** Return true if this QueueStats object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    QueueStatsImpl queueStats = (QueueStatsImpl) o;
    return Objects.equals(this.outboundSize, queueStats.outboundSize)
        && Objects.equals(this.outboundLimit, queueStats.outboundLimit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(outboundSize, outboundLimit);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QueueStatsImpl {\n");
    sb.append("    outboundSize: ").append(toIndentedString(outboundSize)).append("\n");
    sb.append("    outboundLimit: ").append(toIndentedString(outboundLimit)).append("\n");
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
  static class Builder implements QueueStats.Builder {
    OptionalValue<Long> outboundSize = OptionalValue.empty();
    OptionalValue<Long> outboundLimit = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_OUTBOUND_SIZE)
    public Builder setOutboundSize(Long outboundSize) {
      this.outboundSize = OptionalValue.of(outboundSize);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_OUTBOUND_LIMIT)
    public Builder setOutboundLimit(Long outboundLimit) {
      this.outboundLimit = OptionalValue.of(outboundLimit);
      return this;
    }

    public QueueStats build() {
      return new QueueStatsImpl(outboundSize, outboundLimit);
    }
  }
}
