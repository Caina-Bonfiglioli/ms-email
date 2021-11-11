package com.ms.email.services.email.data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class EmailPayload {

  @NotBlank(message = "ownerRef can not be blank")
  private String ownerRef;

  @NotBlank(message = "emailFrom can not be blank")
  @Email(message = "emailFrom is not valid")
  private String emailFrom;

  @NotBlank(message = "emailTo can not be blank")
  @Email(message = "emailTo is not a valid email")
  private String emailTo;

  @NotBlank(message = "subject can not be blank")
  private String subject;

  @NotBlank(message = "text can not be blank")
  private String text;
}
