package com.ms.email.common;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonValue;

public interface EntityIdentifier extends Serializable {
  @JsonValue
	public String getId();
}
