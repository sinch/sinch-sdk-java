package com.sinch.sdk.domains.conversation.models.v1.apps;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.ProcessingMode;
import com.sinch.sdk.domains.conversation.models.v1.apps.internal.AppsListResponseInternal;
import com.sinch.sdk.domains.conversation.models.v1.apps.request.AppCreateRequest;
import com.sinch.sdk.domains.conversation.models.v1.apps.request.AppUpdateRequest;
import com.sinch.sdk.domains.conversation.models.v1.apps.response.AppResponse;
import com.sinch.sdk.domains.conversation.models.v1.apps.response.QueueStats;
import com.sinch.sdk.domains.conversation.models.v1.apps.response.RateLimits;
import com.sinch.sdk.domains.conversation.models.v1.credentials.ChannelIntegrationState;
import com.sinch.sdk.domains.conversation.models.v1.credentials.ChannelIntegrationStatus;
import com.sinch.sdk.domains.conversation.models.v1.credentials.ConversationChannelCredentials;
import com.sinch.sdk.domains.conversation.models.v1.credentials.StaticBearerCredentials;
import com.sinch.sdk.domains.conversation.models.v1.credentials.StaticTokenCredentials;
import java.util.Arrays;
import java.util.Collections;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class AppDtoTest extends BaseTest {

  @GivenJsonResource("/domains/conversation/v1/apps/AppListResponseDto.json")
  AppsListResponseInternal loadedListAppsResponseDto;

  @GivenJsonResource("/domains/conversation/v1/apps/AppResponseDto.json")
  AppResponse loadedAppsResponseDto;

  @GivenTextResource("/domains/conversation/v1/apps/AppCreateRequestDto.json")
  String jsonAppCreateRequestDto;

  @GivenTextResource("/domains/conversation/v1/apps/AppUpdateRequestDto.json")
  String jsonAppUpdateRequestDto;

  public static AppResponse expectedAppResponseDto =
      AppResponse.builder()
          .setId("an app id")
          .setChannelCredentials(
              Collections.singletonList(
                  ConversationChannelCredentials.builder()
                      .setChannel(ConversationChannel.MESSENGER)
                      .setCredentials(StaticTokenCredentials.builder().setToken("my token").build())
                      .setCallbackSecret("foo value")
                      .setState(
                          ChannelIntegrationState.builder()
                              .setStatus(ChannelIntegrationStatus.from("ACTIVE"))
                              .setDescription("")
                              .build())
                      .setChannelKnownId("a channel id")
                      .build()))
          .setConversationMetadataReportView(ConversationMetadataReportView.NONE)
          .setDisplayName("Brazil App")
          .setRateLimits(
              RateLimits.builder().setInbound(100L).setOutbound(20L).setWebhooks(200L).build())
          .setRetentionPolicy(
              RetentionPolicy.builder()
                  .setRetentionType(RetentionPolicyType.CONVERSATION_EXPIRE_POLICY)
                  .setTtlDays(180L)
                  .build())
          .setProcessingMode(ProcessingMode.DISPATCH)
          .setDispatchRetentionPolicy(
              DispatchRetentionPolicy.builder()
                  .setRetentionType(DispatchRetentionPolicyType.MESSAGE_EXPIRE_POLICY)
                  .setTtlDays(0L)
                  .build())
          .setSmartConversation(SmartConversation.builder().setEnabled(true).build())
          .setQueueStats(QueueStats.builder().setOutboundLimit(500000L).setOutboundSize(0L).build())
          .setCallbackSettings(
              CallbackSettings.builder().setSecretForOverriddenCallbackUrls("my secret").build())
          .setDeliveryReportBasedFallback(
              DeliveryReportBasedFallback.builder()
                  .setEnabled(true)
                  .setDeliveryReportWaitingTime(455)
                  .build())
          .setMessageRetrySettings(null)
          .build();
  public static AppsListResponseInternal expectedListAppsResponseDto =
      AppsListResponseInternal.builder()
          .setApps(Collections.singletonList(expectedAppResponseDto))
          .build();
  public static AppCreateRequest appCreateRequestDto =
      AppCreateRequest.builder()
          .setChannelCredentials(
              Arrays.asList(
                  ConversationChannelCredentials.builder()
                      .setChannel(ConversationChannel.MESSENGER)
                      .setCredentials(StaticTokenCredentials.builder().setToken("my token").build())
                      .setCallbackSecret("foo value")
                      .build(),
                  ConversationChannelCredentials.builder()
                      .setChannel(ConversationChannel.SMS)
                      .setCredentials(
                          StaticBearerCredentials.builder()
                              .setClaimedIdentity("my identity")
                              .setToken("sms token")
                              .build())
                      .setCallbackSecret("")
                      .build()))
          .setConversationMetadataReportView(ConversationMetadataReportView.NONE)
          .setDisplayName("Brazil App")
          .setRetentionPolicy(
              RetentionPolicy.builder()
                  .setRetentionType(RetentionPolicyType.CONVERSATION_EXPIRE_POLICY)
                  .setTtlDays(180L)
                  .build())
          .setProcessingMode(ProcessingMode.DISPATCH)
          .setDispatchRetentionPolicy(
              DispatchRetentionPolicy.builder()
                  .setRetentionType(DispatchRetentionPolicyType.MESSAGE_EXPIRE_POLICY)
                  .setTtlDays(0L)
                  .build())
          .setSmartConversation(SmartConversation.builder().setEnabled(true).build())
          .setCallbackSettings(
              CallbackSettings.builder().setSecretForOverriddenCallbackUrls("my secret").build())
          .build();
  public static AppUpdateRequest appUpdateRequestDto =
      AppUpdateRequest.builder()
          .setChannelCredentials(
              Arrays.asList(
                  ConversationChannelCredentials.builder()
                      .setChannel(ConversationChannel.MESSENGER)
                      .setCredentials(StaticTokenCredentials.builder().setToken("my token").build())
                      .setCallbackSecret("foo value")
                      .build(),
                  ConversationChannelCredentials.builder()
                      .setChannel(ConversationChannel.SMS)
                      .setCredentials(
                          StaticBearerCredentials.builder()
                              .setClaimedIdentity("my identity")
                              .setToken("sms token")
                              .build())
                      .setCallbackSecret("")
                      .build()))
          .setConversationMetadataReportView(ConversationMetadataReportView.NONE)
          .setDisplayName("Brazil App")
          .setRetentionPolicy(
              RetentionPolicy.builder()
                  .setRetentionType(RetentionPolicyType.CONVERSATION_EXPIRE_POLICY)
                  .setTtlDays(180L)
                  .build())
          .setProcessingMode(ProcessingMode.DISPATCH)
          .setDispatchRetentionPolicy(
              DispatchRetentionPolicy.builder()
                  .setRetentionType(DispatchRetentionPolicyType.MESSAGE_EXPIRE_POLICY)
                  .setTtlDays(0L)
                  .build())
          .setSmartConversation(SmartConversation.builder().setEnabled(true).build())
          .setCallbackSettings(
              CallbackSettings.builder().setSecretForOverriddenCallbackUrls("my secret").build())
          .build();

  @Test
  void deserializeAppResponseDto() {
    TestHelpers.recursiveEquals(loadedAppsResponseDto, expectedAppResponseDto);
  }

  @Test
  void deserializeListAppsResponseDto() {
    TestHelpers.recursiveEquals(loadedListAppsResponseDto, expectedListAppsResponseDto);
  }

  @Test
  void serializeAppCreateRequestDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(appCreateRequestDto);

    JSONAssert.assertEquals(jsonAppCreateRequestDto, serializedString, true);
  }

  @Test
  void serializeAppUpdateRequestDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(appUpdateRequestDto);

    JSONAssert.assertEquals(jsonAppUpdateRequestDto, serializedString, true);
  }
}
