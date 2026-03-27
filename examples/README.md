# Sinch Java SDK — Examples

This directory provides ready-to-run examples and templates to help you get started quickly with the [Sinch Java SDK](https://github.com/sinch/sinch-sdk-java).

## Overview

| Directory                              | Purpose                                                          | Java |
|----------------------------------------|------------------------------------------------------------------|------|
| [`getting-started/`](#getting-started) | Minimal one-feature examples, each paired with a Sinch tutorial  | 8+   |
| [`snippets/`](#snippets)               | Self-contained code snippets covering every API operation        | 8+   |
| [`client/`](#client)                   | SDK Client template application                                  | 8+   |
| [`sinch-events/`](#sinch-events)       | Spring Boot server template to process received Sinch Events     | 21+  |
| [`tutorials/`](#tutorials)             | Step-by-step tutorials combining multiple SDK features           | 21+  |

---

## Getting Started

> **Best entry point if you are new to the SDK.**

`getting-started/` contains small, focused examples — one per feature — each matching a tutorial on [developers.sinch.com](https://developers.sinch.com).

```
getting-started/
├── conversation/
│   ├── send-text-message/
│   └── respond-to-incoming-message/
├── numbers/
│   ├── search-available/
│   ├── rent-first-available-number/
│   └── rent-and-configure/
├── sms/
│   ├── send-sms-message/
│   └── respond-to-incoming-message/
├── verification/
│   └── user-verification-using-sms-pin/
└── voice/
    ├── make-a-call/
    └── respond-to-incoming-call/
```

Each subdirectory contains its own `README.md` with a link to the corresponding online tutorial and a pointer to the shared [client configuration](client/README.md).

---

## Snippets

`snippets/` contains individual, self-contained Java classes demonstrating a single API operation each. They are a useful reference when you need to know exactly how to call a specific endpoint.

**Covered services and operations:**

See dedicated [README](snippets/README.md) file

---

## Client

`client/` is a skeleton of application that lets you explore all SDK features through a menu-driven interface.

**Useful when** you want to experiment with several services without writing code.

See dedicated [README](client/README.md) file

---

## Sinch Events

`sinch-events/` is a Spring Boot server template for receiving and processing Sinch Events.

**Useful when** you need a starting point for a backend that reacts to inbound messages, delivery reports, call events, or verification results.

See dedicated [README](sinch-events/README.md) file

---

## Tutorials

`tutorials/` contains longer, scenario-based examples that combine multiple SDK features.

### Voice — Qualify Leads

[`tutorials/voice/capture-leads-app/`](tutorials/voice/capture-leads-app)

A Spring Boot application that initiates outbound calls from a CLI helper and processes the resulting call events on a local server. Accompanies the [Qualify Leads tutorial](https://developers.sinch.com/docs/voice/tutorials/qualify-leads/java) on the Sinch developer portal.

See the [tutorial README](tutorials/voice/capture-leads-app/README.md) for setup instructions.
