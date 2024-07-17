package com.sinch.sdk.domains.conversation.api.v1.adapters.messages;

import com.fasterxml.jackson.core.JsonGenerator;
import com.sinch.sdk.domains.conversation.models.v1.messages.CardMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.CarouselMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.ChoiceMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.ContactInfoMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.ListMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.LocationMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.MediaMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.OmniMessageOverride;
import com.sinch.sdk.domains.conversation.models.v1.messages.TextMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.internal.CardMessageFieldInternal;
import com.sinch.sdk.domains.conversation.models.v1.messages.internal.CarouselMessageFieldInternal;
import com.sinch.sdk.domains.conversation.models.v1.messages.internal.ChoiceMessageFieldInternal;
import com.sinch.sdk.domains.conversation.models.v1.messages.internal.ContactInfoMessageFieldInternal;
import com.sinch.sdk.domains.conversation.models.v1.messages.internal.ListMessageFieldInternal;
import com.sinch.sdk.domains.conversation.models.v1.messages.internal.OmniMessageOverrideInternalImpl;
import com.sinch.sdk.domains.conversation.models.v1.templates.TemplateReference;
import com.sinch.sdk.domains.conversation.models.v1.templates.internal.TemplateReferenceFieldInternal;
import java.io.IOException;
import java.util.logging.Logger;

public class OmniMessageOverrideMapper {

  private static final Logger LOGGER = Logger.getLogger(OmniMessageOverrideMapper.class.getName());

  // We cannot create a dedicated Mapper based onto "OmniMessageOverride" interface detection
  // 'OmniMessageOverride' interface is added to all fields supported by OmniMessageOverride
  // but if we serialize them in dedicated field (e.g. CardMessageFieldInternal for CardMessage );
  // it will contain
  // it own reference: then serialization will generate an infinite loop
  // We have a ticket tpo remove Jackson, dependency: it will be fine if we can fix it by homemade
  // implementation
  // So currently: just a helper to be called from an upper level

  public static void serialize(OmniMessageOverride value, JsonGenerator jgen) throws IOException {

    Object field = null;
    if (value instanceof CardMessage) {
      field = CardMessageFieldInternal.builder().setCardMessage((CardMessage) value).build();
    } else if (value instanceof CarouselMessage) {
      field =
          CarouselMessageFieldInternal.builder()
              .setCarouselMessage((CarouselMessage) value)
              .build();
    } else if (value instanceof ChoiceMessage) {
      field = ChoiceMessageFieldInternal.builder().setChoiceMessage((ChoiceMessage) value).build();
    } else if (value instanceof ContactInfoMessage) {
      field =
          ContactInfoMessageFieldInternal.builder()
              .setContactInfoMessage((ContactInfoMessage) value)
              .build();
    } else if (value instanceof ListMessage) {
      field = ListMessageFieldInternal.builder().setListMessage((ListMessage) value).build();
    } else if (value instanceof LocationMessage) {
      field = value;
    } else if (value instanceof MediaMessage) {
      field = value;
    } else if (value instanceof TemplateReference) {
      field =
          TemplateReferenceFieldInternal.builder()
              .setTemplateReference((TemplateReference) value)
              .build();
    } else if (value instanceof TextMessage) {
      field = value;
    } else {
      LOGGER.severe("Unexpected class '" + value.getClass() + "'");
    }

    OmniMessageOverrideInternalImpl internal = new OmniMessageOverrideInternalImpl();
    internal.setActualInstance(field);

    jgen.writeObject(internal);
  }
}
