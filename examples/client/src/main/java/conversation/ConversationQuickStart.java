package conversation;

import com.sinch.sdk.domains.conversation.api.v1.ConversationService;
import java.util.logging.Logger;

public class ConversationQuickStart {

  private static final Logger LOGGER = Logger.getLogger(ConversationQuickStart.class.getName());

  private final ConversationService conversationService;

  public ConversationQuickStart(ConversationService conversationService) {
    this.conversationService = conversationService;

    // Insert your application logic or business process here
    LOGGER.info("Snippet execution");
  }
}
