package com.mycompany.app.sms;

import com.sinch.sdk.domains.sms.models.v1.deliveryreports.DeliveryReport;
import com.sinch.sdk.domains.sms.models.v1.inbounds.InboundMessage;
import com.sinch.sdk.domains.sms.models.v1.sinchevents.SmsSinchEvent;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;

@Component("SMSServerBusinessLogic")
public class ServerBusinessLogic {

  private static final Logger LOGGER = Logger.getLogger(ServerBusinessLogic.class.getName());

  public void processInboundEvent(InboundMessage event) {
    trace(event);
  }

  public void processDeliveryReportEvent(DeliveryReport event) {
    trace(event);
  }

  private void trace(SmsSinchEvent event) {
    LOGGER.info("Handle event: " + event);
  }
}
