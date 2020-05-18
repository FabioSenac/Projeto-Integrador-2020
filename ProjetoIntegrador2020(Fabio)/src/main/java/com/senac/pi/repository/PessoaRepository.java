package com.senac.pi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senac.pi.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
