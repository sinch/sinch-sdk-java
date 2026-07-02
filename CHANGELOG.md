# Changelog

All notable changes to the **Sinch Java SDK** are documented in this file.

> **Tag legend**
> - `[feature]` — new capability
> - `[fix]` — bug fix
> - `[deprecation notice]` — will be removed in a future release
> - `[dependency]` — third-party library update
> - `[doc]` — documentation only
> - `[test]` — test coverage
> - `[refactor]` — internal restructuring
> - `[releasing]` — release infrastructure
> - `[design]` — API design change
> - `[tech]` — technical improvement

---

## v2.1 – unreleased

### Numbers
- Extend `NumberSinchEvents` class.
  - **[fix]** `EventTypeEnum`: `DEPROVISIONING_TO_VOICE_PLATFORM` is deprecated and has to be replaced by `DEPROVISIONING_FROM_VOICE_PLATFORM`.
  - **[feature]** Support new `internalFailureCode` field.
  - **[feature]** Support new `StatusEnum` values: `IN_REVIEW`, `BLOCKED`, `COMPLETED`, `REJECTED`, `EXPIRED`.
  - **[feature]** Support new `EventTypeEnum` value: `NUMBER_ORDER_PROCESSING`.

### Conversation
- **[feature]** Support `Consents` API: `listIdentities` and `listAuditRecords` endpoints

### Number Lookup
- **[feature]** Support `Number Lookup` API V2

### SDK
- **[feature]** HTTP proxy support: configure an unauthenticated or authenticated (Basic) proxy via `HttpProxyConfiguration`
- **[feature]** `SinchClient` exposes a `close()` method to shut down the underlying HTTP connection pool and release all associated resources deterministically
- **[fix]** `HttpClientApache`: declare now `headersToBeAdded` as `volatile` to guarantee visibility across threads in concurrent usage
- **[fix]** `HttpClientApache`: wrap response-body `Scanner` in a try-with-resources block to prevent resource leaks; gracefully handle empty (`null`) response entities
- **[fix]** `SinchClient`: guard against a `NullPointerException` when `java.vendor` system property is absent while building the `User-Agent` auxiliary flag
- **[fix]** `Configuration`: correct copy-paste error in `toString()` and Javadoc — `conversationContext` label was incorrectly attributed to the Voice domain
- **[doc]** Improve README structure and content.


### Examples / Snippets
- **[doc]** Fix typos in `conversation/conversations/Create` and `voice/applications/GetEventDestinations` snippets

---

## v2.0 – 2026-03-31

