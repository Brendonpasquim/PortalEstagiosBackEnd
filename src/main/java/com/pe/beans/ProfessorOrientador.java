package com.pe.beans;

import org.json.JSONObject;

import br.com.starmetal.exceptions.BusinessException;
import br.com.starmetal.validacoes.Validacao;

public class ProfessorOrientador {
	private long id;
	private String nome;
	private String departamento;
	private String telefone;
	private String email;
	
	public ProfessorOrientador() {}
	
	public ProfessorOrientador(Long id, String nome, String departamento, String telefone, String email) {
		if(Validacao.saoParametrosInvalidos(nome, departamento, telefone, email)) {
			throw new BusinessException("Parâmetros inválidos");
		}
		
		this.id = id;
		this.nome = nome;
		this.departamento = departamento;
		this.telefone = telefone;
		this.email = email;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDepartamento() {
		return departamento;
	}
	
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public static ProfessorOrientador fromJson(JSONObject json) {
		if(Validacao.saoParametrosInvalidos(json)) {
			return null;
		}
		
		Long id = null;
		String nome = null;
		String departamento = null;
		String telefone = null;
		String email = null;
		
		if(json.has("nome")) nome = json.getString("nome");
		if(json.has("departamento")) departamento = json.getString("departamento"); 
		if(json.has("telefone")) telefone = json.getString("telefone");
		if(json.has("email")) email = json.getString("email");
		
		return new ProfessorOrientador(id, nome, departamento, telefone, email);
	}
	
	public static boolean isValid(ProfessorOrientador professor) {
		if( professor == null ) return false;
		
		String nome = professor.getNome();
		String departamento = professor.getDepartamento();
		String telefone = professor.getTelefone();
		String email = professor.getEmail();
		
		return Validacao.saoParametrosValidos(nome, departamento, telefone, email);
	}
}
