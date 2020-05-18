package com.senac.pi.resource;


import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.senac.pi.model.Pessoa;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/pessoa")

public class PessoaResource {

	@Autowired
	private com.senac.pi.repository.PessoaRepository PessoaRepository;
	
	@GetMapping
	public List<Pessoa> list() {
		return PessoaRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Pessoa> findById(@PathVariable Long id) {
		return PessoaRepository.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<Pessoa> create(@Valid @RequestBody Pessoa Pessoa, HttpServletResponse response) {
		Pessoa save = PessoaRepository.save(Pessoa);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(save.getId()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(save);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		PessoaRepository.deleteById(id);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Pessoa> update(@PathVariable Long id, @Valid @RequestBody Pessoa Pessoa) {
		Optional<Pessoa> pessoaBanco = PessoaRepository.findById(id);
		BeanUtils.copyProperties(Pessoa, pessoaBanco.get(), "id");
		PessoaRepository.save(pessoaBanco.get());
		return ResponseEntity.ok(Pessoa);
	}
	
	@PatchMapping("/{id}/status")
	public ResponseEntity<Pessoa> updateStatus(@PathVariable Long id, 
			@Valid @RequestBody String status) {
		Optional<Pessoa> pessoaBanco = PessoaRepository.findById(id);
		pessoaBanco.get().setStatus(status);
		PessoaRepository.save(pessoaBanco.get());
		return ResponseEntity.ok(pessoaBanco.get());
	}
	
}
