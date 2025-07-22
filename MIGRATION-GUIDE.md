# Sinch Java SDK Migration Guide

## 2.0.0

This release removes legacy SDK support. 

This guide lists all removed classes and interfaces from V1 and how to migrate to their V2 equivalents.


### [`Numbers`](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/2.0.0/com/sinch/sdk/domains/numbers/package-summary.html)

#### Replacement models

##### Common models
| Old class                         | New class                                                                                                                                                                                                                              |
|-----------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------| 
| models.ActiveNumber               | [com.sinch.sdk.domains.numbers.models.v1.ActiveNumber](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/2.0.0/com/sinch/sdk/domains/numbers/models/v1/ActiveNumber.html)                                                     |
| models.AvailableNumber            | [com.sinch.sdk.domains.numbers.models.v1.response/AvailableNumber](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/2.0.0/com/sinch/sdk/domains/numbers/models/v1/response/AvailableNumber.html)                             |
| models.CallbackConfiguration      | [com.sinch.sdk.domains.numbers.models.v1.response/CallbackConfigurationResponse](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/2.0.0/com/sinch/sdk/domains/numbers/models/v1/response/CallbackConfigurationResponse.html) |
| models.Capability                 | [com.sinch.sdk.domains.numbers.models.v1.Capability](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/2.0.0/com/sinch/sdk/domains/numbers/models/v1/Capability.html)                                                         |
| models.Money                      | [com.sinch.sdk.domains.numbers.models.v1.Money](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/2.0.0/com/sinch/sdk/domains/numbers/models/v1/Money.html)                                                                   |
| models.NumberPattern              | [com.sinch.sdk.domains.numbers.models.v1.request.SearchPattern](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/2.0.0/com/sinch/sdk/domains/numbers/models/v1/request/SearchPattern.html)                                   |
| models.NumberType                 | [com.sinch.sdk.domains.numbers.models.v1.NumberType](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/2.0.0/com/sinch/sdk/domains/numbers/models/v1/NumberType.html)                                                         |
| models.OrderBy                    | [com.sinch.sdk.domains.numbers.models.v1.request.OrderBy](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/2.0.0/com/sinch/sdk/domains/numbers/models/v1/request/OrderBy.html)                                               |
| models.ProvisioningStatus         | [com.sinch.sdk.domains.numbers.models.v1.ProvisioningStatus](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/2.0.0/com/sinch/sdk/domains/numbers/models/v1/ProvisioningStatus.html)                                         |
| models.Region                     | Part of [com.sinch.sdk.domains.numbers.models.v1.regions.available.AvailableRegion](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/2.0.0/com/sinch/sdk/domains/numbers/models/v1/regions/available/AvailableRegion.html)   |
| models.SMSConfiguration           | [com.sinch.sdk.domains.numbers.models.v1.SmsConfiguration](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/2.0.0/com/sinch/sdk/domains/numbers/models/v1/SmsConfiguration.html)                                             |
| models.ScheduledSmsProvisioning   | [com.sinch.sdk.domains.numbers.models.v1.ScheduledSmsProvisioning](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/2.0.0/com/sinch/sdk/domains/numbers/models/v1/ScheduledSmsProvisioning.html)                             |
| models.ScheduledVoiceProvisioning | [com.sinch.sdk.domains.numbers.models.v1.request/ScheduledVoiceProvisioning](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/2.0.0/com/sinch/sdk/domains/numbers/models/v1/ScheduledVoiceProvisioning.html)                 |
| models.SearchPattern              | [com.sinch.sdk.domains.numbers.models.v1.request/SearchPosition](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/2.0.0/com/sinch/sdk/domains/numbers/models/v1/request/SearchPosition.html)                                 |
| models.SmsErrorCode               | [com.sinch.sdk.domains.numbers.models.v1.SmsErrorCode](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/2.0.0/com/sinch/sdk/domains/numbers/models/v1/SmsErrorCode.html)                                                     |
| models.VoiceConfiguration         | [com.sinch.sdk.domains.numbers.models.v1.VoiceConfiguration](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/2.0.0/com/sinch/sdk/domains/numbers/models/v1/VoiceConfiguration.html)                                         |

