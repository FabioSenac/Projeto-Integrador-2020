package com.senac.pi.model;

import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ordem_servico")

public class OrdemServico {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ose_id")
	private Long id;
	
	
//	@NotNull
	@Column(name = "tps_id")
	private String tps_id;
	
//	@NotNull
	@Column(name = "lab_id")
	private String lab_id;
	
//	@NotNull
	@Column(name = "pes_id_func")
	private String pes_id_func;
	
//	@NotNull
	@Column(name = "pes_id_cli")
	private String pes_id;
	
//	@NotNull
	@Column(name = "ose_data_emissao")
	private Date ose_data_emissao;
	
	
//	@NotNull
	@Column(name = "ose_data_fechamento")
	private Date ose_data_fechamento;
	
//	@NotNull
	@Column(name = "ose_status")
	private String ose_status;
	
//	@NotNull
	@Column(name = "ose_descricao")
	private String ose_descricao;
	
//	@NotNull
	@Column(name = "ose_local")
	private String ose_local;
	
	
	
	
	
//	//Tabela Tipo de Serviço
//	
//	@ManyToOne
//	@JoinColumn (name = "tps_id")
//	private TipoServico tiposervico;
//	
//	public TipoServico getTipoServico() {
//		return tiposervico;
//	}
//	
//	//Tabela Pessoa - Cliente
//	
//	@ManyToOne
//	@JoinColumn (name = "pes_id-cli")
//	private Pessoa cliente;
//	
//	public Pessoa getCliente() {
//		return cliente;
//	}
//	
//	//Tabela Pessoa - Funcionario
//	
//	@ManyToOne
//	@JoinColumn (name = "pes_id_func")
//	private Pessoa funcionario;
//	
//	public Pessoa getFuncionario() {
//		return funcionario;
//	}
//	
//	//Tabela Laboratorio
//	
//	@ManyToOne
//	@JoinColumn (name = "lab_id")
//	private LaboratorioSala laboratorioSala;
//	
//	public LaboratorioSala getLaboratorioSala() {
//		return laboratorioSala;
//	}

	public String getTps_id() {
		return tps_id;
	}

	public void setTps_id(String tps_id) {
		this.tps_id = tps_id;
	}

	public String getLab_id() {
		return lab_id;
	}

	public void setLab_id(String lab_id) {
		this.lab_id = lab_id;
	}

	public String getPes_id_func() {
		return pes_id_func;
	}

	public void setPes_id_func(String pes_id_func) {
		this.pes_id_func = pes_id_func;
	}

	public String getPes_id() {
		return pes_id;
	}

	public void setPes_id(String pes_id) {
		this.pes_id = pes_id;
	}

	public Date getOse_data_emissao() {
		return ose_data_emissao;
	}

	public void setOse_data_emissao(Date ose_data_emissao) {
		this.ose_data_emissao = ose_data_emissao;
	}

	public Date getOse_data_fechamento() {
		return ose_data_fechamento;
	}

	public void setOse_data_fechamento(Date ose_data_fechamento) {
		this.ose_data_fechamento = ose_data_fechamento;
	}

	public String getOse_status() {
		return ose_status;
	}

	public void setOse_status(String ose_status) {
		this.ose_status = ose_status;
	}

	public String getOse_descricao() {
		return ose_descricao;
	}

	public void setOse_descricao(String ose_descricao) {
		this.ose_descricao = ose_descricao;
	}

	public String getOse_local() {
		return ose_local;
	}

	public void setOse_local(String ose_local) {
		this.ose_local = ose_local;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setStatus(@Valid String status) {
		// TODO Auto-generated method stub
		
	}

	public Map<String, ?> getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
