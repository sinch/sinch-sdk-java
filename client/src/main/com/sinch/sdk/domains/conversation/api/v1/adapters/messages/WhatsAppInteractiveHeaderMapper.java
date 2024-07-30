package com.sinch.sdk.domains.conversation.api.v1.adapters.messages;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.conversation.models.v1.messages.internal.WhatsAppInteractiveDocumentHeaderInternal;
import com.sinch.sdk.domains.conversation.models.v1.messages.internal.WhatsAppInteractiveImageHeaderInternal;
import com.sinch.sdk.domains.conversation.models.v1.messages.internal.WhatsAppInteractiveTextHeaderInternal;
import com.sinch.sdk.domains.conversation.models.v1.messages.internal.WhatsAppInteractiveVideoHeaderInternal;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.flows.WhatsAppInteractiveHeader;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.flows.WhatsAppInteractiveHeaderDocument;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.flows.WhatsAppInteractiveHeaderImage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.flows.WhatsAppInteractiveHeaderText;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.flows.WhatsAppInteractiveHeaderVideo;
import java.io.IOException;
import java.util.logging.Logger;

public class WhatsAppInteractiveHeaderMapper extends StdSerializer<WhatsAppInteractiveHeader> {

  private static final Logger LOGGER =
      Logger.getLogger(WhatsAppInteractiveHeaderMapper.class.getName());

  public WhatsAppInteractiveHeaderMapper() {
    this(null);
  }

  public WhatsAppInteractiveHeaderMapper(Class<WhatsAppInteractiveHeader> t) {
    super(t);
  }

  public static void initMapper() {
    SimpleModule module = new SimpleModule();
    module.addSerializer(WhatsAppInteractiveHeader.class, new WhatsAppInteractiveHeaderMapper());
    Mapper.getInstance().registerModule(module);
  }

  @Override
  public void serialize(
      WhatsAppInteractiveHeader value, JsonGenerator jgen, SerializerProvider provider)
      throws IOException {

    Object internal = null;

    if (value instanceof WhatsAppInteractiveHeaderDocument) {
      internal =
          WhatsAppInteractiveDocumentHeaderInternal.builder()
              .setType(WhatsAppInteractiveDocumentHeaderInternal.TypeEnum.DOCUMENT)
              .setDocument(((WhatsAppInteractiveHeaderDocument) value).getMedia())
              .build();
    } else if (value instanceof WhatsAppInteractiveHeaderImage) {
      internal =
          WhatsAppInteractiveImageHeaderInternal.builder()
              .setType(WhatsAppInteractiveImageHeaderInternal.TypeEnum.IMAGE)
              .setImage(((WhatsAppInteractiveHeaderImage) value).getMedia())
              .build();
    } else if (value instanceof WhatsAppInteractiveHeaderText) {
      internal =
          WhatsAppInteractiveTextHeaderInternal.builder()
              .setType(WhatsAppInteractiveTextHeaderInternal.TypeEnum.TEXT)
              .setText(((WhatsAppInteractiveHeaderText) value).getText())
              .build();
    } else if (value instanceof WhatsAppInteractiveHeaderVideo) {
      internal =
          WhatsAppInteractiveVideoHeaderInternal.builder()
              .setType(WhatsAppInteractiveVideoHeaderInternal.TypeEnum.VIDEO)
              .setVideo(((WhatsAppInteractiveHeaderVideo) value).getMedia())
              .build();
    } else {
      LOGGER.severe("Unexpected class '" + value.getClass() + "'");
    }

    jgen.writeObject(internal);
  }
}
