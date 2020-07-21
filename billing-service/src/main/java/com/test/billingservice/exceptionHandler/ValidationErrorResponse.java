package com.test.billingservice.exceptionHandler;

import lombok.Data;

import java.util.List;

@Data
public class ValidationErrorResponse {
  private final int statusCode;
  private final String cause;
  private final String message;
  private final List<FieldErrorResponse> errrors;
}
