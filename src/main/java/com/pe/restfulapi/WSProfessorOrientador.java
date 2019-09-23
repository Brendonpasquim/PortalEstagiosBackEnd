package com.pe.restfulapi;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.pe.beans.ProfessorOrientador;
import com.pe.database.DAOManager;

@Path("professor_orientador")
public class WSProfessorOrientador {

	@Context
	DAOManager manager;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt() {
		return "Endpoint OK";
	}
	
	@GET
	@Path("consultar_todos")
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultarProfessores() {
		return Responses.getStatusGET(manager.getDAOProfessores().consultarProfessoresOrientadores());
	}
	
	@POST
	@Path("cadastrar")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrarProfessor(ProfessorOrientador professor) {
		return Responses.getStatusPOST(manager.getDAOProfessores().cadastrarProfessorOrientador(professor));
	}
	
}
