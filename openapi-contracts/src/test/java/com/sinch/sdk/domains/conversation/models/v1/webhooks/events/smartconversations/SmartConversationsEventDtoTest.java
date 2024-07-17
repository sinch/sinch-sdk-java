package com.sinch.sdk.domains.conversation.models.v1.webhooks.events.smartconversations;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.smartconversations.OffensiveAnalysis.EvaluationEnum;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class SmartConversationsEventDtoTest extends ConversationBaseTest {

  static List<MachineLearningSentimentResult> mlSentimentResult =
      Arrays.asList(
          MachineLearningSentimentResult.builder()
              .setMessage("message result")
              .setResults(
                  Arrays.asList(
                      SentimentResult.builder()
                          .setSentiment(Sentiment.POSITIVE)
                          .setScore(0.4F)
                          .build()))
              .setSentiment(Sentiment.NEUTRAL)
              .setScore(.6F)
              .build());
  static List<MachineLearningNLUResult> mlNluResult =
      Arrays.asList(
          MachineLearningNLUResult.builder()
              .setMessage("message ml_nlu_result")
              .setResults(
                  Arrays.asList(
                      IntentResult.builder().setIntent("chitchat.greeting").setScore(.3F).build()))
              .setIntent("chitchat.compliment")
              .setScore(.2F)
              .build());

  static DocumentImageClassification documentImageClassification =
      DocumentImageClassification.builder()
          .setDocType("an image classification")
          .setConfidence(.12F)
          .build();

  static OpticalCharacterRecognition opticalCharacterRecognition =
      OpticalCharacterRecognition.builder()
          .setResult(
              Arrays.asList(
                  OpticalCharacterRecognitionData.builder()
                      .setData(Arrays.asList("string 1", "string 2"))
                      .build()))
          .build();

  static DocumentFieldClassification documentFieldClassification =
      DocumentFieldClassification.builder()
          .setResult(
              Arrays.asList(
                  Stream.of(
                          new Object[][] {
                            {
                              "John",
                              DocumentFieldClassificationData.builder()
                                  .setData(Arrays.asList("a string"))
                                  .build()
                            },
                            {
                              "Doe",
                              DocumentFieldClassificationData.builder()
                                  .setData(Arrays.asList("another string"))
                                  .build()
                            },
                          })
                      .collect(
                          Collectors.toMap(
                              data -> (String) data[0],
                              data -> (DocumentFieldClassificationData) data[1]))))
          .build();
  static List<MachineLearningImageRecognitionResult> mlImageRecognitionResult =
      Arrays.asList(
          MachineLearningImageRecognitionResult.builder()
              .setUrl("url value")
              .setDocumentImageClassification(documentImageClassification)
              .setOpticalCharacterRecognition(opticalCharacterRecognition)
              .setDocumentFieldClassification(documentFieldClassification)
              .build());
  static List<MachineLearningPIIResult> mlPiiResult =
      Arrays.asList(
          MachineLearningPIIResult.builder()
              .setMessage("analyzed message")
              .setMasked("masked analyzed message")
              .build());

  static List<OffensiveAnalysis> mlOffensiveAnalysisResult =
      Arrays.asList(
          OffensiveAnalysis.builder()
              .setMessage("message value")
              .setUrl("URL value")
              .setEvaluation(EvaluationEnum.UNSAFE)
              .setScore(.456F)
              .build());
  static AnalysisResult analysisResult =
      AnalysisResult.builder()
          .setMlSentimentResult(mlSentimentResult)
          .setMlNluResult(mlNluResult)
          .setMlImageRecognitionResult(mlImageRecognitionResult)
          .setMlPiiResult(mlPiiResult)
          .setMlOffensiveAnalysisResult(mlOffensiveAnalysisResult)
          .build();
  static SmartConversationsEventNotification notification =
      SmartConversationsEventNotification.builder()
          .setContactId("contact id")
          .setChannelIdentity("channel identity")
          .setChannel(ConversationChannel.MESSENGER)
          .setMessageId("message id")
          .setConversationId("conversation id")
          .setAnalysisResults(analysisResult)
          .build();
  public static SmartConversationsEvent expectedSmartConversationsEvent =
      SmartConversationsEvent.builder()
          .setAppId("app id value")
          .setAcceptedTime(Instant.parse("2020-11-17T16:05:51.724083Z"))
          .setEventTime(Instant.parse("2020-11-17T16:05:45Z"))
          .setMessageMetadata("metadata value")
          .setProjectId("project id value")
          .setCorrelationId("correlation id value")
          .setNotification(notification)
          .build();

  @GivenJsonResource(
      "domains/conversation/v1/webhooks/events/smartconversations/SmartConversationsEventDto.json")
  SmartConversationsEvent smartConversationsEventDto;

  @GivenTextResource(
      "domains/conversation/v1/webhooks/events/smartconversations/SmartConversationsEventDto.json")
  String jsonSmartConversationsEventDto;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedSmartConversationsEvent);
    JSONAssert.assertEquals(jsonSmartConversationsEventDto, serializedString, true);
  }

  @Test
  void deserialize() {
    TestHelpers.recursiveEquals(smartConversationsEventDto, expectedSmartConversationsEvent);
  }
}
