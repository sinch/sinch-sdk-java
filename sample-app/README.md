# Sample application based onto Sinch Java SDK

This directory contains samples related to supported services/endpoint for Sinch Java SDK.

It is not a submodule to mimic a real application to be built from a deployed SDK; this mean the SDK jar must be "installed" locally to be resolved as application dependency. 

# Prerequisites

- JDK 21 or later (Sinch SDK Java is requiring java 8 only but samples are requiring Java 21 JVM)
- [Maven](https://maven.apache.org/)
- [Maven Repository for this SDK](https://central.sonatype.com/artifact/com.sinch.sdk/sinch-sdk-java)
- [Sinch account](https://dashboard.sinch.com)

## Usage

1. Generate and install locally the Sinch SDK java

    From parent directory of this application (repository root directory):
    ```
    mvn install 
    ```
   Then generated SDK will be available for sample application generation.
2. Application generation

   Application generation command:
   ```
   mvn package
   ```
3. Execute a sample
    ```
    java -cp target/sinch-sdk-java-sample-app-1.0.0-SNAPSHOT-jar-with-dependencies.jar  <sample class to be executed>
    ```

## Samples execution required parameters
### Common parameters
Set your credentials used by sample app:
```
export SINCH_KEY_ID=<key id value>
export SINCH_KEY_SECRET=<key secret value>
export SINCH_PROJECT_ID=<project id value>
```

### Test dependant parameters

Like for credentials, use the following command to define a parameter required by test execution:

   ```
   export <parameter name>=<parameter value>
   ```

Variable to be used:
- `PHONE_NUMBER`: Some test are requiring a phone number parameter.
- `BATCH_ID`: Some test are requiring a phone number parameter.

See https://developers.sinch.com for details about these parameters

## Available samples classes

### Full workflow
A full application chaining calls to Numbers service to onboard onto Java SDK and Numbers: [NumbersSampleFlow](src/main/java/com/sinch/sample/numbers/NumbersSampleFlow.java)

### Dedicated service feature samples

#### Numbers

| Service   | Sample              | Class                                                                                                                           |
|-----------|---------------------|---------------------------------------------------------------------------------------------------------------------------------|
| Available | - CheckAvailability | [com.sinch.sample.numbers.available.CheckAvailability](src/main/java/com/sinch/sample/numbers/available/CheckAvailability.java) | Require `PHONE_NUMBER` parameter                  |
|           | - List              | [com.sinch.sample.numbers.available.List](src/main/java/com/sinch/sample/numbers/available/List.java)                           |                                                   |
|           | - Rent              | [com.sinch.sample.numbers.available.Rent](src/main/java/com/sinch/sample/numbers/available/Rent.java)                           | Require `PHONE_NUMBER` parameter                  |
|           | - RentAny           | [com.sinch.sample.numbers.available.RentAny](src/main/java/com/sinch/sample/numbers/available/RentAny.java)                     |                                                   |
| Active    | - Get               | [com.sinch.sample.numbers.active.Get](src/main/java/com/sinch/sample/numbers/active/Get.java)                                   | Require `PHONE_NUMBER` parameter                  |
|           | - List              | [com.sinch.sample.numbers.active.List](src/main/java/com/sinch/sample/numbers/active/List.java)                                 |                                                   |
|           | - Release           | [com.sinch.sample.numbers.active.Release](src/main/java/com/sinch/sample/numbers/active/Release.java)                           | Require `PHONE_NUMBER` parameter                  |
|           | - Update            | [com.sinch.sample.numbers.active.Update](src/main/java/com/sinch/sample/numbers/active/Update.java)                             | Require `PHONE_NUMBER` parameter                  |
| Callback  | - Get               | [com.sinch.sample.numbers.callback.Get](src/main/java/com/sinch/sample/numbers/callback/Get.java)                               |                                                   |
|           | - Update            | [com.sinch.sample.numbers.callback.Update](src/main/java/com/sinch/sample/numbers/callback/Get.java)                            |                                                   |
| Regions   | - ListAll           | [com.sinch.sample.numbers.regions.List](src/main/java/com/sinch/sample/numbers/regions/List.java)                               |                                                   |

#### SMS

| Service        | Sample                 | Class                                                                                                                                                 |
|----------------|------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------|
| Batches        | - Get                  | [com.sinch.sample.sms.batches.Get](src/main/java/com/sinch/sample/sms/batches/Get.java)                                                               | Require `BATCH_ID` parameter                      |
|                | - List                 | [com.sinch.sample.sms.batches.List](src/main/java/com/sinch/sample/sms/batches/List.java)                                                             |                                                   |
|                | - Send                 | [com.sinch.sample.sms.batches.Send](src/main/java/com/sinch/sample/sms/batches/Send.java)                                                             |                                                   |
|                | - Replace              | [com.sinch.sample.sms.batches.Replace](src/main/java/com/sinch/sample/sms/batches/Replace.java)                                                       | Require `BATCH_ID` parameter                      |
|                | - Update               | [com.sinch.sample.sms.batches.Update](src/main/java/com/sinch/sample/sms/batches/Update.java)                                                         | Require `BATCH_ID` parameter                      |
|                | - DryRun               | [com.sinch.sample.sms.batches.DryRun](src/main/java/com/sinch/sample/sms/batches/dryRun.java)                                                         |                                                   |
|                | - Cancel               | [com.sinch.sample.sms.batches.Cancel](src/main/java/com/sinch/sample/sms/batches/Cancel.java)                                                         | Require `BATCH_ID` parameter                      |
|                | - SendDeliveryFeedback | [com.sinch.sample.sms.batches.SendDeliveryFeedback](src/main/java/com/sinch/sample/sms/batches/SendDeliveryFeedback.java)                             | Require `BATCH_ID` parameter                      |
| DeliveryReport | - Get                  | [com.sinch.sample.sms.deliveryReports.Get](src/main/java/com/sinch/sample/sms/deliveryReports/Get.java)                                               | Require `BATCH_ID` parameter                      |
|                | - GetForNumber         | [com.sinch.sample.sms.deliveryReports.GetForNumber](src/main/java/com/sinch/sample/sms/deliveryReports/GetForNumber.java)                             | Require `BATCH_ID` and  `PHONE_NUMBER` parameters |
|                | - List                 | [com.sinch.sample.sms.deliveryReports.List](src/main/java/com/sinch/sample/sms/deliveryReports/List.java)                                             |                                                   |
| Groups         | - Create               | [com.sinch.sample.sms.groups.Create](src/main/java/com/sinch/sample/sms/groups/Create.java)                                                           |                                                   |
|                | - Get                  | [com.sinch.sample.sms.groups.Get](src/main/java/com/sinch/sample/sms/groups/Get.java)                                                                 |                                                   |
|                | - Delete               | [com.sinch.sample.sms.groups.Delete](src/main/java/com/sinch/sample/sms/groups/Delete.java)                                                           |                                                   |
|                | - List                 | [com.sinch.sample.sms.groups.List](src/main/java/com/sinch/sample/sms/groups/List.java)                                                               |                                                   |
|                | - ListMembers          | [com.sinch.sample.sms.groups.ListMembers](src/main/java/com/sinch/sample/sms/groups/ListMembers.java)                                                 |                                                   |
|                | - Replace              | [com.sinch.sample.sms.groups.Replace](src/main/java/com/sinch/sample/sms/groups/Replace.java)                                                         |                                                   |
|                | - Update               | [com.sinch.sample.sms.groups.Update](src/main/java/com/sinch/sample/sms/groups/Update.java)                                                           |                                                   |
| Inbounds       | - Get                  | [com.sinch.sample.sms.inbounds.Get](src/main/java/com/sinch/sample/sms/inbounds/Get.java)                                                             |                                                   |
|                | - List                 | [com.sinch.sample.sms.inbounds.List](src/main/java/com/sinch/sample/sms/inbounds/List.java)                                                           |                                                   |
| WebHooks       | - DeliveryReport       | [com.sinch.sample.sms.webhooks.DeliveryReport](src/main/java/com/sinch/sample/sms/webhooks/DeliveryReport.java)                                       |                                                   |
|                | - IncomingSMSReport    | [com.sinch.sample.sms.webhooks.IncomingSMS](src/main/java/com/sinch/sample/sms/webhooks/IncomingSMS.java)                                             |                                                   |

#### Verification

| Service | Sample             | Class                                                                                                                                           |
|---------|--------------------|-------------------------------------------------------------------------------------------------------------------------------------------------|
| Report  | - Start            | [com.sinch.sample.verification.verifications.Start](src/main/java/com/sinch/sample/verification/verifications/Start.java)                       |                     |
|         | - ReportById       | [com.sinch.sample.verification.verifications.ReportById](src/main/java/com/sinch/sample/verification/verifications/ReportById.java)             |                     |
|         | - ReportByIdentity | [com.sinch.sample.verification.verifications.ReportByIdentity](src/main/java/com/sinch/sample/verification/verifications/ReportByIdentity.java) |                     |
| Status  | - GetById          | [com.sinch.sample.verification.status.GetById](src/main/java/com/sinch/sample/verification/status/GetById.java)                                 |                     |
|         | - GetByIdentity    | [com.sinch.sample.verification.status.GetByIdentity](src/main/java/com/sinch/sample/verification/status/GetByIdentity.java)                     |                     |
|         | - GetByReference   | [com.sinch.sample.verification.status.GetByReference](src/main/java/com/sinch/sample/verification/status/GetByReference.java)                   |                     |

#### Voice

| Service  | Sample | Class                                                                                           |
|----------|--------|-------------------------------------------------------------------------------------------------|
| Callouts | Call   | [com.sinch.sample.voice.callouts.Call](src/main/java/com/sinch/sample/voice/callouts/Call.java) |                     |

### Dedicated webhooks feature samples
#### How to run webhooks sample application
Webhooks samples are based onto a dedicated SpringBoot applications.
By using service like `ngrok` and running locally the SpringBoot application you'll be able to use the local springboot application to response to callbacks defined within your dashboard
1. Install `ngrok` and launch it (see [ngrok site](https://ngrok.com/docs))
2. Run the application: `mvn -f pom-webhooks.xml clean package spring-boot:run`   
3. Configure your `dashboard` & `application settings` to define callback according to ngrok running `bridge`
   - ngrok output put like `Forwarding https://35d0-78-117-86-140.ngrok.io -> http://localhost:8080`
   - Verification webhooks application is having a controller responding to `/VerificationEvent` path
   - Define dashboard callback value to `https://35d0-78-117-86-140.ngrok.io/VerificationEvent`
4. Execute a Verification action and check the webhook calls

#### Verification WebHooks
Require to set following parameters (by environment or config file):
- `APPLICATION_API_KEY`
- `APPLICATION_API_SECRET`

Check your dashboard to retrieve Application credentials values

| API          | Package                                                                                        | Notes |
|--------------|------------------------------------------------------------------------------------------------|-------|
| Numbers      | [com.sinch.sample.webhooks.numbers](src/main/java/com/sinch/sample/webhooks/numbers)           |       |
| Verification | [com.sinch.sample.webhooks.verification](src/main/java/com/sinch/sample/webhooks/verification) |       |

