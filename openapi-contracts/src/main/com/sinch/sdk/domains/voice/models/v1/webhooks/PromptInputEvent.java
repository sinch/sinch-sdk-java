/*
 * Voice API | Sinch
 *
 * OpenAPI document version: 1.0.1
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.voice.models.v1.webhooks;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.time.Instant;
import java.util.Arrays;
import java.util.stream.Stream;

/** The request body of a Prompt Input Event. */
@JsonDeserialize(builder = PromptInputEventImpl.Builder.class)
public interface PromptInputEvent extends VoiceWebhookEvent {

  /** Must have the value <code>pie</code>. */
  public class WebhooksEventRequestType extends EnumDynamic<String, WebhooksEventRequestType> {
    public static final WebhooksEventRequestType PIE = new WebhooksEventRequestType("pie");

    private static final EnumSupportDynamic<String, WebhooksEventRequestType> ENUM_SUPPORT =
        new EnumSupportDynamic<>(
            WebhooksEventRequestType.class, WebhooksEventRequestType::new, Arrays.asList(PIE));

    private WebhooksEventRequestType(String value) {
      super(value);
    }

    public static Stream<WebhooksEventRequestType> values() {
      return ENUM_SUPPORT.values();
    }

    public static WebhooksEventRequestType from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(WebhooksEventRequestType e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  /**
   * The timestamp in UTC format.
   *
   * @return timestamp
   */
  Instant getTimestamp();

  /**
   * Get menuResult
   *
   * @return menuResult
   */
  MenuResult getMenuResult();

  /**
   * A string that can be used to pass custom information related to the call.
   *
   * @return custom
   */
  String getCustom();

  /**
   * The unique application key. You can find it in the Sinch <a
   * href="https://dashboard.sinch.com/voice/apps">dashboard</a>.
   *
   * @return applicationKey
   */
  String getApplicationKey();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new PromptInputEventImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder extends VoiceWebhookEvent.Builder<Builder> {

    /**
     * see getter
     *
     * @param timestamp see getter
     * @return Current builder
     * @see #getTimestamp
     */
    Builder setTimestamp(Instant timestamp);

    /**
     * see getter
     *
     * @param menuResult see getter
     * @return Current builder
     * @see #getMenuResult
     */
    Builder setMenuResult(MenuResult menuResult);

    /**
     * see getter
     *
     * @param custom see getter
     * @return Current builder
     * @see #getCustom
     */
    Builder setCustom(String custom);

    /**
     * see getter
     *
     * @param applicationKey see getter
     * @return Current builder
     * @see #getApplicationKey
     */
    Builder setApplicationKey(String applicationKey);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    PromptInputEvent build();
  }
}