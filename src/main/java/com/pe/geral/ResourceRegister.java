package com.pe.geral;

import org.glassfish.jersey.server.ResourceConfig;

import com.pe.parameters.LocalDateConverterProvider;
import com.pe.parameters.LocalTimeConverterProvider;

public class ResourceRegister extends ResourceConfig{

	public ResourceRegister() {
		register(new DAOManagerFactory.Binder());
		packages(true, "com.pe.geral");
		
		//Registra a conversão de tipo personalizado.
		register(LocalDateConverterProvider.class);
		register(LocalTimeConverterProvider.class);
		packages(true, "com.pe.parameters");
	}
	
}
