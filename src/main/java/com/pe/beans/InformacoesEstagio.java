package com.pe.beans;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbProperty;

import br.com.starmetal.validacoes.Validacao;

public class InformacoesEstagio {
	private Integer id;
	private String status;

	@JsonbProperty("nome_empresa")
	private String nomeEmpresa;
	
	@JsonbProperty("codigo_disciplina")
	private String codigoDisciplina;
	
	@JsonbProperty("data_inicio") @JsonbDateFormat(value = "dd/MM/uuuu")
	private LocalDate dataInicio;
	
	@JsonbProperty("data_fim") @JsonbDateFormat(value = "dd/MM/uuuu")
	private LocalDate dataFim;
	
	@JsonbProperty("atividades_estagio")
	private String atividadesEstagio;
	
	private boolean ativo;
	
	@JsonbProperty("endereco_empresa")
	private String enderecoEmpresa;
	
	@JsonbProperty("path_pdf_termo")
	private String pathPDFTermo;
	
	//===================== SUPERVISOR DE ESTÁGIO =====================
	@JsonbProperty("nome_supervisor")
	private String nomeSupervisor;
	
	@JsonbProperty("cargo_supervisor")
	private String cargoSupervisor;
	
	@JsonbProperty("email_supervisor")
	private String emailSupervisor;
	
	@JsonbProperty("telefone_supervisor")
	private String telefoneSupervisor;
	//=================================================================
	
	//===================== HORÁRIO DE ESTÁGIO =====================
	@JsonbProperty("carga_horaria_semanal")
	private Integer cargaHorariaSemanal;
	
	@JsonbProperty("entrada_segunda")
	private LocalTime entradaSegunda;
	@JsonbProperty("saida_segunda")
	private LocalTime saidaSegunda;
	
	@JsonbProperty("entrada_terca")
	private LocalTime entradaTerca;
	@JsonbProperty("saida_terca")
	private LocalTime saidaTerca;
	
	@JsonbProperty("entrada_quarta")
	private LocalTime entradaQuarta;
	@JsonbProperty("saida_quarta")
	private LocalTime saidaQuarta;
	
	@JsonbProperty("entrada_quinta")
	private LocalTime entradaQuinta;
	@JsonbProperty("saida_quinta")
	private LocalTime saidaQuinta;
	
	@JsonbProperty("entrada_sexta")
	private LocalTime entradaSexta;
	@JsonbProperty("saida_sexta")
	private LocalTime saidaSexta;
	
	@JsonbProperty("entrada_sabado")
	private LocalTime entradaSabado;
	@JsonbProperty("saida_sabado")
	private LocalTime saidaSabado;
	//==============================================================
		
	public Integer getId() {return id;}
	public void setId(Integer id) {this.id = id;}
	
	public String getStatus() {return status;}
	public void setStatus(String status) {this.status = status;}

	public String getNomeEmpresa() {return nomeEmpresa;}
	public void setNomeEmpresa(String nomeEmpresa) {this.nomeEmpresa = nomeEmpresa;}

	public String getCodigoDisciplina() {return codigoDisciplina;}
	public void setCodigoDisciplina(String codigoDisciplina) {this.codigoDisciplina = codigoDisciplina;}

	public String getNomeSupervisor() {return nomeSupervisor;}
	public void setNomeSupervisor(String nomeSupervisor) {this.nomeSupervisor = nomeSupervisor;}

	public String getCargoSupervisor() {return cargoSupervisor;}
	public void setCargoSupervisor(String cargoSupervisor) {this.cargoSupervisor = cargoSupervisor;}

	public String getEmailSupervisor() {return emailSupervisor;}
	public void setEmailSupervisor(String emailSupervisor) {this.emailSupervisor = emailSupervisor;}

	public String getTelefoneSupervisor() {return telefoneSupervisor;}
	public void setTelefoneSupervisor(String telefoneSupervisor) {this.telefoneSupervisor = telefoneSupervisor;}

	public Integer getCargaHorariaSemanal() {return cargaHorariaSemanal;}
	public void setCargaHorariaSemanal(Integer carga_horaria_semanal) {this.cargaHorariaSemanal = carga_horaria_semanal;}

	public String getEnderecoEmpresa() {return enderecoEmpresa;}
	public void setEnderecoEmpresa(String enderecoEmpresa) {this.enderecoEmpresa = enderecoEmpresa;}

