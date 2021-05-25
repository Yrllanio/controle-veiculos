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
	private Integer ano;

	private Integer diaDoRodizio;

	private Boolean statusRodizio;

	public VeiculoDTO() {
	}

	public VeiculoDTO(Long id, String marca, String modelo, Integer ano, Integer diaDoRodizio, Boolean statusRodizio) {
		this.id = id;
		this.marca = marca;
		this.modeloDoVeiculo = modelo;
		this.ano = ano;
		this.diaDoRodizio = diaDoRodizio;
		this.statusRodizio = statusRodizio;
	}

	public VeiculoDTO(Veiculo veiculo) {

		id = veiculo.getId();
		marca = veiculo.getMarca();
		modeloDoVeiculo = veiculo.getModeloDoVeiculo();
		ano = veiculo.getAno();
		diaDoRodizio = veiculo.getDiaDoRodizio();
		statusRodizio = veiculo.getStatusRodizio();
	}

	public Integer getDiaDoRodizio() {
		return diaDoRodizio;
	}

	public void setDiaDoRodizio(Integer diaDoRodizio) {
		this.diaDoRodizio = diaDoRodizio;
	}

	public Boolean getStatusRodizio() {
		return statusRodizio;
	}

	public void setStatusRodizio(Boolean statusRodizio) {
		this.statusRodizio = statusRodizio;
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

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

}
