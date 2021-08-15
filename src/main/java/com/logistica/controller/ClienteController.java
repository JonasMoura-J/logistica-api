package com.logistica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.logistica.model.Cliente;
import com.logistica.repository.ClienteRepository;

@RestController
public class ClienteController {

	@Autowired
	ClienteRepository repository;
	
	@GetMapping("/clientes")
	public List<Cliente> listar() {
		return repository.findAll();
	}
}
