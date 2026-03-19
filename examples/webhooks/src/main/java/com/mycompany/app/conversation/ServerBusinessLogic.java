package com.mycompany.app.conversation;

import com.sinch.sdk.domains.conversation.models.v1.sinchevents.capability.CapabilityEvent;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.channel.ChannelEvent;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.contact.ContactCreateEvent;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.contact.ContactDeleteEvent;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.contact.ContactIdentitiesDuplicationEvent;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.contact.ContactMergeEvent;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.contact.ContactUpdateEvent;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.conversation.ConversationDeleteEvent;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.conversation.ConversationStartEvent;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.conversation.ConversationStopEvent;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.delivery.EventDeliveryReceiptEvent;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.delivery.MessageDeliveryReceiptEvent;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.inbound.InboundEvent;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.message.MessageInboundEvent;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.message.MessageSubmitEvent;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.opting.OptInEvent;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.opting.OptOutEvent;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.record.RecordNotificationEvent;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.smartconversations.MessageInboundSmartConversationRedactionEvent;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.smartconversations.SmartConversationsEvent;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.unsupported.UnsupportedCallbackEvent;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;

@Component("ConversationServerBusinessLogic")
public class ServerBusinessLogic {

  private static final Logger LOGGER = Logger.getLogger(ServerBusinessLogic.class.getName());

  public void handleCapabilityEvent(CapabilityEvent event) {

    LOGGER.info("Handle event: " + event);
  }

  public void handleChannelEvent(ChannelEvent event) {

    LOGGER.info("Handle event: " + event);
  }

  public void handleContactCreateEvent(ContactCreateEvent event) {

    LOGGER.info("Handle event: " + event);
  }

  public void handleContactDeleteEvent(ContactDeleteEvent event) {

    LOGGER.info("Handle event: " + event);
  }

  public void handleContactIdentitiesDuplicationEvent(ContactIdentitiesDuplicationEvent event) {

    LOGGER.info("Handle event: " + event);
  }

  public void handleContactMergeEvent(ContactMergeEvent event) {

    LOGGER.info("Handle event: " + event);
  }

  public void handleContactUpdateEvent(ContactUpdateEvent event) {

    LOGGER.info("Handle event: " + event);
  }

  public void handleConversationDeleteEvent(ConversationDeleteEvent event) {

    LOGGER.info("Handle event: " + event);
  }

  public void handleConversationStartEvent(ConversationStartEvent event) {

    LOGGER.info("Handle event: " + event);
  }

  public void handleConversationStopEvent(ConversationStopEvent event) {

    LOGGER.info("Handle event: " + event);
  }

  public void handleEventDeliveryReceiptEvent(EventDeliveryReceiptEvent event) {

    LOGGER.info("Handle event: " + event);
  }

  public void handleInboundEvent(InboundEvent event) {

    LOGGER.info("Handle event: " + event);
  }

  public void handleMessageDeliveryReceiptEvent(MessageDeliveryReceiptEvent event) {

    LOGGER.info("Handle event: " + event);
  }

  public void handleMessageInboundEvent(MessageInboundEvent event) {

    LOGGER.info("Handle event: " + event);
  }

  public void handleMessageInboundSmartConversationRedactionEvent(
      MessageInboundSmartConversationRedactionEvent event) {

    LOGGER.info("Handle event: " + event);
  }

  public void handleMessageSubmitEvent(MessageSubmitEvent event) {

    LOGGER.info("Handle event: " + event);
  }

  public void handleOptInEvent(OptInEvent event) {

    LOGGER.info("Handle event: " + event);
  }

  public void handleOptOutEvent(OptOutEvent event) {

    LOGGER.info("Handle event: " + event);
  }

  public void handleRecordNotificationEvent(RecordNotificationEvent event) {

    LOGGER.info("Handle event: " + event);
  }

  public void handleSmartConversationsEvent(SmartConversationsEvent event) {

    LOGGER.info("Handle event: " + event);
  }

  public void handleUnsupportedCallbackEvent(UnsupportedCallbackEvent event) {

    LOGGER.info("Handle event: " + event);
  }
}
