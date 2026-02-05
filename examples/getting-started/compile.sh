#!/bin/sh

DIRECTORIES="
conversation/send-text-message
numbers/rent-and-configure
numbers/rent-first-available-number
numbers/search-available
sms/send-sms-message
sms/respond-to-incoming-message
verification/user-verification-using-sms-pin
voice/respond-to-incoming-call
voice/make-a-call
"

for DIRECTORY in $DIRECTORIES
do
 (cd "$DIRECTORY" && echo "$PWD" && mvn -Puse-version clean package) || exit 1
done
