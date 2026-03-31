package voice;

import com.sinch.sdk.domains.voice.api.v1.CalloutsService;
import com.sinch.sdk.domains.voice.api.v1.VoiceService;
import com.sinch.sdk.domains.voice.models.v1.callouts.request.CalloutRequestTTS;
import com.sinch.sdk.domains.voice.models.v1.destination.DestinationPstn;
import java.util.logging.Logger;

public class Snippet {

  private static final Logger LOGGER = Logger.getLogger(Snippet.class.getName());

  public static String execute(VoiceService voiceService) {

    CalloutsService calloutsService = voiceService.callouts();

    String phoneNumber = "PHONE_NUMBER";
    String message = "Hello, this is a call from Sinch. Congratulations! You made your first call.";

    LOGGER.info("Calling '" + phoneNumber + '"');

    CalloutRequestTTS parameters =
        CalloutRequestTTS.builder()
            .setDestination(DestinationPstn.from(phoneNumber))
            .setText(message)
            .build();

    String callId = calloutsService.textToSpeech(parameters);

    LOGGER.info("Call started with id: '" + callId + '"');

    return callId;
  }
}
