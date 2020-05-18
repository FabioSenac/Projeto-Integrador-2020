package com.senac.pi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;

import com.sun.istack.NotNull;

@Entity
@Table(name = "tipo_servico")

public class TipoServico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tps_id")
	private Long id;
	
//	@NotNull
	@Column(name = "tps_descricao")
	private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setStatus(@Valid String status) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
