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

import com.yrllanio.controleveiculos.dto.VeiculoDTO;
import com.yrllanio.controleveiculos.services.VeiculoService;

@RestController
@RequestMapping(value = "/veiculos")
public class VeiculoController {

	@Autowired
	private VeiculoService veiculoService;

	@GetMapping
	public ResponseEntity<Page<VeiculoDTO>> buscaPaginada(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size) {

		PageRequest pageRequest = PageRequest.of(page, size);
		Page<VeiculoDTO> lista = veiculoService.buscaTodos(pageRequest);
		return ResponseEntity.ok().body(lista);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<VeiculoDTO> buscaPorId(@PathVariable Long id) {
		VeiculoDTO dto = veiculoService.buscaPorId(id);
		return ResponseEntity.ok(dto);
	}

	@PostMapping
	public ResponseEntity<VeiculoDTO> inserir(@Valid @RequestBody VeiculoDTO dto) {
		dto = veiculoService.inserir(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<VeiculoDTO> atualizar(@PathVariable Long id, @Valid @RequestBody VeiculoDTO dto) {
		dto = veiculoService.atualizar(id, dto);
		return ResponseEntity.ok(dto);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<VeiculoDTO> deletar(@PathVariable Long id) {
		veiculoService.deletar(id);
		return ResponseEntity.noContent().build();
	}
}
