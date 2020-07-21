package com.test.billingservice.validation;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
@EqualsAndHashCode(doNotUseGetters = true)
public class ValidationErrorDetail {

  String fieldName;
  String errorMessage;
}
