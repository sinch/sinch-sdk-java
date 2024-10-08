package com.sinch.sdk.domains.conversation.models.v1.messages.types.template;

import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.TemplateReference;
import com.sinch.sdk.domains.conversation.models.v1.messages.AppMessageBody;
import java.util.Map;

/** Template Message */
public interface TemplateMessage extends AppMessageBody {

  /**
   * Optional. Channel specific template reference with parameters per channel. The channel template
   * if exists overrides the omnichannel template. At least one of <code>channel_template</code> or
   * <code>omni_template</code> needs to be present. The key in the map must point to a valid
   * conversation channel as defined by the enum ConversationChannel.
   *
   * @return channelTemplate
   */
  Map<ConversationChannel, TemplateReference> getChannelTemplate();

  /**
   * Get omniTemplate
   *
   * @return omniTemplate
   */
  TemplateReference getOmniTemplate();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new TemplateMessageImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param channelTemplate see getter
     * @return Current builder
     * @see #getChannelTemplate
     */
    Builder setChannelTemplate(Map<ConversationChannel, TemplateReference> channelTemplate);

    /**
     * see getter
     *
     * @param omniTemplate see getter
     * @return Current builder
     * @see #getOmniTemplate
     */
    Builder setOmniTemplate(TemplateReference omniTemplate);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    TemplateMessage build();
  }
}
