
package com.example.demo.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.model.ErrorResponse;


@RestControllerAdvice
public class GlobalExceptionHandler {


	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorResponse> handle(ConstraintViolationException constraintViolationException) {
		Set<ConstraintViolation<?>> violations = constraintViolationException.getConstraintViolations();
		Map<String, String> details = new HashMap<>();

		if (!violations.isEmpty()) {
			violations
					.forEach(violation -> details.put(violation.getPropertyPath().toString(), violation.getMessage()));
		}

		ErrorResponse errorResponse = new ErrorResponse("Validation failed", details);
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

}
