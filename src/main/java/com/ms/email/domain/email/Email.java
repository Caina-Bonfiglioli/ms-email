package com.ms.email.domain.email;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "EMAIL")
public class Email {

  @EmbeddedId
  private EmailId emailId;

  @Column(name = "OWRER_REF")
  private String ownerRef;

  @Column(name = "EMAIL_FROM")
  private String emailFrom;

  @Column(name = "EMAIL_TO")
  private String emailTo;

  @Column(name = "SUBJECT") 
  private String subject;

  @Column(columnDefinition = "TEXT")
  private String text;

  @Column(name = "SEND_DATE")
  private LocalDateTime sendDate;

  @Column(name = "STATUS")
  @Enumerated(EnumType.STRING)
  private StatusEmail status;

  public Email(EmailId emailId, String ownerRef, String emailFrom, String emailTo, String subject, String text,
      LocalDateTime sendDate, StatusEmail status) {
    setEmailId(emailId);
    setOwnerRef(ownerRef);
    setEmailFrom(emailFrom);
    setEmailTo(emailTo);
    setSubject(subject);
    setText(text);
    setSendDate(sendDate);
    setStatus(status);
  }

  public EmailId emailId() {
    return this.emailId;
  }

  private void setEmailId(EmailId emailId) {
    this.emailId = emailId;
  }

  public String ownerRef() {
    return this.ownerRef;
  }

  private void setOwnerRef(String ownerRef) {
    this.ownerRef = ownerRef;
  }

  public String emailFrom() {
    return this.emailFrom;
  }

  private void setEmailFrom(String emailFrom) {
    this.emailFrom = emailFrom;
  }

  public String emailTo() {
    return this.emailTo;
  }

  private void setEmailTo(String emailTo) {
    this.emailTo = emailTo;
  }

  public String subject() {
    return this.subject;
  }

  private void setSubject(String subject) {
    this.subject = subject;
  }

  public String text() {
    return this.text;
  }

  private void setText(String text) {
    this.text = text;
  }

  public LocalDateTime sendDate() {
    return this.sendDate;
  }

  private void setSendDate(LocalDateTime sendDate) {
    this.sendDate = sendDate;
  }

  public StatusEmail status() {
    return this.status;
  }

  private void setStatus(StatusEmail status) {
    this.status = status;
  }

  public void updateStatus(StatusEmail status) {
    setStatus(status);
  }

}
