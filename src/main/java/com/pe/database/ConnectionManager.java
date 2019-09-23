package com.pe.database;

import java.util.Properties;
import java.util.logging.Logger;

import com.pe.geral.Deploy;

import br.com.starmetal.database.ConnectionFactory;
import br.com.starmetal.database.PooledConnectionFactory;
import br.com.starmetal.io.IOProperties;

public class ConnectionManager {
	
	private final ConnectionFactory factory;
	private static final Logger LOG = Logger.getLogger(ConnectionManager.class.getName());
	
	public ConnectionManager(final boolean PRODUCTION_MODE) {

		Properties dbPropertie;
				
		if(PRODUCTION_MODE) {
			LOG.info("Modo de Operação Atual: [PRODUCTION]");
			dbPropertie  = IOProperties.getProperties(System.getenv("HOME") + "/src/main/webapp/WEB-INF/properties/db.properties");
		} else {
			LOG.info("Modo de Operação Atual: [DEVELOPMENT]");
			dbPropertie  = IOProperties.getProperties(Deploy.WildFly.DB_CONFIG_FILE_PATH);
		}
		
		factory = new ConnectionFactory(new PooledConnectionFactory(dbPropertie), dbPropertie);
	}
	
	public ConnectionFactory getConnectionFactory() {
		return this.factory;
	}
}
