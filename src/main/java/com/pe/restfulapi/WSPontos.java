package com.pe.restfulapi;

import static com.pe.restfulapi.Responses.getStatusGET;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;

import com.pe.database.DAOManager;

@Path("pontos")
public class WSPontos {
	
	@Context
	private DAOManager manager;
	
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it 222!";
    }

	@GET
	@Path("pontos_proximos_simplificado")
	@Produces(MediaType.APPLICATION_JSON)	
	public void consultarPontosProximosSimplificado(@NotNull @QueryParam("latitude") double latitude, 
													  @NotNull @QueryParam("longitude") double longitude) {
		
//        JSONArray pontosProximosSimplificados = manager.getDAOPontos().consultarPontosDeOnibusProximosSimplificado(latitude, longitude);
//		return getStatusGET(pontosProximosSimplificados);
	}	
}
