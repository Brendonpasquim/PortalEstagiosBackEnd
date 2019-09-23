package com.pe.geral;

import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.pe.database.ConnectionManager;

@WebListener
public class InicializarRecursosContexto implements ServletContextListener{
	
	private static final Logger LOG = Logger.getLogger(InicializarRecursosContexto.class.getName());
	private ConnectionManager manager;
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		LOG.info("Inicializando Connection Manager no contexto de aplicação.");
		manager = new ConnectionManager(true);

		LOG.info("Disponibilizando Connection Manager no contexto de aplicação.");
		ServletContext context = sce.getServletContext();
		context.setAttribute("manager", manager);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {}
	
}
