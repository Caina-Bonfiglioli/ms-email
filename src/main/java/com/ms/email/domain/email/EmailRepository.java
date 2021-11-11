package com.ms.email.domain.email;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class EmailRepository {
  
  private EmailSpringData springData;

  public EmailId nextId() {
    return new EmailId(UUID.randomUUID().toString());
  }

  public void save(Email email) {
    springData.save(email);
  }

  public void delete(Email email) {
    springData.delete(email);
  }

  public Optional<Email> findById(EmailId emailId) {
    return springData.findById(emailId);
  }
}
