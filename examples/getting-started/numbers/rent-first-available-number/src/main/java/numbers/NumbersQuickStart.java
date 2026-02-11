package numbers;

import com.sinch.sdk.domains.numbers.api.v1.NumbersService;

public class NumbersQuickStart {

  private final NumbersService numbersService;

  public NumbersQuickStart(NumbersService numbersService) {
    this.numbersService = numbersService;

    // Insert your application logic or business process here
    Snippet.execute(this.numbersService);
  }
}
