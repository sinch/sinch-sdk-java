package com.sinch.sdk.domains.voice.models.v1.webhooks;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Gets or Sets webhooksEventRequestType */
public class WebhooksEventRequestType extends EnumDynamic<String, WebhooksEventRequestType> {

  public static final WebhooksEventRequestType ICE = new WebhooksEventRequestType("ice");

  public static final WebhooksEventRequestType ACE = new WebhooksEventRequestType("ace");

  public static final WebhooksEventRequestType DICE = new WebhooksEventRequestType("dice");

  public static final WebhooksEventRequestType PIE = new WebhooksEventRequestType("pie");

  public static final WebhooksEventRequestType NOTIFY = new WebhooksEventRequestType("notify");

  private static final EnumSupportDynamic<String, WebhooksEventRequestType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          WebhooksEventRequestType.class,
          WebhooksEventRequestType::new,
          Arrays.asList(ICE, ACE, DICE, PIE, NOTIFY));

  private WebhooksEventRequestType(String value) {
    super(value);
  }

  public static Stream<WebhooksEventRequestType> values() {
    return ENUM_SUPPORT.values();
  }

  public static WebhooksEventRequestType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(WebhooksEventRequestType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
