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

import com.senac.pi.model.LaboratorioSala;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/laboratorioSala")

public class LaboratorioSalaResource {

	@Autowired
	private com.senac.pi.repository.LaboratorioSalaRepository LaboratorioSalaRepository;
	
	@GetMapping
	public List<LaboratorioSala> list() {
		return LaboratorioSalaRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<LaboratorioSala> findById(@PathVariable Long id) {
		return LaboratorioSalaRepository.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<LaboratorioSala> create(@Valid @RequestBody LaboratorioSala LaboratorioSala, HttpServletResponse response) {
		LaboratorioSala save = LaboratorioSalaRepository.save(LaboratorioSala);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(save.getId()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(save);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		LaboratorioSalaRepository.deleteById(id);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<LaboratorioSala> update(@PathVariable Long id, @Valid @RequestBody LaboratorioSala LaboratorioSala) {
		Optional<LaboratorioSala> laboratorioSalaBanco = LaboratorioSalaRepository.findById(id);
		BeanUtils.copyProperties(LaboratorioSala, laboratorioSalaBanco.get(), "id");
		LaboratorioSalaRepository.save(laboratorioSalaBanco.get());
		return ResponseEntity.ok(LaboratorioSala);
	}
	
	@PatchMapping("/{id}/status")
	public ResponseEntity<LaboratorioSala> updateStatus(@PathVariable Long id, 
			@Valid @RequestBody String status) {
		Optional<LaboratorioSala> laboratorioSalaBanco = LaboratorioSalaRepository.findById(id);
		laboratorioSalaBanco.get().setStatus(status);
		LaboratorioSalaRepository.save(laboratorioSalaBanco.get());
		return ResponseEntity.ok(laboratorioSalaBanco.get());
	}
	
}
