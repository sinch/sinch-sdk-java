# Changelog

All notable changes to the **Sinch Java SDK** are documented in this file.

> **Tag legend**
> - `[Feature]` — new capability
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

## v2.0 – Unreleased

### Major breaking changes with major release
- see [MIGRATION-GUIDE](MIGRATION-GUIDE.md#200)

### Conversation
- **[Feature]** Support `Project Settings` API
- **[Feature]** Support `Contacts Identity Conflicts` API
- **[Feature]** [Messages] Support new `direction` query parameter for `MessagesListQueryParameterslist`
- **[Feature]** [Messages] Support `listLastMessagesByChannelIdentity` API
- **[Feature]** [KakaoTalk] Support `COMMERCE` and `CAROUSEL_COMMERCE` channel specific message
- **[Feature]** [LINE] Support `NOTIFICATION_MESSAGE_TEMPLATE` channel specific message
- **[deprecation notice]** [OrderDetailsSettings] [`PaymentSettings`](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/1.7.1/com/sinch/sdk/domains/conversation/models/v1/messages/types/channelspecific/whatsapp/payment/OrderDetailsPayment.html#getPaymentSettings()) deprecated in favor of [`PaymentButtons`](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/1.7.1/com/sinch/sdk/domains/conversation/models/v1/messages/types/channelspecific/whatsapp/payment/OrderDetailsPayment.html#getPaymentButtons())

### Verification
- **[Feature]** Support `VerificationSmsDeliveredEvent` webhook events
- FlashCall
    - **[Feature]** `VerificationStartRequestFlashCall` support `interceptionTimeout` and additionalProperties
    - **[Feature]** `VerificationStartResponseFlashCall` support additionalProperties
    - **[Feature]** `VerificationRequestEventResponseFlashCall` support `interceptionTimeout` and additionalProperties
- PhoneCall
    - **[Feature]** `VerificationStartRequestPhoneCall` support additionalProperties
    - **[Feature]** `VerificationRequestEventResponsePhoneCall` support additionalProperties
- SMS
    - **[Feature]** `VerificationStartResponseSms` support `codeType` and additionalProperties
    - **[Feature]** `VerificationRequestEventResponseSms` support `codeType`, `expiry` and additionalProperties
- WhatsApp
    - **[Feature]** [BETA] Support `WhatsApp` verification method

### Voice
- **[Feature]** Support new DICE reason values


---

## v1.7.1 – 2025-10-14
- **[fix]** Issue #273: Fix NPE when handling 401 response without a token expired header

---

## v1.7.0 – 2025-07-16
### SDK
- **[dependency]** Bump Jackson dependency to '2.19.0'
- **[dependency]** Bump generated sources based onto generator '7.13'
- **[dependency]** Bump maven-gpg-plugin used to sign released artifacts to '1.6'
- **[releasing]** migration to replace deprecated OSSRH in favor of SonaType Central
- **[test]** Activate parallel mode for unit tests

### Conversation
- **[fix]** Specifications fixed:
  - `TemplateMessage.OmniTemplate` field is now requiring a `TemplateReference` with `version` field filled.
  - `TemplateMessage.ChannelTemplate` still use a `TemplateReference` with `version` field not required.
              To avoid breaking change and namespace pollution, SDK is accepting a common `TemplateReference` instance and validation about the required `version` field won't be performed at client level by client, but will validate at backend level after having sent the request.
- **[Feature]** `Reason.channel_code` field added (only for supported by WhatsApp)
- **[deprecation notice]** Emit a warning log onto using default region for Conversation (US). To avoid regulation issue, defaulting to US will no longer be supported in future version and defining the region will be required.
- **[test]** Clean Jackson cache during unit tests

### Mailgun
- **[Feature]** `copyVersion` API based now return `version` field in place of deprecated `template` one
- **[doc]** Improve Javadoc rendering by separating summary and notes
- **[deprecation notice]** Emit a warning log onto using default region for Mailgun (US). To avoid regulation issue, defaulting to US will no longer be supported in future version and defining the region will be required.

### Numbers
- **[Feature]** Support Emergency Address
- **[Feature]** Add new API `rent(phoneNumber)` without configuration
- **[Feature]** Switch from 'Basic' to 'OAuth' auth
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
- **[Feature]** Support SVAML `connectStream` action
- **[Feature]** Support `asynch` field for `amdRequest`
- **[Feature]** Define two new values for `AnsweringMachineDetection.Reason` enum

---

## v1.6.0 – 2025-04-23

### SDK
- **[Feature]** Lazy HTTP client initialization until really required

### Cross domains
- **[Feature]** Relax domains init for Webhooks when credentials are not required
- **[Feature]** Validation against missing required property at protocol level

### Conversation
- **[fix]** `CardMessage.media_message` is now of `MediaMessage` type
- **[Feature]** New `ListMessage.media` field is supported
- **[Feature]** New SG (Singapore) country defined for WhatsApp order payment details
- **[Feature]** New `ConversationChannelCredentials.credential_ordinal_number` field is supported
- **[Feature]** New `LineEnterpriseCredentials` is supported
- **[Feature]** New `LineCredentialsField.isDefault` field is supported
- **[Feature]** New `SendMessageRequest.message_content_type` is supported (enum of `MessageContentType`)
- **[Feature]** New `ChannelSpecificMessage` classes for WhatsApp:
    - `OrderDetails`
    - `OrderStatus`
- **[deprecation notice]** `CardMessageMedia` class is deprecated in favor of shared `MediaMessage`

### Mailgun as PREVIEW features

- **[Feature]** Support "Emails"
- **[Feature]** Support "Templates"

### SMS

- **[fix]** `contentType` VS `content_type` JSON field name for `MediaMessageBodyDetails` at protocol level
- **[fix]** body requests defined as required at protocol level
- **[fix]** `UpdateBinaryRequest.udh` field is required at protocol level
- **[Feature]** `DryRunPerRecipientDetails.encodingEnum` defined as an enum
- **[Feature]** List batches query parameters is accepting a list from values of code
- **[deprecation notice]** List batches query parameters accepting a single from value (replaced by function above)
- **[deprecation notice]** `DryRunPerRecipientDetails.encoding` is deprecated in favor of `DryRunPerRecipientDetails.encodingEnum`

### Voice

- **[Feature]** Define `AnsweringMachineDetection` used by `AnsweredCallEvent` and `NotificationEvent`
- **[Feature]** `conferenceId` field is supported by
    - `AnsweredCallEvent`
    - `DisconnectCallEvent`
    - `IncomingCallEvent`
    - `NotificationEvent`
    - `PromptInputEvent`
- **[Feature]** `NotificationEvent` support `destination` and `amd` fields
- **[deprecation notice]** `AnsweredCallEventAnsweringMachineDetection` is replaced by `AnsweringMachineDetection`
- **[deprecation notice]** Following backend endpoint deprecation `applications.queryNumber` is deprecated

---

## v1.5.1 – 2025-03-04
- **[fix]** conversation fix card message
  - `CardMessage.media` field is of `MediaMessage` type (see Javadoc)
  - `CardMessageMedia` class is deprecated (see Javadoc)

---

## v1.5.0 – 2025-02-12

### chore
- **[dependency]** Updated Jackson dependency to jackson-jakarta-rs-providers v2.18.2

### SMS
- **[Feature]** Versioned access to SMS services
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

- **[Feature]** support V1 design
- **[Feature]** Follow specification update for SVAML `PlayFiles.locale`, field is no longer required
- **[fix]** Webhooks callbacks validation use case-insensitive headers (`validateAuthenticationHeader`)
- **[test]** Extend tests coverage (introduced end-to-end tests)
 
### Numbers
- **[Feature]** Specification update for `VoiceConfiguration.scheduledProvisioning` defined as readOnly
- **[Feature]** Specification update for `SmSConfiguration.scheduledProvisioning` defined as readOnly

---

## v1.3.1 – 2024-09-30
### SMS
- **[fix]** Enable list of parameters grouped by duplicated keys

---

## v1.3.0 – 2024-09-27
### Core

#### Generated sources
- **[fix]** Generated sources with OptionalValue getter: guard against uninitialized value
- **[Feature]** contains serializer/deserializer to be used for delegation pattern
- **[Feature]** enhanced javadoc content

#### Versioning
- **[Feature]** Store SDK related information within sources

### Conversation
- **[Feature]** Support Conversation API

### Numbers
- **[Feature]** Helper function for webhook authentication header
- **[Feature]** readOnly fields are no longer sent over network

### SMS
- **[Feature]** Align with updated specs for DryRun

### Verification
- **[fix]** Enforce webhooks validation logic for empty or missing `authorization` header

---

## v1.2.4 – 2024-09-30
### SMS
- **[fix]** Enable list of parameters grouped by duplicated keys

---

## v1.2.3 – 2024-09-04
### Verification (SMS)
- **[Feature]** Support additional properties onto Start verification by SMS

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
- **[Feature]** FAX & EST number's configuration. The `VoiceConfiguration` and `ScheduledVoiceProvisioning` models have been updated to reflect the "Unified Numbers" API updates: they now hold values for Fax and Elastic SIP Trunking configuration (respectively with the properties `serviceId` and `trunkId`).

### Verification
- **[doc]** Error message related to invalid configuration (credentials) fixed

---

## v1.1.0 – 2024-06-28
With version `1.1` we are moving to support versioned domain access.

Starting with the `Verification` domain, you can access services by using the `v1()` API calls.
The existing non-versioned services will no longer be updated with new features/fields.

### Verification
- **[Feature]** [Design] Non-versioned `Verification` domain is split into dedicated Start and Report new versioned services

- **[Feature]** Synchronization with documentation terms
  - `Callout` related fields and APIs are now named Phone Call
  - `Seamless` related fields and APIs are now named Data
- **[Feature]** Start Verification
  - `VerificationStartRequestSms`
    - Support `Accept-Language` option
    - Support `code type` option
    - Support `expiry` option
  - `VerificationStartRequestPhoneCall`
    - Support `speech` option
  - `VerificationStartResponseData`
    - **[fix]** `targetUri` field added
- **[Feature]** Verification Report
    - **[fix]** `VerificationReportResponse`: Report service no longer returns a common status response shared with status service, but a dedicated verification report response.

- **[Feature]** Webhooks
    - **[deprecation notice]** `VerificationRequestEvent.acceptLanguage` field is deprecated

- **[tech]** Logs
  - Reduce logging severity related to phone number not compliant with E164 format

---

## v1.0.0 – 2024-04-18
- **[Feature]** Support Numbers API (SDK doc)
- **[Feature]** Support SMS API (SDK doc). Support both unified credentials (projectId) and service planId
- **[Feature]** Support Verification API (SDK doc)
- **[Feature]** Support Voice API (REST API)
- **[doc]** Online javadoc
