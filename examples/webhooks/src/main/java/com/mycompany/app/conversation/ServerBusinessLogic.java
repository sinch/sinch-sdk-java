package com.mycompany.app.conversation;

import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.capability.CapabilityEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.channel.ChannelEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.contact.ContactCreateEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.contact.ContactDeleteEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.contact.ContactIdentitiesDuplicationEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.contact.ContactMergeEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.contact.ContactUpdateEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.conversation.ConversationDeleteEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.conversation.ConversationStartEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.conversation.ConversationStopEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.delivery.EventDeliveryReceiptEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.delivery.MessageDeliveryReceiptEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.inbound.InboundEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.message.MessageInboundEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.message.MessageSubmitEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.opting.OptInEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.opting.OptOutEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.record.RecordNotificationEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.smartconversations.MessageInboundSmartConversationRedactionEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.smartconversations.SmartConversationsEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.unsupported.UnsupportedCallbackEvent;
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
