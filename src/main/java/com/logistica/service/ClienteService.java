package com.logistica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logistica.exception.NegocioException;
import com.logistica.model.Cliente;
import com.logistica.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository repository;
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		boolean emailExistente = repository.findByEmail(cliente.getEmail())
				.stream()
				.anyMatch(x -> !x.equals(cliente));
		
		if(emailExistente) {
			throw new NegocioException("já existe um cliente com este email");
		}
		
		return repository.save(cliente);
	}
	@Transactional
	public void excluir(Long id) {
		repository.deleteById(id);
	}
}