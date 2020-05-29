package com.prueba.calculadora.exceptions;

import org.springframework.http.HttpStatus;

public class CalculadoraException extends Exception {

  HttpStatus httpStatus;

  public CalculadoraException(String message, HttpStatus httpStatus) {
    super(message);
    this.httpStatus = httpStatus;
  }

  public CalculadoraException(String message) {
    super(message);
    this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
  }

  public HttpStatus getHttpStatus() {
    return httpStatus;
  }

  public void setHttpStatus(HttpStatus httpStatus) {
    this.httpStatus = httpStatus;
  }
}
