package com.sinch.sdk.domains.mailgun.models.v1.emails.request;

import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.databind.multipart.ObjectMapperTest;
import com.sinch.sdk.core.http.HttpMapper;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@TestWithResources
public class ResendRequestTest extends BaseTest {

  public static Map<String, Object> expectedResendRequest =
      ObjectMapperTest.fillMap(
          "to",
          "recipient1@mailgun-by-sinch.com,recipient2@mailgun-by-sinch.com,"
              + " recipient3@mailgun-by-sinch.com");

  public static ResendRequest resentRequest =
      ResendRequest.builder()
          .setTo(
              Arrays.asList(
                  "recipient1@mailgun-by-sinch.com",
                  "recipient2@mailgun-by-sinch.com, recipient3@mailgun-by-sinch.com"))
          .build();

  @Test
  void serializeResendRequest() {

    Object serialized =
        HttpMapper.getInstance()
            .serializeFormParameters(Arrays.asList("multipart/form-data"), resentRequest);

    TestHelpers.recursiveEquals(serialized, expectedResendRequest);
  }
}
