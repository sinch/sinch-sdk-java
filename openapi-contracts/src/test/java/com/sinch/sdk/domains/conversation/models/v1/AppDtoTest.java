package com.sinch.sdk.domains.conversation.models.v1;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.conversation.models.v1.credentials.ChannelIntegrationState;
import com.sinch.sdk.domains.conversation.models.v1.credentials.ConversationChannelCredentials;
import com.sinch.sdk.domains.conversation.models.v1.credentials.StaticTokenCredentials;
import java.util.Collections;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@TestWithResources
public class AppDtoTest extends BaseTest {

  @GivenJsonResource("/domains/conversation/v1/AppListResponseDto.json")
  ListAppsResponse loadedListAppsResponseDto;

  @GivenTextResource("/domains/conversation/v1/AppCreateRequestDto.json")
  String jsonAppCreateRequestDto;

  @GivenTextResource("/domains/conversation/v1/AppUpdateRequestDto.json")
  String jsonAppUpdateRequestDto;

  public static AppResponse expectedAppsResponseDto =
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
                              .setStatus("ACTIVE")
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
      ListAppsResponse.builder()
          .setApps(Collections.singletonList(expectedAppsResponseDto))
          .build();

  /*  public static AppCreateRequestDto appCreateRequestDto =
        new AppCreateRequestDto()
            .channelCredentials(
                Arrays.asList(
                    new ConversationChannelCredentialDto()
                        .channel(ConversationChannelDto.MESSENGER)
                        .staticToken(new StaticTokenCredentialDto().token("my token"))
                        .callbackSecret("foo value")
                        .channelKnownId("a channel id"),
                    new ConversationChannelCredentialDto()
                        .channel(ConversationChannelDto.SMS)
                        .staticBearer(
                            new StaticBearerCredentialDto()
                                .claimedIdentity("my identity")
                                .token("sms token"))
                        .callbackSecret("")
                        .channelKnownId("")))
            .conversationMetadataReportView(ConversationMetadataReportViewDto.NONE)
            .displayName("Brazil App")
            .retentionPolicy(
                new RetentionPolicyDto()
                    .retentionType(RetentionPolicyTypeDto.CONVERSATION_EXPIRE_POLICY)
                    .ttlDays(180L))
            .processingMode(ProcessingModeDto.DISPATCH)
            .dispatchRetentionPolicy(
                new DispatchRetentionPolicyDto()
                    .retentionType(DispatchRetentionPolicyTypeDto.MESSAGE_EXPIRE_POLICY)
                    .ttlDays(0L))
            .smartConversation(new SmartConversationDto().enabled(true))
            .callbackSettings(new CallbackSettingsDto().secretForOverriddenCallbackUrls("my secret"));

    public static AppUpdateRequestDto appUpdateRequestDto =
        new AppUpdateRequestDto()
            .channelCredentials(
                Arrays.asList(
                    new ConversationChannelCredentialDto()
                        .channel(ConversationChannelDto.MESSENGER)
                        .staticToken(new StaticTokenCredentialDto().token("my token"))
                        .callbackSecret("foo value")
                        .channelKnownId("a channel id"),
                    new ConversationChannelCredentialDto()
                        .channel(ConversationChannelDto.SMS)
                        .staticBearer(
                            new StaticBearerCredentialDto()
                                .claimedIdentity("my identity")
                                .token("sms token"))
                        .callbackSecret("")
                        .channelKnownId("")))
            .conversationMetadataReportView(ConversationMetadataReportViewDto.NONE)
            .displayName("Brazil App")
            .retentionPolicy(
                new RetentionPolicyDto()
                    .retentionType(RetentionPolicyTypeDto.CONVERSATION_EXPIRE_POLICY)
                    .ttlDays(180L))
            .processingMode(ProcessingModeDto.DISPATCH)
            .dispatchRetentionPolicy(
                new DispatchRetentionPolicyDto()
                    .retentionType(DispatchRetentionPolicyTypeDto.MESSAGE_EXPIRE_POLICY)
                    .ttlDays(0L))
            .smartConversation(new SmartConversationDto().enabled(true))
            .callbackSettings(new CallbackSettingsDto().secretForOverriddenCallbackUrls("my secret"));
  */
  @Test
  void deserializeListAppsResponseDto() {
    Assertions.assertThat(loadedListAppsResponseDto)
        .usingRecursiveComparison()
        .isEqualTo(expectedListAppsResponseDto);
  }

  /* @Test
  void serializeAppCreateRequestDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(appCreateRequestDto);

    JSONAssert.assertEquals(jsonAppCreateRequestDto, serializedString, true);
  }

  @Test
  void serializeAppUpdateRequestDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(appUpdateRequestDto);

    JSONAssert.assertEquals(jsonAppUpdateRequestDto, serializedString, true);
  }*/
}
