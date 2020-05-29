package com.prueba.calculadora.controllers;

import static org.slf4j.LoggerFactory.getLogger;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.OK;

import com.prueba.calculadora.exceptions.CalculadoraException;
import com.prueba.calculadora.exceptions.ErrorMessage;
import com.prueba.calculadora.services.CalculadoraService;
import com.prueba.calculadora.services.TracerService;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controlador REST del servicio Calculadora
 */
@Controller
public class CalculadoraController {
  private static final Logger LOGGER = getLogger(CalculadoraController.class);

  @Autowired
  CalculadoraService calculadoraService;

  @Autowired
  TracerService tracerService;

  /**
   * Internal server error handler.
   *
   * @param e exception
   * @return ResponseEntity
   */
  @ExceptionHandler(Exception.class)
  static ResponseEntity<ErrorMessage> handleCalculadoraInternalException(Exception e) {
    LOGGER.error("Ha ocurrido un error interno inesperado" + " : " + e);
    return new ResponseEntity<>(
        new ErrorMessage("Ha ocurrido un error interno inesperado: " + e.getMessage()),
        INTERNAL_SERVER_ERROR);
  }

  /**
   * CalculadoraException server error handler.
   *
   * @param calexcep CalculadoraException
   * @return ResponseEntity
   */
  @ExceptionHandler(CalculadoraException.class)
  static ResponseEntity<ErrorMessage> handleCalculadoraException(CalculadoraException calexcep) {
    LOGGER.error(calexcep.getMessage());
    return new ResponseEntity<>(
        new ErrorMessage(calexcep.getMessage()), calexcep.getHttpStatus());
  }

  @GetMapping(value = "/suma")
  public ResponseEntity<Double> suma(
      @ApiParam(value = "Primer operador", required = true)
      @RequestParam
      @Validated Double operador1,
      @ApiParam(value = "Segundo operador", required = true)
      @RequestParam
      @Validated
      Double operador2) {
    Double resultado = calculadoraService.suma(operador1, operador2);
    tracerService.trace(resultado);
    return new ResponseEntity<>(resultado, OK);
  }

  @GetMapping(value = "/resta")
  public ResponseEntity<Double> resta(
      @ApiParam(value = "Primer operador", required = true)
      @RequestParam
      @Validated
      Double operador1,
      @ApiParam(value = "Segundo operador", required = true)
      @RequestParam
      @Validated
      Double operador2) {
    Double resultado = calculadoraService.resta(operador1, operador2);
    tracerService.trace(resultado);
    return new ResponseEntity<>(resultado, OK);
  }

  @GetMapping(value = "/multiplica")
  public ResponseEntity<Double> multiplica(
      @ApiParam(value = "Primer operador", required = true)
      @RequestParam
      @Validated
          Double operador1,
      @ApiParam(value = "Segundo operador", required = true)
      @RequestParam
      @Validated
       Double operador2) throws CalculadoraException{
      Double resultado = calculadoraService.multiplica(operador1, operador2);
      tracerService.trace(resultado);
      return new ResponseEntity<>(resultado, OK);
  }

  @GetMapping(value = "/divide")
  public ResponseEntity<Double> divide(
      @ApiParam(value = "Primer operador", required = true)
      @RequestParam
      @Validated
      Double operador1,
      @ApiParam(value = "Segundo operador", required = true)
      @RequestParam
      @Validated
      Double operador2) throws CalculadoraException{
      Double resultado = calculadoraService.divide(operador1, operador2);
      tracerService.trace(resultado);
      return new ResponseEntity<>(resultado, OK);
  }
}
