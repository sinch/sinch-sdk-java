package conversation;

import com.sinch.sdk.domains.conversation.api.v1.ConversationService;

public class ConversationQuickStart {

  private final ConversationService conversationService;

  public ConversationQuickStart(ConversationService conversationService) {
    this.conversationService = conversationService;

    // replace by your code and business logic
    Snippet.execute(this.conversationService);
  }
}