	public Boolean isAtivo() {return ativo;}
	public void setAtivo(boolean ativo) {this.ativo = ativo;}

	public String getPathPDFTermo() {return pathPDFTermo;}
	public void setPathPDFTermo(String pathPDFTermo) {this.pathPDFTermo = pathPDFTermo;}

	public LocalDate getDataInicio() {return dataInicio;}
	public void setDataInicio(LocalDate dataInicio) {this.dataInicio = dataInicio;}

	public LocalDate getDataFim() {return dataFim;}
	public void setDataFim(LocalDate dataFim) {this.dataFim = dataFim;}

	public String getAtividadesEstagio() {return atividadesEstagio;}
	public void setAtividadesEstagio(String atividadesEstagio) {this.atividadesEstagio = atividadesEstagio;}
	
	//SEGUNDA-FEIRA
	public LocalTime getEntradaSegunda() {return entradaSegunda;}
	public void setEntradaSegunda(LocalTime entradaSegunda) {this.entradaSegunda = entradaSegunda;}
	public LocalTime getSaidaSegunda() {return saidaSegunda;}
	public void setSaidaSegunda(LocalTime saidaSegunda) {this.saidaSegunda = saidaSegunda;}
	
	//TERÇA-FEIRA
	public LocalTime getEntradaTerca() {return entradaTerca;}
	public void setEntradaTerca(LocalTime entradaTerca) {this.entradaTerca = entradaTerca;}
	public LocalTime getSaidaTerca() {return saidaTerca;}
	public void setSaidaTerca(LocalTime saidaTerca) {this.saidaTerca = saidaTerca;}
	
	//QUARTA-FEIRA
	public LocalTime getEntradaQuarta() {return entradaQuarta;}
	public void setEntradaQuarta(LocalTime entradaQuarta) {this.entradaQuarta = entradaQuarta;}
	public LocalTime getSaidaQuarta() {return saidaQuarta;}
	public void setSaidaQuarta(LocalTime saidaQuarta) {this.saidaQuarta = saidaQuarta;}
	
	//QUINTA-FEIRA
	public LocalTime getEntradaQuinta() {return entradaQuinta;}
	public void setEntradaQuinta(LocalTime entradaQuinta) {this.entradaQuinta = entradaQuinta;}
	public LocalTime getSaidaQuinta() {return saidaQuinta;}
	public void setSaidaQuinta(LocalTime saidaQuinta) {this.saidaQuinta = saidaQuinta;}
	
	//SEXTA-FEIRA
	public LocalTime getEntradaSexta() {return entradaSexta;}
	public void setEntradaSexta(LocalTime entradaSexta) {this.entradaSexta = entradaSexta;}
	public LocalTime getSaidaSexta() {return saidaSexta;}
	public void setSaidaSexta(LocalTime saidaSexta) {this.saidaSexta = saidaSexta;}
	
	//SÁBADO
	public LocalTime getEntradaSabado() {return entradaSabado;}
	public void setEntradaSabado(LocalTime entradaSabado) {this.entradaSabado = entradaSabado;}
	public LocalTime getSaidaSabado() {return saidaSabado;}
	public void setSaidaSabado(LocalTime saidaSabado) {this.saidaSabado = saidaSabado;}
	
	public static boolean isValid(InformacoesEstagio info) {
		if (info == null) return false;
		
		return Validacao.saoParametrosValidos(
			info.getStatus(),
			info.getNomeEmpresa(),
			info.getCodigoDisciplina(),
			info.getDataInicio(),
			info.getDataFim(),
			info.getAtividadesEstagio(),
			info.isAtivo(),
			info.getEnderecoEmpresa(),
			info.getPathPDFTermo(),
			info.getNomeSupervisor(),
			info.getCargoSupervisor(),
			info.getEmailSupervisor(),
			info.getTelefoneSupervisor(),
			info.getCargaHorariaSemanal(),
			info.getEntradaSegunda(),
			info.getSaidaSegunda(),
			info.getEntradaTerca(),
			info.getSaidaTerca(),
			info.getEntradaQuarta(),
			info.getSaidaQuarta(),
			info.getEntradaQuinta(),
			info.getSaidaQuinta(),
			info.getEntradaSexta(),
			info.getSaidaSexta(),
			info.getEntradaSabado(),
			info.getSaidaSabado()
		);
		
	}
}