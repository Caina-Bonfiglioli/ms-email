package com.ms.email.domain.email;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailSpringData extends JpaRepository<Email, EmailId> {

}
