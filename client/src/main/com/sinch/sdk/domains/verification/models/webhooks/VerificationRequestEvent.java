package com.sinch.sdk.domains.verification.models.webhooks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinch.sdk.domains.verification.models.Price;
import java.util.Collection;
import java.util.Optional;

/**
 * This event is received onto a POST request to the specified verification callback URL and is
 * triggered when a new verification request is made from the SDK client or the Verification Request
 * API. This callback event is only triggered when a verification callback URL is specified in your
 * dashboard.
 */
public class VerificationRequestEvent extends VerificationEvent {

  private final Price price;
  private final Collection<String> acceptLanguage;

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

  /**
   * The amount of money and currency of the verification request
   *
   * @return Price value
   * @since 1.0
   */
  public Optional<Price> getPrice() {
    return Optional.ofNullable(price);
  }

  /**
   * Allows you to set or override if provided in the API request, the SMS verification content
   * language. Only used with the SMS verification method. The content language specified in the API
   * request or in the callback can be overridden by carrier provider specific templates, due to
   * compliance and legal requirements, such as US shortcode requirements see <a
   * href="https://developers.sinch.com/docs/verification/api-reference/verification/tag/Verification-callbacks/#tag/Verification-callbacks/paths/VerificationRequestEvent/post">https://developers.sinch.com/docs/verification/api-reference/verification/tag/Verification-callbacks/#tag/Verification-callbacks/paths/VerificationRequestEvent/post</a>
   *
   * @return Values collection list
   * @since 1.0
   */
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
    private final Float amount;
    private final String currencyId;

    @JsonCreator
    public jsonPrice(
        @JsonProperty("amount") Float amount, @JsonProperty("currencyId") String currencyId) {
      this.amount = amount;
      this.currencyId = currencyId;
    }
  }
}
