package com.mycompany.app.voice;

import com.sinch.sdk.domains.voice.models.v2.helpers.Calls;
import com.sinch.sdk.domains.voice.models.v2.helpers.SinchEventResponses;
import com.sinch.sdk.domains.voice.models.v2.sinchevents.VoiceSinchEvent;
import com.sinch.sdk.domains.voice.models.v2.sinchevents.VoiceSinchEventResponse;
import com.sinch.sdk.domains.voice.models.v2.svaml.recording.RecordingDestinationType;
import com.sinch.sdk.domains.voice.models.v2.svaml.recording.RecordingFormatType;
import com.sinch.sdk.domains.voice.models.v2.svaml.recording.RecordingType;
import com.sinch.sdk.domains.voice.models.v2.svaml.recording.TranscriptionOptions;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("VoiceServerBusinessLogic")
public class ServerBusinessLogic {

  private static final Logger LOGGER = Logger.getLogger(ServerBusinessLogic.class.getName());

  @Value("${STORAGE_DESTINATION_URL:}")
  private String storageDestinationUrl;

  @Value("${STORAGE_CREDENTIALS:}")
  private String storageCredentials;

  public VoiceSinchEventResponse incoming(VoiceSinchEvent event) {

    // SVAML commands: answer -> start recording -> play a recording notice
    return SinchEventResponses.incomingCallResponse(
            commands ->
                commands
                    .answer()
                    .recording(
                        storageDestination(),
                        storageDestinationUrl,
                        storageCredentials,
                        recording ->
                            recording
                                .name("main-recording")
                                .format(RecordingFormatType.MP3)
                                .recordingType(RecordingType.COMBINED)
                                .transcriptionOptions(
                                    TranscriptionOptions.builder()
                                        .setIsEnabled(true)
                                        .setLocale("en-US")
                                        .build()))
                    .text(
                        "This call may be recorded for quality and compliance purposes.",
                        "Emma",
                        notice -> notice.name("recording-notice"))
            // Add further SVAML commands here, e.g.:
            // .bridgeCall("agent-bridge")
            )
        .onHangup(Calls.hangup())
        .build();
  }

  public VoiceSinchEventResponse other(VoiceSinchEvent event) {

    LOGGER.info("Unhandled event: " + event.getEvent());

    return SinchEventResponses.response();
  }

  // Infer the storage provider from the destination URL scheme
  private RecordingDestinationType storageDestination() {
    if (storageDestinationUrl.startsWith("s3://")) {
      return RecordingDestinationType.AWS;
    }
    if (storageDestinationUrl.startsWith("gs://")) {
      return RecordingDestinationType.GCP;
    }
    return RecordingDestinationType.AZURE;
  }
}
