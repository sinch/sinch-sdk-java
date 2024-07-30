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
  FlowChannelSpecificMessageImpl.JSON_PROPERTY_HEADER,
  FlowChannelSpecificMessageImpl.JSON_PROPERTY_BODY,
  FlowChannelSpecificMessageImpl.JSON_PROPERTY_FOOTER,
  FlowChannelSpecificMessageImpl.JSON_PROPERTY_FLOW_ID,
  FlowChannelSpecificMessageImpl.JSON_PROPERTY_FLOW_TOKEN,
  FlowChannelSpecificMessageImpl.JSON_PROPERTY_FLOW_MODE,
  FlowChannelSpecificMessageImpl.JSON_PROPERTY_FLOW_CTA,
  FlowChannelSpecificMessageImpl.JSON_PROPERTY_FLOW_ACTION,
  FlowChannelSpecificMessageImpl.JSON_PROPERTY_FLOW_ACTION_PAYLOAD
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class FlowChannelSpecificMessageImpl
    implements FlowChannelSpecificMessage,
        com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific
            .ChannelSpecificMessage {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_HEADER = "header";

  private OptionalValue<FlowChannelSpecificMessageHeader> header;

  public static final String JSON_PROPERTY_BODY = "body";

  private OptionalValue<WhatsAppInteractiveBody> body;

  public static final String JSON_PROPERTY_FOOTER = "footer";

  private OptionalValue<WhatsAppInteractiveFooter> footer;

  public static final String JSON_PROPERTY_FLOW_ID = "flow_id";

  private OptionalValue<String> flowId;

  public static final String JSON_PROPERTY_FLOW_TOKEN = "flow_token";

  private OptionalValue<String> flowToken;

  public static final String JSON_PROPERTY_FLOW_MODE = "flow_mode";

  private OptionalValue<FlowModeEnum> flowMode;

  public static final String JSON_PROPERTY_FLOW_CTA = "flow_cta";

  private OptionalValue<String> flowCta;

  public static final String JSON_PROPERTY_FLOW_ACTION = "flow_action";

  private OptionalValue<FlowActionEnum> flowAction;

  public static final String JSON_PROPERTY_FLOW_ACTION_PAYLOAD = "flow_action_payload";

  private OptionalValue<FlowChannelSpecificMessageFlowActionPayload> flowActionPayload;

  public FlowChannelSpecificMessageImpl() {}

  protected FlowChannelSpecificMessageImpl(
      OptionalValue<FlowChannelSpecificMessageHeader> header,
      OptionalValue<WhatsAppInteractiveBody> body,
      OptionalValue<WhatsAppInteractiveFooter> footer,
      OptionalValue<String> flowId,
      OptionalValue<String> flowToken,
      OptionalValue<FlowModeEnum> flowMode,
      OptionalValue<String> flowCta,
      OptionalValue<FlowActionEnum> flowAction,
      OptionalValue<FlowChannelSpecificMessageFlowActionPayload> flowActionPayload) {
    this.header = header;
    this.body = body;
    this.footer = footer;
    this.flowId = flowId;
    this.flowToken = flowToken;
    this.flowMode = flowMode;
    this.flowCta = flowCta;
    this.flowAction = flowAction;
    this.flowActionPayload = flowActionPayload;
  }

  @JsonIgnore
  public FlowChannelSpecificMessageHeader getHeader() {
    return header.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_HEADER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<FlowChannelSpecificMessageHeader> header() {
    return header;
  }

  @JsonIgnore
  public WhatsAppInteractiveBody getBody() {
    return body.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_BODY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<WhatsAppInteractiveBody> body() {
    return body;
  }

  @JsonIgnore
  public WhatsAppInteractiveFooter getFooter() {
    return footer.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FOOTER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<WhatsAppInteractiveFooter> footer() {
    return footer;
  }

  @JsonIgnore
  public String getFlowId() {
    return flowId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FLOW_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> flowId() {
    return flowId;
  }

  @JsonIgnore
  public String getFlowToken() {
    return flowToken.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FLOW_TOKEN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> flowToken() {
    return flowToken;
  }

  @JsonIgnore
  public FlowModeEnum getFlowMode() {
    return flowMode.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FLOW_MODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<FlowModeEnum> flowMode() {
    return flowMode;
  }

  @JsonIgnore
  public String getFlowCta() {
    return flowCta.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FLOW_CTA)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> flowCta() {
    return flowCta;
  }

  @JsonIgnore
  public FlowActionEnum getFlowAction() {
    return flowAction.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FLOW_ACTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<FlowActionEnum> flowAction() {
    return flowAction;
  }

  @JsonIgnore
  public FlowChannelSpecificMessageFlowActionPayload getFlowActionPayload() {
    return flowActionPayload.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FLOW_ACTION_PAYLOAD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<FlowChannelSpecificMessageFlowActionPayload> flowActionPayload() {
    return flowActionPayload;
  }

  /** Return true if this FlowChannelSpecificMessage object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FlowChannelSpecificMessageImpl flowChannelSpecificMessage = (FlowChannelSpecificMessageImpl) o;
    return Objects.equals(this.header, flowChannelSpecificMessage.header)
        && Objects.equals(this.body, flowChannelSpecificMessage.body)
        && Objects.equals(this.footer, flowChannelSpecificMessage.footer)
        && Objects.equals(this.flowId, flowChannelSpecificMessage.flowId)
        && Objects.equals(this.flowToken, flowChannelSpecificMessage.flowToken)
        && Objects.equals(this.flowMode, flowChannelSpecificMessage.flowMode)
        && Objects.equals(this.flowCta, flowChannelSpecificMessage.flowCta)
        && Objects.equals(this.flowAction, flowChannelSpecificMessage.flowAction)
        && Objects.equals(this.flowActionPayload, flowChannelSpecificMessage.flowActionPayload);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        header, body, footer, flowId, flowToken, flowMode, flowCta, flowAction, flowActionPayload);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FlowChannelSpecificMessageImpl {\n");
    sb.append("    header: ").append(toIndentedString(header)).append("\n");
    sb.append("    body: ").append(toIndentedString(body)).append("\n");
    sb.append("    footer: ").append(toIndentedString(footer)).append("\n");
    sb.append("    flowId: ").append(toIndentedString(flowId)).append("\n");
    sb.append("    flowToken: ").append(toIndentedString(flowToken)).append("\n");
    sb.append("    flowMode: ").append(toIndentedString(flowMode)).append("\n");
    sb.append("    flowCta: ").append(toIndentedString(flowCta)).append("\n");
    sb.append("    flowAction: ").append(toIndentedString(flowAction)).append("\n");
    sb.append("    flowActionPayload: ").append(toIndentedString(flowActionPayload)).append("\n");
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
  static class Builder implements FlowChannelSpecificMessage.Builder {
    OptionalValue<FlowChannelSpecificMessageHeader> header = OptionalValue.empty();
    OptionalValue<WhatsAppInteractiveBody> body = OptionalValue.empty();
    OptionalValue<WhatsAppInteractiveFooter> footer = OptionalValue.empty();
    OptionalValue<String> flowId = OptionalValue.empty();
    OptionalValue<String> flowToken = OptionalValue.empty();
    OptionalValue<FlowModeEnum> flowMode = OptionalValue.empty();
    OptionalValue<String> flowCta = OptionalValue.empty();
    OptionalValue<FlowActionEnum> flowAction = OptionalValue.empty();
    OptionalValue<FlowChannelSpecificMessageFlowActionPayload> flowActionPayload =
        OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_HEADER)
    public Builder setHeader(FlowChannelSpecificMessageHeader header) {
      this.header = OptionalValue.of(header);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_BODY)
    public Builder setBody(WhatsAppInteractiveBody body) {
      this.body = OptionalValue.of(body);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_FOOTER)
    public Builder setFooter(WhatsAppInteractiveFooter footer) {
      this.footer = OptionalValue.of(footer);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_FLOW_ID)
    public Builder setFlowId(String flowId) {
      this.flowId = OptionalValue.of(flowId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_FLOW_TOKEN)
    public Builder setFlowToken(String flowToken) {
      this.flowToken = OptionalValue.of(flowToken);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_FLOW_MODE)
    public Builder setFlowMode(FlowModeEnum flowMode) {
      this.flowMode = OptionalValue.of(flowMode);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_FLOW_CTA)
    public Builder setFlowCta(String flowCta) {
      this.flowCta = OptionalValue.of(flowCta);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_FLOW_ACTION)
    public Builder setFlowAction(FlowActionEnum flowAction) {
      this.flowAction = OptionalValue.of(flowAction);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_FLOW_ACTION_PAYLOAD)
    public Builder setFlowActionPayload(
        FlowChannelSpecificMessageFlowActionPayload flowActionPayload) {
      this.flowActionPayload = OptionalValue.of(flowActionPayload);
      return this;
    }

    public FlowChannelSpecificMessage build() {
      return new FlowChannelSpecificMessageImpl(
          header,
          body,
          footer,
          flowId,
          flowToken,
          flowMode,
          flowCta,
          flowAction,
          flowActionPayload);
    }
  }
}
