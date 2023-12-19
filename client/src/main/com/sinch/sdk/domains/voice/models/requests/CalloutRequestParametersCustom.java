package com.sinch.sdk.domains.voice.models.requests;

import com.sinch.sdk.domains.voice.models.CalloutMethodType;
import com.sinch.sdk.models.E164PhoneNumber;
import java.util.Optional;

/**
 * The custom callout, the server initiates a call from the servers that can be controlled by
 * specifying how the call should progress at each call event.
 */
public class CalloutRequestParametersCustom extends CalloutRequestParameters {

  private final Integer maxDuration;
  private final String ice;
  private final String ace;
  private final String pie;

  public CalloutRequestParametersCustom(
      Destination destination,
      E164PhoneNumber cli,
      String dtfm,
      String custom,
      Integer maxDuration,
      String ice,
      String ace,
      String pie) {
    super(CalloutMethodType.CUSTOM_CALLOUT, destination, cli, dtfm, custom);

    this.maxDuration = maxDuration;
    this.ice = ice;
    this.ace = ace;
    this.pie = pie;
  }

  /**
   * The maximum amount of time in seconds that the call will last.
   *
   * @return Max duration value
   */
  public Optional<Integer> getMaxDuration() {
    return Optional.ofNullable(maxDuration);
  }

  /**
   * You can use inline <a
   * href="https://developers.sinch.com/docs/voice/api-reference/svaml/">SVAML</a> to replace a
   * callback URL when using custom callouts.
   *
   * <p>Ensure that the JSON object is escaped correctly
   *
   * <p>If inline ICE SVAML is passed, exclude cli and destination properties from the customCallout
   * request body. <b>Example:</b> <code>
   * "{\"action\": {\"name\": \"RunMenu\",\"locale\": \"en-US\",\"menus\": [{\"id\": \"main\",\"mainPrompt\": \"#tts[ Welcome to the main menu. Press 1 for a callback or 2 for a cancel&lt;\/speak&gt;]\",\"timeoutMills\": 5000,\"options\": [ {\"dtmf\": \"1\",\"action\": \"return(callback)\"}, {\"dtmf\": \"2\",\"action\": \"return(cancel)\"}]}]}}""
   * </code>
   *
   * @return The Incoming Call Event value
   */
  public Optional<String> getIce() {
    return Optional.ofNullable(ice);
  }

  /**
   * You can use inline <a
   * href="https://developers.sinch.com/docs/voice/api-reference/svaml/">SVAML</a> to replace a
   * callback URL when using custom callouts.
   *
   * <p>Ensure that the JSON object is escaped correctly <b>Example:</b> <code>
   * "{\"action\":{\"name\":\"connectPstn\",\"number\":\"46000000001\",\"maxDuration\":90}}"</code>
   *
   * @return The Answered Call Event value
   */
  public Optional<String> getAce() {
    return Optional.ofNullable(ace);
  }

  /**
   * <b>Note:</b> PIE callbacks are not available for DATA Calls; only PSTN and SIP calls.
   *
   * <p>You can use inline <a
   * href="https://developers.sinch.com/docs/voice/api-reference/svaml/">SVAML</a> to replace a
   * callback URL when using custom callouts.
   *
   * <p>Ensure that the JSON object is escaped correctly. A PIE event will contain a value chosen
   * from an IVR choice. Usually a PIE event wil contain a URL to a callback sever that will receive
   * the choice and be able to parse it. This could result in further SVAML or some other
   * application logic function.
   *
   * @return Prompt Input Event value
   */
  public Optional<String> getPie() {
    return Optional.ofNullable(pie);
  }

  @Override
  public String toString() {
    return "CalloutRequestParametersCustom{"
        + "maxDuration="
        + maxDuration
        + ", ice='"
        + ice
        + '\''
        + ", ace='"
        + ace
        + '\''
        + ", pie='"
        + pie
        + '\''
        + "} "
        + super.toString();
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends CalloutRequestParameters.Builder<Builder> {

    Integer maxDuration;
    String ice;
    String ace;
    String pie;

    public Builder() {
      super();
    }

    public Builder setMaxDuration(Integer maxDuration) {
      this.maxDuration = maxDuration;
      return self();
    }

    public Builder setIce(String ice) {
      this.ice = ice;
      return self();
    }

    public Builder setAce(String ace) {
      this.ace = ace;
      return self();
    }

    public Builder setPie(String pie) {
      this.pie = pie;
      return self();
    }

    public CalloutRequestParametersCustom build() {
      return new CalloutRequestParametersCustom(
          destination, cli, dtfm, custom, maxDuration, ice, ace, pie);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
