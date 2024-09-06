package br.com.rabbitmq.producer.configs;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.rabbitmq.producer.exceptions.UserFoundException;
import lib.exception.entity.ExceptionError;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UserFoundException.class)
	private ResponseEntity<ExceptionError> userExistsHandler(UserFoundException exception) {
		return ResponseEntity.status(HttpStatus.CONFLICT).body(new ExceptionError(false, HttpStatus.INTERNAL_SERVER_ERROR.value(), "Esse usuario ja esta cadastrado!!!"));
	}
}
