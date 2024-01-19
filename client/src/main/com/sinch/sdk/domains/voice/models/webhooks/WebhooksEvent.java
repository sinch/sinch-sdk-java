package com.sinch.sdk.domains.voice.models.webhooks;

public class WebhooksEvent {

  private final String callId;
  private final Integer version;

  protected WebhooksEvent(String callId, Integer version) {
    this.callId = callId;
    this.version = version;
  }

  public String getCallId() {
    return callId;
  }

  public Integer getVersion() {
    return version;
  }

  @Override
  public String toString() {
    return "CallEvent{" + "callId='" + callId + '\'' + ", version=" + version + '}';
  }

  public static Builder<?> builder() {
    return new Builder<>();
  }

  public static class Builder<B extends Builder<B>> {

    String callId;
    Integer version;

    public B setCallId(String callId) {
      this.callId = callId;
      return self();
    }

    public B setVersion(Integer version) {
      this.version = version;
      return self();
    }

    public WebhooksEvent build() {
      return new WebhooksEvent(callId, version);
    }

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }
  }
}
