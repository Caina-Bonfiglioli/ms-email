package com.ms.email.controllers;

import javax.validation.Valid;

import com.ms.email.services.email.EmailService;
import com.ms.email.services.email.data.EmailPayload;
import com.ms.email.services.email.data.EmailResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/email")
public class EmailController {
  
  private EmailService service;

  @PostMapping("/send")
  public ResponseEntity<EmailResponse> sendEmail(@RequestBody @Valid EmailPayload payload) {
    var response = service.sendEmail(payload);
    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }
}
