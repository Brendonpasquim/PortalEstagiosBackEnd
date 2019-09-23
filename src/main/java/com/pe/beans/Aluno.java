package com.pe.beans;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import br.com.starmetal.exceptions.BusinessException;
import br.com.starmetal.validacoes.Validacao;

public class Aluno {
	private Long id;
	private String ra;       
	private String nome;     
	private String periodo;  
	private String telefone; 
	private String ano;
	private String email;    
	private String curso;   

	public Aluno() {}
	
	public Aluno(Long id, String ra, String nome, String periodo, String telefone, String ano, String email, String curso) {
		if(Validacao.saoParametrosInvalidos(nome, periodo, telefone, ano, email, curso)) {
			throw new BusinessException("Parâmetros inválidos");
		}
		
		this.id = id;
		this.ra = ra;
		this.nome = nome;
		this.periodo = periodo;
		this.telefone = telefone;
		this.ano = ano;
		this.email = email;
		this.curso = curso;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	public static Aluno fromJson(JSONObject json) {
		if(Validacao.saoParametrosInvalidos(json)) {
			return null;
		}
		
		Long id = null;
		String ra = null;
		String nome = null;
		String periodo = null;
		String telefone = null;
		String ano = null;
		String email = null;
		String curso = null;
		
		if(json.has("id")) 	 	 id = json.getLong("id");		
		if(json.has("ra")) 	 	 ra = json.getString("ra");
		if(json.has("nome")) 	 nome = json.getString("nome");
		if(json.has("periodo"))  periodo = json.getString("periodo"); 
		if(json.has("telefone")) telefone = json.getString("telefone");
		if(json.has("ano")) 	 ano = json.getString("ano");
		if(json.has("email")) 	 email = json.getString("email");
		if(json.has("curso")) 	 curso = json.getString("curso");
		
		return new Aluno(id, ra, nome, periodo, telefone, ano, email, curso);
	}
	
	public static List<Aluno> fromJsonArray(JSONArray rawArray) {
		if (rawArray == null) return null;
		
		List<Aluno> listaDeAlunos = new ArrayList<Aluno>();
		for(int indice = 0; indice < rawArray.length(); indice++) {
			Aluno aluno = Aluno.fromJson(rawArray.getJSONObject(indice));
			listaDeAlunos.add(aluno);
		}
		
		return listaDeAlunos;
	}
	
	public static boolean isValid(Aluno aluno) {
		if (aluno == null) return false; 
		
		String ra = aluno.getRa();
		String nome = aluno.getNome();
		String periodo = aluno.getPeriodo();  
		String telefone = aluno.getTelefone(); 
		String ano = aluno.getAno();
		String email = aluno.getEmail();    
		String curso = aluno.getCurso();
		
		return Validacao.saoParametrosValidos(ra, nome, periodo, telefone, ano, email, curso);
	}
	
}
