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

import com.senac.pi.model.OrdemServico;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/ordemServico")

public class OrdemServicoResource {

	@Autowired
	private com.senac.pi.repository.OrdemServicoRepository OrdemServicoRepository;
	
	@GetMapping
	public List<OrdemServico> list() {
		return OrdemServicoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<OrdemServico> findById(@PathVariable Long id) {
		return OrdemServicoRepository.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<OrdemServico> create(@Valid @RequestBody OrdemServico OrdemServico, HttpServletResponse response) {
		OrdemServico save = OrdemServicoRepository.save(OrdemServico);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(save.getId()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(save);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		OrdemServicoRepository.deleteById(id);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<OrdemServico> update(@PathVariable Long id, @Valid @RequestBody OrdemServico OrdemServico) {
		Optional<OrdemServico> ordemServicoBanco = OrdemServicoRepository.findById(id);
		BeanUtils.copyProperties(OrdemServico, ordemServicoBanco.get(), "id");
		OrdemServicoRepository.save(ordemServicoBanco.get());
		return ResponseEntity.ok(OrdemServico);
	}
	
	@PatchMapping("/{id}/status")
	public ResponseEntity<OrdemServico> updateStatus(@PathVariable Long id, 
			@Valid @RequestBody String status) {
		Optional<OrdemServico> ordemServicoBanco = OrdemServicoRepository.findById(id);
		ordemServicoBanco.get().setStatus(status);
		OrdemServicoRepository.save(ordemServicoBanco.get());
		return ResponseEntity.ok(ordemServicoBanco.get());
	}
	
}
