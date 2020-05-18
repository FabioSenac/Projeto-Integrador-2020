package com.senac.pi.model;

import java.util.Date;

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
@Table(name = "historico")

public class Historico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "his_id")
	private Long id;
	
	@NotNull
	@Column(name = "ose_id")
	private int ose_id;
	
	@NotNull
	@Column(name = "pes_id")
	private int pes_id;
	
	@NotNull
	@Column(name = "his_data")
	private Date his_data;
	
	@NotNull
	@Column(name = "his_status")
	private String his_status;

//	//Tabela Ordem Serviço
//	
//	@ManyToOne
//	@JoinColumn (name = "ose_id")
//	private OrdemServico ordemServico;
//	
//	public OrdemServico getOrdemServico() {
//		return ordemServico;
//	}
//	
//	//Tabela Pessoa
//	
//	@ManyToOne
//	@JoinColumn (name = "pes_id")
//	private Pessoa pessoa;
//	
//	public Pessoa getPessoa() {
//		return pessoa;
//	}
	
	// Getters e Setter
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getOse_id() {
		return ose_id;
	}

	public void setOse_id(int ose_id) {
		this.ose_id = ose_id;
	}

	public int getPes_id() {
		return pes_id;
	}

	public void setPes_id(int pes_id) {
		this.pes_id = pes_id;
	}

	public Date getHis_data() {
		return his_data;
	}

	public void setHis_data(Date his_data) {
		this.his_data = his_data;
	}

	public String getHis_status() {
		return his_status;
	}

	public void setHis_status(String his_status) {
		this.his_status = his_status;
	}

	public void setStatus(@Valid String status) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
