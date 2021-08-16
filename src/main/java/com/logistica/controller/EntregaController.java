package com.logistica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.logistica.model.Entrega;
import com.logistica.service.EntregaService;

@RestController
@RequestMapping("/entregas")
public class EntregaController {
	
	@Autowired
	EntregaService service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Entrega soliciar(@RequestBody Entrega entrega) {
		return service.solicitar(entrega);
	}
}
