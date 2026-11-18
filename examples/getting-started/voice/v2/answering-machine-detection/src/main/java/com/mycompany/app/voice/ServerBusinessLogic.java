package com.mycompany.app.voice;

import com.sinch.sdk.domains.voice.models.v2.helpers.Calls;
import com.sinch.sdk.domains.voice.models.v2.helpers.SinchEventResponses;
import com.sinch.sdk.domains.voice.models.v2.sinchevents.VoiceSinchEvent;
import com.sinch.sdk.domains.voice.models.v2.sinchevents.VoiceSinchEventResponse;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;

@Component("VoiceServerBusinessLogic")
public class ServerBusinessLogic {

  private static final Logger LOGGER = Logger.getLogger(ServerBusinessLogic.class.getName());

  public VoiceSinchEventResponse incoming(VoiceSinchEvent event) {

    // Inbound call: answer and run AMD as the first command after answering.
    // AMD fires one of: onHuman, onMachine, onBeep, onUnknown.
    return SinchEventResponses.response(
        commands ->
            commands
                .answer()
                .amd(
                    amd ->
                        amd
                            // Live human: play a personalized greeting
                            .onHuman(
                                human ->
                                    human.text(
                                        "Hello! This is a call from Acme Corp. An agent will be"
                                            + " with you shortly.",
                                        "Emma",
                                        greeting ->
                                            greeting
                                                .name("human-greeting")
                                                .onFinish(Calls.hangup())))
                            // Machine greeting (no beep yet): hang up silently
                            .onMachine(Calls.hangup())
                            // Beep detected: leave voicemail right after the beep
                            .onBeep(
                                beep ->
                                    beep.text(
                                        "Hi, this is Acme Corp calling about your recent inquiry."
                                            + " Please call us back at 555-1234. Thank you.",
                                        "Emma",
                                        voicemail ->
                                            voicemail
                                                .name("voicemail-message")
                                                .onFinish(Calls.hangup())))
                            // Unknown result: hang up safely
                            .onUnknown(Calls.hangup())));
  }

  public VoiceSinchEventResponse amdVerdict(VoiceSinchEvent event) {

    // AMD verdict events: this is how you see which branch fired, server-side
    LOGGER.info("AMD verdict: " + event.getEvent());

    return SinchEventResponses.response();
  }

  public VoiceSinchEventResponse other(VoiceSinchEvent event) {

    LOGGER.info("Unhandled event: " + event.getEvent());

    return SinchEventResponses.response();
  }
}
