/**
 * Helpers to build Voice V2 payloads
 *
 * <ul>
 *   <li>Call destinations and origins: {@link Destination}
 *   <li>SVAML commands: {@link Calls}, {@link Amd}, {@link Messages}, {@link Recording}
 *   <li>Custom events and menus: {@link CustomEvents} and {@link Menu}
 *   <li>Command sequences: {@link CommandsSequenceCreator}
 *   <li>Service call behaviors: {@link CallBehaviorHelper}
 *   <li>Sinch Event responses: {@link SinchEventResponses}
 * </ul>
 *
 * <p>The limits of the API (lengths, ranges, number of items) are documented on the methods but not
 * checked by the helpers: the API checks them.
 *
 * @since 2.4
 */
package com.sinch.sdk.domains.voice.models.v2.helpers;
