package com.sinch.sdk.domains.mailgun.models.v1.emails.request;

import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.databind.multipart.ObjectMapperTest;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.utils.Pair;
import java.io.File;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@TestWithResources
public class SendEmailRequestTest extends BaseTest {

  public static Map<String, Object> expectedEmailHtmlInline, expectedEmailHtmlInTemplate;
  static File fileAttachment1;
  static File fileAttachment2;

  public static Map<String, Collection<Pair<String, Object>>> RECIPIENT_VARIABLES =
      Collections.singletonMap(
          "cc-dest@sinch.com", Collections.singletonList(Pair.of("variable1", "value1")));
  public static List<Pair<String, String>> CUSTOM_VARIABLES;
  public static List<Pair<String, String>> CUSTOM_HEADERS;

  static {
    ClassLoader classLoader = SendEmailRequestTest.class.getClassLoader();
    fileAttachment1 =
        new File(
            classLoader.getResource("domains/mailgun/v1/emails/request/attachment1.txt").getFile());
    fileAttachment2 =
        new File(
            classLoader.getResource("domains/mailgun/v1/emails/request/attachment2.txt").getFile());

    CUSTOM_VARIABLES =
        Arrays.asList(
            Pair.of("my-var-key1", "a-var-value1"),
            Pair.of("my-var-key1", "a-var-value2"),
            Pair.of("my-var-key2", "a-var-value3"));
    CUSTOM_HEADERS =
        Arrays.asList(
            Pair.of("my-header-key1", "a-header-value1"),
            Pair.of("my-header-key1", "a-header-value2"),
            Pair.of("my-header-key2", "a-header-value3"));

    expectedEmailHtmlInline =
        ObjectMapperTest.fillMap(
            // spotless:off
            "from", "User <JavaSdkUser@sinch.com>",
            "to", Arrays.asList("aRecipient@mailgun-by-sinch.com"),
            "cc",Arrays.asList("cc-dest@sinch.com"),
            "bcc",Arrays.asList("bcc-dest@sinch.com"),
            "subject", "\uD83D\uDCE7 From Sinch SDK Java",
            "text", "Sent from Sinch SDK Java with 📧",
            "html", "&#128231; HTML sent with <bold>Sinch SDK Java</bold>",
            "amp-html", "amp html value",
            "attachment", Arrays.asList(fileAttachment1, fileAttachment2),
            "inline",Arrays.asList( fileAttachment2),
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
            "o:skip-verification","true",
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

    expectedEmailHtmlInTemplate =
        ObjectMapperTest.fillMap(
            // spotless:off
              "from", "User <JavaSdkUser@sinch.com>",
              "to", Arrays.asList("aRecipient@mailgun-by-sinch.com"),
              "cc",Arrays.asList("cc-dest@sinch.com"),
              "bcc",Arrays.asList("bcc-dest@sinch.com"),
              "subject", "\uD83D\uDCE7 From Sinch SDK Java",
              "text", "Sent from Sinch SDK Java with 📧",
              "amp-html", "amp html value",
              "attachment", Arrays.asList(fileAttachment1, fileAttachment2),
              "inline",Arrays.asList( fileAttachment2),
              "template","template value",
              "t:version","2",
              "t:text","true",
              "t:variables","{\"key\":\"value\"}",
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
              "o:skip-verification","true",
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

  public static SendEmailRequest sendEmailHtmlInlineRequest =
      SendEmailHtmlInlineRequest.builder()
          .setInline(Arrays.asList(fileAttachment2))
          .setAttachment(Arrays.asList(fileAttachment1, fileAttachment2))
          .setTo(Arrays.asList("aRecipient@mailgun-by-sinch.com"))
          .setFrom("User <JavaSdkUser@sinch.com>")
          .setText("Sent from Sinch SDK Java with 📧")
          .setHtml("&#128231; HTML sent with <bold>Sinch SDK Java</bold>")
          .setSubject("📧 From Sinch SDK Java")
          .setCc(Arrays.asList("cc-dest@sinch.com"))
          .setBcc(Arrays.asList("bcc-dest@sinch.com"))
          .setAmpHtml("amp html value")
          .setRecipientVariables(RECIPIENT_VARIABLES)
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
                  .setSkipVerification(true)
                  .setSendingIp("192.168.0.10")
                  .setSendingIpPool("sending pool ID")
                  .setTrackingPixelLocationTop(TrueFalseHtmlonlyEnum.HTMLONLY)
                  .build())
          .setCustomVariables(CUSTOM_VARIABLES)
          .setCustomHeaders(CUSTOM_HEADERS)
          .build();

  public static SendEmailRequest sendEmailHtmlInTemplateRequest =
      SendEmailHtmlInTemplateRequest.builder()
          .setInline(Arrays.asList(fileAttachment2))
          .setAttachment(Arrays.asList(fileAttachment1, fileAttachment2))
          .setTo(Arrays.asList("aRecipient@mailgun-by-sinch.com"))
          .setFrom("User <JavaSdkUser@sinch.com>")
          .setText("Sent from Sinch SDK Java with 📧")
          .setSubject("📧 From Sinch SDK Java")
          .setCc(Arrays.asList("cc-dest@sinch.com"))
          .setBcc(Arrays.asList("bcc-dest@sinch.com"))
          .setAmpHtml("amp html value")
          .setRecipientVariables(RECIPIENT_VARIABLES)
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
                  .setSkipVerification(true)
                  .setSendingIp("192.168.0.10")
                  .setSendingIpPool("sending pool ID")
                  .setTrackingPixelLocationTop(TrueFalseHtmlonlyEnum.HTMLONLY)
                  .build())
          .setTemplateProperties(
              TemplateProperties.builder()
                  .setText(true)
                  .setVersion("2")
                  .setVariables(Collections.singletonMap("key", "value"))
                  .build())
          .setCustomVariables(CUSTOM_VARIABLES)
          .setCustomHeaders(CUSTOM_HEADERS)
          .build();

  @Test
  void serializeSendEmailHtmlInlineRequest() {
    Object serialized =
        HttpMapper.getInstance()
            .serializeFormParameters(
                Arrays.asList("multipart/form-data"), sendEmailHtmlInlineRequest);

    TestHelpers.recursiveEquals(expectedEmailHtmlInline, serialized);
  }

  @Test
  void serializeSendEmailHtmlInlineRequestRawRecipientVariables() {

    Object serialized =
        HttpMapper.getInstance()
            .serializeFormParameters(
                Arrays.asList("multipart/form-data"),
                SendEmailHtmlInlineRequest.builder()
                    .setRecipientVariables("{\"cc-dest@sinch.com\":{\"variable1\":\"value1\"}}")
                    .build());

    TestHelpers.recursiveEquals(
        ObjectMapperTest.fillMap(
            "recipient-variables", "{\"cc-dest@sinch.com\":{\"variable1\":\"value1\"}}"),
        serialized);
  }

  @Test
  void serializeSendEmailHtmlInTemplateRequest() {
    Object serialized =
        HttpMapper.getInstance()
            .serializeFormParameters(
                Arrays.asList("multipart/form-data"), sendEmailHtmlInTemplateRequest);

    TestHelpers.recursiveEquals(expectedEmailHtmlInTemplate, serialized);
  }

  @Test
  void serializeSendEmailHtmlInTemplateRequestRawVariables() {

    Object serialized =
        HttpMapper.getInstance()
            .serializeFormParameters(
                Arrays.asList("multipart/form-data"),
                SendEmailHtmlInTemplateRequest.builder()
                    .setTemplateProperties(
                        TemplateProperties.builder().setVariables("{\"key\":\"value\"}").build())
                    .build());

    TestHelpers.recursiveEquals(
        ObjectMapperTest.fillMap("t:variables", "{\"key\":\"value\"}"), serialized);
  }
}
