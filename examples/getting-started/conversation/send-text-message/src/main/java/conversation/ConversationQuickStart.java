package conversation;

import com.sinch.sdk.domains.conversation.api.v1.ConversationService;

public class ConversationQuickStart {

  private final ConversationService conversationService;

  public ConversationQuickStart(ConversationService conversationService) {
    this.conversationService = conversationService;

    // Insert your application logic or business process here
    Snippet.execute(this.conversationService);
  }
}
