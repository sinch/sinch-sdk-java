package com.sinch.sdk.domains.voice.models.requests;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.voice.models.Destination;
import com.sinch.sdk.domains.voice.models.requests.CalloutRequestParametersConference.Builder;
import com.sinch.sdk.models.DualToneMultiFrequency;
import com.sinch.sdk.models.E164PhoneNumber;

/**
 * The custom callout, the server initiates a call from the servers that can be controlled by
 * specifying how the call should progress at each call event.
 */
public class CalloutRequestParametersCustom extends CalloutRequestParameters {

  private final OptionalValue<Integer> maxDuration;
  private final OptionalValue<Control> ice;
  private final OptionalValue<Control> ace;
  private final OptionalValue<Control> pie;

  private CalloutRequestParametersCustom(
      OptionalValue<Destination> destination,
      OptionalValue<E164PhoneNumber> cli,
      OptionalValue<DualToneMultiFrequency> dtfm,
      OptionalValue<String> custom,
      OptionalValue<Integer> maxDuration,
      OptionalValue<Control> ice,
      OptionalValue<Control> ace,
      OptionalValue<Control> pie) {
    super(destination, cli, dtfm, custom);

    this.maxDuration = maxDuration;
    this.ice = ice;
    this.ace = ace;
    this.pie = pie;
  }

  /**
   * See builder
   *
   * @see Builder#setMaxDuration(Integer)
   */
  public OptionalValue<Integer> getMaxDuration() {
    return maxDuration;
  }

  /**
   * See builder
   *
   * @see Builder#setIce(Control)
   */
  public OptionalValue<Control> getIce() {
    return ice;
  }

  /**
   * See builder
   *
   * @see Builder#setAce(Control)
   */
  public OptionalValue<Control> getAce() {
    return ace;
  }

  /**
   * See builder
   *
   * @see Builder#setPie(Control)
   */
  public OptionalValue<Control> getPie() {
    return pie;
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

    OptionalValue<Integer> maxDuration = OptionalValue.empty();
    OptionalValue<Control> ice = OptionalValue.empty();
    OptionalValue<Control> ace = OptionalValue.empty();
    OptionalValue<Control> pie = OptionalValue.empty();

    public Builder() {
      super();
    }

    /**
     * The maximum amount of time in seconds that the call will last.
     *
     * @param maxDuration Max duration value
     * @return current builder
     */
    public Builder setMaxDuration(Integer maxDuration) {
      this.maxDuration = OptionalValue.of(maxDuration);
      return self();
    }

    /**
     * You can use inline <a
     * href="https://developers.sinch.com/docs/voice/api-reference/svaml/">SVAML</a> to replace a
     * callback URL when using custom callouts.
     *
     * <p>Ensure that the JSON object is escaped correctly
     *
     * <p>If inline ICE SVAML is passed, exclude cli and destination properties from the
     * customCallout request body. <b>Example:</b> <code>
     * "{\"action\": {\"name\": \"RunMenu\",\"locale\": \"en-US\",\"menus\": [{\"id\": \"main\",\"mainPrompt\": \"#tts[ Welcome to the main menu. Press 1 for a callback or 2 for a cancel&lt;\/speak&gt;]\",\"timeoutMills\": 5000,\"options\": [ {\"dtmf\": \"1\",\"action\": \"return(callback)\"}, {\"dtmf\": \"2\",\"action\": \"return(cancel)\"}]}]}}""
     * </code>
     *
     * @param ice The Incoming Call Event value
     * @return current builder
     */
    public Builder setIce(Control ice) {
      this.ice = OptionalValue.of(ice);
      return self();
    }

    /**
     * You can use inline <a
     * href="https://developers.sinch.com/docs/voice/api-reference/svaml/">SVAML</a> to replace a
     * callback URL when using custom callouts.
     *
     * <p>Ensure that the JSON object is escaped correctly <b>Example:</b> <code>
     * "{\"action\":{\"name\":\"connectPstn\",\"number\":\"46000000001\",\"maxDuration\":90}}"
     * </code>
     *
     * @param ace The Answered Call Event value
     * @return current builder
     */
    public Builder setAce(Control ace) {
      this.ace = OptionalValue.of(ace);
      return self();
    }

    /**
     * <b>Note:</b> PIE callbacks are not available for DATA Calls; only PSTN and SIP calls.
     *
     * <p>You can use inline <a
     * href="https://developers.sinch.com/docs/voice/api-reference/svaml/">SVAML</a> to replace a
     * callback URL when using custom callouts.
     *
     * <p>Ensure that the JSON object is escaped correctly. A PIE event will contain a value chosen
     * from an IVR choice. Usually a PIE event wil contain a URL to a callback sever that will
     * receive the choice and be able to parse it. This could result in further SVAML or some other
     * application logic function.
     *
     * @param pie Prompt Input Event value
     * @return current builder
     */
    public Builder setPie(Control pie) {
      this.pie = OptionalValue.of(pie);
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
