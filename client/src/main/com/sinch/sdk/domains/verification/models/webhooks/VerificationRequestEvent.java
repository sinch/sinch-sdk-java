package com.sinch.sdk.domains.verification.models.webhooks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinch.sdk.domains.verification.models.Price;
import java.util.Collection;
import java.util.Optional;

public class VerificationRequestEvent extends VerificationEvent {

  private final Price price;
  private final Collection<String> acceptLanguage;

  /**
   * This event is a POST request to the specified verification callback URL and is triggered when a
   * new verification request is made from the SDK client or the Verification Request API. This
   * callback event is only triggered when a verification callback URL is specified in your
   * dashboard.
   *
   * @param id The ID of the verification request.
   * @param event The type of the event.
   * @param method The verification method
   * @param identity Specifies the type of endpoint that will be verified and the particular
   *     endpoint. number is currently the only supported endpoint type
   * @param reference The reference ID that was optionally passed together with the verification
   *     request
   * @param custom A custom string that can be provided during a verification request.
   * @param price The amount of money and currency of the verification request
   * @param acceptLanguage Allows you to set or override if provided in the API request, the SMS
   *     verification content language. Only used with the SMS verification method. The content
   *     language specified in the API request or in the callback can be overridden by carrier
   *     provider specific templates, due to compliance and legal requirements, such as US shortcode
   *     requirements see <a
   *     href="https://developers.sinch.com/docs/verification/api-reference/verification/tag/Verification-callbacks/#tag/Verification-callbacks/paths/VerificationRequestEvent/post">https://developers.sinch.com/docs/verification/api-reference/verification/tag/Verification-callbacks/#tag/Verification-callbacks/paths/VerificationRequestEvent/post</a>
   * @since 1.0
   */
  @JsonCreator
  VerificationRequestEvent(
      @JsonProperty("id") String id,
      @JsonProperty("event") String event,
      @JsonProperty("method") String method,
      @JsonProperty("identity") jsonIdentity identity,
      @JsonProperty("price") jsonPrice price,
      @JsonProperty("reference") String reference,
      @JsonProperty("custom") String custom,
      @JsonProperty("acceptLanguage") Collection<String> acceptLanguage) {
    super(id, event, method, identity, reference, custom);

    if (null != price) {
      this.price = Price.builder().setAmount(price.amount).setCurrencyId(price.currencyId).build();
    } else {
      this.price = null;
    }
    this.acceptLanguage = acceptLanguage;
  }

  public Optional<Price> getPrice() {
    return Optional.ofNullable(price);
  }

  public Optional<Collection<String>> getAcceptLanguage() {
    return Optional.ofNullable(acceptLanguage);
  }

  @Override
  public String toString() {
    return "VerificationRequestEvent{"
        + "price="
        + price
        + ", acceptLanguage="
        + acceptLanguage
        + "} "
        + super.toString();
  }

  static class jsonPrice {
    Float amount;
    String currencyId;

    @JsonCreator
    public jsonPrice(
        @JsonProperty("amount") Float amount, @JsonProperty("currencyId") String currencyId) {
      this.amount = amount;
      this.currencyId = currencyId;
    }
  }
}
