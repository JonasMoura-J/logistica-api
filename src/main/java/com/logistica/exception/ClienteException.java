package com.logistica.exception;

import java.time.LocalDate;
import java.util.List;

public class ClienteException {

	private Integer status;
	private LocalDate dataHora;
	private String titulo;
	private List<Campo> campos;

	public ClienteException() {
		
	}
	public ClienteException(Integer status, LocalDate dataHora, String titulo) {
		super();
		this.status = status;
		this.dataHora = dataHora;
		this.titulo = titulo;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public LocalDate getDataHora() {
		return dataHora;
	}
	public void setDataHora(LocalDate dataHora) {
		this.dataHora = dataHora;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public List<Campo> getCampos() {
		return campos;
	}
	public void setCampos(List<Campo> campos) {
		this.campos = campos;
	}
	
}
