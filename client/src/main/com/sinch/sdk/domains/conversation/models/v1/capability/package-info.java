/**
 * Conversation models for <code>Capability</code>
 *
 * <p>A capability query checks the options available for reaching the contact on the channels on
 * which it has a channel identity.
 *
 * <p>Capability queries can only be executed for contacts that already exist in a project and app.
 * For executing the request, either the contact ID or the channel recipient identities of the
 * contact are required.
 *
 * <p>The request is executed asynchronously, therefore the service responds immediately. The result
 * of the capability query is sent to the registered webhook for the <b>CAPABILITY</b> trigger.
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/conversation/api-reference/conversation/tag/Capability">Capability</a>
 * @since 1.3
 */
package com.sinch.sdk.domains.conversation.models.v1.capability;
