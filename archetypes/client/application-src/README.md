# Client application based onto Sinch Java SDK

This directory contains a client application based onto [Sinch SDK java](https://github.com/sinch/sinch-sdk-java)

# Prerequisites

- JDK 8 or later (Sinch SDK Java is requiring java 8 only but client application can use latest available version)
- [Maven](https://maven.apache.org/)
- [Sinch account](https://dashboard.sinch.com)

## Configuration

Edit [config.properties](src/main/resources/config.properties) file to set credentials to be used by client.

You need to fill the following settings with your Sinch account information:
- `SINCH_PROJECT_ID`=Your Sinch Project ID
- `SINCH_KEY_ID`=Your Sinch Key ID
- `SINCH_KEY_SECRET`=Your Sinch Key Secret

## Usage

1. Edit configuration file
See above for Configuration paragraph

2. Application generation

   Application generation command:
   ```sh
   mvn package
   ```
3. Execute application
   ```sh
   java -jar target/sinch-java-sdk-client-application-1.0-SNAPSHOT-jar-with-dependencies.jar
   ```
