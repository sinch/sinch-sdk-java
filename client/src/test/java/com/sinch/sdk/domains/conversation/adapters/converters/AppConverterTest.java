package com.sinch.sdk.domains.conversation.adapters.converters;

import com.sinch.sdk.domains.conversation.models.CallbackSettings;
import com.sinch.sdk.domains.conversation.models.ConversationMetadataReportViewType;
import com.sinch.sdk.domains.conversation.models.DeliveryReportBasedFallback;
import com.sinch.sdk.domains.conversation.models.DispatchRetentionPolicy;
import com.sinch.sdk.domains.conversation.models.MessageSearch;
import com.sinch.sdk.domains.conversation.models.PersistMessageStatus;
import com.sinch.sdk.domains.conversation.models.ProcessingModeType;
import com.sinch.sdk.domains.conversation.models.QueueStats;
import com.sinch.sdk.domains.conversation.models.RateLimits;
import com.sinch.sdk.domains.conversation.models.RetentionPolicy;
import com.sinch.sdk.domains.conversation.models.RetentionPolicyType;
import com.sinch.sdk.domains.conversation.models.SmartConversation;
import com.sinch.sdk.domains.conversation.models.credentials.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.credentials.ConversationChannelMessenger;
import com.sinch.sdk.domains.conversation.models.credentials.ConversationChannelSMS;
import com.sinch.sdk.domains.conversation.models.credentials.CredentialState;
import com.sinch.sdk.domains.conversation.models.credentials.CredentialStateStatusType;
import com.sinch.sdk.domains.conversation.models.credentials.StaticBearerCredentials;
import com.sinch.sdk.domains.conversation.models.credentials.StaticTokenCredentials;
import com.sinch.sdk.domains.conversation.models.dto.v1.AppDtoTest;
import com.sinch.sdk.domains.conversation.models.requests.AppRequestParameters;
import com.sinch.sdk.domains.conversation.models.responses.App;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class AppConverterTest {

  static final ConversationChannel messengerCredentialsResponse =
      ConversationChannelMessenger.builder()
          .setCredentials(StaticTokenCredentials.builder().setToken("my token").build())
          .setCallbackSecret("foo value")
          .setState(
              CredentialState.builder()
                  .setStatus(CredentialStateStatusType.ACTIVE)
                  .setDescription("")
                  .build())
          .setChannelKnownId("a channel id")
          .build();

  public static final AppRequestParameters appRequest =
      AppRequestParameters.builder()
          .setChannelCredentials(
              Arrays.asList(
                  ConversationChannelMessenger.builder()
                      .setCredentials(StaticTokenCredentials.builder().setToken("my token").build())
                      .setCallbackSecret("foo value")
                      .setChannelKnownId("a channel id")
                      .build(),
                  ConversationChannelSMS.builder()
                      .setCredentials(
                          StaticBearerCredentials.builder()
                              .setClaimedIdentity("my identity")
                              .setToken("sms token")
                              .build())
                      .setCallbackSecret("")
                      .setChannelKnownId("")
                      .build()))
          .setMetadataReportView(ConversationMetadataReportViewType.NONE)
          .setDisplayName("Brazil App")
          .setRetentionPolicy(
              RetentionPolicy.builder()
                  .setRetentionType(RetentionPolicyType.CONVERSATION_EXPIRE_POLICY)
                  .setTtlDays(180)
                  .build())
          .setDispatchRetentionPolicy(DispatchRetentionPolicy.builder().setTtlDays(0).build())
          .setProcessingMode(ProcessingModeType.DISPATCH)
          .setSmartConversation(SmartConversation.builder().setEnabled(true).build())
          .setCallbackSettings(
              CallbackSettings.builder().setSecretForOverriddenCallbackUrls("my secret").build())
          .build();
  public static final App expectedAPPResponse =
      App.builder()
          .setId("an app id")
          .setChannelCredentials(Collections.singletonList(messengerCredentialsResponse))
          .setMetadataReportView(ConversationMetadataReportViewType.NONE)
          .setDisplayName("Brazil App")
          .setRetentionPolicy(
              RetentionPolicy.builder()
                  .setRetentionType(RetentionPolicyType.CONVERSATION_EXPIRE_POLICY)
                  .setTtlDays(180)
                  .build())
          .setDispatchRetentionPolicy(DispatchRetentionPolicy.builder().setTtlDays(0).build())
          .setProcessingMode(ProcessingModeType.DISPATCH)
          .setSmartConversation(SmartConversation.builder().setEnabled(true).build())
          .setPersistMessageStatus(PersistMessageStatus.builder().setEnabled(false).build())
          .setMessageSearch(MessageSearch.builder().setEnabled(true).build())
          .setCallbackSettings(
              CallbackSettings.builder().setSecretForOverriddenCallbackUrls("my secret").build())
          .setDeliveryReportBasedFallback(
              DeliveryReportBasedFallback.builder()
                  .setEnabled(true)
                  .setDeliveryReportWaitingTime(455)
                  .build())
          .setRateLimits(
              RateLimits.builder().setInBound(100L).setOutBound(20L).setWebhooks(200L).build())
          .setQueueStats(QueueStats.builder().setOutboundSize(0L).setOutboundLimit(500000L).build())
          .build();

  public static final Collection<App> expectedAppList =
      Collections.singletonList(expectedAPPResponse);

  @Test
  void convertAppResponseList() {

    Assertions.assertThat(AppConverter.convert(AppDtoTest.expectedListAppsResponseDto))
        .usingRecursiveComparison()
        .isEqualTo(expectedAppList);
  }

  @Test
  void convertAppCreateRequest() {

    Assertions.assertThat(AppConverter.convertForCreate(appRequest))
        .usingRecursiveComparison()
        .isEqualTo(AppDtoTest.appCreateRequestDto);
  }

  @Test
  void convertAppUpdateRequest() {

    Assertions.assertThat(AppConverter.convertForUpdate(appRequest))
        .usingRecursiveComparison()
        .isEqualTo(AppDtoTest.appCreateRequestDto);
  }
}
