#!/bin/sh

DIRECTORIES="
conversation/respond-to-incoming-message
conversation/send-text-message
numbers/rent-and-configure
numbers/rent-first-available-number
numbers/search-available
sms/send-sms-message
sms/respond-to-incoming-message
verification/user-verification-using-sms-pin
voice/respond-to-incoming-call
voice/make-a-call
voice/v2/answering-machine-detection
voice/v2/call-forwarding
voice/v2/call-pacing
voice/v2/handle-inbound-pstn-call
voice/v2/number-masking
voice/v2/outbound-text-to-speech
voice/v2/recording-and-transcription
voice/v2/text-to-speech-voices
voice/v2/track-call-status
"

for DIRECTORY in $DIRECTORIES
do
 (cd "$DIRECTORY" && echo "$PWD" && mvn -Puse-version clean package) || exit 1
done
