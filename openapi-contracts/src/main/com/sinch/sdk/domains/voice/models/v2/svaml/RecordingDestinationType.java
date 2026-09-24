package com.sinch.sdk.domains.voice.models.v2.svaml;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Select target service to receive recorded and transcribed files */
public class RecordingDestinationType extends EnumDynamic<String, RecordingDestinationType> {
  /**
   * Store recordings in Amazon Web Services S3 bucket. Use <code>s3</code> as schema for the URL.
   */
  public static final RecordingDestinationType AWS = new RecordingDestinationType("AWS");

  /**
   * Store recordings in Google Cloud Platform Storage. Use <code>gs</code> as schema for the URL.
   */
  public static final RecordingDestinationType GCP = new RecordingDestinationType("GCP");

  /**
   * Store recordings in Microsoft Azure Blob Storage. Use <code>azure</code> as schema for the URL.
   */
  public static final RecordingDestinationType AZURE = new RecordingDestinationType("AZURE");

  private static final EnumSupportDynamic<String, RecordingDestinationType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          RecordingDestinationType.class,
          RecordingDestinationType::new,
          Arrays.asList(AWS, GCP, AZURE));

  private RecordingDestinationType(String value) {
    super(value);
  }

  public static Stream<RecordingDestinationType> values() {
    return ENUM_SUPPORT.values();
  }

  public static RecordingDestinationType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(RecordingDestinationType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
