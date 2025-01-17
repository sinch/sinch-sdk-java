package com.sinch.sdk.domains.mailgun.models.v1.emails.request;

import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.databind.multipart.ObjectMapperTest;
import com.sinch.sdk.core.http.HttpMapper;
import java.io.File;
import java.time.Instant;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@TestWithResources
public class SendMimeEmailRequestTest extends BaseTest {

  public static Map<String, Object> expected;
  static File fileAttachment1;
  static File fileAttachment2;

  static {
    ClassLoader classLoader = SendMimeEmailRequestTest.class.getClassLoader();
    fileAttachment1 =
        new File(
            classLoader.getResource("domains/mailgun/v1/emails/request/attachment1.txt").getFile());
    fileAttachment2 =
        new File(
            classLoader.getResource("domains/mailgun/v1/emails/request/attachment2.txt").getFile());

    expected =
        ObjectMapperTest.fillMap(
            // spotless:off
            "to", Arrays.asList("aRecipient@mailgun-by-sinch.com"),
            "message", fileAttachment1,
            "template","template value",
            "t:version","2",
            "t:text","true",
            "t:variables","{\"key\": \"value\"}",
            "o:tag", Arrays.asList("tag1", "tag2"),
            "o:dkim","true",
            "o:secondary-dkim","example.com/s1",
            "o:secondary-dkim-public","public.example.com/s1",
            "o:deliverytime", "Sat, 22 Jan 2000 11:23:45 GMT",
            "o:deliverytime-optimize-period", "29h",
            "o:time-zone-localize","02:04PM",
            "o:testmode", "false",
            "o:tracking","htmlonly",
            "o:tracking-clicks","true",
            "o:tracking-opens","false",
            "o:require-tls","true",
            "o:skip-verification","false",
            "o:sending-ip","192.168.0.10",
            "o:sending-ip-pool","sending pool ID",
            "o:tracking-pixel-location-top","htmlonly",
            "recipient-variables","{\"cc-dest@sinch.com\":{\"variable1\":\"value1\"}}",
            "v:my-var-key1", Arrays.asList("a-var-value1","a-var-value2"),
            "v:my-var-key2", Arrays.asList("a-var-value3"),
            "h:my-header-key1", Arrays.asList("a-header-value1","a-header-value2"),
            "h:my-header-key2", Arrays.asList("a-header-value3")
            // spotless:on
            );
  }

  public static SendMimeEmailRequest sendMimEmailRequest =
      SendMimeEmailRequest.builder()
          .setMessage(fileAttachment1)
          .setTo(Arrays.asList("aRecipient@mailgun-by-sinch.com"))
          .setRecipientVariables(SendEmailRequestTest.RECIPIENT_VARIABLES)
          .setTemplate("template value")
          .setOverrideProperties(
              OverrideProperties.builder()
                  .setTag(Arrays.asList("tag1", "tag2"))
                  .setDeliveryTime(Instant.parse("2000-01-22T11:23:45Z"))
                  .setTestMode(false)
                  .setEnableDkimSignature(true)
                  .setSecondaryDkim("example.com/s1")
                  .setSecondaryDkimPublic("public.example.com/s1")
                  .setDeliveryTimeOptimizePeriod(29)
                  .setTimeZoneLocalize("02:04PM")
                  .setTracking(TrueFalseHtmlonlyEnum.HTMLONLY)
                  .setTrackingClicks(TrueFalseHtmlonlyEnum.TRUE)
                  .setTrackingOpens(false)
                  .setRequireTls(true)
                  .setSkipVerification(false)
                  .setSendingIp("192.168.0.10")
                  .setSendingIpPool("sending pool ID")
                  .setTrackingPixelLocationTop(TrueFalseHtmlonlyEnum.HTMLONLY)
                  .build())
          .setTemplateProperties(
              TemplateProperties.builder()
                  .setText(true)
                  .setVersion("2")
                  .setVariables("{\"key\": \"value\"}")
                  .build())
          .setCustomVariables(SendEmailRequestTest.CUSTOM_VARIABLES)
          .setCustomHeaders(SendEmailRequestTest.CUSTOM_HEADERS)
          .build();

  @Test
  void serialize() {
    Object serialized =
        new HttpMapper()
            .serializeFormParameters(Arrays.asList("multipart/form-data"), sendMimEmailRequest);

    TestHelpers.recursiveEquals(expected, serialized);
  }

  @Test
  void serializeSendEmailHtmlInlineRequestRawRecipientVariables() {

    Object serialized =
        new HttpMapper()
            .serializeFormParameters(
                Arrays.asList("multipart/form-data"),
                SendMimeEmailRequest.builder()
                    .setRecipientVariables("{\"cc-dest@sinch.com\":{\"variable1\":\"value1\"}}")
                    .build());

    TestHelpers.recursiveEquals(
        ObjectMapperTest.fillMap(
            "recipient-variables", "{\"cc-dest@sinch.com\":{\"variable1\":\"value1\"}}"),
        serialized);
  }
}
