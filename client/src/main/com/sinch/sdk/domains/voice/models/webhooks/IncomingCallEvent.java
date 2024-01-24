package com.sinch.sdk.domains.voice.models.webhooks;

import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.domains.voice.models.Destination;
import com.sinch.sdk.domains.voice.models.DomainType;
import com.sinch.sdk.domains.voice.models.Price;
import com.sinch.sdk.domains.voice.models.webhooks.CallEvent.Builder;
import java.time.Instant;
import java.util.Collection;

/**
 * This event, called the ICE event, can be triggered by either an incoming data call or an incoming
 * PSTN call.
 *
 * <p>It's a POST request to the specified calling callback URL. Look here for allowed {@link
 * com.sinch.sdk.domains.voice.models.svaml.Action instructions} and {@link
 * com.sinch.sdk.domains.voice.models.svaml.Instruction actions}.
 *
 * <p>If there is no response to the callback within the timeout period, an error message is played,
 * and the call is disconnected.
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/voice/api-reference/voice/tag/Callbacks/#tag/Callbacks/operation/ice">ICE</a>
 */
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

  /**
   * The path of the API resource
   *
   * @return path value
   */
  public String getCallResourceUrl() {
    return callResourceUrl;
  }

  /**
   * Charged for the call established to the original destination. If the SVAML response specifies
   * another destination, the same rate may not apply.
   *
   * @return charged value
   */
  public Price getUserRate() {
    return userRate;
  }

  /**
   * The number that will be displayed to the recipient of the call.
   *
   * <p>To set your own CLI, you may use your verified number or your Dashboard virtual number and
   * add it to the {@link com.sinch.sdk.domains.voice.models.svaml.ActionConnectPstn
   * ActionConnectPstn} SVAML response to the Incoming Call Event request.
   *
   * @return
   */
  public String getCli() {
    return cli;
  }

  /**
   * Information about the recipient of the call
   *
   * @return information value
   */
  public Destination getTo() {
    return to;
  }

  /**
   * The domain destination of the incoming call
   *
   * @return Domain value
   */
  public DomainType getDomain() {
    return domain;
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
   * The origination domain of the incoming call
   *
   * @return Origin type
   */
  public DomainType getOriginationType() {
    return originationType;
  }

  /**
   * The duration of the call in seconds
   *
   * @return Duration value
   */
  public Integer getDuration() {
    return duration;
  }

  /**
   * The redirected dialled number identification service
   *
   * @return RDNIS value
   */
  public String getRdnis() {
    return rdnis;
  }

  /**
   * If the call is initiated by a Sinch SDK client, call headers are the headers specified by the
   * caller client. Read more about call headers <a
   * href="https://developers.sinch.com/docs/voice/api-reference/call-headers">here</a>
   *
   * @return Headers
   */
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
