package com.yrllanio.controleveiculos.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.yrllanio.controleveiculos.entities.Veiculo;

public class VeiculoDTO {

	private Long id;
	
	@Size(min = 3, max = 20, message = "A Marca deve ter entre 3 a 20 caracteres")
	private String marca;
	
	@NotBlank(message = "Campo obrigatório")
	private String modeloDoVeiculo;
	
	@NotBlank(message = "Campo obrigatório")
	private String ano;
	

	public VeiculoDTO() {
	}

	public VeiculoDTO(Long id, String marca, String modelo, String ano) {
		this.id = id;
		this.marca = marca;
		this.modeloDoVeiculo = modelo;
		this.ano = ano;
	}

	public VeiculoDTO(Veiculo veiculo) {

		id = veiculo.getId();
		marca = veiculo.getMarca();
		modeloDoVeiculo = veiculo.getModeloDoVeiculo();
		ano = veiculo.getAno();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModeloDoVeiculo() {
		return modeloDoVeiculo;
	}

	public void setModeloDoVeiculo(String modeloDoVeiculo) {
		this.modeloDoVeiculo = modeloDoVeiculo;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

}
