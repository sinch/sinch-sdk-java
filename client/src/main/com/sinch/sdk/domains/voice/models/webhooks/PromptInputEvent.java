package com.sinch.sdk.domains.voice.models.webhooks;

import java.time.Instant;

public class PromptInputEvent extends CallEvent {

  private final String applicationKey;
  private final MenuResult menuResult;

  public PromptInputEvent(
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

  public String getApplicationKey() {
    return applicationKey;
  }

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
