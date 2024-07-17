/*
 * Conversation API | Sinch
 * Send and receive messages globally over SMS, RCS, WhatsApp, Viber Business, Facebook messenger and other popular channels using the Sinch Conversation API.  The Conversation API endpoint uses built-in transcoding to give you the power of conversation across all supported channels and, if required, full control over channel specific features.
 *
 * The version of the OpenAPI document: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.v1.webhooks.events.smartconversations;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** OffensiveAnalysis */
@JsonDeserialize(builder = OffensiveAnalysisImpl.Builder.class)
public interface OffensiveAnalysis {

  /**
   * Either the message text or the URL of the image that was analyzed.
   *
   * @return message
   */
  String getMessage();

  /**
   * URL of the image that was analyzed.
   *
   * @return url
   */
  String getUrl();

  /** A label, either SAFE or UNSAFE, that classifies the analyzed content. */
  public class EvaluationEnum extends EnumDynamic<String, EvaluationEnum> {
    public static final EvaluationEnum SAFE = new EvaluationEnum("SAFE");
    public static final EvaluationEnum UNSAFE = new EvaluationEnum("UNSAFE");

    private static final EnumSupportDynamic<String, EvaluationEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(
            EvaluationEnum.class, EvaluationEnum::new, Arrays.asList(SAFE, UNSAFE));

    private EvaluationEnum(String value) {
      super(value);
    }

    public static Stream<EvaluationEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static EvaluationEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(EvaluationEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  /**
   * A label, either SAFE or UNSAFE, that classifies the analyzed content.
   *
   * @return evaluation
   */
  EvaluationEnum getEvaluation();

  /**
   * The likelihood that the assigned evaluation represents the analyzed message correctly. 1 is the
   * maximum value, representing the highest likelihood that the content of the message matches the
   * evaluation. 0 is the minimum value, representing the lowest likelihood that the content of the
   * message matches the evaluation.
   *
   * @return score
   */
  Float getScore();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new OffensiveAnalysisImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param message see getter
     * @return Current builder
     * @see #getMessage
     */
    Builder setMessage(String message);

    /**
     * see getter
     *
     * @param url see getter
     * @return Current builder
     * @see #getUrl
     */
    Builder setUrl(String url);

    /**
     * see getter
     *
     * @param evaluation see getter
     * @return Current builder
     * @see #getEvaluation
     */
    Builder setEvaluation(EvaluationEnum evaluation);

    /**
     * see getter
     *
     * @param score see getter
     * @return Current builder
     * @see #getScore
     */
    Builder setScore(Float score);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    OffensiveAnalysis build();
  }
}
