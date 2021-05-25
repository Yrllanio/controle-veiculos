package com.yrllanio.controleveiculos.repositories;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.yrllanio.controleveiculos.dto.FipeDTO;

@FeignClient(url = "https://parallelum.com.br/fipe/api/v1", name = "controleveiculos")
public interface FipeRepository {

	@GetMapping("{tipo}/marcas")
	List<FipeDTO> buscarVeiculoFipe(@PathVariable("tipo") String tipo);
}
