package com.sinch.sdk.domains.verification.models.webhooks;

import com.sinch.sdk.domains.verification.models.Identity;
import com.sinch.sdk.domains.verification.models.Price;
import com.sinch.sdk.domains.verification.models.VerificationMethodType;
import com.sinch.sdk.domains.verification.models.VerificationReference;
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

  public VerificationRequestEvent(
      String id,
      VerificationMethodType method,
      Identity identity,
      Price price,
      VerificationReference reference,
      String custom,
      Collection<String> acceptLanguage) {
    super(id, method, identity, reference, custom);
    this.price = price;
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
}
