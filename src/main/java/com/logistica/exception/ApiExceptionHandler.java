package com.logistica.exception;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{
	
	@Autowired
	private MessageSource source;
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<Campo> campos = new ArrayList<>();
		for (ObjectError err : ex.getBindingResult().getAllErrors()) {
			String nome = ((FieldError) err).getField();
			String mensagem = source.getMessage(err, LocaleContextHolder.getLocale());
			campos.add(new Campo(nome, mensagem));
		}
		
		var excep = new ClienteException(status.value(), LocalDate.now(), "Um ou mais campos está incorretos. Faça o preenchimemnto e tente novamente.");
		excep.setCampos(campos);
		return handleExceptionInternal(ex, excep, headers, status, request);
	}
	
	@ExceptionHandler(NegocioException.class)
	public ResponseEntity<Object> handlenegocio(NegocioException ex, WebRequest request){
		var excep = new ClienteException(HttpStatus.BAD_REQUEST.value(), LocalDate.now(), ex.getMessage());
		return handleExceptionInternal(ex, excep, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
}
