package com.pe.database;

import org.json.JSONObject;

import com.pe.beans.InformacoesEstagio;

import br.com.starmetal.database.postgresql.InsertMaker;
import br.com.starmetal.database.postgresql.QueryMaker;
import br.com.starmetal.results.ResultType;

public class DAOInformacoesEstagio {
	private Executor executar;

	public DAOInformacoesEstagio(DAOManager manager) {
		this.executar = manager.getExecutor();
	}

	public JSONObject consultarInformacoesEstagio(Integer idAluno) {
		QueryMaker query = new QueryMaker();
		query.select("*").from("informacoes_estagio").where("id_aluno", idAluno);

		return executar.runAndReturnAsJSON(query);
	}

	public ResultType cadastrarInformacoesEstagio(InformacoesEstagio info) {
		if (!InformacoesEstagio.isValid(info)) return ResultType.ERROR; 
		
		InsertMaker insert = new InsertMaker();
		insert.insertInto("informacoes_estagio")
			  .value("status", info.getStatus())
			  .value("nome_empresa", info.getNomeEmpresa())
			  .value("codigo_disciplina", info.getCodigoDisciplina())
			  .value("data_inicio", info.getDataInicio())
			  .value("data_fim", info.getDataFim())
			  .value("atividades_estagio", info.getAtividadesEstagio())
			  .value("ativo", info.isAtivo().toString())
			  .value("endereco_empresa", info.getEnderecoEmpresa())
			  .value("path_pdf_termo", info.getPathPDFTermo())
			  .value("nome_supervisor", info.getNomeSupervisor())
			  .value("cargo_supervisor", info.getCargoSupervisor())
			  .value("email_supervisor", info.getEmailSupervisor())
			  .value("telefone_supervisor", info.getTelefoneSupervisor())
			  .value("carga_horaria_semanal", info.getCargaHorariaSemanal())
			  .value("entrada_segunda", info.getEntradaSegunda())
			  .value("saida_segunda", info.getSaidaSegunda())
			  .value("entrada_terca", info.getEntradaTerca())
			  .value("saida_terca", info.getSaidaTerca())
			  .value("entrada_quarta", info.getEntradaQuarta())
			  .value("saida_quarta", info.getSaidaQuarta())
			  .value("entrada_quinta", info.getEntradaQuinta())
			  .value("saida_quinta", info.getSaidaQuinta())
			  .value("entrada_sexta", info.getEntradaSexta())
			  .value("saida_sexta", info.getSaidaSexta())
			  .value("entrada_sabado", info.getEntradaSabado())
			  .value("saida_sabado", info.getSaidaSabado());
		
		return executar.insertExecutor(insert);
	}
}
