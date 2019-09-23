package com.pe.database;

import java.sql.Connection;

public class DAOManager {
	private DAOAlunos daoAlunos = null;
	private DAOProfessorOrientador daoProfessores = null;
	private DAOInformacoesEstagio daoInfoEstagio = null;
	private Executor executor;
	
	public DAOManager(Connection connection) {
		this.executor = new Executor(connection);
	}
	
	public DAOAlunos getDAOAlunos() {
		if(this.daoAlunos == null) {
			return this.daoAlunos = new DAOAlunos(this);
		}
		
		return this.daoAlunos;
	}
	
	public DAOProfessorOrientador getDAOProfessores() {
		if(this.daoProfessores == null) {
			return this.daoProfessores = new DAOProfessorOrientador(this);
		}
		
		return this.daoProfessores;
	}
	
	public DAOInformacoesEstagio getDAOInfoEstagio() {
		if(this.daoInfoEstagio == null) {
			return this.daoInfoEstagio = new DAOInformacoesEstagio(this);
		}
		
		return this.daoInfoEstagio;
	}
	
	public Executor getExecutor() {
		return executor;
	}
}
