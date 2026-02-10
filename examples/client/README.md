# Client application template based onto Sinch Java SDK

This directory contains a client application based onto [Sinch SDK java](https://github.com/sinch/sinch-sdk-java)

# Prerequisites

- JDK 8 or later (Sinch SDK Java is requiring java 8 only but client application can use latest available version)
- [Maven](https://maven.apache.org/)
- [Sinch account](https://dashboard.sinch.com)

## Configuration

Edit [config.properties](src/main/resources/config.properties) file to set credentials to be used to configure the SinchClient.

- To use Numbers or SMS, you need to fill the following settings with your Sinch account information:
  - `SINCH_PROJECT_ID`=Your Sinch Project ID
  - `SINCH_KEY_ID`=Your Sinch Key ID
  - `SINCH_KEY_SECRET`=Your Sinch Key Secret
- To use [Verification](https://developers.sinch.com/docs/verification) or [Voice](https://developers.sinch.com/docs/voice) you will need application credentials and fill [config.properties](src/main/resources/config.properties) dedicated section.
- To use [SMS](https://developers.sinch.com/docs/sms) for regions other than US/EU, you will need service plan ID credentials and fill [config.properties](src/main/resources/config.properties) dedicated section.


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
