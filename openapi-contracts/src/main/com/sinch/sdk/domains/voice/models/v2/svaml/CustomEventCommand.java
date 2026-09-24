package com.sinch.sdk.domains.voice.models.v2.svaml;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Triggers a mid-call Custom Event: sends a Sinch Event request to <code>url</code> and executes
 * the SVAML commands returned in the response.
 *
 * <p>Sent on the wire as the <code>webhook</code> command.
 */
@JsonDeserialize(builder = CustomEventCommandImpl.Builder.class)
public interface CustomEventCommand extends SvamlCommand {

  /** The command property. Must have the value <code>webhook</code>. */
  public class CommandEnum extends EnumDynamic<String, CommandEnum> {
    /** The <code>webhook</code> command. */
    public static final CommandEnum WEBHOOK = new CommandEnum("webhook");

    private static final EnumSupportDynamic<String, CommandEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(CommandEnum.class, CommandEnum::new, Arrays.asList(WEBHOOK));

    private CommandEnum(String value) {
      super(value);
    }

    public static Stream<CommandEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static CommandEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(CommandEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  /**
   * Name for this Custom Event. When triggered, the Sinch Event request's <code>event</code>
   * property will contain this name prepended with <code>call.customEvent.</code>.
   *
   * <p>For example, if <code>customEventName</code> is set to <code>"my.custom.event"</code>, the
   * event will be delivered as <code>"call.customEvent.my.custom.event"</code>.
   *
   * <p>Field is required
   *
   * @return customEventName
   */
  String getCustomEventName();

  /**
   * URL of the endpoint to send the mid-call Sinch Event to.
   *
   * <p>Field is required
   *
   * @return url
   */
  String getUrl();

  /**
   * Fallback URL used when the primary URL fails.
   *
   * <p>A failed request is re-sent to this URL immediately. After repeated consecutive failures of
   * the primary URL, requests are sent only here until the primary URL recovers.
   *
   * @return fallbackUrl
   */
  String getFallbackUrl();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new CustomEventCommandImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param customEventName see getter
     * @return Current builder
     * @see #getCustomEventName
     */
    Builder setCustomEventName(String customEventName);

    /**
     * see getter
     *
     * @param url see getter
     * @return Current builder
     * @see #getUrl
     */
    Builder setUrl(String url);

    /**
     * see getter
     *
     * @param fallbackUrl see getter
     * @return Current builder
     * @see #getFallbackUrl
     */
    Builder setFallbackUrl(String fallbackUrl);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    CustomEventCommand build();
  }
}
