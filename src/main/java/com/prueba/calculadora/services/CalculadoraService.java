package com.prueba.calculadora.services;

import static org.springframework.http.HttpStatus.NOT_IMPLEMENTED;

import com.prueba.calculadora.exceptions.CalculadoraException;
import org.springframework.stereotype.Service;

/**
 * Servicio de cálculos aritméticos
 */
@Service
public class CalculadoraService {

  /**
   * Operación suma
   * @param operador1 operador 1
   * @param operador2 operador 2
   * @return resultado
   */
  public Double suma(Double operador1, Double operador2) {
    Double resultado = operador1 + operador2;
    return operador1 + operador2;
  }

  /**
   * Operación resta
   * @param operador1 operador 1
   * @param operador2 operador 2
   * @return resultado
   */
  public Double resta(Double operador1, Double operador2) {
    return operador1 - operador2;
  }

  /**
   * Operación multiplica
   * @param operador1 operador 1
   * @param operador2 operador 2
   * @return resultado
   */
  public Double multiplica(Double operador1, Double operador2) throws CalculadoraException {
    CalculadoraException calcExcep = new CalculadoraException("Esta operación no está soportada todavía");
    calcExcep.setHttpStatus(NOT_IMPLEMENTED);
    throw calcExcep;
  }

  /**
   * Operación divide
   * @param operador1 operador 1
   * @param operador2 operador 2
   * @return resultado
   */
  public Double divide(Double operador1, Double operador2) throws CalculadoraException {
    CalculadoraException calcExcep = new CalculadoraException("Esta operación no está soportada todavía");
    calcExcep.setHttpStatus(NOT_IMPLEMENTED);
    throw calcExcep;
  }
}
