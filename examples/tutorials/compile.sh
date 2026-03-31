#!/bin/sh

DIRECTORIES="
voice/capture-leads-app
"

for DIRECTORY in $DIRECTORIES
do
 (cd "$DIRECTORY" && echo "$PWD" && mvn -Puse-version clean package) || exit 1
done
