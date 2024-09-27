package com.sinch.sdk.domains.conversation.api.v1;

import com.sinch.sdk.domains.conversation.models.v1.transcoding.request.TranscodeMessageRequest;
import com.sinch.sdk.domains.conversation.models.v1.transcoding.response.TranscodeMessageResponse;

/**
 * Service for working with transcoding
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/conversation/api-reference/conversation/tag/Transcoding">online
 *     documentation</a>
 * @since 1.3
 */
public interface TranscodingService {

  /**
   * Transcodes the message from the Conversation API format to the channel-specific formats for the
   * requested channels.
   *
   * <p>No message is sent to the contact.
   *
   * @param request The message to be transcoded, and the app and channels for which the message is
   *     to be transcoded
   * @return Transcoded message
   * @since 1.3
   */
  TranscodeMessageResponse transcodeMessage(TranscodeMessageRequest request);
}
