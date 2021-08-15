package com.logistica.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.logistica.model.Cliente;

@RestController
public class ClienteController {
	
	@GetMapping("/clientes")
	public List<Cliente> listar() {
		var cliente1 = new Cliente(1L, "Jose", "jose@gmail", "2213242341234");
		var cliente2 = new Cliente(2L, "Jose", "jose@gmail", "2213242341234");
		
		return Arrays.asList(cliente1, cliente2);
	}
}