| Old enum                              | New enum                                                                                                                                                                                                                                                     |
|---------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------| 
| SmsErrorCode.EXCEEDED_10DLC_LIMIT     | [com.sinch.sdk.domains.numbers.models.v1.SmsErrorCode.EXCEEDED_10_DLC_LIMIT](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/2.0.0/com/sinch/sdk/domains/numbers/models/v1/SmsErrorCode.htmll#EXCEEDED_10_DLC_LIMIT)                                 |
| NumberEvent.EXCEEDED_10DLC_LIMIT      | [com.sinch.sdk.domains.numbers.models.v1.webhooks.NumbersEvent.EXCEEDED_10_DLC_LIMIT](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/2.0.0/com/sinch/sdk/domains/numbers/models/v1/webhooks/NumberEvent.FailureCodeEnum.html#EXCEEDED_10_DLC_LIMIT) |

##### Active Numbers
| Old class                                                             | New class                                                                                                                                                                                                                                  |
|-----------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------| 
| models.requests.ActiveNumberListRequestParameters                     | [com.sinch.sdk.domains.numbers.models.v1.request.ActiveNumbersListQueryParameters](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/2.0.0/com/sinch/sdk/domains/numbers/models/v1/request/ActiveNumbersListQueryParameters.html) |
| models.requests.ActiveNumberUpdateRequestParameters                   | [com.sinch.sdk.domains.numbers.models.v1.request.ActiveNumberUpdateRequest](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/2.0.0/com/sinch/sdk/domains/numbers/models/v1/request/ActiveNumberUpdateRequest.html)               |
| models.requests.ActiveNumberUpdateSMSConfigurationRequestParameters   | [com.sinch.sdk.domains.numbers.models.v1.SmsConfiguration](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/2.0.0/com/sinch/sdk/domains/numbers/models/v1/SmsConfiguration.html)                                                 |
| models.requests.ActiveNumberUpdateVoiceConfigurationRequestParameters | [com.sinch.sdk.domains.numbers.models.v1.VoiceConfiguration](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/2.0.0/com/sinch/sdk/domains/numbers/models/v1/request/VoiceConfiguration.html)                                     |
| models.responses.ActiveNumberListResponse.java                        | [com.sinch.sdk.domains.numbers.models.v1.response.ActiveNumberListResponse](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/2.0.0/com/sinch/sdk/domains/numbers/models/v1/response/ActiveNumberListResponse.html)               |

##### Available Numbers
| Old class                                               | New class                                                                                                                                                                                                                                        |
|---------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| models.requests.AvailableNumberListAllRequestParameters | [com.sinch.sdk.domains.numbers.models.v1.request.AvailableNumbersListQueryParameters](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/2.0.0/com/sinch/sdk/domains/numbers/models/v1/request/AvailableNumbersListQueryParameters.html) |
| models.requests.AvailableNumberRentAnyRequestParameters | [com.sinch.sdk.domains.numbers.models.v1.request.AvailableNumberRentAnyRequest](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/2.0.0/com/sinch/sdk/domains/numbers/models/v1/request/AvailableNumberRentAnyRequest.html)             |
| models.requests.AvailableNumberRentRequestParameters    | [com.sinch.sdk.domains.numbers.models.v1.request.AvailableNumberRentRequest](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/2.0.0/com/sinch/sdk/domains/numbers/models/v1/request/AvailableNumberRentRequest.html)                   |
| models.responses.AvailableNumberListResponse            | [com.sinch.sdk.domains.numbers.models.v1.response.AvailableNumberListResponse](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/2.0.0/com/sinch/sdk/domains/numbers/models/v1/response/AvailableNumberListResponse.html)               |
| models.requests.RentSMSConfigurationRequestParameters   | [com.sinch.sdk.domains.numbers.models.v1.SmsConfiguration](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/2.0.0/com/sinch/sdk/domains/numbers/models/v1/SmsConfiguration.html)                                                       |
| models.requests.RentVoiceConfigurationRequestParameters | [com.sinch.sdk.domains.numbers.models.v1.VoiceConfiguration](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/2.0.0/com/sinch/sdk/domains/numbers/models/v1/VoiceConfiguration.html)                                                   |

##### Regions
| Old class                                               | New class                                                                                                                                                                                                                                                              |
|---------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------| 
| models.requests.AvailableRegionListAllRequestParameters | [com.sinch.sdk.domains.numbers.models.v1.regions.request.AvailableRegionsListQueryParameters](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/2.0.0/com/sinch/sdk/domains/numbers/models/v1/regions/request/AvailableRegionsListQueryParameters.html)       |
| models.responses.AvailableRegionListResponse            | [com.sinch.sdk.domains.numbers.models.v1.regions.available.response.AvailableRegionListResponse](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/2.0.0/com/sinch/sdk/domains/numbers/models/v1/regions/available/response/AvailableRegionListResponse.html) |

##### Callbacks configuration
| Old class                                          | New class                                                                                                                                                                                                                                                          |
|----------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------| 
| models.requests.CallbackConfigurationUpdateRequest | [com.sinch.sdk.domains.numbers.models.v1.callbacks.request.CallbackConfigurationUpdateRequest](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/2.0.0/com/sinch/sdk/domains/numbers/models/v1/callbacks/request/CallbackConfigurationUpdateRequest.html) |

##### Webhooks
| Old class                              | New class                                                                                                                                                                                                                   |
|----------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------| 
| models.webhooks.EventNotification.java | [com.sinch.sdk.domains.numbers.models.v1.webhooks.NumberEvent](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/2.0.0/com/sinch/sdk/domains/numbers/models/v1/webhooks/NumberEvent.html)                             |
| models.webhooks.EventStatus.java       | [com.sinch.sdk.domains.numbers.models.v1.webhooks.NumberEvent.StatusEnum](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/2.0.0/com/sinch/sdk/domains/numbers/models/v1/webhooks/NumberEvent.StatusEnum.html)       |      
| models.webhooks.EventType.java         | [com.sinch.sdk.domains.numbers.models.v1.webhooks.NumberEvent.EventTypeEnum](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/2.0.0/com/sinch/sdk/domains/numbers/models/v1/webhooks/NumberEvent.EventTypeEnum.html) |
| models.webhooks.ResourceType.java      | [com.sinch.sdk.domains.numbers.models.v1.webhooks.ResourceType](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/2.0.0/com/sinch/sdk/domains/numbers/models/v1/webhooks/ResourceType.html)                           |

#### Replacement APIs

Use the new versioned API under v1().numbers() to get access to [NumbersService](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/2.0.0/com/sinch/sdk/domains/numbers/api/v1/NumbersService.html): [`sinchClient.numbers.v1()`](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/2.0.0./com/sinch/sdk/domains/numbers/NumbersService.html#v1())

| Old interface | New Equivalent in `numbers().v1()`                                                                                                                      |
|---------------|---------------------------------------------------------------------------------------------------------------------------------------------------------| 
| active()      | [Direct access from v1()](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/2.0.0/com/sinch/sdk/domains/numbers/api/v1/NumbersService.html)    |
| available()   | [Direct access from v1()](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/2.0.0/com/sinch/sdk/domains/numbers/api/v1/NumbersService.html)    |
| regions()     | [v1().regions()](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/2.0.0/com/sinch/sdk/domains/numbers/api/v1/AvailableRegionsService.html)    |
| callback()    | [v1().callback()](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/2.0.0/com/sinch/sdk/domains/numbers/api/v1/CallbackConfigurationService.html) |
| webhook()     | [v1().webhooks()](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/2.0.0/com/sinch/sdk/domains/numbers/api/v1/WebHooksService.html)              |

