package com.yrllanio.controleveiculos.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_veiculo")
public class Veiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String marca;

	@Column(nullable = false)
	private String modeloDoVeiculo;

	@Column(nullable = false)
	private Integer ano;

	@ManyToMany(mappedBy = "veiculos")
	private Set<Usuario> usuarios = new HashSet<>();

	private Integer diaDoRodizio;

	private Boolean statusRodizio;

	public Veiculo() {
	}

	public Veiculo(Long id, String marca, String modeloDoVeiculo, Integer ano, Integer diaDoRodizio,
			Boolean statusRodizio) {
		this.id = id;
		this.marca = marca;
		this.modeloDoVeiculo = modeloDoVeiculo;
		this.ano = ano;
		this.diaDoRodizio = diaDoRodizio;
		this.statusRodizio = statusRodizio;
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

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

}
