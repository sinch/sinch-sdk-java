package com.sinch.sdk.domains.voice.models.v2.svaml;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({MessageEventsImpl.JSON_PROPERTY_ON_FINISH})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class MessageEventsImpl implements MessageEvents {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ON_FINISH = "onFinish";

  private OptionalValue<List<SvamlCommand>> onFinish;

  public MessageEventsImpl() {}

  protected MessageEventsImpl(OptionalValue<List<SvamlCommand>> onFinish) {
    this.onFinish = onFinish;
  }

  @JsonIgnore
  public List<SvamlCommand> getOnFinish() {
    return onFinish.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ON_FINISH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<SvamlCommand>> onFinish() {
    return onFinish;
  }

  /** Return true if this MessageEvents object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MessageEventsImpl messageEvents = (MessageEventsImpl) o;
    return Objects.equals(this.onFinish, messageEvents.onFinish);
  }

  @Override
  public int hashCode() {
    return Objects.hash(onFinish);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MessageEventsImpl {\n");
    sb.append("    onFinish: ").append(toIndentedString(onFinish)).append("\n");
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
  static class Builder implements MessageEvents.Builder {
    OptionalValue<List<SvamlCommand>> onFinish = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_ON_FINISH)
    public Builder setOnFinish(List<SvamlCommand> onFinish) {
      this.onFinish = OptionalValue.of(onFinish);
      return this;
    }

    public MessageEvents build() {
      return new MessageEventsImpl(onFinish);
    }
  }
}
