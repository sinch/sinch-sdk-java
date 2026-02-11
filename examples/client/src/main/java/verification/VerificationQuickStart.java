package verification;

import com.sinch.sdk.domains.verification.api.v1.VerificationService;
import java.util.logging.Logger;

public class VerificationQuickStart {

  private static final Logger LOGGER = Logger.getLogger(VerificationQuickStart.class.getName());

  private final VerificationService verificationService;

  public VerificationQuickStart(VerificationService verificationService) {
    this.verificationService = verificationService;

    // Insert your application logic or business process here
    LOGGER.info("Snippet execution");
  }
}
