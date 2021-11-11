package com.ms.email.services.email;

import java.time.LocalDateTime;

import com.ms.email.domain.email.Email;
import com.ms.email.domain.email.EmailRepository;
import com.ms.email.domain.email.StatusEmail;
import com.ms.email.services.email.data.EmailPayload;
import com.ms.email.services.email.data.EmailResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmailService {
  
  private EmailRepository repository;

  @Autowired
  private JavaMailSender mailSender;

  public EmailResponse sendEmail(EmailPayload payload) {
    var email = new Email(
      repository.nextId(), 
      payload.getOwnerRef(), 
      payload.getEmailFrom(), 
      payload.getEmailTo(), 
      payload.getSubject(), 
      payload.getText(), 
      LocalDateTime.now(), 
      StatusEmail.PENDING);

    try {
      var message = new SimpleMailMessage();
      message.setFrom(email.emailFrom());
      message.setTo(email.emailTo());
      message.setSubject(email.subject());
      message.setText(email.text());

      mailSender.send(message);

      email.updateStatus(StatusEmail.SENT);
    } catch (Exception e) {
      email.updateStatus(StatusEmail.ERROR);
    } finally {
      repository.save(email);
    }

    return buildResponse(email);
  }

  private EmailResponse buildResponse(Email email) {
    return new EmailResponse(email.emailId(), email.sendDate(), email.ownerRef());
  }
}
