package com.gbc8.task.controlador.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.gbc8.task.controlador.exception.NotFoundException;

@RestControllerAdvice
public class TarefaExceptionHandler {
	@ExceptionHandler(value = { MethodArgumentNotValidException.class })
	protected ResponseEntity<String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex){
		return ResponseEntity.badRequest().body(ex.getBindingResult().getFieldError().getDefaultMessage());
	}
	@ExceptionHandler(value = { NotFoundException.class })
	protected ResponseEntity<String> handleNotFoundException(NotFoundException ex){
		return ResponseEntity.badRequest().body(ex.getMessage());
	}
}