#!/bin/sh

(cd tutorials/sms/auto-subscribe-app && mvn clean package)
(cd tutorials/voice/handle-incoming-call && mvn clean package)
