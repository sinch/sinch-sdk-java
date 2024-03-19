package com.sinch.sdk.domains.conversation.models.v1;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.conversation.models.v1.app.CallbackSettings;
import com.sinch.sdk.domains.conversation.models.v1.app.ConversationMetadataReportView;
import com.sinch.sdk.domains.conversation.models.v1.app.DeliveryReportBasedFallback;
import com.sinch.sdk.domains.conversation.models.v1.app.DispatchRetentionPolicy;
import com.sinch.sdk.domains.conversation.models.v1.app.DispatchRetentionPolicyType;
import com.sinch.sdk.domains.conversation.models.v1.app.RetentionPolicy;
import com.sinch.sdk.domains.conversation.models.v1.app.SmartConversation;
import com.sinch.sdk.domains.conversation.models.v1.app.request.AppCreateRequest;
import com.sinch.sdk.domains.conversation.models.v1.app.request.AppUpdateRequest;
import com.sinch.sdk.domains.conversation.models.v1.app.request.ConversationChannelCredentialRequest;
import com.sinch.sdk.domains.conversation.models.v1.app.response.AppResponse;
import com.sinch.sdk.domains.conversation.models.v1.app.response.ListAppsResponse;
import com.sinch.sdk.domains.conversation.models.v1.app.response.QueueStats;
import com.sinch.sdk.domains.conversation.models.v1.app.response.RateLimits;
import com.sinch.sdk.domains.conversation.models.v1.credentials.ChannelIntegrationState;
import com.sinch.sdk.domains.conversation.models.v1.credentials.ChannelIntegrationStatus;
import com.sinch.sdk.domains.conversation.models.v1.credentials.ConversationChannelCredentials;
import com.sinch.sdk.domains.conversation.models.v1.credentials.StaticBearerCredentials;
import com.sinch.sdk.domains.conversation.models.v1.credentials.StaticTokenCredentials;
import java.util.Arrays;
import java.util.Collections;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class AppDtoTest extends BaseTest {

  public static AppResponse expectedAppResponseDto =
      AppResponse.builder()
          .setId("an app id")
          .setChannelCredentials(
              Collections.singletonList(
                  ConversationChannelCredentials.builder()
                      .setChannel(ConversationChannel.MESSENGER)
                      .setStaticToken(StaticTokenCredentials.builder().setToken("my token").build())
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
                  .setRetentionType("CONVERSATION_EXPIRE_POLICY")
                  .setTtlDays(180L)
                  .build())
          .setProcessingMode("DISPATCH")
          .setDispatchRetentionPolicy(
              DispatchRetentionPolicy.builder()
                  .setRetentionType(DispatchRetentionPolicyType.MESSAGE_EXPIRE_POLICY)
                  .setTtlDays(0L)
                  .build())
          .setSmartConversation(SmartConversation.builder().setEnabled(true).build())
          .setQueueStats(QueueStats.builder().setOutboundLimit(500000L).setOutboundSize(0L).build())
          // .setPersistMessageStatus(new AppResponsePersistMessageStatusDto().enabled(false))
          // .setMessageSearch(new AppResponseMessageSearchDto().enabled(true))
          .setCallbackSettings(
              CallbackSettings.builder().setSecretForOverriddenCallbackUrls("my secret").build())
          .setDeliveryReportBasedFallback(
              DeliveryReportBasedFallback.builder()
                  .setEnabled(true)
                  .setDeliveryReportWaitingTime(455)
                  .build())
          .setMessageRetrySettings(null)
          .build();
  public static ListAppsResponse expectedListAppsResponseDto =
      ListAppsResponse.builder().setApps(Collections.singletonList(expectedAppResponseDto)).build();
  public static AppCreateRequest appCreateRequestDto =
      AppCreateRequest.builder()
          .setChannelCredentials(
              Arrays.asList(
                  ConversationChannelCredentialRequest.builder()
                      .setChannel(ConversationChannel.MESSENGER)
                      .setStaticToken(StaticTokenCredentials.builder().setToken("my token").build())
                      .setCallbackSecret("foo value")
                      .build(),
                  ConversationChannelCredentialRequest.builder()
                      .setChannel(ConversationChannel.SMS)
                      .setStaticBearer(
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
                  .setRetentionType("CONVERSATION_EXPIRE_POLICY")
                  .setTtlDays(180L)
                  .build())
          .setProcessingMode("DISPATCH")
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
                  ConversationChannelCredentialRequest.builder()
                      .setChannel(ConversationChannel.MESSENGER)
                      .setStaticToken(StaticTokenCredentials.builder().setToken("my token").build())
                      .setCallbackSecret("foo value")
                      .build(),
                  ConversationChannelCredentialRequest.builder()
                      .setChannel(ConversationChannel.SMS)
                      .setStaticBearer(
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
                  .setRetentionType("CONVERSATION_EXPIRE_POLICY")
                  .setTtlDays(180L)
                  .build())
          .setProcessingMode("DISPATCH")
          .setDispatchRetentionPolicy(
              DispatchRetentionPolicy.builder()
                  .setRetentionType(DispatchRetentionPolicyType.MESSAGE_EXPIRE_POLICY)
                  .setTtlDays(0L)
                  .build())
          .setSmartConversation(SmartConversation.builder().setEnabled(true).build())
          .setCallbackSettings(
              CallbackSettings.builder().setSecretForOverriddenCallbackUrls("my secret").build())
          .build();

  @GivenJsonResource("/domains/conversation/v1/AppListResponseDto.json")
  ListAppsResponse loadedListAppsResponseDto;

  @GivenTextResource("/domains/conversation/v1/AppCreateRequestDto.json")
  String jsonAppCreateRequestDto;

  @GivenTextResource("/domains/conversation/v1/AppUpdateRequestDto.json")
  String jsonAppUpdateRequestDto;

  @Test
  void deserializeListAppsResponseDto() {
    Assertions.assertThat(loadedListAppsResponseDto)
        .usingRecursiveComparison()
        .isEqualTo(expectedListAppsResponseDto);
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
