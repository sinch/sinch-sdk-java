package com.sinch.sdk.domains.numbers.models.v1.numberorder.response;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * The attachment upload status. It will be either <code>COMPLETED</code>, <code>WAITING</code> or
 * <code>FAILED</code>.
 */
public class UploadStatus extends EnumDynamic<String, UploadStatus> {

  /** Upload completed */
  public static final UploadStatus COMPLETED = new UploadStatus("COMPLETED");

  /** Waiting for upload */
  public static final UploadStatus WAITING = new UploadStatus("WAITING");

  /** Upload failed */
  public static final UploadStatus FAILED = new UploadStatus("FAILED");

  private static final EnumSupportDynamic<String, UploadStatus> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          UploadStatus.class, UploadStatus::new, Arrays.asList(COMPLETED, WAITING, FAILED));

  private UploadStatus(String value) {
    super(value);
  }

  public static Stream<UploadStatus> values() {
    return ENUM_SUPPORT.values();
  }

  public static UploadStatus from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(UploadStatus e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
