package com.ms.email.domain.email;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.ms.email.common.EntityIdentifier;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

@Embeddable
@Access(AccessType.FIELD)
@Value
@AllArgsConstructor
@NoArgsConstructor(force=true, access=AccessLevel.PRIVATE)
public class EmailId implements EntityIdentifier {
  @Column(name="ID")
	private String id;
	
	public String toString() { return getId(); }; 
	
	private static final long serialVersionUID = 1L;

}
