package com.sinch.sdk.domains.numbers.models.v1.webhooks;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** The type of the resource. */
public class ResourceType extends EnumDynamic<String, ResourceType> {

  /** Numbers which are already active and updated with new campaign IDs or service plan IDs. */
  public static final ResourceType ACTIVE_NUMBER = new ResourceType("ACTIVE_NUMBER");

  private static final EnumSupportDynamic<String, ResourceType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(ResourceType.class, ResourceType::new, Arrays.asList(ACTIVE_NUMBER));

  private ResourceType(String value) {
    super(value);
  }

  public static Stream<ResourceType> values() {
    return ENUM_SUPPORT.values();
  }

  public static ResourceType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(ResourceType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
