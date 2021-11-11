package com.ms.email.services.email.data;

import java.time.LocalDateTime;

import com.ms.email.domain.email.EmailId;

public record EmailResponse (
  EmailId emailId,
  LocalDateTime sendDate,
  String ownerRef
) {}
