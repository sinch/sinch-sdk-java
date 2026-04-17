package com.sinch.sdk.domains.conversation.models.v1.consents;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.consents.internal.ConsentsListResponseInternal;
import com.sinch.sdk.domains.conversation.models.v1.consents.response.AuditRecord;
import com.sinch.sdk.domains.conversation.models.v1.consents.response.AuditRecordsResponse;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.Test;

@TestWithResources
public class ConsentsDtoTest extends ConversationBaseTest {

  @GivenJsonResource("/domains/conversation/v1/consents/ConsentsListResponseDtoPage0.json")
  ConsentsListResponseInternal loadedConsentsListResponseDtoPage0;

  @GivenJsonResource("/domains/conversation/v1/consents/ConsentsListResponseDtoPage1.json")
  ConsentsListResponseInternal loadedConsentsListResponseDtoPage1;

  @GivenJsonResource("/domains/conversation/v1/consents/AuditRecordsResponseDto.json")
  AuditRecordsResponse loadedAuditRecordsResponseDto;

  public static Identity expectedIdentityDto =
      Identity.builder().setIdentity("an identity value").build();

  public static ConsentsListResponseInternal expectedConsentsListResponseDtoPage0 =
      ConsentsListResponseInternal.builder()
          .setIdentities(
              Arrays.asList(
                  expectedIdentityDto,
                  Identity.builder().setIdentity("a 2nd identity value").build()))
          .setNextPageToken("the next page token value")
          .build();

  public static ConsentsListResponseInternal expectedConsentsListResponseDtoPage1 =
      ConsentsListResponseInternal.builder()
          .setIdentities(
              Collections.singletonList(
                  Identity.builder().setIdentity("a 3rd identity value").build()))
          .setNextPageToken("")
          .build();

  public static AuditRecord expectedAuditRecordDto =
      AuditRecord.builder()
          .setOrigin(AuditRecord.OriginEnum.ORIGIN_API)
          .setOperation(AuditRecord.OperationEnum.OPERATION_INSERT)
          .setListType(ConsentsListType.OPT_OUT_ALL)
          .setProjectId("a project id")
          .setAppId("an app id")
          .setDatetime(Instant.parse("2025-06-06T14:42:56.031323Z"))
          .build();

  public static AuditRecordsResponse expectedAuditRecordsResponseDto =
      AuditRecordsResponse.builder()
          .setIdentity(expectedIdentityDto)
          .setAuditRecords(Collections.singletonList(expectedAuditRecordDto))
          .build();

  @Test
  void deserializeConsentsListResponseDtoPage0() {
    TestHelpers.recursiveEquals(
        loadedConsentsListResponseDtoPage0, expectedConsentsListResponseDtoPage0);
  }

  @Test
  void deserializeConsentsListResponseDtoPage1() {
    TestHelpers.recursiveEquals(
        loadedConsentsListResponseDtoPage1, expectedConsentsListResponseDtoPage1);
  }

  @Test
  void deserializeAuditRecordsResponseDto() {
    TestHelpers.recursiveEquals(loadedAuditRecordsResponseDto, expectedAuditRecordsResponseDto);
  }
}
