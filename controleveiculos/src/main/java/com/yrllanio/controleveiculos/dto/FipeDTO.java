package com.yrllanio.controleveiculos.dto;


public class FipeDTO {

		private String nome;
		private String codigo;
		private String valor;
		private String marca;
		private String modelo;
		private String anoModelo;
		private String combustivel;
		private String codigoFipe;
		private String mesReferencia;
		private String tipoVeiculo;
		private String siglaCombustivel;


	public FipeDTO() {
	}


	public FipeDTO(String nome, String codigo, String valor, String marca, String modelo, String anoModelo,
			String combustivel, String codigoFipe, String mesReferencia, String tipoVeiculo, String siglaCombustivel) {
		super();
		this.nome = nome;
		this.codigo = codigo;
		this.valor = valor;
		this.marca = marca;
		this.modelo = modelo;
		this.anoModelo = anoModelo;
		this.combustivel = combustivel;
		this.codigoFipe = codigoFipe;
		this.mesReferencia = mesReferencia;
		this.tipoVeiculo = tipoVeiculo;
		this.siglaCombustivel = siglaCombustivel;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getValor() {
		return valor;
	}


	public void setValor(String valor) {
		this.valor = valor;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getAnoModelo() {
		return anoModelo;
	}


	public void setAnoModelo(String anoModelo) {
		this.anoModelo = anoModelo;
	}


	public String getCombustivel() {
		return combustivel;
	}


	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}


	public String getCodigoFipe() {
		return codigoFipe;
	}


	public void setCodigoFipe(String codigoFipe) {
		this.codigoFipe = codigoFipe;
	}


	public String getMesReferencia() {
		return mesReferencia;
	}


	public void setMesReferencia(String mesReferencia) {
		this.mesReferencia = mesReferencia;
	}


	public String getTipoVeiculo() {
		return tipoVeiculo;
	}


	public void setTipoVeiculo(String tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}


	public String getSiglaCombustivel() {
		return siglaCombustivel;
	}


	public void setSiglaCombustivel(String siglaCombustivel) {
		this.siglaCombustivel = siglaCombustivel;
	}




}