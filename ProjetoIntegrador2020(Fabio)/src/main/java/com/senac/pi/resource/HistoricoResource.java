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

import com.senac.pi.model.Historico;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/historico")

public class HistoricoResource {

	@Autowired
	private com.senac.pi.repository.HistoricoRepository HistoricoRepository;
	
	@GetMapping
	public List<Historico> list() {
		return HistoricoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Historico> findById(@PathVariable Long id) {
		return HistoricoRepository.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<Historico> create(@Valid @RequestBody Historico Historico, HttpServletResponse response) {
		Historico save = HistoricoRepository.save(Historico);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(save.getId()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(save);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		HistoricoRepository.deleteById(id);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Historico> update(@PathVariable Long id, @Valid @RequestBody Historico Historico) {
		Optional<Historico> historicoBanco = HistoricoRepository.findById(id);
		BeanUtils.copyProperties(Historico, historicoBanco.get(), "id");
		HistoricoRepository.save(historicoBanco.get());
		return ResponseEntity.ok(Historico);
	}
	
	@PatchMapping("/{id}/status")
	public ResponseEntity<Historico> updateStatus(@PathVariable Long id, 
			@Valid @RequestBody String status) {
		Optional<Historico> historicoBanco = HistoricoRepository.findById(id);
		historicoBanco.get().setStatus(status);
		HistoricoRepository.save(historicoBanco.get());
		return ResponseEntity.ok(historicoBanco.get());
	}
	
}
