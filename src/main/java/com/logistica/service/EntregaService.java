package com.logistica.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logistica.model.Entrega;
import com.logistica.model.StatusEntrega;
import com.logistica.repository.EntregaRepository;

@Service
public class EntregaService {
	
	@Autowired
	EntregaRepository repository;
	
	@Transactional
	public Entrega solicitar(Entrega entrega) {
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(LocalDateTime.now());
		return repository.save(entrega);
	}
}
