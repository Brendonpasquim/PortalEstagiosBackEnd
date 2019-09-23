package com.pe.database;

import org.json.JSONObject;

import com.pe.beans.Aluno;

import br.com.starmetal.database.postgresql.InsertMaker;
import br.com.starmetal.database.postgresql.QueryMaker;
import br.com.starmetal.results.ResultType;

public class DAOAlunos {
	private Executor executar;
	
	public DAOAlunos(DAOManager manager) {
		this.executar = manager.getExecutor();
	}
	
	public JSONObject consultarTodosAlunos() {
		QueryMaker query = new QueryMaker();
		query.select("ra, nome, periodo, telefone, ano, email, curso")
			 .from("aluno")
			 .orderBy("ra");
		
		return executar.runAndReturnAsJSON(query);
	}
	
	public ResultType cadastrarAluno(Aluno aluno) {
		if(!Aluno.isValid(aluno)) return ResultType.ERROR;
		
		InsertMaker insert = new InsertMaker();
		insert.insertInto("aluno")
			  .value("nome", aluno.getNome())
			  .value("periodo", aluno.getPeriodo())
			  .value("telefone", aluno.getTelefone())
			  .value("ano", aluno.getAno())
			  .value("email", aluno.getEmail())
			  .value("curso", aluno.getCurso());
		
		return executar.insertExecutor(insert);
	}
}
