package com.pe.database;

import org.json.JSONArray;

import br.com.starmetal.database.postgresql.QueryMaker;

public class DAOPontos {
    private Executor executar;

    public DAOPontos(DAOManager manager){
        this.executar = manager.getExecutor();
    }
    
    /**
     * 
     * @param latitude
     * @param longitude
     * @return
     */
    public JSONArray consultarPontosDeOnibusProximosSimplificado(double latitude, double longitude) {
    	QueryMaker query = new QueryMaker();
    	query.select("DISTINCT numero_ponto")
    		 .from("pontos_de_onibus")
    		 .where("ST_Within(geom, ST_buffer(ST_GeomFromText('POINT( :lon_origem :lat_origem)', 4326), 0.0025))")
    		 .setParameter("lon_origem", longitude)
    		 .setParameter("lat_origem", latitude);
    	
    	return executar.queryExecutor(query);
    }
}
