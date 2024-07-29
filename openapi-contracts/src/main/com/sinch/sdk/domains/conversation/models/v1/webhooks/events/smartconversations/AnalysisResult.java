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
import java.util.List;

/**
 * The analysis provided by the Smart Conversations machine learning engine(s). The contents of the
 * object are determined by the functionalities that are enabled for your solution.
 */
@JsonDeserialize(builder = AnalysisResultImpl.Builder.class)
public interface AnalysisResult {

  /**
   * An array that contains the analyses of the sentiments of the corresponding messages.
   *
   * @return mlSentimentResult
   */
  List<MachineLearningSentimentResult> getMlSentimentResult();

  /**
   * An array that contains the analyses of the intentions of, and entities within, the
   * corresponding messages.
   *
   * @return mlNluResult
   */
  List<MachineLearningNLUResult> getMlNluResult();

  /**
   * An array that contains the image recognition analyses of the images identified in the
   * corresponding messages.
   *
   * @return mlImageRecognitionResult
   */
  List<MachineLearningImageRecognitionResult> getMlImageRecognitionResult();

  /**
   * An array that contains the PII analysis of the corresponding messages.
   *
   * @return mlPiiResult
   */
  List<MachineLearningPIIResult> getMlPiiResult();

  /**
   * An array that contains the analyses of the offenses of the corresponding messages.
   *
   * @return mlOffensiveAnalysisResult
   */
  List<OffensiveAnalysis> getMlOffensiveAnalysisResult();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new AnalysisResultImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param mlSentimentResult see getter
     * @return Current builder
     * @see #getMlSentimentResult
     */
    Builder setMlSentimentResult(List<MachineLearningSentimentResult> mlSentimentResult);

    /**
     * see getter
     *
     * @param mlNluResult see getter
     * @return Current builder
     * @see #getMlNluResult
     */
    Builder setMlNluResult(List<MachineLearningNLUResult> mlNluResult);

    /**
     * see getter
     *
     * @param mlImageRecognitionResult see getter
     * @return Current builder
     * @see #getMlImageRecognitionResult
     */
    Builder setMlImageRecognitionResult(
        List<MachineLearningImageRecognitionResult> mlImageRecognitionResult);

    /**
     * see getter
     *
     * @param mlPiiResult see getter
     * @return Current builder
     * @see #getMlPiiResult
     */
    Builder setMlPiiResult(List<MachineLearningPIIResult> mlPiiResult);

    /**
     * see getter
     *
     * @param mlOffensiveAnalysisResult see getter
     * @return Current builder
     * @see #getMlOffensiveAnalysisResult
     */
    Builder setMlOffensiveAnalysisResult(List<OffensiveAnalysis> mlOffensiveAnalysisResult);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    AnalysisResult build();
  }
}
