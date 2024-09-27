package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.nfmreply;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  WhatsAppInteractiveNfmReplyChannelSpecificContactMessageImpl.JSON_PROPERTY_TYPE,
  WhatsAppInteractiveNfmReplyChannelSpecificContactMessageImpl.JSON_PROPERTY_NFM_REPLY
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class WhatsAppInteractiveNfmReplyChannelSpecificContactMessageImpl
    implements WhatsAppInteractiveNfmReplyChannelSpecificContactMessage,
        com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific
            .ChannelSpecificContactMessageContent {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<TypeEnum> type;

  public static final String JSON_PROPERTY_NFM_REPLY = "nfm_reply";

  private OptionalValue<WhatsAppInteractiveNfmReply> nfmReply;

  public WhatsAppInteractiveNfmReplyChannelSpecificContactMessageImpl() {}

  protected WhatsAppInteractiveNfmReplyChannelSpecificContactMessageImpl(
      OptionalValue<TypeEnum> type, OptionalValue<WhatsAppInteractiveNfmReply> nfmReply) {
    this.type = type;
    this.nfmReply = nfmReply;
  }

  @JsonIgnore
  public TypeEnum getType() {
    return type.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<TypeEnum> type() {
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

  /**
   * Return true if this WhatsAppInteractiveNfmReplyChannelSpecificContactMessage object is equal to
   * o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WhatsAppInteractiveNfmReplyChannelSpecificContactMessageImpl
        whatsAppInteractiveNfmReplyChannelSpecificContactMessage =
            (WhatsAppInteractiveNfmReplyChannelSpecificContactMessageImpl) o;
    return Objects.equals(this.type, whatsAppInteractiveNfmReplyChannelSpecificContactMessage.type)
        && Objects.equals(
            this.nfmReply, whatsAppInteractiveNfmReplyChannelSpecificContactMessage.nfmReply);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, nfmReply);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WhatsAppInteractiveNfmReplyChannelSpecificContactMessageImpl {\n");
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
  static class Builder implements WhatsAppInteractiveNfmReplyChannelSpecificContactMessage.Builder {
    OptionalValue<TypeEnum> type =
        OptionalValue.of(
            WhatsAppInteractiveNfmReplyChannelSpecificContactMessage.TypeEnum.NFM_REPLY);
    OptionalValue<WhatsAppInteractiveNfmReply> nfmReply = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_NFM_REPLY)
    public Builder setNfmReply(WhatsAppInteractiveNfmReply nfmReply) {
      this.nfmReply = OptionalValue.of(nfmReply);
      return this;
    }

    public WhatsAppInteractiveNfmReplyChannelSpecificContactMessage build() {
      return new WhatsAppInteractiveNfmReplyChannelSpecificContactMessageImpl(type, nfmReply);
    }
  }
}
