package com.test.billingservice.exceptionHandler;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.Collections;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class ValidationExceptionHandler {

  @ExceptionHandler(ConstraintViolationException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ValidationErrorResponse onValidationErrorResponse(ConstraintViolationException e) {

    List<FieldErrorResponse> fieldErrorResponses = Lists.newArrayList();

    e.getConstraintViolations()
        .forEach(
            (exception) -> {
              fieldErrorResponses.add(
                  new FieldErrorResponse(
                      exception.getPropertyPath().toString(), exception.getMessage()));
            });
    Collections.reverse(fieldErrorResponses);

    return new ValidationErrorResponse(
        HttpStatus.BAD_REQUEST.value(),
        HttpStatus.BAD_REQUEST.getReasonPhrase(),
        "Input Validation Error | Invalid Data",
        fieldErrorResponses);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ValidationErrorResponse onMethodValidationErrorResponse(
      MethodArgumentNotValidException e) {

    List<FieldErrorResponse> fieldErrorResponses = Lists.newArrayList();

    e.getBindingResult()
        .getAllErrors()
        .forEach(
            (exception) -> {
              fieldErrorResponses.add(
                  new FieldErrorResponse(
                      ((FieldError) exception).getField(), exception.getDefaultMessage()));
            });
    Collections.reverse(fieldErrorResponses);

    return new ValidationErrorResponse(
        HttpStatus.BAD_REQUEST.value(),
        HttpStatus.BAD_REQUEST.getReasonPhrase(),
        "Input Validation Error | Invalid Data",
        fieldErrorResponses);
  }
}