### Major breaking changes with major release
- see [MIGRATION-GUIDE](MIGRATION-GUIDE.md#200)

### Chore
- **[dependency]** Updated `maven-model` dependency to `3.9.14` or more recent version to fix security vulnerabilities [#8](https://github.com/sinch/sinch-sdk-java/security/dependabot/8)

### Conversation
- **[feature]** Support `Project Settings` API
- **[feature]** Support `Contacts Identity Conflicts` API
- **[feature]** [Messages] Support new `direction` query parameter for `MessagesListQueryParameters`
- **[feature]** [Messages] Support `listLastMessagesByChannelIdentity` API
- **[feature]** [KakaoTalk] Support `COMMERCE` and `CAROUSEL_COMMERCE` channel specific message
- **[feature]** [LINE] Support `NOTIFICATION_MESSAGE_TEMPLATE` channel specific message
- **[deprecation notice]** [OrderDetailsSettings] [`PaymentSettings`](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/1.7.1/com/sinch/sdk/domains/conversation/models/v1/messages/types/channelspecific/whatsapp/payment/OrderDetailsPayment.html#getPaymentSettings()) deprecated in favor of [`PaymentButtons`](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/1.7.1/com/sinch/sdk/domains/conversation/models/v1/messages/types/channelspecific/whatsapp/payment/OrderDetailsPayment.html#getPaymentButtons())

### Verification
- **[feature]** Support `VerificationSmsDeliveredEvent` webhook events
- FlashCall
    - **[feature]** `VerificationStartRequestFlashCall` support `interceptionTimeout` and additionalProperties
    - **[feature]** `VerificationStartResponseFlashCall` support additionalProperties
    - **[feature]** `VerificationRequestEventResponseFlashCall` support `interceptionTimeout` and additionalProperties
- PhoneCall
    - **[feature]** `VerificationStartRequestPhoneCall` support additionalProperties
    - **[feature]** `VerificationRequestEventResponsePhoneCall` support additionalProperties
- SMS
    - **[feature]** `VerificationStartResponseSms` support `codeType` and additionalProperties
    - **[feature]** `VerificationRequestEventResponseSms` support `codeType`, `expiry` and additionalProperties
- WhatsApp
    - **[feature]** [BETA] Support `WhatsApp` verification method

### Voice
- **[feature]** Support new DICE reason values


---

## v1.7.1 – 2025-10-14
- **[fix]** Issue #273: Fix NPE when handling 401 response without a token expired header

---

## v1.7.0 – 2025-07-16
### SDK
- **[dependency]** Bump Jackson dependency to '2.19.0'
- **[dependency]** Bump generated sources based onto generator '7.13'
- **[dependency]** Bump maven-gpg-plugin used to sign released artifacts to '1.6'
- **[releasing]** Migration to replace deprecated OSSRH in favor of SonaType Central
- **[test]** Activate parallel mode for unit tests

### Conversation
- **[fix]** Specifications fixed:
  - `TemplateMessage.OmniTemplate` field is now requiring a `TemplateReference` with `version` field filled.
  - `TemplateMessage.ChannelTemplate` still use a `TemplateReference` with `version` field not required.
  To avoid breaking changes and namespace pollution, SDK is accepting a common `TemplateReference` instance and validation about the required `version` field won't be performed at client level by client, but will validate at backend level after having sent the request.
- **[feature]** `Reason.channel_code` field added (only for supported by WhatsApp)
- **[deprecation notice]** Emit a warning log onto using default region for Conversation (US). To avoid regulation issue, defaulting to US will no longer be supported in future version and defining the region will be required.
- **[test]** Clean Jackson cache during unit tests

### Mailgun
- **[feature]** `copyVersion` API based now return `version` field in place of deprecated `template` one
- **[doc]** Improve Javadoc rendering by separating summary and notes
- **[deprecation notice]** Emit a warning log onto using default region for Mailgun (US). To avoid regulation issue, defaulting to US will no longer be supported in future version and defining the region will be required.

### Numbers
- **[feature]** Support Emergency Address
- **[feature]** Add new API `rent(phoneNumber)` without configuration
- **[feature]** Switch from 'Basic' to 'OAuth' auth
- **[deprecation notice]**
  - [list(ActiveNumberListRequest)](https://www.javadoc.io/static/com.sinch.sdk/sinch-sdk-java/1.7.0/com/sinch/sdk/domains/numbers/api/v1/NumbersService.html#list(com.sinch.sdk.domains.numbers.models.v1.request.ActiveNumberListRequest)) replaced by [list(ActiveNumbersListQueryParameters)](https://www.javadoc.io/static/com.sinch.sdk/sinch-sdk-java/1.7.0/com/sinch/sdk/domains/numbers/api/v1/ActiveNumberService.html#list(com.sinch.sdk.domains.numbers.models.v1.request.ActiveNumbersListQueryParameters))
  - [searchForAvailableNumbers(AvailableNumberListRequest)](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/latest/com/sinch/sdk/domains/numbers/api/v1/NumbersService.html#searchForAvailableNumbers(com.sinch.sdk.domains.numbers.models.v1.request.AvailableNumberListRequest)) replaced by [searchForAvailableNumbers(AvailableNumbersListQueryParameters)](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/latest/com/sinch/sdk/domains/numbers/api/v1/AvailableNumberService.html#searchForAvailableNumbers(com.sinch.sdk.domains.numbers.models.v1.request.AvailableNumbersListQueryParameters))
  - [list(AvailableRegionListRequest)](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/latest/com/sinch/sdk/domains/numbers/api/v1/AvailableRegionService.html#list(com.sinch.sdk.domains.numbers.models.v1.regions.available.request.AvailableRegionListRequest)) replaced by [list(AvailableRegionsListQueryParameters)](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/latest/com/sinch/sdk/domains/numbers/api/v1/AvailableRegionsService.html#list(com.sinch.sdk.domains.numbers.models.v1.regions.request.AvailableRegionsListQueryParameters))
- **[refactor]** Voice configuration RTC is optional onto requests. No effect at SDK interface level
- **[refactor]** Move to facade pattern and consume APIs from generator

### SMS
- **[doc]** Improve Javadoc rendering by separating summary and notes
- **[deprecation notice]** Emit a warning log onto using default region for SMS (US). To avoid regulation issue, defaulting to US will no longer be supported in future version and defining the region will be required.

### Voice
- **[test]** Extend end-to-end tests against `notify`
- **[feature]** Support SVAML `connectStream` action
- **[feature]** Support `asynch` field for `amdRequest`
- **[feature]** Define two new values for `AnsweringMachineDetection.Reason` enum

---

## v1.6.0 – 2025-04-23

### SDK
- **[feature]** Lazy HTTP client initialization until really required

### Cross domains
- **[feature]** Relax domains init for Webhooks when credentials are not required
- **[feature]** Validation against missing required property at protocol level

### Conversation
- **[fix]** `CardMessage.media_message` is now of `MediaMessage` type
- **[feature]** New `ListMessage.media` field is supported
- **[feature]** New SG (Singapore) country defined for WhatsApp order payment details
- **[feature]** New `ConversationChannelCredentials.credential_ordinal_number` field is supported
- **[feature]** New `LineEnterpriseCredentials` is supported
- **[feature]** New `LineCredentialsField.isDefault` field is supported
- **[feature]** New `SendMessageRequest.message_content_type` is supported (enum of `MessageContentType`)
- **[feature]** New `ChannelSpecificMessage` classes for WhatsApp:
    - `OrderDetails`
    - `OrderStatus`
- **[deprecation notice]** `CardMessageMedia` class is deprecated in favor of shared `MediaMessage`

### Mailgun as PREVIEW features

- **[feature]** Support "Emails"
- **[feature]** Support "Templates"

### SMS

- **[fix]** `contentType` VS `content_type` JSON field name for `MediaMessageBodyDetails` at protocol level
- **[fix]** Body requests defined as required at protocol level
- **[fix]** `UpdateBinaryRequest.udh` field is required at protocol level
- **[feature]** `DryRunPerRecipientDetails.encodingEnum` defined as an enum
- **[feature]** List batches query parameters is accepting a list from values of code
- **[deprecation notice]** List batches query parameters accepting a single from value (replaced by function above)
- **[deprecation notice]** `DryRunPerRecipientDetails.encoding` is deprecated in favor of `DryRunPerRecipientDetails.encodingEnum`

### Voice

- **[feature]** Define `AnsweringMachineDetection` used by `AnsweredCallEvent` and `NotificationEvent`
- **[feature]** `conferenceId` field is supported by
    - `AnsweredCallEvent`
    - `DisconnectCallEvent`
    - `IncomingCallEvent`
    - `NotificationEvent`
    - `PromptInputEvent`
- **[feature]** `NotificationEvent` support `destination` and `amd` fields
- **[deprecation notice]** `AnsweredCallEventAnsweringMachineDetection` is replaced by `AnsweringMachineDetection`
- **[deprecation notice]** Following backend endpoint deprecation `applications.queryNumber` is deprecated

---

## v1.5.1 – 2025-03-04
### Conversation
- **[fix]** `CardMessage`
  - `CardMessage.media` field is of `MediaMessage` type (see Javadoc)
  - `CardMessageMedia` class is deprecated (see Javadoc)

---

## v1.5.0 – 2025-02-12

### Chore
- **[dependency]** Updated Jackson dependency to jackson-jakarta-rs-providers v2.18.2

### SMS
- **[feature]** Versioned access to SMS services
- **[deprecation notice]** Un-versioned access to SMS services (see SMS migration guide)

### Conversation
- **[fix]** Channel specific message (Messenger / FLOWS) fix for serialization/de-serialization
- **[fix]** List `ChoiceItem.media` field fix for serialization/de-serialization

### Numbers
- **[deprecation notice]** Un-versioned access to Numbers services (see Numbers migration guide)

### Verification
- **[deprecation notice]** Un-versioned access to Verification services (see Verification migration guide)

### Voice
- **[deprecation notice]** Un-versioned access to Voice services (see Voice migration guide)

---

## v1.4.0 – 2024-11-06

### Voice

- **[feature]** Support V1 design
- **[feature]** Follow specification update for SVAML `PlayFiles.locale`, field is no longer required
- **[fix]** Webhooks callbacks validation use case-insensitive headers (`validateAuthenticationHeader`)
- **[test]** Extend tests coverage (introduced end-to-end tests)
 
### Numbers
- **[feature]** Specification update for `VoiceConfiguration.scheduledProvisioning` defined as readOnly
- **[feature]** Specification update for `SmSConfiguration.scheduledProvisioning` defined as readOnly

---

## v1.3.1 – 2024-09-30
### SMS
- **[fix]** Enable list of parameters grouped by duplicated keys

---

## v1.3.0 – 2024-09-27
### Core

#### Generated sources
- **[fix]** Generated sources with OptionalValue getter: guard against uninitialized value
- **[feature]** Contains serializer/deserializer to be used for delegation pattern
- **[feature]** Enhanced javadoc content

#### Versioning
- **[feature]** Store SDK related information within sources

### Conversation
- **[feature]** Support Conversation API

### Numbers
- **[feature]** Helper function for webhook authentication header
- **[feature]** `readOnly` fields are no longer sent over network

### SMS
- **[feature]** Align with updated specs for DryRun

### Verification
- **[fix]** Enforce webhooks validation logic for empty or missing `authorization` header

---

## v1.2.4 – 2024-09-30
### SMS
- **[fix]** Enable list of parameters grouped by duplicated keys

---

## v1.2.3 – 2024-09-04
### Verification (SMS)
- **[feature]** Support additional properties onto Start verification by SMS

---

## v1.2.2 – 2024-08-19
- **[fix]** UTF-8 encoding for body payloads.

---

## v1.2.1 – 2024-07-24
### Numbers
- **[fix]** Add missing `WebHooksService.validateAuthenticationHeader` function for Numbers

---

## v1.2.0 – 2024-07-11

Starting with version `1.2`, `Numbers` domain now support versioned access by using the `v1()` API calls.
The existing non-versioned services will no longer be updated with new features/fields.

### Numbers
- **[design]** New versioned service simplified access to available or active: APIs are accessible directly under `v1()`
- **[feature]** FAX & EST number's configuration. The `VoiceConfiguration` and `ScheduledVoiceProvisioning` models have been updated to reflect the "Unified Numbers" API updates: they now hold values for Fax and Elastic SIP Trunking configuration (respectively with the properties `serviceId` and `trunkId`).

### Verification
- **[doc]** Error message related to invalid configuration (credentials) fixed

---

## v1.1.0 – 2024-06-28
With version `1.1` we are moving to support versioned domain access.

Starting with the `Verification` domain, you can access services by using the `v1()` API calls.
The existing non-versioned services will no longer be updated with new features/fields.

### Verification
- **[feature]** [Design] Non-versioned `Verification` domain is split into dedicated Start and Report new versioned services

- **[feature]** Synchronization with documentation terms
  - `Callout` related fields and APIs are now named Phone Call
  - `Seamless` related fields and APIs are now named Data
- **[feature]** Start Verification
  - `VerificationStartRequestSms`
    - Support `Accept-Language` option
    - Support `code type` option
    - Support `expiry` option
  - `VerificationStartRequestPhoneCall`
    - Support `speech` option
  - `VerificationStartResponseData`
    - **[fix]** `targetUri` field added
- **[feature]** Verification Report
    - **[fix]** `VerificationReportResponse`: Report service no longer returns a common status response shared with status service, but a dedicated verification report response.

- **[feature]** Webhooks
    - **[deprecation notice]** `VerificationRequestEvent.acceptLanguage` field is deprecated

- **[tech]** Logs
  - Reduce logging severity related to phone number not compliant with E164 format

---

## v1.0.0 – 2024-04-18
- **[feature]** Support Numbers API (SDK doc)
- **[feature]** Support SMS API (SDK doc). Support both unified credentials (projectId) and service planId
- **[feature]** Support Verification API (SDK doc)
- **[feature]** Support Voice API (REST API)
- **[doc]** Online javadoc
