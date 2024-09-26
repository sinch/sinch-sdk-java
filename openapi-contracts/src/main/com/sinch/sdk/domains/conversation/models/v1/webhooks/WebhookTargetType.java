package com.sinch.sdk.domains.conversation.models.v1.webhooks;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Gets or Sets WebhookTargetType */
public class WebhookTargetType extends EnumDynamic<String, WebhookTargetType> {

  /** Events won't be sent. */
  public static final WebhookTargetType DISMISS = new WebhookTargetType("DISMISS");

  /** Events will be sent to an HTTP target. */
  public static final WebhookTargetType HTTP = new WebhookTargetType("HTTP");

  private static final EnumSupportDynamic<String, WebhookTargetType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          WebhookTargetType.class, WebhookTargetType::new, Arrays.asList(DISMISS, HTTP));

  private WebhookTargetType(String value) {
    super(value);
  }

  public static Stream<WebhookTargetType> values() {
    return ENUM_SUPPORT.values();
  }

  public static WebhookTargetType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(WebhookTargetType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
