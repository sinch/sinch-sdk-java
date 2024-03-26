package com.sinch.sdk.domains.conversation.models.v1.request;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Update strategy for the &#x60;conversation_metadata&#x60; field. */
public class MetadataUpdateStrategy extends EnumDynamic<String, MetadataUpdateStrategy> {

  public static final MetadataUpdateStrategy REPLACE = new MetadataUpdateStrategy("REPLACE");

  public static final MetadataUpdateStrategy MERGE_PATCH =
      new MetadataUpdateStrategy("MERGE_PATCH");

  private static final EnumSupportDynamic<String, MetadataUpdateStrategy> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          MetadataUpdateStrategy.class,
          MetadataUpdateStrategy::new,
          Arrays.asList(REPLACE, MERGE_PATCH));

  private MetadataUpdateStrategy(String value) {
    super(value);
  }

  public static Stream<MetadataUpdateStrategy> values() {
    return ENUM_SUPPORT.values();
  }

  public static MetadataUpdateStrategy from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(MetadataUpdateStrategy e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
