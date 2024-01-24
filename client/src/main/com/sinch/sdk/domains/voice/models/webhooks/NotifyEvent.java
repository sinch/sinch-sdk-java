package com.sinch.sdk.domains.voice.models.webhooks;

public class NotifyEvent extends WebhooksEvent {

  private final String custom;
  private final String type;

  private NotifyEvent(String callId, Integer version, String custom, String type) {
    super(callId, version);
    this.custom = custom;
    this.type = type;
  }

  public String getCustom() {
    return custom;
  }

  public String getType() {
    return type;
  }

  @Override
  public String toString() {
    return "NotifyEvent{"
        + "custom='"
        + custom
        + '\''
        + ", type='"
        + type
        + '\''
        + "} "
        + super.toString();
  }

  public static Builder<?> builder() {
    return new Builder<>();
  }

  public static class Builder<B extends Builder<B>> extends WebhooksEvent.Builder<Builder<B>> {

    String custom;
    String type;

    public B setCustom(String custom) {
      this.custom = custom;
      return self();
    }

    public B setType(String type) {
      this.type = type;
      return self();
    }

    public NotifyEvent build() {
      return new NotifyEvent(callId, version, custom, type);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }
  }
}
