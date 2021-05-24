package com.yrllanio.controleveiculos.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.yrllanio.controleveiculos.dto.UsuarioDTO;
import com.yrllanio.controleveiculos.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	// endpoint com a lista de veiculos cadastrados
	@GetMapping
	public ResponseEntity<Page<UsuarioDTO>> buscaPaginada(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size) {

		PageRequest pageRequest = PageRequest.of(page, size);
		Page<UsuarioDTO> lista = service.buscaTodos(pageRequest);
		return ResponseEntity.ok().body(lista);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<UsuarioDTO> buscaPorId(@PathVariable Long id) {
		UsuarioDTO dto = service.buscaPorId(id);
		return ResponseEntity.ok(dto);
	}

	@PostMapping
	public ResponseEntity<UsuarioDTO> inserir(@Valid @RequestBody UsuarioDTO dto) {
		dto = service.inserir(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<UsuarioDTO> atualizar(@PathVariable Long id,@Valid @RequestBody UsuarioDTO dto) {
		dto = service.atualizar(id, dto);
		return ResponseEntity.ok(dto);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<UsuarioDTO> deletar(@PathVariable Long id) {
		service.deletar(id);
		return ResponseEntity.noContent().build();
	}
}
