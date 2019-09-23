package com.pe.restfulapi;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.pe.beans.Aluno;
import com.pe.database.DAOManager;

@Path("alunos")
public class WSAlunos {
	
	@Context
	private DAOManager manager;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt() {
		return "Endpoint is OK";
	}
	
	@GET
	@Path("consultar_todos")
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultarTodosAlunos() {
		return Responses.getStatusGET(manager.getDAOAlunos().consultarTodosAlunos());
	}
	
	@POST
	@Path("cadastrar")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrarAluno(Aluno aluno) {	
		return Responses.getStatusPOST(manager.getDAOAlunos().cadastrarAluno(aluno));
	}

}
