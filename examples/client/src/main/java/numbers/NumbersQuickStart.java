package numbers;

import com.sinch.sdk.domains.numbers.api.v1.NumbersService;
import java.util.logging.Logger;

public class NumbersQuickStart {

  private static final Logger LOGGER = Logger.getLogger(NumbersQuickStart.class.getName());

  private final NumbersService numbersService;

  public NumbersQuickStart(NumbersService numbersService) {
    this.numbersService = numbersService;

    // Insert your application logic or business process here
    LOGGER.info("Snippet execution");
  }
}
