package com.sinch.sdk.domains.conversation.models.dto.v1;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import java.util.Arrays;
import java.util.Collections;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class AppDtoTest extends BaseTest {

  @GivenJsonResource("/domains/conversation/v1/AppListResponseDto.json")
  ListAppsResponseDto loadedListAppsResponseDto;

  @GivenTextResource("/domains/conversation/v1/AppCreateRequestDto.json")
  String jsonAppCreateRequestDto;

  @GivenTextResource("/domains/conversation/v1/AppUpdateRequestDto.json")
  String jsonAppUpdateRequestDto;

  public static AppResponseDto expectedAppsResponseDto =
      new AppResponseDto()
          .id("an app id")
          .channelCredentials(
              Collections.singletonList(
                  new ConversationChannelCredentialDto()
                      .channel(ConversationChannelDto.MESSENGER)
                      .staticToken(new StaticTokenCredentialDto().token("my token"))
                      .callbackSecret("foo value")
                      .state(
                          new ConversationChannelCredentialStateDto()
                              .status("ACTIVE")
                              .description(""))
                      .channelKnownId("a channel id")))
          .conversationMetadataReportView(ConversationMetadataReportViewDto.NONE)
          .displayName("Brazil App")
          .rateLimits(new RateLimitsDto(100L, 20L, 200L))
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
          .queueStats(new QueueStatsDto(0L, 500000L))
          .persistMessageStatus(new AppResponsePersistMessageStatusDto().enabled(false))
          .messageSearch(new AppResponsePersistMessageStatusDto().enabled(true))
          .callbackSettings(new CallbackSettingsDto().secretForOverriddenCallbackUrls("my secret"))
          .deliveryReportBasedFallback(
              new AppResponseDeliveryReportBasedFallbackDto()
                  .enabled(true)
                  .deliveryReportWaitingTime(455))
          .messageRetrySettings(null);

  public static ListAppsResponseDto expectedListAppsResponseDto =
      new ListAppsResponseDto().apps(Collections.singletonList(expectedAppsResponseDto));

  public static AppCreateRequestDto appCreateRequestDto =
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
