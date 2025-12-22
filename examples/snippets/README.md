# sinch-sdk-java-snippets
Sinch Java SDK Code Snippets Repository 

This repository contains code snippets related to [Sinch JAVA SDK](https://github.com/sinch/sinch-sdk-java)

Snippets can be used as starting point to support Sinch products from your own application.

## Requirements
- JDK 8 or later
- [Sinch account](https://dashboard.sinch.com)

## Snippet execution
Launcher helpers are provided to execute snippets and minimize time to setup your first Java application based onto Sinch SDK

### Snippets execution settings
When executing a snippet you will need to provide certain information about your Sinch account (credentials, Sinch virtual phone number, ...)

This settings can be placed directly in the snippet source or you can choose to edit the [configuration file](./src/main/resources/config.properties), in which case the settings will be shared and used automatically by each snippet.

### Linux platform
Launch script is [here](./launcher)

Execution:
```shell
cd snippets
launcher <SNIPPET_SOURCE_PATH>
```
Where `SNIPPET_SOURCE_PATH` is path to snippet source (see [Available Snippets](#available-snippets) for available snippets)

e.g.: 
```shell
launcher numbers/SearchForAvailableNumbers
...
launcher regions/List

```

## Available Snippets

- Conversation: [README.md](src/main/java/conversation/README.md)
- Mailgun: [README.md](src/main/java/mailgun/README.md)
- Numbers: [README.md](src/main/java/numbers/README.md)
- SMS: [README.md](src/main/java/sms/README.md)
- Verification: [README.md](src/main/java/verification/README.md)
- Voice: [README.md](src/main/java/voice/README.md)

