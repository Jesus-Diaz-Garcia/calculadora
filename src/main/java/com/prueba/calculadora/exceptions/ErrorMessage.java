package com.prueba.calculadora.exceptions;

/**
 *
 */
public class ErrorMessage {
  String errorCause;

  public ErrorMessage(String errorCause) {
    this.errorCause = errorCause;
  }

  public String getErrorCause() {
    return errorCause;
  }

  public void setErrorCause(String errorCause) {
    this.errorCause = errorCause;
  }
}
