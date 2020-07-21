package com.test.billingservice.exceptionHandler;

import lombok.Data;

@Data
public class FieldErrorResponse {

  private final String fieldName;
  private final String message;
}
