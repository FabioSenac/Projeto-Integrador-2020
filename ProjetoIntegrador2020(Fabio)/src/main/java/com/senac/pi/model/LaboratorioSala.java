package com.senac.pi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "laboratorio_sala")

public class LaboratorioSala {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lab_id")
	private Long id;
	
//	@NotNull
//	@Size(max = 40)
	@Column(name = "lab_nome")
	private String nome_lab;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome_lab() {
		return nome_lab;
	}

	public void setNome_lab(String nome_lab) {
		this.nome_lab = nome_lab;
	}

	public void setStatus(@Valid String status) {
		// TODO Auto-generated method stub
		
	}
			
}
