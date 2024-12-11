package com.sinch.sdk.domains.mailgun.models.v1.emails.request;

import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.databind.multipart.ObjectMapperTest;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.domains.mailgun.models.v1.emails.request.SendEmailRequest.TrackingClicksEnum;
import com.sinch.sdk.domains.mailgun.models.v1.emails.request.SendEmailRequest.TrackingEnum;
import java.io.File;
import java.time.Instant;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@TestWithResources
public class SendEmailRequestTest extends BaseTest {

  static Map<String, Object> expected;
  static File fileAttachment1;
  static File fileAttachment2;

  static {
    ClassLoader classLoader = SendEmailRequestTest.class.getClassLoader();
    fileAttachment1 =
        new File(
            classLoader.getResource("domains/mailgun/v1/emails/request/attachment1.txt").getFile());
    fileAttachment2 =
        new File(
            classLoader.getResource("domains/mailgun/v1/emails/request/attachment2.txt").getFile());

    expected =
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
              "o:skip-verification","true",
              "o:sending-ip","192.168.0.10",
              "o:sending-ip-pool","sending pool ID",
              "o:tracking-pixel-location-top","foo",
              "recipient-variables","{\"cc-dest@sinch.com\": {\"variable1\": \"value1\"}}"
              // spotless:on
            );
  }

  public static SendEmailRequest sendEmailRequest =
      SendEmailRequest.builder()
          .setInline(Arrays.asList(fileAttachment2))
          .setAttachment(Arrays.asList(fileAttachment1, fileAttachment2))
          .setTag(Arrays.asList("tag1", "tag2"))
          .setDeliveryTime(Instant.parse("2000-01-22T11:23:45Z"))
          .setTestMode(false)
          .setTo(Arrays.asList("aRecipient@mailgun-by-sinch.com"))
          .setFrom("User <JavaSdkUser@sinch.com>")
          .setText("Sent from Sinch SDK Java with 📧")
          .setTemplateText(true)
          .setHtml("&#128231; HTML sent with <bold>Sinch SDK Java</bold>")
          .setSubject("📧 From Sinch SDK Java")
          .setCc(Arrays.asList("cc-dest@sinch.com"))
          .setBcc(Arrays.asList("bcc-dest@sinch.com"))
          .setAmpHtml("amp html value")
          .setTemplateVersion("2")
          .setTemplateVariables("{\"key\": \"value\"}")
          .setEnableDkimSignature(true)
          .setSecondaryDkim("example.com/s1")
          .setSecondaryDkimPublic("public.example.com/s1")
          .setDeliveryTimeOptimizePeriod(29)
          .setTimezoneLocalize("02:04PM")
          .setTracking(TrackingEnum.HTMLONLY)
          .setTrackingClicks(TrackingClicksEnum.TRUE)
          .setTrackingOpens(false)
          .setRequireTls(true)
          .setSkipVerification(true)
          .setSendingIp("192.168.0.10")
          .setSendingIpPool("sending pool ID")
          .setTrackingPixelLocationTop("foo")
          .setRecipientVariables("{\"cc-dest@sinch.com\": {\"variable1\": \"value1\"}}")
          .setTemplate("template value")
          .build();

  @Test
  void serialize() {
    Object serialized =
        new HttpMapper()
            .serializeFormParameters(Arrays.asList("multipart/form-data"), sendEmailRequest);

    TestHelpers.recursiveEquals(expected, serialized);
  }
}
