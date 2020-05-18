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

import com.senac.pi.model.TipoServico;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/tipoServico")

public class TipoServicoResource {

	@Autowired
	private com.senac.pi.repository.TipoServicoRepository TipoServicoRepository;
	
	@GetMapping
	public List<TipoServico> list() {
		return TipoServicoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<TipoServico> findById(@PathVariable Long id) {
		return TipoServicoRepository.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<TipoServico> create(@Valid @RequestBody TipoServico TipoServico, HttpServletResponse response) {
		TipoServico save = TipoServicoRepository.save(TipoServico);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(save.getId()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(save);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		TipoServicoRepository.deleteById(id);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TipoServico> update(@PathVariable Long id, @Valid @RequestBody TipoServico TipoServico) {
		Optional<TipoServico> tipoServicoBanco = TipoServicoRepository.findById(id);
		BeanUtils.copyProperties(TipoServico, tipoServicoBanco.get(), "id");
		TipoServicoRepository.save(tipoServicoBanco.get());
		return ResponseEntity.ok(TipoServico);
	}
	
	@PatchMapping("/{id}/status")
	public ResponseEntity<TipoServico> updateStatus(@PathVariable Long id, 
			@Valid @RequestBody String status) {
		Optional<TipoServico> tipoServicoBanco = TipoServicoRepository.findById(id);
		tipoServicoBanco.get().setStatus(status);
		TipoServicoRepository.save(tipoServicoBanco.get());
		return ResponseEntity.ok(tipoServicoBanco.get());
	}
	
}
