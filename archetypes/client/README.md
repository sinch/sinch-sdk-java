# maven archetype for Client application

This directory contains a sources to create a [maven archetype](https://maven.apache.org/archetype) enabling Sinch Java SDK client application creation

# Prerequisites

- [Maven](https://maven.apache.org/)

## Template sources 

Sources related to archetype are located in [application-src](application-src) directory

Form the template directory you can compile and run application to ensure template sources execution.

See [sources README](application-src/README.md) for details

## Generate archetype from application sources

1. Generate files from sources
    ```sh
    (cd application-src ; mvn clean ; mvn -s ../settings.xml archetype:create-from-project)
    ```
2. Copy generated files
   ```sh
   rm -r archetype && mkdir archetype
   mv application-src/target/generated-sources/archetype/pom.xml archetype
   mv application-src/target/generated-sources/archetype/src archetype
   ```
   
## Install (locally)
Installing locally the archetype enable to test it before deploying "worldwide". 
   ```sh
   (cd archetype && mvn install)
   ```
Once installed, you create an application using `mvn archetype:generate` command (see dedicated paragraph below)

## Generate an application using archetype
Following command will create a `sinch-java-sdk-client-application` application using Sinch SDK Java to send an SMS

   ```sh
   
   cd /tmp
   mvn archetype:generate -DinteractiveMode=false \
     -DarchetypeGroupId=com.sinch.sdk.archetypes \
     -DarchetypeArtifactId=sinch-sdk-client-archetype \
     -DarchetypeVersion=1.0-SNAPSHOT \
     -DgroupId=my.company.com \
     -DartifactId=sinch-java-sdk-client-application \
     -Dversion=1.0-SNAPSHOT
   ```

## Use the generated application
Application is generated within `sinch-java-sdk-client-application` directory
See application [README.md](application-src/README.md) for details about using it.
