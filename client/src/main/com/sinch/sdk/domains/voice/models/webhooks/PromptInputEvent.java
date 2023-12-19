package com.sinch.sdk.domains.voice.models.webhooks;

import java.time.Instant;

/**
 * This callback is triggered as a result of a {@link
 * com.sinch.sdk.domains.voice.models.svaml.ActionRunMenu runMenu} action. It can be triggered from
 * either a user pressing a number of DTMF digits, or by the {@link
 * com.sinch.sdk.domains.voice.models.svaml.MenuOptionActionType#RETURN return} command.
 *
 * <p>It's a POST request to the specified calling callback URL. Your application can respond with
 * {@link com.sinch.sdk.domains.voice.models.svaml SVAML} logic.
 *
 * <p>Note: PIE callbacks are not issued for DATA Calls, only PSTN and SIP calls.
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/voice/api-reference/voice/tag/Callbacks/#tag/Callbacks/operation/pie">PIE</a>
 */
public class PromptInputEvent extends CallEvent {

  private final String applicationKey;
  private final MenuResult menuResult;

  private PromptInputEvent(
      String callId,
      Instant timestamp,
      Integer version,
      String custom,
      String applicationKey,
      MenuResult menuResult) {
    super(callId, timestamp, version, custom);
    this.applicationKey = applicationKey;
    this.menuResult = menuResult;
  }

  /**
   * The unique application key
   *
   * @return Application key value
   */
  public String getApplicationKey() {
    return applicationKey;
  }

  /**
   * Information about the returned menu result
   *
   * @return Menu
   */
  public MenuResult getMenuResult() {
    return menuResult;
  }

  @Override
  public String toString() {
    return "PromptInputEvent{"
        + "applicationKey='"
        + applicationKey
        + '\''
        + ", menuResult="
        + menuResult
        + "} "
        + super.toString();
  }

  public static Builder<?> builder() {
    return new Builder<>();
  }

  public static class Builder<B extends Builder<B>> extends CallEvent.Builder<Builder<B>> {

    String applicationKey;
    MenuResult menuResult;

    public Builder<B> setApplicationKey(String applicationKey) {
      this.applicationKey = applicationKey;
      return this;
    }

    public Builder<B> setMenuResult(MenuResult menuResult) {
      this.menuResult = menuResult;
      return this;
    }

    public PromptInputEvent build() {
      return new PromptInputEvent(callId, timestamp, version, custom, applicationKey, menuResult);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }
  }
}
