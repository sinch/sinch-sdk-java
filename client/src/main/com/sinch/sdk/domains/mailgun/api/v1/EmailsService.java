package com.sinch.sdk.domains.mailgun.api.v1;

import com.sinch.sdk.domains.mailgun.models.v1.emails.request.SendEmailRequest;
import com.sinch.sdk.domains.mailgun.models.v1.emails.request.SendMimeEmailRequest;
import com.sinch.sdk.domains.mailgun.models.v1.emails.response.GetStoredEmailResponse;
import com.sinch.sdk.domains.mailgun.models.v1.emails.response.SendEmailResponse;
import com.sinch.sdk.domains.mailgun.models.v1.emails.response.SendingQueuesStatusResponse;

/**
 * Mailgun Emails Service V1
 *
 * @see <a href="__TO_BE_DEFINED__">__TO_BE_DEFINED__</a>
 * @since __TO_BE_DEFINED__
 */
public interface EmailsService {

  SendEmailResponse sendEmail(String domain, SendEmailRequest request);

  SendEmailResponse sendMimeEmail(String domain, SendMimeEmailRequest request);

  GetStoredEmailResponse getStoredEmail(String domain, String storageKey);

  SendingQueuesStatusResponse getSendingQueuesStatus(String domain);

  void purgeDomainQueues(String domainName);
}
