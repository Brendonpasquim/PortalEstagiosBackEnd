package com.pe.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONObject;

import br.com.starmetal.database.postgresql.InsertMaker;
import br.com.starmetal.database.postgresql.QueryMaker;
import br.com.starmetal.exceptions.DatabaseException;
import br.com.starmetal.results.ResultType;

public class Executor {

	private static final Logger LOG = Logger.getLogger(Executor.class.getName());
	private final Connection connection;

	public Executor(Connection connection) {
		this.connection = connection;
	}

	/**
	 * Executa uma consulta na base de dados.
	 * 
	 * @param query
	 * @return
	 */
	public JSONArray queryExecutor(final QueryMaker query) {
		if (query == null) return new JSONArray();

		JSONArray jsonArray;
		String queryString = query.getQuery();
		try (PreparedStatement statement = connection.prepareStatement(queryString);
			 ResultSet result = statement.executeQuery()) {
			
			LOG.info("Status Query: [EXECUTANDO]");	LOG.info(queryString);
			jsonArray = Executor.Parser.toJSONArray(result);
			LOG.info("Status Query: [FINALIZADA]");
			
		} catch (SQLException sqle) {
			throw new DatabaseException("Falha ao executar consulta na Base de Dados.", sqle.getMessage());
		}

		return jsonArray;
	}
	
	public JSONObject runAndReturnAsJSON(final QueryMaker query) {
		if (query == null) return new JSONObject();
		
		return Parser.toJSON(this.queryExecutor(query));
	}
	
	/**
	 * Executa uma inserção na base de dados.
	 * 
	 * @param insert
	 * @return
	 */
	public ResultType insertExecutor(final InsertMaker insert) {
		if (insert == null) {
			return ResultType.ERROR;
		}

		String insertString = insert.getInsert();
		try (PreparedStatement statement = this.connection.prepareStatement(insertString)) {
			
			LOG.info("Status Insert: [EXECUTANDO]"); LOG.info(insertString);
			statement.executeUpdate();
			LOG.info("Status Query: [FINALIZADO]");
			
		} catch (SQLException sqle) {
			throw new DatabaseException("Falha ao executar inserção na Base de Dados.", sqle);
		}

		return ResultType.SUCESS;
	}

	public static class Parser {

		/**
		 * 
		 * @param result
		 * @return
		 * @throws SQLException
		 */
		public static JSONArray toJSONArray(ResultSet result) throws SQLException {
			if (result == null) {
				return null;
			}

			ResultSetMetaData metadados = result.getMetaData();
			int numeroDeColunas = metadados.getColumnCount();
			JSONArray jsonArray = new JSONArray();
			JSONObject json;

			while (result.next()) {

				json = new JSONObject();
				for (int indice = 1; indice <= numeroDeColunas; indice++) {
					String nomeColuna = metadados.getColumnName(indice);
					json.put(nomeColuna, result.getObject(nomeColuna));
				}

				jsonArray.put(json);
			}

			return jsonArray;
		}
		
		/**
		 * 
		 * @param array
		 * @return
		 */
		public static JSONObject toJSON(JSONArray array) {
			if (array == null) return null;
			
			return new JSONObject().put("results", array);
		}
	}
}
