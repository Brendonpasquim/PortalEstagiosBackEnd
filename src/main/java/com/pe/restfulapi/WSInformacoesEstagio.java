package com.pe.restfulapi;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.pe.beans.InformacoesEstagio;
import com.pe.database.DAOManager;

@Path("informacoes_estagio")
public class WSInformacoesEstagio {

	@Context
	private DAOManager manager;

	@POST
	@Path("cadastrar")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getIt(InformacoesEstagio info) {
		info.setStatus("Pendente");
		return Responses.getStatusPOST(manager.getDAOInfoEstagio().cadastrarInformacoesEstagio(info));
	}

}
