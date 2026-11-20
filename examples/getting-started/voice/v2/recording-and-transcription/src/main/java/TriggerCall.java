import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.voice.models.v2.calls.request.StartCallRequest;
import com.sinch.sdk.domains.voice.models.v2.calls.response.StartCallResponse;
import com.sinch.sdk.domains.voice.models.v2.helpers.CommandsSequenceCreator;
import com.sinch.sdk.domains.voice.models.v2.svaml.recording.RecordingDestinationType;
import com.sinch.sdk.domains.voice.models.v2.svaml.recording.RecordingFormatType;
import com.sinch.sdk.domains.voice.models.v2.svaml.recording.RecordingType;
import com.sinch.sdk.domains.voice.models.v2.svaml.recording.TranscriptionOptions;
import java.util.logging.Logger;

public class TriggerCall {

  private static final Logger LOGGER = Logger.getLogger(TriggerCall.class.getName());

  public static void main(String[] args) {

    String sinchNumber = Settings.get("SINCH_NUMBER", "MY_SINCH_NUMBER");
    String destinationNumber = Settings.get("DESTINATION_NUMBER", "MY_DESTINATION_NUMBER");
    String storageDestinationUrl =
        Settings.get("STORAGE_DESTINATION_URL", "MY_STORAGE_DESTINATION_URL");
    String storageCredentials = Settings.get("STORAGE_CREDENTIALS", "MY_STORAGE_CREDENTIALS");

    // Infer the storage provider from the destination URL scheme
    RecordingDestinationType storageDestination;
    if (storageDestinationUrl.startsWith("s3://")) {
      storageDestination = RecordingDestinationType.AWS;
    } else if (storageDestinationUrl.startsWith("gs://")) {
      storageDestination = RecordingDestinationType.GCP;
    } else {
      storageDestination = RecordingDestinationType.AZURE;
    }

    SinchClient sinchClient = Settings.sinchClient();

    // SVAML commands: dial -> on answer start recording and play a recording notice
    // -> on hangup stop recording, which uploads the file to the storage bucket
    StartCallRequest request =
        StartCallRequest.builder()
            .setCommands(
                CommandsSequenceCreator.create()
                    .dial(
                        destinationNumber,
                        dial ->
                            dial.from(sinchNumber)
                                .name("recorded-call")
                                .timeoutDurationSeconds(30)
                                .maxDurationSeconds(3600)
                                .onAnswer(
                                    answered ->
                                        answered
                                            .recording(
                                                storageDestination,
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
                                                "This call is being recorded.",
                                                "Emma",
                                                notice -> notice.name("recording-notice")))
                                .onHangup(hangup -> hangup.stopRecording("main-recording")))
                    .build())
            .build();

    LOGGER.info(
        String.format(
            "Calling %s with recording enabled (%s) ...", destinationNumber, storageDestination));

    StartCallResponse response = sinchClient.voice().v2().calls().start(request);

    LOGGER.info("Call created with recording: " + response);
    LOGGER.info("Recording will be uploaded to: " + storageDestinationUrl);
  }
}
