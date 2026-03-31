package voice;

import com.sinch.sdk.domains.voice.api.v1.VoiceService;
import java.util.logging.Logger;

public class VoiceQuickStart {

  private static final Logger LOGGER = Logger.getLogger(VoiceQuickStart.class.getName());

  private final VoiceService voiceService;

  public VoiceQuickStart(VoiceService voiceService) {
    this.voiceService = voiceService;

    // Insert your application logic or business process here
    LOGGER.info("Snippet execution");
  }
}
