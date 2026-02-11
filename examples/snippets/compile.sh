#!/bin/sh

mvn clean spotless:apply || exit 1

./mvnw  -Puse-version clean compile || exit 1
