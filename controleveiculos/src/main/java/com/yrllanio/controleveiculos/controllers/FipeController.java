package com.yrllanio.controleveiculos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.yrllanio.controleveiculos.dto.FipeDTO;
import com.yrllanio.controleveiculos.repositories.FipeRepository;

@RestController
public class FipeController {

	@Autowired
    private FipeRepository fipeService;		

    
    @GetMapping("/{tipo}")
    public ResponseEntity<List<FipeDTO>> getTipo(@PathVariable("tipo") String tipo) {
    	List<FipeDTO> listaTipo = fipeService.buscarVeiculoFipe(tipo);
        return listaTipo != null ? ResponseEntity.ok().body(listaTipo) : ResponseEntity.notFound().build(); 
    } 
}
