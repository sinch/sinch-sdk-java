package voice;

import com.sinch.sdk.domains.voice.api.v1.VoiceService;

public class VoiceQuickStart {

  private final VoiceService voiceService;

  public VoiceQuickStart(VoiceService voiceService) {
    this.voiceService = voiceService;

    // Insert your application logic or business process here
    Snippet.execute(this.voiceService);
  }
}
