package com.pe.database;

import org.json.JSONObject;

import com.pe.beans.ProfessorOrientador;

import br.com.starmetal.database.postgresql.InsertMaker;
import br.com.starmetal.database.postgresql.QueryMaker;
import br.com.starmetal.results.ResultType;

public class DAOProfessorOrientador {
	private Executor executar;
	
	public DAOProfessorOrientador(DAOManager manager) {
		this.executar = manager.getExecutor();
	}
	
	public JSONObject consultarProfessoresOrientadores() {
		QueryMaker query = new QueryMaker();
		query.select("id, nome, departamento, telefone, email")
			 .from("professor_orientador")
			 .orderBy("nome");
		
		return executar.runAndReturnAsJSON(query);
	}
	
	public ResultType cadastrarProfessorOrientador(ProfessorOrientador professor) {
		if (!ProfessorOrientador.isValid(professor)) return ResultType.ERROR;
		
		InsertMaker insert = new InsertMaker();
		insert.insertInto("professor_orientador")
			  .value("nome", professor.getNome())
			  .value("departamento", professor.getDepartamento())
			  .value("telefone", professor.getTelefone())
			  .value("email", professor.getEmail());
		
		return executar.insertExecutor(insert);
	}
}
