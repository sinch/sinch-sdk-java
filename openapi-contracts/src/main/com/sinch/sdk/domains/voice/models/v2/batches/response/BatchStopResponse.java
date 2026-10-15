package com.sinch.sdk.domains.voice.models.v2.batches.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Response returned when the request to stop processing a batch of call sessions has been received.
 */
@JsonDeserialize(builder = BatchStopResponseImpl.Builder.class)
public interface BatchStopResponse {

  /** State of the batch processing cancellation request */
  public class ResultEnum extends EnumDynamic<String, ResultEnum> {
    public static final ResultEnum STOP_REQUESTED = new ResultEnum("STOP_REQUESTED");

    private static final EnumSupportDynamic<String, ResultEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(ResultEnum.class, ResultEnum::new, Arrays.asList(STOP_REQUESTED));

    private ResultEnum(String value) {
      super(value);
    }

    public static Stream<ResultEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static ResultEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(ResultEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  /**
   * State of the batch processing cancellation request.
   *
   * <p><code>STOP_REQUESTED</code>: batch call processing cancellation requested. No new calls will
   * be initiated.
   *
   * @return result
   */
  ResultEnum getResult();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new BatchStopResponseImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param result see getter
     * @return Current builder
     * @see #getResult
     */
    Builder setResult(ResultEnum result);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    BatchStopResponse build();
  }
}
