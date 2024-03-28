package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  ChannelSpecificContactMessageMessageImpl.JSON_PROPERTY_TYPE,
  ChannelSpecificContactMessageMessageImpl.JSON_PROPERTY_NFM_REPLY
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ChannelSpecificContactMessageMessageImpl
    implements ChannelSpecificContactMessageMessage {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<String> type;

  public static final String JSON_PROPERTY_NFM_REPLY = "nfm_reply";

  private OptionalValue<WhatsAppInteractiveNfmReply> nfmReply;

  public ChannelSpecificContactMessageMessageImpl() {}

  protected ChannelSpecificContactMessageMessageImpl(
      OptionalValue<String> type, OptionalValue<WhatsAppInteractiveNfmReply> nfmReply) {
    this.type = type;
    this.nfmReply = nfmReply;
  }

  @JsonIgnore
  public String getType() {
    return type.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> type() {
    return type;
  }

  @JsonIgnore
  public WhatsAppInteractiveNfmReply getNfmReply() {
    return nfmReply.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NFM_REPLY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<WhatsAppInteractiveNfmReply> nfmReply() {
    return nfmReply;
  }

  /** Return true if this ChannelSpecificContactMessage_message object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChannelSpecificContactMessageMessageImpl channelSpecificContactMessageMessage =
        (ChannelSpecificContactMessageMessageImpl) o;
    return Objects.equals(this.type, channelSpecificContactMessageMessage.type)
        && Objects.equals(this.nfmReply, channelSpecificContactMessageMessage.nfmReply);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, nfmReply);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChannelSpecificContactMessageMessageImpl {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    nfmReply: ").append(toIndentedString(nfmReply)).append("\n");
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
  static class Builder implements ChannelSpecificContactMessageMessage.Builder {
    OptionalValue<String> type = OptionalValue.empty();
    OptionalValue<WhatsAppInteractiveNfmReply> nfmReply = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_TYPE)
    public Builder setType(String type) {
      this.type = OptionalValue.of(type);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_NFM_REPLY)
    public Builder setNfmReply(WhatsAppInteractiveNfmReply nfmReply) {
      this.nfmReply = OptionalValue.of(nfmReply);
      return this;
    }

    public ChannelSpecificContactMessageMessage build() {
      return new ChannelSpecificContactMessageMessageImpl(type, nfmReply);
    }
  }
}
