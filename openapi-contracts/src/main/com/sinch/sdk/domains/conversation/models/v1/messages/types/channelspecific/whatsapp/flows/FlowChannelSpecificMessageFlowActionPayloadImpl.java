package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.flows;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  FlowChannelSpecificMessageFlowActionPayloadImpl.JSON_PROPERTY_SCREEN,
  FlowChannelSpecificMessageFlowActionPayloadImpl.JSON_PROPERTY_DATA
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class FlowChannelSpecificMessageFlowActionPayloadImpl
    implements FlowChannelSpecificMessageFlowActionPayload {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_SCREEN = "screen";

  private OptionalValue<String> screen;

  public static final String JSON_PROPERTY_DATA = "data";

  private OptionalValue<Object> data;

  public FlowChannelSpecificMessageFlowActionPayloadImpl() {}

  protected FlowChannelSpecificMessageFlowActionPayloadImpl(
      OptionalValue<String> screen, OptionalValue<Object> data) {
    this.screen = screen;
    this.data = data;
  }

  @JsonIgnore
  public String getScreen() {
    return screen.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SCREEN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> screen() {
    return screen;
  }

  @JsonIgnore
  public Object getData() {
    return data.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Object> data() {
    return data;
  }

  /**
   * Return true if this WhatsApp_Flow_channel_specific_message_flow_action_payload object is equal
   * to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FlowChannelSpecificMessageFlowActionPayloadImpl
        whatsAppFlowChannelSpecificMessageFlowActionPayload =
            (FlowChannelSpecificMessageFlowActionPayloadImpl) o;
    return Objects.equals(this.screen, whatsAppFlowChannelSpecificMessageFlowActionPayload.screen)
        && Objects.equals(this.data, whatsAppFlowChannelSpecificMessageFlowActionPayload.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(screen, data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FlowChannelSpecificMessageFlowActionPayloadImpl {\n");
    sb.append("    screen: ").append(toIndentedString(screen)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
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
  static class Builder implements FlowChannelSpecificMessageFlowActionPayload.Builder {
    OptionalValue<String> screen = OptionalValue.empty();
    OptionalValue<Object> data = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_SCREEN)
    public Builder setScreen(String screen) {
      this.screen = OptionalValue.of(screen);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DATA)
    public Builder setData(Object data) {
      this.data = OptionalValue.of(data);
      return this;
    }

    public FlowChannelSpecificMessageFlowActionPayload build() {
      return new FlowChannelSpecificMessageFlowActionPayloadImpl(screen, data);
    }
  }
}
