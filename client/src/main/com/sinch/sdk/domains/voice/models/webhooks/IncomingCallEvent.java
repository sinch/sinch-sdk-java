package com.sinch.sdk.domains.voice.models.webhooks;

import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.domains.voice.models.Destination;
import com.sinch.sdk.domains.voice.models.DomainType;
import com.sinch.sdk.domains.voice.models.Price;
import com.sinch.sdk.domains.voice.models.webhooks.CallEvent.Builder;
import java.time.Instant;
import java.util.Collection;

public class IncomingCallEvent extends CallEvent {

  private final String callResourceUrl;
  private final Price userRate;
  private final String cli;
  private final Destination to;
  private final DomainType domain;
  private final String applicationKey;
  private final DomainType originationType;
  private final Integer duration;
  private final String rdnis;
  private final Collection<Pair<String, String>> callHeaders;

  private IncomingCallEvent(
      String callId,
      Instant timestamp,
      Integer version,
      String custom,
      String callResourceUrl,
      Price userRate,
      String cli,
      Destination to,
      DomainType domain,
      String applicationKey,
      DomainType originationType,
      Integer duration,
      String rdnis,
      Collection<Pair<String, String>> callHeaders) {
    super(callId, timestamp, version, custom);
    this.callResourceUrl = callResourceUrl;
    this.userRate = userRate;
    this.cli = cli;
    this.to = to;
    this.domain = domain;
    this.applicationKey = applicationKey;
    this.originationType = originationType;
    this.duration = duration;
    this.rdnis = rdnis;
    this.callHeaders = callHeaders;
  }

  public String getCallResourceUrl() {
    return callResourceUrl;
  }

  public Price getUserRate() {
    return userRate;
  }

  public String getCli() {
    return cli;
  }

  public Destination getTo() {
    return to;
  }

  public DomainType getDomain() {
    return domain;
  }

  public String getApplicationKey() {
    return applicationKey;
  }

  public DomainType getOriginationType() {
    return originationType;
  }

  public Integer getDuration() {
    return duration;
  }

  public String getRdnis() {
    return rdnis;
  }

  public Collection<Pair<String, String>> getCallHeaders() {
    return callHeaders;
  }

  @Override
  public String toString() {
    return "IncomingCallEvent{"
        + "callResourceUrl='"
        + callResourceUrl
        + '\''
        + ", userRate="
        + userRate
        + ", cli='"
        + cli
        + '\''
        + ", to="
        + to
        + ", domain="
        + domain
        + ", applicationKey='"
        + applicationKey
        + '\''
        + ", originationType="
        + originationType
        + ", duration="
        + duration
        + ", rdnis='"
        + rdnis
        + '\''
        + ", callHeaders="
        + callHeaders
        + "} "
        + super.toString();
  }

  public static Builder<?> builder() {
    return new Builder<>();
  }

  public static class Builder<B extends Builder<B>> extends CallEvent.Builder<Builder<B>> {

    String callResourceUrl;
    Price userRate;
    String cli;
    Destination to;
    DomainType domain;
    String applicationKey;
    DomainType originationType;
    Integer duration;
    String rdnis;
    Collection<Pair<String, String>> callHeaders;

    public B setCallResourceUrl(String callResourceUrl) {
      this.callResourceUrl = callResourceUrl;
      return self();
    }

    public B setUserRate(Price userRate) {
      this.userRate = userRate;
      return self();
    }

    public B setCli(String cli) {
      this.cli = cli;
      return self();
    }

    public B setTo(Destination to) {
      this.to = to;
      return self();
    }

    public B setDomain(DomainType domain) {
      this.domain = domain;
      return self();
    }

    public B setApplicationKey(String applicationKey) {
      this.applicationKey = applicationKey;
      return self();
    }

    public B setOriginationType(DomainType originationType) {
      this.originationType = originationType;
      return self();
    }

    public B setDuration(Integer duration) {
      this.duration = duration;
      return self();
    }

    public B setRdnis(String rdnis) {
      this.rdnis = rdnis;
      return self();
    }

    public B setCallHeaders(Collection<Pair<String, String>> callHeaders) {
      this.callHeaders = callHeaders;
      return self();
    }

    public IncomingCallEvent build() {
      return new IncomingCallEvent(
          callId,
          timestamp,
          version,
          custom,
          callResourceUrl,
          userRate,
          cli,
          to,
          domain,
          applicationKey,
          originationType,
          duration,
          rdnis,
          callHeaders);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }
  }
}
