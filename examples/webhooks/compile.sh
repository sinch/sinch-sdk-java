#!/bin/sh

mvn clean spotless:apply || exit 1

./mvnw clean compile || exit 1
